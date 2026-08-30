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
 * <p><strong>RU:</strong> Низкоуровневый HTTP-интерфейс VersionsApi отображает операции Alfresco REST API на Spring HTTP Service. В обычном прикладном коде предпочтительнее high-level сервисы; этот интерфейс нужен для параметров и endpoint, не покрытых удобной обёрткой.</p>
 * <p><strong>EN:</strong> Low-level HTTP interface VersionsApi maps Alfresco REST operations to Spring HTTP Service methods. Application code will normally prefer high-level services; use this interface for endpoint-level control or operations without a high-level wrapper.</p>
 * <p><strong>RU:</strong> HTTP-ошибки преобразуются общей конфигурацией клиента в AlfrescoApiException.</p>
 * <p><strong>EN:</strong> HTTP errors are converted by the shared client configuration into AlfrescoApiException.</p>
 */
public interface VersionsApi {

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Gets the version history as an ordered list of versions for the specified nodeId. The list is ordered in descending modified order. So the most recent version is first and the original version is last in the list.</p>
     * <p><strong>REST:</strong> GET /nodes/{nodeId}/versions; operationId: listVersionHistory.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the version node. The following optional fields can be requested: * properties * aspectNames. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listVersionHistory в generated-модели VersionPaging. EN: Alfresco response for listVersionHistory represented as VersionPaging.
     */

    @GetExchange(url = "/nodes/{nodeId}/versions")
    VersionPaging listVersionHistory(@PathVariable("nodeId") String nodeId, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "fields", required = false) List<String> fields, @RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Gets the version information for versionId of file node nodeId.</p>
     * <p><strong>REST:</strong> GET /nodes/{nodeId}/versions/{versionId}; operationId: getVersion.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param versionId RU: идентификатор версии. Обязательный параметр. EN: The identifier of a version, ie. version label, within the version history of a node.. Required.
     * @return RU: ответ Alfresco для getVersion в generated-модели VersionEntry. EN: Alfresco response for getVersion represented as VersionEntry.
     */

    @GetExchange(url = "/nodes/{nodeId}/versions/{versionId}")
    VersionEntry getVersion(@PathVariable("nodeId") String nodeId, @PathVariable("versionId") String versionId);

        /**
     * <p><strong>RU:</strong> Удаляет ресурс или связь через Alfresco REST API; обратимость зависит от конкретной операции и её параметров.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Delete the version identified by versionId and nodeId*. If the version is successfully deleted then the content and metadata for that versioned node will be deleted and will no longer appear in the version history. This operation cannot be undone. If the most recent version is deleted the live node will revert to the next most recent version. We currently do not allow the last version to be deleted. If you wish to clear the history then you can remove the "cm:versionable" aspect (via update node) which will also disable versioning. In this case, you can re-enable versioning by adding back the "cm:versionable" aspect or using the version params (majorVersion and comment) on a subsequent file content update.</p>
     * <p><strong>REST:</strong> DELETE /nodes/{nodeId}/versions/{versionId}; operationId: deleteVersion.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param versionId RU: идентификатор версии. Обязательный параметр. EN: The identifier of a version, ie. version label, within the version history of a node.. Required.
     */

    @DeleteExchange(url = "/nodes/{nodeId}/versions/{versionId}")
    Void deleteVersion(@PathVariable("nodeId") String nodeId, @PathVariable("versionId") String versionId);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Gets the version content for versionId of file node nodeId.</p>
     * <p><strong>REST:</strong> GET /nodes/{nodeId}/versions/{versionId}/content; operationId: getVersionContent.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param versionId RU: идентификатор версии. Обязательный параметр. EN: The identifier of a version, ie. version label, within the version history of a node.. Required.
     * @param attachment RU: управляет выдачей содержимого как attachment. Необязательный параметр, если аннотация допускает null. EN: true enables a web browser to download the file as an attachment. false means a web browser may preview the file in a new tab or window. You can only set this parameter to false if the content type of the file is in the supported list; for example, certain image files and PDF files. If the content type is not supported for preview, then a value of false is ignored, and the attachment will be returned in the response.. Optional when the method annotation allows null.
     * @param ifModifiedSince RU: HTTP If-Modified-Since для условного получения содержимого. Необязательный параметр, если аннотация допускает null. EN: Value of parameter ifModifiedSince for this REST operation. Optional when the method annotation allows null.
     * @param range RU: HTTP Range для частичного чтения содержимого. Необязательный параметр, если аннотация допускает null. EN: Value of parameter range for this REST operation. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для getVersionContent в generated-модели byte[]. EN: Alfresco response for getVersionContent represented as byte[].
     */

