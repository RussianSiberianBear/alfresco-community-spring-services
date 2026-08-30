package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;

/**
 * RU: DTO-модель Alfresco REST API: CascadingDictCreate.
 * EN: Alfresco REST API DTO model: CascadingDictCreate.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CascadingDictCreate {
    /**
     * <p><strong>RU:</strong> дата и время создания. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the created at field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private OffsetDateTime createdAt;

    /**
     * RU: Создаёт экземпляр CascadingDictCreate.
     * EN: Creates a CascadingDictCreate instance.
     */
    public CascadingDictCreate() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает дата и время создания.</p>
     * <p><strong>EN:</strong> Returns Value of the created at field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение createdAt. EN: current value of createdAt.
     */

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает дата и время создания.</p>
     * <p><strong>EN:</strong> Sets Value of the created at field in the Alfresco REST API model.</p>
     *
     * @param createdAt RU: новое значение createdAt. EN: new value for createdAt.
     */

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
