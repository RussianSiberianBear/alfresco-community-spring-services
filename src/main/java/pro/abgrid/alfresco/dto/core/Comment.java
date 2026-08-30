package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;

/**
 * RU: DTO-модель Alfresco REST API: Comment.
 * EN: Alfresco REST API DTO model: Comment.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {
    /**
     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the id field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private String id;

    /**

     * <p><strong>RU:</strong> значение поля «title» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the title field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private String title;

    /**

     * <p><strong>RU:</strong> метаданные бинарного содержимого. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the content field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private String content;

    /**

     * <p><strong>RU:</strong> значение поля «created by» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the created by field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private Person createdBy;

    /**

     * <p><strong>RU:</strong> дата и время создания. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the created at field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private OffsetDateTime createdAt;

    /**

     * <p><strong>RU:</strong> значение поля «edited» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the edited field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private Boolean edited;

    /**

     * <p><strong>RU:</strong> значение поля «modified by» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the modified by field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private Person modifiedBy;

    /**

     * <p><strong>RU:</strong> дата и время последнего изменения. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the modified at field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private OffsetDateTime modifiedAt;

    /**

     * <p><strong>RU:</strong> значение поля «can edit» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the can edit field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private Boolean canEdit;

    /**

     * <p><strong>RU:</strong> значение поля «can delete» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the can delete field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private Boolean canDelete;

    /**
     * RU: Создаёт экземпляр Comment.
     * EN: Creates a Comment instance.
     */
    public Comment() {
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
     * <p><strong>RU:</strong> Возвращает метаданные бинарного содержимого.</p>
     * <p><strong>EN:</strong> Returns Value of the content field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение content. EN: current value of content.
     */

    public String getContent() {
        return content;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает метаданные бинарного содержимого.</p>
     * <p><strong>EN:</strong> Sets Value of the content field in the Alfresco REST API model.</p>
     *
     * @param content RU: новое значение content. EN: new value for content.
     */

    public void setContent(String content) {
        this.content = content;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «created by» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the created by field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение createdBy. EN: current value of createdBy.
     */

    public Person getCreatedBy() {
        return createdBy;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «created by» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the created by field in the Alfresco REST API model.</p>
     *
     * @param createdBy RU: новое значение createdBy. EN: new value for createdBy.
     */

    public void setCreatedBy(Person createdBy) {
        this.createdBy = createdBy;
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
     * <p><strong>RU:</strong> Возвращает значение поля «edited» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the edited field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение edited. EN: current value of edited.
     */

    public Boolean getEdited() {
        return edited;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «edited» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the edited field in the Alfresco REST API model.</p>
     *
     * @param edited RU: новое значение edited. EN: new value for edited.
     */

    public void setEdited(Boolean edited) {
        this.edited = edited;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «modified by» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the modified by field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение modifiedBy. EN: current value of modifiedBy.
     */

    public Person getModifiedBy() {
        return modifiedBy;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «modified by» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the modified by field in the Alfresco REST API model.</p>
     *
     * @param modifiedBy RU: новое значение modifiedBy. EN: new value for modifiedBy.
     */

    public void setModifiedBy(Person modifiedBy) {
        this.modifiedBy = modifiedBy;
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
     * <p><strong>RU:</strong> Возвращает значение поля «can edit» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the can edit field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение canEdit. EN: current value of canEdit.
     */

    public Boolean getCanEdit() {
        return canEdit;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «can edit» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the can edit field in the Alfresco REST API model.</p>
     *
     * @param canEdit RU: новое значение canEdit. EN: new value for canEdit.
     */

    public void setCanEdit(Boolean canEdit) {
        this.canEdit = canEdit;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «can delete» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the can delete field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение canDelete. EN: current value of canDelete.
     */

    public Boolean getCanDelete() {
        return canDelete;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «can delete» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the can delete field in the Alfresco REST API model.</p>
     *
     * @param canDelete RU: новое значение canDelete. EN: new value for canDelete.
     */

    public void setCanDelete(Boolean canDelete) {
        this.canDelete = canDelete;
    }

}
