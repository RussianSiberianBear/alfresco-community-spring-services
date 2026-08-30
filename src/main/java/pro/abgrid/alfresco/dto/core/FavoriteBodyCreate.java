package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

/**
 * RU: DTO-модель Alfresco REST API: FavoriteBodyCreate.
 * EN: Alfresco REST API DTO model: FavoriteBodyCreate.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FavoriteBodyCreate {
    /**
     * <p><strong>RU:</strong> значение поля «target» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the target field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private Map<String, Object> target;

    /**
     * RU: Создаёт экземпляр FavoriteBodyCreate.
     * EN: Creates a FavoriteBodyCreate instance.
     */
    public FavoriteBodyCreate() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «target» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the target field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение target. EN: current value of target.
     */

    public Map<String, Object> getTarget() {
        return target;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «target» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the target field in the Alfresco REST API model.</p>
     *
     * @param target RU: новое значение target. EN: new value for target.
     */

    public void setTarget(Map<String, Object> target) {
        this.target = target;
    }

}
