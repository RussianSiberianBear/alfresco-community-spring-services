package pro.abgrid.alfresco.api;

import pro.abgrid.alfresco.dto.core.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

/**
 * <p><strong>RU:</strong> Низкоуровневый HTTP-интерфейс AuditApi отображает операции Alfresco REST API на Spring HTTP Service. В обычном прикладном коде предпочтительнее high-level сервисы; этот интерфейс нужен для параметров и endpoint, не покрытых удобной обёрткой.</p>
 * <p><strong>EN:</strong> Low-level HTTP interface AuditApi maps Alfresco REST operations to Spring HTTP Service methods. Application code will normally prefer high-level services; use this interface for endpoint-level control or operations without a high-level wrapper.</p>
 * <p><strong>RU:</strong> HTTP-ошибки преобразуются общей конфигурацией клиента в AlfrescoApiException.</p>
 * <p><strong>EN:</strong> HTTP errors are converted by the shared client configuration into AlfrescoApiException.</p>
 */
public interface AuditApi {

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2.2 and newer versions. Gets a list of audit applications in this repository. This list may include pre-configured audit applications, if enabled, such as: * alfresco-access * CMISChangeLog * Alfresco Tagging Service * Alfresco Sync Service (used by Enterprise Cloud Sync) You must have admin rights to retrieve audit information.</p>
     * <p><strong>REST:</strong> GET /audit-applications; operationId: listAuditApps.</p>
     *
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listAuditApps в generated-модели AuditAppPaging. EN: Alfresco response for listAuditApps represented as AuditAppPaging.
     */

