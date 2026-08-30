package pro.abgrid.alfresco.api;

import pro.abgrid.alfresco.dto.core.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

/**
 * <p><strong>RU:</strong> Низкоуровневый HTTP-интерфейс ActionsApi отображает операции Alfresco REST API на Spring HTTP Service. В обычном прикладном коде предпочтительнее high-level сервисы; этот интерфейс нужен для параметров и endpoint, не покрытых удобной обёрткой.</p>
 * <p><strong>EN:</strong> Low-level HTTP interface ActionsApi maps Alfresco REST operations to Spring HTTP Service methods. Application code will normally prefer high-level services; use this interface for endpoint-level control or operations without a high-level wrapper.</p>
 * <p><strong>RU:</strong> HTTP-ошибки преобразуются общей конфигурацией клиента в AlfrescoApiException.</p>
 * <p><strong>EN:</strong> HTTP errors are converted by the shared client configuration into AlfrescoApiException.</p>
 */
public interface ActionsApi {

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию GET /nodes/{nodeId}/action-definitions Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Retrieve the list of actions that may be executed against the given nodeId. The default sort order for the returned list is for actions to be sorted by ascending name. You can override the default by using the orderBy parameter. You can use any of the following fields to order the results: * name * title</p>
     * <p><strong>REST:</strong> GET /nodes/{nodeId}/action-definitions; operationId: nodeActions.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param orderBy RU: серверные выражения сортировки. Необязательный параметр, если аннотация допускает null. EN: A string to control the order of the entities returned in a list. You can use the orderBy parameter to sort the list by one or more fields. Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order. To sort the entities in a specific order, you can use the ASC and DESC keywords for any field.. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для nodeActions в generated-модели ActionDefinitionList. EN: Alfresco response for nodeActions represented as ActionDefinitionList.
     */

    @GetExchange(url = "/nodes/{nodeId}/action-definitions")
    ActionDefinitionList nodeActions(@PathVariable("nodeId") String nodeId, @RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "orderBy", required = false) List<String> orderBy, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.3.0 and newer versions. Gets action parameter constraint by requested name. Sample reposne: { "entry": { "constraintValues": [ { "value": "fa41fd6e-5640-410f-9f3e-93f268186f69", "label": "Start Pooled Review and Approve Workflow", "isNode": true } ], "constraintName": "ac-scripts" } }</p>
     * <p><strong>REST:</strong> GET /action-parameter-constraints/{parameterConstraintName}; operationId: getActionConstraint.</p>
     *
     * @param parameterConstraintName RU: значение параметра parameterConstraintName для данной REST-операции. Обязательный параметр. EN: Action parameter constraint name to be returned in the response.. Required.
     * @return RU: ответ Alfresco для getActionConstraint в generated-модели ActionConstraintEntry. EN: Alfresco response for getActionConstraint represented as ActionConstraintEntry.
     */

    @GetExchange(url = "/action-parameter-constraints/{parameterConstraintName}")
    ActionConstraintEntry getActionConstraint(@PathVariable("parameterConstraintName") String parameterConstraintName);

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2.2 and newer versions. Gets a list of all available actions The default sort order for the returned list is for actions to be sorted by ascending name. You can override the default by using the orderBy parameter. You can use any of the following fields to order the results: * name * title</p>
     * <p><strong>REST:</strong> GET /action-definitions; operationId: listActions.</p>
     *
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param orderBy RU: серверные выражения сортировки. Необязательный параметр, если аннотация допускает null. EN: A string to control the order of the entities returned in a list. You can use the orderBy parameter to sort the list by one or more fields. Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order. To sort the entities in a specific order, you can use the ASC and DESC keywords for any field.. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listActions в generated-модели ActionDefinitionList. EN: Alfresco response for listActions represented as ActionDefinitionList.
     */

    @GetExchange(url = "/action-definitions")
    ActionDefinitionList listActions(@RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "orderBy", required = false) List<String> orderBy, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию GET /action-definitions/{actionDefinitionId} Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Retrieve the details of the action denoted by actionDefinitionId.</p>
     * <p><strong>REST:</strong> GET /action-definitions/{actionDefinitionId}; operationId: actionDetails.</p>
     *
     * @param actionDefinitionId RU: значение параметра actionDefinitionId для данной REST-операции. Обязательный параметр. EN: The identifier of an action definition.. Required.
     * @return RU: ответ Alfresco для actionDetails в generated-модели ActionDefinitionEntry. EN: Alfresco response for actionDetails represented as ActionDefinitionEntry.
     */

    @GetExchange(url = "/action-definitions/{actionDefinitionId}")
    ActionDefinitionEntry actionDetails(@PathVariable("actionDefinitionId") String actionDefinitionId);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию POST /action-executions Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Executes an action An action may be executed against a node specified by targetId. For example: { "actionDefinitionId": "copy", "targetId": "4c4b3c43-f18b-43ff-af84-751f16f1ddfd", "params": { "destination-folder": "34219f79-66fa-4ebf-b371-118598af898c" } } Performing a POST with the request body shown above will result in the node identified by targetId being copied to the destination folder specified in the params object by the key destination-folder. targetId is optional, however, currently targetId must be a valid node ID. In the future, actions may be executed against different entity types or executed without the need for the context of an entity. Parameters supplied to the action within the params object will be converted to the expected type, where possible using the DefaultTypeConverter class. In addition: * Node IDs may be supplied in their short form (implicit workspace://SpacesStore prefix) * Aspect names m…</p>
     * <p><strong>REST:</strong> POST /action-executions; operationId: actionExec.</p>
     *
     * @param actionBodyExec RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: Action execution details. Required.
     * @return RU: ответ Alfresco для actionExec в generated-модели ActionExecResultEntry. EN: Alfresco response for actionExec represented as ActionExecResultEntry.
     */

    @PostExchange(url = "/action-executions")
    ActionExecResultEntry actionExec(@RequestBody ActionBodyExec actionBodyExec);
}
