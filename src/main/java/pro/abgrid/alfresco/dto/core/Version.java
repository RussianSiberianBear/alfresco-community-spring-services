package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

/**
 * RU: DTO-модель Alfresco REST API: Version.
 * EN: Alfresco REST API DTO model: Version.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Version {
    /**
     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the id field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private String id;

    /**

     * <p><strong>RU:</strong> значение поля «version comment» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the version comment field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String versionComment;

    /**

     * <p><strong>RU:</strong> имя ресурса Alfresco. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> The name must not contain spaces or the following special characters: * " &lt; &gt; \ / ? : and |. The character . must not be used at the end of the name.. Required by the Swagger schema.</p>

     */

    private String name;

    /**

     * <p><strong>RU:</strong> QName типа узла Alfresco. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the node type field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private String nodeType;

    /**

     * <p><strong>RU:</strong> признак папки. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the is folder field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private Boolean isFolder;

    /**

     * <p><strong>RU:</strong> признак файла/документа. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the is file field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private Boolean isFile;

    /**

     * <p><strong>RU:</strong> дата и время последнего изменения. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the modified at field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private OffsetDateTime modifiedAt;

    /**

     * <p><strong>RU:</strong> пользователь, изменивший ресурс последним. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the modified by user field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private UserInfo modifiedByUser;

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
     * RU: Создаёт экземпляр Version.
     * EN: Creates a Version instance.
     */
    public Version() {
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
     * <p><strong>RU:</strong> Возвращает значение поля «version comment» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the version comment field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение versionComment. EN: current value of versionComment.
     */

    public String getVersionComment() {
        return versionComment;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «version comment» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the version comment field in the Alfresco REST API model.</p>
     *
     * @param versionComment RU: новое значение versionComment. EN: new value for versionComment.
     */

    public void setVersionComment(String versionComment) {
        this.versionComment = versionComment;
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

}
