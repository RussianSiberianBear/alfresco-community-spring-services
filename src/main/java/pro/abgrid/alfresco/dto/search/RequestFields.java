package pro.abgrid.alfresco.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;

/**
 * RU: DTO-модель Alfresco REST API: RequestFields.
 * EN: Alfresco REST API DTO model: RequestFields.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestFields extends ArrayList<String> {
    /**
     * RU: Создаёт экземпляр RequestFields.
     * EN: Creates a RequestFields instance.
     */
    public RequestFields() {
        super();
    }
}
