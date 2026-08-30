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
 * <p><strong>RU:</strong> Низкоуровневый HTTP-интерфейс SitesApi отображает операции Alfresco REST API на Spring HTTP Service. В обычном прикладном коде предпочтительнее high-level сервисы; этот интерфейс нужен для параметров и endpoint, не покрытых удобной обёрткой.</p>
 * <p><strong>EN:</strong> Low-level HTTP interface SitesApi maps Alfresco REST operations to Spring HTTP Service methods. Application code will normally prefer high-level services; use this interface for endpoint-level control or operations without a high-level wrapper.</p>
 * <p><strong>RU:</strong> HTTP-ошибки преобразуются общей конфигурацией клиента в AlfrescoApiException.</p>
 * <p><strong>EN:</strong> HTTP errors are converted by the shared client configuration into AlfrescoApiException.</p>
 */
public interface SitesApi {

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Gets a list of the current site membership requests for person personId. You can use the -me- string in place of &lt;personId&gt; to specify the currently authenticated user.</p>
     * <p><strong>REST:</strong> GET /people/{personId}/site-membership-requests; operationId: listSiteMembershipRequestsForPerson.</p>
     *
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listSiteMembershipRequestsForPerson в generated-модели SiteMembershipRequestPaging. EN: Alfresco response for listSiteMembershipRequestsForPerson represented as SiteMembershipRequestPaging.
     */

