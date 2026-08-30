package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: AssociationInfo.
 * EN: Alfresco REST API DTO model: AssociationInfo.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssociationInfo {
    /**
     * <p><strong>RU:</strong> значение поля «assoc type» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the assoc type field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private String assocType;

    /**
     * RU: Создаёт экземпляр AssociationInfo.
     * EN: Creates a AssociationInfo instance.
     */
    public AssociationInfo() {
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
