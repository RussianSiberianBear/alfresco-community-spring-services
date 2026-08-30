package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * RU: DTO-модель Alfresco REST API: Property.
 * EN: Alfresco REST API DTO model: Property.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Property {
    /**
     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the id field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private String id;

    /**

     * <p><strong>RU:</strong> значение поля «title» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> the human-readable title. Optional unless a specific endpoint requires it.</p>

     */

    private String title;

    /**

     * <p><strong>RU:</strong> значение поля «description» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> the human-readable description. Optional unless a specific endpoint requires it.</p>

     */

    private String description;

    /**

     * <p><strong>RU:</strong> значение поля «default value» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> the default value. Optional unless a specific endpoint requires it.</p>

     */

    private String defaultValue;

    /**

     * <p><strong>RU:</strong> значение поля «data type» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> the name of the property type (e.g. d:text). Optional unless a specific endpoint requires it.</p>

     */

    private String dataType;

    /**

     * <p><strong>RU:</strong> значение поля «is multi valued» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> define if the property is multi-valued. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean isMultiValued;

    /**

     * <p><strong>RU:</strong> значение поля «is mandatory» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> define if the property is mandatory. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean isMandatory;

    /**

     * <p><strong>RU:</strong> значение поля «is mandatory enforced» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> define if the presence of mandatory properties is enforced. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean isMandatoryEnforced;

    /**

     * <p><strong>RU:</strong> значение поля «is protected» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> define if the property is system maintained. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean isProtected;

    /**

     * <p><strong>RU:</strong> значение поля «constraints» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> list of constraints defined for the property. Optional unless a specific endpoint requires it.</p>

     */

    private List<Constraint> constraints;

    /**
     * RU: Создаёт экземпляр Property.
     * EN: Creates a Property instance.
     */
    public Property() {
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
     * <p><strong>RU:</strong> Возвращает значение поля «title» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns the human-readable title.</p>
     *
     * @return RU: текущее значение title. EN: current value of title.
     */

    public String getTitle() {
        return title;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «title» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets the human-readable title.</p>
     *
     * @param title RU: новое значение title. EN: new value for title.
     */

    public void setTitle(String title) {
        this.title = title;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «description» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns the human-readable description.</p>
     *
     * @return RU: текущее значение description. EN: current value of description.
     */

    public String getDescription() {
        return description;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «description» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets the human-readable description.</p>
     *
     * @param description RU: новое значение description. EN: new value for description.
     */

    public void setDescription(String description) {
        this.description = description;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «default value» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns the default value.</p>
     *
     * @return RU: текущее значение defaultValue. EN: current value of defaultValue.
     */

    public String getDefaultValue() {
        return defaultValue;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «default value» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets the default value.</p>
     *
     * @param defaultValue RU: новое значение defaultValue. EN: new value for defaultValue.
     */

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «data type» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns the name of the property type (e.g. d:text).</p>
     *
     * @return RU: текущее значение dataType. EN: current value of dataType.
     */

    public String getDataType() {
        return dataType;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «data type» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets the name of the property type (e.g. d:text).</p>
     *
     * @param dataType RU: новое значение dataType. EN: new value for dataType.
     */

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «is multi valued» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns define if the property is multi-valued.</p>
     *
     * @return RU: текущее значение isMultiValued. EN: current value of isMultiValued.
     */

    public Boolean getIsMultiValued() {
        return isMultiValued;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «is multi valued» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets define if the property is multi-valued.</p>
     *
     * @param isMultiValued RU: новое значение isMultiValued. EN: new value for isMultiValued.
     */

    public void setIsMultiValued(Boolean isMultiValued) {
        this.isMultiValued = isMultiValued;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «is mandatory» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns define if the property is mandatory.</p>
     *
     * @return RU: текущее значение isMandatory. EN: current value of isMandatory.
     */

    public Boolean getIsMandatory() {
        return isMandatory;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «is mandatory» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets define if the property is mandatory.</p>
     *
     * @param isMandatory RU: новое значение isMandatory. EN: new value for isMandatory.
     */

    public void setIsMandatory(Boolean isMandatory) {
        this.isMandatory = isMandatory;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «is mandatory enforced» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns define if the presence of mandatory properties is enforced.</p>
     *
     * @return RU: текущее значение isMandatoryEnforced. EN: current value of isMandatoryEnforced.
     */

    public Boolean getIsMandatoryEnforced() {
        return isMandatoryEnforced;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «is mandatory enforced» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets define if the presence of mandatory properties is enforced.</p>
     *
     * @param isMandatoryEnforced RU: новое значение isMandatoryEnforced. EN: new value for isMandatoryEnforced.
     */

    public void setIsMandatoryEnforced(Boolean isMandatoryEnforced) {
        this.isMandatoryEnforced = isMandatoryEnforced;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «is protected» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns define if the property is system maintained.</p>
     *
     * @return RU: текущее значение isProtected. EN: current value of isProtected.
     */

    public Boolean getIsProtected() {
        return isProtected;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «is protected» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets define if the property is system maintained.</p>
     *
     * @param isProtected RU: новое значение isProtected. EN: new value for isProtected.
     */

    public void setIsProtected(Boolean isProtected) {
        this.isProtected = isProtected;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «constraints» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns list of constraints defined for the property.</p>
     *
     * @return RU: текущее значение constraints. EN: current value of constraints.
     */

    public List<Constraint> getConstraints() {
        return constraints;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «constraints» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets list of constraints defined for the property.</p>
     *
     * @param constraints RU: новое значение constraints. EN: new value for constraints.
     */

    public void setConstraints(List<Constraint> constraints) {
        this.constraints = constraints;
    }

}
