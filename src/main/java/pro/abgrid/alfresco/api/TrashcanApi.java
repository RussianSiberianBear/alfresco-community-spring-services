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
 * <p><strong>RU:</strong> Низкоуровневый HTTP-интерфейс TrashcanApi отображает операции Alfresco REST API на Spring HTTP Service. В обычном прикладном коде предпочтительнее high-level сервисы; этот интерфейс нужен для параметров и endpoint, не покрытых удобной обёрткой.</p>
 * <p><strong>EN:</strong> Low-level HTTP interface TrashcanApi maps Alfresco REST operations to Spring HTTP Service methods. Application code will normally prefer high-level services; use this interface for endpoint-level control or operations without a high-level wrapper.</p>
 * <p><strong>RU:</strong> HTTP-ошибки преобразуются общей конфигурацией клиента в AlfrescoApiException.</p>
 * <p><strong>EN:</strong> HTTP errors are converted by the shared client configuration into AlfrescoApiException.</p>
 */
public interface TrashcanApi {

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Gets a list of deleted nodes for the current user. If the current user is an administrator deleted nodes for all users will be returned. The list of deleted nodes will be ordered with the most recently deleted node at the top of the list.</p>
     * <p><strong>REST:</strong> GET /deleted-nodes; operationId: listDeletedNodes.</p>
     *
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the node. The following optional fields can be requested: * allowableOperations * aspectNames * association * isLink * isFavorite * isDirectLinkEnabled * isLocked * path * properties * permissions. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listDeletedNodes в generated-модели DeletedNodesPaging. EN: Alfresco response for listDeletedNodes represented as DeletedNodesPaging.
     */

