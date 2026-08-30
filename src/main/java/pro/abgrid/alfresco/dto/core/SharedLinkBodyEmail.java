package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * RU: DTO-модель Alfresco REST API: SharedLinkBodyEmail.
 * EN: Alfresco REST API DTO model: SharedLinkBodyEmail.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SharedLinkBodyEmail {
    /**
     * <p><strong>RU:</strong> значение поля «client» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Value of the client field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>
     */
    private String client;

    /**

     * <p><strong>RU:</strong> значение поля «message» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the message field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String message;

    /**

     * <p><strong>RU:</strong> значение поля «locale» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the locale field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String locale;

    /**

     * <p><strong>RU:</strong> значение поля «recipient emails» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the recipient emails field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private List<String> recipientEmails;

    /**
     * RU: Создаёт экземпляр SharedLinkBodyEmail.
     * EN: Creates a SharedLinkBodyEmail instance.
     */
    public SharedLinkBodyEmail() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «client» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the client field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение client. EN: current value of client.
     */

    public String getClient() {
        return client;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «client» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the client field in the Alfresco REST API model.</p>
     *
     * @param client RU: новое значение client. EN: new value for client.
     */

    public void setClient(String client) {
        this.client = client;
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

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «locale» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the locale field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение locale. EN: current value of locale.
     */

    public String getLocale() {
        return locale;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «locale» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the locale field in the Alfresco REST API model.</p>
     *
     * @param locale RU: новое значение locale. EN: new value for locale.
     */

    public void setLocale(String locale) {
        this.locale = locale;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «recipient emails» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the recipient emails field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение recipientEmails. EN: current value of recipientEmails.
     */

    public List<String> getRecipientEmails() {
        return recipientEmails;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «recipient emails» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the recipient emails field in the Alfresco REST API model.</p>
     *
     * @param recipientEmails RU: новое значение recipientEmails. EN: new value for recipientEmails.
     */

    public void setRecipientEmails(List<String> recipientEmails) {
        this.recipientEmails = recipientEmails;
    }

}
