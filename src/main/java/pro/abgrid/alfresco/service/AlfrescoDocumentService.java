package pro.abgrid.alfresco.service;

import pro.abgrid.alfresco.dto.core.Node;
import pro.abgrid.alfresco.dto.core.NodeEntry;
import pro.abgrid.alfresco.dto.core.VersionEntry;
import pro.abgrid.alfresco.dto.core.VersionPaging;
import pro.abgrid.alfresco.model.ContentResource;
import pro.abgrid.alfresco.model.TransformationResult;
import pro.abgrid.alfresco.model.UploadRequest;
import pro.abgrid.alfresco.model.VersionRequest;
import pro.abgrid.alfresco.model.PermissionGrant;
import pro.abgrid.alfresco.model.PermissionSnapshot;
import pro.abgrid.alfresco.service.content.AlfrescoContentService;
import pro.abgrid.alfresco.service.metadata.AlfrescoMetadataService;
import pro.abgrid.alfresco.service.transformation.AlfrescoTransformationService;
import pro.abgrid.alfresco.service.version.AlfrescoVersionService;
import pro.abgrid.alfresco.service.permission.AlfrescoPermissionService;
import pro.abgrid.alfresco.service.tag.AlfrescoTagService;
import pro.abgrid.alfresco.service.comment.AlfrescoCommentService;
import pro.abgrid.alfresco.service.rating.AlfrescoRatingService;
import pro.abgrid.alfresco.service.favorite.AlfrescoFavoriteService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p><strong>RU:</strong> Высокоуровневый Spring-сервис для сценариев «document» в Alfresco. Он служит прикладной границей над generated REST API: принимает более удобные параметры, скрывает технические детали HTTP/DTO там, где для них есть high-level модель, и оставляет доступ к серверному результату, когда это необходимо. Сервис предназначен для внедрения как обычный Spring bean в бизнес-сервисы приложения.</p>
 * <p><strong>EN:</strong> High-level Spring service for Alfresco document scenarios. It acts as an application boundary over the generated REST API: it accepts application-friendly parameters, hides HTTP/DTO plumbing where a high-level model exists, and still exposes server results when required. The service is intended to be injected as a regular Spring bean into application business services.</p>
 */
@Service
public class AlfrescoDocumentService {
    private final AlfrescoContentService content;
    private final AlfrescoTransformationService transformation;
    private final AlfrescoMetadataService metadata;
    private final AlfrescoVersionService versions;
    private final AlfrescoPermissionService permissions;
    private final AlfrescoTagService tags;
    private final AlfrescoCommentService comments;
    private final AlfrescoRatingService ratings;
    private final AlfrescoFavoriteService favorites;

        /**
     * <p><strong>RU:</strong> создаёт сервис и получает его зависимости через Spring DI; обычно этот конструктор не вызывается прикладным кодом напрямую.</p>
     * <p><strong>EN:</strong> creates the service with dependencies supplied by Spring DI; application code normally does not call this constructor directly.</p>
     *
     * @param content RU: зависимость `content`, используемая сервисом для выполнения операций Alfresco. EN: `content` dependency used by the service to perform Alfresco operations.
     * @param transformation RU: зависимость `transformation`, используемая сервисом для выполнения операций Alfresco. EN: `transformation` dependency used by the service to perform Alfresco operations.
     * @param metadata RU: зависимость `metadata`, используемая сервисом для выполнения операций Alfresco. EN: `metadata` dependency used by the service to perform Alfresco operations.
     * @param versions RU: зависимость `versions`, используемая сервисом для выполнения операций Alfresco. EN: `versions` dependency used by the service to perform Alfresco operations.
     * @param permissions RU: зависимость `permissions`, используемая сервисом для выполнения операций Alfresco. EN: `permissions` dependency used by the service to perform Alfresco operations.
     * @param tags RU: зависимость `tags`, используемая сервисом для выполнения операций Alfresco. EN: `tags` dependency used by the service to perform Alfresco operations.
     * @param comments RU: зависимость `comments`, используемая сервисом для выполнения операций Alfresco. EN: `comments` dependency used by the service to perform Alfresco operations.
     * @param ratings RU: зависимость `ratings`, используемая сервисом для выполнения операций Alfresco. EN: `ratings` dependency used by the service to perform Alfresco operations.
     * @param favorites RU: зависимость `favorites`, используемая сервисом для выполнения операций Alfresco. EN: `favorites` dependency used by the service to perform Alfresco operations.
     */

