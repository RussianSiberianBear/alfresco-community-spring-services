package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;

/**
 * RU: DTO-модель Alfresco REST API: CascadingDictUpdate.
 * EN: Alfresco REST API DTO model: CascadingDictUpdate.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CascadingDictUpdate {
    /**
     * <p><strong>RU:</strong> дата и время последнего изменения. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the modified at field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private OffsetDateTime modifiedAt;

    /**
     * RU: Создаёт экземпляр CascadingDictUpdate.
     * EN: Creates a CascadingDictUpdate instance.
     */
    public CascadingDictUpdate() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает дата и время последнего изменения.</p>
     * <p><strong>EN:</strong> Returns Value of the modified at field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение modifiedAt. EN: current value of modifiedAt.
     */

    public OffsetDateTime getModifiedAt() {
        return modifiedAt;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает дата и время последнего изменения.</p>
     * <p><strong>EN:</strong> Sets Value of the modified at field in the Alfresco REST API model.</p>
     *
     * @param modifiedAt RU: новое значение modifiedAt. EN: new value for modifiedAt.
     */

    public void setModifiedAt(OffsetDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

}
