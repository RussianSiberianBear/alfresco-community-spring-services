package pro.abgrid.alfresco.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * RU: DTO-модель Alfresco REST API: RequestFacetIntervals.
 * EN: Alfresco REST API DTO model: RequestFacetIntervals.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestFacetIntervals {
    /**
     * <p><strong>RU:</strong> значение поля «sets» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Sets the intervals for all fields.. Optional unless a specific endpoint requires it.</p>
     */
    private List<RequestFacetSet> sets;

    /**

     * <p><strong>RU:</strong> значение поля «intervals» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Specifies the fields to facet by interval.. Optional unless a specific endpoint requires it.</p>

     */

    private List<Object> intervals;

    /**
     * RU: Создаёт экземпляр RequestFacetIntervals.
     * EN: Creates a RequestFacetIntervals instance.
     */
    public RequestFacetIntervals() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «sets» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Sets the intervals for all fields..</p>
     *
     * @return RU: текущее значение sets. EN: current value of sets.
     */

    public List<RequestFacetSet> getSets() {
        return sets;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «sets» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Sets the intervals for all fields..</p>
     *
     * @param sets RU: новое значение sets. EN: new value for sets.
     */

    public void setSets(List<RequestFacetSet> sets) {
        this.sets = sets;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «intervals» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Specifies the fields to facet by interval..</p>
     *
     * @return RU: текущее значение intervals. EN: current value of intervals.
     */

    public List<Object> getIntervals() {
        return intervals;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «intervals» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Specifies the fields to facet by interval..</p>
     *
     * @param intervals RU: новое значение intervals. EN: new value for intervals.
     */

    public void setIntervals(List<Object> intervals) {
        this.intervals = intervals;
    }

}