    @GetExchange(url = "/audit-applications")
    AuditAppPaging listAuditApps(@RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2.2 and newer versions. Get status of an audit application auditApplicationId. You must have admin rights to retrieve audit information. You can use the include parameter to return the minimum and/or maximum audit record id for the application.</p>
     * <p><strong>REST:</strong> GET /audit-applications/{auditApplicationId}; operationId: getAuditApp.</p>
     *
     * @param auditApplicationId RU: идентификатор audit-приложения. Обязательный параметр. EN: The identifier of an audit application.. Required.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Also include the current minimum and/or maximum audit entry ids for the application. The following optional fields can be requested: * max * min. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для getAuditApp в generated-модели AuditAppEntry. EN: Alfresco response for getAuditApp represented as AuditAppEntry.
     */

    @GetExchange(url = "/audit-applications/{auditApplicationId}")
    AuditAppEntry getAuditApp(@PathVariable("auditApplicationId") String auditApplicationId, @RequestParam(value = "fields", required = false) List<String> fields, @RequestParam(value = "include", required = false) List<String> include);

        /**
     * <p><strong>RU:</strong> Изменяет существующий ресурс Alfresco согласно REST-контракту и возвращает подтверждённое сервером состояние, если endpoint имеет ответ.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2.2 and newer versions. Disable or re-enable the audit application auditApplicationId. New audit entries will not be created for a disabled audit application until it is re-enabled (and system-wide auditing is also enabled). Note, it is still possible to query &amp;/or delete any existing audit entries even if auditing is disabled for the audit application. You must have admin rights to update audit application.</p>
     * <p><strong>REST:</strong> PUT /audit-applications/{auditApplicationId}; operationId: updateAuditApp.</p>
     *
     * @param auditApplicationId RU: идентификатор audit-приложения. Обязательный параметр. EN: The identifier of an audit application.. Required.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param auditAppBodyUpdate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The audit application to update.. Required.
     * @return RU: ответ Alfresco для updateAuditApp в generated-модели AuditAppEntry. EN: Alfresco response for updateAuditApp represented as AuditAppEntry.
     */

    @PutExchange(url = "/audit-applications/{auditApplicationId}")
    AuditAppEntry updateAuditApp(@PathVariable("auditApplicationId") String auditApplicationId, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody AuditBodyUpdate auditAppBodyUpdate);

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2.2 and newer versions. Gets a list of audit entries for audit application auditApplicationId. You can use the include parameter to return additional values information. The list can be filtered by one or more of: * createdByUser person id * createdAt inclusive time period * id inclusive range of ids * valuesKey audit entry values contains the exact matching key * valuesValue audit entry values contains the exact matching value The default sort order is createdAt ascending, but you can use an optional ASC or DESC modifier to specify an ascending or descending sort order. For example, specifying orderBy=createdAt DESC returns audit entries in descending createdAt order. You must have admin rights to retrieve audit information.</p>
     * <p><strong>REST:</strong> GET /audit-applications/{auditApplicationId}/audit-entries; operationId: listAuditEntriesForAuditApp.</p>
     *
     * @param auditApplicationId RU: идентификатор audit-приложения. Обязательный параметр. EN: The identifier of an audit application.. Required.
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param omitTotalItems RU: если true, сервер может не вычислять totalItems. Необязательный параметр, если аннотация допускает null. EN: A boolean to control if the response provides the total numbers of items in the collection. If not supplied then the default value is false.. Optional when the method annotation allows null.
     * @param orderBy RU: серверные выражения сортировки. Необязательный параметр, если аннотация допускает null. EN: A string to control the order of the entities returned in a list. You can use the orderBy parameter to sort the list by one or more fields. Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order. To sort the entities in a specific order, you can use the ASC and DESC keywords for any field.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param where RU: серверное выражение фильтрации Alfresco. Необязательный параметр, если аннотация допускает null. EN: Optionally filter the list. Here are some examples: * where=(createdByUser='jbloggs') * where=(id BETWEEN ('1234', '4321')) * where=(createdAt BETWEEN ('2017-06-02T12:13:51.593+01:00' , '2017-06-04T10:05:16.536+01:00')) * where=(createdByUser='jbloggs' and createdAt BETWEEN ('2017-06-02T12:13:51.593+01:00' , '2017-06-04T10:05:16.536+01:00')) * where=(valuesKey='/alfresco-access/login/user') * where=(valuesKey='/alfresco-access/transaction/action' and valuesValue='DELETE'). Optional when the method annotation allows null.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the audit entry. The following optional fields can be requested: * values. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listAuditEntriesForAuditApp в generated-модели AuditEntryPaging. EN: Alfresco response for listAuditEntriesForAuditApp represented as AuditEntryPaging.
     */

    @GetExchange(url = "/audit-applications/{auditApplicationId}/audit-entries")
    AuditEntryPaging listAuditEntriesForAuditApp(@PathVariable("auditApplicationId") String auditApplicationId, @RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "omitTotalItems", required = false) Boolean omitTotalItems, @RequestParam(value = "orderBy", required = false) List<String> orderBy, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "where", required = false) String where, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Удаляет ресурс или связь через Alfresco REST API; обратимость зависит от конкретной операции и её параметров.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2.2 and newer versions. Permanently delete audit entries for an audit application auditApplicationId. The where clause must be specified, either with an inclusive time period or for an inclusive range of ids. The delete is within the context of the given audit application. For example: * where=(createdAt BETWEEN ('2017-06-02T12:13:51.593+01:00' , '2017-06-04T10:05:16.536+01:00')) * where=(id BETWEEN ('1234', '4321')) You must have admin rights to delete audit information.</p>
     * <p><strong>REST:</strong> DELETE /audit-applications/{auditApplicationId}/audit-entries; operationId: deleteAuditEntriesForAuditApp.</p>
     *
     * @param auditApplicationId RU: идентификатор audit-приложения. Обязательный параметр. EN: The identifier of an audit application.. Required.
     * @param where RU: серверное выражение фильтрации Alfresco. Обязательный параметр. EN: Audit entries to permanently delete for an audit application, given an inclusive time period or range of ids. For example: * where=(createdAt BETWEEN ('2017-06-02T12:13:51.593+01:00' , '2017-06-04T10:05:16.536+01:00')) * where=(id BETWEEN ('1234', '4321')). Required.
     */

