package pro.abgrid.alfresco.service.tag;

import pro.abgrid.alfresco.api.TagsApi;
import pro.abgrid.alfresco.dto.core.TagBody;
import pro.abgrid.alfresco.dto.core.TagEntry;
import pro.abgrid.alfresco.dto.core.TagPaging;
import org.springframework.stereotype.Service;

/**
 * <p><strong>RU:</strong> Высокоуровневый Spring-сервис для сценариев «tag» в Alfresco. Он служит прикладной границей над generated REST API: принимает более удобные параметры, скрывает технические детали HTTP/DTO там, где для них есть high-level модель, и оставляет доступ к серверному результату, когда это необходимо. Сервис предназначен для внедрения как обычный Spring bean в бизнес-сервисы приложения.</p>
 * <p><strong>EN:</strong> High-level Spring service for Alfresco tag scenarios. It acts as an application boundary over the generated REST API: it accepts application-friendly parameters, hides HTTP/DTO plumbing where a high-level model exists, and still exposes server results when required. The service is intended to be injected as a regular Spring bean into application business services.</p>
 */
@Service
public class AlfrescoTagService {
    private final TagsApi api;

        /**
     * <p><strong>RU:</strong> создаёт сервис и получает его зависимости через Spring DI; обычно этот конструктор не вызывается прикладным кодом напрямую.</p>
     * <p><strong>EN:</strong> creates the service with dependencies supplied by Spring DI; application code normally does not call this constructor directly.</p>
     *
     * @param api RU: зависимость `api`, используемая сервисом для выполнения операций Alfresco. EN: `api` dependency used by the service to perform Alfresco operations.
     */

    public AlfrescoTagService(TagsApi api) {
        this.api = api;
    }

        /**
     * <p><strong>RU:</strong> получает список объектов из Alfresco с учётом поддерживаемых сервером ограничений и пагинации.</p>
     * <p><strong>EN:</strong> retrieves a list of Alfresco objects using the server-supported filtering and paging options.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public TagPaging list(String nodeId, int skip, int size) {
        return api.listTagsForNode(nodeId, skip, size, null);
    }

        /**
     * <p><strong>RU:</strong> добавляет связь, значение или дочерний объект к существующему объекту Alfresco.</p>
     * <p><strong>EN:</strong> adds a relation, value, or child object to an existing Alfresco object.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param tag RU: значение параметра `tag` для выполняемой операции. EN: value of `tag` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public TagEntry add(String nodeId, String tag) {
        TagBody body = body(tag);
        return api.createTagForNode(nodeId, null, body);
    }

        /**
     * <p><strong>RU:</strong> перемещает существующий узел в другую папку репозитория.</p>
     * <p><strong>EN:</strong> moves an existing node to another repository folder.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param tagId RU: идентификатор тега. EN: tag identifier.
     */

    public void remove(String nodeId, String tagId) {
        api.deleteTagFromNode(nodeId, tagId);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `all` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `all` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public TagPaging all(int skip, int size) {
        return api.listTags(skip, size, null, null, null, null);
    }

        /**
     * <p><strong>RU:</strong> получает актуальное представление объекта из Alfresco; подходит для чтения его серверного состояния и метаданных.</p>
     * <p><strong>EN:</strong> retrieves the current Alfresco representation of the object for reading server-side state and metadata.</p>
     *
     * @param tagId RU: идентификатор тега. EN: tag identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public TagEntry get(String tagId) {
        return api.getTag(tagId, null, null);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `create` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `create` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param tag RU: значение параметра `tag` для выполняемой операции. EN: value of `tag` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public TagEntry create(String tag) {
        return api.createTag(null, null, body(tag));
    }

        /**
     * <p><strong>RU:</strong> изменяет имя узла, не меняя его идентификатор.</p>
     * <p><strong>EN:</strong> changes a node name without changing its identifier.</p>
     *
     * @param tagId RU: идентификатор тега. EN: tag identifier.
     * @param tag RU: значение параметра `tag` для выполняемой операции. EN: value of `tag` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public TagEntry rename(String tagId, String tag) {
        return api.updateTag(tagId, null, null, body(tag));
    }

        /**
     * <p><strong>RU:</strong> удаляет соответствующий объект Alfresco; используйте метод, когда объект больше не должен быть доступен через репозиторий.</p>
     * <p><strong>EN:</strong> deletes the corresponding Alfresco object; use it when the object should no longer be available through the repository.</p>
     *
     * @param tagId RU: идентификатор тега. EN: tag identifier.
     */

    public void delete(String tagId) {
        api.deleteTag(tagId);
    }

    private TagBody body(String tag) {
        TagBody body = new TagBody();
        body.setTag(tag);
        return body;
    }
}
