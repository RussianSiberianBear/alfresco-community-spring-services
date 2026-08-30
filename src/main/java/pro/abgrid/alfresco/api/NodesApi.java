package pro.abgrid.alfresco.api;

import pro.abgrid.alfresco.dto.core.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * <p><strong>RU:</strong> Низкоуровневый HTTP-интерфейс NodesApi отображает операции Alfresco REST API на Spring HTTP Service. В обычном прикладном коде предпочтительнее high-level сервисы; этот интерфейс нужен для параметров и endpoint, не покрытых удобной обёрткой.</p>
 * <p><strong>EN:</strong> Low-level HTTP interface NodesApi maps Alfresco REST operations to Spring HTTP Service methods. Application code will normally prefer high-level services; use this interface for endpoint-level control or operations without a high-level wrapper.</p>
 * <p><strong>RU:</strong> HTTP-ошибки преобразуются общей конфигурацией клиента в AlfrescoApiException.</p>
 * <p><strong>EN:</strong> HTTP errors are converted by the shared client configuration into AlfrescoApiException.</p>
 */
public interface NodesApi {

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Get information for node nodeId. You can use the include parameter to return additional information.</p>
     * <p><strong>REST:</strong> GET /nodes/{nodeId}; operationId: getNode.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node. You can also use one of these well-known aliases: * -my- * -shared- * -root-. Required.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the node. The following optional fields can be requested: * allowableOperations * association * isLink * isFavorite * isDirectLinkEnabled * isLocked * path * permissions * definition. Optional when the method annotation allows null.
     * @param relativePath RU: путь относительно nodeId, позволяющий адресовать вложенный узел без отдельного поиска его id. Необязательный параметр, если аннотация допускает null. EN: A path relative to the nodeId. If you set this, information is returned on the node resolved by this path.. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для getNode в generated-модели NodeEntry. EN: Alfresco response for getNode represented as NodeEntry.
     */

