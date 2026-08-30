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
import java.util.List;

/**
 * <p><strong>RU:</strong> Низкоуровневый HTTP-интерфейс SharedLinksApi отображает операции Alfresco REST API на Spring HTTP Service. В обычном прикладном коде предпочтительнее high-level сервисы; этот интерфейс нужен для параметров и endpoint, не покрытых удобной обёрткой.</p>
 * <p><strong>EN:</strong> Low-level HTTP interface SharedLinksApi maps Alfresco REST operations to Spring HTTP Service methods. Application code will normally prefer high-level services; use this interface for endpoint-level control or operations without a high-level wrapper.</p>
 * <p><strong>RU:</strong> HTTP-ошибки преобразуются общей конфигурацией клиента в AlfrescoApiException.</p>
 * <p><strong>EN:</strong> HTTP errors are converted by the shared client configuration into AlfrescoApiException.</p>
 */
public interface SharedLinksApi {

        /**
     * <p><strong>RU:</strong> Создаёт ресурс или связь в Alfresco. Метод напрямую отражает REST-контракт и принимает generated DTO тела запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Create a shared link to the file nodeId in the request body. Also, an optional expiry date could be set, so the shared link would become invalid when the expiry date is reached. For example: JSON { "nodeId": "1ff9da1a-ee2f-4b9c-8c34-3333333333", "expiresAt": "2017-03-23T23:00:00.000+0000" } Note: You can create shared links to more than one file specifying a list of nodeIds in the JSON body like this: JSON [ { "nodeId": "1ff9da1a-ee2f-4b9c-8c34-4444444444" }, { "nodeId": "1ff9da1a-ee2f-4b9c-8c34-5555555555" } ] If you specify a list as input, then a paginated list rather than an entry is returned in the response body. For example: JSON { "list": { "pagination": { "count": 2, "hasMoreItems": false, "totalItems": 2, "skipCount": 0, "maxItems": 100 }, "entries": [ { "entry": { ... } }, { "entry": { ... } } ] } }</p>
     * <p><strong>REST:</strong> POST /shared-links; operationId: createSharedLink.</p>
     *
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the shared link, the following optional fields can be requested: * allowableOperations * path * properties * isFavorite * aspectNames. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param sharedLinkBodyCreate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The nodeId to create a shared link for.. Required.
     * @return RU: ответ Alfresco для createSharedLink в generated-модели SharedLinkEntry. EN: Alfresco response for createSharedLink represented as SharedLinkEntry.
     */

    @PostExchange(url = "/shared-links")
    SharedLinkEntry createSharedLink(@RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody SharedLinkBodyCreate sharedLinkBodyCreate);

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Get a list of links that the current user has read permission on source node. The list is ordered in descending modified order. Note: The list of links is eventually consistent so newly created shared links may not appear immediately.</p>
     * <p><strong>REST:</strong> GET /shared-links; operationId: listSharedLinks.</p>
     *
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param where RU: серверное выражение фильтрации Alfresco. Необязательный параметр, если аннотация допускает null. EN: Optionally filter the list by "sharedByUser" userid of person who shared the link (can also use -me-) * where=(sharedByUser='jbloggs') * where=(sharedByUser='-me-'). Optional when the method annotation allows null.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the shared link, the following optional fields can be requested: * allowableOperations * path * properties * isFavorite * aspectNames. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listSharedLinks в generated-модели SharedLinkPaging. EN: Alfresco response for listSharedLinks represented as SharedLinkPaging.
     */

    @GetExchange(url = "/shared-links")
    SharedLinkPaging listSharedLinks(@RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "where", required = false) String where, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Gets minimal information for the file with shared link identifier sharedId. Note: No authentication is required to call this endpoint.</p>
     * <p><strong>REST:</strong> GET /shared-links/{sharedId}; operationId: getSharedLink.</p>
     *
     * @param sharedId RU: идентификатор shared link. Обязательный параметр. EN: The identifier of a shared link to a file.. Required.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для getSharedLink в generated-модели SharedLinkEntry. EN: Alfresco response for getSharedLink represented as SharedLinkEntry.
     */

