package pro.abgrid.alfresco.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * RU: DTO-модель Alfresco REST API: RequestFacetFields.
 * EN: Alfresco REST API DTO model: RequestFacetFields.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestFacetFields {
    /**
     * <p><strong>RU:</strong> значение поля «facets» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Define specifc fields on which to facet (adds SOLR facet.field and f.field.facet.* options). Optional unless a specific endpoint requires it.</p>
     */
    private List<RequestFacetField> facets;

    /**
     * RU: Создаёт экземпляр RequestFacetFields.
     * EN: Creates a RequestFacetFields instance.
     */
    public RequestFacetFields() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «facets» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Define specifc fields on which to facet (adds SOLR facet.field and f.field.facet.* options).</p>
     *
     * @return RU: текущее значение facets. EN: current value of facets.
     */

    public List<RequestFacetField> getFacets() {
        return facets;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «facets» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Define specifc fields on which to facet (adds SOLR facet.field and f.field.facet.* options).</p>
     *
     * @param facets RU: новое значение facets. EN: new value for facets.
     */

    public void setFacets(List<RequestFacetField> facets) {
        this.facets = facets;
    }

}
