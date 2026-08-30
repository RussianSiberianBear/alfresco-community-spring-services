package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * RU: DTO-модель Alfresco REST API: GroupBodyCreate.
 * EN: Alfresco REST API DTO model: GroupBodyCreate.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupBodyCreate {
    /**
     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the id field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private String id;

    /**

     * <p><strong>RU:</strong> значение поля «display name» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the display name field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private String displayName;

    /**

     * <p><strong>RU:</strong> значение поля «description» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the description field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String description;

    /**

     * <p><strong>RU:</strong> значение поля «parent ids» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the parent ids field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private List<String> parentIds;

    /**
     * RU: Создаёт экземпляр GroupBodyCreate.
     * EN: Creates a GroupBodyCreate instance.
     */
    public GroupBodyCreate() {
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
     * <p><strong>RU:</strong> Возвращает значение поля «display name» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the display name field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение displayName. EN: current value of displayName.
     */

    public String getDisplayName() {
        return displayName;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «display name» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the display name field in the Alfresco REST API model.</p>
     *
     * @param displayName RU: новое значение displayName. EN: new value for displayName.
     */

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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
     * <p><strong>RU:</strong> Возвращает значение поля «parent ids» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the parent ids field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение parentIds. EN: current value of parentIds.
     */

    public List<String> getParentIds() {
        return parentIds;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «parent ids» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the parent ids field in the Alfresco REST API model.</p>
     *
     * @param parentIds RU: новое значение parentIds. EN: new value for parentIds.
     */

    public void setParentIds(List<String> parentIds) {
        this.parentIds = parentIds;
    }

}