    public AlfrescoDocumentService(
            AlfrescoContentService content,
            AlfrescoTransformationService transformation,
            AlfrescoMetadataService metadata,
            AlfrescoVersionService versions,
            AlfrescoPermissionService permissions,
            AlfrescoTagService tags,
            AlfrescoCommentService comments,
            AlfrescoRatingService ratings,
            AlfrescoFavoriteService favorites) {
        this.content = content;
        this.transformation = transformation;
        this.metadata = metadata;
        this.versions = versions;
        this.permissions = permissions;
        this.tags = tags;
        this.comments = comments;
        this.ratings = ratings;
        this.favorites = favorites;
    }

        /**
     * <p><strong>RU:</strong> загружает новый документ в Alfresco и возвращает созданный узел с серверными метаданными.</p>
     * <p><strong>EN:</strong> uploads a new document to Alfresco and returns the created node with server-side metadata.</p>
     *
     * @param request RU: high-level параметры операции. EN: high-level operation parameters.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public NodeEntry upload(UploadRequest request) { return content.upload(request); }
        /**
     * <p><strong>RU:</strong> получает бинарное содержимое из Alfresco для передачи клиенту, сохранения или дальнейшей обработки.</p>
     * <p><strong>EN:</strong> retrieves binary content from Alfresco for client delivery, storage, or further processing.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @return RU: полученное бинарное содержимое. EN: retrieved binary content.
     */

    public ContentResource download(String nodeId) { return content.download(nodeId); }
        /**
     * <p><strong>RU:</strong> изменяет имя узла, не меняя его идентификатор.</p>
     * <p><strong>EN:</strong> changes a node name without changing its identifier.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param name RU: имя создаваемого или изменяемого объекта. EN: name of the object being created or changed.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public NodeEntry rename(String nodeId, String name) { return content.rename(nodeId, name); }
        /**
     * <p><strong>RU:</strong> перемещает существующий узел в другую папку репозитория.</p>
     * <p><strong>EN:</strong> moves an existing node to another repository folder.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param parentId RU: идентификатор родительского узла. EN: parent node identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public NodeEntry move(String nodeId, String parentId) { return content.move(nodeId, parentId, null); }
        /**
     * <p><strong>RU:</strong> удаляет соответствующий объект Alfresco; используйте метод, когда объект больше не должен быть доступен через репозиторий.</p>
     * <p><strong>EN:</strong> deletes the corresponding Alfresco object; use it when the object should no longer be available through the repository.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     */

    public void delete(String nodeId) { content.delete(nodeId); }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `toPdf` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `toPdf` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public TransformationResult toPdf(String nodeId) { return transformation.toPdf(nodeId); }
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `preview` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `preview` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public TransformationResult preview(String nodeId) { return transformation.preview(nodeId); }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `metadata` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `metadata` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public Node metadata(String nodeId) { return metadata.get(nodeId); }
        /**
     * <p><strong>RU:</strong> изменяет существующий объект Alfresco и возвращает состояние, подтверждённое сервером.</p>
     * <p><strong>EN:</strong> updates an existing Alfresco object and returns the server-confirmed state.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param properties RU: свойства Alfresco, которые требуется установить или изменить. EN: Alfresco properties to set or update.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public Node updateMetadata(String nodeId, Map<String, String> properties) { return metadata.updateProperties(nodeId, properties); }
        /**
     * <p><strong>RU:</strong> добавляет связь, значение или дочерний объект к существующему объекту Alfresco.</p>
     * <p><strong>EN:</strong> adds a relation, value, or child object to an existing Alfresco object.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param aspect RU: значение параметра `aspect` для выполняемой операции. EN: value of `aspect` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public Node addAspect(String nodeId, String aspect) { return metadata.addAspect(nodeId, aspect); }
        /**
     * <p><strong>RU:</strong> перемещает существующий узел в другую папку репозитория.</p>
     * <p><strong>EN:</strong> moves an existing node to another repository folder.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param aspect RU: значение параметра `aspect` для выполняемой операции. EN: value of `aspect` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public Node removeAspect(String nodeId, String aspect) { return metadata.removeAspect(nodeId, aspect); }
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `hasAspect` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `hasAspect` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param aspect RU: значение параметра `aspect` для выполняемой операции. EN: value of `aspect` used by the operation.
     * @return RU: `true`, если условие выполнено; иначе `false`. EN: `true` when the condition is satisfied; otherwise `false`.
     */

