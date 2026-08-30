package pro.abgrid.alfresco.api;

import pro.abgrid.alfresco.dto.core.CommentBody;
import pro.abgrid.alfresco.dto.core.CommentEntry;
import pro.abgrid.alfresco.dto.core.CommentPaging;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

/**
 * <p><strong>RU:</strong> Низкоуровневый HTTP-интерфейс CommentsApi отображает операции Alfresco REST API на Spring HTTP Service. В обычном прикладном коде предпочтительнее high-level сервисы; этот интерфейс нужен для параметров и endpoint, не покрытых удобной обёрткой.</p>
 * <p><strong>EN:</strong> Low-level HTTP interface CommentsApi maps Alfresco REST operations to Spring HTTP Service methods. Application code will normally prefer high-level services; use this interface for endpoint-level control or operations without a high-level wrapper.</p>
 * <p><strong>RU:</strong> HTTP-ошибки преобразуются общей конфигурацией клиента в AlfrescoApiException.</p>
 * <p><strong>EN:</strong> HTTP errors are converted by the shared client configuration into AlfrescoApiException.</p>
 */
public interface CommentsApi {

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Gets a list of comments for the node nodeId, sorted chronologically with the newest comment first.</p>
     * <p><strong>REST:</strong> GET /nodes/{nodeId}/comments; operationId: listComments.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listComments в generated-модели CommentPaging. EN: Alfresco response for listComments represented as CommentPaging.
     */

    @GetExchange(url = "/nodes/{nodeId}/comments")
    CommentPaging listComments(@PathVariable("nodeId") String nodeId, @RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Создаёт ресурс или связь в Alfresco. Метод напрямую отражает REST-контракт и принимает generated DTO тела запроса.</p>
     * <p><strong>EN:</strong> Creates a comment on node nodeId. You specify the comment in a JSON body like this: JSON { "content": "This is a comment" } Note: You can create more than one comment by specifying a list of comments in the JSON body like this: JSON [ { "content": "This is a comment" }, { "content": "This is another comment" } ] If you specify a list as input, then a paginated list rather than an entry is returned in the response body. For example: JSON { "list": { "pagination": { "count": 2, "hasMoreItems": false, "totalItems": 2, "skipCount": 0, "maxItems": 100 }, "entries": [ { "entry": { ... } }, { "entry": { ... } } ] } }</p>
     * <p><strong>REST:</strong> POST /nodes/{nodeId}/comments; operationId: createComment.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param commentBodyCreate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The comment text. Note that you can also provide a list of comments.. Required.
     * @return RU: ответ Alfresco для createComment в generated-модели CommentEntry. EN: Alfresco response for createComment represented as CommentEntry.
     */

    @PostExchange(url = "/nodes/{nodeId}/comments")
    CommentEntry createComment(@PathVariable("nodeId") String nodeId, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody CommentBody commentBodyCreate);

        /**
     * <p><strong>RU:</strong> Изменяет существующий ресурс Alfresco согласно REST-контракту и возвращает подтверждённое сервером состояние, если endpoint имеет ответ.</p>
     * <p><strong>EN:</strong> Updates an existing comment commentId on node nodeId.</p>
     * <p><strong>REST:</strong> PUT /nodes/{nodeId}/comments/{commentId}; operationId: updateComment.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param commentId RU: идентификатор комментария. Обязательный параметр. EN: The identifier of a comment.. Required.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param commentBodyUpdate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The JSON representing the comment to be updated.. Required.
     * @return RU: ответ Alfresco для updateComment в generated-модели CommentEntry. EN: Alfresco response for updateComment represented as CommentEntry.
     */

    @PutExchange(url = "/nodes/{nodeId}/comments/{commentId}")
    CommentEntry updateComment(@PathVariable("nodeId") String nodeId, @PathVariable("commentId") String commentId, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody CommentBody commentBodyUpdate);

        /**
     * <p><strong>RU:</strong> Удаляет ресурс или связь через Alfresco REST API; обратимость зависит от конкретной операции и её параметров.</p>
     * <p><strong>EN:</strong> Deletes the comment commentId from node nodeId.</p>
     * <p><strong>REST:</strong> DELETE /nodes/{nodeId}/comments/{commentId}; operationId: deleteComment.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco; для ряда endpoint допустимы специальные aliases, указанные в REST-спецификации. Обязательный параметр. EN: The identifier of a node.. Required.
     * @param commentId RU: идентификатор комментария. Обязательный параметр. EN: The identifier of a comment.. Required.
     */

    @DeleteExchange(url = "/nodes/{nodeId}/comments/{commentId}")
    Void deleteComment(@PathVariable("nodeId") String nodeId, @PathVariable("commentId") String commentId);
}