    @DeleteExchange(url = "/audit-applications/{auditApplicationId}/audit-entries")
    Void deleteAuditEntriesForAuditApp(@PathVariable("auditApplicationId") String auditApplicationId, @RequestParam(value = "where", required = true) String where);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2.2 and newer versions. Gets audit entry auditEntryId. You must have admin rights to access audit information.</p>
     * <p><strong>REST:</strong> GET /audit-applications/{auditApplicationId}/audit-entries/{auditEntryId}; operationId: getAuditEntry.</p>
     *
     * @param auditApplicationId RU: идентификатор audit-приложения. Обязательный параметр. EN: The identifier of an audit application.. Required.
     * @param auditEntryId RU: идентификатор audit-записи. Обязательный параметр. EN: The identifier of an audit entry.. Required.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для getAuditEntry в generated-модели AuditEntryEntry. EN: Alfresco response for getAuditEntry represented as AuditEntryEntry.
     */

    @GetExchange(url = "/audit-applications/{auditApplicationId}/audit-entries/{auditEntryId}")
    AuditEntryEntry getAuditEntry(@PathVariable("auditApplicationId") String auditApplicationId, @PathVariable("auditEntryId") String auditEntryId, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Удаляет ресурс или связь через Alfresco REST API; обратимость зависит от конкретной операции и её параметров.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2.2 and newer versions. Permanently delete a single audit entry auditEntryId. You must have admin rights to delete audit information.</p>
     * <p><strong>REST:</strong> DELETE /audit-applications/{auditApplicationId}/audit-entries/{auditEntryId}; operationId: deleteAuditEntry.</p>
     *
     * @param auditApplicationId RU: идентификатор audit-приложения. Обязательный параметр. EN: The identifier of an audit application.. Required.
     * @param auditEntryId RU: идентификатор audit-записи. Обязательный параметр. EN: The identifier of an audit entry.. Required.
     */

    @DeleteExchange(url = "/audit-applications/{auditApplicationId}/audit-entries/{auditEntryId}")
    Void deleteAuditEntry(@PathVariable("auditApplicationId") String auditApplicationId, @PathVariable("auditEntryId") String auditEntryId);

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2.2 and newer versions. Gets a list of audit entries for node nodeId. The list can be filtered by createdByUser and for a given inclusive time period. The default sort order is createdAt ascending, but you can use an optional ASC or DESC modifier to specify an ascending or descending sort order. For example, specifying orderBy=createdAt DESC returns audit entries in descending createdAt order. This relies on the pre-configured 'alfresco-access' audit application.</p>
     * <p><strong>REST:</strong> GET /nodes/{nodeId}/audit-entries; operationId: listAuditEntriesForNode.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param orderBy RU: серверные выражения сортировки. Необязательный параметр, если аннотация допускает null. EN: A string to control the order of the entities returned in a list. You can use the orderBy parameter to sort the list by one or more fields. Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order. To sort the entities in a specific order, you can use the ASC and DESC keywords for any field.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param where RU: серверное выражение фильтрации Alfresco. Необязательный параметр, если аннотация допускает null. EN: Optionally filter the list. Here are some examples: * where=(createdByUser='-me-') * where=(createdAt BETWEEN ('2017-06-02T12:13:51.593+01:00' , '2017-06-04T10:05:16.536+01:00')) * where=(createdByUser='jbloggs' and createdAt BETWEEN ('2017-06-02T12:13:51.593+01:00' , '2017-06-04T10:05:16.536+01:00')). Optional when the method annotation allows null.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the audit entry. The following optional fields can be requested: * values. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listAuditEntriesForNode в generated-модели AuditEntryPaging. EN: Alfresco response for listAuditEntriesForNode represented as AuditEntryPaging.
     */

    @GetExchange(url = "/nodes/{nodeId}/audit-entries")
    AuditEntryPaging listAuditEntriesForNode(@PathVariable("nodeId") String nodeId, @RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "orderBy", required = false) List<String> orderBy, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "where", required = false) String where, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "fields", required = false) List<String> fields);
}
