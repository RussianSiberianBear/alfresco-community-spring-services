package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: SiteMembershipRequestBodyCreate.
 * EN: Alfresco REST API DTO model: SiteMembershipRequestBodyCreate.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SiteMembershipRequestBodyCreate {
    /**
     * <p><strong>RU:</strong> значение поля «message» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Value of the message field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>
     */
    private String message;

    /**

     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the id field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private String id;

    /**

     * <p><strong>RU:</strong> значение поля «title» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the title field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String title;

    /**

     * <p><strong>RU:</strong> значение поля «client» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Optional client name used when sending an email to the end user, defaults to "share" if not provided. Note: The client must be registered before this API can send an email. Note: This is available in Alfresco 7.0.0 and newer versions.. Optional unless a specific endpoint requires it.</p>

     */

    private String client;

    /**
     * RU: Создаёт экземпляр SiteMembershipRequestBodyCreate.
     * EN: Creates a SiteMembershipRequestBodyCreate instance.
     */
    public SiteMembershipRequestBodyCreate() {
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
     * <p><strong>RU:</strong> Возвращает значение поля «title» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the title field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение title. EN: current value of title.
     */

    public String getTitle() {
        return title;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «title» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the title field in the Alfresco REST API model.</p>
     *
     * @param title RU: новое значение title. EN: new value for title.
     */

    public void setTitle(String title) {
        this.title = title;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «client» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Optional client name used when sending an email to the end user, defaults to "share" if not provided. Note: The client must be registered before this API can send an email. Note: This is available in Alfresco 7.0.0 and newer versions..</p>
     *
     * @return RU: текущее значение client. EN: current value of client.
     */

    public String getClient() {
        return client;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «client» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Optional client name used when sending an email to the end user, defaults to "share" if not provided. Note: The client must be registered before this API can send an email. Note: This is available in Alfresco 7.0.0 and newer versions..</p>
     *
     * @param client RU: новое значение client. EN: new value for client.
     */

    public void setClient(String client) {
        this.client = client;
    }

}