    @GetExchange(url = "/people/{personId}/site-membership-requests")
    SiteMembershipRequestPaging listSiteMembershipRequestsForPerson(@PathVariable("personId") String personId, @RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Создаёт ресурс или связь в Alfresco. Метод напрямую отражает REST-контракт и принимает generated DTO тела запроса.</p>
     * <p><strong>EN:</strong> Create a site membership request for yourself on the site with the identifier of id, specified in the JSON body. The result of the request differs depending on the type of site. * For a public site, you join the site immediately as a SiteConsumer. * For a moderated site, your request is added to the site membership request list. The request waits for approval from the Site Manager. * You cannot request membership of a private site. Members are invited by the site administrator. You can use the -me- string in place of &lt;personId&gt; to specify the currently authenticated user. Note: You can create site membership requests for more than one site by specifying a list of sites in the JSON body like this: JSON [ { "message": "Please can you add me", "id": "test-site-1", "title": "Request for test site 1", }, { "message": "Please can you add me", "id": "test-site-2", "title": "Request for test site 2", } ] If you specify a list as input, then a paginated list rather than an entry is return…</p>
     * <p><strong>REST:</strong> POST /people/{personId}/site-membership-requests; operationId: createSiteMembershipRequestForPerson.</p>
     *
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param siteMembershipRequestBodyCreate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: Site membership request details. Required.
     * @return RU: ответ Alfresco для createSiteMembershipRequestForPerson в generated-модели SiteMembershipRequestEntry. EN: Alfresco response for createSiteMembershipRequestForPerson represented as SiteMembershipRequestEntry.
     */

    @PostExchange(url = "/people/{personId}/site-membership-requests")
    SiteMembershipRequestEntry createSiteMembershipRequestForPerson(@PathVariable("personId") String personId, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody SiteMembershipRequestBodyCreate siteMembershipRequestBodyCreate);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Gets the site membership request for site siteId for person personId, if one exists. You can use the -me- string in place of &lt;personId&gt; to specify the currently authenticated user.</p>
     * <p><strong>REST:</strong> GET /people/{personId}/site-membership-requests/{siteId}; operationId: getSiteMembershipRequestForPerson.</p>
     *
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     * @param siteId RU: короткий идентификатор сайта Alfresco. Обязательный параметр. EN: The identifier of a site.. Required.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для getSiteMembershipRequestForPerson в generated-модели SiteMembershipRequestEntry. EN: Alfresco response for getSiteMembershipRequestForPerson represented as SiteMembershipRequestEntry.
     */

    @GetExchange(url = "/people/{personId}/site-membership-requests/{siteId}")
    SiteMembershipRequestEntry getSiteMembershipRequestForPerson(@PathVariable("personId") String personId, @PathVariable("siteId") String siteId, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Изменяет существующий ресурс Alfresco согласно REST-контракту и возвращает подтверждённое сервером состояние, если endpoint имеет ответ.</p>
     * <p><strong>EN:</strong> Updates the message for the site membership request to site siteId for person personId. You can use the -me- string in place of &lt;personId&gt; to specify the currently authenticated user.</p>
     * <p><strong>REST:</strong> PUT /people/{personId}/site-membership-requests/{siteId}; operationId: updateSiteMembershipRequestForPerson.</p>
     *
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     * @param siteId RU: короткий идентификатор сайта Alfresco. Обязательный параметр. EN: The identifier of a site.. Required.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param siteMembershipRequestBodyUpdate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The new message to display. Required.
     * @return RU: ответ Alfresco для updateSiteMembershipRequestForPerson в generated-модели SiteMembershipRequestEntry. EN: Alfresco response for updateSiteMembershipRequestForPerson represented as SiteMembershipRequestEntry.
     */

    @PutExchange(url = "/people/{personId}/site-membership-requests/{siteId}")
    SiteMembershipRequestEntry updateSiteMembershipRequestForPerson(@PathVariable("personId") String personId, @PathVariable("siteId") String siteId, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody SiteMembershipRequestBodyUpdate siteMembershipRequestBodyUpdate);

        /**
     * <p><strong>RU:</strong> Удаляет ресурс или связь через Alfresco REST API; обратимость зависит от конкретной операции и её параметров.</p>
     * <p><strong>EN:</strong> Deletes the site membership request to site siteId for person personId. You can use the -me- string in place of &lt;personId&gt; to specify the currently authenticated user.</p>
     * <p><strong>REST:</strong> DELETE /people/{personId}/site-membership-requests/{siteId}; operationId: deleteSiteMembershipRequestForPerson.</p>
     *
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     * @param siteId RU: короткий идентификатор сайта Alfresco. Обязательный параметр. EN: The identifier of a site.. Required.
     */

    @DeleteExchange(url = "/people/{personId}/site-membership-requests/{siteId}")
    Void deleteSiteMembershipRequestForPerson(@PathVariable("personId") String personId, @PathVariable("siteId") String siteId);

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Gets a list of site membership information for person personId. You can use the -me- string in place of &lt;personId&gt; to specify the currently authenticated user. You can use the where parameter to filter the returned sites by visibility or site preset. Example to filter by visibility, use any one of: (visibility='PRIVATE') (visibility='PUBLIC') (visibility='MODERATED') Example to filter by site preset: (preset='site-dashboard') The default sort order for the returned list is for sites to be sorted by ascending title. You can override the default by using the orderBy parameter. You can specify one or more of the following fields in the orderBy parameter: * id * title * role</p>
     * <p><strong>REST:</strong> GET /people/{personId}/sites; operationId: listSiteMembershipsForPerson.</p>
     *
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param orderBy RU: серверные выражения сортировки. Необязательный параметр, если аннотация допускает null. EN: A string to control the order of the entities returned in a list. You can use the orderBy parameter to sort the list by one or more fields. Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order. To sort the entities in a specific order, you can use the ASC and DESC keywords for any field.. Optional when the method annotation allows null.
     * @param relations RU: значение параметра relations для данной REST-операции. Необязательный параметр, если аннотация допускает null. EN: Use the relations parameter to include one or more related entities in a single response.. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param where RU: серверное выражение фильтрации Alfresco. Необязательный параметр, если аннотация допускает null. EN: A string to restrict the returned objects by using a predicate.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listSiteMembershipsForPerson в generated-модели SiteRolePaging. EN: Alfresco response for listSiteMembershipsForPerson represented as SiteRolePaging.
     */

    @GetExchange(url = "/people/{personId}/sites")
    SiteRolePaging listSiteMembershipsForPerson(@PathVariable("personId") String personId, @RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "orderBy", required = false) List<String> orderBy, @RequestParam(value = "relations", required = false) List<String> relations, @RequestParam(value = "fields", required = false) List<String> fields, @RequestParam(value = "where", required = false) String where);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Gets site membership information for person personId on site siteId. You can use the -me- string in place of &lt;personId&gt; to specify the currently authenticated user.</p>
     * <p><strong>REST:</strong> GET /people/{personId}/sites/{siteId}; operationId: getSiteMembershipForPerson.</p>
     *
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     * @param siteId RU: короткий идентификатор сайта Alfresco. Обязательный параметр. EN: The identifier of a site.. Required.
     * @return RU: ответ Alfresco для getSiteMembershipForPerson в generated-модели SiteRoleEntry. EN: Alfresco response for getSiteMembershipForPerson represented as SiteRoleEntry.
     */

    @GetExchange(url = "/people/{personId}/sites/{siteId}")
    SiteRoleEntry getSiteMembershipForPerson(@PathVariable("personId") String personId, @PathVariable("siteId") String siteId);

        /**
     * <p><strong>RU:</strong> Удаляет ресурс или связь через Alfresco REST API; обратимость зависит от конкретной операции и её параметров.</p>
     * <p><strong>EN:</strong> Deletes person personId as a member of site siteId. You can use the -me- string in place of &lt;personId&gt; to specify the currently authenticated user.</p>
     * <p><strong>REST:</strong> DELETE /people/{personId}/sites/{siteId}; operationId: deleteSiteMembershipForPerson.</p>
     *
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     * @param siteId RU: короткий идентификатор сайта Alfresco. Обязательный параметр. EN: The identifier of a site.. Required.
     */

    @DeleteExchange(url = "/people/{personId}/sites/{siteId}")
    Void deleteSiteMembershipForPerson(@PathVariable("personId") String personId, @PathVariable("siteId") String siteId);

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Gets a list of sites in this repository. You can use the where parameter to filter the returned sites by visibility or site preset. Example to filter by visibility, use any one of: (visibility='PRIVATE') (visibility='PUBLIC') (visibility='MODERATED') Example to filter by site preset: (preset='site-dashboard') The default sort order for the returned list is for sites to be sorted by ascending title. You can override the default by using the orderBy parameter. You can specify one or more of the following fields in the orderBy parameter: * id * title * description You can use the relations parameter to include one or more related entities in a single response and so reduce network traffic. The entity types in Alfresco are organized in a tree structure. The sites entity has two children, containers and members. The following relations parameter returns all the container and member objects related to each site: containers,members</p>
     * <p><strong>REST:</strong> GET /sites; operationId: listSites.</p>
     *
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param orderBy RU: серверные выражения сортировки. Необязательный параметр, если аннотация допускает null. EN: A string to control the order of the entities returned in a list. You can use the orderBy parameter to sort the list by one or more fields. Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order. To sort the entities in a specific order, you can use the ASC and DESC keywords for any field.. Optional when the method annotation allows null.
     * @param relations RU: значение параметра relations для данной REST-операции. Необязательный параметр, если аннотация допускает null. EN: Use the relations parameter to include one or more related entities in a single response.. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param where RU: серверное выражение фильтрации Alfresco. Необязательный параметр, если аннотация допускает null. EN: A string to restrict the returned objects by using a predicate.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listSites в generated-модели SitePaging. EN: Alfresco response for listSites represented as SitePaging.
     */

    @GetExchange(url = "/sites")
    SitePaging listSites(@RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "orderBy", required = false) List<String> orderBy, @RequestParam(value = "relations", required = false) List<String> relations, @RequestParam(value = "fields", required = false) List<String> fields, @RequestParam(value = "where", required = false) String where);

