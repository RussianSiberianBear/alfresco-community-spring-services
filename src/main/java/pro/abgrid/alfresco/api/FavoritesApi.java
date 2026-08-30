package pro.abgrid.alfresco.api;

import pro.abgrid.alfresco.dto.core.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

/**
 * <p><strong>RU:</strong> Низкоуровневый HTTP-интерфейс FavoritesApi отображает операции Alfresco REST API на Spring HTTP Service. В обычном прикладном коде предпочтительнее high-level сервисы; этот интерфейс нужен для параметров и endpoint, не покрытых удобной обёрткой.</p>
 * <p><strong>EN:</strong> Low-level HTTP interface FavoritesApi maps Alfresco REST operations to Spring HTTP Service methods. Application code will normally prefer high-level services; use this interface for endpoint-level control or operations without a high-level wrapper.</p>
 * <p><strong>RU:</strong> HTTP-ошибки преобразуются общей конфигурацией клиента в AlfrescoApiException.</p>
 * <p><strong>EN:</strong> HTTP errors are converted by the shared client configuration into AlfrescoApiException.</p>
 */
public interface FavoritesApi {

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Note: this endpoint is deprecated as of Alfresco 4.2, and will be removed in the future. Use /people/{personId}/favorites instead. Gets a list of a person's favorite sites. You can use the -me- string in place of &lt;personId&gt; to specify the currently authenticated user.</p>
     * <p><strong>REST:</strong> GET /people/{personId}/favorite-sites; operationId: listFavoriteSitesForPerson.</p>
     *
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listFavoriteSitesForPerson в generated-модели SitePaging. EN: Alfresco response for listFavoriteSitesForPerson represented as SitePaging.
     */

