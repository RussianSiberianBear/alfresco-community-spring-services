package pro.abgrid.alfresco.api;

import pro.abgrid.alfresco.dto.search.ResultSetPaging;
import pro.abgrid.alfresco.dto.search.SearchRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;

/**
 * <p><strong>RU:</strong> Низкоуровневый HTTP-интерфейс SearchApi отображает операции Alfresco REST API на Spring HTTP Service. В обычном прикладном коде предпочтительнее high-level сервисы; этот интерфейс нужен для параметров и endpoint, не покрытых удобной обёрткой.</p>
 * <p><strong>EN:</strong> Low-level HTTP interface SearchApi maps Alfresco REST operations to Spring HTTP Service methods. Application code will normally prefer high-level services; use this interface for endpoint-level control or operations without a high-level wrapper.</p>
 * <p><strong>RU:</strong> HTTP-ошибки преобразуются общей конфигурацией клиента в AlfrescoApiException.</p>
 * <p><strong>EN:</strong> HTTP errors are converted by the shared client configuration into AlfrescoApiException.</p>
 */
public interface SearchApi {

        /**
     * <p><strong>RU:</strong> Выполняет серверный поиск Alfresco и возвращает generated-ответ без high-level преобразования.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. You specify all the parameters in this API in a JSON body, URL parameters are not supported. A basic query looks like this: JSON { "query": { "query": "foo" } } Note: These are the minimum possible query parameters. The default search language is afts ([Alfresco Full Text Search](http://docs.alfresco.com/5.1/concepts/rm-searchsyntax-intro.html)), but you can also specify cmis, and lucene. A basic CMIS query looks like this: JSON { "query": { "query": "select * from cmis:folder", "language": "cmis" } } By default, results are limited to the first 100. Results can be restricted using "paging". For example: JSON "paging": { "maxItems": "50", "skipCount": "28" } This example would ensure that results are limited by Final Size, skipping the first 28 results and returning the next 50. Alternatively, you can limit the results by using the limits JSON body parameter. For example, JSON "limits": { "permissionEvaluationTime": 2…</p>
     * <p><strong>REST:</strong> POST /search; operationId: search.</p>
     *
     * @param queryBody RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: Generic query API. Required.
     * @return RU: ответ Alfresco для search в generated-модели ResultSetPaging. EN: Alfresco response for search represented as ResultSetPaging.
     */

    @PostExchange(url = "/search")
    ResultSetPaging search(@RequestBody SearchRequest queryBody);
}
