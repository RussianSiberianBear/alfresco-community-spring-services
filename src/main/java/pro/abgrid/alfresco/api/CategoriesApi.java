package pro.abgrid.alfresco.api;

import pro.abgrid.alfresco.dto.core.CategoryBody;
import pro.abgrid.alfresco.dto.core.CategoryEntry;
import pro.abgrid.alfresco.dto.core.CategoryLinkBody;
import pro.abgrid.alfresco.dto.core.CategoryPaging;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

/**
 * <p><strong>RU:</strong> Низкоуровневый HTTP-интерфейс CategoriesApi отображает операции Alfresco REST API на Spring HTTP Service. В обычном прикладном коде предпочтительнее high-level сервисы; этот интерфейс нужен для параметров и endpoint, не покрытых удобной обёрткой.</p>
 * <p><strong>EN:</strong> Low-level HTTP interface CategoriesApi maps Alfresco REST operations to Spring HTTP Service methods. Application code will normally prefer high-level services; use this interface for endpoint-level control or operations without a high-level wrapper.</p>
 * <p><strong>RU:</strong> HTTP-ошибки преобразуются общей конфигурацией клиента в AlfrescoApiException.</p>
 * <p><strong>EN:</strong> HTTP errors are converted by the shared client configuration into AlfrescoApiException.</p>
 */
public interface CategoriesApi {

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.4 and newer versions. Gets a list of categories for node nodeId.</p>
     * <p><strong>REST:</strong> GET /nodes/{nodeId}/category-links; operationId: listCategoriesForNode.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the category. The following optional fields can be requested: * path. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listCategoriesForNode в generated-модели CategoryPaging. EN: Alfresco response for listCategoriesForNode represented as CategoryPaging.
     */

