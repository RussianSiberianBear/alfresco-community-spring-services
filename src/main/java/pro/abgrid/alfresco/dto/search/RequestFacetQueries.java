package pro.abgrid.alfresco.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;

/**
 * RU: DTO-модель Alfresco REST API: RequestFacetQueries.
 * EN: Alfresco REST API DTO model: RequestFacetQueries.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestFacetQueries extends ArrayList<Object> {
    /**
     * RU: Создаёт экземпляр RequestFacetQueries.
     * EN: Creates a RequestFacetQueries instance.
     */
    public RequestFacetQueries() {
        super();
    }
}
