package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: Pagination.
 * EN: Alfresco REST API DTO model: Pagination.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pagination {
    /**
     * <p><strong>RU:</strong> значение поля «count» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> The number of objects in the entries array.. Required by the Swagger schema.</p>
     */
    private Long count;

    /**

     * <p><strong>RU:</strong> признак наличия следующей страницы. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> A boolean value which is true if there are more entities in the collection beyond those in this response. A true value means a request with a larger value for the skipCount or the maxItems parameter will return more entities.. Required by the Swagger schema.</p>

     */

    private Boolean hasMoreItems;

    /**

     * <p><strong>RU:</strong> общее количество элементов, если сервер его вычислял. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> An integer describing the total number of entities in the collection. The API might not be able to determine this value, in which case this property will not be present.. Optional unless a specific endpoint requires it.</p>

     */

    private Long totalItems;

    /**

     * <p><strong>RU:</strong> значение поля «skip count» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> An integer describing how many entities exist in the collection before those included in this list.. Required by the Swagger schema.</p>

     */

    private Long skipCount;

    /**

     * <p><strong>RU:</strong> значение поля «max items» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> The value of the maxItems parameter used to generate this list, or if there was no maxItems parameter the default value is 100. Required by the Swagger schema.</p>

     */

    private Long maxItems;

    /**
     * RU: Создаёт экземпляр Pagination.
     * EN: Creates a Pagination instance.
     */
    public Pagination() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «count» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The number of objects in the entries array..</p>
     *
     * @return RU: текущее значение count. EN: current value of count.
     */

    public Long getCount() {
        return count;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «count» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The number of objects in the entries array..</p>
     *
     * @param count RU: новое значение count. EN: new value for count.
     */

    public void setCount(Long count) {
        this.count = count;
    }

        /**
     * <p><strong>RU:</strong> Возвращает признак наличия следующей страницы.</p>
     * <p><strong>EN:</strong> Returns A boolean value which is true if there are more entities in the collection beyond those in this response. A true value means a request with a larger value for the skipCount or the maxItems parameter will return more entities..</p>
     *
     * @return RU: текущее значение hasMoreItems. EN: current value of hasMoreItems.
     */

    public Boolean getHasMoreItems() {
        return hasMoreItems;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает признак наличия следующей страницы.</p>
     * <p><strong>EN:</strong> Sets A boolean value which is true if there are more entities in the collection beyond those in this response. A true value means a request with a larger value for the skipCount or the maxItems parameter will return more entities..</p>
     *
     * @param hasMoreItems RU: новое значение hasMoreItems. EN: new value for hasMoreItems.
     */

    public void setHasMoreItems(Boolean hasMoreItems) {
        this.hasMoreItems = hasMoreItems;
    }

        /**
     * <p><strong>RU:</strong> Возвращает общее количество элементов, если сервер его вычислял.</p>
     * <p><strong>EN:</strong> Returns An integer describing the total number of entities in the collection. The API might not be able to determine this value, in which case this property will not be present..</p>
     *
     * @return RU: текущее значение totalItems. EN: current value of totalItems.
     */

    public Long getTotalItems() {
        return totalItems;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает общее количество элементов, если сервер его вычислял.</p>
     * <p><strong>EN:</strong> Sets An integer describing the total number of entities in the collection. The API might not be able to determine this value, in which case this property will not be present..</p>
     *
     * @param totalItems RU: новое значение totalItems. EN: new value for totalItems.
     */

    public void setTotalItems(Long totalItems) {
        this.totalItems = totalItems;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «skip count» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns An integer describing how many entities exist in the collection before those included in this list..</p>
     *
     * @return RU: текущее значение skipCount. EN: current value of skipCount.
     */

    public Long getSkipCount() {
        return skipCount;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «skip count» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets An integer describing how many entities exist in the collection before those included in this list..</p>
     *
     * @param skipCount RU: новое значение skipCount. EN: new value for skipCount.
     */

    public void setSkipCount(Long skipCount) {
        this.skipCount = skipCount;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «max items» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The value of the maxItems parameter used to generate this list, or if there was no maxItems parameter the default value is 100.</p>
     *
     * @return RU: текущее значение maxItems. EN: current value of maxItems.
     */

    public Long getMaxItems() {
        return maxItems;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «max items» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The value of the maxItems parameter used to generate this list, or if there was no maxItems parameter the default value is 100.</p>
     *
     * @param maxItems RU: новое значение maxItems. EN: new value for maxItems.
     */

    public void setMaxItems(Long maxItems) {
        this.maxItems = maxItems;
    }

}
