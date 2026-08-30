package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: SiteMembershipBodyUpdate.
 * EN: Alfresco REST API DTO model: SiteMembershipBodyUpdate.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SiteMembershipBodyUpdate {
    /**
     * <p><strong>RU:</strong> значение поля «role» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the role field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private String role;

    /**
     * RU: Создаёт экземпляр SiteMembershipBodyUpdate.
     * EN: Creates a SiteMembershipBodyUpdate instance.
     */
    public SiteMembershipBodyUpdate() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «role» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the role field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение role. EN: current value of role.
     */

    public String getRole() {
        return role;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «role» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the role field in the Alfresco REST API model.</p>
     *
     * @param role RU: новое значение role. EN: new value for role.
     */

    public void setRole(String role) {
        this.role = role;
    }

}
