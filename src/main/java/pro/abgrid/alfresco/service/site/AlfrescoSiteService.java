package pro.abgrid.alfresco.service.site;

import pro.abgrid.alfresco.api.SitesApi;
import pro.abgrid.alfresco.dto.core.*;
import org.springframework.stereotype.Service;

/**
 * <p><strong>RU:</strong> Высокоуровневый Spring-сервис для сценариев «site» в Alfresco. Он служит прикладной границей над generated REST API: принимает более удобные параметры, скрывает технические детали HTTP/DTO там, где для них есть high-level модель, и оставляет доступ к серверному результату, когда это необходимо. Сервис предназначен для внедрения как обычный Spring bean в бизнес-сервисы приложения.</p>
 * <p><strong>EN:</strong> High-level Spring service for Alfresco site scenarios. It acts as an application boundary over the generated REST API: it accepts application-friendly parameters, hides HTTP/DTO plumbing where a high-level model exists, and still exposes server results when required. The service is intended to be injected as a regular Spring bean into application business services.</p>
 */
@Service
public class AlfrescoSiteService {
    private final SitesApi api;
        /**
     * <p><strong>RU:</strong> создаёт сервис и получает его зависимости через Spring DI; обычно этот конструктор не вызывается прикладным кодом напрямую.</p>
     * <p><strong>EN:</strong> creates the service with dependencies supplied by Spring DI; application code normally does not call this constructor directly.</p>
     *
     * @param api RU: зависимость `api`, используемая сервисом для выполнения операций Alfresco. EN: `api` dependency used by the service to perform Alfresco operations.
     */

    public AlfrescoSiteService(SitesApi api) { this.api = api; }

        /**
     * <p><strong>RU:</strong> получает список объектов из Alfresco с учётом поддерживаемых сервером ограничений и пагинации.</p>
     * <p><strong>EN:</strong> retrieves a list of Alfresco objects using the server-supported filtering and paging options.</p>
     *
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public SitePaging list(int skip, int size) { return api.listSites(skip, size, null, null, null, null); }
        /**
     * <p><strong>RU:</strong> получает актуальное представление объекта из Alfresco; подходит для чтения его серверного состояния и метаданных.</p>
     * <p><strong>EN:</strong> retrieves the current Alfresco representation of the object for reading server-side state and metadata.</p>
     *
     * @param id RU: идентификатор объекта Alfresco. EN: Alfresco object identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public SiteEntry get(String id) { return api.getSite(id, null, null); }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `create` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `create` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param id RU: идентификатор объекта Alfresco. EN: Alfresco object identifier.
     * @param title RU: отображаемый заголовок. EN: display title.
     * @param visibility RU: значение параметра `visibility` для выполняемой операции. EN: value of `visibility` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public SiteEntry create(String id, String title, String visibility) {
        SiteBodyCreate body = new SiteBodyCreate();
        body.setId(id); body.setTitle(title); body.setVisibility(visibility);
        return create(body);
    }
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `create` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `create` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param body RU: тело запроса, соответствующее операции Alfresco REST API. EN: request body for the corresponding Alfresco REST API operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public SiteEntry create(SiteBodyCreate body) { return api.createSite(null, null, null, body); }
        /**
     * <p><strong>RU:</strong> изменяет существующий объект Alfresco и возвращает состояние, подтверждённое сервером.</p>
     * <p><strong>EN:</strong> updates an existing Alfresco object and returns the server-confirmed state.</p>
     *
     * @param id RU: идентификатор объекта Alfresco. EN: Alfresco object identifier.
     * @param body RU: тело запроса, соответствующее операции Alfresco REST API. EN: request body for the corresponding Alfresco REST API operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public SiteEntry update(String id, SiteBodyUpdate body) { return api.updateSite(id, null, body); }
        /**
     * <p><strong>RU:</strong> удаляет соответствующий объект Alfresco; используйте метод, когда объект больше не должен быть доступен через репозиторий.</p>
     * <p><strong>EN:</strong> deletes the corresponding Alfresco object; use it when the object should no longer be available through the repository.</p>
     *
     * @param id RU: идентификатор объекта Alfresco. EN: Alfresco object identifier.
     */

    public void delete(String id) { delete(id, true); }
        /**
     * <p><strong>RU:</strong> удаляет соответствующий объект Alfresco; используйте метод, когда объект больше не должен быть доступен через репозиторий.</p>
     * <p><strong>EN:</strong> deletes the corresponding Alfresco object; use it when the object should no longer be available through the repository.</p>
     *
     * @param id RU: идентификатор объекта Alfresco. EN: Alfresco object identifier.
     * @param permanent RU: значение параметра `permanent` для выполняемой операции. EN: value of `permanent` used by the operation.
     */

