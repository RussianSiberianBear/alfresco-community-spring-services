package pro.abgrid.alfresco.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * RU: DTO-модель Alfresco REST API: SearchRequest.
 * EN: Alfresco REST API DTO model: SearchRequest.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchRequest {
    /**
     * <p><strong>RU:</strong> значение поля «query» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the query field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private RequestQuery query;

    /**

     * <p><strong>RU:</strong> значение поля «paging» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the paging field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private RequestPagination paging;

    /**

     * <p><strong>RU:</strong> значение поля «include» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the include field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private RequestInclude include;

    /**

     * <p><strong>RU:</strong> значение поля «include request» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> When true, include the original request in the response. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean includeRequest;

    /**

     * <p><strong>RU:</strong> значение поля «fields» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the fields field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private RequestFields fields;

    /**

     * <p><strong>RU:</strong> значение поля «sort» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the sort field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private RequestSortDefinition sort;

    /**

     * <p><strong>RU:</strong> значение поля «templates» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the templates field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private RequestTemplates templates;

    /**

     * <p><strong>RU:</strong> значение поля «defaults» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the defaults field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private RequestDefaults defaults;

    /**

     * <p><strong>RU:</strong> значение поля «localization» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the localization field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private RequestLocalization localization;

    /**

     * <p><strong>RU:</strong> значение поля «filter queries» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the filter queries field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private RequestFilterQueries filterQueries;

    /**

     * <p><strong>RU:</strong> значение поля «facet queries» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the facet queries field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private RequestFacetQueries facetQueries;

    /**

     * <p><strong>RU:</strong> значение поля «facet fields» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the facet fields field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private RequestFacetFields facetFields;

    /**

     * <p><strong>RU:</strong> значение поля «facet intervals» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the facet intervals field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private RequestFacetIntervals facetIntervals;

    /**

     * <p><strong>RU:</strong> значение поля «pivots» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the pivots field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private List<RequestPivot> pivots;

    /**

     * <p><strong>RU:</strong> значение поля «stats» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the stats field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private List<RequestStats> stats;

    /**

     * <p><strong>RU:</strong> значение поля «spellcheck» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the spellcheck field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private RequestSpellcheck spellcheck;

    /**

     * <p><strong>RU:</strong> значение поля «scope» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the scope field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private RequestScope scope;

    /**

     * <p><strong>RU:</strong> значение поля «limits» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the limits field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private RequestLimits limits;

    /**

     * <p><strong>RU:</strong> значение поля «highlight» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the highlight field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private RequestHighlight highlight;

    /**

     * <p><strong>RU:</strong> значение поля «ranges» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the ranges field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private List<RequestRange> ranges;

    /**
     * RU: Создаёт экземпляр SearchRequest.
     * EN: Creates a SearchRequest instance.
     */
    public SearchRequest() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «query» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the query field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение query. EN: current value of query.
     */

    public RequestQuery getQuery() {
        return query;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «query» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the query field in the Alfresco REST API model.</p>
     *
     * @param query RU: новое значение query. EN: new value for query.
     */

    public void setQuery(RequestQuery query) {
        this.query = query;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «paging» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the paging field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение paging. EN: current value of paging.
     */

    public RequestPagination getPaging() {
        return paging;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «paging» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the paging field in the Alfresco REST API model.</p>
     *
     * @param paging RU: новое значение paging. EN: new value for paging.
     */

    public void setPaging(RequestPagination paging) {
        this.paging = paging;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «include» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the include field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение include. EN: current value of include.
     */

    public RequestInclude getInclude() {
        return include;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «include» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the include field in the Alfresco REST API model.</p>
     *
     * @param include RU: новое значение include. EN: new value for include.
     */

    public void setInclude(RequestInclude include) {
        this.include = include;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «include request» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns When true, include the original request in the response.</p>
     *
     * @return RU: текущее значение includeRequest. EN: current value of includeRequest.
     */

    public Boolean getIncludeRequest() {
        return includeRequest;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «include request» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets When true, include the original request in the response.</p>
     *
     * @param includeRequest RU: новое значение includeRequest. EN: new value for includeRequest.
     */

    public void setIncludeRequest(Boolean includeRequest) {
        this.includeRequest = includeRequest;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «fields» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the fields field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение fields. EN: current value of fields.
     */

    public RequestFields getFields() {
        return fields;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «fields» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the fields field in the Alfresco REST API model.</p>
     *
     * @param fields RU: новое значение fields. EN: new value for fields.
     */

    public void setFields(RequestFields fields) {
        this.fields = fields;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «sort» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the sort field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение sort. EN: current value of sort.
     */

    public RequestSortDefinition getSort() {
        return sort;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «sort» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the sort field in the Alfresco REST API model.</p>
     *
     * @param sort RU: новое значение sort. EN: new value for sort.
     */

    public void setSort(RequestSortDefinition sort) {
        this.sort = sort;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «templates» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the templates field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение templates. EN: current value of templates.
     */

    public RequestTemplates getTemplates() {
        return templates;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «templates» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the templates field in the Alfresco REST API model.</p>
     *
     * @param templates RU: новое значение templates. EN: new value for templates.
     */

    public void setTemplates(RequestTemplates templates) {
        this.templates = templates;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «defaults» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the defaults field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение defaults. EN: current value of defaults.
     */

    public RequestDefaults getDefaults() {
        return defaults;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «defaults» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the defaults field in the Alfresco REST API model.</p>
     *
     * @param defaults RU: новое значение defaults. EN: new value for defaults.
     */

    public void setDefaults(RequestDefaults defaults) {
        this.defaults = defaults;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «localization» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the localization field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение localization. EN: current value of localization.
     */

    public RequestLocalization getLocalization() {
        return localization;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «localization» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the localization field in the Alfresco REST API model.</p>
     *
     * @param localization RU: новое значение localization. EN: new value for localization.
     */

    public void setLocalization(RequestLocalization localization) {
        this.localization = localization;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «filter queries» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the filter queries field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение filterQueries. EN: current value of filterQueries.
     */

    public RequestFilterQueries getFilterQueries() {
        return filterQueries;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «filter queries» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the filter queries field in the Alfresco REST API model.</p>
     *
     * @param filterQueries RU: новое значение filterQueries. EN: new value for filterQueries.
     */

    public void setFilterQueries(RequestFilterQueries filterQueries) {
        this.filterQueries = filterQueries;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «facet queries» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the facet queries field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение facetQueries. EN: current value of facetQueries.
     */

    public RequestFacetQueries getFacetQueries() {
        return facetQueries;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «facet queries» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the facet queries field in the Alfresco REST API model.</p>
     *
     * @param facetQueries RU: новое значение facetQueries. EN: new value for facetQueries.
     */

    public void setFacetQueries(RequestFacetQueries facetQueries) {
        this.facetQueries = facetQueries;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «facet fields» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the facet fields field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение facetFields. EN: current value of facetFields.
     */

    public RequestFacetFields getFacetFields() {
        return facetFields;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «facet fields» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the facet fields field in the Alfresco REST API model.</p>
     *
     * @param facetFields RU: новое значение facetFields. EN: new value for facetFields.
     */

    public void setFacetFields(RequestFacetFields facetFields) {
        this.facetFields = facetFields;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «facet intervals» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the facet intervals field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение facetIntervals. EN: current value of facetIntervals.
     */

    public RequestFacetIntervals getFacetIntervals() {
        return facetIntervals;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «facet intervals» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the facet intervals field in the Alfresco REST API model.</p>
     *
     * @param facetIntervals RU: новое значение facetIntervals. EN: new value for facetIntervals.
     */

    public void setFacetIntervals(RequestFacetIntervals facetIntervals) {
        this.facetIntervals = facetIntervals;
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

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «stats» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the stats field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение stats. EN: current value of stats.
     */

    public List<RequestStats> getStats() {
        return stats;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «stats» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the stats field in the Alfresco REST API model.</p>
     *
     * @param stats RU: новое значение stats. EN: new value for stats.
     */

    public void setStats(List<RequestStats> stats) {
        this.stats = stats;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «spellcheck» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the spellcheck field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение spellcheck. EN: current value of spellcheck.
     */

    public RequestSpellcheck getSpellcheck() {
        return spellcheck;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «spellcheck» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the spellcheck field in the Alfresco REST API model.</p>
     *
     * @param spellcheck RU: новое значение spellcheck. EN: new value for spellcheck.
     */

    public void setSpellcheck(RequestSpellcheck spellcheck) {
        this.spellcheck = spellcheck;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «scope» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the scope field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение scope. EN: current value of scope.
     */

    public RequestScope getScope() {
        return scope;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «scope» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the scope field in the Alfresco REST API model.</p>
     *
     * @param scope RU: новое значение scope. EN: new value for scope.
     */

    public void setScope(RequestScope scope) {
        this.scope = scope;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «limits» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the limits field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение limits. EN: current value of limits.
     */

    public RequestLimits getLimits() {
        return limits;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «limits» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the limits field in the Alfresco REST API model.</p>
     *
     * @param limits RU: новое значение limits. EN: new value for limits.
     */

    public void setLimits(RequestLimits limits) {
        this.limits = limits;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «highlight» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the highlight field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение highlight. EN: current value of highlight.
     */

    public RequestHighlight getHighlight() {
        return highlight;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «highlight» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the highlight field in the Alfresco REST API model.</p>
     *
     * @param highlight RU: новое значение highlight. EN: new value for highlight.
     */

    public void setHighlight(RequestHighlight highlight) {
        this.highlight = highlight;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «ranges» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the ranges field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение ranges. EN: current value of ranges.
     */

    public List<RequestRange> getRanges() {
        return ranges;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «ranges» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the ranges field in the Alfresco REST API model.</p>
     *
     * @param ranges RU: новое значение ranges. EN: new value for ranges.
     */

    public void setRanges(List<RequestRange> ranges) {
        this.ranges = ranges;
    }

}
