package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * RU: DTO-модель Alfresco REST API: CompositeConditionDefinition.
 * EN: Alfresco REST API DTO model: CompositeConditionDefinition.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompositeConditionDefinition {
    /**
     * <p><strong>RU:</strong> значение поля «inverted» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Whether to invert the logic for this condition (if true then "not" is applied to the whole condition). Optional unless a specific endpoint requires it.</p>
     */
    private Boolean inverted;

    /**

     * <p><strong>RU:</strong> значение поля «boolean mode» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> How to combine the clauses of this condition ("and" or "or"). Optional unless a specific endpoint requires it.</p>

     */

    private String booleanMode;

    /**

     * <p><strong>RU:</strong> значение поля «composite conditions» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Nested list of composite clauses in this condition. Optional unless a specific endpoint requires it.</p>

     */

    private List<CompositeConditionDefinition> compositeConditions;

    /**

     * <p><strong>RU:</strong> значение поля «simple conditions» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Nested list of simple (per field) conditions.. Optional unless a specific endpoint requires it.</p>

     */

    private List<SimpleConditionDefinition> simpleConditions;

    /**
     * RU: Создаёт экземпляр CompositeConditionDefinition.
     * EN: Creates a CompositeConditionDefinition instance.
     */
    public CompositeConditionDefinition() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «inverted» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Whether to invert the logic for this condition (if true then "not" is applied to the whole condition).</p>
     *
     * @return RU: текущее значение inverted. EN: current value of inverted.
     */

    public Boolean getInverted() {
        return inverted;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «inverted» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Whether to invert the logic for this condition (if true then "not" is applied to the whole condition).</p>
     *
     * @param inverted RU: новое значение inverted. EN: new value for inverted.
     */

    public void setInverted(Boolean inverted) {
        this.inverted = inverted;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «boolean mode» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns How to combine the clauses of this condition ("and" or "or").</p>
     *
     * @return RU: текущее значение booleanMode. EN: current value of booleanMode.
     */

    public String getBooleanMode() {
        return booleanMode;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «boolean mode» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets How to combine the clauses of this condition ("and" or "or").</p>
     *
     * @param booleanMode RU: новое значение booleanMode. EN: new value for booleanMode.
     */

    public void setBooleanMode(String booleanMode) {
        this.booleanMode = booleanMode;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «composite conditions» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Nested list of composite clauses in this condition.</p>
     *
     * @return RU: текущее значение compositeConditions. EN: current value of compositeConditions.
     */

    public List<CompositeConditionDefinition> getCompositeConditions() {
        return compositeConditions;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «composite conditions» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Nested list of composite clauses in this condition.</p>
     *
     * @param compositeConditions RU: новое значение compositeConditions. EN: new value for compositeConditions.
     */

    public void setCompositeConditions(List<CompositeConditionDefinition> compositeConditions) {
        this.compositeConditions = compositeConditions;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «simple conditions» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Nested list of simple (per field) conditions..</p>
     *
     * @return RU: текущее значение simpleConditions. EN: current value of simpleConditions.
     */

    public List<SimpleConditionDefinition> getSimpleConditions() {
        return simpleConditions;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «simple conditions» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Nested list of simple (per field) conditions..</p>
     *
     * @param simpleConditions RU: новое значение simpleConditions. EN: new value for simpleConditions.
     */

    public void setSimpleConditions(List<SimpleConditionDefinition> simpleConditions) {
        this.simpleConditions = simpleConditions;
    }

}
