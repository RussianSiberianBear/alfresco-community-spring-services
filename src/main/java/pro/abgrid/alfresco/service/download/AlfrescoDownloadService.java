package pro.abgrid.alfresco.service.download;

import pro.abgrid.alfresco.api.DownloadsApi;
import pro.abgrid.alfresco.api.NodesApi;
import pro.abgrid.alfresco.dto.core.Download;
import pro.abgrid.alfresco.dto.core.DownloadBodyCreate;
import pro.abgrid.alfresco.dto.core.DownloadEntry;
import pro.abgrid.alfresco.model.ContentResource;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

/**
 * <p><strong>RU:</strong> Высокоуровневый Spring-сервис для сценариев «download» в Alfresco. Он служит прикладной границей над generated REST API: принимает более удобные параметры, скрывает технические детали HTTP/DTO там, где для них есть high-level модель, и оставляет доступ к серверному результату, когда это необходимо. Сервис предназначен для внедрения как обычный Spring bean в бизнес-сервисы приложения.</p>
 * <p><strong>EN:</strong> High-level Spring service for Alfresco download scenarios. It acts as an application boundary over the generated REST API: it accepts application-friendly parameters, hides HTTP/DTO plumbing where a high-level model exists, and still exposes server results when required. The service is intended to be injected as a regular Spring bean into application business services.</p>
 */
@Service
public class AlfrescoDownloadService {
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(60);
    private static final Duration DEFAULT_POLL_INTERVAL = Duration.ofMillis(500);

    private final DownloadsApi downloads;
    private final NodesApi nodes;

        /**
     * <p><strong>RU:</strong> создаёт сервис и получает его зависимости через Spring DI; обычно этот конструктор не вызывается прикладным кодом напрямую.</p>
     * <p><strong>EN:</strong> creates the service with dependencies supplied by Spring DI; application code normally does not call this constructor directly.</p>
     *
     * @param downloads RU: зависимость `downloads`, используемая сервисом для выполнения операций Alfresco. EN: `downloads` dependency used by the service to perform Alfresco operations.
     * @param nodes RU: зависимость `nodes`, используемая сервисом для выполнения операций Alfresco. EN: `nodes` dependency used by the service to perform Alfresco operations.
     */

