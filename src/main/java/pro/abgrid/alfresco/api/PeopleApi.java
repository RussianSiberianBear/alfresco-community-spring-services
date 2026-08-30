package pro.abgrid.alfresco.api;

import pro.abgrid.alfresco.dto.core.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * <p><strong>RU:</strong> Низкоуровневый HTTP-интерфейс PeopleApi отображает операции Alfresco REST API на Spring HTTP Service. В обычном прикладном коде предпочтительнее high-level сервисы; этот интерфейс нужен для параметров и endpoint, не покрытых удобной обёрткой.</p>
 * <p><strong>EN:</strong> Low-level HTTP interface PeopleApi maps Alfresco REST operations to Spring HTTP Service methods. Application code will normally prefer high-level services; use this interface for endpoint-level control or operations without a high-level wrapper.</p>
 * <p><strong>RU:</strong> HTTP-ошибки преобразуются общей конфигурацией клиента в AlfrescoApiException.</p>
 * <p><strong>EN:</strong> HTTP errors are converted by the shared client configuration into AlfrescoApiException.</p>
 */
public interface PeopleApi {

        /**
     * <p><strong>RU:</strong> Создаёт ресурс или связь в Alfresco. Метод напрямую отражает REST-контракт и принимает generated DTO тела запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Create a person. If applicable, the given person's login access can also be optionally disabled. You must have admin rights to create a person. You can set custom properties when you create a person: JSON { "id": "abeecher", "firstName": "Alice", "lastName": "Beecher", "displayName": "Alice Beecher", "email": "abeecher@example.com", "password": "secret", "properties": { "my:property": "The value" } } Note: setting properties of type d:content and d:category are not supported.</p>
     * <p><strong>REST:</strong> POST /people; operationId: createPerson.</p>
     *
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param personBodyCreate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The person details.. Required.
     * @return RU: ответ Alfresco для createPerson в generated-модели PersonEntry. EN: Alfresco response for createPerson represented as PersonEntry.
     */

    @PostExchange(url = "/people")
    PersonEntry createPerson(@RequestParam(value = "fields", required = false) List<String> fields, @RequestBody PersonBodyCreate personBodyCreate);

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. List people. You can use the include parameter to return any additional information. The default sort order for the returned list is for people to be sorted by ascending id. You can override the default by using the orderBy parameter. You can use any of the following fields to order the results: * id * firstName * lastName</p>
     * <p><strong>REST:</strong> GET /people; operationId: listPeople.</p>
     *
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @param orderBy RU: серверные выражения сортировки. Необязательный параметр, если аннотация допускает null. EN: A string to control the order of the entities returned in a list. You can use the orderBy parameter to sort the list by one or more fields. Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order. To sort the entities in a specific order, you can use the ASC and DESC keywords for any field.. Optional when the method annotation allows null.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the person. The following optional fields can be requested: * properties * aspectNames * capabilities. Optional when the method annotation allows null.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listPeople в generated-модели PersonPaging. EN: Alfresco response for listPeople represented as PersonPaging.
     */

