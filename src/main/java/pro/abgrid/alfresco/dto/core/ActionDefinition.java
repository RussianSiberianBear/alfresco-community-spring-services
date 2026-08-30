package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * RU: DTO-модель Alfresco REST API: ActionDefinition.
 * EN: Alfresco REST API DTO model: ActionDefinition.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActionDefinition {
    /**
     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Identifier of the action definition — used for example when executing an action. Required by the Swagger schema.</p>
     */
    private String id;

    /**

     * <p><strong>RU:</strong> имя ресурса Alfresco. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> name of the action definition, e.g. "move". Optional unless a specific endpoint requires it.</p>

     */

    private String name;

    /**

     * <p><strong>RU:</strong> значение поля «title» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> title of the action definition, e.g. "Move". Optional unless a specific endpoint requires it.</p>

     */

    private String title;

    /**

     * <p><strong>RU:</strong> значение поля «description» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> describes the action definition, e.g. "This will move the matched item to another space.". Optional unless a specific endpoint requires it.</p>

     */

    private String description;

    /**

     * <p><strong>RU:</strong> значение поля «applicable types» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> QNames of the types this action applies to. Required by the Swagger schema.</p>

     */

    private List<String> applicableTypes;

    /**

     * <p><strong>RU:</strong> значение поля «track status» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> whether the basic action definition supports action tracking or not. Required by the Swagger schema.</p>

     */

    private Boolean trackStatus;

    /**

     * <p><strong>RU:</strong> значение поля «parameter definitions» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the parameter definitions field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private List<ActionParameterDefinition> parameterDefinitions;

    /**
     * RU: Создаёт экземпляр ActionDefinition.
     * EN: Creates a ActionDefinition instance.
     */
    public ActionDefinition() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Returns Identifier of the action definition — used for example when executing an action.</p>
     *
     * @return RU: текущее значение id. EN: current value of id.
     */

    public String getId() {
        return id;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Sets Identifier of the action definition — used for example when executing an action.</p>
     *
     * @param id RU: новое значение id. EN: new value for id.
     */

    public void setId(String id) {
        this.id = id;
    }

        /**
     * <p><strong>RU:</strong> Возвращает имя ресурса Alfresco.</p>
     * <p><strong>EN:</strong> Returns name of the action definition, e.g. "move".</p>
     *
     * @return RU: текущее значение name. EN: current value of name.
     */

    public String getName() {
        return name;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает имя ресурса Alfresco.</p>
     * <p><strong>EN:</strong> Sets name of the action definition, e.g. "move".</p>
     *
     * @param name RU: новое значение name. EN: new value for name.
     */

    public void setName(String name) {
        this.name = name;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «title» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns title of the action definition, e.g. "Move".</p>
     *
     * @return RU: текущее значение title. EN: current value of title.
     */

    public String getTitle() {
        return title;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «title» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets title of the action definition, e.g. "Move".</p>
     *
     * @param title RU: новое значение title. EN: new value for title.
     */

    public void setTitle(String title) {
        this.title = title;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «description» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns describes the action definition, e.g. "This will move the matched item to another space.".</p>
     *
     * @return RU: текущее значение description. EN: current value of description.
     */

    public String getDescription() {
        return description;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «description» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets describes the action definition, e.g. "This will move the matched item to another space.".</p>
     *
     * @param description RU: новое значение description. EN: new value for description.
     */

    public void setDescription(String description) {
        this.description = description;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «applicable types» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns QNames of the types this action applies to.</p>
     *
     * @return RU: текущее значение applicableTypes. EN: current value of applicableTypes.
     */

    public List<String> getApplicableTypes() {
        return applicableTypes;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «applicable types» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets QNames of the types this action applies to.</p>
     *
     * @param applicableTypes RU: новое значение applicableTypes. EN: new value for applicableTypes.
     */

    public void setApplicableTypes(List<String> applicableTypes) {
        this.applicableTypes = applicableTypes;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «track status» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns whether the basic action definition supports action tracking or not.</p>
     *
     * @return RU: текущее значение trackStatus. EN: current value of trackStatus.
     */

    public Boolean getTrackStatus() {
        return trackStatus;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «track status» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets whether the basic action definition supports action tracking or not.</p>
     *
     * @param trackStatus RU: новое значение trackStatus. EN: new value for trackStatus.
     */

    public void setTrackStatus(Boolean trackStatus) {
        this.trackStatus = trackStatus;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «parameter definitions» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the parameter definitions field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение parameterDefinitions. EN: current value of parameterDefinitions.
     */

    public List<ActionParameterDefinition> getParameterDefinitions() {
        return parameterDefinitions;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «parameter definitions» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the parameter definitions field in the Alfresco REST API model.</p>
     *
     * @param parameterDefinitions RU: новое значение parameterDefinitions. EN: new value for parameterDefinitions.
     */

    public void setParameterDefinitions(List<ActionParameterDefinition> parameterDefinitions) {
        this.parameterDefinitions = parameterDefinitions;
    }

}
