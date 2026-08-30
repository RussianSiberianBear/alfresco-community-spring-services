package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * RU: DTO-модель Alfresco REST API: CascadingDictContentBody.
 * EN: Alfresco REST API DTO model: CascadingDictContentBody.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CascadingDictContentBody {
    /**
     * <p><strong>RU:</strong> значение поля «definition» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> The level definitions for the cascading dictionary content, specifying the properties used at each level. This is needed to correctly interpret the content data and validate it against the dictionary registered in the system.. Required by the Swagger schema.</p>
     */
    private CascadingDictContentDef definition;

    /**

     * <p><strong>RU:</strong> значение поля «data» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> The actual content of the cascading dictionary, organized in a hierarchical structure according to the levels defined in the definition object. Each item contains a map of property values and an array of child items for the next level in the hierarchy.. Required by the Swagger schema.</p>

     */

    private List<CascadingDictItem> data;

    /**
     * RU: Создаёт экземпляр CascadingDictContentBody.
     * EN: Creates a CascadingDictContentBody instance.
     */
    public CascadingDictContentBody() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «definition» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The level definitions for the cascading dictionary content, specifying the properties used at each level. This is needed to correctly interpret the content data and validate it against the dictionary registered in the system..</p>
     *
     * @return RU: текущее значение definition. EN: current value of definition.
     */

    public CascadingDictContentDef getDefinition() {
        return definition;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «definition» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The level definitions for the cascading dictionary content, specifying the properties used at each level. This is needed to correctly interpret the content data and validate it against the dictionary registered in the system..</p>
     *
     * @param definition RU: новое значение definition. EN: new value for definition.
     */

    public void setDefinition(CascadingDictContentDef definition) {
        this.definition = definition;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «data» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The actual content of the cascading dictionary, organized in a hierarchical structure according to the levels defined in the definition object. Each item contains a map of property values and an array of child items for the next level in the hierarchy..</p>
     *
     * @return RU: текущее значение data. EN: current value of data.
     */

    public List<CascadingDictItem> getData() {
        return data;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «data» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The actual content of the cascading dictionary, organized in a hierarchical structure according to the levels defined in the definition object. Each item contains a map of property values and an array of child items for the next level in the hierarchy..</p>
     *
     * @param data RU: новое значение data. EN: new value for data.
     */

    public void setData(List<CascadingDictItem> data) {
        this.data = data;
    }

}
