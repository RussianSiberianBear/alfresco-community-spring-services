package pro.abgrid.alfresco.api;

import pro.abgrid.alfresco.dto.core.NodePaging;
import pro.abgrid.alfresco.dto.core.PersonPaging;
import pro.abgrid.alfresco.dto.core.SitePaging;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

/**
 * <p><strong>RU:</strong> Низкоуровневый HTTP-интерфейс QueriesApi отображает операции Alfresco REST API на Spring HTTP Service. В обычном прикладном коде предпочтительнее high-level сервисы; этот интерфейс нужен для параметров и endpoint, не покрытых удобной обёрткой.</p>
 * <p><strong>EN:</strong> Low-level HTTP interface QueriesApi maps Alfresco REST operations to Spring HTTP Service methods. Application code will normally prefer high-level services; use this interface for endpoint-level control or operations without a high-level wrapper.</p>
 * <p><strong>RU:</strong> HTTP-ошибки преобразуются общей конфигурацией клиента в AlfrescoApiException.</p>
 * <p><strong>EN:</strong> HTTP errors are converted by the shared client configuration into AlfrescoApiException.</p>
 */
public interface QueriesApi {

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию GET /queries/nodes Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Gets a list of nodes that match the given search criteria. The search term is used to look for nodes that match against name, title, description, full text content or tags. The search term: - must contain a minimum of 3 alphanumeric characters - allows "quoted term" - can optionally use '*' for wildcard matching By default, file and folder types will be searched unless a specific type is provided as a query parameter. By default, the search will be across the repository unless a specific root node id is provided to start the search from. You can sort the result list using the orderBy parameter. You can specify one or more of the following fields in the orderBy parameter: * name * modifiedAt * createdAt</p>
     * <p><strong>REST:</strong> GET /queries/nodes; operationId: findNodes.</p>
     *
     * @param term RU: строка поиска/автодополнения. Обязательный параметр. EN: The term to search for.. Required.
     * @param rootNodeId RU: значение параметра rootNodeId для данной REST-операции. Необязательный параметр, если аннотация допускает null. EN: The id of the node to start the search from. Supports the aliases -my-, -root- and -shared-.. Optional when the method annotation allows null.
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param nodeType RU: QName типа узла, например cm:content или cm:folder. Необязательный параметр, если аннотация допускает null. EN: Restrict the returned results to only those of the given node type and its sub-types. Optional when the method annotation allows null.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the node. The following optional fields can be requested: * allowableOperations * aspectNames * isLink * isFavorite * isDirectLinkEnabled * isLocked * path * properties. Optional when the method annotation allows null.
     * @param orderBy RU: серверные выражения сортировки. Необязательный параметр, если аннотация допускает null. EN: A string to control the order of the entities returned in a list. You can use the orderBy parameter to sort the list by one or more fields. Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order. To sort the entities in a specific order, you can use the ASC and DESC keywords for any field.. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для findNodes в generated-модели NodePaging. EN: Alfresco response for findNodes represented as NodePaging.
     */

    @GetExchange(url = "/queries/nodes")
    NodePaging findNodes(@RequestParam(value = "term", required = true) String term, @RequestParam(value = "rootNodeId", required = false) String rootNodeId, @RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "nodeType", required = false) String nodeType, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "orderBy", required = false) List<String> orderBy, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию GET /queries/sites Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Gets a list of sites that match the given search criteria. The search term is used to look for sites that match against site id, title or description. The search term: - must contain a minimum of 2 alphanumeric characters - can optionally use '*' for wildcard matching within the term The default sort order for the returned list is for sites to be sorted by ascending id. You can override the default by using the orderBy parameter. You can specify one or more of the following fields in the orderBy parameter: * id * title * description</p>
     * <p><strong>REST:</strong> GET /queries/sites; operationId: findSites.</p>
     *
     * @param term RU: строка поиска/автодополнения. Обязательный параметр. EN: The term to search for.. Required.
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param orderBy RU: серверные выражения сортировки. Необязательный параметр, если аннотация допускает null. EN: A string to control the order of the entities returned in a list. You can use the orderBy parameter to sort the list by one or more fields. Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order. To sort the entities in a specific order, you can use the ASC and DESC keywords for any field.. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для findSites в generated-модели SitePaging. EN: Alfresco response for findSites represented as SitePaging.
     */

    @GetExchange(url = "/queries/sites")
    SitePaging findSites(@RequestParam(value = "term", required = true) String term, @RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "orderBy", required = false) List<String> orderBy, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию GET /queries/people Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Gets a list of people that match the given search criteria. The search term is used to look for matches against person id, firstname and lastname. The search term: - must contain a minimum of 2 alphanumeric characters - can optionally use '*' for wildcard matching within the term You can sort the result list using the orderBy parameter. You can specify one or more of the following fields in the orderBy parameter: * id * firstName * lastName</p>
     * <p><strong>REST:</strong> GET /queries/people; operationId: findPeople.</p>
     *
     * @param term RU: строка поиска/автодополнения. Обязательный параметр. EN: The term to search for.. Required.
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param orderBy RU: серверные выражения сортировки. Необязательный параметр, если аннотация допускает null. EN: A string to control the order of the entities returned in a list. You can use the orderBy parameter to sort the list by one or more fields. Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order. To sort the entities in a specific order, you can use the ASC and DESC keywords for any field.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для findPeople в generated-модели PersonPaging. EN: Alfresco response for findPeople represented as PersonPaging.
     */

    @GetExchange(url = "/queries/people")
    PersonPaging findPeople(@RequestParam(value = "term", required = true) String term, @RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "fields", required = false) List<String> fields, @RequestParam(value = "orderBy", required = false) List<String> orderBy);
}
