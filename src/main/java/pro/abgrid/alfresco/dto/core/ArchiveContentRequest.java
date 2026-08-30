package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

/**
 * RU: DTO-модель Alfresco REST API: ArchiveContentRequest.
 * EN: Alfresco REST API DTO model: ArchiveContentRequest.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArchiveContentRequest {
    /**
     * <p><strong>RU:</strong> значение поля «archive params» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Optional map (String-String) of archive request properties for given content.. Optional unless a specific endpoint requires it.</p>
     */
    private Map<String, String> archiveParams;

    /**
     * RU: Создаёт экземпляр ArchiveContentRequest.
     * EN: Creates a ArchiveContentRequest instance.
     */
    public ArchiveContentRequest() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «archive params» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Optional map (String-String) of archive request properties for given content..</p>
     *
     * @return RU: текущее значение archiveParams. EN: current value of archiveParams.
     */

    public Map<String, String> getArchiveParams() {
        return archiveParams;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «archive params» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Optional map (String-String) of archive request properties for given content..</p>
     *
     * @param archiveParams RU: новое значение archiveParams. EN: new value for archiveParams.
     */

    public void setArchiveParams(Map<String, String> archiveParams) {
        this.archiveParams = archiveParams;
    }

}
