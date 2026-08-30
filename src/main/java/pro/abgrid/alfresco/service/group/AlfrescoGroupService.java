package pro.abgrid.alfresco.service.group;

import pro.abgrid.alfresco.api.GroupsApi;
import pro.abgrid.alfresco.dto.core.*;
import org.springframework.stereotype.Service;

/**
 * <p><strong>RU:</strong> Высокоуровневый Spring-сервис для сценариев «group» в Alfresco. Он служит прикладной границей над generated REST API: принимает более удобные параметры, скрывает технические детали HTTP/DTO там, где для них есть high-level модель, и оставляет доступ к серверному результату, когда это необходимо. Сервис предназначен для внедрения как обычный Spring bean в бизнес-сервисы приложения.</p>
 * <p><strong>EN:</strong> High-level Spring service for Alfresco group scenarios. It acts as an application boundary over the generated REST API: it accepts application-friendly parameters, hides HTTP/DTO plumbing where a high-level model exists, and still exposes server results when required. The service is intended to be injected as a regular Spring bean into application business services.</p>
 */
@Service
public class AlfrescoGroupService {
    private final GroupsApi api;
        /**
     * <p><strong>RU:</strong> создаёт сервис и получает его зависимости через Spring DI; обычно этот конструктор не вызывается прикладным кодом напрямую.</p>
     * <p><strong>EN:</strong> creates the service with dependencies supplied by Spring DI; application code normally does not call this constructor directly.</p>
     *
     * @param api RU: зависимость `api`, используемая сервисом для выполнения операций Alfresco. EN: `api` dependency used by the service to perform Alfresco operations.
     */

    public AlfrescoGroupService(GroupsApi api) { this.api = api; }

        /**
     * <p><strong>RU:</strong> получает список объектов из Alfresco с учётом поддерживаемых сервером ограничений и пагинации.</p>
     * <p><strong>EN:</strong> retrieves a list of Alfresco objects using the server-supported filtering and paging options.</p>
     *
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public GroupPaging list(int skip, int size) { return api.listGroups(skip, size, null, null, null, null); }
        /**
     * <p><strong>RU:</strong> получает актуальное представление объекта из Alfresco; подходит для чтения его серверного состояния и метаданных.</p>
     * <p><strong>EN:</strong> retrieves the current Alfresco representation of the object for reading server-side state and metadata.</p>
     *
     * @param id RU: идентификатор объекта Alfresco. EN: Alfresco object identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public GroupEntry get(String id) { return api.getGroup(normalize(id), null, null); }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `create` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `create` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param id RU: идентификатор объекта Alfresco. EN: Alfresco object identifier.
     * @param displayName RU: значение параметра `displayName` для выполняемой операции. EN: value of `displayName` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public GroupEntry create(String id, String displayName) { return create(id, displayName, null); }
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `create` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `create` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param id RU: идентификатор объекта Alfresco. EN: Alfresco object identifier.
     * @param displayName RU: значение параметра `displayName` для выполняемой операции. EN: value of `displayName` used by the operation.
     * @param description RU: описание объекта. EN: object description.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public GroupEntry create(String id, String displayName, String description) {
        GroupBodyCreate body = new GroupBodyCreate();
        body.setId(normalize(id));
        body.setDisplayName(displayName);
        body.setDescription(description);
        return api.createGroup(null, null, body);
    }
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `create` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `create` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param body RU: тело запроса, соответствующее операции Alfresco REST API. EN: request body for the corresponding Alfresco REST API operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public GroupEntry create(GroupBodyCreate body) { return api.createGroup(null, null, body); }
        /**
     * <p><strong>RU:</strong> изменяет существующий объект Alfresco и возвращает состояние, подтверждённое сервером.</p>
     * <p><strong>EN:</strong> updates an existing Alfresco object and returns the server-confirmed state.</p>
     *
     * @param id RU: идентификатор объекта Alfresco. EN: Alfresco object identifier.
     * @param body RU: тело запроса, соответствующее операции Alfresco REST API. EN: request body for the corresponding Alfresco REST API operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public GroupEntry update(String id, GroupBodyUpdate body) { return api.updateGroup(normalize(id), null, null, body); }
        /**
     * <p><strong>RU:</strong> удаляет соответствующий объект Alfresco; используйте метод, когда объект больше не должен быть доступен через репозиторий.</p>
     * <p><strong>EN:</strong> deletes the corresponding Alfresco object; use it when the object should no longer be available through the repository.</p>
     *
     * @param id RU: идентификатор объекта Alfresco. EN: Alfresco object identifier.
     */