    @GetExchange(url = "/nodes/{nodeId}/versions/{versionId}/content")
    byte[] getVersionContent(@PathVariable("nodeId") String nodeId, @PathVariable("versionId") String versionId, @RequestParam(value = "attachment", required = false) Boolean attachment, @RequestHeader(value = "If-Modified-Since", required = false) OffsetDateTime ifModifiedSince, @RequestHeader(value = "Range", required = false) String range);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию POST /nodes/{nodeId}/versions/{versionId}/request-direct-access-url Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.1 and newer versions. Generate a direct access content url for the given nodeId.</p>
     * <p><strong>REST:</strong> POST /nodes/{nodeId}/versions/{versionId}/request-direct-access-url; operationId: requestVersionDirectAccessUrl.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param versionId RU: идентификатор версии. Обязательный параметр. EN: The identifier of a version, ie. version label, within the version history of a node.. Required.
     * @param requestContentUrlBodyCreate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Необязательный параметр, если аннотация допускает null. EN: Direct Access URL options and flags. Note: It is up to the actual ContentStore implementation if it can fulfil this request or not. The attachment flag controls the download method of the generated URL. It defaults to true, meaning the value for the Content Disposition response header will be attachment. true enables a web browser to download the file as an attachment. false means a web browser may preview the file in a new tab or window. You can only set this parameter to false if the content type of the file is in the supported list; for example, certain image files and PDF files. If the content type is not supported for preview, then a value of false is ignored, and the attachment will be returned in the response.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для requestVersionDirectAccessUrl в generated-модели DirectAccessUrlEntry. EN: Alfresco response for requestVersionDirectAccessUrl represented as DirectAccessUrlEntry.
     */

    @PostExchange(url = "/nodes/{nodeId}/versions/{versionId}/request-direct-access-url")
    DirectAccessUrlEntry requestVersionDirectAccessUrl(@PathVariable("nodeId") String nodeId, @PathVariable("versionId") String versionId, @RequestBody DirectAccessUrlBodyCreate requestContentUrlBodyCreate);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию POST /nodes/{nodeId}/versions/{versionId}/revert Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Attempts to revert the version identified by versionId and nodeId to the live node. If the node is successfully reverted then the content and metadata for that versioned node will be promoted to the live node and a new version will appear in the version history.</p>
     * <p><strong>REST:</strong> POST /nodes/{nodeId}/versions/{versionId}/revert; operationId: revertVersion.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param versionId RU: идентификатор версии. Обязательный параметр. EN: The identifier of a version, ie. version label, within the version history of a node.. Required.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param revertBody RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: Optionally, specify a version comment and whether this should be a major version, or not.. Required.
     * @return RU: ответ Alfresco для revertVersion в generated-модели VersionEntry. EN: Alfresco response for revertVersion represented as VersionEntry.
     */

    @PostExchange(url = "/nodes/{nodeId}/versions/{versionId}/revert")
    VersionEntry revertVersion(@PathVariable("nodeId") String nodeId, @PathVariable("versionId") String versionId, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody RevertBody revertBody);

        /**
     * <p><strong>RU:</strong> Создаёт ресурс или связь в Alfresco. Метод напрямую отражает REST-контракт и принимает generated DTO тела запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.0.0 and newer versions. An asynchronous request to create a rendition for version of file nodeId and versionId. The version rendition is specified by name id in the request body: JSON { "id":"doclib" } Multiple names may be specified as a comma separated list or using a list format: JSON [ { "id": "doclib" }, { "id": "avatar" } ]</p>
     * <p><strong>REST:</strong> POST /nodes/{nodeId}/versions/{versionId}/renditions; operationId: createVersionRendition.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param versionId RU: идентификатор версии. Обязательный параметр. EN: The identifier of a version, ie. version label, within the version history of a node.. Required.
     * @param renditionBodyCreate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The rendition "id".. Required.
     */

