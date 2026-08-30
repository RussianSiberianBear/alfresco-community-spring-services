package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: PreferenceBodyUpdate.
 * EN: Alfresco REST API DTO model: PreferenceBodyUpdate.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PreferenceBodyUpdate {
    /**
     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> The unique id of the preference. Required by the Swagger schema.</p>
     */
    private String id;

    /**

     * <p><strong>RU:</strong> значение поля «value» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The value of the preference. Note that this can be of any JSON type.. Optional unless a specific endpoint requires it.</p>

     */

    private String value;

    /**
     * RU: Создаёт экземпляр PreferenceBodyUpdate.
     * EN: Creates a PreferenceBodyUpdate instance.
     */
    public PreferenceBodyUpdate() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Returns The unique id of the preference.</p>
     *
     * @return RU: текущее значение id. EN: current value of id.
     */

    public String getId() {
        return id;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Sets The unique id of the preference.</p>
     *
     * @param id RU: новое значение id. EN: new value for id.
     */

    public void setId(String id) {
        this.id = id;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «value» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The value of the preference. Note that this can be of any JSON type..</p>
     *
     * @return RU: текущее значение value. EN: current value of value.
     */

    public String getValue() {
        return value;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «value» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The value of the preference. Note that this can be of any JSON type..</p>
     *
     * @param value RU: новое значение value. EN: new value for value.
     */

    public void setValue(String value) {
        this.value = value;
    }

}
