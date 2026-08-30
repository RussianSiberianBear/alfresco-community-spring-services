package pro.abgrid.alfresco.api;

import pro.abgrid.alfresco.dto.core.RatingBody;
import pro.abgrid.alfresco.dto.core.RatingEntry;
import pro.abgrid.alfresco.dto.core.RatingPaging;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

/**
 * <p><strong>RU:</strong> Низкоуровневый HTTP-интерфейс RatingsApi отображает операции Alfresco REST API на Spring HTTP Service. В обычном прикладном коде предпочтительнее high-level сервисы; этот интерфейс нужен для параметров и endpoint, не покрытых удобной обёрткой.</p>
 * <p><strong>EN:</strong> Low-level HTTP interface RatingsApi maps Alfresco REST operations to Spring HTTP Service methods. Application code will normally prefer high-level services; use this interface for endpoint-level control or operations without a high-level wrapper.</p>
 * <p><strong>RU:</strong> HTTP-ошибки преобразуются общей конфигурацией клиента в AlfrescoApiException.</p>
 * <p><strong>EN:</strong> HTTP errors are converted by the shared client configuration into AlfrescoApiException.</p>
 */
public interface RatingsApi {

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Gets a list of ratings for node nodeId.</p>
     * <p><strong>REST:</strong> GET /nodes/{nodeId}/ratings; operationId: listRatings.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listRatings в generated-модели RatingPaging. EN: Alfresco response for listRatings represented as RatingPaging.
     */

    @GetExchange(url = "/nodes/{nodeId}/ratings")
    RatingPaging listRatings(@PathVariable("nodeId") String nodeId, @RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Создаёт ресурс или связь в Alfresco. Метод напрямую отражает REST-контракт и принимает generated DTO тела запроса.</p>
     * <p><strong>EN:</strong> Create a rating for the node with identifier nodeId</p>
     * <p><strong>REST:</strong> POST /nodes/{nodeId}/ratings; operationId: createRating.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param ratingBodyCreate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: For "myRating" the type is specific to the rating scheme, boolean for the likes and an integer for the fiveStar. For example, to "like" a file the following body would be used: JSON { "id": "likes", "myRating": true }. Required.
     * @return RU: ответ Alfresco для createRating в generated-модели RatingEntry. EN: Alfresco response for createRating represented as RatingEntry.
     */

    @PostExchange(url = "/nodes/{nodeId}/ratings")
    RatingEntry createRating(@PathVariable("nodeId") String nodeId, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody RatingBody ratingBodyCreate);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Get the specific rating ratingId on node nodeId.</p>
     * <p><strong>REST:</strong> GET /nodes/{nodeId}/ratings/{ratingId}; operationId: getRating.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param ratingId RU: тип рейтинга, например likes или fiveStar. Обязательный параметр. EN: The identifier of a rating.. Required.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для getRating в generated-модели RatingEntry. EN: Alfresco response for getRating represented as RatingEntry.
     */

    @GetExchange(url = "/nodes/{nodeId}/ratings/{ratingId}")
    RatingEntry getRating(@PathVariable("nodeId") String nodeId, @PathVariable("ratingId") String ratingId, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Удаляет ресурс или связь через Alfresco REST API; обратимость зависит от конкретной операции и её параметров.</p>
     * <p><strong>EN:</strong> Deletes rating ratingId from node nodeId.</p>
     * <p><strong>REST:</strong> DELETE /nodes/{nodeId}/ratings/{ratingId}; operationId: deleteRating.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param ratingId RU: тип рейтинга, например likes или fiveStar. Обязательный параметр. EN: The identifier of a rating.. Required.
     */

    @DeleteExchange(url = "/nodes/{nodeId}/ratings/{ratingId}")
    Void deleteRating(@PathVariable("nodeId") String nodeId, @PathVariable("ratingId") String ratingId);
}
