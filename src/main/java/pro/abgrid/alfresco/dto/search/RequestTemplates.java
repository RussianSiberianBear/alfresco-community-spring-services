package pro.abgrid.alfresco.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;

/**
 * RU: DTO-модель Alfresco REST API: RequestTemplates.
 * EN: Alfresco REST API DTO model: RequestTemplates.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestTemplates extends ArrayList<Object> {
    /**
     * RU: Создаёт экземпляр RequestTemplates.
     * EN: Creates a RequestTemplates instance.
     */
    public RequestTemplates() {
        super();
    }
}
