package pro.abgrid.alfresco.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * RU: DTO-модель Alfresco REST API: ResultBuckets.
 * EN: Alfresco REST API DTO model: ResultBuckets.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultBuckets {
    /**
     * <p><strong>RU:</strong> значение поля «label» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> The field name or its explicit label, if provided on the request. Optional unless a specific endpoint requires it.</p>
     */
    private String label;

    /**

     * <p><strong>RU:</strong> значение поля «buckets» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> An array of buckets and values. Optional unless a specific endpoint requires it.</p>

     */

    private List<Object> buckets;

    /**
     * RU: Создаёт экземпляр ResultBuckets.
     * EN: Creates a ResultBuckets instance.
     */
    public ResultBuckets() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «label» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The field name or its explicit label, if provided on the request.</p>
     *
     * @return RU: текущее значение label. EN: current value of label.
     */

    public String getLabel() {
        return label;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «label» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The field name or its explicit label, if provided on the request.</p>
     *
     * @param label RU: новое значение label. EN: new value for label.
     */

    public void setLabel(String label) {
        this.label = label;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «buckets» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns An array of buckets and values.</p>
     *
     * @return RU: текущее значение buckets. EN: current value of buckets.
     */

    public List<Object> getBuckets() {
        return buckets;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «buckets» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets An array of buckets and values.</p>
     *
     * @param buckets RU: новое значение buckets. EN: new value for buckets.
     */

    public void setBuckets(List<Object> buckets) {
        this.buckets = buckets;
    }

}
