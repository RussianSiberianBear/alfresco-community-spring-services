package pro.abgrid.alfresco.api;

import pro.abgrid.alfresco.dto.core.ActivityPaging;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

/**
 * <p><strong>RU:</strong> Низкоуровневый HTTP-интерфейс ActivitiesApi отображает операции Alfresco REST API на Spring HTTP Service. В обычном прикладном коде предпочтительнее high-level сервисы; этот интерфейс нужен для параметров и endpoint, не покрытых удобной обёрткой.</p>
 * <p><strong>EN:</strong> Low-level HTTP interface ActivitiesApi maps Alfresco REST operations to Spring HTTP Service methods. Application code will normally prefer high-level services; use this interface for endpoint-level control or operations without a high-level wrapper.</p>
 * <p><strong>RU:</strong> HTTP-ошибки преобразуются общей конфигурацией клиента в AlfrescoApiException.</p>
 * <p><strong>EN:</strong> HTTP errors are converted by the shared client configuration into AlfrescoApiException.</p>
 */
public interface ActivitiesApi {

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Gets a list of activities for person personId. You can use the -me- string in place of &lt;personId&gt; to specify the currently authenticated user.</p>
     * <p><strong>REST:</strong> GET /people/{personId}/activities; operationId: listActivitiesForPerson.</p>
     *
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param who RU: фильтр по пользователю/authority. Необязательный параметр, если аннотация допускает null. EN: A filter to include the user's activities only me, other user's activities only others'. Optional when the method annotation allows null.
     * @param siteId RU: короткий идентификатор сайта Alfresco. Необязательный параметр, если аннотация допускает null. EN: Include only activity feed entries relating to this site.. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listActivitiesForPerson в generated-модели ActivityPaging. EN: Alfresco response for listActivitiesForPerson represented as ActivityPaging.
     */

    @GetExchange(url = "/people/{personId}/activities")
    ActivityPaging listActivitiesForPerson(@PathVariable("personId") String personId, @RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "who", required = false) String who, @RequestParam(value = "siteId", required = false) String siteId, @RequestParam(value = "fields", required = false) List<String> fields);
}