        /**
     * <p><strong>RU:</strong> Создаёт ресурс или связь в Alfresco. Метод напрямую отражает REST-контракт и принимает generated DTO тела запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Creates a default site with the given details. Unless explicitly specified, the site id will be generated from the site title. The site id must be unique and only contain alphanumeric and/or dash characters. Note: the id of a site cannot be updated once the site has been created. For example, to create a public site called "Marketing" the following body could be used: JSON { "title": "Marketing", "visibility": "PUBLIC" } The creation of the (surf) configuration files required by Share can be skipped via the skipConfiguration query parameter. Note: if skipped then such a site will not work within Share. The addition of the site to the user's site favorites can be skipped via the skipAddToFavorites query parameter. The creator will be added as a member with Site Manager role. When you create a site, a container called documentLibrary is created for you in the new site. This container is the root folder for content store…</p>
     * <p><strong>REST:</strong> POST /sites; operationId: createSite.</p>
     *
     * @param skipConfiguration RU: признак пропуска дополнительной конфигурации. Необязательный параметр, если аннотация допускает null. EN: Flag to indicate whether the Share-specific (surf) configuration files for the site should not be created.. Optional when the method annotation allows null.
     * @param skipAddToFavorites RU: признак запрета автоматического добавления сайта в избранное. Необязательный параметр, если аннотация допускает null. EN: Flag to indicate whether the site should not be added to the user's site favorites.. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param siteBodyCreate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The site details. Required.
     * @return RU: ответ Alfresco для createSite в generated-модели SiteEntry. EN: Alfresco response for createSite represented as SiteEntry.
     */