    @GetExchange(url = "/nodes/{nodeId}")
    NodeEntry getNode(@PathVariable("nodeId") String nodeId, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "relativePath", required = false) String relativePath, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Изменяет существующий ресурс Alfresco согласно REST-контракту и возвращает подтверждённое сервером состояние, если endpoint имеет ответ.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Updates the node nodeId. For example, you can rename a file or folder: JSON { "name":"My new name" } You can also set or update one or more properties: JSON { "properties": { "cm:title":"Folder title" } } You can update multi-value properties of a node which supports properties of type multiple. JSON { "name":"My Other Folder", "nodeType":"custom:destination", "properties": { "cm:title":"Folder title", "cm:description":"This is an important folder", "custom:locations": [ "location NewX", "location NewY" ] } } Note: setting properties of type d:content and d:category are not supported. Note: if you want to add or remove aspects, then you must use GET /nodes/{nodeId} first to get the complete set of *aspectNames*. You can add (or remove) *locallySet* permissions, if any, in addition to any inherited permissions. You can also optionally disable (or re-enable) inherited permissions via *isInheritanceEnabled* flag: JSON { …</p>
     * <p><strong>REST:</strong> PUT /nodes/{nodeId}; operationId: updateNode.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the node. The following optional fields can be requested: * allowableOperations * association * isLink * isFavorite * isDirectLinkEnabled * isLocked * path * permissions * definition. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param nodeBodyUpdate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The node information to update.. Required.
     * @return RU: ответ Alfresco для updateNode в generated-модели NodeEntry. EN: Alfresco response for updateNode represented as NodeEntry.
     */

    @PutExchange(url = "/nodes/{nodeId}")
    NodeEntry updateNode(@PathVariable("nodeId") String nodeId, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody NodeBodyUpdate nodeBodyUpdate);

        /**
     * <p><strong>RU:</strong> Удаляет ресурс или связь через Alfresco REST API; обратимость зависит от конкретной операции и её параметров.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Deletes the node nodeId. If nodeId is a folder, then its children are also deleted. Deleted nodes move to the trashcan unless the permanent query parameter is true and the current user is the owner of the node or an admin. Deleting a node deletes it from its primary parent and also from any secondary parents. Peer associations are also deleted, where the deleted node is either a source or target of an association. This applies recursively to any hierarchy of primary children of the deleted node. Note: If the node is not permanently deleted, and is later successfully restored to its former primary parent, then the primary child association is restored. This applies recursively for any primary children. No other secondary child associations or peer associations are restored for any of the nodes in the primary parent-child hierarchy of restored nodes, regardless of whether the original associations were to nodes inside o…</p>
     * <p><strong>REST:</strong> DELETE /nodes/{nodeId}; operationId: deleteNode.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param permanent RU: если true, удаление выполняется без корзины и штатное восстановление невозможно. Необязательный параметр, если аннотация допускает null. EN: If true then the node is deleted permanently, without moving to the trashcan. Only the owner of the node or an admin can permanently delete the node.. Optional when the method annotation allows null.
     */

    @DeleteExchange(url = "/nodes/{nodeId}")
    Void deleteNode(@PathVariable("nodeId") String nodeId, @RequestParam(value = "permanent", required = false) Boolean permanent);

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Gets a list of children of the parent node nodeId. Minimal information for each child is returned by default. You can use the include parameter to return additional information. The list of child nodes includes primary children and secondary children, if there are any. You can use the include parameter (include=association) to return child association details for each child, including the assocType and the isPrimary flag. The default sort order for the returned list is for folders to be sorted before files, and by ascending name. You can override the default using orderBy to specify one or more fields to sort by. The default order is always ascending, but you can use an optional ASC or DESC modifier to specify an ascending or descending sort order. For example, specifying orderBy=name DESC returns a mixed folder/file list in descending name order. You can use any of the following fields to order the results: * isFolde…</p>
     * <p><strong>REST:</strong> GET /nodes/{nodeId}/children; operationId: listNodeChildren.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node. You can also use one of these well-known aliases: * -my- * -shared- * -root-. Required.
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param orderBy RU: серверные выражения сортировки. Необязательный параметр, если аннотация допускает null. EN: A string to control the order of the entities returned in a list. You can use the orderBy parameter to sort the list by one or more fields. Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order. To sort the entities in a specific order, you can use the ASC and DESC keywords for any field.. Optional when the method annotation allows null.
     * @param where RU: серверное выражение фильтрации Alfresco. Необязательный параметр, если аннотация допускает null. EN: Optionally filter the list. Here are some examples: * where=(isFolder=true) * where=(isFile=true) * where=(nodeType='my:specialNodeType') * where=(nodeType='my:specialNodeType INCLUDESUBTYPES') * where=(isPrimary=true) * where=(assocType='my:specialAssocType') * where=(isPrimary=false and assocType='my:specialAssocType'). Optional when the method annotation allows null.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the node. The following optional fields can be requested: * allowableOperations * aspectNames * association * isLink * isFavorite * isDirectLinkEnabled * isLocked * path * properties * permissions. Optional when the method annotation allows null.
     * @param relativePath RU: путь относительно nodeId, позволяющий адресовать вложенный узел без отдельного поиска его id. Необязательный параметр, если аннотация допускает null. EN: Return information on children in the folder resolved by this path. The path is relative to nodeId.. Optional when the method annotation allows null.
     * @param includeSource RU: признак включения source/родительского контекста в paging-ответ. Необязательный параметр, если аннотация допускает null. EN: Also include source in addition to entries with folder information on the parent node – either the specified parent nodeId, or as resolved by relativePath.. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listNodeChildren в generated-модели NodeChildAssociationPaging. EN: Alfresco response for listNodeChildren represented as NodeChildAssociationPaging.
     */

    @GetExchange(url = "/nodes/{nodeId}/children")
    NodeChildAssociationPaging listNodeChildren(@PathVariable("nodeId") String nodeId, @RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "orderBy", required = false) List<String> orderBy, @RequestParam(value = "where", required = false) String where, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "relativePath", required = false) String relativePath, @RequestParam(value = "includeSource", required = false) Boolean includeSource, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Создаёт ресурс или связь в Alfresco. Метод напрямую отражает REST-контракт и принимает generated DTO тела запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Create a node and add it as a primary child of node nodeId. This endpoint supports both JSON and multipart/form-data (file upload). Using multipart/form-data Use the filedata field to represent the content to upload, for example, the following curl command will create a node with the contents of test.txt in the test user's home folder. curl -utest:test -X POST host:port/alfresco/api/-default-/public/alfresco/versions/1/nodes/-my-/children -F filedata=@test.txt You can use the name field to give an alternative name for the new file. You can use the nodeType field to create a specific type. The default is cm:content. You can use the renditions field to create renditions (e.g. doclib) asynchronously upon upload. Also, as requesting rendition is a background process, any rendition failure (e.g. No transformer is currently available) will not fail the whole upload and has the potential to silently fail. You can use the asp…</p>
     * <p><strong>REST:</strong> POST /nodes/{nodeId}/children; operationId: createNode.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node. You can also use one of these well-known aliases: * -my- * -shared- * -root-. Required.
     * @param autoRename RU: если true, Alfresco автоматически разрешает конфликт имени при создании. Необязательный параметр, если аннотация допускает null. EN: If true, then a name clash will cause an attempt to auto rename by finding a unique name using an integer suffix.. Optional when the method annotation allows null.
     * @param majorVersion RU: если true, создаётся major-версия; иначе minor, когда версия создаётся. Необязательный параметр, если аннотация допускает null. EN: If true, then created node will be version *1.0 MAJOR*. If false, then created node will be version *0.1 MINOR*.. Optional when the method annotation allows null.
     * @param versioningEnabled RU: признак включения версионирования для создаваемого узла. Необязательный параметр, если аннотация допускает null. EN: If true, then created node will be versioned. If false, then created node will be unversioned and auto-versioning disabled.. Optional when the method annotation allows null.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the node. The following optional fields can be requested: * allowableOperations * association * isLink * isFavorite * isDirectLinkEnabled * isLocked * path * permissions * definition. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param nodeBodyCreate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The node information to create.. Required.
     * @return RU: ответ Alfresco для createNode в generated-модели NodeEntry. EN: Alfresco response for createNode represented as NodeEntry.
     */

