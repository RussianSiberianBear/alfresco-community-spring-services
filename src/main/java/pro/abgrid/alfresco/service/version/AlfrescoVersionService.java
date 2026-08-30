package pro.abgrid.alfresco.service.version;

import pro.abgrid.alfresco.api.NodesApi;
import pro.abgrid.alfresco.api.VersionsApi;
import pro.abgrid.alfresco.dto.core.NodeEntry;
import pro.abgrid.alfresco.dto.core.RevertBody;
import pro.abgrid.alfresco.dto.core.VersionEntry;
import pro.abgrid.alfresco.dto.core.VersionPaging;
import pro.abgrid.alfresco.model.VersionRequest;
import org.springframework.stereotype.Service;

/**
 * <p><strong>RU:</strong> Высокоуровневый Spring-сервис для сценариев «version» в Alfresco. Он служит прикладной границей над generated REST API: принимает более удобные параметры, скрывает технические детали HTTP/DTO там, где для них есть high-level модель, и оставляет доступ к серверному результату, когда это необходимо. Сервис предназначен для внедрения как обычный Spring bean в бизнес-сервисы приложения.</p>
 * <p><strong>EN:</strong> High-level Spring service for Alfresco version scenarios. It acts as an application boundary over the generated REST API: it accepts application-friendly parameters, hides HTTP/DTO plumbing where a high-level model exists, and still exposes server results when required. The service is intended to be injected as a regular Spring bean into application business services.</p>
 */
@Service
public class AlfrescoVersionService {
    private final VersionsApi versions;
    private final NodesApi nodes;

        /**
     * <p><strong>RU:</strong> создаёт сервис и получает его зависимости через Spring DI; обычно этот конструктор не вызывается прикладным кодом напрямую.</p>
     * <p><strong>EN:</strong> creates the service with dependencies supplied by Spring DI; application code normally does not call this constructor directly.</p>
     *
     * @param versions RU: зависимость `versions`, используемая сервисом для выполнения операций Alfresco. EN: `versions` dependency used by the service to perform Alfresco operations.
     * @param nodes RU: зависимость `nodes`, используемая сервисом для выполнения операций Alfresco. EN: `nodes` dependency used by the service to perform Alfresco operations.
     */

    public AlfrescoVersionService(VersionsApi versions, NodesApi nodes) {
        this.versions = versions;
        this.nodes = nodes;
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `history` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `history` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public VersionPaging history(String nodeId, int skip, int size) {
        return versions.listVersionHistory(nodeId, null, null, skip, size);
    }

        /**
     * <p><strong>RU:</strong> получает актуальное представление объекта из Alfresco; подходит для чтения его серверного состояния и метаданных.</p>
     * <p><strong>EN:</strong> retrieves the current Alfresco representation of the object for reading server-side state and metadata.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param versionId RU: идентификатор версии узла. EN: node version identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public VersionEntry get(String nodeId, String versionId) {
        return versions.getVersion(nodeId, versionId);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `content` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `content` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param versionId RU: идентификатор версии узла. EN: node version identifier.
     * @return RU: полученное бинарное содержимое. EN: retrieved binary content.
     */

    public byte[] content(String nodeId, String versionId) {
        return versions.getVersionContent(nodeId, versionId, true, null, null);
    }

        /**
     * <p><strong>RU:</strong> изменяет существующий объект Alfresco и возвращает состояние, подтверждённое сервером.</p>
     * <p><strong>EN:</strong> updates an existing Alfresco object and returns the server-confirmed state.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param content RU: содержимое документа. EN: document content.
     * @param request RU: high-level параметры операции. EN: high-level operation parameters.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public NodeEntry updateContent(String nodeId, byte[] content, VersionRequest request) {
        VersionRequest effective = request == null ? VersionRequest.minor(null) : request;
        return nodes.updateNodeContent(
                nodeId,
                effective.major(),
                effective.comment(),
                null,
                null,
                null,
                content
        );
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `createVersion` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `createVersion` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param request RU: high-level параметры операции. EN: high-level operation parameters.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public NodeEntry createVersion(String nodeId, VersionRequest request) {
        byte[] currentContent = nodes.getNodeContent(nodeId, true, null, null);
        return updateContent(nodeId, currentContent, request);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `revert` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `revert` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param versionId RU: идентификатор версии узла. EN: node version identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public VersionEntry revert(String nodeId, String versionId) {
        return revert(nodeId, versionId, VersionRequest.minor(null));
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `revert` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `revert` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param versionId RU: идентификатор версии узла. EN: node version identifier.
     * @param request RU: high-level параметры операции. EN: high-level operation parameters.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public VersionEntry revert(String nodeId, String versionId, VersionRequest request) {
        VersionRequest effective = request == null ? VersionRequest.minor(null) : request;
        RevertBody body = new RevertBody();
        body.setMajorVersion(effective.major());
        body.setComment(effective.comment());
        return versions.revertVersion(nodeId, versionId, null, body);
    }

        /**
     * <p><strong>RU:</strong> удаляет соответствующий объект Alfresco; используйте метод, когда объект больше не должен быть доступен через репозиторий.</p>
     * <p><strong>EN:</strong> deletes the corresponding Alfresco object; use it when the object should no longer be available through the repository.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param versionId RU: идентификатор версии узла. EN: node version identifier.
     */

    public void delete(String nodeId, String versionId) {
        versions.deleteVersion(nodeId, versionId);
    }
}
