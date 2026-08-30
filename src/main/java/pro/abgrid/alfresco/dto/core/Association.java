package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: Association.
 * EN: Alfresco REST API DTO model: Association.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Association {
    /**
     * <p><strong>RU:</strong> значение поля «target id» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the target id field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private String targetId;

    /**

     * <p><strong>RU:</strong> значение поля «assoc type» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the assoc type field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private String assocType;

    /**
     * RU: Создаёт экземпляр Association.
     * EN: Creates a Association instance.
     */
    public Association() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «target id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the target id field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение targetId. EN: current value of targetId.
     */

    public String getTargetId() {
        return targetId;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «target id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the target id field in the Alfresco REST API model.</p>
     *
     * @param targetId RU: новое значение targetId. EN: new value for targetId.
     */

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «assoc type» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the assoc type field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение assocType. EN: current value of assocType.
     */

    public String getAssocType() {
        return assocType;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «assoc type» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the assoc type field in the Alfresco REST API model.</p>
     *
     * @param assocType RU: новое значение assocType. EN: new value for assocType.
     */

    public void setAssocType(String assocType) {
        this.assocType = assocType;
    }

}
