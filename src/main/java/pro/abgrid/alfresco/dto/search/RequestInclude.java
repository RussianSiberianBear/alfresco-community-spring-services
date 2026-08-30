package pro.abgrid.alfresco.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;

/**
 * RU: DTO-модель Alfresco REST API: RequestInclude.
 * EN: Alfresco REST API DTO model: RequestInclude.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestInclude extends ArrayList<String> {
    /**
     * RU: Создаёт экземпляр RequestInclude.
     * EN: Creates a RequestInclude instance.
     */
    public RequestInclude() {
        super();
    }
}
