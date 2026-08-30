package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

/**
 * RU: DTO-модель Alfresco REST API: ActionBodyExec.
 * EN: Alfresco REST API DTO model: ActionBodyExec.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActionBodyExec {
    /**
     * <p><strong>RU:</strong> значение поля «action definition id» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the action definition id field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private String actionDefinitionId;

    /**

     * <p><strong>RU:</strong> значение поля «target id» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The entity upon which to execute the action, typically a node ID or similar.. Optional unless a specific endpoint requires it.</p>

     */

    private String targetId;

    /**

     * <p><strong>RU:</strong> значение поля «params» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the params field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Map<String, Object> params;

    /**
     * RU: Создаёт экземпляр ActionBodyExec.
     * EN: Creates a ActionBodyExec instance.
     */
    public ActionBodyExec() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «action definition id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the action definition id field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение actionDefinitionId. EN: current value of actionDefinitionId.
     */

    public String getActionDefinitionId() {
        return actionDefinitionId;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «action definition id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the action definition id field in the Alfresco REST API model.</p>
     *
     * @param actionDefinitionId RU: новое значение actionDefinitionId. EN: new value for actionDefinitionId.
     */

    public void setActionDefinitionId(String actionDefinitionId) {
        this.actionDefinitionId = actionDefinitionId;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «target id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The entity upon which to execute the action, typically a node ID or similar..</p>
     *
     * @return RU: текущее значение targetId. EN: current value of targetId.
     */

    public String getTargetId() {
        return targetId;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «target id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The entity upon which to execute the action, typically a node ID or similar..</p>
     *
     * @param targetId RU: новое значение targetId. EN: new value for targetId.
     */

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «params» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the params field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение params. EN: current value of params.
     */

    public Map<String, Object> getParams() {
        return params;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «params» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the params field in the Alfresco REST API model.</p>
     *
     * @param params RU: новое значение params. EN: new value for params.
     */

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

}
