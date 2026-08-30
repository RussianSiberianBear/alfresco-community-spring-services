package pro.abgrid.alfresco.dto.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: Ticket.
 * EN: Alfresco REST API DTO model: Ticket.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticket {
    /**
     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Value of the id field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>
     */
    private String id;

    /**

     * <p><strong>RU:</strong> значение поля «user id» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the user id field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String userId;

    /**
     * RU: Создаёт экземпляр Ticket.
     * EN: Creates a Ticket instance.
     */
    public Ticket() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Returns Value of the id field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение id. EN: current value of id.
     */

    public String getId() {
        return id;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Sets Value of the id field in the Alfresco REST API model.</p>
     *
     * @param id RU: новое значение id. EN: new value for id.
     */

    public void setId(String id) {
        this.id = id;
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

}