    @PostExchange(url = "/sites")
    SiteEntry createSite(@RequestParam(value = "skipConfiguration", required = false) Boolean skipConfiguration, @RequestParam(value = "skipAddToFavorites", required = false) Boolean skipAddToFavorites, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody SiteBodyCreate siteBodyCreate);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Gets information for site siteId. You can use the relations parameter to include one or more related entities in a single response and so reduce network traffic. The entity types in Alfresco are organized in a tree structure. The sites entity has two children, containers and members. The following relations parameter returns all the container and member objects related to the site siteId: containers,members</p>
     * <p><strong>REST:</strong> GET /sites/{siteId}; operationId: getSite.</p>
     *
     * @param siteId RU: короткий идентификатор сайта Alfresco. Обязательный параметр. EN: The identifier of a site.. Required.
     * @param relations RU: значение параметра relations для данной REST-операции. Необязательный параметр, если аннотация допускает null. EN: Use the relations parameter to include one or more related entities in a single response.. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для getSite в generated-модели SiteEntry. EN: Alfresco response for getSite represented as SiteEntry.
     */

    @GetExchange(url = "/sites/{siteId}")
    SiteEntry getSite(@PathVariable("siteId") String siteId, @RequestParam(value = "relations", required = false) List<String> relations, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Изменяет существующий ресурс Alfresco согласно REST-контракту и возвращает подтверждённое сервером состояние, если endpoint имеет ответ.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Update the details for the given site siteId. Site Manager or otherwise a (site) admin can update title, description or visibility. Note: the id of a site cannot be updated once the site has been created.</p>
     * <p><strong>REST:</strong> PUT /sites/{siteId}; operationId: updateSite.</p>
     *
     * @param siteId RU: короткий идентификатор сайта Alfresco. Обязательный параметр. EN: The identifier of a site.. Required.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param siteBodyUpdate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The site information to update.. Required.
     * @return RU: ответ Alfresco для updateSite в generated-модели SiteEntry. EN: Alfresco response for updateSite represented as SiteEntry.
     */

    @PutExchange(url = "/sites/{siteId}")
    SiteEntry updateSite(@PathVariable("siteId") String siteId, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody SiteBodyUpdate siteBodyUpdate);

        /**
     * <p><strong>RU:</strong> Удаляет ресурс или связь через Alfresco REST API; обратимость зависит от конкретной операции и её параметров.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Deletes the site with siteId.</p>
     * <p><strong>REST:</strong> DELETE /sites/{siteId}; operationId: deleteSite.</p>
     *
     * @param siteId RU: короткий идентификатор сайта Alfresco. Обязательный параметр. EN: The identifier of a site.. Required.
     * @param permanent RU: если true, удаление выполняется без корзины и штатное восстановление невозможно. Необязательный параметр, если аннотация допускает null. EN: Flag to indicate whether the site should be permanently deleted i.e. bypass the trashcan.. Optional when the method annotation allows null.
     */

    @DeleteExchange(url = "/sites/{siteId}")
    Void deleteSite(@PathVariable("siteId") String siteId, @RequestParam(value = "permanent", required = false) Boolean permanent);

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Gets a list of containers for the site siteId.</p>
     * <p><strong>REST:</strong> GET /sites/{siteId}/containers; operationId: listSiteContainers.</p>
     *
     * @param siteId RU: короткий идентификатор сайта Alfresco. Обязательный параметр. EN: The identifier of a site.. Required.
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listSiteContainers в generated-модели SiteContainerPaging. EN: Alfresco response for listSiteContainers represented as SiteContainerPaging.
     */

    @GetExchange(url = "/sites/{siteId}/containers")
    SiteContainerPaging listSiteContainers(@PathVariable("siteId") String siteId, @RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Gets information on the container containerId in site siteId.</p>
     * <p><strong>REST:</strong> GET /sites/{siteId}/containers/{containerId}; operationId: getSiteContainer.</p>
     *
     * @param siteId RU: короткий идентификатор сайта Alfresco. Обязательный параметр. EN: The identifier of a site.. Required.
     * @param containerId RU: значение параметра containerId для данной REST-операции. Обязательный параметр. EN: The unique identifier of a site container.. Required.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для getSiteContainer в generated-модели SiteContainerEntry. EN: Alfresco response for getSiteContainer represented as SiteContainerEntry.
     */

    @GetExchange(url = "/sites/{siteId}/containers/{containerId}")
    SiteContainerEntry getSiteContainer(@PathVariable("siteId") String siteId, @PathVariable("containerId") String containerId, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Get the list of site membership requests the user can action. You can use the where parameter to filter the returned site membership requests by siteId. For example: (siteId=mySite) The where parameter can also be used to filter by *personId*. For example: where=(personId=person) This may be combined with the siteId filter, as shown below: where=(siteId=mySite AND personId=person)</p>
     * <p><strong>REST:</strong> GET /site-membership-requests; operationId: getSiteMembershipRequests.</p>
     *
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param where RU: серверное выражение фильтрации Alfresco. Необязательный параметр, если аннотация допускает null. EN: A string to restrict the returned objects by using a predicate.. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для getSiteMembershipRequests в generated-модели SiteMembershipRequestWithPersonPaging. EN: Alfresco response for getSiteMembershipRequests represented as SiteMembershipRequestWithPersonPaging.
     */

    @GetExchange(url = "/site-membership-requests")
    SiteMembershipRequestWithPersonPaging getSiteMembershipRequests(@RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "where", required = false) String where, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию POST /sites/{siteId}/site-membership-requests/{inviteeId}/approve Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Approve a site membership request.</p>
     * <p><strong>REST:</strong> POST /sites/{siteId}/site-membership-requests/{inviteeId}/approve; operationId: approveSiteMembershipRequest.</p>
     *
     * @param siteId RU: короткий идентификатор сайта Alfresco. Обязательный параметр. EN: The identifier of a site.. Required.
     * @param inviteeId RU: значение параметра inviteeId для данной REST-операции. Обязательный параметр. EN: The invitee user name.. Required.
     * @param siteMembershipApprovalBody RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Необязательный параметр, если аннотация допускает null. EN: Accepting a request to join, optionally, allows assignment of a role to the user.. Optional when the method annotation allows null.
     */

    @PostExchange(url = "/sites/{siteId}/site-membership-requests/{inviteeId}/approve")
    Void approveSiteMembershipRequest(@PathVariable("siteId") String siteId, @PathVariable("inviteeId") String inviteeId, @RequestBody SiteMembershipApprovalBody siteMembershipApprovalBody);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию POST /sites/{siteId}/site-membership-requests/{inviteeId}/reject Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Reject a site membership request.</p>
     * <p><strong>REST:</strong> POST /sites/{siteId}/site-membership-requests/{inviteeId}/reject; operationId: rejectSiteMembershipRequest.</p>
     *
     * @param siteId RU: короткий идентификатор сайта Alfresco. Обязательный параметр. EN: The identifier of a site.. Required.
     * @param inviteeId RU: значение параметра inviteeId для данной REST-операции. Обязательный параметр. EN: The invitee user name.. Required.
     * @param siteMembershipRejectionBody RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Необязательный параметр, если аннотация допускает null. EN: Rejecting a request to join, optionally, allows the inclusion of comment.. Optional when the method annotation allows null.
     */

    @PostExchange(url = "/sites/{siteId}/site-membership-requests/{inviteeId}/reject")
    Void rejectSiteMembershipRequest(@PathVariable("siteId") String siteId, @PathVariable("inviteeId") String inviteeId, @RequestBody SiteMembershipRejectionBody siteMembershipRejectionBody);

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Gets a list of site memberships for site siteId.</p>
     * <p><strong>REST:</strong> GET /sites/{siteId}/members; operationId: listSiteMemberships.</p>
     *
     * @param siteId RU: короткий идентификатор сайта Alfresco. Обязательный параметр. EN: The identifier of a site.. Required.
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param where RU: серверное выражение фильтрации Alfresco. Необязательный параметр, если аннотация допускает null. EN: Optionally filter the list. * where=(isMemberOfGroup=false|true). Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listSiteMemberships в generated-модели SiteMemberPaging. EN: Alfresco response for listSiteMemberships represented as SiteMemberPaging.
     */

    @GetExchange(url = "/sites/{siteId}/members")
    SiteMemberPaging listSiteMemberships(@PathVariable("siteId") String siteId, @RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "fields", required = false) List<String> fields, @RequestParam(value = "where", required = false) String where);

        /**
     * <p><strong>RU:</strong> Создаёт ресурс или связь в Alfresco. Метод напрямую отражает REST-контракт и принимает generated DTO тела запроса.</p>
     * <p><strong>EN:</strong> Creates a site membership for person personId on site siteId. You can set the role to one of four types: * SiteConsumer * SiteCollaborator * SiteContributor * SiteManager Note: You can create more than one site membership by specifying a list of people in the JSON body like this: JSON [ { "role": "SiteConsumer", "id": "joe" }, { "role": "SiteConsumer", "id": "fred" } ] If you specify a list as input, then a paginated list rather than an entry is returned in the response body. For example: JSON { "list": { "pagination": { "count": 2, "hasMoreItems": false, "totalItems": 2, "skipCount": 0, "maxItems": 100 }, "entries": [ { "entry": { ... } }, { "entry": { ... } } ] } }</p>
     * <p><strong>REST:</strong> POST /sites/{siteId}/members; operationId: createSiteMembership.</p>
     *
     * @param siteId RU: короткий идентификатор сайта Alfresco. Обязательный параметр. EN: The identifier of a site.. Required.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param siteMembershipBodyCreate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The person to add and their role. Required.
     * @return RU: ответ Alfresco для createSiteMembership в generated-модели SiteMemberEntry. EN: Alfresco response for createSiteMembership represented as SiteMemberEntry.
     */

    @PostExchange(url = "/sites/{siteId}/members")
    SiteMemberEntry createSiteMembership(@PathVariable("siteId") String siteId, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody SiteMembershipBodyCreate siteMembershipBodyCreate);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Gets site membership information for person personId on site siteId. You can use the -me- string in place of &lt;personId&gt; to specify the currently authenticated user.</p>
     * <p><strong>REST:</strong> GET /sites/{siteId}/members/{personId}; operationId: getSiteMembership.</p>
     *
     * @param siteId RU: короткий идентификатор сайта Alfresco. Обязательный параметр. EN: The identifier of a site.. Required.
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для getSiteMembership в generated-модели SiteMemberEntry. EN: Alfresco response for getSiteMembership represented as SiteMemberEntry.
     */

    @GetExchange(url = "/sites/{siteId}/members/{personId}")
    SiteMemberEntry getSiteMembership(@PathVariable("siteId") String siteId, @PathVariable("personId") String personId, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Изменяет существующий ресурс Alfresco согласно REST-контракту и возвращает подтверждённое сервером состояние, если endpoint имеет ответ.</p>
     * <p><strong>EN:</strong> Update the membership of person personId in site siteId. You can use the -me- string in place of &lt;personId&gt; to specify the currently authenticated user. You can set the role to one of four types: * SiteConsumer * SiteCollaborator * SiteContributor * SiteManager</p>
     * <p><strong>REST:</strong> PUT /sites/{siteId}/members/{personId}; operationId: updateSiteMembership.</p>
     *
     * @param siteId RU: короткий идентификатор сайта Alfresco. Обязательный параметр. EN: The identifier of a site.. Required.
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param siteMembershipBodyUpdate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The persons new role. Required.
     * @return RU: ответ Alfresco для updateSiteMembership в generated-модели SiteMemberEntry. EN: Alfresco response for updateSiteMembership represented as SiteMemberEntry.
     */

    @PutExchange(url = "/sites/{siteId}/members/{personId}")
    SiteMemberEntry updateSiteMembership(@PathVariable("siteId") String siteId, @PathVariable("personId") String personId, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody SiteMembershipBodyUpdate siteMembershipBodyUpdate);

        /**
     * <p><strong>RU:</strong> Удаляет ресурс или связь через Alfresco REST API; обратимость зависит от конкретной операции и её параметров.</p>
     * <p><strong>EN:</strong> Deletes person personId as a member of site siteId. You can use the -me- string in place of &lt;personId&gt; to specify the currently authenticated user.</p>
     * <p><strong>REST:</strong> DELETE /sites/{siteId}/members/{personId}; operationId: deleteSiteMembership.</p>
     *
     * @param siteId RU: короткий идентификатор сайта Alfresco. Обязательный параметр. EN: The identifier of a site.. Required.
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     */

    @DeleteExchange(url = "/sites/{siteId}/members/{personId}")
    Void deleteSiteMembership(@PathVariable("siteId") String siteId, @PathVariable("personId") String personId);

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.0.0 and newer versions. Gets a list of group membership for site siteId.</p>
     * <p><strong>REST:</strong> GET /sites/{siteId}/group-members; operationId: listSiteGroups.</p>
     *
     * @param siteId RU: короткий идентификатор сайта Alfresco. Обязательный параметр. EN: The identifier of a site.. Required.
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listSiteGroups в generated-модели SiteGroupPaging. EN: Alfresco response for listSiteGroups represented as SiteGroupPaging.
     */

    @GetExchange(url = "/sites/{siteId}/group-members")
    SiteGroupPaging listSiteGroups(@PathVariable("siteId") String siteId, @RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Создаёт ресурс или связь в Alfresco. Метод напрямую отражает REST-контракт и принимает generated DTO тела запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.0.0 and newer versions. Creates a site membership for group groupId on site siteId. You can set the role to one of four types: * SiteConsumer * SiteCollaborator * SiteContributor * SiteManager Note: You can create more than one site membership by specifying a list of group in the JSON body like this: JSON [ { "role": "SiteConsumer", "id": "authorityId" }, { "role": "SiteConsumer", "id": "authorityId" } ] If you specify a list as input, then a paginated list rather than an entry is returned in the response body. For example: JSON { "list": { "pagination": { "count": 2, "hasMoreItems": false, "totalItems": 2, "skipCount": 0, "maxItems": 100 }, "entries": [ { "entry": { ... } }, { "entry": { ... } } ] } }</p>
     * <p><strong>REST:</strong> POST /sites/{siteId}/group-members; operationId: createSiteGroupMembership.</p>
     *
     * @param siteId RU: короткий идентификатор сайта Alfresco. Обязательный параметр. EN: The identifier of a site.. Required.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param siteMembershipBodyCreate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The group to add and their role. Required.
     * @return RU: ответ Alfresco для createSiteGroupMembership в generated-модели SiteGroupEntry. EN: Alfresco response for createSiteGroupMembership represented as SiteGroupEntry.
     */

    @PostExchange(url = "/sites/{siteId}/group-members")
    SiteGroupEntry createSiteGroupMembership(@PathVariable("siteId") String siteId, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody SiteMembershipBodyCreate siteMembershipBodyCreate);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.0.0 and newer versions. Gets site membership information for group groupId on site siteId.</p>
     * <p><strong>REST:</strong> GET /sites/{siteId}/group-members/{groupId}; operationId: getSiteGroupMembership.</p>
     *
     * @param siteId RU: короткий идентификатор сайта Alfresco. Обязательный параметр. EN: The identifier of a site.. Required.
     * @param groupId RU: идентификатор группы/authority Alfresco. Обязательный параметр. EN: The identifier of a group.. Required.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для getSiteGroupMembership в generated-модели SiteGroupEntry. EN: Alfresco response for getSiteGroupMembership represented as SiteGroupEntry.
     */

    @GetExchange(url = "/sites/{siteId}/group-members/{groupId}")
    SiteGroupEntry getSiteGroupMembership(@PathVariable("siteId") String siteId, @PathVariable("groupId") String groupId, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Изменяет существующий ресурс Alfresco согласно REST-контракту и возвращает подтверждённое сервером состояние, если endpoint имеет ответ.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.0.0 and newer versions. Update the membership of person groupId in site siteId. You can set the role to one of four types: * SiteConsumer * SiteCollaborator * SiteContributor * SiteManager</p>
     * <p><strong>REST:</strong> PUT /sites/{siteId}/group-members/{groupId}; operationId: updateSiteGroupMembership.</p>
     *
     * @param siteId RU: короткий идентификатор сайта Alfresco. Обязательный параметр. EN: The identifier of a site.. Required.
     * @param groupId RU: идентификатор группы/authority Alfresco. Обязательный параметр. EN: The identifier of a group.. Required.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param siteMembershipBodyUpdate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The groupId new role. Required.
     * @return RU: ответ Alfresco для updateSiteGroupMembership в generated-модели SiteGroupEntry. EN: Alfresco response for updateSiteGroupMembership represented as SiteGroupEntry.
     */

    @PutExchange(url = "/sites/{siteId}/group-members/{groupId}")
    SiteGroupEntry updateSiteGroupMembership(@PathVariable("siteId") String siteId, @PathVariable("groupId") String groupId, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody SiteMembershipBodyUpdate siteMembershipBodyUpdate);

        /**
     * <p><strong>RU:</strong> Удаляет ресурс или связь через Alfresco REST API; обратимость зависит от конкретной операции и её параметров.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.0.0 and newer versions. Deletes group groupId as a member of site siteId.</p>
     * <p><strong>REST:</strong> DELETE /sites/{siteId}/group-members/{groupId}; operationId: deleteSiteGroupMembership.</p>
     *
     * @param siteId RU: короткий идентификатор сайта Alfresco. Обязательный параметр. EN: The identifier of a site.. Required.
     * @param groupId RU: идентификатор группы/authority Alfresco. Обязательный параметр. EN: The identifier of a group.. Required.
     */

    @DeleteExchange(url = "/sites/{siteId}/group-members/{groupId}")
    Void deleteSiteGroupMembership(@PathVariable("siteId") String siteId, @PathVariable("groupId") String groupId);
}
