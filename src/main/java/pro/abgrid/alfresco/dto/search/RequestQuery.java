package pro.abgrid.alfresco.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: RequestQuery.
 * EN: Alfresco REST API DTO model: RequestQuery.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestQuery {
    /**
     * <p><strong>RU:</strong> значение поля «language» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> The query language in which the query is written.. Optional unless a specific endpoint requires it.</p>
     */
    private String language;

    /**

     * <p><strong>RU:</strong> значение поля «user query» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The exact search request typed in by the user. Optional unless a specific endpoint requires it.</p>

     */

    private String userQuery;

    /**

     * <p><strong>RU:</strong> значение поля «query» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> The query which may have been generated in some way from the userQuery. Required by the Swagger schema.</p>

     */

    private String query;

    /**
     * RU: Создаёт экземпляр RequestQuery.
     * EN: Creates a RequestQuery instance.
     */
    public RequestQuery() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «language» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The query language in which the query is written..</p>
     *
     * @return RU: текущее значение language. EN: current value of language.
     */

    public String getLanguage() {
        return language;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «language» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The query language in which the query is written..</p>
     *
     * @param language RU: новое значение language. EN: new value for language.
     */

    public void setLanguage(String language) {
        this.language = language;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «user query» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The exact search request typed in by the user.</p>
     *
     * @return RU: текущее значение userQuery. EN: current value of userQuery.
     */

    public String getUserQuery() {
        return userQuery;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «user query» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The exact search request typed in by the user.</p>
     *
     * @param userQuery RU: новое значение userQuery. EN: new value for userQuery.
     */

    public void setUserQuery(String userQuery) {
        this.userQuery = userQuery;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «query» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The query which may have been generated in some way from the userQuery.</p>
     *
     * @return RU: текущее значение query. EN: current value of query.
     */

    public String getQuery() {
        return query;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «query» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The query which may have been generated in some way from the userQuery.</p>
     *
     * @param query RU: новое значение query. EN: new value for query.
     */

    public void setQuery(String query) {
        this.query = query;
    }

}
