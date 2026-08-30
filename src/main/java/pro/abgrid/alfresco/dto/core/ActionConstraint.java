package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * RU: DTO-модель Alfresco REST API: ActionConstraint.
 * EN: Alfresco REST API DTO model: ActionConstraint.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActionConstraint {
    /**
     * <p><strong>RU:</strong> значение поля «constraint name» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Name of the constraint.. Optional unless a specific endpoint requires it.</p>
     */
    private String constraintName;

    /**

     * <p><strong>RU:</strong> значение поля «constraint values» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> A list of constraint possbile values along with additional data (label, isNode flag). Sample object could be: JSON "constraintValues": [ { "value": "EQUALS", "label": "Equals" }, { "value": "CONTAINS", "label": "Contains" }, { "value": "BEGINS", "label": "Begins With" }, { "value": "ENDS", "label": "Ends With" }, { "value": "GREATER_THAN", "label": "Greater Than" }, { "value": "GREATER_THAN_EQUAL", "label": "Greater Than Or Equal To" }, { "value": "LESS_THAN", "label": "Less Than" }, { "value": "LESS_THAN_EQUAL", "label": "Less Than Or Equal To" } ] or JSON "constraintValues": [ { "value": "fa41fd6e-5640-410f-9f3e-93f268186f69", "label": "Start Pooled Review and Approve Workflow", "isNode": true } ]. Optional unless a specific endpoint requires it.</p>

     */

    private List<ActionConstraintData> constraintValues;

    /**
     * RU: Создаёт экземпляр ActionConstraint.
     * EN: Creates a ActionConstraint instance.
     */
    public ActionConstraint() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «constraint name» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Name of the constraint..</p>
     *
     * @return RU: текущее значение constraintName. EN: current value of constraintName.
     */

    public String getConstraintName() {
        return constraintName;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «constraint name» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Name of the constraint..</p>
     *
     * @param constraintName RU: новое значение constraintName. EN: new value for constraintName.
     */

    public void setConstraintName(String constraintName) {
        this.constraintName = constraintName;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «constraint values» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns A list of constraint possbile values along with additional data (label, isNode flag). Sample object could be: JSON "constraintValues": [ { "value": "EQUALS", "label": "Equals" }, { "value": "CONTAINS", "label": "Contains" }, { "value": "BEGINS", "label": "Begins With" }, { "value": "ENDS", "label": "Ends With" }, { "value": "GREATER_THAN", "label": "Greater Than" }, { "value": "GREATER_THAN_EQUAL", "label": "Greater Than Or Equal To" }, { "value": "LESS_THAN", "label": "Less Than" }, { "value": "LESS_THAN_EQUAL", "label": "Less Than Or Equal To" } ] or JSON "constraintValues": [ { "value": "fa41fd6e-5640-410f-9f3e-93f268186f69", "label": "Start Pooled Review and Approve Workflow", "isNode": true } ].</p>
     *
     * @return RU: текущее значение constraintValues. EN: current value of constraintValues.
     */

    public List<ActionConstraintData> getConstraintValues() {
        return constraintValues;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «constraint values» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets A list of constraint possbile values along with additional data (label, isNode flag). Sample object could be: JSON "constraintValues": [ { "value": "EQUALS", "label": "Equals" }, { "value": "CONTAINS", "label": "Contains" }, { "value": "BEGINS", "label": "Begins With" }, { "value": "ENDS", "label": "Ends With" }, { "value": "GREATER_THAN", "label": "Greater Than" }, { "value": "GREATER_THAN_EQUAL", "label": "Greater Than Or Equal To" }, { "value": "LESS_THAN", "label": "Less Than" }, { "value": "LESS_THAN_EQUAL", "label": "Less Than Or Equal To" } ] or JSON "constraintValues": [ { "value": "fa41fd6e-5640-410f-9f3e-93f268186f69", "label": "Start Pooled Review and Approve Workflow", "isNode": true } ].</p>
     *
     * @param constraintValues RU: новое значение constraintValues. EN: new value for constraintValues.
     */

    public void setConstraintValues(List<ActionConstraintData> constraintValues) {
        this.constraintValues = constraintValues;
    }

}
