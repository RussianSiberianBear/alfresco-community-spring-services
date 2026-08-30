package pro.abgrid.alfresco.dto.discovery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: DiscoveryEntry.
 * EN: Alfresco REST API DTO model: DiscoveryEntry.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscoveryEntry {
    /**
     * <p><strong>RU:</strong> содержимое стандартного entry-wrapper Alfresco. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the entry field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private RepositoryEntry entry;

    /**
     * RU: Создаёт экземпляр DiscoveryEntry.
     * EN: Creates a DiscoveryEntry instance.
     */
    public DiscoveryEntry() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает содержимое стандартного entry-wrapper Alfresco.</p>
     * <p><strong>EN:</strong> Returns Value of the entry field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение entry. EN: current value of entry.
     */

    public RepositoryEntry getEntry() {
        return entry;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает содержимое стандартного entry-wrapper Alfresco.</p>
     * <p><strong>EN:</strong> Sets Value of the entry field in the Alfresco REST API model.</p>
     *
     * @param entry RU: новое значение entry. EN: new value for entry.
     */

    public void setEntry(RepositoryEntry entry) {
        this.entry = entry;
    }

}
