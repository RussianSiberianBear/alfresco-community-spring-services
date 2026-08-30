package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: AuditBodyUpdate.
 * EN: Alfresco REST API DTO model: AuditBodyUpdate.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditBodyUpdate {
    /**
     * <p><strong>RU:</strong> значение поля «is enabled» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Value of the is enabled field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>
     */
    private Boolean isEnabled;

    /**
     * RU: Создаёт экземпляр AuditBodyUpdate.
     * EN: Creates a AuditBodyUpdate instance.
     */
    public AuditBodyUpdate() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «is enabled» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the is enabled field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение isEnabled. EN: current value of isEnabled.
     */

    public Boolean getIsEnabled() {
        return isEnabled;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «is enabled» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the is enabled field in the Alfresco REST API model.</p>
     *
     * @param isEnabled RU: новое значение isEnabled. EN: new value for isEnabled.
     */

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

}
