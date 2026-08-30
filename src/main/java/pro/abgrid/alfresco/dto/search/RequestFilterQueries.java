package pro.abgrid.alfresco.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;

/**
 * RU: DTO-модель Alfresco REST API: RequestFilterQueries.
 * EN: Alfresco REST API DTO model: RequestFilterQueries.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestFilterQueries extends ArrayList<Object> {
    /**
     * RU: Создаёт экземпляр RequestFilterQueries.
     * EN: Creates a RequestFilterQueries instance.
     */
    public RequestFilterQueries() {
        super();
    }
}
