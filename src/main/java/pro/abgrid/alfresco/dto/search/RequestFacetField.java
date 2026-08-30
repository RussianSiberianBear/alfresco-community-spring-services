package pro.abgrid.alfresco.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * RU: DTO-модель Alfresco REST API: RequestFacetField.
 * EN: Alfresco REST API DTO model: RequestFacetField.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestFacetField {
    /**
     * <p><strong>RU:</strong> значение поля «field» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> The facet field. Optional unless a specific endpoint requires it.</p>
     */
    private String field;

    /**

     * <p><strong>RU:</strong> значение поля «label» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> A label to include in place of the facet field. Optional unless a specific endpoint requires it.</p>

     */

    private String label;

    /**

     * <p><strong>RU:</strong> значение поля «prefix» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Restricts the possible constraints to only indexed values with a specified prefix.. Optional unless a specific endpoint requires it.</p>

     */

    private String prefix;

    /**

     * <p><strong>RU:</strong> значение поля «sort» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the sort field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String sort;

    /**

     * <p><strong>RU:</strong> значение поля «method» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the method field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String method;

    /**

     * <p><strong>RU:</strong> значение поля «missing» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> When true, count results that match the query but which have no facet value for the field (in addition to the Term-based constraints).. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean missing;

    /**

     * <p><strong>RU:</strong> значение поля «limit» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the limit field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Integer limit;

    /**

     * <p><strong>RU:</strong> значение поля «offset» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the offset field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Integer offset;

    /**

     * <p><strong>RU:</strong> значение поля «mincount» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The minimum count required for a facet field to be included in the response.. Optional unless a specific endpoint requires it.</p>

     */

    private Integer mincount;

    /**

     * <p><strong>RU:</strong> значение поля «facet enum cache min df» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the facet enum cache min df field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Integer facetEnumCacheMinDf;

    /**

     * <p><strong>RU:</strong> значение поля «exclude filters» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Filter Queries with tags listed here will not be included in facet counts. This is used for multi-select facetting.. Optional unless a specific endpoint requires it.</p>

     */

    private List<String> excludeFilters;

    /**
     * RU: Создаёт экземпляр RequestFacetField.
     * EN: Creates a RequestFacetField instance.
     */
    public RequestFacetField() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «field» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The facet field.</p>
     *
     * @return RU: текущее значение field. EN: current value of field.
     */

    public String getField() {
        return field;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «field» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The facet field.</p>
     *
     * @param field RU: новое значение field. EN: new value for field.
     */

    public void setField(String field) {
        this.field = field;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «label» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns A label to include in place of the facet field.</p>
     *
     * @return RU: текущее значение label. EN: current value of label.
     */

    public String getLabel() {
        return label;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «label» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets A label to include in place of the facet field.</p>
     *
     * @param label RU: новое значение label. EN: new value for label.
     */

    public void setLabel(String label) {
        this.label = label;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «prefix» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Restricts the possible constraints to only indexed values with a specified prefix..</p>
     *
     * @return RU: текущее значение prefix. EN: current value of prefix.
     */

    public String getPrefix() {
        return prefix;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «prefix» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Restricts the possible constraints to only indexed values with a specified prefix..</p>
     *
     * @param prefix RU: новое значение prefix. EN: new value for prefix.
     */

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «sort» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the sort field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение sort. EN: current value of sort.
     */

    public String getSort() {
        return sort;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «sort» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the sort field in the Alfresco REST API model.</p>
     *
     * @param sort RU: новое значение sort. EN: new value for sort.
     */

    public void setSort(String sort) {
        this.sort = sort;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «method» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the method field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение method. EN: current value of method.
     */

    public String getMethod() {
        return method;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «method» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the method field in the Alfresco REST API model.</p>
     *
     * @param method RU: новое значение method. EN: new value for method.
     */

    public void setMethod(String method) {
        this.method = method;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «missing» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns When true, count results that match the query but which have no facet value for the field (in addition to the Term-based constraints)..</p>
     *
     * @return RU: текущее значение missing. EN: current value of missing.
     */

    public Boolean getMissing() {
        return missing;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «missing» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets When true, count results that match the query but which have no facet value for the field (in addition to the Term-based constraints)..</p>
     *
     * @param missing RU: новое значение missing. EN: new value for missing.
     */

    public void setMissing(Boolean missing) {
        this.missing = missing;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «limit» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the limit field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение limit. EN: current value of limit.
     */

    public Integer getLimit() {
        return limit;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «limit» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the limit field in the Alfresco REST API model.</p>
     *
     * @param limit RU: новое значение limit. EN: new value for limit.
     */

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «offset» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the offset field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение offset. EN: current value of offset.
     */

    public Integer getOffset() {
        return offset;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «offset» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the offset field in the Alfresco REST API model.</p>
     *
     * @param offset RU: новое значение offset. EN: new value for offset.
     */

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «mincount» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The minimum count required for a facet field to be included in the response..</p>
     *
     * @return RU: текущее значение mincount. EN: current value of mincount.
     */

    public Integer getMincount() {
        return mincount;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «mincount» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The minimum count required for a facet field to be included in the response..</p>
     *
     * @param mincount RU: новое значение mincount. EN: new value for mincount.
     */

    public void setMincount(Integer mincount) {
        this.mincount = mincount;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «facet enum cache min df» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the facet enum cache min df field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение facetEnumCacheMinDf. EN: current value of facetEnumCacheMinDf.
     */

    public Integer getFacetEnumCacheMinDf() {
        return facetEnumCacheMinDf;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «facet enum cache min df» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the facet enum cache min df field in the Alfresco REST API model.</p>
     *
     * @param facetEnumCacheMinDf RU: новое значение facetEnumCacheMinDf. EN: new value for facetEnumCacheMinDf.
     */

    public void setFacetEnumCacheMinDf(Integer facetEnumCacheMinDf) {
        this.facetEnumCacheMinDf = facetEnumCacheMinDf;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «exclude filters» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Filter Queries with tags listed here will not be included in facet counts. This is used for multi-select facetting..</p>
     *
     * @return RU: текущее значение excludeFilters. EN: current value of excludeFilters.
     */

    public List<String> getExcludeFilters() {
        return excludeFilters;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «exclude filters» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Filter Queries with tags listed here will not be included in facet counts. This is used for multi-select facetting..</p>
     *
     * @param excludeFilters RU: новое значение excludeFilters. EN: new value for excludeFilters.
     */

    public void setExcludeFilters(List<String> excludeFilters) {
        this.excludeFilters = excludeFilters;
    }

}