    public AlfrescoDownloadService(DownloadsApi downloads, NodesApi nodes) {
        this.downloads = downloads;
        this.nodes = nodes;
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `create` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `create` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeIds RU: значение параметра `nodeIds` для выполняемой операции. EN: value of `nodeIds` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public DownloadEntry create(List<String> nodeIds) {
        if (nodeIds == null || nodeIds.isEmpty()) {
            throw new IllegalArgumentException("nodeIds must not be empty");
        }
        if (nodeIds.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("nodeIds must not contain null values");
        }
        if (nodeIds.stream().distinct().count() != nodeIds.size()) {
            throw new IllegalArgumentException("nodeIds must not contain duplicates");
        }
        DownloadBodyCreate body = new DownloadBodyCreate();
        body.setNodeIds(List.copyOf(nodeIds));
        return downloads.createDownload(null, body);
    }

        /**
     * <p><strong>RU:</strong> получает актуальное представление объекта из Alfresco; подходит для чтения его серверного состояния и метаданных.</p>
     * <p><strong>EN:</strong> retrieves the current Alfresco representation of the object for reading server-side state and metadata.</p>
     *
     * @param downloadId RU: идентификатор задания пакетной загрузки. EN: download job identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public DownloadEntry get(String downloadId) {
        return downloads.getDownload(downloadId, null);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `cancel` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `cancel` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param downloadId RU: идентификатор задания пакетной загрузки. EN: download job identifier.
     */

    public void cancel(String downloadId) {
        downloads.cancelDownload(downloadId);
    }

        /**
     * <p><strong>RU:</strong> ожидает перехода асинхронной операции Alfresco в конечное состояние и возвращает её актуальное состояние.</p>
     * <p><strong>EN:</strong> waits until the asynchronous Alfresco operation reaches a terminal state and returns its current state.</p>
     *
     * @param downloadId RU: идентификатор задания пакетной загрузки. EN: download job identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public DownloadEntry awaitDone(String downloadId) {
        return awaitDone(downloadId, DEFAULT_TIMEOUT, DEFAULT_POLL_INTERVAL);
    }

        /**
     * <p><strong>RU:</strong> ожидает перехода асинхронной операции Alfresco в конечное состояние и возвращает её актуальное состояние.</p>
     * <p><strong>EN:</strong> waits until the asynchronous Alfresco operation reaches a terminal state and returns its current state.</p>
     *
     * @param downloadId RU: идентификатор задания пакетной загрузки. EN: download job identifier.
     * @param timeout RU: максимальное время ожидания завершения асинхронной операции. EN: maximum time to wait for an asynchronous operation.
     * @param pollInterval RU: интервал между проверками состояния асинхронной операции. EN: interval between asynchronous operation status checks.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public DownloadEntry awaitDone(String downloadId, Duration timeout, Duration pollInterval) {
        Objects.requireNonNull(timeout, "timeout");
        Objects.requireNonNull(pollInterval, "pollInterval");
        long deadline = System.nanoTime() + timeout.toNanos();
        while (true) {
            DownloadEntry result = get(downloadId);
            Download entry = result == null ? null : result.getEntry();
            String status = entry == null ? null : entry.getStatus();
            if ("DONE".equalsIgnoreCase(status)) {
                return result;
            }
            if ("CANCELLED".equalsIgnoreCase(status) || "MAX_CONTENT_SIZE_EXCEEDED".equalsIgnoreCase(status)) {
                throw new IllegalStateException("Alfresco download " + downloadId + " finished with status " + status);
            }
            if (System.nanoTime() >= deadline) {
                throw new IllegalStateException("Timed out waiting for Alfresco download " + downloadId + "; last status=" + status);
            }
            sleep(pollInterval);
        }
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `content` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `content` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param downloadId RU: идентификатор задания пакетной загрузки. EN: download job identifier.
     * @return RU: полученное бинарное содержимое. EN: retrieved binary content.
     */

    public ContentResource content(String downloadId) {
        DownloadEntry status = get(downloadId);
        Download download = status == null ? null : status.getEntry();
        byte[] data = nodes.getNodeContent(downloadId, true, null, null);
        String filename = "download-" + downloadId + ".zip";
        return new ContentResource(data, filename, "application/zip");
    }

        /**
     * <p><strong>RU:</strong> создаёт серверное задание формирования архива и ожидает готовый результат, избавляя вызывающий код от ручного polling.</p>
     * <p><strong>EN:</strong> creates a server-side archive job and waits for the result, so callers do not have to implement polling.</p>
     *
     * @param nodeIds RU: значение параметра `nodeIds` для выполняемой операции. EN: value of `nodeIds` used by the operation.
     * @return RU: полученное бинарное содержимое. EN: retrieved binary content.
     */

    public ContentResource createAndDownload(List<String> nodeIds) {
        DownloadEntry created = create(nodeIds);
        String id = requireId(created);
        awaitDone(id);
        return content(id);
    }

        /**
     * <p><strong>RU:</strong> удаляет соответствующий объект Alfresco; используйте метод, когда объект больше не должен быть доступен через репозиторий.</p>
     * <p><strong>EN:</strong> deletes the corresponding Alfresco object; use it when the object should no longer be available through the repository.</p>
     *
     * @param downloadId RU: идентификатор задания пакетной загрузки. EN: download job identifier.
     */

    public void delete(String downloadId) {
        nodes.deleteNode(downloadId, true);
    }

    private static String requireId(DownloadEntry entry) {
        if (entry == null || entry.getEntry() == null || entry.getEntry().getId() == null) {
            throw new IllegalStateException("Alfresco did not return a download id");
        }
        return entry.getEntry().getId();
    }

    private static void sleep(Duration duration) {
        try {
            Thread.sleep(Math.max(1L, duration.toMillis()));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Interrupted while waiting for Alfresco download", e);
        }
    }
}
