package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: UserInfo.
 * EN: Alfresco REST API DTO model: UserInfo.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfo {
    /**
     * <p><strong>RU:</strong> значение поля «display name» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the display name field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private String displayName;

    /**

     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the id field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private String id;

    /**
     * RU: Создаёт экземпляр UserInfo.
     * EN: Creates a UserInfo instance.
     */
    public UserInfo() {
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

}