    @PostExchange(url = "/nodes/{nodeId}/children")
    NodeEntry createNode(@PathVariable("nodeId") String nodeId, @RequestParam(value = "autoRename", required = false) Boolean autoRename, @RequestParam(value = "majorVersion", required = false) Boolean majorVersion, @RequestParam(value = "versioningEnabled", required = false) Boolean versioningEnabled, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody NodeBodyCreate nodeBodyCreate);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию POST /nodes/{nodeId}/copy Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Copies the node nodeId to the parent folder node targetParentId. You specify the targetParentId in the request body. The new node has the same name as the source node unless you specify a new name in the request body. If the source nodeId is a folder, then all of its children are also copied. If the source nodeId is a file, it's properties, aspects and tags are copied, it's ratings, comments and locks are not.</p>
     * <p><strong>REST:</strong> POST /nodes/{nodeId}/copy; operationId: copyNode.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the node. The following optional fields can be requested: * allowableOperations * association * isLink * isFavorite * isDirectLinkEnabled * isLocked * path * permissions * definition. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param nodeBodyCopy RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The targetParentId and, optionally, a new name which should include the file extension.. Required.
     * @return RU: ответ Alfresco для copyNode в generated-модели NodeEntry. EN: Alfresco response for copyNode represented as NodeEntry.
     */

    @PostExchange(url = "/nodes/{nodeId}/copy")
    NodeEntry copyNode(@PathVariable("nodeId") String nodeId, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody NodeBodyCopy nodeBodyCopy);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию POST /nodes/{nodeId}/lock Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Places a lock on node nodeId. Note: you can only lock files. More specifically, a node can only be locked if it is of type cm:content or a subtype of cm:content. The lock is owned by the current user, and prevents other users or processes from making updates to the node until the lock is released. If the timeToExpire is not set or is zero, then the lock never expires. Otherwise, the timeToExpire is the number of seconds before the lock expires. When a lock expires, the lock is released. If the node is already locked, and the user is the lock owner, then the lock is renewed with the new timeToExpire. By default, a lock is applied that allows the owner to update or delete the node. You can use type to change the lock type to one of the following: * ALLOW_OWNER_CHANGES (default) changes to the node can be made only by the lock owner. This enum is the same value as the deprecated WRITE_LOCK described in org.alfresco.servi…</p>
     * <p><strong>REST:</strong> POST /nodes/{nodeId}/lock; operationId: lockNode.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the node. The following optional fields can be requested: * allowableOperations * association * isLink * isFavorite * isDirectLinkEnabled * isLocked * path * permissions * definition. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param nodeBodyLock RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: Lock details.. Required.
     * @return RU: ответ Alfresco для lockNode в generated-модели NodeEntry. EN: Alfresco response for lockNode represented as NodeEntry.
     */

