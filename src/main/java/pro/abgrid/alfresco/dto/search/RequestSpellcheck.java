package pro.abgrid.alfresco.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: RequestSpellcheck.
 * EN: Alfresco REST API DTO model: RequestSpellcheck.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestSpellcheck {
    /**
     * <p><strong>RU:</strong> значение поля «query» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Value of the query field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>
     */
    private String query;

    /**
     * RU: Создаёт экземпляр RequestSpellcheck.
     * EN: Creates a RequestSpellcheck instance.
     */
    public RequestSpellcheck() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «query» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the query field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение query. EN: current value of query.
     */

    public String getQuery() {
        return query;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «query» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the query field in the Alfresco REST API model.</p>
     *
     * @param query RU: новое значение query. EN: new value for query.
     */

    public void setQuery(String query) {
        this.query = query;
    }

}
