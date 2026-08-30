package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: RestoreArchivedContentRequest.
 * EN: Alfresco REST API DTO model: RestoreArchivedContentRequest.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestoreArchivedContentRequest {
    /**
     * <p><strong>RU:</strong> значение поля «restore priority» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Restore from archive priority (Standard/High - to be mapped to Storage Provider specific values in Cloud Connectors). Optional unless a specific endpoint requires it.</p>
     */
    private String restorePriority;

    /**
     * RU: Создаёт экземпляр RestoreArchivedContentRequest.
     * EN: Creates a RestoreArchivedContentRequest instance.
     */
    public RestoreArchivedContentRequest() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «restore priority» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Restore from archive priority (Standard/High - to be mapped to Storage Provider specific values in Cloud Connectors).</p>
     *
     * @return RU: текущее значение restorePriority. EN: current value of restorePriority.
     */

    public String getRestorePriority() {
        return restorePriority;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «restore priority» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Restore from archive priority (Standard/High - to be mapped to Storage Provider specific values in Cloud Connectors).</p>
     *
     * @param restorePriority RU: новое значение restorePriority. EN: new value for restorePriority.
     */

    public void setRestorePriority(String restorePriority) {
        this.restorePriority = restorePriority;
    }

}
