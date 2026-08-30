package pro.abgrid.alfresco.api;

import pro.abgrid.alfresco.dto.core.PersonNetworkEntry;
import pro.abgrid.alfresco.dto.core.PersonNetworkPaging;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

/**
 * <p><strong>RU:</strong> Низкоуровневый HTTP-интерфейс NetworksApi отображает операции Alfresco REST API на Spring HTTP Service. В обычном прикладном коде предпочтительнее high-level сервисы; этот интерфейс нужен для параметров и endpoint, не покрытых удобной обёрткой.</p>
 * <p><strong>EN:</strong> Low-level HTTP interface NetworksApi maps Alfresco REST operations to Spring HTTP Service methods. Application code will normally prefer high-level services; use this interface for endpoint-level control or operations without a high-level wrapper.</p>
 * <p><strong>RU:</strong> HTTP-ошибки преобразуются общей конфигурацией клиента в AlfrescoApiException.</p>
 * <p><strong>EN:</strong> HTTP errors are converted by the shared client configuration into AlfrescoApiException.</p>
 */
public interface NetworksApi {

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Gets a list of network memberships for person personId. You can use the -me- string in place of &lt;personId&gt; to specify the currently authenticated user.</p>
     * <p><strong>REST:</strong> GET /people/{personId}/networks; operationId: listNetworksForPerson.</p>
     *
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listNetworksForPerson в generated-модели PersonNetworkPaging. EN: Alfresco response for listNetworksForPerson represented as PersonNetworkPaging.
     */

    @GetExchange(url = "/people/{personId}/networks")
    PersonNetworkPaging listNetworksForPerson(@PathVariable("personId") String personId, @RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Gets network information on a single network specified by networkId for personId. You can use the -me- string in place of &lt;personId&gt; to specify the currently authenticated user.</p>
     * <p><strong>REST:</strong> GET /people/{personId}/networks/{networkId}; operationId: getNetworkForPerson.</p>
     *
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     * @param networkId RU: значение параметра networkId для данной REST-операции. Обязательный параметр. EN: The identifier of a network.. Required.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для getNetworkForPerson в generated-модели PersonNetworkEntry. EN: Alfresco response for getNetworkForPerson represented as PersonNetworkEntry.
     */

    @GetExchange(url = "/people/{personId}/networks/{networkId}")
    PersonNetworkEntry getNetworkForPerson(@PathVariable("personId") String personId, @PathVariable("networkId") String networkId, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Gets information for a network networkId.</p>
     * <p><strong>REST:</strong> GET /networks/{networkId}; operationId: getNetwork.</p>
     *
     * @param networkId RU: значение параметра networkId для данной REST-операции. Обязательный параметр. EN: The identifier of a network.. Required.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для getNetwork в generated-модели PersonNetworkEntry. EN: Alfresco response for getNetwork represented as PersonNetworkEntry.
     */

    @GetExchange(url = "/networks/{networkId}")
    PersonNetworkEntry getNetwork(@PathVariable("networkId") String networkId, @RequestParam(value = "fields", required = false) List<String> fields);
}
