package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

/**
 * RU: DTO-модель Alfresco REST API: Constraint.
 * EN: Alfresco REST API DTO model: Constraint.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Constraint {
    /**
     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the id field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private String id;

    /**

     * <p><strong>RU:</strong> значение поля «type» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> the type of the constraint. Optional unless a specific endpoint requires it.</p>

     */

    private String type;

    /**

     * <p><strong>RU:</strong> значение поля «title» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> the human-readable constraint title. Optional unless a specific endpoint requires it.</p>

     */

    private String title;

    /**

     * <p><strong>RU:</strong> значение поля «description» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> the human-readable constraint description. Optional unless a specific endpoint requires it.</p>

     */

    private String description;

    /**

     * <p><strong>RU:</strong> значение поля «parameters» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the parameters field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Map<String, Map<String, Object>> parameters;

    /**
     * RU: Создаёт экземпляр Constraint.
     * EN: Creates a Constraint instance.
     */
    public Constraint() {
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
     * <p><strong>RU:</strong> Возвращает значение поля «type» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns the type of the constraint.</p>
     *
     * @return RU: текущее значение type. EN: current value of type.
     */

    public String getType() {
        return type;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «type» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets the type of the constraint.</p>
     *
     * @param type RU: новое значение type. EN: new value for type.
     */

    public void setType(String type) {
        this.type = type;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «title» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns the human-readable constraint title.</p>
     *
     * @return RU: текущее значение title. EN: current value of title.
     */

    public String getTitle() {
        return title;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «title» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets the human-readable constraint title.</p>
     *
     * @param title RU: новое значение title. EN: new value for title.
     */

    public void setTitle(String title) {
        this.title = title;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «description» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns the human-readable constraint description.</p>
     *
     * @return RU: текущее значение description. EN: current value of description.
     */

    public String getDescription() {
        return description;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «description» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets the human-readable constraint description.</p>
     *
     * @param description RU: новое значение description. EN: new value for description.
     */

    public void setDescription(String description) {
        this.description = description;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «parameters» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the parameters field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение parameters. EN: current value of parameters.
     */

    public Map<String, Map<String, Object>> getParameters() {
        return parameters;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «parameters» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the parameters field in the Alfresco REST API model.</p>
     *
     * @param parameters RU: новое значение parameters. EN: new value for parameters.
     */

    public void setParameters(Map<String, Map<String, Object>> parameters) {
        this.parameters = parameters;
    }

}
