package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

/**
 * RU: DTO-модель Alfresco REST API: DeletedNode.
 * EN: Alfresco REST API DTO model: DeletedNode.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeletedNode {
    /**
     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Value of the id field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>
     */
    private String id;

    /**

     * <p><strong>RU:</strong> имя ресурса Alfresco. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the name field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String name;

    /**

     * <p><strong>RU:</strong> QName типа узла Alfresco. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the node type field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String nodeType;

    /**

     * <p><strong>RU:</strong> признак папки. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the is folder field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean isFolder;

    /**

     * <p><strong>RU:</strong> признак файла/документа. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the is file field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean isFile;

    /**

     * <p><strong>RU:</strong> значение поля «is locked» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the is locked field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean isLocked;

    /**

     * <p><strong>RU:</strong> дата и время последнего изменения. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the modified at field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private OffsetDateTime modifiedAt;

    /**

     * <p><strong>RU:</strong> пользователь, изменивший ресурс последним. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the modified by user field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private UserInfo modifiedByUser;

    /**

     * <p><strong>RU:</strong> дата и время создания. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the created at field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private OffsetDateTime createdAt;

    /**

     * <p><strong>RU:</strong> пользователь, создавший ресурс. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the created by user field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private UserInfo createdByUser;

    /**

     * <p><strong>RU:</strong> идентификатор родительского узла. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the parent id field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String parentId;

    /**

     * <p><strong>RU:</strong> значение поля «is link» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the is link field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean isLink;

    /**

     * <p><strong>RU:</strong> значение поля «is favorite» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the is favorite field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean isFavorite;

    /**

     * <p><strong>RU:</strong> значение поля «is direct link enabled» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the is direct link enabled field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean isDirectLinkEnabled;

    /**

     * <p><strong>RU:</strong> метаданные бинарного содержимого. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the content field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private ContentInfo content;

    /**

     * <p><strong>RU:</strong> QName аспектов, применённых к узлу. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the aspect names field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private List<String> aspectNames;

    /**

     * <p><strong>RU:</strong> динамические свойства Alfresco, индексированные по QName. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the properties field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Map<String, Object> properties;

    /**

     * <p><strong>RU:</strong> значение поля «allowable operations» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the allowable operations field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private List<String> allowableOperations;

    /**

     * <p><strong>RU:</strong> значение поля «path» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the path field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private PathInfo path;

    /**

     * <p><strong>RU:</strong> данные permissions/ACL. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the permissions field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private PermissionsInfo permissions;

    /**

     * <p><strong>RU:</strong> значение поля «definition» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the definition field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Definition definition;

    /**

     * <p><strong>RU:</strong> значение поля «archived by user» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the archived by user field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private UserInfo archivedByUser;

    /**

     * <p><strong>RU:</strong> значение поля «archived at» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the archived at field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private OffsetDateTime archivedAt;

    /**
     * RU: Создаёт экземпляр DeletedNode.
     * EN: Creates a DeletedNode instance.
     */
    public DeletedNode() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Returns Value of the id field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение id. EN: current value of id.
     */

    public String getId() {
        return id;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Sets Value of the id field in the Alfresco REST API model.</p>
     *
     * @param id RU: новое значение id. EN: new value for id.
     */

    public void setId(String id) {
        this.id = id;
    }

        /**
     * <p><strong>RU:</strong> Возвращает имя ресурса Alfresco.</p>
     * <p><strong>EN:</strong> Returns Value of the name field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение name. EN: current value of name.
     */

    public String getName() {
        return name;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает имя ресурса Alfresco.</p>
     * <p><strong>EN:</strong> Sets Value of the name field in the Alfresco REST API model.</p>
     *
     * @param name RU: новое значение name. EN: new value for name.
     */

    public void setName(String name) {
        this.name = name;
    }

        /**
     * <p><strong>RU:</strong> Возвращает QName типа узла Alfresco.</p>
     * <p><strong>EN:</strong> Returns Value of the node type field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение nodeType. EN: current value of nodeType.
     */

    public String getNodeType() {
        return nodeType;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает QName типа узла Alfresco.</p>
     * <p><strong>EN:</strong> Sets Value of the node type field in the Alfresco REST API model.</p>
     *
     * @param nodeType RU: новое значение nodeType. EN: new value for nodeType.
     */

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

        /**
     * <p><strong>RU:</strong> Возвращает признак папки.</p>
     * <p><strong>EN:</strong> Returns Value of the is folder field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение isFolder. EN: current value of isFolder.
     */

    public Boolean getIsFolder() {
        return isFolder;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает признак папки.</p>
     * <p><strong>EN:</strong> Sets Value of the is folder field in the Alfresco REST API model.</p>
     *
     * @param isFolder RU: новое значение isFolder. EN: new value for isFolder.
     */

    public void setIsFolder(Boolean isFolder) {
        this.isFolder = isFolder;
    }

        /**
     * <p><strong>RU:</strong> Возвращает признак файла/документа.</p>
     * <p><strong>EN:</strong> Returns Value of the is file field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение isFile. EN: current value of isFile.
     */

    public Boolean getIsFile() {
        return isFile;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает признак файла/документа.</p>
     * <p><strong>EN:</strong> Sets Value of the is file field in the Alfresco REST API model.</p>
     *
     * @param isFile RU: новое значение isFile. EN: new value for isFile.
     */

    public void setIsFile(Boolean isFile) {
        this.isFile = isFile;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «is locked» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the is locked field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение isLocked. EN: current value of isLocked.
     */

    public Boolean getIsLocked() {
        return isLocked;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «is locked» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the is locked field in the Alfresco REST API model.</p>
     *
     * @param isLocked RU: новое значение isLocked. EN: new value for isLocked.
     */

    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;
    }

        /**
     * <p><strong>RU:</strong> Возвращает дата и время последнего изменения.</p>
     * <p><strong>EN:</strong> Returns Value of the modified at field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение modifiedAt. EN: current value of modifiedAt.
     */

    public OffsetDateTime getModifiedAt() {
        return modifiedAt;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает дата и время последнего изменения.</p>
     * <p><strong>EN:</strong> Sets Value of the modified at field in the Alfresco REST API model.</p>
     *
     * @param modifiedAt RU: новое значение modifiedAt. EN: new value for modifiedAt.
     */

    public void setModifiedAt(OffsetDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

        /**
     * <p><strong>RU:</strong> Возвращает пользователь, изменивший ресурс последним.</p>
     * <p><strong>EN:</strong> Returns Value of the modified by user field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение modifiedByUser. EN: current value of modifiedByUser.
     */

    public UserInfo getModifiedByUser() {
        return modifiedByUser;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает пользователь, изменивший ресурс последним.</p>
     * <p><strong>EN:</strong> Sets Value of the modified by user field in the Alfresco REST API model.</p>
     *
     * @param modifiedByUser RU: новое значение modifiedByUser. EN: new value for modifiedByUser.
     */

    public void setModifiedByUser(UserInfo modifiedByUser) {
        this.modifiedByUser = modifiedByUser;
    }

        /**
     * <p><strong>RU:</strong> Возвращает дата и время создания.</p>
     * <p><strong>EN:</strong> Returns Value of the created at field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение createdAt. EN: current value of createdAt.
     */

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает дата и время создания.</p>
     * <p><strong>EN:</strong> Sets Value of the created at field in the Alfresco REST API model.</p>
     *
     * @param createdAt RU: новое значение createdAt. EN: new value for createdAt.
     */

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

        /**
     * <p><strong>RU:</strong> Возвращает пользователь, создавший ресурс.</p>
     * <p><strong>EN:</strong> Returns Value of the created by user field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение createdByUser. EN: current value of createdByUser.
     */

    public UserInfo getCreatedByUser() {
        return createdByUser;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает пользователь, создавший ресурс.</p>
     * <p><strong>EN:</strong> Sets Value of the created by user field in the Alfresco REST API model.</p>
     *
     * @param createdByUser RU: новое значение createdByUser. EN: new value for createdByUser.
     */

    public void setCreatedByUser(UserInfo createdByUser) {
        this.createdByUser = createdByUser;
    }

        /**
     * <p><strong>RU:</strong> Возвращает идентификатор родительского узла.</p>
     * <p><strong>EN:</strong> Returns Value of the parent id field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение parentId. EN: current value of parentId.
     */

    public String getParentId() {
        return parentId;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает идентификатор родительского узла.</p>
     * <p><strong>EN:</strong> Sets Value of the parent id field in the Alfresco REST API model.</p>
     *
     * @param parentId RU: новое значение parentId. EN: new value for parentId.
     */

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «is link» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the is link field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение isLink. EN: current value of isLink.
     */

    public Boolean getIsLink() {
        return isLink;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «is link» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the is link field in the Alfresco REST API model.</p>
     *
     * @param isLink RU: новое значение isLink. EN: new value for isLink.
     */

    public void setIsLink(Boolean isLink) {
        this.isLink = isLink;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «is favorite» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the is favorite field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение isFavorite. EN: current value of isFavorite.
     */

    public Boolean getIsFavorite() {
        return isFavorite;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «is favorite» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the is favorite field in the Alfresco REST API model.</p>
     *
     * @param isFavorite RU: новое значение isFavorite. EN: new value for isFavorite.
     */

    public void setIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «is direct link enabled» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the is direct link enabled field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение isDirectLinkEnabled. EN: current value of isDirectLinkEnabled.
     */

    public Boolean getIsDirectLinkEnabled() {
        return isDirectLinkEnabled;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «is direct link enabled» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the is direct link enabled field in the Alfresco REST API model.</p>
     *
     * @param isDirectLinkEnabled RU: новое значение isDirectLinkEnabled. EN: new value for isDirectLinkEnabled.
     */

    public void setIsDirectLinkEnabled(Boolean isDirectLinkEnabled) {
        this.isDirectLinkEnabled = isDirectLinkEnabled;
    }

        /**
     * <p><strong>RU:</strong> Возвращает метаданные бинарного содержимого.</p>
     * <p><strong>EN:</strong> Returns Value of the content field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение content. EN: current value of content.
     */

    public ContentInfo getContent() {
        return content;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает метаданные бинарного содержимого.</p>
     * <p><strong>EN:</strong> Sets Value of the content field in the Alfresco REST API model.</p>
     *
     * @param content RU: новое значение content. EN: new value for content.
     */

    public void setContent(ContentInfo content) {
        this.content = content;
    }

        /**
     * <p><strong>RU:</strong> Возвращает QName аспектов, применённых к узлу.</p>
     * <p><strong>EN:</strong> Returns Value of the aspect names field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение aspectNames. EN: current value of aspectNames.
     */

    public List<String> getAspectNames() {
        return aspectNames;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает QName аспектов, применённых к узлу.</p>
     * <p><strong>EN:</strong> Sets Value of the aspect names field in the Alfresco REST API model.</p>
     *
     * @param aspectNames RU: новое значение aspectNames. EN: new value for aspectNames.
     */

    public void setAspectNames(List<String> aspectNames) {
        this.aspectNames = aspectNames;
    }

        /**
     * <p><strong>RU:</strong> Возвращает динамические свойства Alfresco, индексированные по QName.</p>
     * <p><strong>EN:</strong> Returns Value of the properties field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение properties. EN: current value of properties.
     */

    public Map<String, Object> getProperties() {
        return properties;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает динамические свойства Alfresco, индексированные по QName.</p>
     * <p><strong>EN:</strong> Sets Value of the properties field in the Alfresco REST API model.</p>
     *
     * @param properties RU: новое значение properties. EN: new value for properties.
     */

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «allowable operations» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the allowable operations field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение allowableOperations. EN: current value of allowableOperations.
     */

    public List<String> getAllowableOperations() {
        return allowableOperations;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «allowable operations» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the allowable operations field in the Alfresco REST API model.</p>
     *
     * @param allowableOperations RU: новое значение allowableOperations. EN: new value for allowableOperations.
     */

    public void setAllowableOperations(List<String> allowableOperations) {
        this.allowableOperations = allowableOperations;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «path» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the path field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение path. EN: current value of path.
     */

    public PathInfo getPath() {
        return path;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «path» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the path field in the Alfresco REST API model.</p>
     *
     * @param path RU: новое значение path. EN: new value for path.
     */

    public void setPath(PathInfo path) {
        this.path = path;
    }

        /**
     * <p><strong>RU:</strong> Возвращает данные permissions/ACL.</p>
     * <p><strong>EN:</strong> Returns Value of the permissions field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение permissions. EN: current value of permissions.
     */

    public PermissionsInfo getPermissions() {
        return permissions;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает данные permissions/ACL.</p>
     * <p><strong>EN:</strong> Sets Value of the permissions field in the Alfresco REST API model.</p>
     *
     * @param permissions RU: новое значение permissions. EN: new value for permissions.
     */

    public void setPermissions(PermissionsInfo permissions) {
        this.permissions = permissions;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «definition» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the definition field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение definition. EN: current value of definition.
     */

    public Definition getDefinition() {
        return definition;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «definition» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the definition field in the Alfresco REST API model.</p>
     *
     * @param definition RU: новое значение definition. EN: new value for definition.
     */

    public void setDefinition(Definition definition) {
        this.definition = definition;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «archived by user» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the archived by user field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение archivedByUser. EN: current value of archivedByUser.
     */

    public UserInfo getArchivedByUser() {
        return archivedByUser;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «archived by user» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the archived by user field in the Alfresco REST API model.</p>
     *
     * @param archivedByUser RU: новое значение archivedByUser. EN: new value for archivedByUser.
     */

    public void setArchivedByUser(UserInfo archivedByUser) {
        this.archivedByUser = archivedByUser;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «archived at» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the archived at field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение archivedAt. EN: current value of archivedAt.
     */

    public OffsetDateTime getArchivedAt() {
        return archivedAt;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «archived at» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the archived at field in the Alfresco REST API model.</p>
     *
     * @param archivedAt RU: новое значение archivedAt. EN: new value for archivedAt.
     */

    public void setArchivedAt(OffsetDateTime archivedAt) {
        this.archivedAt = archivedAt;
    }

}