    public void delete(String id) { delete(id, false); }
        /**
     * <p><strong>RU:</strong> удаляет соответствующий объект Alfresco; используйте метод, когда объект больше не должен быть доступен через репозиторий.</p>
     * <p><strong>EN:</strong> deletes the corresponding Alfresco object; use it when the object should no longer be available through the repository.</p>
     *
     * @param id RU: идентификатор объекта Alfresco. EN: Alfresco object identifier.
     * @param cascade RU: значение параметра `cascade` для выполняемой операции. EN: value of `cascade` used by the operation.
     */

    public void delete(String id, boolean cascade) { api.deleteGroup(normalize(id), cascade); }

        /**
     * <p><strong>RU:</strong> добавляет связь, значение или дочерний объект к существующему объекту Alfresco.</p>
     * <p><strong>EN:</strong> adds a relation, value, or child object to an existing Alfresco object.</p>
     *
     * @param groupId RU: идентификатор группы Alfresco. EN: Alfresco group identifier.
     * @param personId RU: идентификатор пользователя; для текущего пользователя обычно используется `-me-`. EN: person identifier; `-me-` is normally used for the current user.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public GroupMemberEntry addPerson(String groupId, String personId) { return addMember(groupId, personId, "PERSON"); }
        /**
     * <p><strong>RU:</strong> добавляет связь, значение или дочерний объект к существующему объекту Alfresco.</p>
     * <p><strong>EN:</strong> adds a relation, value, or child object to an existing Alfresco object.</p>
     *
     * @param parentGroupId RU: значение параметра `parentGroupId` для выполняемой операции. EN: value of `parentGroupId` used by the operation.
     * @param childGroupId RU: значение параметра `childGroupId` для выполняемой операции. EN: value of `childGroupId` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public GroupMemberEntry addGroup(String parentGroupId, String childGroupId) { return addMember(parentGroupId, normalize(childGroupId), "GROUP"); }
        /**
     * <p><strong>RU:</strong> добавляет связь, значение или дочерний объект к существующему объекту Alfresco.</p>
     * <p><strong>EN:</strong> adds a relation, value, or child object to an existing Alfresco object.</p>
     *
     * @param groupId RU: идентификатор группы Alfresco. EN: Alfresco group identifier.
     * @param memberId RU: значение параметра `memberId` для выполняемой операции. EN: value of `memberId` used by the operation.
     * @param memberType RU: значение параметра `memberType` для выполняемой операции. EN: value of `memberType` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public GroupMemberEntry addMember(String groupId, String memberId, String memberType) {
        GroupMembershipBodyCreate body = new GroupMembershipBodyCreate();
        body.setId(memberId);
        body.setMemberType(memberType);
        return api.createGroupMembership(normalize(groupId), null, body);
    }
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `members` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `members` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param groupId RU: идентификатор группы Alfresco. EN: Alfresco group identifier.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public GroupMemberPaging members(String groupId, int skip, int size) {
        return api.listGroupMemberships(normalize(groupId), skip, size, null, null, null);
    }
        /**
     * <p><strong>RU:</strong> перемещает существующий узел в другую папку репозитория.</p>
     * <p><strong>EN:</strong> moves an existing node to another repository folder.</p>
     *
     * @param groupId RU: идентификатор группы Alfresco. EN: Alfresco group identifier.
     * @param memberId RU: значение параметра `memberId` для выполняемой операции. EN: value of `memberId` used by the operation.
     */

    public void removeMember(String groupId, String memberId) { api.deleteGroupMembership(normalize(groupId), memberId); }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `normalize` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `normalize` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param id RU: идентификатор объекта Alfresco. EN: Alfresco object identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public static String normalize(String id) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("group id must not be blank");
        return id.startsWith("GROUP_") ? id : "GROUP_" + id;
    }
}
