package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * RU: DTO-модель Alfresco REST API: CascadingDictLevel.
 * EN: Alfresco REST API DTO model: CascadingDictLevel.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CascadingDictLevel {
    /**
     * <p><strong>RU:</strong> значение поля «level» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> The level number of the cascading dictionary definition (starting with 0 for the top level). Required by the Swagger schema.</p>
     */
    private Integer level;

    /**

     * <p><strong>RU:</strong> динамические свойства Alfresco, индексированные по QName. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> The prefixed names of all properties at this level. Required by the Swagger schema.</p>

     */

    private List<String> properties;

    /**
     * RU: Создаёт экземпляр CascadingDictLevel.
     * EN: Creates a CascadingDictLevel instance.
     */
    public CascadingDictLevel() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «level» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The level number of the cascading dictionary definition (starting with 0 for the top level).</p>
     *
     * @return RU: текущее значение level. EN: current value of level.
     */

    public Integer getLevel() {
        return level;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «level» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The level number of the cascading dictionary definition (starting with 0 for the top level).</p>
     *
     * @param level RU: новое значение level. EN: new value for level.
     */

    public void setLevel(Integer level) {
        this.level = level;
    }

        /**
     * <p><strong>RU:</strong> Возвращает динамические свойства Alfresco, индексированные по QName.</p>
     * <p><strong>EN:</strong> Returns The prefixed names of all properties at this level.</p>
     *
     * @return RU: текущее значение properties. EN: current value of properties.
     */

    public List<String> getProperties() {
        return properties;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает динамические свойства Alfresco, индексированные по QName.</p>
     * <p><strong>EN:</strong> Sets The prefixed names of all properties at this level.</p>
     *
     * @param properties RU: новое значение properties. EN: new value for properties.
     */

    public void setProperties(List<String> properties) {
        this.properties = properties;
    }

}
