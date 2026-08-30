package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;

/**
 * RU: DTO-модель Alfresco REST API: DirectAccessUrl.
 * EN: Alfresco REST API DTO model: DirectAccessUrl.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DirectAccessUrl {
    /**
     * <p><strong>RU:</strong> значение поля «content url» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> The direct access URL of a binary content. Required by the Swagger schema.</p>
     */
    private String contentUrl;

    /**

     * <p><strong>RU:</strong> значение поля «attachment» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Flag to control the download method, true for attachment URL, false for embedded URL. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean attachment;

    /**

     * <p><strong>RU:</strong> значение поля «expires at» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The direct access URL would become invalid when the expiry date is reached. Optional unless a specific endpoint requires it.</p>

     */

    private OffsetDateTime expiresAt;

    /**
     * RU: Создаёт экземпляр DirectAccessUrl.
     * EN: Creates a DirectAccessUrl instance.
     */
    public DirectAccessUrl() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «content url» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The direct access URL of a binary content.</p>
     *
     * @return RU: текущее значение contentUrl. EN: current value of contentUrl.
     */

    public String getContentUrl() {
        return contentUrl;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «content url» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The direct access URL of a binary content.</p>
     *
     * @param contentUrl RU: новое значение contentUrl. EN: new value for contentUrl.
     */

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «attachment» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Flag to control the download method, true for attachment URL, false for embedded URL.</p>
     *
     * @return RU: текущее значение attachment. EN: current value of attachment.
     */

    public Boolean getAttachment() {
        return attachment;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «attachment» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Flag to control the download method, true for attachment URL, false for embedded URL.</p>
     *
     * @param attachment RU: новое значение attachment. EN: new value for attachment.
     */

    public void setAttachment(Boolean attachment) {
        this.attachment = attachment;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «expires at» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The direct access URL would become invalid when the expiry date is reached.</p>
     *
     * @return RU: текущее значение expiresAt. EN: current value of expiresAt.
     */

    public OffsetDateTime getExpiresAt() {
        return expiresAt;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «expires at» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The direct access URL would become invalid when the expiry date is reached.</p>
     *
     * @param expiresAt RU: новое значение expiresAt. EN: new value for expiresAt.
     */

    public void setExpiresAt(OffsetDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

}