    @GetExchange(url = "/shared-links/{sharedId}")
    SharedLinkEntry getSharedLink(@PathVariable("sharedId") String sharedId, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Удаляет ресурс или связь через Alfresco REST API; обратимость зависит от конкретной операции и её параметров.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Deletes the shared link with identifier sharedId.</p>
     * <p><strong>REST:</strong> DELETE /shared-links/{sharedId}; operationId: deleteSharedLink.</p>
     *
     * @param sharedId RU: идентификатор shared link. Обязательный параметр. EN: The identifier of a shared link to a file.. Required.
     */

    @DeleteExchange(url = "/shared-links/{sharedId}")
    Void deleteSharedLink(@PathVariable("sharedId") String sharedId);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Gets the content of the file with shared link identifier sharedId. Note: No authentication is required to call this endpoint.</p>
     * <p><strong>REST:</strong> GET /shared-links/{sharedId}/content; operationId: getSharedLinkContent.</p>
     *
     * @param sharedId RU: идентификатор shared link. Обязательный параметр. EN: The identifier of a shared link to a file.. Required.
     * @param attachment RU: управляет выдачей содержимого как attachment. Необязательный параметр, если аннотация допускает null. EN: true enables a web browser to download the file as an attachment. false means a web browser may preview the file in a new tab or window. You can only set this parameter to false if the content type of the file is in the supported list; for example, certain image files and PDF files. If the content type is not supported for preview, then a value of false is ignored, and the attachment will be returned in the response.. Optional when the method annotation allows null.
     * @param ifModifiedSince RU: HTTP If-Modified-Since для условного получения содержимого. Необязательный параметр, если аннотация допускает null. EN: Value of parameter ifModifiedSince for this REST operation. Optional when the method annotation allows null.
     * @param range RU: HTTP Range для частичного чтения содержимого. Необязательный параметр, если аннотация допускает null. EN: Value of parameter range for this REST operation. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для getSharedLinkContent в generated-модели byte[]. EN: Alfresco response for getSharedLinkContent represented as byte[].
     */

    @GetExchange(url = "/shared-links/{sharedId}/content")
    byte[] getSharedLinkContent(@PathVariable("sharedId") String sharedId, @RequestParam(value = "attachment", required = false) Boolean attachment, @RequestHeader(value = "If-Modified-Since", required = false) OffsetDateTime ifModifiedSince, @RequestHeader(value = "Range", required = false) String range);

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Gets a list of the rendition information for the file with shared link identifier sharedId. This API method returns rendition information, including the rendition id, for each rendition where the rendition status is CREATED, which means the rendition is available to view/download. Note: No authentication is required to call this endpoint.</p>
     * <p><strong>REST:</strong> GET /shared-links/{sharedId}/renditions; operationId: listSharedLinkRenditions.</p>
     *
     * @param sharedId RU: идентификатор shared link. Обязательный параметр. EN: The identifier of a shared link to a file.. Required.
     * @return RU: ответ Alfresco для listSharedLinkRenditions в generated-модели RenditionPaging. EN: Alfresco response for listSharedLinkRenditions represented as RenditionPaging.
     */

    @GetExchange(url = "/shared-links/{sharedId}/renditions")
    RenditionPaging listSharedLinkRenditions(@PathVariable("sharedId") String sharedId);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Gets rendition information for the file with shared link identifier sharedId. This API method returns rendition information where the rendition status is CREATED, which means the rendition is available to view/download. Note: No authentication is required to call this endpoint.</p>
     * <p><strong>REST:</strong> GET /shared-links/{sharedId}/renditions/{renditionId}; operationId: getSharedLinkRendition.</p>
     *
     * @param sharedId RU: идентификатор shared link. Обязательный параметр. EN: The identifier of a shared link to a file.. Required.
     * @param renditionId RU: идентификатор rendition. Обязательный параметр. EN: The name of a thumbnail rendition, for example *doclib*, or *pdf*.. Required.
     * @return RU: ответ Alfresco для getSharedLinkRendition в generated-модели RenditionEntry. EN: Alfresco response for getSharedLinkRendition represented as RenditionEntry.
     */

    @GetExchange(url = "/shared-links/{sharedId}/renditions/{renditionId}")
    RenditionEntry getSharedLinkRendition(@PathVariable("sharedId") String sharedId, @PathVariable("renditionId") String renditionId);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Gets the rendition content for file with shared link identifier sharedId. Note: No authentication is required to call this endpoint.</p>
     * <p><strong>REST:</strong> GET /shared-links/{sharedId}/renditions/{renditionId}/content; operationId: getSharedLinkRenditionContent.</p>
     *
     * @param sharedId RU: идентификатор shared link. Обязательный параметр. EN: The identifier of a shared link to a file.. Required.
     * @param renditionId RU: идентификатор rendition. Обязательный параметр. EN: The name of a thumbnail rendition, for example *doclib*, or *pdf*.. Required.
     * @param attachment RU: управляет выдачей содержимого как attachment. Необязательный параметр, если аннотация допускает null. EN: true enables a web browser to download the file as an attachment. false means a web browser may preview the file in a new tab or window. You can only set this parameter to false if the content type of the file is in the supported list; for example, certain image files and PDF files. If the content type is not supported for preview, then a value of false is ignored, and the attachment will be returned in the response.. Optional when the method annotation allows null.
     * @param ifModifiedSince RU: HTTP If-Modified-Since для условного получения содержимого. Необязательный параметр, если аннотация допускает null. EN: Value of parameter ifModifiedSince for this REST operation. Optional when the method annotation allows null.
     * @param range RU: HTTP Range для частичного чтения содержимого. Необязательный параметр, если аннотация допускает null. EN: Value of parameter range for this REST operation. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для getSharedLinkRenditionContent в generated-модели byte[]. EN: Alfresco response for getSharedLinkRenditionContent represented as byte[].
     */

    @GetExchange(url = "/shared-links/{sharedId}/renditions/{renditionId}/content")
    byte[] getSharedLinkRenditionContent(@PathVariable("sharedId") String sharedId, @PathVariable("renditionId") String renditionId, @RequestParam(value = "attachment", required = false) Boolean attachment, @RequestHeader(value = "If-Modified-Since", required = false) OffsetDateTime ifModifiedSince, @RequestHeader(value = "Range", required = false) String range);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию POST /shared-links/{sharedId}/email Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Sends email with app-specific url including identifier sharedId. The client and recipientEmails properties are mandatory in the request body. For example, to email a shared link with minimum info: JSON { "client": "myClient", "recipientEmails": ["john.doe@acme.com", "joe.bloggs@acme.com"] } A plain text message property can be optionally provided in the request body to customise the sent email. Also, a locale property can be optionally provided in the request body to send the emails in a particular language (if the locale is supported by Alfresco). For example, to email a shared link with a messages and a locale: JSON { "client": "myClient", "recipientEmails": ["john.doe@acme.com", "joe.bloggs@acme.com"], "message": "myMessage", "locale":"en-GB" } Note: The client must be registered before you can send a shared link email. See [server documentation]. However, out-of-the-box share is registered as a default client, so …</p>
     * <p><strong>REST:</strong> POST /shared-links/{sharedId}/email; operationId: emailSharedLink.</p>
     *
     * @param sharedId RU: идентификатор shared link. Обязательный параметр. EN: The identifier of a shared link to a file.. Required.
     * @param sharedLinkBodyEmail RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The shared link email to send.. Required.
     */

    @PostExchange(url = "/shared-links/{sharedId}/email")
    Void emailSharedLink(@PathVariable("sharedId") String sharedId, @RequestBody SharedLinkBodyEmail sharedLinkBodyEmail);
}