    @GetExchange(url = "/people/{personId}/favorite-sites")
    SitePaging listFavoriteSitesForPerson(@PathVariable("personId") String personId, @RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Создаёт ресурс или связь в Alfresco. Метод напрямую отражает REST-контракт и принимает generated DTO тела запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is deprecated as of Alfresco 4.2, and will be removed in the future. Use /people/{personId}/favorites instead. Create a site favorite for person personId. You can use the -me- string in place of &lt;personId&gt; to specify the currently authenticated user. Note: You can favorite more than one site by specifying a list of sites in the JSON body like this: JSON [ { "id": "test-site-1" }, { "id": "test-site-2" } ] If you specify a list as input, then a paginated list rather than an entry is returned in the response body. For example: JSON { "list": { "pagination": { "count": 2, "hasMoreItems": false, "totalItems": 2, "skipCount": 0, "maxItems": 100 }, "entries": [ { "entry": { ... } }, { "entry": { ... } } ] } }</p>
     * <p><strong>REST:</strong> POST /people/{personId}/favorite-sites; operationId: createSiteFavorite.</p>
     *
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param favoriteSiteBodyCreate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The id of the site to favorite.. Required.
     * @return RU: ответ Alfresco для createSiteFavorite в generated-модели FavoriteSiteEntry. EN: Alfresco response for createSiteFavorite represented as FavoriteSiteEntry.
     */

    @PostExchange(url = "/people/{personId}/favorite-sites")
    FavoriteSiteEntry createSiteFavorite(@PathVariable("personId") String personId, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody FavoriteSiteBodyCreate favoriteSiteBodyCreate);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is deprecated as of Alfresco 4.2, and will be removed in the future. Use /people/{personId}/favorites/{favoriteId} instead. Gets information on favorite site siteId of person personId. You can use the -me- string in place of &lt;personId&gt; to specify the currently authenticated user.</p>
     * <p><strong>REST:</strong> GET /people/{personId}/favorite-sites/{siteId}; operationId: getFavoriteSite.</p>
     *
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     * @param siteId RU: короткий идентификатор сайта Alfresco. Обязательный параметр. EN: The identifier of a site.. Required.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для getFavoriteSite в generated-модели SiteEntry. EN: Alfresco response for getFavoriteSite represented as SiteEntry.
     */

    @GetExchange(url = "/people/{personId}/favorite-sites/{siteId}")
    SiteEntry getFavoriteSite(@PathVariable("personId") String personId, @PathVariable("siteId") String siteId, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Удаляет ресурс или связь через Alfresco REST API; обратимость зависит от конкретной операции и её параметров.</p>
     * <p><strong>EN:</strong> Note: this endpoint is deprecated as of Alfresco 4.2, and will be removed in the future. Use /people/{personId}/favorites/{favoriteId} instead. Deletes site siteId from the favorite site list of person personId. You can use the -me- string in place of &lt;personId&gt; to specify the currently authenticated user.</p>
     * <p><strong>REST:</strong> DELETE /people/{personId}/favorite-sites/{siteId}; operationId: deleteSiteFavorite.</p>
     *
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     * @param siteId RU: короткий идентификатор сайта Alfresco. Обязательный параметр. EN: The identifier of a site.. Required.
     */

    @DeleteExchange(url = "/people/{personId}/favorite-sites/{siteId}")
    Void deleteSiteFavorite(@PathVariable("personId") String personId, @PathVariable("siteId") String siteId);

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Gets a list of favorites for person personId. You can use the -me- string in place of &lt;personId&gt; to specify the currently authenticated user. The default sort order for the returned list of favorites is type ascending, createdAt descending. You can override the default by using the orderBy parameter. You can use any of the following fields to order the results: * type * createdAt * title You can use the where parameter to restrict the list in the response to entries of a specific kind. The where parameter takes a value. The value is a single predicate that can include one or more EXISTS conditions. The EXISTS condition uses a single operand to limit the list to include entries that include that one property. The property values are: * target/file * target/folder * target/site For example, the following where parameter restricts the returned list to the file favorites for a person: SQL (EXISTS(target/file)) You can specify more than one condition using OR. The predicate must be en…</p>
     * <p><strong>REST:</strong> GET /people/{personId}/favorites; operationId: listFavorites.</p>
     *
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param orderBy RU: серверные выражения сортировки. Необязательный параметр, если аннотация допускает null. EN: A string to control the order of the entities returned in a list. You can use the orderBy parameter to sort the list by one or more fields. Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order. To sort the entities in a specific order, you can use the ASC and DESC keywords for any field.. Optional when the method annotation allows null.
     * @param where RU: серверное выражение фильтрации Alfresco. Необязательный параметр, если аннотация допускает null. EN: A string to restrict the returned objects by using a predicate.. Optional when the method annotation allows null.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about favorites, the following optional fields can be requested: * path (note, this only applies to files and folders) * properties * allowableOperations. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listFavorites в generated-модели FavoritePaging. EN: Alfresco response for listFavorites represented as FavoritePaging.
     */

    @GetExchange(url = "/people/{personId}/favorites")
    FavoritePaging listFavorites(@PathVariable("personId") String personId, @RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "orderBy", required = false) List<String> orderBy, @RequestParam(value = "where", required = false) String where, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Создаёт ресурс или связь в Alfresco. Метод напрямую отражает REST-контракт и принимает generated DTO тела запроса.</p>
     * <p><strong>EN:</strong> Favorite a site, file, or folder in the repository. You can use the -me- string in place of &lt;personId&gt; to specify the currently authenticated user. Note: You can favorite more than one entity by specifying a list of objects in the JSON body like this: JSON [ { "target": { "file": { "guid": "abcde-01234-...." } } }, { "target": { "file": { "guid": "abcde-09863-...." } } }, ] If you specify a list as input, then a paginated list rather than an entry is returned in the response body. For example: JSON { "list": { "pagination": { "count": 2, "hasMoreItems": false, "totalItems": 2, "skipCount": 0, "maxItems": 100 }, "entries": [ { "entry": { ... } }, { "entry": { ... } } ] } }</p>
     * <p><strong>REST:</strong> POST /people/{personId}/favorites; operationId: createFavorite.</p>
     *
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about favorites, the following optional fields can be requested: * path (note, this only applies to files and folders) * properties * allowableOperations. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param favoriteBodyCreate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: An object identifying the entity to be favorited. The object consists of a single property which is an object with the name site, file, or folder. The content of that object is the guid of the target entity. For example, to favorite a file the following body would be used: JSON { "target": { "file": { "guid": "abcde-01234-...." } } }. Required.
     * @return RU: ответ Alfresco для createFavorite в generated-модели FavoriteEntry. EN: Alfresco response for createFavorite represented as FavoriteEntry.
     */

    @PostExchange(url = "/people/{personId}/favorites")
    FavoriteEntry createFavorite(@PathVariable("personId") String personId, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody FavoriteBodyCreate favoriteBodyCreate);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Gets favorite favoriteId for person personId. You can use the -me- string in place of &lt;personId&gt; to specify the currently authenticated user.</p>
     * <p><strong>REST:</strong> GET /people/{personId}/favorites/{favoriteId}; operationId: getFavorite.</p>
     *
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     * @param favoriteId RU: идентификатор favorite. Обязательный параметр. EN: The identifier of a favorite.. Required.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about favorites, the following optional fields can be requested: * path (note, this only applies to files and folders) * properties * allowableOperations. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для getFavorite в generated-модели FavoriteEntry. EN: Alfresco response for getFavorite represented as FavoriteEntry.
     */

    @GetExchange(url = "/people/{personId}/favorites/{favoriteId}")
    FavoriteEntry getFavorite(@PathVariable("personId") String personId, @PathVariable("favoriteId") String favoriteId, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Удаляет ресурс или связь через Alfresco REST API; обратимость зависит от конкретной операции и её параметров.</p>
     * <p><strong>EN:</strong> Deletes favoriteId as a favorite of person personId. You can use the -me- string in place of &lt;personId&gt; to specify the currently authenticated user.</p>
     * <p><strong>REST:</strong> DELETE /people/{personId}/favorites/{favoriteId}; operationId: deleteFavorite.</p>
     *
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     * @param favoriteId RU: идентификатор favorite. Обязательный параметр. EN: The identifier of a favorite.. Required.
     */

    @DeleteExchange(url = "/people/{personId}/favorites/{favoriteId}")
    Void deleteFavorite(@PathVariable("personId") String personId, @PathVariable("favoriteId") String favoriteId);
}
