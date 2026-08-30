package pro.abgrid.alfresco.dto.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: TicketBody.
 * EN: Alfresco REST API DTO model: TicketBody.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TicketBody {
    /**
     * <p><strong>RU:</strong> значение поля «user id» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Value of the user id field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>
     */
    private String userId;

    /**

     * <p><strong>RU:</strong> значение поля «password» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the password field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String password;

    /**
     * RU: Создаёт экземпляр TicketBody.
     * EN: Creates a TicketBody instance.
     */
    public TicketBody() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «user id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the user id field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение userId. EN: current value of userId.
     */

    public String getUserId() {
        return userId;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «user id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the user id field in the Alfresco REST API model.</p>
     *
     * @param userId RU: новое значение userId. EN: new value for userId.
     */

    public void setUserId(String userId) {
        this.userId = userId;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «password» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the password field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение password. EN: current value of password.
     */

    public String getPassword() {
        return password;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «password» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the password field in the Alfresco REST API model.</p>
     *
     * @param password RU: новое значение password. EN: new value for password.
     */

    public void setPassword(String password) {
        this.password = password;
    }

}
