package pro.abgrid.alfresco.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * RU: DTO-модель Alfresco REST API: RequestPivot.
 * EN: Alfresco REST API DTO model: RequestPivot.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestPivot {
    /**
     * <p><strong>RU:</strong> значение поля «key» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> A key corresponding to a matching field facet label or stats.. Optional unless a specific endpoint requires it.</p>
     */
    private String key;

    /**

     * <p><strong>RU:</strong> значение поля «pivots» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the pivots field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private List<RequestPivot> pivots;

    /**
     * RU: Создаёт экземпляр RequestPivot.
     * EN: Creates a RequestPivot instance.
     */
    public RequestPivot() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «key» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns A key corresponding to a matching field facet label or stats..</p>
     *
     * @return RU: текущее значение key. EN: current value of key.
     */

    public String getKey() {
        return key;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «key» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets A key corresponding to a matching field facet label or stats..</p>
     *
     * @param key RU: новое значение key. EN: new value for key.
     */

    public void setKey(String key) {
        this.key = key;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «pivots» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the pivots field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение pivots. EN: current value of pivots.
     */

    public List<RequestPivot> getPivots() {
        return pivots;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «pivots» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the pivots field in the Alfresco REST API model.</p>
     *
     * @param pivots RU: новое значение pivots. EN: new value for pivots.
     */

    public void setPivots(List<RequestPivot> pivots) {
        this.pivots = pivots;
    }

}
