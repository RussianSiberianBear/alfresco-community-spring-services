package pro.abgrid.alfresco.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: RequestScope.
 * EN: Alfresco REST API DTO model: RequestScope.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestScope {
    /**
     * <p><strong>RU:</strong> значение поля «locations» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> The locations to include in the query. Optional unless a specific endpoint requires it.</p>
     */
    private String locations;

    /**
     * RU: Создаёт экземпляр RequestScope.
     * EN: Creates a RequestScope instance.
     */
    public RequestScope() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «locations» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The locations to include in the query.</p>
     *
     * @return RU: текущее значение locations. EN: current value of locations.
     */

    public String getLocations() {
        return locations;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «locations» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The locations to include in the query.</p>
     *
     * @param locations RU: новое значение locations. EN: new value for locations.
     */

    public void setLocations(String locations) {
        this.locations = locations;
    }

}