    @PostExchange(url = "/nodes/{nodeId}/lock")
    NodeEntry lockNode(@PathVariable("nodeId") String nodeId, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody NodeBodyLock nodeBodyLock);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию POST /nodes/{nodeId}/unlock Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Deletes a lock on node nodeId. The current user must be the owner of the locks or have admin rights, otherwise an error is returned. If a lock on the node cannot be released, then an error is returned.</p>
     * <p><strong>REST:</strong> POST /nodes/{nodeId}/unlock; operationId: unlockNode.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the node. The following optional fields can be requested: * allowableOperations * association * isLink * isFavorite * isDirectLinkEnabled * isLocked * path * permissions * definition. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для unlockNode в generated-модели NodeEntry. EN: Alfresco response for unlockNode represented as NodeEntry.
     */

    @PostExchange(url = "/nodes/{nodeId}/unlock")
    NodeEntry unlockNode(@PathVariable("nodeId") String nodeId, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию POST /nodes/{nodeId}/checkout Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Checks out the file node nodeId for offline editing. A private working copy is created and the original node is locked. The working copy node is returned. Only files (cm:content or subtypes) can be checked out.</p>
     * <p><strong>REST:</strong> POST /nodes/{nodeId}/checkout; operationId: checkoutNode.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the node. The following optional fields can be requested: * allowableOperations * association * isLink * isFavorite * isDirectLinkEnabled * isLocked * path * permissions * definition. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для checkoutNode в generated-модели NodeEntry. EN: Alfresco response for checkoutNode represented as NodeEntry.
     */

    @PostExchange(url = "/nodes/{nodeId}/checkout")
    NodeEntry checkoutNode(@PathVariable("nodeId") String nodeId, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию POST /nodes/{nodeId}/cancel-checkout Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Cancel the checkout workflow for the node nodeId. The private working copy is deleted and the original node is unlocked. The original node is returned.</p>
     * <p><strong>REST:</strong> POST /nodes/{nodeId}/cancel-checkout; operationId: cancelCheckoutNode.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the node. The following optional fields can be requested: * allowableOperations * association * isLink * isFavorite * isDirectLinkEnabled * isLocked * path * permissions * definition. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для cancelCheckoutNode в generated-модели NodeEntry. EN: Alfresco response for cancelCheckoutNode represented as NodeEntry.
     */

    @PostExchange(url = "/nodes/{nodeId}/cancel-checkout")
    NodeEntry cancelCheckoutNode(@PathVariable("nodeId") String nodeId, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию POST /nodes/{nodeId}/move Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Move the node nodeId to the parent folder node targetParentId. The targetParentId is specified in the in request body. The moved node retains its name unless you specify a new name in the request body. If the source nodeId is a folder, then its children are also moved. The move will effectively change the primary parent.</p>
     * <p><strong>REST:</strong> POST /nodes/{nodeId}/move; operationId: moveNode.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the node. The following optional fields can be requested: * allowableOperations * association * isLink * isFavorite * isDirectLinkEnabled * isLocked * path * permissions * definition. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param nodeBodyMove RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The targetParentId and, optionally, a new name which should include the file extension.. Required.
     * @return RU: ответ Alfresco для moveNode в generated-модели NodeEntry. EN: Alfresco response for moveNode represented as NodeEntry.
     */

    @PostExchange(url = "/nodes/{nodeId}/move")
    NodeEntry moveNode(@PathVariable("nodeId") String nodeId, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody NodeBodyMove nodeBodyMove);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Gets the content of the node with identifier nodeId.</p>
     * <p><strong>REST:</strong> GET /nodes/{nodeId}/content; operationId: getNodeContent.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param attachment RU: управляет выдачей содержимого как attachment. Необязательный параметр, если аннотация допускает null. EN: true enables a web browser to download the file as an attachment. false means a web browser may preview the file in a new tab or window. You can only set this parameter to false if the content type of the file is in the supported list; for example, certain image files and PDF files. If the content type is not supported for preview, then a value of false is ignored, and the attachment will be returned in the response.. Optional when the method annotation allows null.
     * @param ifModifiedSince RU: HTTP If-Modified-Since для условного получения содержимого. Необязательный параметр, если аннотация допускает null. EN: Value of parameter ifModifiedSince for this REST operation. Optional when the method annotation allows null.
     * @param range RU: HTTP Range для частичного чтения содержимого. Необязательный параметр, если аннотация допускает null. EN: Value of parameter range for this REST operation. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для getNodeContent в generated-модели byte[]. EN: Alfresco response for getNodeContent represented as byte[].
     */

    @GetExchange(url = "/nodes/{nodeId}/content")
    byte[] getNodeContent(@PathVariable("nodeId") String nodeId, @RequestParam(value = "attachment", required = false) Boolean attachment, @RequestHeader(value = "If-Modified-Since", required = false) OffsetDateTime ifModifiedSince, @RequestHeader(value = "Range", required = false) String range);

        /**
     * <p><strong>RU:</strong> Изменяет существующий ресурс Alfresco согласно REST-контракту и возвращает подтверждённое сервером состояние, если endpoint имеет ответ.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Updates the content of the node with identifier nodeId. The request body for this endpoint can be any text or binary stream. The majorVersion and comment parameters can be used to control versioning behaviour. If the content is versionable, a new minor version is created by default. Optionally a new name parameter can also be specified that must be unique within the parent folder. If specified and valid then this will rename the node. If invalid then an error is returned and the content is not updated. Note: This API method accepts any content type, but for testing with this tool text based content can be provided. This is because the OpenAPI Specification does not allow a wildcard to be provided or the ability for tooling to accept an arbitrary file.</p>
     * <p><strong>REST:</strong> PUT /nodes/{nodeId}/content; operationId: updateNodeContent.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param majorVersion RU: если true, создаётся major-версия; иначе minor, когда версия создаётся. Необязательный параметр, если аннотация допускает null. EN: If true, create a major version. Setting this parameter also enables versioning of this node, if it is not already versioned.. Optional when the method annotation allows null.
     * @param comment RU: комментарий к операции/версии. Необязательный параметр, если аннотация допускает null. EN: Add a version comment which will appear in version history. Setting this parameter also enables versioning of this node, if it is not already versioned.. Optional when the method annotation allows null.
     * @param name RU: имя ресурса. Необязательный параметр, если аннотация допускает null. EN: Optional new name. This should include the file extension. The name must not contain spaces or the following special characters: * " &lt; &gt; \ / ? : and |. The character . must not be used at the end of the name.. Optional when the method annotation allows null.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the node. The following optional fields can be requested: * allowableOperations * association * isLink * isFavorite * isDirectLinkEnabled * isLocked * path * permissions * definition. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param contentBodyUpdate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The binary content. Required.
     * @return RU: ответ Alfresco для updateNodeContent в generated-модели NodeEntry. EN: Alfresco response for updateNodeContent represented as NodeEntry.
     */

    @PutExchange(url = "/nodes/{nodeId}/content", contentType = "application/octet-stream")
    NodeEntry updateNodeContent(@PathVariable("nodeId") String nodeId, @RequestParam(value = "majorVersion", required = false) Boolean majorVersion, @RequestParam(value = "comment", required = false) String comment, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody byte[] contentBodyUpdate);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию POST /nodes/{nodeId}/request-direct-access-url Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.1 and newer versions. Generate a direct access content url for the given nodeId.</p>
     * <p><strong>REST:</strong> POST /nodes/{nodeId}/request-direct-access-url; operationId: requestNodeDirectAccessUrl.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param requestContentUrlBodyCreate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Необязательный параметр, если аннотация допускает null. EN: Direct Access URL options and flags. Note: It is up to the actual ContentStore implementation if it can fulfil this request or not. The attachment flag controls the download method of the generated URL. It defaults to true, meaning the value for the Content Disposition response header will be attachment. true enables a web browser to download the file as an attachment. false means a web browser may preview the file in a new tab or window. You can only set this parameter to false if the content type of the file is in the supported list; for example, certain image files and PDF files. If the content type is not supported for preview, then a value of false is ignored, and the attachment will be returned in the response.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для requestNodeDirectAccessUrl в generated-модели DirectAccessUrlEntry. EN: Alfresco response for requestNodeDirectAccessUrl represented as DirectAccessUrlEntry.
     */

    @PostExchange(url = "/nodes/{nodeId}/request-direct-access-url")
    DirectAccessUrlEntry requestNodeDirectAccessUrl(@PathVariable("nodeId") String nodeId, @RequestBody DirectAccessUrlBodyCreate requestContentUrlBodyCreate);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> This may be executed against a node specified by nodeId and this nodeId must be a valid node ID. Furthermore, this POST endpoint will be executed asynchronously with a 202 HTTP response signifying that the request has been accepted successfully. The response body will include the jobId of the pending/completed action.</p>
     * <p><strong>REST:</strong> POST /nodes/{nodeId}/size-details; operationId: getNodeSizeDetailsRequest.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a target node.. Required.
     * @return RU: ответ Alfresco для getNodeSizeDetailsRequest в generated-модели sizeDetailsRequestResultEntry. EN: Alfresco response for getNodeSizeDetailsRequest represented as sizeDetailsRequestResultEntry.
     */

    @PostExchange(url = "/nodes/{nodeId}/size-details")
    sizeDetailsRequestResultEntry getNodeSizeDetailsRequest(@PathVariable("nodeId") String nodeId);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> *Receiving the size* This endpoint takes nodeId and jobId as the path parameters and returns the result after executing above GET request. The size details job can be in one of three states: NOT-INITIATED: Not Initiated yet. IN-PROGRESS: Calculation is in progress. COMPLETED: Calculation has been done.</p>
     * <p><strong>REST:</strong> GET /nodes/{nodeId}/size-details/{jobId}; operationId: getNodeSizeDetails.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a target node.. Required.
     * @param jobId RU: идентификатор асинхронного задания. Обязательный параметр. EN: The identifier of a job.. Required.
     * @return RU: ответ Alfresco для getNodeSizeDetails в generated-модели getNodeSizeDetailsResponse. EN: Alfresco response for getNodeSizeDetails represented as getNodeSizeDetailsResponse.
     */

    @GetExchange(url = "/nodes/{nodeId}/size-details/{jobId}")
    getNodeSizeDetailsResponse getNodeSizeDetails(@PathVariable("nodeId") String nodeId, @PathVariable("jobId") String jobId);

        /**
     * <p><strong>RU:</strong> Создаёт ресурс или связь в Alfresco. Метод напрямую отражает REST-контракт и принимает generated DTO тела запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Create a secondary child association, with the given association type, between the parent nodeId and a child node. Note: You can create more than one secondary child association by specifying a list of associations in the JSON body like this: JSON [ { "childId": "string", "assocType": "string" }, { "childId": "string", "assocType": "string" } ] If you specify a list as input, then a paginated list rather than an entry is returned in the response body. For example: JSON { "list": { "pagination": { "count": 2, "hasMoreItems": false, "totalItems": 2, "skipCount": 0, "maxItems": 100 }, "entries": [ { "entry": { ... } }, { "entry": { ... } } ] } }</p>
     * <p><strong>REST:</strong> POST /nodes/{nodeId}/secondary-children; operationId: createSecondaryChildAssociation.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a parent node.. Required.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param secondaryChildAssociationBodyCreate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The child node id and assoc type.. Required.
     * @return RU: ответ Alfresco для createSecondaryChildAssociation в generated-модели ChildAssociationEntry. EN: Alfresco response for createSecondaryChildAssociation represented as ChildAssociationEntry.
     */

    @PostExchange(url = "/nodes/{nodeId}/secondary-children")
    ChildAssociationEntry createSecondaryChildAssociation(@PathVariable("nodeId") String nodeId, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody ChildAssociationBody secondaryChildAssociationBodyCreate);

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Gets a list of secondary child nodes that are associated with the current parent nodeId, via a secondary child association.</p>
     * <p><strong>REST:</strong> GET /nodes/{nodeId}/secondary-children; operationId: listSecondaryChildren.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a parent node. You can also use one of these well-known aliases: * -my- * -shared- * -root-. Required.
     * @param where RU: серверное выражение фильтрации Alfresco. Необязательный параметр, если аннотация допускает null. EN: Optionally filter the list by assocType. Here's an example: * where=(assocType='my:specialAssocType'). Optional when the method annotation allows null.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the node. The following optional fields can be requested: * allowableOperations * aspectNames * isLink * isFavorite * isDirectLinkEnabled * isLocked * path * properties. Optional when the method annotation allows null.
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param includeSource RU: признак включения source/родительского контекста в paging-ответ. Необязательный параметр, если аннотация допускает null. EN: Also include source (in addition to entries) with folder information on nodeId. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listSecondaryChildren в generated-модели NodeChildAssociationPaging. EN: Alfresco response for listSecondaryChildren represented as NodeChildAssociationPaging.
     */

    @GetExchange(url = "/nodes/{nodeId}/secondary-children")
    NodeChildAssociationPaging listSecondaryChildren(@PathVariable("nodeId") String nodeId, @RequestParam(value = "where", required = false) String where, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "includeSource", required = false) Boolean includeSource, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Удаляет ресурс или связь через Alfresco REST API; обратимость зависит от конкретной операции и её параметров.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Delete secondary child associations between the parent nodeId and child nodes for the given association type. If the association type is not specified, then all secondary child associations, of any type in the direction from parent to secondary child, will be deleted. The child will still have a primary parent and may still be associated as a secondary child with other secondary parents.</p>
     * <p><strong>REST:</strong> DELETE /nodes/{nodeId}/secondary-children/{childId}; operationId: deleteSecondaryChildAssociation.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a parent node.. Required.
     * @param childId RU: значение параметра childId для данной REST-операции. Обязательный параметр. EN: The identifier of a child node.. Required.
     * @param assocType RU: QName типа ассоциации. Необязательный параметр, если аннотация допускает null. EN: Only delete associations of this type.. Optional when the method annotation allows null.
     */

    @DeleteExchange(url = "/nodes/{nodeId}/secondary-children/{childId}")
    Void deleteSecondaryChildAssociation(@PathVariable("nodeId") String nodeId, @PathVariable("childId") String childId, @RequestParam(value = "assocType", required = false) String assocType);

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Gets a list of parent nodes that are associated with the current child nodeId. The list includes both the primary parent and any secondary parents.</p>
     * <p><strong>REST:</strong> GET /nodes/{nodeId}/parents; operationId: listParents.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a child node. You can also use one of these well-known aliases: * -my- * -shared- * -root-. Required.
     * @param where RU: серверное выражение фильтрации Alfresco. Необязательный параметр, если аннотация допускает null. EN: Optionally filter the list by assocType and/or isPrimary. Here are some example filters: * where=(assocType='my:specialAssocType') * where=(isPrimary=true) * where=(isPrimary=false and assocType='my:specialAssocType'). Optional when the method annotation allows null.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the node. The following optional fields can be requested: * allowableOperations * aspectNames * isLink * isFavorite * isDirectLinkEnabled * isLocked * path * properties. Optional when the method annotation allows null.
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param includeSource RU: признак включения source/родительского контекста в paging-ответ. Необязательный параметр, если аннотация допускает null. EN: Also include source (in addition to entries) with folder information on nodeId. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listParents в generated-модели NodeAssociationPaging. EN: Alfresco response for listParents represented as NodeAssociationPaging.
     */

    @GetExchange(url = "/nodes/{nodeId}/parents")
    NodeAssociationPaging listParents(@PathVariable("nodeId") String nodeId, @RequestParam(value = "where", required = false) String where, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "includeSource", required = false) Boolean includeSource, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Создаёт ресурс или связь в Alfresco. Метод напрямую отражает REST-контракт и принимает generated DTO тела запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Create an association, with the given association type, between the source nodeId and a target node. Note: You can create more than one association by specifying a list of associations in the JSON body like this: JSON [ { "targetId": "string", "assocType": "string" }, { "targetId": "string", "assocType": "string" } ] If you specify a list as input, then a paginated list rather than an entry is returned in the response body. For example: JSON { "list": { "pagination": { "count": 2, "hasMoreItems": false, "totalItems": 2, "skipCount": 0, "maxItems": 100 }, "entries": [ { "entry": { ... } }, { "entry": { ... } } ] } }</p>
     * <p><strong>REST:</strong> POST /nodes/{nodeId}/targets; operationId: createAssociation.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a source node.. Required.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param associationBodyCreate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The target node id and assoc type.. Required.
     * @return RU: ответ Alfresco для createAssociation в generated-модели AssociationEntry. EN: Alfresco response for createAssociation represented as AssociationEntry.
     */

    @PostExchange(url = "/nodes/{nodeId}/targets")
    AssociationEntry createAssociation(@PathVariable("nodeId") String nodeId, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody AssociationBody associationBodyCreate);

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Gets a list of target nodes that are associated with the current source nodeId.</p>
     * <p><strong>REST:</strong> GET /nodes/{nodeId}/targets; operationId: listTargetAssociations.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a source node.. Required.
     * @param where RU: серверное выражение фильтрации Alfresco. Необязательный параметр, если аннотация допускает null. EN: Optionally filter the list by assocType. Here's an example: * where=(assocType='my:specialAssocType'). Optional when the method annotation allows null.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the node. The following optional fields can be requested: * allowableOperations * aspectNames * isLink * isFavorite * isDirectLinkEnabled * isLocked * path * properties. Optional when the method annotation allows null.
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listTargetAssociations в generated-модели NodeAssociationPaging. EN: Alfresco response for listTargetAssociations represented as NodeAssociationPaging.
     */

    @GetExchange(url = "/nodes/{nodeId}/targets")
    NodeAssociationPaging listTargetAssociations(@PathVariable("nodeId") String nodeId, @RequestParam(value = "where", required = false) String where, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Удаляет ресурс или связь через Alfresco REST API; обратимость зависит от конкретной операции и её параметров.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Delete an association, or associations, from the source nodeId* to a target node for the given association type. If the association type is not specified, then all peer associations, of any type, in the direction from source to target, are deleted. Note: After removal of the peer association, or associations, from source to target, the two nodes may still have peer associations in the other direction.</p>
     * <p><strong>REST:</strong> DELETE /nodes/{nodeId}/targets/{targetId}; operationId: deleteAssociation.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a source node.. Required.
     * @param targetId RU: значение параметра targetId для данной REST-операции. Обязательный параметр. EN: The identifier of a target node.. Required.
     * @param assocType RU: QName типа ассоциации. Необязательный параметр, если аннотация допускает null. EN: Only delete associations of this type.. Optional when the method annotation allows null.
     */

    @DeleteExchange(url = "/nodes/{nodeId}/targets/{targetId}")
    Void deleteAssociation(@PathVariable("nodeId") String nodeId, @PathVariable("targetId") String targetId, @RequestParam(value = "assocType", required = false) String assocType);

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Gets a list of source nodes that are associated with the current target nodeId.</p>
     * <p><strong>REST:</strong> GET /nodes/{nodeId}/sources; operationId: listSourceAssociations.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a target node.. Required.
     * @param where RU: серверное выражение фильтрации Alfresco. Необязательный параметр, если аннотация допускает null. EN: Optionally filter the list by assocType. Here's an example: * where=(assocType='my:specialAssocType'). Optional when the method annotation allows null.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the node. The following optional fields can be requested: * allowableOperations * aspectNames * isLink * isFavorite * isDirectLinkEnabled * isLocked * path * properties. Optional when the method annotation allows null.
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listSourceAssociations в generated-модели NodeAssociationPaging. EN: Alfresco response for listSourceAssociations represented as NodeAssociationPaging.
     */

    @GetExchange(url = "/nodes/{nodeId}/sources")
    NodeAssociationPaging listSourceAssociations(@PathVariable("nodeId") String nodeId, @RequestParam(value = "where", required = false) String where, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "fields", required = false) List<String> fields);
}
