package pro.abgrid.alfresco.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * RU: DTO-модель Alfresco REST API: ResultSetContext.
 * EN: Alfresco REST API DTO model: ResultSetContext.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultSetContext {
    /**
     * <p><strong>RU:</strong> значение поля «consistency» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Value of the consistency field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>
     */
    private ResponseConsistency consistency;

    /**

     * <p><strong>RU:</strong> значение поля «request» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the request field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private SearchRequest request;

    /**

     * <p><strong>RU:</strong> значение поля «facet queries» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The counts from facet queries. Optional unless a specific endpoint requires it.</p>

     */

    private List<Object> facetQueries;

    /**

     * <p><strong>RU:</strong> значение поля «facets fields» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The counts from field facets. Optional unless a specific endpoint requires it.</p>

     */

    private List<ResultBuckets> facetsFields;

    /**

     * <p><strong>RU:</strong> значение поля «facets» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The faceted response. Optional unless a specific endpoint requires it.</p>

     */

    private List<GenericFacetResponse> facets;

    /**

     * <p><strong>RU:</strong> значение поля «spellcheck» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Suggested corrections If zero results were found for the original query then a single entry of type "searchInsteadFor" will be returned. If alternatives were found that return more results than the original query they are returned as "didYouMean" options. The highest quality suggestion is first.. Optional unless a specific endpoint requires it.</p>

     */

    private List<Object> spellcheck;

    /**
     * RU: Создаёт экземпляр ResultSetContext.
     * EN: Creates a ResultSetContext instance.
     */
    public ResultSetContext() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «consistency» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the consistency field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение consistency. EN: current value of consistency.
     */

    public ResponseConsistency getConsistency() {
        return consistency;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «consistency» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the consistency field in the Alfresco REST API model.</p>
     *
     * @param consistency RU: новое значение consistency. EN: new value for consistency.
     */

    public void setConsistency(ResponseConsistency consistency) {
        this.consistency = consistency;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «request» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the request field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение request. EN: current value of request.
     */

    public SearchRequest getRequest() {
        return request;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «request» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the request field in the Alfresco REST API model.</p>
     *
     * @param request RU: новое значение request. EN: new value for request.
     */

    public void setRequest(SearchRequest request) {
        this.request = request;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «facet queries» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The counts from facet queries.</p>
     *
     * @return RU: текущее значение facetQueries. EN: current value of facetQueries.
     */

    public List<Object> getFacetQueries() {
        return facetQueries;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «facet queries» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The counts from facet queries.</p>
     *
     * @param facetQueries RU: новое значение facetQueries. EN: new value for facetQueries.
     */

    public void setFacetQueries(List<Object> facetQueries) {
        this.facetQueries = facetQueries;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «facets fields» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The counts from field facets.</p>
     *
     * @return RU: текущее значение facetsFields. EN: current value of facetsFields.
     */

    public List<ResultBuckets> getFacetsFields() {
        return facetsFields;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «facets fields» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The counts from field facets.</p>
     *
     * @param facetsFields RU: новое значение facetsFields. EN: new value for facetsFields.
     */

    public void setFacetsFields(List<ResultBuckets> facetsFields) {
        this.facetsFields = facetsFields;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «facets» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The faceted response.</p>
     *
     * @return RU: текущее значение facets. EN: current value of facets.
     */

    public List<GenericFacetResponse> getFacets() {
        return facets;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «facets» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The faceted response.</p>
     *
     * @param facets RU: новое значение facets. EN: new value for facets.
     */

    public void setFacets(List<GenericFacetResponse> facets) {
        this.facets = facets;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «spellcheck» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Suggested corrections If zero results were found for the original query then a single entry of type "searchInsteadFor" will be returned. If alternatives were found that return more results than the original query they are returned as "didYouMean" options. The highest quality suggestion is first..</p>
     *
     * @return RU: текущее значение spellcheck. EN: current value of spellcheck.
     */

    public List<Object> getSpellcheck() {
        return spellcheck;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «spellcheck» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Suggested corrections If zero results were found for the original query then a single entry of type "searchInsteadFor" will be returned. If alternatives were found that return more results than the original query they are returned as "didYouMean" options. The highest quality suggestion is first..</p>
     *
     * @param spellcheck RU: новое значение spellcheck. EN: new value for spellcheck.
     */

    public void setSpellcheck(List<Object> spellcheck) {
        this.spellcheck = spellcheck;
    }

}
