package pro.abgrid.alfresco.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;

/**
 * RU: DTO-модель Alfresco REST API: RequestSortDefinition.
 * EN: Alfresco REST API DTO model: RequestSortDefinition.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestSortDefinition extends ArrayList<Object> {
    /**
     * RU: Создаёт экземпляр RequestSortDefinition.
     * EN: Creates a RequestSortDefinition instance.
     */
    public RequestSortDefinition() {
        super();
    }
}
