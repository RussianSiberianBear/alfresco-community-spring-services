package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: CascadingDictUpdateEntry.
 * EN: Alfresco REST API DTO model: CascadingDictUpdateEntry.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CascadingDictUpdateEntry {
    /**
     * <p><strong>RU:</strong> содержимое стандартного entry-wrapper Alfresco. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the entry field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private CascadingDictUpdate entry;

    /**
     * RU: Создаёт экземпляр CascadingDictUpdateEntry.
     * EN: Creates a CascadingDictUpdateEntry instance.
     */
    public CascadingDictUpdateEntry() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает содержимое стандартного entry-wrapper Alfresco.</p>
     * <p><strong>EN:</strong> Returns Value of the entry field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение entry. EN: current value of entry.
     */

    public CascadingDictUpdate getEntry() {
        return entry;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает содержимое стандартного entry-wrapper Alfresco.</p>
     * <p><strong>EN:</strong> Sets Value of the entry field in the Alfresco REST API model.</p>
     *
     * @param entry RU: новое значение entry. EN: new value for entry.
     */

    public void setEntry(CascadingDictUpdate entry) {
        this.entry = entry;
    }

}