    @PostExchange(url = "/nodes/{nodeId}/versions/{versionId}/renditions")
    Void createVersionRendition(@PathVariable("nodeId") String nodeId, @PathVariable("versionId") String versionId, @RequestBody RenditionBodyCreate renditionBodyCreate);

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.0.0 and newer versions. Gets a list of the rendition information for each rendition of the version of file nodeId and versionId, including the rendition id. Each rendition returned has a status: CREATED means it is available to view or download, NOT_CREATED means the rendition can be requested. You can use the where parameter to filter the returned renditions by status. For example, the following where clause will return just the CREATED renditions: (status='CREATED')</p>
     * <p><strong>REST:</strong> GET /nodes/{nodeId}/versions/{versionId}/renditions; operationId: listVersionRenditions.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param versionId RU: идентификатор версии. Обязательный параметр. EN: The identifier of a version, ie. version label, within the version history of a node.. Required.
     * @param where RU: серверное выражение фильтрации Alfresco. Необязательный параметр, если аннотация допускает null. EN: A string to restrict the returned objects by using a predicate.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listVersionRenditions в generated-модели RenditionPaging. EN: Alfresco response for listVersionRenditions represented as RenditionPaging.
     */

    @GetExchange(url = "/nodes/{nodeId}/versions/{versionId}/renditions")
    RenditionPaging listVersionRenditions(@PathVariable("nodeId") String nodeId, @PathVariable("versionId") String versionId, @RequestParam(value = "where", required = false) String where);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.0.0 and newer versions. Gets the rendition information for renditionId of version of file nodeId and versionId.</p>
     * <p><strong>REST:</strong> GET /nodes/{nodeId}/versions/{versionId}/renditions/{renditionId}; operationId: getVersionRendition.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param versionId RU: идентификатор версии. Обязательный параметр. EN: The identifier of a version, ie. version label, within the version history of a node.. Required.
     * @param renditionId RU: идентификатор rendition. Обязательный параметр. EN: The name of a thumbnail rendition, for example *doclib*, or *pdf*.. Required.
     * @return RU: ответ Alfresco для getVersionRendition в generated-модели RenditionEntry. EN: Alfresco response for getVersionRendition represented as RenditionEntry.
     */

    @GetExchange(url = "/nodes/{nodeId}/versions/{versionId}/renditions/{renditionId}")
    RenditionEntry getVersionRendition(@PathVariable("nodeId") String nodeId, @PathVariable("versionId") String versionId, @PathVariable("renditionId") String renditionId);

        /**
     * <p><strong>RU:</strong> Удаляет ресурс или связь через Alfresco REST API; обратимость зависит от конкретной операции и её параметров.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.1.1 and newer versions. Delete the rendition for renditionId of version versionId of nodeId. If the rendition is successfully deleted then the content for that rendition node will be cleared.</p>
     * <p><strong>REST:</strong> DELETE /nodes/{nodeId}/versions/{versionId}/renditions/{renditionId}; operationId: deleteVersionRendition.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param versionId RU: идентификатор версии. Обязательный параметр. EN: The identifier of a version, ie. version label, within the version history of a node.. Required.
     * @param renditionId RU: идентификатор rendition. Обязательный параметр. EN: The name of a thumbnail rendition, for example *doclib*, or *pdf*.. Required.
     */

