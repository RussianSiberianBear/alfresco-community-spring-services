package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

/**
 * RU: DTO-модель Alfresco REST API: SharedLink.
 * EN: Alfresco REST API DTO model: SharedLink.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SharedLink {
    /**
     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Value of the id field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>
     */
    private String id;

    /**

     * <p><strong>RU:</strong> значение поля «expires at» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the expires at field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private OffsetDateTime expiresAt;

    /**

     * <p><strong>RU:</strong> значение поля «node id» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the node id field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String nodeId;

    /**

     * <p><strong>RU:</strong> имя ресурса Alfresco. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The name must not contain spaces or the following special characters: * " &lt; &gt; \ / ? : and |. The character . must not be used at the end of the name.. Optional unless a specific endpoint requires it.</p>

     */

    private String name;

    /**

     * <p><strong>RU:</strong> значение поля «title» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the title field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String title;

    /**

     * <p><strong>RU:</strong> значение поля «description» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the description field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String description;

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

     * <p><strong>RU:</strong> значение поля «shared by user» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the shared by user field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private UserInfo sharedByUser;

    /**

     * <p><strong>RU:</strong> метаданные бинарного содержимого. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the content field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private ContentInfo content;

    /**

     * <p><strong>RU:</strong> значение поля «allowable operations» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The allowable operations for the Quickshare link itself. See allowableOperationsOnTarget for the allowable operations pertaining to the linked content node.. Optional unless a specific endpoint requires it.</p>

     */

    private List<String> allowableOperations;

    /**

     * <p><strong>RU:</strong> значение поля «allowable operations on target» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The allowable operations for the content node being shared.. Optional unless a specific endpoint requires it.</p>

     */

    private List<String> allowableOperationsOnTarget;

    /**

     * <p><strong>RU:</strong> значение поля «is favorite» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the is favorite field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean isFavorite;

    /**

     * <p><strong>RU:</strong> динамические свойства Alfresco, индексированные по QName. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> A subset of the target node's properties, system properties and properties already available in the SharedLink are excluded.. Optional unless a specific endpoint requires it.</p>

     */

    private Map<String, Object> properties;

    /**

     * <p><strong>RU:</strong> QName аспектов, применённых к узлу. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the aspect names field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private List<String> aspectNames;

    /**

     * <p><strong>RU:</strong> значение поля «path» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the path field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private PathInfo path;

    /**
     * RU: Создаёт экземпляр SharedLink.
     * EN: Creates a SharedLink instance.
     */
    public SharedLink() {
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
     * <p><strong>RU:</strong> Возвращает значение поля «expires at» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the expires at field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение expiresAt. EN: current value of expiresAt.
     */

    public OffsetDateTime getExpiresAt() {
        return expiresAt;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «expires at» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the expires at field in the Alfresco REST API model.</p>
     *
     * @param expiresAt RU: новое значение expiresAt. EN: new value for expiresAt.
     */

    public void setExpiresAt(OffsetDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «node id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the node id field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение nodeId. EN: current value of nodeId.
     */

    public String getNodeId() {
        return nodeId;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «node id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the node id field in the Alfresco REST API model.</p>
     *
     * @param nodeId RU: новое значение nodeId. EN: new value for nodeId.
     */

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

        /**
     * <p><strong>RU:</strong> Возвращает имя ресурса Alfresco.</p>
     * <p><strong>EN:</strong> Returns The name must not contain spaces or the following special characters: * " &lt; &gt; \ / ? : and |. The character . must not be used at the end of the name..</p>
     *
     * @return RU: текущее значение name. EN: current value of name.
     */

    public String getName() {
        return name;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает имя ресурса Alfresco.</p>
     * <p><strong>EN:</strong> Sets The name must not contain spaces or the following special characters: * " &lt; &gt; \ / ? : and |. The character . must not be used at the end of the name..</p>
     *
     * @param name RU: новое значение name. EN: new value for name.
     */

    public void setName(String name) {
        this.name = name;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «title» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the title field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение title. EN: current value of title.
     */

    public String getTitle() {
        return title;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «title» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the title field in the Alfresco REST API model.</p>
     *
     * @param title RU: новое значение title. EN: new value for title.
     */

    public void setTitle(String title) {
        this.title = title;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «description» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the description field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение description. EN: current value of description.
     */

    public String getDescription() {
        return description;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «description» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the description field in the Alfresco REST API model.</p>
     *
     * @param description RU: новое значение description. EN: new value for description.
     */

    public void setDescription(String description) {
        this.description = description;
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
     * <p><strong>RU:</strong> Возвращает значение поля «shared by user» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the shared by user field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение sharedByUser. EN: current value of sharedByUser.
     */

    public UserInfo getSharedByUser() {
        return sharedByUser;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «shared by user» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the shared by user field in the Alfresco REST API model.</p>
     *
     * @param sharedByUser RU: новое значение sharedByUser. EN: new value for sharedByUser.
     */

    public void setSharedByUser(UserInfo sharedByUser) {
        this.sharedByUser = sharedByUser;
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
     * <p><strong>RU:</strong> Возвращает значение поля «allowable operations» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The allowable operations for the Quickshare link itself. See allowableOperationsOnTarget for the allowable operations pertaining to the linked content node..</p>
     *
     * @return RU: текущее значение allowableOperations. EN: current value of allowableOperations.
     */

    public List<String> getAllowableOperations() {
        return allowableOperations;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «allowable operations» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The allowable operations for the Quickshare link itself. See allowableOperationsOnTarget for the allowable operations pertaining to the linked content node..</p>
     *
     * @param allowableOperations RU: новое значение allowableOperations. EN: new value for allowableOperations.
     */

    public void setAllowableOperations(List<String> allowableOperations) {
        this.allowableOperations = allowableOperations;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «allowable operations on target» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The allowable operations for the content node being shared..</p>
     *
     * @return RU: текущее значение allowableOperationsOnTarget. EN: current value of allowableOperationsOnTarget.
     */

    public List<String> getAllowableOperationsOnTarget() {
        return allowableOperationsOnTarget;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «allowable operations on target» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The allowable operations for the content node being shared..</p>
     *
     * @param allowableOperationsOnTarget RU: новое значение allowableOperationsOnTarget. EN: new value for allowableOperationsOnTarget.
     */

    public void setAllowableOperationsOnTarget(List<String> allowableOperationsOnTarget) {
        this.allowableOperationsOnTarget = allowableOperationsOnTarget;
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
     * <p><strong>RU:</strong> Возвращает динамические свойства Alfresco, индексированные по QName.</p>
     * <p><strong>EN:</strong> Returns A subset of the target node's properties, system properties and properties already available in the SharedLink are excluded..</p>
     *
     * @return RU: текущее значение properties. EN: current value of properties.
     */

    public Map<String, Object> getProperties() {
        return properties;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает динамические свойства Alfresco, индексированные по QName.</p>
     * <p><strong>EN:</strong> Sets A subset of the target node's properties, system properties and properties already available in the SharedLink are excluded..</p>
     *
     * @param properties RU: новое значение properties. EN: new value for properties.
     */

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
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

}
