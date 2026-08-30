package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: ActionConstraintData.
 * EN: Alfresco REST API DTO model: ActionConstraintData.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActionConstraintData {
    /**
     * <p><strong>RU:</strong> значение поля «value» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Constraint value (this can also be a node id). Required by the Swagger schema.</p>
     */
    private String value;

    /**

     * <p><strong>RU:</strong> значение поля «label» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Constraint display label. Optional unless a specific endpoint requires it.</p>

     */

    private String label;

    /**
     * RU: Создаёт экземпляр ActionConstraintData.
     * EN: Creates a ActionConstraintData instance.
     */
    public ActionConstraintData() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «value» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Constraint value (this can also be a node id).</p>
     *
     * @return RU: текущее значение value. EN: current value of value.
     */

    public String getValue() {
        return value;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «value» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Constraint value (this can also be a node id).</p>
     *
     * @param value RU: новое значение value. EN: new value for value.
     */

    public void setValue(String value) {
        this.value = value;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «label» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Constraint display label.</p>
     *
     * @return RU: текущее значение label. EN: current value of label.
     */

    public String getLabel() {
        return label;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «label» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Constraint display label.</p>
     *
     * @param label RU: новое значение label. EN: new value for label.
     */

    public void setLabel(String label) {
        this.label = label;
    }

}