    public boolean hasAspect(String nodeId, String aspect) { return metadata.hasAspect(nodeId, aspect); }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `createVersion` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `createVersion` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param request RU: high-level параметры операции. EN: high-level operation parameters.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public NodeEntry createVersion(String nodeId, VersionRequest request) { return versions.createVersion(nodeId, request); }
        /**
     * <p><strong>RU:</strong> изменяет существующий объект Alfresco и возвращает состояние, подтверждённое сервером.</p>
     * <p><strong>EN:</strong> updates an existing Alfresco object and returns the server-confirmed state.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param data RU: значение параметра `data` для выполняемой операции. EN: value of `data` used by the operation.
     * @param request RU: high-level параметры операции. EN: high-level operation parameters.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public NodeEntry updateContent(String nodeId, byte[] data, VersionRequest request) { return versions.updateContent(nodeId, data, request); }
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `versions` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `versions` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public VersionPaging versions(String nodeId, int skip, int size) { return versions.history(nodeId, skip, size); }
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `version` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `version` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param versionId RU: идентификатор версии узла. EN: node version identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public VersionEntry version(String nodeId, String versionId) { return versions.get(nodeId, versionId); }
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `revertVersion` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `revertVersion` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param versionId RU: идентификатор версии узла. EN: node version identifier.
     * @param request RU: high-level параметры операции. EN: high-level operation parameters.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public VersionEntry revertVersion(String nodeId, String versionId, VersionRequest request) { return versions.revert(nodeId, versionId, request); }
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `permissions` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `permissions` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public PermissionSnapshot permissions(String nodeId) { return permissions.get(nodeId); }
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `grantPermission` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `grantPermission` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param authorityId RU: значение параметра `authorityId` для выполняемой операции. EN: value of `authorityId` used by the operation.
     * @param permission RU: описание разрешения/ACL, применяемого к узлу. EN: permission/ACL definition applied to the node.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public Node grantPermission(String nodeId, String authorityId, String permission) { return permissions.grant(nodeId, authorityId, permission); }
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `denyPermission` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `denyPermission` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param authorityId RU: значение параметра `authorityId` для выполняемой операции. EN: value of `authorityId` used by the operation.
     * @param permission RU: описание разрешения/ACL, применяемого к узлу. EN: permission/ACL definition applied to the node.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public Node denyPermission(String nodeId, String authorityId, String permission) { return permissions.deny(nodeId, authorityId, permission); }
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `revokePermission` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `revokePermission` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param authorityId RU: значение параметра `authorityId` для выполняемой операции. EN: value of `authorityId` used by the operation.
     * @param permission RU: описание разрешения/ACL, применяемого к узлу. EN: permission/ACL definition applied to the node.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public Node revokePermission(String nodeId, String authorityId, String permission) { return permissions.revoke(nodeId, authorityId, permission); }
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `revokeAllPermissions` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `revokeAllPermissions` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param authorityId RU: значение параметра `authorityId` для выполняемой операции. EN: value of `authorityId` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public Node revokeAllPermissions(String nodeId, String authorityId) { return permissions.revokeAll(nodeId, authorityId); }
        /**
     * <p><strong>RU:</strong> устанавливает требуемое состояние или значение в Alfresco и возвращает результат операции.</p>
     * <p><strong>EN:</strong> sets the requested state or value in Alfresco and returns the operation result.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param enabled RU: требуемое состояние включено/выключено. EN: desired enabled/disabled state.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public Node setPermissionInheritance(String nodeId, boolean enabled) { return permissions.setInheritance(nodeId, enabled); }

        /**
     * <p><strong>RU:</strong> добавляет связь, значение или дочерний объект к существующему объекту Alfresco.</p>
     * <p><strong>EN:</strong> adds a relation, value, or child object to an existing Alfresco object.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param tag RU: значение параметра `tag` для выполняемой операции. EN: value of `tag` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public pro.abgrid.alfresco.dto.core.TagEntry addTag(String nodeId, String tag) { return tags.add(nodeId, tag); }
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `tags` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `tags` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public pro.abgrid.alfresco.dto.core.TagPaging tags(String nodeId, int skip, int size) { return tags.list(nodeId, skip, size); }
        /**
     * <p><strong>RU:</strong> перемещает существующий узел в другую папку репозитория.</p>
     * <p><strong>EN:</strong> moves an existing node to another repository folder.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param tagId RU: идентификатор тега. EN: tag identifier.
     */

