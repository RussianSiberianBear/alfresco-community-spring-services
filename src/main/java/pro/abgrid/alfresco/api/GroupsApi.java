package pro.abgrid.alfresco.api;

import pro.abgrid.alfresco.dto.core.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

/**
 * <p><strong>RU:</strong> Низкоуровневый HTTP-интерфейс GroupsApi отображает операции Alfresco REST API на Spring HTTP Service. В обычном прикладном коде предпочтительнее high-level сервисы; этот интерфейс нужен для параметров и endpoint, не покрытых удобной обёрткой.</p>
 * <p><strong>EN:</strong> Low-level HTTP interface GroupsApi maps Alfresco REST operations to Spring HTTP Service methods. Application code will normally prefer high-level services; use this interface for endpoint-level control or operations without a high-level wrapper.</p>
 * <p><strong>RU:</strong> HTTP-ошибки преобразуются общей конфигурацией клиента в AlfrescoApiException.</p>
 * <p><strong>EN:</strong> HTTP errors are converted by the shared client configuration into AlfrescoApiException.</p>
 */
public interface GroupsApi {

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2.1 and newer versions. Gets a list of group membership information for person personId. You can use the -me- string in place of &lt;personId&gt; to specify the currently authenticated user. You can use the include parameter to return additional information. You can use the where parameter to filter the returned groups by isRoot. For example, the following where clause will return just the root groups: (isRoot=true) The where parameter can also be used to filter by *zone*. This may be combined with isRoot to narrow a result set even further. For example, the following where clause will only return groups belonging to the MY.ZONE zone. where=(zones in ('MY.ZONE')) This may be combined with the isRoot filter, as shown below: where=(isRoot=false AND zones in ('MY.ZONE')) *Note:* restrictions include * AND is the only supported operator when combining isRoot and zones filters * Only one zone is supported by the filter * The quoted zone name mu…</p>
     * <p><strong>REST:</strong> GET /people/{personId}/groups; operationId: listGroupMembershipsForPerson.</p>
     *
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param orderBy RU: серверные выражения сортировки. Необязательный параметр, если аннотация допускает null. EN: A string to control the order of the entities returned in a list. You can use the orderBy parameter to sort the list by one or more fields. Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order. To sort the entities in a specific order, you can use the ASC and DESC keywords for any field.. Optional when the method annotation allows null.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the group. The following optional fields can be requested: * parentIds * zones * hasSubgroups * description. Optional when the method annotation allows null.
     * @param where RU: серверное выражение фильтрации Alfresco. Необязательный параметр, если аннотация допускает null. EN: A string to restrict the returned objects by using a predicate.. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listGroupMembershipsForPerson в generated-модели GroupPaging. EN: Alfresco response for listGroupMembershipsForPerson represented as GroupPaging.
     */

