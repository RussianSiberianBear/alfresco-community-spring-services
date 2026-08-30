package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: DeletedNodeBodyRestore.
 * EN: Alfresco REST API DTO model: DeletedNodeBodyRestore.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeletedNodeBodyRestore {
    /**
     * <p><strong>RU:</strong> значение поля «target parent id» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Value of the target parent id field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>
     */
    private String targetParentId;

    /**

     * <p><strong>RU:</strong> значение поля «assoc type» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the assoc type field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String assocType;

    /**
     * RU: Создаёт экземпляр DeletedNodeBodyRestore.
     * EN: Creates a DeletedNodeBodyRestore instance.
     */
    public DeletedNodeBodyRestore() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «target parent id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the target parent id field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение targetParentId. EN: current value of targetParentId.
     */

    public String getTargetParentId() {
        return targetParentId;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «target parent id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the target parent id field in the Alfresco REST API model.</p>
     *
     * @param targetParentId RU: новое значение targetParentId. EN: new value for targetParentId.
     */

    public void setTargetParentId(String targetParentId) {
        this.targetParentId = targetParentId;
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
