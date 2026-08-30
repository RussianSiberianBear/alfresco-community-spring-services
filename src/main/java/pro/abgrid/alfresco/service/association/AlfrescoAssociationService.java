package pro.abgrid.alfresco.service.association;

import pro.abgrid.alfresco.api.NodesApi;
import pro.abgrid.alfresco.dto.core.AssociationBody;
import pro.abgrid.alfresco.dto.core.AssociationEntry;
import pro.abgrid.alfresco.dto.core.NodeAssociation;
import pro.abgrid.alfresco.dto.core.NodeAssociationPaging;
import pro.abgrid.alfresco.model.PageSlice;
import pro.abgrid.alfresco.support.PagingExtractor;
import org.springframework.stereotype.Service;

/**
 * <p><strong>RU:</strong> Высокоуровневый Spring-сервис для сценариев «association» в Alfresco. Он служит прикладной границей над generated REST API: принимает более удобные параметры, скрывает технические детали HTTP/DTO там, где для них есть high-level модель, и оставляет доступ к серверному результату, когда это необходимо. Сервис предназначен для внедрения как обычный Spring bean в бизнес-сервисы приложения.</p>
 * <p><strong>EN:</strong> High-level Spring service for Alfresco association scenarios. It acts as an application boundary over the generated REST API: it accepts application-friendly parameters, hides HTTP/DTO plumbing where a high-level model exists, and still exposes server results when required. The service is intended to be injected as a regular Spring bean into application business services.</p>
 */
@Service
public class AlfrescoAssociationService {
    private final NodesApi api;
    private final PagingExtractor paging;

        /**
     * <p><strong>RU:</strong> создаёт сервис и получает его зависимости через Spring DI; обычно этот конструктор не вызывается прикладным кодом напрямую.</p>
     * <p><strong>EN:</strong> creates the service with dependencies supplied by Spring DI; application code normally does not call this constructor directly.</p>
     *
     * @param api RU: зависимость `api`, используемая сервисом для выполнения операций Alfresco. EN: `api` dependency used by the service to perform Alfresco operations.
     * @param paging RU: зависимость `paging`, используемая сервисом для выполнения операций Alfresco. EN: `paging` dependency used by the service to perform Alfresco operations.
     */

    public AlfrescoAssociationService(NodesApi api, PagingExtractor paging) {
        this.api = api;
        this.paging = paging;
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `create` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `create` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param sourceId RU: значение параметра `sourceId` для выполняемой операции. EN: value of `sourceId` used by the operation.
     * @param targetId RU: значение параметра `targetId` для выполняемой операции. EN: value of `targetId` used by the operation.
     * @param assocType RU: QName типа ассоциации Alfresco. EN: QName of the Alfresco association type.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public AssociationEntry create(String sourceId, String targetId, String assocType) {
        AssociationBody body = new AssociationBody();
        body.setTargetId(requireText(targetId, "targetId"));
        body.setAssocType(requireText(assocType, "assocType"));
        return api.createAssociation(requireText(sourceId, "sourceId"), null, body);
    }

        /**
     * <p><strong>RU:</strong> получает актуальное представление объекта из Alfresco; подходит для чтения его серверного состояния и метаданных.</p>
     * <p><strong>EN:</strong> retrieves the current Alfresco representation of the object for reading server-side state and metadata.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param assocType RU: QName типа ассоциации Alfresco. EN: QName of the Alfresco association type.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public NodeAssociationPaging targetsRaw(String nodeId, String assocType, int skip, int size) {
        return api.listTargetAssociations(requireText(nodeId, "nodeId"), where(assocType), null, skip, size, null);
    }

        /**
     * <p><strong>RU:</strong> получает актуальное представление объекта из Alfresco; подходит для чтения его серверного состояния и метаданных.</p>
     * <p><strong>EN:</strong> retrieves the current Alfresco representation of the object for reading server-side state and metadata.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public PageSlice<NodeAssociation> targets(String nodeId, int skip, int size) {
        return targets(nodeId, null, skip, size);
    }

        /**
     * <p><strong>RU:</strong> получает актуальное представление объекта из Alfresco; подходит для чтения его серверного состояния и метаданных.</p>
     * <p><strong>EN:</strong> retrieves the current Alfresco representation of the object for reading server-side state and metadata.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param assocType RU: QName типа ассоциации Alfresco. EN: QName of the Alfresco association type.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public PageSlice<NodeAssociation> targets(String nodeId, String assocType, int skip, int size) {
        return paging.extract(targetsRaw(nodeId, assocType, skip, size).getList(), NodeAssociation.class);
    }

        /**
     * <p><strong>RU:</strong> передаёт generated-запрос напрямую в REST-клиент; предназначен для сценариев, которым недостаточно high-level API.</p>
     * <p><strong>EN:</strong> passes the generated request directly to the REST client; intended for cases not covered by the high-level API.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param assocType RU: QName типа ассоциации Alfresco. EN: QName of the Alfresco association type.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public NodeAssociationPaging sourcesRaw(String nodeId, String assocType, int skip, int size) {
        return api.listSourceAssociations(requireText(nodeId, "nodeId"), where(assocType), null, skip, size, null);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `sources` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `sources` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public PageSlice<NodeAssociation> sources(String nodeId, int skip, int size) {
        return sources(nodeId, null, skip, size);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `sources` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `sources` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param assocType RU: QName типа ассоциации Alfresco. EN: QName of the Alfresco association type.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public PageSlice<NodeAssociation> sources(String nodeId, String assocType, int skip, int size) {
        return paging.extract(sourcesRaw(nodeId, assocType, skip, size).getList(), NodeAssociation.class);
    }

        /**
     * <p><strong>RU:</strong> удаляет соответствующий объект Alfresco; используйте метод, когда объект больше не должен быть доступен через репозиторий.</p>
     * <p><strong>EN:</strong> deletes the corresponding Alfresco object; use it when the object should no longer be available through the repository.</p>
     *
     * @param sourceId RU: значение параметра `sourceId` для выполняемой операции. EN: value of `sourceId` used by the operation.
     * @param targetId RU: значение параметра `targetId` для выполняемой операции. EN: value of `targetId` used by the operation.
     * @param assocType RU: QName типа ассоциации Alfresco. EN: QName of the Alfresco association type.
     */

    public void delete(String sourceId, String targetId, String assocType) {
        api.deleteAssociation(requireText(sourceId, "sourceId"), requireText(targetId, "targetId"), requireText(assocType, "assocType"));
    }

    private static String where(String assocType) {
        return assocType == null || assocType.isBlank() ? null : "(assocType='" + assocType.replace("'", "''") + "')";
    }

    private static String requireText(String value, String name) {
        if (value == null || value.isBlank()) throw new IllegalArgumentException(name + " must not be blank");
        return value;
    }
}
