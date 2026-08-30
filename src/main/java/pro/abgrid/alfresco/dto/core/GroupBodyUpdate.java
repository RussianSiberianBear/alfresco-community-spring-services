package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: GroupBodyUpdate.
 * EN: Alfresco REST API DTO model: GroupBodyUpdate.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupBodyUpdate {
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
     * RU: Создаёт экземпляр GroupBodyUpdate.
     * EN: Creates a GroupBodyUpdate instance.
     */
    public GroupBodyUpdate() {
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

}
