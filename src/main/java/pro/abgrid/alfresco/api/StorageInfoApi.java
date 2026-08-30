package pro.abgrid.alfresco.api;

import pro.abgrid.alfresco.dto.core.ArchiveContentRequest;
import pro.abgrid.alfresco.dto.core.ContentStorageInfo;
import pro.abgrid.alfresco.dto.core.RestoreArchivedContentRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * <p><strong>RU:</strong> Низкоуровневый HTTP-интерфейс StorageInfoApi отображает операции Alfresco REST API на Spring HTTP Service. В обычном прикладном коде предпочтительнее high-level сервисы; этот интерфейс нужен для параметров и endpoint, не покрытых удобной обёрткой.</p>
 * <p><strong>EN:</strong> Low-level HTTP interface StorageInfoApi maps Alfresco REST operations to Spring HTTP Service methods. Application code will normally prefer high-level services; use this interface for endpoint-level control or operations without a high-level wrapper.</p>
 * <p><strong>RU:</strong> HTTP-ошибки преобразуются общей конфигурацией клиента в AlfrescoApiException.</p>
 * <p><strong>EN:</strong> HTTP errors are converted by the shared client configuration into AlfrescoApiException.</p>
 */
public interface StorageInfoApi {

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.2.0 and newer versions. It also requires at least one specific implementation of underlying functionality in Cloud Connector(s). Gets storage properties for given content. Please find below sample responses for this endpoint when Alfresco Content Connector for AWS S3 is installed. Similar responses will be returned when Alfresco Content Connector for Azure Blob is installed, albeit it with some native storage properties with x-ms- prefix instead of x-amz- prefix. Standard storage class: json { "entry": { "storageProperties": { "x-alf-archived": "false" }, "id": "cm:content" } } Intelligent tiering storage class: json { "entry": { "storageProperties": { "x-alf-archived": "false", "x-amz-storage-class": "INTELLIGENT_TIERING" }, "id": "cm:content" } } Glacier archive storage class (no restore request ongoing or submitted): json { "entry": { "storageProperties": { "x-alf-archived": "true", "x-amz-storage-class": "GLACIER" }, "id": "cm:content"…</p>
     * <p><strong>REST:</strong> GET /nodes/{nodeId}/storage-info/{contentPropName}; operationId: getStorageProperties.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param contentPropName RU: QName content-свойства узла. Обязательный параметр. EN: The namespace-prefix property name of content. Delimiter between namespace-prefix and property name can be either colon (':') or underscore ('_') character (e.g., 'cm:content' or 'cm_content').. Required.
     * @return RU: ответ Alfresco для getStorageProperties в generated-модели ContentStorageInfo. EN: Alfresco response for getStorageProperties represented as ContentStorageInfo.
     */

    @GetExchange(url = "/nodes/{nodeId}/storage-info/{contentPropName}")
    ContentStorageInfo getStorageProperties(@PathVariable("nodeId") String nodeId, @PathVariable("contentPropName") String contentPropName);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.2.0 and newer versions. It also requires at least one specific implementation of underlying functionality in Cloud Connector(s). Gets storage properties for given version content. Please find below sample responses for this endpoint when Alfresco Content Connector for AWS S3 is installed. Similar responses will be returned when Alfresco Content Connector for Azure Blob is installed, albeit it with some native storage properties with x-ms- prefix instead of x-amz- prefix. Standard storage class: json { "entry": { "storageProperties": { "x-alf-archived": "false" }, "id": "cm:content" } } Intelligent tiering storage class: json { "entry": { "storageProperties": { "x-alf-archived": "false", "x-amz-storage-class": "INTELLIGENT_TIERING" }, "id": "cm:content" } } Glacier archive storage class (no restore request ongoing or submitted): json { "entry": { "storageProperties": { "x-alf-archived": "true", "x-amz-storage-class": "GLACIER" }, "id": "cm:…</p>
     * <p><strong>REST:</strong> GET /nodes/{nodeId}/versions/{versionId}/storage-info/{contentPropName}; operationId: getVersionStorageProperties.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param versionId RU: идентификатор версии. Обязательный параметр. EN: The identifier of a version, ie. version label, within the version history of a node.. Required.
     * @param contentPropName RU: QName content-свойства узла. Обязательный параметр. EN: The namespace-prefix property name of content. Delimiter between namespace-prefix and property name can be either colon (':') or underscore ('_') character (e.g., 'cm:content' or 'cm_content').. Required.
     * @return RU: ответ Alfresco для getVersionStorageProperties в generated-модели ContentStorageInfo. EN: Alfresco response for getVersionStorageProperties represented as ContentStorageInfo.
     */

    @GetExchange(url = "/nodes/{nodeId}/versions/{versionId}/storage-info/{contentPropName}")
    ContentStorageInfo getVersionStorageProperties(@PathVariable("nodeId") String nodeId, @PathVariable("versionId") String versionId, @PathVariable("contentPropName") String contentPropName);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию POST /nodes/{nodeId}/storage-info/{contentPropName}/archive Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.2.0 and newer versions. It also requires at least one specific implementation of underlying functionality in Cloud Connector(s). Request to send given content to archive.</p>
     * <p><strong>REST:</strong> POST /nodes/{nodeId}/storage-info/{contentPropName}/archive; operationId: requestArchiveContent.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param contentPropName RU: QName content-свойства узла. Обязательный параметр. EN: The namespace-prefix property name of content. Delimiter between namespace-prefix and property name can be either colon (':') or underscore ('_') character (e.g., 'cm:content' or 'cm_content').. Required.
     * @param archiveContentRequest RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Необязательный параметр, если аннотация допускает null. EN: Archive content request parameters - currently not supported by any Alfresco Cloud Connector. Body is not mandatory. Request body example: JSON { "archiveParams": { "x-amz-storage-class": "GLACIER" } }. Optional when the method annotation allows null.
     */

    @PostExchange(url = "/nodes/{nodeId}/storage-info/{contentPropName}/archive")
    Void requestArchiveContent(@PathVariable("nodeId") String nodeId, @PathVariable("contentPropName") String contentPropName, @RequestBody ArchiveContentRequest archiveContentRequest);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию POST /nodes/{nodeId}/versions/{versionId}/storage-info/{contentPropName}/archive Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.2.0 and newer versions. It also requires at least one specific implementation of underlying functionality in Cloud Connector(s). Request to send given version content to archive.</p>
     * <p><strong>REST:</strong> POST /nodes/{nodeId}/versions/{versionId}/storage-info/{contentPropName}/archive; operationId: requestArchiveVersionContent.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param versionId RU: идентификатор версии. Обязательный параметр. EN: The identifier of a version, ie. version label, within the version history of a node.. Required.
     * @param contentPropName RU: QName content-свойства узла. Обязательный параметр. EN: The namespace-prefix property name of content. Delimiter between namespace-prefix and property name can be either colon (':') or underscore ('_') character (e.g., 'cm:content' or 'cm_content').. Required.
     * @param archiveContentRequest RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Необязательный параметр, если аннотация допускает null. EN: Archive content request parameters - currently not supported by any Alfresco Cloud Connector. Body is not mandatory. Request body example: JSON { "archiveParams": { "x-amz-storage-class": "GLACIER" } }. Optional when the method annotation allows null.
     */

    @PostExchange(url = "/nodes/{nodeId}/versions/{versionId}/storage-info/{contentPropName}/archive")
    Void requestArchiveVersionContent(@PathVariable("nodeId") String nodeId, @PathVariable("versionId") String versionId, @PathVariable("contentPropName") String contentPropName, @RequestBody ArchiveContentRequest archiveContentRequest);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию POST /nodes/{nodeId}/storage-info/{contentPropName}/archive-restore Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.2.0 and newer versions. It also requires at least one specific implementation of underlying functionality in Cloud Connector(s). Request to restore given content from archive.</p>
     * <p><strong>REST:</strong> POST /nodes/{nodeId}/storage-info/{contentPropName}/archive-restore; operationId: requestRestoreContentFromArchive.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param contentPropName RU: QName content-свойства узла. Обязательный параметр. EN: The namespace-prefix property name of content. Delimiter between namespace-prefix and property name can be either colon (':') or underscore ('_') character (e.g., 'cm:content' or 'cm_content').. Required.
     * @param restoreArchivedContentRequest RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Необязательный параметр, если аннотация допускает null. EN: Restore content from archive request parameters. At the moment there is one parameter being supported which is restore priority. 'High' restore priority translates to 'Expedited' Glacier restore tier in AWS S3 and 'High' rehydrate priority in Azure Blob. 'Standard' restore priority translates to 'Standard' Glacier restore tier in AWS S3 and 'Standard' rehydrate priority in Azure Blob. Body is not mandatory. High restore priority request body example: JSON { "restorePriority": "High" } Standard restore priority request body example: JSON { "restorePriority": "Standard" }. Optional when the method annotation allows null.
     */

    @PostExchange(url = "/nodes/{nodeId}/storage-info/{contentPropName}/archive-restore")
    Void requestRestoreContentFromArchive(@PathVariable("nodeId") String nodeId, @PathVariable("contentPropName") String contentPropName, @RequestBody RestoreArchivedContentRequest restoreArchivedContentRequest);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию POST /nodes/{nodeId}/versions/{versionId}/storage-info/{contentPropName}/archive-restore Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.2.0 and newer versions. It also requires at least one specific implementation of underlying functionality in Cloud Connector(s). Request to restore given version content from archive.</p>
     * <p><strong>REST:</strong> POST /nodes/{nodeId}/versions/{versionId}/storage-info/{contentPropName}/archive-restore; operationId: requestRestoreVersionContentFromArchive.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param versionId RU: идентификатор версии. Обязательный параметр. EN: The identifier of a version, ie. version label, within the version history of a node.. Required.
     * @param contentPropName RU: QName content-свойства узла. Обязательный параметр. EN: The namespace-prefix property name of content. Delimiter between namespace-prefix and property name can be either colon (':') or underscore ('_') character (e.g., 'cm:content' or 'cm_content').. Required.
     * @param restoreArchivedContentRequest RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Необязательный параметр, если аннотация допускает null. EN: Restore content from archive request parameters. At the moment there is one parameter being supported which is restore priority. 'High' restore priority translates to 'Expedited' Glacier restore tier in AWS S3 and 'High' rehydrate priority in Azure Blob. 'Standard' restore priority translates to 'Standard' Glacier restore tier in AWS S3 and 'Standard' rehydrate priority in Azure Blob. Body is not mandatory. High restore priority request body example: JSON { "restorePriority": "High" } Standard restore priority request body example: JSON { "restorePriority": "Standard" }. Optional when the method annotation allows null.
     */

    @PostExchange(url = "/nodes/{nodeId}/versions/{versionId}/storage-info/{contentPropName}/archive-restore")
    Void requestRestoreVersionContentFromArchive(@PathVariable("nodeId") String nodeId, @PathVariable("versionId") String versionId, @PathVariable("contentPropName") String contentPropName, @RequestBody RestoreArchivedContentRequest restoreArchivedContentRequest);
}
