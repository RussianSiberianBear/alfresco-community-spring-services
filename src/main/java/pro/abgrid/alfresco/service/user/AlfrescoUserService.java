package pro.abgrid.alfresco.service.user;

import pro.abgrid.alfresco.api.GroupsApi;
import pro.abgrid.alfresco.api.PeopleApi;
import pro.abgrid.alfresco.api.SitesApi;
import pro.abgrid.alfresco.dto.core.*;
import org.springframework.stereotype.Service;

/**
 * <p><strong>RU:</strong> Высокоуровневый Spring-сервис для сценариев «user» в Alfresco. Он служит прикладной границей над generated REST API: принимает более удобные параметры, скрывает технические детали HTTP/DTO там, где для них есть high-level модель, и оставляет доступ к серверному результату, когда это необходимо. Сервис предназначен для внедрения как обычный Spring bean в бизнес-сервисы приложения.</p>
 * <p><strong>EN:</strong> High-level Spring service for Alfresco user scenarios. It acts as an application boundary over the generated REST API: it accepts application-friendly parameters, hides HTTP/DTO plumbing where a high-level model exists, and still exposes server results when required. The service is intended to be injected as a regular Spring bean into application business services.</p>
 */
@Service
public class AlfrescoUserService {
    private final PeopleApi people;
    private final GroupsApi groups;
    private final SitesApi sites;

        /**
     * <p><strong>RU:</strong> создаёт сервис и получает его зависимости через Spring DI; обычно этот конструктор не вызывается прикладным кодом напрямую.</p>
     * <p><strong>EN:</strong> creates the service with dependencies supplied by Spring DI; application code normally does not call this constructor directly.</p>
     *
     * @param people RU: зависимость `people`, используемая сервисом для выполнения операций Alfresco. EN: `people` dependency used by the service to perform Alfresco operations.
     * @param groups RU: зависимость `groups`, используемая сервисом для выполнения операций Alfresco. EN: `groups` dependency used by the service to perform Alfresco operations.
     * @param sites RU: зависимость `sites`, используемая сервисом для выполнения операций Alfresco. EN: `sites` dependency used by the service to perform Alfresco operations.
     */

    public AlfrescoUserService(PeopleApi people, GroupsApi groups, SitesApi sites) {
        this.people = people;
        this.groups = groups;
        this.sites = sites;
    }

        /**
     * <p><strong>RU:</strong> получает актуальное представление объекта из Alfresco; подходит для чтения его серверного состояния и метаданных.</p>
     * <p><strong>EN:</strong> retrieves the current Alfresco representation of the object for reading server-side state and metadata.</p>
     *
     * @param id RU: идентификатор объекта Alfresco. EN: Alfresco object identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public PersonEntry get(String id) { return people.getPerson(id, null); }
        /**
     * <p><strong>RU:</strong> получает список объектов из Alfresco с учётом поддерживаемых сервером ограничений и пагинации.</p>
     * <p><strong>EN:</strong> retrieves a list of Alfresco objects using the server-supported filtering and paging options.</p>
     *
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public PersonPaging list(int skip, int size) { return people.listPeople(skip, size, null, null, null); }
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `create` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `create` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param body RU: тело запроса, соответствующее операции Alfresco REST API. EN: request body for the corresponding Alfresco REST API operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public PersonEntry create(PersonBodyCreate body) { return people.createPerson(null, body); }
        /**
     * <p><strong>RU:</strong> изменяет существующий объект Alfresco и возвращает состояние, подтверждённое сервером.</p>
     * <p><strong>EN:</strong> updates an existing Alfresco object and returns the server-confirmed state.</p>
     *
     * @param id RU: идентификатор объекта Alfresco. EN: Alfresco object identifier.
     * @param body RU: тело запроса, соответствующее операции Alfresco REST API. EN: request body for the corresponding Alfresco REST API operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public PersonEntry update(String id, PersonBodyUpdate body) { return people.updatePerson(id, null, body); }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `groups` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `groups` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param personId RU: идентификатор пользователя; для текущего пользователя обычно используется `-me-`. EN: person identifier; `-me-` is normally used for the current user.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public GroupPaging groups(String personId, int skip, int size) {
        return groups.listGroupMembershipsForPerson(personId, skip, size, null, null, null, null);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `sites` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `sites` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param personId RU: идентификатор пользователя; для текущего пользователя обычно используется `-me-`. EN: person identifier; `-me-` is normally used for the current user.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public SiteRolePaging sites(String personId, int skip, int size) {
        return sites.listSiteMembershipsForPerson(personId, skip, size, null, null, null, null);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `avatar` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `avatar` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param id RU: идентификатор объекта Alfresco. EN: Alfresco object identifier.
     * @return RU: полученное бинарное содержимое. EN: retrieved binary content.
     */

    public byte[] avatar(String id) { return people.getAvatarImage(id, true, null, false); }
        /**
     * <p><strong>RU:</strong> изменяет существующий объект Alfresco и возвращает состояние, подтверждённое сервером.</p>
     * <p><strong>EN:</strong> updates an existing Alfresco object and returns the server-confirmed state.</p>
     *
     * @param id RU: идентификатор объекта Alfresco. EN: Alfresco object identifier.
     * @param data RU: значение параметра `data` для выполняемой операции. EN: value of `data` used by the operation.
     */

    public void updateAvatar(String id, byte[] data) { people.updateAvatarImage(id, data); }
        /**
     * <p><strong>RU:</strong> удаляет соответствующий объект Alfresco; используйте метод, когда объект больше не должен быть доступен через репозиторий.</p>
     * <p><strong>EN:</strong> deletes the corresponding Alfresco object; use it when the object should no longer be available through the repository.</p>
     *
     * @param id RU: идентификатор объекта Alfresco. EN: Alfresco object identifier.
     */

    public void deleteAvatar(String id) { people.deleteAvatarImage(id); }
}
