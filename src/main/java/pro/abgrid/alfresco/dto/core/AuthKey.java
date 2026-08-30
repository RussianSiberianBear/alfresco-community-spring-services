package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: AuthKey.
 * EN: Alfresco REST API DTO model: AuthKey.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthKey {
    /**
     * <p><strong>RU:</strong> значение поля «authorization key» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> The Base64 encoded authorization key.. Required by the Swagger schema.</p>
     */
    private String authorizationKey;

    /**
     * RU: Создаёт экземпляр AuthKey.
     * EN: Creates a AuthKey instance.
     */
    public AuthKey() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «authorization key» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The Base64 encoded authorization key..</p>
     *
     * @return RU: текущее значение authorizationKey. EN: current value of authorizationKey.
     */

    public String getAuthorizationKey() {
        return authorizationKey;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «authorization key» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The Base64 encoded authorization key..</p>
     *
     * @param authorizationKey RU: новое значение authorizationKey. EN: new value for authorizationKey.
     */

    public void setAuthorizationKey(String authorizationKey) {
        this.authorizationKey = authorizationKey;
    }

}