    @GetExchange(url = "/people/{personId}/groups")
    GroupPaging listGroupMembershipsForPerson(@PathVariable("personId") String personId, @RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "orderBy", required = false) List<String> orderBy, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "where", required = false) String where, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2.1 and newer versions. Gets a list of groups. You can use the include parameter to return additional information. You can use the where parameter to filter the returned groups by isRoot. For example, the following where clause will return just the root groups: (isRoot=true) The where parameter can also be used to filter by *zone* and *displayName*. They may be combined with isRoot to narrow a result set even further. For example, the following where clause will only return groups belonging to the MY.ZONE zone. where=(zones in ('MY.ZONE')) This may be combined with the isRoot filter, as shown below: where=(isRoot=false AND zones in ('MY.ZONE')) The following where clause will only return groups with displayName MY.GROUP.NAME. where=(displayName in ('MY.GROUP.NAME')) This may be combined with the isRoot and zones filter, as shown below: where=(isRoot=false AND displayName in ('MY.GROUP.NAME')) where=(zones in ('MY.ZONE') AND displayName in …</p>
     * <p><strong>REST:</strong> GET /groups; operationId: listGroups.</p>
     *
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param orderBy RU: серверные выражения сортировки. Необязательный параметр, если аннотация допускает null. EN: A string to control the order of the entities returned in a list. You can use the orderBy parameter to sort the list by one or more fields. Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order. To sort the entities in a specific order, you can use the ASC and DESC keywords for any field.. Optional when the method annotation allows null.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the group. The following optional fields can be requested: * parentIds * zones * hasSubgroups * description. Optional when the method annotation allows null.
     * @param where RU: серверное выражение фильтрации Alfresco. Необязательный параметр, если аннотация допускает null. EN: A string to restrict the returned objects by using a predicate.. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listGroups в generated-модели GroupPaging. EN: Alfresco response for listGroups represented as GroupPaging.
     */

    @GetExchange(url = "/groups")
    GroupPaging listGroups(@RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "orderBy", required = false) List<String> orderBy, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "where", required = false) String where, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Создаёт ресурс или связь в Alfresco. Метод напрямую отражает REST-контракт и принимает generated DTO тела запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2.1 and newer versions. Create a group. The group id must start with "GROUP\_". If this is omitted it will be added automatically. This format is also returned when listing groups or group memberships. It should be noted that the other group-related operations also expect the id to start with "GROUP\_". If one or more parentIds are specified then the group will be created and become a member of each of the specified parent groups. If no parentIds are specified then the group will be created as a root group. The group will be created in the APP.DEFAULT and AUTH.ALF zones. You must have admin rights to create a group.</p>
     * <p><strong>REST:</strong> POST /groups; operationId: createGroup.</p>
     *
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the group. The following optional fields can be requested: * parentIds * zones * hasSubgroups * description. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param groupBodyCreate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The group to create.. Required.
     * @return RU: ответ Alfresco для createGroup в generated-модели GroupEntry. EN: Alfresco response for createGroup represented as GroupEntry.
     */

    @PostExchange(url = "/groups")
    GroupEntry createGroup(@RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody GroupBodyCreate groupBodyCreate);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2.1 and newer versions. Get details for group groupId. You can use the include parameter to return additional information.</p>
     * <p><strong>REST:</strong> GET /groups/{groupId}; operationId: getGroup.</p>
     *
     * @param groupId RU: идентификатор группы/authority Alfresco. Обязательный параметр. EN: The identifier of a group.. Required.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the group. The following optional fields can be requested: * parentIds * zones * hasSubgroups * description. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для getGroup в generated-модели GroupEntry. EN: Alfresco response for getGroup represented as GroupEntry.
     */

    @GetExchange(url = "/groups/{groupId}")
    GroupEntry getGroup(@PathVariable("groupId") String groupId, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Изменяет существующий ресурс Alfresco согласно REST-контракту и возвращает подтверждённое сервером состояние, если endpoint имеет ответ.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2.1 and newer versions. Update details (displayName) for group groupId. You must have admin rights to update a group.</p>
     * <p><strong>REST:</strong> PUT /groups/{groupId}; operationId: updateGroup.</p>
     *
     * @param groupId RU: идентификатор группы/authority Alfresco. Обязательный параметр. EN: The identifier of a group.. Required.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the group. The following optional fields can be requested: * parentIds * zones * hasSubgroups * description. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param groupBodyUpdate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The group information to update.. Required.
     * @return RU: ответ Alfresco для updateGroup в generated-модели GroupEntry. EN: Alfresco response for updateGroup represented as GroupEntry.
     */

    @PutExchange(url = "/groups/{groupId}")
    GroupEntry updateGroup(@PathVariable("groupId") String groupId, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody GroupBodyUpdate groupBodyUpdate);

        /**
     * <p><strong>RU:</strong> Удаляет ресурс или связь через Alfresco REST API; обратимость зависит от конкретной операции и её параметров.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2.1 and newer versions. Delete group groupId. The option to cascade delete applies this recursively to any hierarchy of group members. In this case, removing a group member does not delete the person or sub-group itself. If a removed sub-group no longer has any parent groups then it becomes a root group. You must have admin rights to delete a group.</p>
     * <p><strong>REST:</strong> DELETE /groups/{groupId}; operationId: deleteGroup.</p>
     *
     * @param groupId RU: идентификатор группы/authority Alfresco. Обязательный параметр. EN: The identifier of a group.. Required.
     * @param cascade RU: признак каскадного применения операции. Необязательный параметр, если аннотация допускает null. EN: If true then the delete will be applied in cascade to sub-groups.. Optional when the method annotation allows null.
     */

    @DeleteExchange(url = "/groups/{groupId}")
    Void deleteGroup(@PathVariable("groupId") String groupId, @RequestParam(value = "cascade", required = false) Boolean cascade);

        /**
     * <p><strong>RU:</strong> Создаёт ресурс или связь в Alfresco. Метод напрямую отражает REST-контракт и принимает generated DTO тела запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2.1 and newer versions. Create a group membership (for an existing person or group) within a group groupId. If the added group was previously a root group then it becomes a non-root group since it now has a parent. It is an error to specify an id that does not exist. You must have admin rights to create a group membership.</p>
     * <p><strong>REST:</strong> POST /groups/{groupId}/members; operationId: createGroupMembership.</p>
     *
     * @param groupId RU: идентификатор группы/authority Alfresco. Обязательный параметр. EN: The identifier of a group.. Required.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param groupMembershipBodyCreate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The group membership to add (person or sub-group).. Required.
     * @return RU: ответ Alfresco для createGroupMembership в generated-модели GroupMemberEntry. EN: Alfresco response for createGroupMembership represented as GroupMemberEntry.
     */

    @PostExchange(url = "/groups/{groupId}/members")
    GroupMemberEntry createGroupMembership(@PathVariable("groupId") String groupId, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody GroupMembershipBodyCreate groupMembershipBodyCreate);

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2.1 and newer versions. Gets a list of the group memberships for the group groupId. You can use the where parameter to filter the returned groups by memberType. Example to filter by memberType, use any one of: (memberType='GROUP') (memberType='PERSON') The default sort order for the returned list is for group members to be sorted by ascending displayName. You can override the default by using the orderBy parameter. You can specify one of the following fields in the orderBy parameter: * id * displayName</p>
     * <p><strong>REST:</strong> GET /groups/{groupId}/members; operationId: listGroupMemberships.</p>
     *
     * @param groupId RU: идентификатор группы/authority Alfresco. Обязательный параметр. EN: The identifier of a group.. Required.
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param orderBy RU: серверные выражения сортировки. Необязательный параметр, если аннотация допускает null. EN: A string to control the order of the entities returned in a list. You can use the orderBy parameter to sort the list by one or more fields. Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order. To sort the entities in a specific order, you can use the ASC and DESC keywords for any field.. Optional when the method annotation allows null.
     * @param where RU: серверное выражение фильтрации Alfresco. Необязательный параметр, если аннотация допускает null. EN: A string to restrict the returned objects by using a predicate.. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listGroupMemberships в generated-модели GroupMemberPaging. EN: Alfresco response for listGroupMemberships represented as GroupMemberPaging.
     */

    @GetExchange(url = "/groups/{groupId}/members")
    GroupMemberPaging listGroupMemberships(@PathVariable("groupId") String groupId, @RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "orderBy", required = false) List<String> orderBy, @RequestParam(value = "where", required = false) String where, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Удаляет ресурс или связь через Alfresco REST API; обратимость зависит от конкретной операции и её параметров.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2.1 and newer versions. Delete group member groupMemberId (person or sub-group) from group groupId. Removing a group member does not delete the person or sub-group itself. If a removed sub-group no longer has any parent groups then it becomes a root group. You must have admin rights to delete a group membership.</p>
     * <p><strong>REST:</strong> DELETE /groups/{groupId}/members/{groupMemberId}; operationId: deleteGroupMembership.</p>
     *
     * @param groupId RU: идентификатор группы/authority Alfresco. Обязательный параметр. EN: The identifier of a group.. Required.
     * @param groupMemberId RU: значение параметра groupMemberId для данной REST-операции. Обязательный параметр. EN: The identifier of a person or group.. Required.
     */

    @DeleteExchange(url = "/groups/{groupId}/members/{groupMemberId}")
    Void deleteGroupMembership(@PathVariable("groupId") String groupId, @PathVariable("groupMemberId") String groupMemberId);
}
