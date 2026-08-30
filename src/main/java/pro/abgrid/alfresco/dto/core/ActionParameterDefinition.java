package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: ActionParameterDefinition.
 * EN: Alfresco REST API DTO model: ActionParameterDefinition.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActionParameterDefinition {
    /**
     * <p><strong>RU:</strong> имя ресурса Alfresco. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Value of the name field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>
     */
    private String name;

    /**

     * <p><strong>RU:</strong> значение поля «type» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the type field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String type;

    /**

     * <p><strong>RU:</strong> значение поля «multi valued» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the multi valued field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean multiValued;

    /**

     * <p><strong>RU:</strong> значение поля «mandatory» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the mandatory field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean mandatory;

    /**

     * <p><strong>RU:</strong> значение поля «display label» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the display label field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String displayLabel;

    /**

     * <p><strong>RU:</strong> значение поля «parameter constraint name» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the parameter constraint name field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String parameterConstraintName;

    /**
     * RU: Создаёт экземпляр ActionParameterDefinition.
     * EN: Creates a ActionParameterDefinition instance.
     */
    public ActionParameterDefinition() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает имя ресурса Alfresco.</p>
     * <p><strong>EN:</strong> Returns Value of the name field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение name. EN: current value of name.
     */

    public String getName() {
        return name;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает имя ресурса Alfresco.</p>
     * <p><strong>EN:</strong> Sets Value of the name field in the Alfresco REST API model.</p>
     *
     * @param name RU: новое значение name. EN: new value for name.
     */

    public void setName(String name) {
        this.name = name;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «type» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the type field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение type. EN: current value of type.
     */

    public String getType() {
        return type;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «type» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the type field in the Alfresco REST API model.</p>
     *
     * @param type RU: новое значение type. EN: new value for type.
     */

    public void setType(String type) {
        this.type = type;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «multi valued» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the multi valued field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение multiValued. EN: current value of multiValued.
     */

    public Boolean getMultiValued() {
        return multiValued;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «multi valued» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the multi valued field in the Alfresco REST API model.</p>
     *
     * @param multiValued RU: новое значение multiValued. EN: new value for multiValued.
     */

    public void setMultiValued(Boolean multiValued) {
        this.multiValued = multiValued;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «mandatory» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the mandatory field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение mandatory. EN: current value of mandatory.
     */

    public Boolean getMandatory() {
        return mandatory;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «mandatory» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the mandatory field in the Alfresco REST API model.</p>
     *
     * @param mandatory RU: новое значение mandatory. EN: new value for mandatory.
     */

    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «display label» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the display label field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение displayLabel. EN: current value of displayLabel.
     */

    public String getDisplayLabel() {
        return displayLabel;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «display label» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the display label field in the Alfresco REST API model.</p>
     *
     * @param displayLabel RU: новое значение displayLabel. EN: new value for displayLabel.
     */

    public void setDisplayLabel(String displayLabel) {
        this.displayLabel = displayLabel;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «parameter constraint name» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the parameter constraint name field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение parameterConstraintName. EN: current value of parameterConstraintName.
     */

    public String getParameterConstraintName() {
        return parameterConstraintName;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «parameter constraint name» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the parameter constraint name field in the Alfresco REST API model.</p>
     *
     * @param parameterConstraintName RU: новое значение parameterConstraintName. EN: new value for parameterConstraintName.
     */

    public void setParameterConstraintName(String parameterConstraintName) {
        this.parameterConstraintName = parameterConstraintName;
    }

}