    public void delete(String id, boolean permanent) { api.deleteSite(id, permanent); }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `members` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `members` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param siteId RU: короткий идентификатор сайта Alfresco. EN: Alfresco site short identifier.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public SiteMemberPaging members(String siteId, int skip, int size) { return api.listSiteMemberships(siteId, skip, size, null, null); }
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `member` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `member` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param siteId RU: короткий идентификатор сайта Alfresco. EN: Alfresco site short identifier.
     * @param personId RU: идентификатор пользователя; для текущего пользователя обычно используется `-me-`. EN: person identifier; `-me-` is normally used for the current user.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public SiteMemberEntry member(String siteId, String personId) { return api.getSiteMembership(siteId, personId, null); }
        /**
     * <p><strong>RU:</strong> добавляет связь, значение или дочерний объект к существующему объекту Alfresco.</p>
     * <p><strong>EN:</strong> adds a relation, value, or child object to an existing Alfresco object.</p>
     *
     * @param siteId RU: короткий идентификатор сайта Alfresco. EN: Alfresco site short identifier.
     * @param personId RU: идентификатор пользователя; для текущего пользователя обычно используется `-me-`. EN: person identifier; `-me-` is normally used for the current user.
     * @param role RU: значение параметра `role` для выполняемой операции. EN: value of `role` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public SiteMemberEntry addMember(String siteId, String personId, String role) {
        SiteMembershipBodyCreate body = membership(personId, role);
        return api.createSiteMembership(siteId, null, body);
    }
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `changeRole` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `changeRole` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param siteId RU: короткий идентификатор сайта Alfresco. EN: Alfresco site short identifier.
     * @param personId RU: идентификатор пользователя; для текущего пользователя обычно используется `-me-`. EN: person identifier; `-me-` is normally used for the current user.
     * @param role RU: значение параметра `role` для выполняемой операции. EN: value of `role` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public SiteMemberEntry changeRole(String siteId, String personId, String role) {
        SiteMembershipBodyUpdate body = new SiteMembershipBodyUpdate(); body.setRole(role);
        return api.updateSiteMembership(siteId, personId, null, body);
    }
        /**
     * <p><strong>RU:</strong> перемещает существующий узел в другую папку репозитория.</p>
     * <p><strong>EN:</strong> moves an existing node to another repository folder.</p>
     *
     * @param siteId RU: короткий идентификатор сайта Alfresco. EN: Alfresco site short identifier.
     * @param personId RU: идентификатор пользователя; для текущего пользователя обычно используется `-me-`. EN: person identifier; `-me-` is normally used for the current user.
     */

    public void removeMember(String siteId, String personId) { api.deleteSiteMembership(siteId, personId); }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `groups` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `groups` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param siteId RU: короткий идентификатор сайта Alfresco. EN: Alfresco site short identifier.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public SiteGroupPaging groups(String siteId, int skip, int size) { return api.listSiteGroups(siteId, skip, size, null); }
        /**
     * <p><strong>RU:</strong> добавляет связь, значение или дочерний объект к существующему объекту Alfresco.</p>
     * <p><strong>EN:</strong> adds a relation, value, or child object to an existing Alfresco object.</p>
     *
     * @param siteId RU: короткий идентификатор сайта Alfresco. EN: Alfresco site short identifier.
     * @param groupId RU: идентификатор группы Alfresco. EN: Alfresco group identifier.
     * @param role RU: значение параметра `role` для выполняемой операции. EN: value of `role` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public SiteGroupEntry addGroup(String siteId, String groupId, String role) {
        return api.createSiteGroupMembership(siteId, null, membership(groupId, role));
    }
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `changeGroupRole` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `changeGroupRole` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param siteId RU: короткий идентификатор сайта Alfresco. EN: Alfresco site short identifier.
     * @param groupId RU: идентификатор группы Alfresco. EN: Alfresco group identifier.
     * @param role RU: значение параметра `role` для выполняемой операции. EN: value of `role` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public SiteGroupEntry changeGroupRole(String siteId, String groupId, String role) {
        SiteMembershipBodyUpdate body = new SiteMembershipBodyUpdate(); body.setRole(role);
        return api.updateSiteGroupMembership(siteId, groupId, null, body);
    }
        /**
     * <p><strong>RU:</strong> перемещает существующий узел в другую папку репозитория.</p>
     * <p><strong>EN:</strong> moves an existing node to another repository folder.</p>
     *
     * @param siteId RU: короткий идентификатор сайта Alfresco. EN: Alfresco site short identifier.
     * @param groupId RU: идентификатор группы Alfresco. EN: Alfresco group identifier.
     */

    public void removeGroup(String siteId, String groupId) { api.deleteSiteGroupMembership(siteId, groupId); }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `containers` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `containers` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param siteId RU: короткий идентификатор сайта Alfresco. EN: Alfresco site short identifier.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public SiteContainerPaging containers(String siteId, int skip, int size) { return api.listSiteContainers(siteId, skip, size, null); }
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `container` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `container` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param siteId RU: короткий идентификатор сайта Alfresco. EN: Alfresco site short identifier.
     * @param containerId RU: значение параметра `containerId` для выполняемой операции. EN: value of `containerId` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public SiteContainerEntry container(String siteId, String containerId) { return api.getSiteContainer(siteId, containerId, null); }

    private static SiteMembershipBodyCreate membership(String id, String role) {
        SiteMembershipBodyCreate body = new SiteMembershipBodyCreate(); body.setId(id); body.setRole(role); return body;
    }
}
