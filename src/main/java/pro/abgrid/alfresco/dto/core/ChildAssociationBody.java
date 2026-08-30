package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: ChildAssociationBody.
 * EN: Alfresco REST API DTO model: ChildAssociationBody.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChildAssociationBody {
    /**
     * <p><strong>RU:</strong> значение поля «child id» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the child id field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private String childId;

    /**

     * <p><strong>RU:</strong> значение поля «assoc type» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the assoc type field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private String assocType;

    /**
     * RU: Создаёт экземпляр ChildAssociationBody.
     * EN: Creates a ChildAssociationBody instance.
     */
    public ChildAssociationBody() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «child id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the child id field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение childId. EN: current value of childId.
     */

    public String getChildId() {
        return childId;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «child id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the child id field in the Alfresco REST API model.</p>
     *
     * @param childId RU: новое значение childId. EN: new value for childId.
     */

    public void setChildId(String childId) {
        this.childId = childId;
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