    @GetExchange(url = "/deleted-nodes")
    DeletedNodesPaging listDeletedNodes(@RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "include", required = false) List<String> include);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Gets the specific deleted node nodeId.</p>
     * <p><strong>REST:</strong> GET /deleted-nodes/{nodeId}; operationId: getDeletedNode.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the node. The following optional fields can be requested: * allowableOperations * association * isLink * isFavorite * isDirectLinkEnabled * isLocked * path * permissions * definition. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для getDeletedNode в generated-модели DeletedNodeEntry. EN: Alfresco response for getDeletedNode represented as DeletedNodeEntry.
     */

    @GetExchange(url = "/deleted-nodes/{nodeId}")
    DeletedNodeEntry getDeletedNode(@PathVariable("nodeId") String nodeId, @RequestParam(value = "include", required = false) List<String> include);

        /**
     * <p><strong>RU:</strong> Удаляет ресурс или связь через Alfresco REST API; обратимость зависит от конкретной операции и её параметров.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Permanently deletes the deleted node nodeId.</p>
     * <p><strong>REST:</strong> DELETE /deleted-nodes/{nodeId}; operationId: deleteDeletedNode.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     */

    @DeleteExchange(url = "/deleted-nodes/{nodeId}")
    Void deleteDeletedNode(@PathVariable("nodeId") String nodeId);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Gets the content of the deleted node with identifier nodeId.</p>
     * <p><strong>REST:</strong> GET /deleted-nodes/{nodeId}/content; operationId: getDeletedNodeContent.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param attachment RU: управляет выдачей содержимого как attachment. Необязательный параметр, если аннотация допускает null. EN: true enables a web browser to download the file as an attachment. false means a web browser may preview the file in a new tab or window. You can only set this parameter to false if the content type of the file is in the supported list; for example, certain image files and PDF files. If the content type is not supported for preview, then a value of false is ignored, and the attachment will be returned in the response.. Optional when the method annotation allows null.
     * @param ifModifiedSince RU: HTTP If-Modified-Since для условного получения содержимого. Необязательный параметр, если аннотация допускает null. EN: Value of parameter ifModifiedSince for this REST operation. Optional when the method annotation allows null.
     * @param range RU: HTTP Range для частичного чтения содержимого. Необязательный параметр, если аннотация допускает null. EN: Value of parameter range for this REST operation. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для getDeletedNodeContent в generated-модели byte[]. EN: Alfresco response for getDeletedNodeContent represented as byte[].
     */

    @GetExchange(url = "/deleted-nodes/{nodeId}/content")
    byte[] getDeletedNodeContent(@PathVariable("nodeId") String nodeId, @RequestParam(value = "attachment", required = false) Boolean attachment, @RequestHeader(value = "If-Modified-Since", required = false) OffsetDateTime ifModifiedSince, @RequestHeader(value = "Range", required = false) String range);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию POST /deleted-nodes/{nodeId}/request-direct-access-url Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.1 and newer versions. Generate a direct access content url for the given nodeId.</p>
     * <p><strong>REST:</strong> POST /deleted-nodes/{nodeId}/request-direct-access-url; operationId: requestDeletedNodeDirectAccessUrl.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param requestContentUrlBodyCreate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Необязательный параметр, если аннотация допускает null. EN: Direct Access URL options and flags. Note: It is up to the actual ContentStore implementation if it can fulfil this request or not. The attachment flag controls the download method of the generated URL. It defaults to true, meaning the value for the Content Disposition response header will be attachment. true enables a web browser to download the file as an attachment. false means a web browser may preview the file in a new tab or window. You can only set this parameter to false if the content type of the file is in the supported list; for example, certain image files and PDF files. If the content type is not supported for preview, then a value of false is ignored, and the attachment will be returned in the response.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для requestDeletedNodeDirectAccessUrl в generated-модели DirectAccessUrlEntry. EN: Alfresco response for requestDeletedNodeDirectAccessUrl represented as DirectAccessUrlEntry.
     */

    @PostExchange(url = "/deleted-nodes/{nodeId}/request-direct-access-url")
    DirectAccessUrlEntry requestDeletedNodeDirectAccessUrl(@PathVariable("nodeId") String nodeId, @RequestBody DirectAccessUrlBodyCreate requestContentUrlBodyCreate);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию POST /deleted-nodes/{nodeId}/restore Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Attempts to restore the deleted node nodeId to its original location or to a new location. If the node is successfully restored to its former primary parent, then only the primary child association will be restored, including recursively for any primary children. It should be noted that no other secondary child associations or peer associations will be restored, for any of the nodes within the primary parent-child hierarchy of restored nodes, irrespective of whether these associations were to nodes within or outside of the restored hierarchy. Also, any previously shared link will not be restored since it is deleted at the time of delete of each node.</p>
     * <p><strong>REST:</strong> POST /deleted-nodes/{nodeId}/restore; operationId: restoreDeletedNode.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param deletedNodeBodyRestore RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Необязательный параметр, если аннотация допускает null. EN: Optional restore target. Omit the request body to restore to the original location. Supply targetParentId (and optionally assocType) only when restoring to a new location.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для restoreDeletedNode в generated-модели NodeEntry. EN: Alfresco response for restoreDeletedNode represented as NodeEntry.
     */

    @PostExchange(url = "/deleted-nodes/{nodeId}/restore")
    NodeEntry restoreDeletedNode(@PathVariable("nodeId") String nodeId, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody(required = false) DeletedNodeBodyRestore deletedNodeBodyRestore);

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Gets a list of the rendition information for each rendition of the file nodeId, including the rendition id. Each rendition returned has a status: CREATED means it is available to view or download, NOT_CREATED means the rendition can be requested. You can use the where parameter to filter the returned renditions by status. For example, the following where clause will return just the CREATED renditions: (status='CREATED')</p>
     * <p><strong>REST:</strong> GET /deleted-nodes/{nodeId}/renditions; operationId: listDeletedNodeRenditions.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param where RU: серверное выражение фильтрации Alfresco. Необязательный параметр, если аннотация допускает null. EN: A string to restrict the returned objects by using a predicate.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listDeletedNodeRenditions в generated-модели RenditionPaging. EN: Alfresco response for listDeletedNodeRenditions represented as RenditionPaging.
     */

    @GetExchange(url = "/deleted-nodes/{nodeId}/renditions")
    RenditionPaging listDeletedNodeRenditions(@PathVariable("nodeId") String nodeId, @RequestParam(value = "where", required = false) String where);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Gets the rendition information for renditionId of file nodeId.</p>
     * <p><strong>REST:</strong> GET /deleted-nodes/{nodeId}/renditions/{renditionId}; operationId: getArchivedNodeRendition.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param renditionId RU: идентификатор rendition. Обязательный параметр. EN: The name of a thumbnail rendition, for example *doclib*, or *pdf*.. Required.
     * @return RU: ответ Alfresco для getArchivedNodeRendition в generated-модели RenditionEntry. EN: Alfresco response for getArchivedNodeRendition represented as RenditionEntry.
     */

    @GetExchange(url = "/deleted-nodes/{nodeId}/renditions/{renditionId}")
    RenditionEntry getArchivedNodeRendition(@PathVariable("nodeId") String nodeId, @PathVariable("renditionId") String renditionId);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Gets the rendition content for renditionId of file nodeId.</p>
     * <p><strong>REST:</strong> GET /deleted-nodes/{nodeId}/renditions/{renditionId}/content; operationId: getArchivedNodeRenditionContent.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param renditionId RU: идентификатор rendition. Обязательный параметр. EN: The name of a thumbnail rendition, for example *doclib*, or *pdf*.. Required.
     * @param attachment RU: управляет выдачей содержимого как attachment. Необязательный параметр, если аннотация допускает null. EN: true enables a web browser to download the file as an attachment. false means a web browser may preview the file in a new tab or window. You can only set this parameter to false if the content type of the file is in the supported list; for example, certain image files and PDF files. If the content type is not supported for preview, then a value of false is ignored, and the attachment will be returned in the response.. Optional when the method annotation allows null.
     * @param ifModifiedSince RU: HTTP If-Modified-Since для условного получения содержимого. Необязательный параметр, если аннотация допускает null. EN: Value of parameter ifModifiedSince for this REST operation. Optional when the method annotation allows null.
     * @param range RU: HTTP Range для частичного чтения содержимого. Необязательный параметр, если аннотация допускает null. EN: Value of parameter range for this REST operation. Optional when the method annotation allows null.
     * @param placeholder RU: значение параметра placeholder для данной REST-операции. Необязательный параметр, если аннотация допускает null. EN: If true and there is no rendition for this nodeId and renditionId, then the placeholder image for the mime type of this rendition is returned, rather than a 404 response.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для getArchivedNodeRenditionContent в generated-модели byte[]. EN: Alfresco response for getArchivedNodeRenditionContent represented as byte[].
     */

    @GetExchange(url = "/deleted-nodes/{nodeId}/renditions/{renditionId}/content")
    byte[] getArchivedNodeRenditionContent(@PathVariable("nodeId") String nodeId, @PathVariable("renditionId") String renditionId, @RequestParam(value = "attachment", required = false) Boolean attachment, @RequestHeader(value = "If-Modified-Since", required = false) OffsetDateTime ifModifiedSince, @RequestHeader(value = "Range", required = false) String range, @RequestParam(value = "placeholder", required = false) Boolean placeholder);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию POST /deleted-nodes/{nodeId}/renditions/{renditionId}/request-direct-access-url Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.1 and newer versions. Generate a direct access content url for the given nodeId.</p>
     * <p><strong>REST:</strong> POST /deleted-nodes/{nodeId}/renditions/{renditionId}/request-direct-access-url; operationId: requestArchivedNodeRenditionDirectAccessUrl.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param renditionId RU: идентификатор rendition. Обязательный параметр. EN: The name of a thumbnail rendition, for example *doclib*, or *pdf*.. Required.
     * @param requestContentUrlBodyCreate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Необязательный параметр, если аннотация допускает null. EN: Direct Access URL options and flags. Note: It is up to the actual ContentStore implementation if it can fulfil this request or not. The attachment flag controls the download method of the generated URL. It defaults to true, meaning the value for the Content Disposition response header will be attachment. true enables a web browser to download the file as an attachment. false means a web browser may preview the file in a new tab or window. You can only set this parameter to false if the content type of the file is in the supported list; for example, certain image files and PDF files. If the content type is not supported for preview, then a value of false is ignored, and the attachment will be returned in the response.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для requestArchivedNodeRenditionDirectAccessUrl в generated-модели DirectAccessUrlEntry. EN: Alfresco response for requestArchivedNodeRenditionDirectAccessUrl represented as DirectAccessUrlEntry.
     */

    @PostExchange(url = "/deleted-nodes/{nodeId}/renditions/{renditionId}/request-direct-access-url")
    DirectAccessUrlEntry requestArchivedNodeRenditionDirectAccessUrl(@PathVariable("nodeId") String nodeId, @PathVariable("renditionId") String renditionId, @RequestBody DirectAccessUrlBodyCreate requestContentUrlBodyCreate);
}
