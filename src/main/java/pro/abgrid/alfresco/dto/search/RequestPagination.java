package pro.abgrid.alfresco.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: RequestPagination.
 * EN: Alfresco REST API DTO model: RequestPagination.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestPagination {
    /**
     * <p><strong>RU:</strong> значение поля «max items» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> The maximum number of items to return in the query results. Optional unless a specific endpoint requires it.</p>
     */
    private Integer maxItems;

    /**

     * <p><strong>RU:</strong> значение поля «skip count» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The number of items to skip from the start of the query set. Optional unless a specific endpoint requires it.</p>

     */

    private Integer skipCount;

    /**
     * RU: Создаёт экземпляр RequestPagination.
     * EN: Creates a RequestPagination instance.
     */
    public RequestPagination() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «max items» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The maximum number of items to return in the query results.</p>
     *
     * @return RU: текущее значение maxItems. EN: current value of maxItems.
     */

    public Integer getMaxItems() {
        return maxItems;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «max items» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The maximum number of items to return in the query results.</p>
     *
     * @param maxItems RU: новое значение maxItems. EN: new value for maxItems.
     */

    public void setMaxItems(Integer maxItems) {
        this.maxItems = maxItems;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «skip count» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The number of items to skip from the start of the query set.</p>
     *
     * @return RU: текущее значение skipCount. EN: current value of skipCount.
     */

    public Integer getSkipCount() {
        return skipCount;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «skip count» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The number of items to skip from the start of the query set.</p>
     *
     * @param skipCount RU: новое значение skipCount. EN: new value for skipCount.
     */

    public void setSkipCount(Integer skipCount) {
        this.skipCount = skipCount;
    }

}
