package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: SiteMembershipRequestBodyUpdate.
 * EN: Alfresco REST API DTO model: SiteMembershipRequestBodyUpdate.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SiteMembershipRequestBodyUpdate {
    /**
     * <p><strong>RU:</strong> значение поля «message» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Value of the message field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>
     */
    private String message;

    /**
     * RU: Создаёт экземпляр SiteMembershipRequestBodyUpdate.
     * EN: Creates a SiteMembershipRequestBodyUpdate instance.
     */
    public SiteMembershipRequestBodyUpdate() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «message» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the message field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение message. EN: current value of message.
     */

    public String getMessage() {
        return message;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «message» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the message field in the Alfresco REST API model.</p>
     *
     * @param message RU: новое значение message. EN: new value for message.
     */

    public void setMessage(String message) {
        this.message = message;
    }

}
