package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: AuditEntryEntry.
 * EN: Alfresco REST API DTO model: AuditEntryEntry.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditEntryEntry {
    /**
     * <p><strong>RU:</strong> содержимое стандартного entry-wrapper Alfresco. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Value of the entry field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>
     */
    private AuditEntry entry;

    /**
     * RU: Создаёт экземпляр AuditEntryEntry.
     * EN: Creates a AuditEntryEntry instance.
     */
    public AuditEntryEntry() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает содержимое стандартного entry-wrapper Alfresco.</p>
     * <p><strong>EN:</strong> Returns Value of the entry field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение entry. EN: current value of entry.
     */

    public AuditEntry getEntry() {
        return entry;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает содержимое стандартного entry-wrapper Alfresco.</p>
     * <p><strong>EN:</strong> Sets Value of the entry field in the Alfresco REST API model.</p>
     *
     * @param entry RU: новое значение entry. EN: new value for entry.
     */

    public void setEntry(AuditEntry entry) {
        this.entry = entry;
    }

}
