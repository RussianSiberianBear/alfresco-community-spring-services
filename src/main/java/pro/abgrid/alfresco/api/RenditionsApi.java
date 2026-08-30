package pro.abgrid.alfresco.api;

import pro.abgrid.alfresco.dto.core.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.time.OffsetDateTime;

/**
 * <p><strong>RU:</strong> Низкоуровневый HTTP-интерфейс RenditionsApi отображает операции Alfresco REST API на Spring HTTP Service. В обычном прикладном коде предпочтительнее high-level сервисы; этот интерфейс нужен для параметров и endpoint, не покрытых удобной обёрткой.</p>
 * <p><strong>EN:</strong> Low-level HTTP interface RenditionsApi maps Alfresco REST operations to Spring HTTP Service methods. Application code will normally prefer high-level services; use this interface for endpoint-level control or operations without a high-level wrapper.</p>
 * <p><strong>RU:</strong> HTTP-ошибки преобразуются общей конфигурацией клиента в AlfrescoApiException.</p>
 * <p><strong>EN:</strong> HTTP errors are converted by the shared client configuration into AlfrescoApiException.</p>
 */
public interface RenditionsApi {

        /**
     * <p><strong>RU:</strong> Создаёт ресурс или связь в Alfresco. Метод напрямую отражает REST-контракт и принимает generated DTO тела запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. An asynchronous request to create a rendition for file nodeId. The rendition is specified by name id in the request body: JSON { "id":"doclib" } Multiple names may be specified as a comma separated list or using a list format: JSON [ { "id": "doclib" }, { "id": "avatar" } ]</p>
     * <p><strong>REST:</strong> POST /nodes/{nodeId}/renditions; operationId: createRendition.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param renditionBodyCreate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The rendition "id".. Required.
     */

    @PostExchange(url = "/nodes/{nodeId}/renditions")
    Void createRendition(@PathVariable("nodeId") String nodeId, @RequestBody RenditionBodyCreate renditionBodyCreate);

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Gets a list of the rendition information for each rendition of the the file nodeId, including the rendition id. Each rendition returned has a status: CREATED means it is available to view or download, NOT_CREATED means the rendition can be requested. You can use the where parameter to filter the returned renditions by status. For example, the following where clause will return just the CREATED renditions: (status='CREATED')</p>
     * <p><strong>REST:</strong> GET /nodes/{nodeId}/renditions; operationId: listRenditions.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param where RU: серверное выражение фильтрации Alfresco. Необязательный параметр, если аннотация допускает null. EN: A string to restrict the returned objects by using a predicate.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listRenditions в generated-модели RenditionPaging. EN: Alfresco response for listRenditions represented as RenditionPaging.
     */

    @GetExchange(url = "/nodes/{nodeId}/renditions")
    RenditionPaging listRenditions(@PathVariable("nodeId") String nodeId, @RequestParam(value = "where", required = false) String where);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Gets the rendition information for renditionId of file nodeId.</p>
     * <p><strong>REST:</strong> GET /nodes/{nodeId}/renditions/{renditionId}; operationId: getRendition.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param renditionId RU: идентификатор rendition. Обязательный параметр. EN: The name of a thumbnail rendition, for example *doclib*, or *pdf*.. Required.
     * @return RU: ответ Alfresco для getRendition в generated-модели RenditionEntry. EN: Alfresco response for getRendition represented as RenditionEntry.
     */

    @GetExchange(url = "/nodes/{nodeId}/renditions/{renditionId}")
    RenditionEntry getRendition(@PathVariable("nodeId") String nodeId, @PathVariable("renditionId") String renditionId);

        /**
     * <p><strong>RU:</strong> Удаляет ресурс или связь через Alfresco REST API; обратимость зависит от конкретной операции и её параметров.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.1.1 and newer versions. Delete the rendition identified by renditionId of nodeId. If the rendition is successfully deleted then the content for that rendition node will be cleared.</p>
     * <p><strong>REST:</strong> DELETE /nodes/{nodeId}/renditions/{renditionId}; operationId: deleteRendition.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param renditionId RU: идентификатор rendition. Обязательный параметр. EN: The name of a thumbnail rendition, for example *doclib*, or *pdf*.. Required.
     */

