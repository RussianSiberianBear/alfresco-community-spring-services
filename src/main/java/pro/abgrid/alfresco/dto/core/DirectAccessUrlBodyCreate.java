package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: DirectAccessUrlBodyCreate.
 * EN: Alfresco REST API DTO model: DirectAccessUrlBodyCreate.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DirectAccessUrlBodyCreate {
    /**
     * <p><strong>RU:</strong> значение поля «attachment» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> URL type (embedded/attachment).. Optional unless a specific endpoint requires it.</p>
     */
    private Boolean attachment;

    /**
     * RU: Создаёт экземпляр DirectAccessUrlBodyCreate.
     * EN: Creates a DirectAccessUrlBodyCreate instance.
     */
    public DirectAccessUrlBodyCreate() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «attachment» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns URL type (embedded/attachment)..</p>
     *
     * @return RU: текущее значение attachment. EN: current value of attachment.
     */

    public Boolean getAttachment() {
        return attachment;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «attachment» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets URL type (embedded/attachment)..</p>
     *
     * @param attachment RU: новое значение attachment. EN: new value for attachment.
     */

    public void setAttachment(Boolean attachment) {
        this.attachment = attachment;
    }

}
