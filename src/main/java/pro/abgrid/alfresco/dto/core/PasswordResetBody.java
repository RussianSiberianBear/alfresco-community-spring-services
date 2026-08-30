package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: PasswordResetBody.
 * EN: Alfresco REST API DTO model: PasswordResetBody.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PasswordResetBody {
    /**
     * <p><strong>RU:</strong> значение поля «password» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> the new password. Required by the Swagger schema.</p>
     */
    private String password;

    /**

     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> the workflow id provided in the reset password email. Required by the Swagger schema.</p>

     */

    private String id;

    /**

     * <p><strong>RU:</strong> значение поля «key» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> the workflow key provided in the reset password email. Required by the Swagger schema.</p>

     */

    private String key;

    /**
     * RU: Создаёт экземпляр PasswordResetBody.
     * EN: Creates a PasswordResetBody instance.
     */
    public PasswordResetBody() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «password» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns the new password.</p>
     *
     * @return RU: текущее значение password. EN: current value of password.
     */

    public String getPassword() {
        return password;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «password» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets the new password.</p>
     *
     * @param password RU: новое значение password. EN: new value for password.
     */

    public void setPassword(String password) {
        this.password = password;
    }

        /**
     * <p><strong>RU:</strong> Возвращает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Returns the workflow id provided in the reset password email.</p>
     *
     * @return RU: текущее значение id. EN: current value of id.
     */

    public String getId() {
        return id;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Sets the workflow id provided in the reset password email.</p>
     *
     * @param id RU: новое значение id. EN: new value for id.
     */

    public void setId(String id) {
        this.id = id;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «key» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns the workflow key provided in the reset password email.</p>
     *
     * @return RU: текущее значение key. EN: current value of key.
     */

    public String getKey() {
        return key;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «key» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets the workflow key provided in the reset password email.</p>
     *
     * @param key RU: новое значение key. EN: new value for key.
     */

    public void setKey(String key) {
        this.key = key;
    }

}