    @GetExchange(url = "/people")
    PersonPaging listPeople(@RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems, @RequestParam(value = "orderBy", required = false) List<String> orderBy, @RequestParam(value = "include", required = false) List<String> include, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Gets information for the person personId. You can use the -me- string in place of &lt;personId&gt; to specify the currently authenticated user.</p>
     * <p><strong>REST:</strong> GET /people/{personId}; operationId: getPerson.</p>
     *
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для getPerson в generated-модели PersonEntry. EN: Alfresco response for getPerson represented as PersonEntry.
     */

    @GetExchange(url = "/people/{personId}")
    PersonEntry getPerson(@PathVariable("personId") String personId, @RequestParam(value = "fields", required = false) List<String> fields);

        /**
     * <p><strong>RU:</strong> Изменяет существующий ресурс Alfresco согласно REST-контракту и возвращает подтверждённое сервером состояние, если endpoint имеет ответ.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Update the given person's details. You can use the -me- string in place of &lt;personId&gt; to specify the currently authenticated user. If applicable, the given person's login access can also be optionally disabled or re-enabled. You must have admin rights to update a person — unless updating your own details. If you are changing your password, as a non-admin user, then the existing password must also be supplied (using the oldPassword field in addition to the new password value). Admin users cannot be disabled by setting enabled to false. Non-admin users may not disable themselves. You can set custom properties when you update a person: JSON { "firstName": "Alice", "properties": { "my:property": "The value" } } Note: setting properties of type d:content and d:category are not supported.</p>
     * <p><strong>REST:</strong> PUT /people/{personId}; operationId: updatePerson.</p>
     *
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     * @param fields RU: поля JSON, которые требуется вернуть. Необязательный параметр, если аннотация допускает null. EN: A list of field names. You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth. The list applies to a returned individual entity or entries within a collection. If the API method also supports the include parameter, then the fields specified in the include parameter are returned in addition to those specified in the fields parameter.. Optional when the method annotation allows null.
     * @param personBodyUpdate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The person details.. Required.
     * @return RU: ответ Alfresco для updatePerson в generated-модели PersonEntry. EN: Alfresco response for updatePerson represented as PersonEntry.
     */

    @PutExchange(url = "/people/{personId}")
    PersonEntry updatePerson(@PathVariable("personId") String personId, @RequestParam(value = "fields", required = false) List<String> fields, @RequestBody PersonBodyUpdate personBodyUpdate);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию POST /people/{personId}/request-password-reset Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is deprecated as of Alfresco 7.1, and will be removed in the future. Initiates the reset password workflow to send an email with reset password instruction to the user's registered email. The client is mandatory in the request body. For example: JSON { "client": "myClient" } Note: The client must be registered before this API can send an email. See [server documentation]. However, out-of-the-box share is registered as a default client, so you could pass share as the client name: JSON { "client": "share" } Note: No authentication is required to call this endpoint.</p>
     * <p><strong>REST:</strong> POST /people/{personId}/request-password-reset; operationId: requestPasswordReset.</p>
     *
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     * @param clientBody RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The client name to send email with app-specific url.. Required.
     */

    @PostExchange(url = "/people/{personId}/request-password-reset")
    Void requestPasswordReset(@PathVariable("personId") String personId, @RequestBody ClientBody clientBody);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию POST /people/{personId}/reset-password Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is deprecated as of Alfresco 7.1, and will be removed in the future. Resets user's password The password, id and key properties are mandatory in the request body. For example: JSON { "password":"newPassword", "id":"activiti$10", "key":"4dad6d00-0daf-413a-b200-f64af4e12345" } Note: No authentication is required to call this endpoint.</p>
     * <p><strong>REST:</strong> POST /people/{personId}/reset-password; operationId: resetPassword.</p>
     *
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     * @param passwordResetBody RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The reset password details. Required.
     */

    @PostExchange(url = "/people/{personId}/reset-password")
    Void resetPassword(@PathVariable("personId") String personId, @RequestBody PasswordResetBody passwordResetBody);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2.2 and newer versions. Gets the avatar image related to the person personId. If the person has no related avatar then the placeholder query parameter can be optionally used to request a placeholder image to be returned. You can use the -me- string in place of &lt;personId&gt; to specify the currently authenticated user.</p>
     * <p><strong>REST:</strong> GET /people/{personId}/avatar; operationId: getAvatarImage.</p>
     *
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     * @param attachment RU: управляет выдачей содержимого как attachment. Необязательный параметр, если аннотация допускает null. EN: true enables a web browser to download the file as an attachment. false means a web browser may preview the file in a new tab or window. You can only set this parameter to false if the content type of the file is in the supported list; for example, certain image files and PDF files. If the content type is not supported for preview, then a value of false is ignored, and the attachment will be returned in the response.. Optional when the method annotation allows null.
     * @param ifModifiedSince RU: HTTP If-Modified-Since для условного получения содержимого. Необязательный параметр, если аннотация допускает null. EN: Value of parameter ifModifiedSince for this REST operation. Optional when the method annotation allows null.
     * @param placeholder RU: значение параметра placeholder для данной REST-операции. Необязательный параметр, если аннотация допускает null. EN: If true and there is no avatar for this personId then the placeholder image is returned, rather than a 404 response.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для getAvatarImage в generated-модели byte[]. EN: Alfresco response for getAvatarImage represented as byte[].
     */

    @GetExchange(url = "/people/{personId}/avatar")
    byte[] getAvatarImage(@PathVariable("personId") String personId, @RequestParam(value = "attachment", required = false) Boolean attachment, @RequestHeader(value = "If-Modified-Since", required = false) OffsetDateTime ifModifiedSince, @RequestParam(value = "placeholder", required = false) Boolean placeholder);

        /**
     * <p><strong>RU:</strong> Изменяет существующий ресурс Alfresco согласно REST-контракту и возвращает подтверждённое сервером состояние, если endpoint имеет ответ.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2.2 and newer versions. Updates the avatar image related to the person personId. The request body should be the binary stream for the avatar image. The content type of the file should be an image file. This will be used to generate an "avatar" thumbnail rendition. You must be the person or have admin rights to update a person's avatar. You can use the -me- string in place of &lt;personId&gt; to specify the currently authenticated user.</p>
     * <p><strong>REST:</strong> PUT /people/{personId}/avatar; operationId: updateAvatarImage.</p>
     *
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     * @param contentBodyUpdate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The binary content. Required.
     */

    @PutExchange(url = "/people/{personId}/avatar", contentType = "application/octet-stream")
    Void updateAvatarImage(@PathVariable("personId") String personId, @RequestBody byte[] contentBodyUpdate);

        /**
     * <p><strong>RU:</strong> Удаляет ресурс или связь через Alfresco REST API; обратимость зависит от конкретной операции и её параметров.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2.2 and newer versions. Deletes the avatar image related to person personId. You must be the person or have admin rights to update a person's avatar. You can use the -me- string in place of &lt;personId&gt; to specify the currently authenticated user.</p>
     * <p><strong>REST:</strong> DELETE /people/{personId}/avatar; operationId: deleteAvatarImage.</p>
     *
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     */

    @DeleteExchange(url = "/people/{personId}/avatar")
    Void deleteAvatarImage(@PathVariable("personId") String personId);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию POST /people/{personId}/deauthorize Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco Enterprise 25.x and newer versions. Deauthorizes the user related to the person's personId. After this action the user can't be reauthorized without contact with the Alfresco Support. See: [POST /people/{personId}/reauthorization-code](#people/reauthorizationCode) You must have admin rights to deauthorize the user.</p>
     * <p><strong>REST:</strong> POST /people/{personId}/deauthorize; operationId: deauthorizeUser.</p>
     *
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     */

    @PostExchange(url = "/people/{personId}/deauthorize")
    Void deauthorizeUser(@PathVariable("personId") String personId);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию POST /people/{personId}/reauthorization-code Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco Enterprise 25.x and newer versions. Generates the authorization code that can be sent to the Alfresco Support to obtain the encrypted authorization key. The encrypted authorization key can be used to reauthorize the user by invoking [POST /people/{personId}/reauthorize](#people/reauthorizeUser) endpoint. You must have admin rights to use this endpoint.</p>
     * <p><strong>REST:</strong> POST /people/{personId}/reauthorization-code; operationId: reauthorizationCode.</p>
     *
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     * @return RU: ответ Alfresco для reauthorizationCode в generated-модели AuthCodeEntry. EN: Alfresco response for reauthorizationCode represented as AuthCodeEntry.
     */

    @PostExchange(url = "/people/{personId}/reauthorization-code")
    AuthCodeEntry reauthorizationCode(@PathVariable("personId") String personId);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию POST /people/{personId}/reauthorize Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco Enterprise 25.x and newer versions. Reauthorizes the user related to the person's personId. To obtain the encrypted authorization key, the authorization code must be generated and sent to the Alfresco Support. See: [POST /people/{personId}/reauthorization-code](#people/reauthorizationCode) You must have admin rights to use this endpoint.</p>
     * <p><strong>REST:</strong> POST /people/{personId}/reauthorize; operationId: reauthorizeUser.</p>
     *
     * @param personId RU: идентификатор пользователя; специальное значение -me- означает текущего аутентифицированного пользователя. Обязательный параметр. EN: The identifier of a person.. Required.
     * @param authorizationKey RU: значение параметра authorizationKey для данной REST-операции. Обязательный параметр. EN: The encrypted authorization key received from the Alfresco Support. Required.
     */

    @PostExchange(url = "/people/{personId}/reauthorize")
    Void reauthorizeUser(@PathVariable("personId") String personId, @RequestBody AuthKey authorizationKey);
}
