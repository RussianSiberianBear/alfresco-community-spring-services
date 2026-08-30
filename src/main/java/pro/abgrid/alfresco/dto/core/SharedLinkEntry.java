package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: SharedLinkEntry.
 * EN: Alfresco REST API DTO model: SharedLinkEntry.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SharedLinkEntry {
    /**
     * <p><strong>RU:</strong> содержимое стандартного entry-wrapper Alfresco. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the entry field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private SharedLink entry;

    /**
     * RU: Создаёт экземпляр SharedLinkEntry.
     * EN: Creates a SharedLinkEntry instance.
     */
    public SharedLinkEntry() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает содержимое стандартного entry-wrapper Alfresco.</p>
     * <p><strong>EN:</strong> Returns Value of the entry field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение entry. EN: current value of entry.
     */

    public SharedLink getEntry() {
        return entry;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает содержимое стандартного entry-wrapper Alfresco.</p>
     * <p><strong>EN:</strong> Sets Value of the entry field in the Alfresco REST API model.</p>
     *
     * @param entry RU: новое значение entry. EN: new value for entry.
     */

    public void setEntry(SharedLink entry) {
        this.entry = entry;
    }

}
