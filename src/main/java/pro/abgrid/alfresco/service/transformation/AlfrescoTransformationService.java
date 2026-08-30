package pro.abgrid.alfresco.service.transformation;

import pro.abgrid.alfresco.api.RenditionsApi;
import pro.abgrid.alfresco.dto.core.RenditionBodyCreate;
import pro.abgrid.alfresco.dto.core.RenditionEntry;
import pro.abgrid.alfresco.exception.AlfrescoApiException;
import pro.abgrid.alfresco.model.TransformationResult;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Objects;

/**
 * <p><strong>RU:</strong> Высокоуровневый Spring-сервис для сценариев «transformation» в Alfresco. Он служит прикладной границей над generated REST API: принимает более удобные параметры, скрывает технические детали HTTP/DTO там, где для них есть high-level модель, и оставляет доступ к серверному результату, когда это необходимо. Сервис предназначен для внедрения как обычный Spring bean в бизнес-сервисы приложения.</p>
 * <p><strong>EN:</strong> High-level Spring service for Alfresco transformation scenarios. It acts as an application boundary over the generated REST API: it accepts application-friendly parameters, hides HTTP/DTO plumbing where a high-level model exists, and still exposes server results when required. The service is intended to be injected as a regular Spring bean into application business services.</p>
 */
@Service
public class AlfrescoTransformationService {
    /** RU: Целевой формат PDF для трансформации. EN: PDF target format for transformation. */
    public static final String PDF = "pdf";
    /** RU: Стандартный rendition {@code webpreview}. EN: Standard {@code webpreview} rendition. */
    public static final String WEB_PREVIEW = "webpreview";
    /** RU: Стандартный rendition {@code doclib} для миниатюры. EN: Standard {@code doclib} thumbnail rendition. */
    public static final String THUMBNAIL = "doclib";

    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(60);
    private static final Duration DEFAULT_POLL_INTERVAL = Duration.ofMillis(500);

    private final RenditionsApi renditions;

        /**
     * <p><strong>RU:</strong> создаёт сервис и получает его зависимости через Spring DI; обычно этот конструктор не вызывается прикладным кодом напрямую.</p>
     * <p><strong>EN:</strong> creates the service with dependencies supplied by Spring DI; application code normally does not call this constructor directly.</p>
     *
     * @param renditions RU: зависимость `renditions`, используемая сервисом для выполнения операций Alfresco. EN: `renditions` dependency used by the service to perform Alfresco operations.
     */

    public AlfrescoTransformationService(RenditionsApi renditions) {
        this.renditions = renditions;
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `transform` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `transform` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param renditionId RU: идентификатор rendition. EN: rendition identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public TransformationResult transform(String nodeId, String renditionId) {
        return transform(nodeId, renditionId, DEFAULT_TIMEOUT, DEFAULT_POLL_INTERVAL);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `transform` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `transform` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param renditionId RU: идентификатор rendition. EN: rendition identifier.
     * @param timeout RU: максимальное время ожидания завершения асинхронной операции. EN: maximum time to wait for an asynchronous operation.
     * @param pollInterval RU: интервал между проверками состояния асинхронной операции. EN: interval between asynchronous operation status checks.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public TransformationResult transform(
            String nodeId,
            String renditionId,
            Duration timeout,
            Duration pollInterval) {

        Objects.requireNonNull(nodeId, "nodeId must not be null");
        Objects.requireNonNull(renditionId, "renditionId must not be null");
        Objects.requireNonNull(timeout, "timeout must not be null");
        Objects.requireNonNull(pollInterval, "pollInterval must not be null");

        if (nodeId.isBlank()) {
            throw new IllegalArgumentException("nodeId must not be blank");
        }
        if (renditionId.isBlank()) {
            throw new IllegalArgumentException("renditionId must not be blank");
        }
        if (timeout.isNegative() || timeout.isZero()) {
            throw new IllegalArgumentException("timeout must be positive");
        }
        if (pollInterval.isNegative() || pollInterval.isZero()) {
            throw new IllegalArgumentException("pollInterval must be positive");
        }

        RenditionBodyCreate request = new RenditionBodyCreate();
        request.setId(renditionId);

        // ACS returns 202 because rendition creation is asynchronous.
        // 409 means that the requested rendition already exists; in that case
        // we can simply wait for/read the existing rendition.
        try {
            renditions.createRendition(nodeId, request);
        } catch (AlfrescoApiException ex) {
            if (ex.getStatus().value() != 409) {
                throw ex;
            }
        }

        long deadline = System.nanoTime() + timeout.toNanos();
        RenditionEntry rendition = null;

        while (System.nanoTime() < deadline) {
            try {
                rendition = renditions.getRendition(nodeId, renditionId);
                if (isCreated(rendition)) {
                    break;
                }
            } catch (AlfrescoApiException ex) {
                // Depending on ACS/transformer timing the rendition may not be
                // visible immediately. Treat 404 as "not ready yet".
                if (ex.getStatus().value() != 404) {
                    throw ex;
                }
            }
            sleep(pollInterval);
        }

        if (!isCreated(rendition)) {
            throw new IllegalStateException(
                    "Rendition '" + renditionId + "' for node '" + nodeId
                            + "' was not created within " + timeout);
        }

        byte[] content = renditions.getRenditionContent(
                nodeId, renditionId, true, null, null, false);

        String mimeType = rendition.getEntry().getContent() == null
                ? null
                : rendition.getEntry().getContent().getMimeType();

        return new TransformationResult(
                nodeId,
                renditionId,
                rendition.getEntry().getStatus(),
                content,
                mimeType);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `toPdf` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `toPdf` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public TransformationResult toPdf(String nodeId) {
        return transform(nodeId, PDF);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `preview` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `preview` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public TransformationResult preview(String nodeId) {
        return transform(nodeId, WEB_PREVIEW);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `thumbnail` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `thumbnail` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public TransformationResult thumbnail(String nodeId) {
        return transform(nodeId, THUMBNAIL);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `toPdfContent` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `toPdfContent` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @return RU: полученное бинарное содержимое. EN: retrieved binary content.
     */

    public byte[] toPdfContent(String nodeId) {
        return toPdf(nodeId).content();
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `previewContent` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `previewContent` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @return RU: полученное бинарное содержимое. EN: retrieved binary content.
     */

    public byte[] previewContent(String nodeId) {
        return preview(nodeId).content();
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `thumbnailContent` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `thumbnailContent` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @return RU: полученное бинарное содержимое. EN: retrieved binary content.
     */

    public byte[] thumbnailContent(String nodeId) {
        return thumbnail(nodeId).content();
    }

    private boolean isCreated(RenditionEntry rendition) {
        return rendition != null
                && rendition.getEntry() != null
                && "CREATED".equalsIgnoreCase(rendition.getEntry().getStatus());
    }

    private void sleep(Duration duration) {
        try {
            Thread.sleep(Math.max(1, duration.toMillis()));
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Interrupted while waiting for rendition", ex);
        }
    }
}
