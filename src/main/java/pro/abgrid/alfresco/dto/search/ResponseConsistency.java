package pro.abgrid.alfresco.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: ResponseConsistency.
 * EN: Alfresco REST API DTO model: ResponseConsistency.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseConsistency {
    /**
     * <p><strong>RU:</strong> значение поля «last tx id» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> The id of the last indexed transaction. Optional unless a specific endpoint requires it.</p>
     */
    private Integer lastTxId;

    /**
     * RU: Создаёт экземпляр ResponseConsistency.
     * EN: Creates a ResponseConsistency instance.
     */
    public ResponseConsistency() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «last tx id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The id of the last indexed transaction.</p>
     *
     * @return RU: текущее значение lastTxId. EN: current value of lastTxId.
     */

    public Integer getLastTxId() {
        return lastTxId;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «last tx id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The id of the last indexed transaction.</p>
     *
     * @param lastTxId RU: новое значение lastTxId. EN: new value for lastTxId.
     */

    public void setLastTxId(Integer lastTxId) {
        this.lastTxId = lastTxId;
    }

}
