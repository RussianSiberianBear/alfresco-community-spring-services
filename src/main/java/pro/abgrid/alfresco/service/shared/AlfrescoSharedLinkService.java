package pro.abgrid.alfresco.service.shared;

import pro.abgrid.alfresco.api.SharedLinksApi;
import pro.abgrid.alfresco.dto.core.*;
import pro.abgrid.alfresco.model.PageSlice;
import pro.abgrid.alfresco.support.PagingExtractor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

/**
 * <p><strong>RU:</strong> Высокоуровневый Spring-сервис для сценариев «shared link» в Alfresco. Он служит прикладной границей над generated REST API: принимает более удобные параметры, скрывает технические детали HTTP/DTO там, где для них есть high-level модель, и оставляет доступ к серверному результату, когда это необходимо. Сервис предназначен для внедрения как обычный Spring bean в бизнес-сервисы приложения.</p>
 * <p><strong>EN:</strong> High-level Spring service for Alfresco shared link scenarios. It acts as an application boundary over the generated REST API: it accepts application-friendly parameters, hides HTTP/DTO plumbing where a high-level model exists, and still exposes server results when required. The service is intended to be injected as a regular Spring bean into application business services.</p>
 */
@Service
public class AlfrescoSharedLinkService {
    private final SharedLinksApi api;
    private final PagingExtractor paging;

        /**
     * <p><strong>RU:</strong> создаёт сервис и получает его зависимости через Spring DI; обычно этот конструктор не вызывается прикладным кодом напрямую.</p>
     * <p><strong>EN:</strong> creates the service with dependencies supplied by Spring DI; application code normally does not call this constructor directly.</p>
     *
     * @param api RU: зависимость `api`, используемая сервисом для выполнения операций Alfresco. EN: `api` dependency used by the service to perform Alfresco operations.
     * @param paging RU: зависимость `paging`, используемая сервисом для выполнения операций Alfresco. EN: `paging` dependency used by the service to perform Alfresco operations.
     */

    public AlfrescoSharedLinkService(SharedLinksApi api, PagingExtractor paging) {
        this.api = api;
        this.paging = paging;
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `create` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `create` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public SharedLinkEntry create(String nodeId) {
        return create(nodeId, null);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `create` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `create` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param expiresAt RU: значение параметра `expiresAt` для выполняемой операции. EN: value of `expiresAt` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public SharedLinkEntry create(String nodeId, OffsetDateTime expiresAt) {
        SharedLinkBodyCreate body = new SharedLinkBodyCreate();
        body.setNodeId(nodeId);
        body.setExpiresAt(expiresAt);
        return api.createSharedLink(null, null, body);
    }

        /**
     * <p><strong>RU:</strong> получает актуальное представление объекта из Alfresco; подходит для чтения его серверного состояния и метаданных.</p>
     * <p><strong>EN:</strong> retrieves the current Alfresco representation of the object for reading server-side state and metadata.</p>
     *
     * @param sharedId RU: идентификатор публичной ссылки. EN: shared-link identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public SharedLinkEntry get(String sharedId) {
        return api.getSharedLink(sharedId, null);
    }

        /**
     * <p><strong>RU:</strong> получает список объектов из Alfresco с учётом поддерживаемых сервером ограничений и пагинации.</p>
     * <p><strong>EN:</strong> retrieves a list of Alfresco objects using the server-supported filtering and paging options.</p>
     *
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public SharedLinkPaging list(int skip, int size) {
        return api.listSharedLinks(skip, size, null, null, null);
    }

        /**
     * <p><strong>RU:</strong> получает список объектов из Alfresco с учётом поддерживаемых сервером ограничений и пагинации.</p>
     * <p><strong>EN:</strong> retrieves a list of Alfresco objects using the server-supported filtering and paging options.</p>
     *
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public SharedLinkPaging listMine(int skip, int size) {
        return api.listSharedLinks(skip, size, "(sharedByUser='-me-')", null, null);
    }

        /**
     * <p><strong>RU:</strong> возвращает типизированную страницу результатов и скрывает от прикладного кода generated paging-wrapper Alfresco.</p>
     * <p><strong>EN:</strong> returns a typed result page and hides the generated Alfresco paging wrapper from application code.</p>
     *
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public PageSlice<SharedLink> page(int skip, int size) {
        return paging.extract(list(skip, size).getList(), SharedLink.class);
    }

        /**
     * <p><strong>RU:</strong> возвращает типизированную страницу результатов и скрывает от прикладного кода generated paging-wrapper Alfresco.</p>
     * <p><strong>EN:</strong> returns a typed result page and hides the generated Alfresco paging wrapper from application code.</p>
     *
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public PageSlice<SharedLink> myPage(int skip, int size) {
        return paging.extract(listMine(skip, size).getList(), SharedLink.class);
    }



        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `content` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `content` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param sharedId RU: идентификатор публичной ссылки. EN: shared-link identifier.
     * @return RU: полученное бинарное содержимое. EN: retrieved binary content.
     */

    public byte[] content(String sharedId) {
        return api.getSharedLinkContent(sharedId, true, null, null);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `renditions` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `renditions` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param sharedId RU: идентификатор публичной ссылки. EN: shared-link identifier.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public RenditionPaging renditions(String sharedId) {
        return api.listSharedLinkRenditions(sharedId);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `rendition` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `rendition` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param sharedId RU: идентификатор публичной ссылки. EN: shared-link identifier.
     * @param renditionId RU: идентификатор rendition. EN: rendition identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public RenditionEntry rendition(String sharedId, String renditionId) {
        return api.getSharedLinkRendition(sharedId, renditionId);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `renditionContent` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `renditionContent` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param sharedId RU: идентификатор публичной ссылки. EN: shared-link identifier.
     * @param renditionId RU: идентификатор rendition. EN: rendition identifier.
     * @return RU: полученное бинарное содержимое. EN: retrieved binary content.
     */

    public byte[] renditionContent(String sharedId, String renditionId) {
        return api.getSharedLinkRenditionContent(sharedId, renditionId, true, null, null);
    }

        /**
     * <p><strong>RU:</strong> удаляет соответствующий объект Alfresco; используйте метод, когда объект больше не должен быть доступен через репозиторий.</p>
     * <p><strong>EN:</strong> deletes the corresponding Alfresco object; use it when the object should no longer be available through the repository.</p>
     *
     * @param sharedId RU: идентификатор публичной ссылки. EN: shared-link identifier.
     */

    public void delete(String sharedId) {
        api.deleteSharedLink(sharedId);
    }

}
