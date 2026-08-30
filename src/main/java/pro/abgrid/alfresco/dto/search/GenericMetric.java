package pro.abgrid.alfresco.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

/**
 * RU: DTO-модель Alfresco REST API: GenericMetric.
 * EN: Alfresco REST API DTO model: GenericMetric.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenericMetric {
    /**
     * <p><strong>RU:</strong> значение поля «type» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> The type of metric, e.g. count. Optional unless a specific endpoint requires it.</p>
     */
    private String type;

    /**

     * <p><strong>RU:</strong> значение поля «value» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The metric value, e.g. {"count": 34}. Optional unless a specific endpoint requires it.</p>

     */

    private Map<String, Object> value;

    /**
     * RU: Создаёт экземпляр GenericMetric.
     * EN: Creates a GenericMetric instance.
     */
    public GenericMetric() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «type» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The type of metric, e.g. count.</p>
     *
     * @return RU: текущее значение type. EN: current value of type.
     */

    public String getType() {
        return type;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «type» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The type of metric, e.g. count.</p>
     *
     * @param type RU: новое значение type. EN: new value for type.
     */

    public void setType(String type) {
        this.type = type;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «value» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The metric value, e.g. {"count": 34}.</p>
     *
     * @return RU: текущее значение value. EN: current value of value.
     */

    public Map<String, Object> getValue() {
        return value;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «value» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The metric value, e.g. {"count": 34}.</p>
     *
     * @param value RU: новое значение value. EN: new value for value.
     */

    public void setValue(Map<String, Object> value) {
        this.value = value;
    }

}