    public void removeTag(String nodeId, String tagId) { tags.remove(nodeId, tagId); }

        /**
     * <p><strong>RU:</strong> добавляет связь, значение или дочерний объект к существующему объекту Alfresco.</p>
     * <p><strong>EN:</strong> adds a relation, value, or child object to an existing Alfresco object.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param text RU: текст пользовательского полнотекстового запроса. EN: user full-text query.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public pro.abgrid.alfresco.dto.core.CommentEntry addComment(String nodeId, String text) { return comments.add(nodeId, text); }
        /**
     * <p><strong>RU:</strong> изменяет существующий объект Alfresco и возвращает состояние, подтверждённое сервером.</p>
     * <p><strong>EN:</strong> updates an existing Alfresco object and returns the server-confirmed state.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param commentId RU: идентификатор комментария. EN: comment identifier.
     * @param text RU: текст пользовательского полнотекстового запроса. EN: user full-text query.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public pro.abgrid.alfresco.dto.core.CommentEntry updateComment(String nodeId, String commentId, String text) { return comments.update(nodeId, commentId, text); }
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `comments` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `comments` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public pro.abgrid.alfresco.dto.core.CommentPaging comments(String nodeId, int skip, int size) { return comments.list(nodeId, skip, size); }
        /**
     * <p><strong>RU:</strong> удаляет соответствующий объект Alfresco; используйте метод, когда объект больше не должен быть доступен через репозиторий.</p>
     * <p><strong>EN:</strong> deletes the corresponding Alfresco object; use it when the object should no longer be available through the repository.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param commentId RU: идентификатор комментария. EN: comment identifier.
     */

    public void deleteComment(String nodeId, String commentId) { comments.delete(nodeId, commentId); }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `like` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `like` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public pro.abgrid.alfresco.dto.core.RatingEntry like(String nodeId) { return ratings.like(nodeId); }
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `fiveStar` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `fiveStar` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param stars RU: значение параметра `stars` для выполняемой операции. EN: value of `stars` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public pro.abgrid.alfresco.dto.core.RatingEntry fiveStar(String nodeId, int stars) { return ratings.fiveStar(nodeId, stars); }
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `ratings` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `ratings` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public pro.abgrid.alfresco.dto.core.RatingPaging ratings(String nodeId, int skip, int size) { return ratings.list(nodeId, skip, size); }
        /**
     * <p><strong>RU:</strong> перемещает существующий узел в другую папку репозитория.</p>
     * <p><strong>EN:</strong> moves an existing node to another repository folder.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param scheme RU: значение параметра `scheme` для выполняемой операции. EN: value of `scheme` used by the operation.
     */

    public void removeRating(String nodeId, String scheme) { ratings.remove(nodeId, scheme); }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `favorite` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `favorite` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public pro.abgrid.alfresco.dto.core.FavoriteEntry favorite(String nodeId) { return favorites.addFile(nodeId); }
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `unfavorite` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `unfavorite` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param favoriteId RU: значение параметра `favoriteId` для выполняемой операции. EN: value of `favoriteId` used by the operation.
     */

    public void unfavorite(String favoriteId) { favorites.remove(favoriteId); }

}
