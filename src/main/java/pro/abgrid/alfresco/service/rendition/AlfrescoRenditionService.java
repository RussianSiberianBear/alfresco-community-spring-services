package pro.abgrid.alfresco.service.rendition;

import pro.abgrid.alfresco.api.RenditionsApi;
import pro.abgrid.alfresco.dto.core.RenditionBodyCreate;
import pro.abgrid.alfresco.dto.core.RenditionEntry;
import pro.abgrid.alfresco.dto.core.RenditionPaging;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p><strong>RU:</strong> Высокоуровневый Spring-сервис для сценариев «rendition» в Alfresco. Он служит прикладной границей над generated REST API: принимает более удобные параметры, скрывает технические детали HTTP/DTO там, где для них есть high-level модель, и оставляет доступ к серверному результату, когда это необходимо. Сервис предназначен для внедрения как обычный Spring bean в бизнес-сервисы приложения.</p>
 * <p><strong>EN:</strong> High-level Spring service for Alfresco rendition scenarios. It acts as an application boundary over the generated REST API: it accepts application-friendly parameters, hides HTTP/DTO plumbing where a high-level model exists, and still exposes server results when required. The service is intended to be injected as a regular Spring bean into application business services.</p>
 */
@Service
public class AlfrescoRenditionService {
    private final RenditionsApi api;

        /**
     * <p><strong>RU:</strong> создаёт сервис и получает его зависимости через Spring DI; обычно этот конструктор не вызывается прикладным кодом напрямую.</p>
     * <p><strong>EN:</strong> creates the service with dependencies supplied by Spring DI; application code normally does not call this constructor directly.</p>
     *
     * @param api RU: зависимость `api`, используемая сервисом для выполнения операций Alfresco. EN: `api` dependency used by the service to perform Alfresco operations.
     */

    public AlfrescoRenditionService(RenditionsApi api) {
        this.api = api;
    }

        /**
     * <p><strong>RU:</strong> получает список объектов из Alfresco с учётом поддерживаемых сервером ограничений и пагинации.</p>
     * <p><strong>EN:</strong> retrieves a list of Alfresco objects using the server-supported filtering and paging options.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public RenditionPaging list(String nodeId) {
        return api.listRenditions(nodeId, null);
    }

        /**
     * <p><strong>RU:</strong> получает актуальное представление объекта из Alfresco; подходит для чтения его серверного состояния и метаданных.</p>
     * <p><strong>EN:</strong> retrieves the current Alfresco representation of the object for reading server-side state and metadata.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param renditionId RU: идентификатор rendition. EN: rendition identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public RenditionEntry get(String nodeId, String renditionId) {
        return api.getRendition(nodeId, renditionId);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `content` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `content` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param renditionId RU: идентификатор rendition. EN: rendition identifier.
     * @return RU: полученное бинарное содержимое. EN: retrieved binary content.
     */

    public byte[] content(String nodeId, String renditionId) {
        return api.getRenditionContent(nodeId, renditionId, true, null, null, false);
    }

        /**
     * <p><strong>RU:</strong> формирует generated request DTO из high-level параметров без выполнения HTTP-запроса; полезно для диагностики и расширенных сценариев.</p>
     * <p><strong>EN:</strong> builds the generated request DTO from high-level parameters without executing HTTP; useful for diagnostics and advanced scenarios.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param renditionId RU: идентификатор rendition. EN: rendition identifier.
     */

    public void request(String nodeId, String renditionId) {
        Objects.requireNonNull(nodeId, "nodeId must not be null");
        Objects.requireNonNull(renditionId, "renditionId must not be null");
        RenditionBodyCreate body = new RenditionBodyCreate();
        body.setId(renditionId);
        api.createRendition(nodeId, body);
    }

        /**
     * <p><strong>RU:</strong> удаляет соответствующий объект Alfresco; используйте метод, когда объект больше не должен быть доступен через репозиторий.</p>
     * <p><strong>EN:</strong> deletes the corresponding Alfresco object; use it when the object should no longer be available through the repository.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param renditionId RU: идентификатор rendition. EN: rendition identifier.
     */

    public void delete(String nodeId, String renditionId) {
        api.deleteRendition(nodeId, renditionId);
    }
}
