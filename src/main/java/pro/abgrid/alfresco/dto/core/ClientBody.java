package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: ClientBody.
 * EN: Alfresco REST API DTO model: ClientBody.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientBody {
    /**
     * <p><strong>RU:</strong> значение поля «client» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> the client name. Required by the Swagger schema.</p>
     */
    private String client;

    /**
     * RU: Создаёт экземпляр ClientBody.
     * EN: Creates a ClientBody instance.
     */
    public ClientBody() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «client» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns the client name.</p>
     *
     * @return RU: текущее значение client. EN: current value of client.
     */

    public String getClient() {
        return client;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «client» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets the client name.</p>
     *
     * @param client RU: новое значение client. EN: new value for client.
     */

    public void setClient(String client) {
        this.client = client;
    }

}
