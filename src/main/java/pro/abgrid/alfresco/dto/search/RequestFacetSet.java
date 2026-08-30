package pro.abgrid.alfresco.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: RequestFacetSet.
 * EN: Alfresco REST API DTO model: RequestFacetSet.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestFacetSet {
    /**
     * <p><strong>RU:</strong> значение поля «label» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> A label to use to identify the set. Optional unless a specific endpoint requires it.</p>
     */
    private String label;

    /**

     * <p><strong>RU:</strong> значение поля «start» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The start of the range. Optional unless a specific endpoint requires it.</p>

     */

    private String start;

    /**

     * <p><strong>RU:</strong> значение поля «end» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The end of the range. Optional unless a specific endpoint requires it.</p>

     */

    private String end;

    /**

     * <p><strong>RU:</strong> значение поля «start inclusive» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> When true, the set will include values greater or equal to "start". Optional unless a specific endpoint requires it.</p>

     */

    private Boolean startInclusive;

    /**

     * <p><strong>RU:</strong> значение поля «end inclusive» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> When true, the set will include values less than or equal to "end". Optional unless a specific endpoint requires it.</p>

     */

    private Boolean endInclusive;

    /**
     * RU: Создаёт экземпляр RequestFacetSet.
     * EN: Creates a RequestFacetSet instance.
     */
    public RequestFacetSet() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «label» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns A label to use to identify the set.</p>
     *
     * @return RU: текущее значение label. EN: current value of label.
     */

    public String getLabel() {
        return label;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «label» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets A label to use to identify the set.</p>
     *
     * @param label RU: новое значение label. EN: new value for label.
     */

    public void setLabel(String label) {
        this.label = label;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «start» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The start of the range.</p>
     *
     * @return RU: текущее значение start. EN: current value of start.
     */

    public String getStart() {
        return start;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «start» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The start of the range.</p>
     *
     * @param start RU: новое значение start. EN: new value for start.
     */

    public void setStart(String start) {
        this.start = start;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «end» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The end of the range.</p>
     *
     * @return RU: текущее значение end. EN: current value of end.
     */

    public String getEnd() {
        return end;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «end» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The end of the range.</p>
     *
     * @param end RU: новое значение end. EN: new value for end.
     */

    public void setEnd(String end) {
        this.end = end;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «start inclusive» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns When true, the set will include values greater or equal to "start".</p>
     *
     * @return RU: текущее значение startInclusive. EN: current value of startInclusive.
     */

    public Boolean getStartInclusive() {
        return startInclusive;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «start inclusive» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets When true, the set will include values greater or equal to "start".</p>
     *
     * @param startInclusive RU: новое значение startInclusive. EN: new value for startInclusive.
     */

    public void setStartInclusive(Boolean startInclusive) {
        this.startInclusive = startInclusive;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «end inclusive» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns When true, the set will include values less than or equal to "end".</p>
     *
     * @return RU: текущее значение endInclusive. EN: current value of endInclusive.
     */

    public Boolean getEndInclusive() {
        return endInclusive;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «end inclusive» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets When true, the set will include values less than or equal to "end".</p>
     *
     * @param endInclusive RU: новое значение endInclusive. EN: new value for endInclusive.
     */

    public void setEndInclusive(Boolean endInclusive) {
        this.endInclusive = endInclusive;
    }

}