    @DeleteExchange(url = "/nodes/{nodeId}/versions/{versionId}/renditions/{renditionId}")
    Void deleteVersionRendition(@PathVariable("nodeId") String nodeId, @PathVariable("versionId") String versionId, @PathVariable("renditionId") String renditionId);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.0.0 and newer versions. Gets the rendition content for renditionId of version of file nodeId and versionId.</p>
     * <p><strong>REST:</strong> GET /nodes/{nodeId}/versions/{versionId}/renditions/{renditionId}/content; operationId: getVersionRenditionContent.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param versionId RU: идентификатор версии. Обязательный параметр. EN: The identifier of a version, ie. version label, within the version history of a node.. Required.
     * @param renditionId RU: идентификатор rendition. Обязательный параметр. EN: The name of a thumbnail rendition, for example *doclib*, or *pdf*.. Required.
     * @param attachment RU: управляет выдачей содержимого как attachment. Необязательный параметр, если аннотация допускает null. EN: true enables a web browser to download the file as an attachment. false means a web browser may preview the file in a new tab or window. You can only set this parameter to false if the content type of the file is in the supported list; for example, certain image files and PDF files. If the content type is not supported for preview, then a value of false is ignored, and the attachment will be returned in the response.. Optional when the method annotation allows null.
     * @param ifModifiedSince RU: HTTP If-Modified-Since для условного получения содержимого. Необязательный параметр, если аннотация допускает null. EN: Value of parameter ifModifiedSince for this REST operation. Optional when the method annotation allows null.
     * @param range RU: HTTP Range для частичного чтения содержимого. Необязательный параметр, если аннотация допускает null. EN: Value of parameter range for this REST operation. Optional when the method annotation allows null.
     * @param placeholder RU: значение параметра placeholder для данной REST-операции. Необязательный параметр, если аннотация допускает null. EN: If true and there is no rendition for this nodeId and renditionId, then the placeholder image for the mime type of this rendition is returned, rather than a 404 response.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для getVersionRenditionContent в generated-модели byte[]. EN: Alfresco response for getVersionRenditionContent represented as byte[].
     */

    @GetExchange(url = "/nodes/{nodeId}/versions/{versionId}/renditions/{renditionId}/content")
    byte[] getVersionRenditionContent(@PathVariable("nodeId") String nodeId, @PathVariable("versionId") String versionId, @PathVariable("renditionId") String renditionId, @RequestParam(value = "attachment", required = false) Boolean attachment, @RequestHeader(value = "If-Modified-Since", required = false) OffsetDateTime ifModifiedSince, @RequestHeader(value = "Range", required = false) String range, @RequestParam(value = "placeholder", required = false) Boolean placeholder);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию POST /nodes/{nodeId}/versions/{versionId}/renditions/{renditionId}/request-direct-access-url Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.2 and newer versions. Generate a direct access content url for the given nodeId.</p>
     * <p><strong>REST:</strong> POST /nodes/{nodeId}/versions/{versionId}/renditions/{renditionId}/request-direct-access-url; operationId: requestVersionRenditionDirectAccessUrl.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param versionId RU: идентификатор версии. Обязательный параметр. EN: The identifier of a version, ie. version label, within the version history of a node.. Required.
     * @param renditionId RU: идентификатор rendition. Обязательный параметр. EN: The name of a thumbnail rendition, for example *doclib*, or *pdf*.. Required.
     * @param requestContentUrlBodyCreate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Необязательный параметр, если аннотация допускает null. EN: Direct Access URL options and flags. It can be used to set the attachment flag, which controls the download method of the generated URL (attachment DAU vs embedded DAU). It defaults to true, meaning the value for the Content Disposition response header will be attachment. Note: It is up to the actual ContentStore implementation if it can fulfil this request or not.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для requestVersionRenditionDirectAccessUrl в generated-модели DirectAccessUrlEntry. EN: Alfresco response for requestVersionRenditionDirectAccessUrl represented as DirectAccessUrlEntry.
     */

    @PostExchange(url = "/nodes/{nodeId}/versions/{versionId}/renditions/{renditionId}/request-direct-access-url")
    DirectAccessUrlEntry requestVersionRenditionDirectAccessUrl(@PathVariable("nodeId") String nodeId, @PathVariable("versionId") String versionId, @PathVariable("renditionId") String renditionId, @RequestBody DirectAccessUrlBodyCreate requestContentUrlBodyCreate);
}
