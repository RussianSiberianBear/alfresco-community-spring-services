package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: AuthCode.
 * EN: Alfresco REST API DTO model: AuthCode.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthCode {
    /**
     * <p><strong>RU:</strong> значение поля «authorization code» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the authorization code field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private String authorizationCode;

    /**
     * RU: Создаёт экземпляр AuthCode.
     * EN: Creates a AuthCode instance.
     */
    public AuthCode() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «authorization code» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the authorization code field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение authorizationCode. EN: current value of authorizationCode.
     */

    public String getAuthorizationCode() {
        return authorizationCode;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «authorization code» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the authorization code field in the Alfresco REST API model.</p>
     *
     * @param authorizationCode RU: новое значение authorizationCode. EN: new value for authorizationCode.
     */

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

}
