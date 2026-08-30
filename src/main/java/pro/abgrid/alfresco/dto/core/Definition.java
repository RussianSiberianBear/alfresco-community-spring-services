package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * RU: DTO-модель Alfresco REST API: Definition.
 * EN: Alfresco REST API DTO model: Definition.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Definition {
    /**
     * <p><strong>RU:</strong> динамические свойства Alfresco, индексированные по QName. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> List of property definitions effective for this node as the result of combining the type with all aspects.. Optional unless a specific endpoint requires it.</p>
     */
    private List<Property> properties;

    /**
     * RU: Создаёт экземпляр Definition.
     * EN: Creates a Definition instance.
     */
    public Definition() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает динамические свойства Alfresco, индексированные по QName.</p>
     * <p><strong>EN:</strong> Returns List of property definitions effective for this node as the result of combining the type with all aspects..</p>
     *
     * @return RU: текущее значение properties. EN: current value of properties.
     */

    public List<Property> getProperties() {
        return properties;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает динамические свойства Alfresco, индексированные по QName.</p>
     * <p><strong>EN:</strong> Sets List of property definitions effective for this node as the result of combining the type with all aspects..</p>
     *
     * @param properties RU: новое значение properties. EN: new value for properties.
     */

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

}
