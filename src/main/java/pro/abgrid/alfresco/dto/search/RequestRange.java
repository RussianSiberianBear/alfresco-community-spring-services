package pro.abgrid.alfresco.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * RU: DTO-модель Alfresco REST API: RequestRange.
 * EN: Alfresco REST API DTO model: RequestRange.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestRange {
    /**
     * <p><strong>RU:</strong> значение поля «field» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> The name of the field to perform range. Optional unless a specific endpoint requires it.</p>
     */
    private String field;

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

     * <p><strong>RU:</strong> значение поля «gap» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Bucket size. Optional unless a specific endpoint requires it.</p>

     */

    private String gap;

    /**

     * <p><strong>RU:</strong> значение поля «hardend» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> If true means that the last bucket will end at “end” even if it is less than “gap” wide.. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean hardend;

    /**

     * <p><strong>RU:</strong> значение поля «other» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> before, after, between, non, all. Optional unless a specific endpoint requires it.</p>

     */

    private List<String> other;

    /**

     * <p><strong>RU:</strong> значение поля «include» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> lower, upper, edge, outer, all. Optional unless a specific endpoint requires it.</p>

     */

    private List<String> include;

    /**

     * <p><strong>RU:</strong> значение поля «label» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> A label to include as a pivot reference. Optional unless a specific endpoint requires it.</p>

     */

    private String label;

    /**

     * <p><strong>RU:</strong> значение поля «exclude filters» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Filter queries to exclude when calculating statistics. Optional unless a specific endpoint requires it.</p>

     */

    private List<String> excludeFilters;

    /**
     * RU: Создаёт экземпляр RequestRange.
     * EN: Creates a RequestRange instance.
     */
    public RequestRange() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «field» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The name of the field to perform range.</p>
     *
     * @return RU: текущее значение field. EN: current value of field.
     */

    public String getField() {
        return field;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «field» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The name of the field to perform range.</p>
     *
     * @param field RU: новое значение field. EN: new value for field.
     */

    public void setField(String field) {
        this.field = field;
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
     * <p><strong>RU:</strong> Возвращает значение поля «gap» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Bucket size.</p>
     *
     * @return RU: текущее значение gap. EN: current value of gap.
     */

    public String getGap() {
        return gap;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «gap» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Bucket size.</p>
     *
     * @param gap RU: новое значение gap. EN: new value for gap.
     */

    public void setGap(String gap) {
        this.gap = gap;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «hardend» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns If true means that the last bucket will end at “end” even if it is less than “gap” wide..</p>
     *
     * @return RU: текущее значение hardend. EN: current value of hardend.
     */

    public Boolean getHardend() {
        return hardend;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «hardend» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets If true means that the last bucket will end at “end” even if it is less than “gap” wide..</p>
     *
     * @param hardend RU: новое значение hardend. EN: new value for hardend.
     */

    public void setHardend(Boolean hardend) {
        this.hardend = hardend;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «other» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns before, after, between, non, all.</p>
     *
     * @return RU: текущее значение other. EN: current value of other.
     */

    public List<String> getOther() {
        return other;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «other» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets before, after, between, non, all.</p>
     *
     * @param other RU: новое значение other. EN: new value for other.
     */

    public void setOther(List<String> other) {
        this.other = other;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «include» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns lower, upper, edge, outer, all.</p>
     *
     * @return RU: текущее значение include. EN: current value of include.
     */

    public List<String> getInclude() {
        return include;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «include» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets lower, upper, edge, outer, all.</p>
     *
     * @param include RU: новое значение include. EN: new value for include.
     */

    public void setInclude(List<String> include) {
        this.include = include;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «label» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns A label to include as a pivot reference.</p>
     *
     * @return RU: текущее значение label. EN: current value of label.
     */

    public String getLabel() {
        return label;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «label» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets A label to include as a pivot reference.</p>
     *
     * @param label RU: новое значение label. EN: new value for label.
     */

    public void setLabel(String label) {
        this.label = label;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «exclude filters» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Filter queries to exclude when calculating statistics.</p>
     *
     * @return RU: текущее значение excludeFilters. EN: current value of excludeFilters.
     */

    public List<String> getExcludeFilters() {
        return excludeFilters;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «exclude filters» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Filter queries to exclude when calculating statistics.</p>
     *
     * @param excludeFilters RU: новое значение excludeFilters. EN: new value for excludeFilters.
     */

    public void setExcludeFilters(List<String> excludeFilters) {
        this.excludeFilters = excludeFilters;
    }

}