    @GetExchange(url = "/nodes/{nodeId}/category-links")
    CategoryPaging listCategoriesForNode(@PathVariable("nodeId") String nodeId, @RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Создаёт ресурс или связь в Alfresco. Метод напрямую отражает REST-контракт и принимает generated DTO тела запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.4 and newer versions. Assign the node nodeId to a category. You specify the category ID in a JSON body like this: JSON { "categoryId": "01234567-89ab-cdef-0123-456789abcdef" } Note: You can assign the node to more than one category by specifying a list of categories in the JSON body like this: JSON [ { "categoryId": "01234567-89ab-cdef-0123-456789abcdef" }, { "categoryId": "89abcdef-0123-4567-89ab-cdef01234567" } ] If you specify a list as input, then a paginated list rather than an entry is returned in the response body. For example: JSON { "list": { "pagination": { "count": 2, "hasMoreItems": false, "totalItems": 2, "skipCount": 0, "maxItems": 100 }, "entries": [ { "entry": { ... } }, { "entry": { ... } } ] } }</p>
     * <p><strong>REST:</strong> POST /nodes/{nodeId}/category-links; operationId: createCategoryLinkForNode.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the category. The following optional fields can be requested: * path. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param categoryLinkBodyCreate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The new category link. Required.
     * @return RU: ответ Alfresco для createCategoryLinkForNode в generated-модели CategoryEntry. EN: Alfresco response for createCategoryLinkForNode represented as CategoryEntry.
     */

    @PostExchange(url = "/nodes/{nodeId}/category-links")
    CategoryEntry createCategoryLinkForNode(@PathVariable("nodeId") String nodeId, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody CategoryLinkBody categoryLinkBodyCreate);

        /**
     * <p><strong>RU:</strong> Удаляет ресурс или связь через Alfresco REST API; обратимость зависит от конкретной операции и её параметров.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.4 and newer versions. Removes the node nodeId from the category categoryId.</p>
     * <p><strong>REST:</strong> DELETE /nodes/{nodeId}/category-links/{categoryId}; operationId: deleteCategoryLinkFromNode.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param categoryId RU: идентификатор категории. Обязательный параметр. EN: The identifier of a category.. Required.
     */

    @DeleteExchange(url = "/nodes/{nodeId}/category-links/{categoryId}")
    Void deleteCategoryLinkFromNode(@PathVariable("nodeId") String nodeId, @PathVariable("categoryId") String categoryId);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.4 and newer versions. Get a specific category with categoryId.</p>
     * <p><strong>REST:</strong> GET /categories/{categoryId}; operationId: getCategory.</p>
     *
     * @param categoryId RU: идентификатор категории. Обязательный параметр. EN: The identifier of a category.. Required.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the category. The following optional fields can be requested: * count * path. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для getCategory в generated-модели CategoryEntry. EN: Alfresco response for getCategory represented as CategoryEntry.
     */

    @GetExchange(url = "/categories/{categoryId}")
    CategoryEntry getCategory(@PathVariable("categoryId") String categoryId, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Изменяет существующий ресурс Alfresco согласно REST-контракту и возвращает подтверждённое сервером состояние, если endpoint имеет ответ.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.4 and newer versions. Updates the category categoryId. You must have admin rights to update a category.</p>
     * <p><strong>REST:</strong> PUT /categories/{categoryId}; operationId: updateCategory.</p>
     *
     * @param categoryId RU: идентификатор категории. Обязательный параметр. EN: The identifier of a category.. Required.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the category. The following optional fields can be requested: * count * path. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param categoryBodyUpdate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The updated category. Required.
     * @return RU: ответ Alfresco для updateCategory в generated-модели CategoryEntry. EN: Alfresco response for updateCategory represented as CategoryEntry.
     */

    @PutExchange(url = "/categories/{categoryId}")
    CategoryEntry updateCategory(@PathVariable("categoryId") String categoryId, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody CategoryBody categoryBodyUpdate);

        /**
     * <p><strong>RU:</strong> Удаляет ресурс или связь через Alfresco REST API; обратимость зависит от конкретной операции и её параметров.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.4 and newer versions. Deletes the category with categoryId. This will cause everything to be removed from the category. You must have admin rights to delete a category.</p>
     * <p><strong>REST:</strong> DELETE /categories/{categoryId}; operationId: deleteCategory.</p>
     *
     * @param categoryId RU: идентификатор категории. Обязательный параметр. EN: The identifier of a category.. Required.
     */

    @DeleteExchange(url = "/categories/{categoryId}")
    Void deleteCategory(@PathVariable("categoryId") String categoryId);

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.4 and newer versions. Gets a list of subcategories within the category categoryId. The parameter categoryId can be set to the alias -root- to obtain a list of top level categories.</p>
     * <p><strong>REST:</strong> GET /categories/{categoryId}/subcategories; operationId: listSubcategories.</p>
     *
     * @param categoryId RU: идентификатор категории. Обязательный параметр. EN: The identifier of a category.. Required.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the category. The following optional fields can be requested: * count * path. Optional when the method annotation allows null.
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listSubcategories в generated-модели CategoryPaging. EN: Alfresco response for listSubcategories represented as CategoryPaging.
     */

    @GetExchange(url = "/categories/{categoryId}/subcategories")
    CategoryPaging listSubcategories(@PathVariable("categoryId") String categoryId, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Создаёт ресурс или связь в Alfresco. Метод напрямую отражает REST-контракт и принимает generated DTO тела запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 7.4 and newer versions. Creates a new category within the category categoryId. The parameter categoryId can be set to the alias -root- to create a new top level category. You must have admin rights to create a category. It is possible to create more than one subcategory by posting a list of categories: JSON [ { "name": "test category 1" }, { "name": "test category 2" } ] If you specify a list as input, then a paginated list rather than an entry is returned in the response body. For example: JSON { "list": { "pagination": { "count": 2, "hasMoreItems": false, "totalItems": 2, "skipCount": 0, "maxItems": 100 }, "entries": [ { "entry": { ... } }, { "entry": { ... } } ] } }</p>
     * <p><strong>REST:</strong> POST /categories/{categoryId}/subcategories; operationId: createCategory.</p>
     *
     * @param categoryId RU: идентификатор категории. Обязательный параметр. EN: The identifier of a category.. Required.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the category. The following optional fields can be requested: * count * path. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param categoryBodyCreate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The category details. Required.
     * @return RU: ответ Alfresco для createCategory в generated-модели CategoryEntry. EN: Alfresco response for createCategory represented as CategoryEntry.
     */

    @PostExchange(url = "/categories/{categoryId}/subcategories")
    CategoryEntry createCategory(@PathVariable("categoryId") String categoryId, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody CategoryBody categoryBodyCreate);
}