    @DeleteExchange(url = "/nodes/{nodeId}/renditions/{renditionId}")
    Void deleteRendition(@PathVariable("nodeId") String nodeId, @PathVariable("renditionId") String renditionId);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Gets the rendition content for renditionId of file nodeId.</p>
     * <p><strong>REST:</strong> GET /nodes/{nodeId}/renditions/{renditionId}/content; operationId: getRenditionContent.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param renditionId RU: идентификатор rendition. Обязательный параметр. EN: The name of a thumbnail rendition, for example *doclib*, or *pdf*.. Required.
     * @param attachment RU: управляет выдачей содержимого как attachment. Необязательный параметр, если аннотация допускает null. EN: true enables a web browser to download the file as an attachment. false means a web browser may preview the file in a new tab or window. You can only set this parameter to false if the content type of the file is in the supported list; for example, certain image files and PDF files. If the content type is not supported for preview, then a value of false is ignored, and the attachment will be returned in the response.. Optional when the method annotation allows null.
     * @param ifModifiedSince RU: HTTP If-Modified-Since для условного получения содержимого. Необязательный параметр, если аннотация допускает null. EN: Value of parameter ifModifiedSince for this REST operation. Optional when the method annotation allows null.
     * @param range RU: HTTP Range для частичного чтения содержимого. Необязательный параметр, если аннотация допускает null. EN: Value of parameter range for this REST operation. Optional when the method annotation allows null.
     * @param placeholder RU: значение параметра placeholder для данной REST-операции. Необязательный параметр, если аннотация допускает null. EN: If true and there is no rendition for this nodeId and renditionId, then the placeholder image for the mime type of this rendition is returned, rather than a 404 response.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для getRenditionContent в generated-модели byte[]. EN: Alfresco response for getRenditionContent represented as byte[].
     */

    @GetExchange(url = "/nodes/{nodeId}/renditions/{renditionId}/content")
    byte[] getRenditionContent(@PathVariable("nodeId") String nodeId, @PathVariable("renditionId") String renditionId, @RequestParam(value = "attachment", required = false) Boolean attachment, @RequestHeader(value = "If-Modified-Since", required = false) OffsetDateTime ifModifiedSince, @RequestHeader(value = "Range", required = false) String range, @RequestParam(value = "placeholder", required = false) Boolean placeholder);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию POST /nodes/{nodeId}/renditions/{renditionId}/request-direct-access-url Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.1 and newer versions. Generate a direct access content url for the given nodeId.</p>
     * <p><strong>REST:</strong> POST /nodes/{nodeId}/renditions/{renditionId}/request-direct-access-url; operationId: requestRenditionDirectAccessUrl.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param renditionId RU: идентификатор rendition. Обязательный параметр. EN: The name of a thumbnail rendition, for example *doclib*, or *pdf*.. Required.
     * @param requestContentUrlBodyCreate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Необязательный параметр, если аннотация допускает null. EN: Direct Access URL options and flags. Note: It is up to the actual ContentStore implementation if it can fulfil this request or not. The attachment flag controls the download method of the generated URL. It defaults to true, meaning the value for the Content Disposition response header will be attachment. true enables a web browser to download the file as an attachment. false means a web browser may preview the file in a new tab or window. You can only set this parameter to false if the content type of the file is in the supported list; for example, certain image files and PDF files. If the content type is not supported for preview, then a value of false is ignored, and the attachment will be returned in the response.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для requestRenditionDirectAccessUrl в generated-модели DirectAccessUrlEntry. EN: Alfresco response for requestRenditionDirectAccessUrl represented as DirectAccessUrlEntry.
     */

    @PostExchange(url = "/nodes/{nodeId}/renditions/{renditionId}/request-direct-access-url")
    DirectAccessUrlEntry requestRenditionDirectAccessUrl(@PathVariable("nodeId") String nodeId, @PathVariable("renditionId") String renditionId, @RequestBody DirectAccessUrlBodyCreate requestContentUrlBodyCreate);
}
