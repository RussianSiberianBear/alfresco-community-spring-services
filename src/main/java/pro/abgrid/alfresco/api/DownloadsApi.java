package pro.abgrid.alfresco.api;

import pro.abgrid.alfresco.dto.core.DownloadBodyCreate;
import pro.abgrid.alfresco.dto.core.DownloadEntry;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

/**
 * <p><strong>RU:</strong> Низкоуровневый HTTP-интерфейс DownloadsApi отображает операции Alfresco REST API на Spring HTTP Service. В обычном прикладном коде предпочтительнее high-level сервисы; этот интерфейс нужен для параметров и endpoint, не покрытых удобной обёрткой.</p>
 * <p><strong>EN:</strong> Low-level HTTP interface DownloadsApi maps Alfresco REST operations to Spring HTTP Service methods. Application code will normally prefer high-level services; use this interface for endpoint-level control or operations without a high-level wrapper.</p>
 * <p><strong>RU:</strong> HTTP-ошибки преобразуются общей конфигурацией клиента в AlfrescoApiException.</p>
 * <p><strong>EN:</strong> HTTP errors are converted by the shared client configuration into AlfrescoApiException.</p>
 */
public interface DownloadsApi {

        /**
     * <p><strong>RU:</strong> Создаёт ресурс или связь в Alfresco. Метод напрямую отражает REST-контракт и принимает generated DTO тела запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2.1 and newer versions. Creates a new download node asynchronously, the content of which will be the zipped content of the nodeIds specified in the JSON body like this: JSON { "nodeIds": [ "c8bb482a-ff3c-4704-a3a3-de1c83ccd84c", "cffa62db-aa01-493d-9594-058bc058eeb1" ] } Note: The content of the download node can be obtained using the GET /nodes/{downloadId}/content endpoint</p>
     * <p><strong>REST:</strong> POST /downloads; operationId: createDownload.</p>
     *
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param downloadBodyCreate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Необязательный параметр, если аннотация допускает null. EN: Value of parameter downloadBodyCreate for this REST operation. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для createDownload в generated-модели DownloadEntry. EN: Alfresco response for createDownload represented as DownloadEntry.
     */

    @PostExchange(url = "/downloads")
    DownloadEntry createDownload(@RequestParam(value = "fields", required = false) List<String> fields, @RequestBody DownloadBodyCreate downloadBodyCreate);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2.1 and newer versions. Retrieve status information for download node downloadId</p>
     * <p><strong>REST:</strong> GET /downloads/{downloadId}; operationId: getDownload.</p>
     *
     * @param downloadId RU: идентификатор задания пакетной загрузки. Обязательный параметр. EN: The identifier of a download node.. Required.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для getDownload в generated-модели DownloadEntry. EN: Alfresco response for getDownload represented as DownloadEntry.
     */

    @GetExchange(url = "/downloads/{downloadId}")
    DownloadEntry getDownload(@PathVariable("downloadId") String downloadId, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию DELETE /downloads/{downloadId} Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2.1 and newer versions. Cancels the creation of a download request. Note: The download node can be deleted using the DELETE /nodes/{downloadId} endpoint By default, if the download node is not deleted it will be picked up by a cleaner job which removes download nodes older than a configurable amount of time (default is 1 hour) Information about the existing progress at the time of cancelling can be retrieved by calling the GET /downloads/{downloadId} endpoint The cancel operation is done asynchronously.</p>
     * <p><strong>REST:</strong> DELETE /downloads/{downloadId}; operationId: cancelDownload.</p>
     *
     * @param downloadId RU: идентификатор задания пакетной загрузки. Обязательный параметр. EN: The identifier of a download node.. Required.
     */

    @DeleteExchange(url = "/downloads/{downloadId}")
    Void cancelDownload(@PathVariable("downloadId") String downloadId);
}
