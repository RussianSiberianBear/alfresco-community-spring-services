package pro.abgrid.alfresco.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;

/**
 * RU: DTO-модель Alfresco REST API: GenericBucket.
 * EN: Alfresco REST API DTO model: GenericBucket.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenericBucket {
    /**
     * <p><strong>RU:</strong> значение поля «label» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> The bucket label. Optional unless a specific endpoint requires it.</p>
     */
    private String label;

    /**

     * <p><strong>RU:</strong> значение поля «filter query» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The filter query you can use to apply this facet. Optional unless a specific endpoint requires it.</p>

     */

    private String filterQuery;

    /**

     * <p><strong>RU:</strong> значение поля «display» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> An optional field for additional display information. Optional unless a specific endpoint requires it.</p>

     */

    private Map<String, Object> display;

    /**

     * <p><strong>RU:</strong> значение поля «metrics» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> An array of buckets and values. Optional unless a specific endpoint requires it.</p>

     */

    private List<GenericMetric> metrics;

    /**

     * <p><strong>RU:</strong> значение поля «facets» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Additional list of nested facets. Optional unless a specific endpoint requires it.</p>

     */

    private List<Map<String, Object>> facets;

    /**

     * <p><strong>RU:</strong> значение поля «bucket info» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Additional information of nested facet. Optional unless a specific endpoint requires it.</p>

     */

    private Object bucketInfo;

    /**
     * RU: Создаёт экземпляр GenericBucket.
     * EN: Creates a GenericBucket instance.
     */
    public GenericBucket() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «label» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The bucket label.</p>
     *
     * @return RU: текущее значение label. EN: current value of label.
     */

    public String getLabel() {
        return label;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «label» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The bucket label.</p>
     *
     * @param label RU: новое значение label. EN: new value for label.
     */

    public void setLabel(String label) {
        this.label = label;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «filter query» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The filter query you can use to apply this facet.</p>
     *
     * @return RU: текущее значение filterQuery. EN: current value of filterQuery.
     */

    public String getFilterQuery() {
        return filterQuery;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «filter query» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The filter query you can use to apply this facet.</p>
     *
     * @param filterQuery RU: новое значение filterQuery. EN: new value for filterQuery.
     */

    public void setFilterQuery(String filterQuery) {
        this.filterQuery = filterQuery;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «display» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns An optional field for additional display information.</p>
     *
     * @return RU: текущее значение display. EN: current value of display.
     */

    public Map<String, Object> getDisplay() {
        return display;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «display» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets An optional field for additional display information.</p>
     *
     * @param display RU: новое значение display. EN: new value for display.
     */

    public void setDisplay(Map<String, Object> display) {
        this.display = display;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «metrics» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns An array of buckets and values.</p>
     *
     * @return RU: текущее значение metrics. EN: current value of metrics.
     */

    public List<GenericMetric> getMetrics() {
        return metrics;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «metrics» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets An array of buckets and values.</p>
     *
     * @param metrics RU: новое значение metrics. EN: new value for metrics.
     */

    public void setMetrics(List<GenericMetric> metrics) {
        this.metrics = metrics;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «facets» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Additional list of nested facets.</p>
     *
     * @return RU: текущее значение facets. EN: current value of facets.
     */

    public List<Map<String, Object>> getFacets() {
        return facets;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «facets» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Additional list of nested facets.</p>
     *
     * @param facets RU: новое значение facets. EN: new value for facets.
     */

    public void setFacets(List<Map<String, Object>> facets) {
        this.facets = facets;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «bucket info» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Additional information of nested facet.</p>
     *
     * @return RU: текущее значение bucketInfo. EN: current value of bucketInfo.
     */

    public Object getBucketInfo() {
        return bucketInfo;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «bucket info» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Additional information of nested facet.</p>
     *
     * @param bucketInfo RU: новое значение bucketInfo. EN: new value for bucketInfo.
     */

    public void setBucketInfo(Object bucketInfo) {
        this.bucketInfo = bucketInfo;
    }

}
