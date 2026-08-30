package pro.abgrid.alfresco.api;

import pro.abgrid.alfresco.dto.core.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

/**
 * <p><strong>RU:</strong> Низкоуровневый HTTP-интерфейс CascadingDictionariesApi отображает операции Alfresco REST API на Spring HTTP Service. В обычном прикладном коде предпочтительнее high-level сервисы; этот интерфейс нужен для параметров и endpoint, не покрытых удобной обёрткой.</p>
 * <p><strong>EN:</strong> Low-level HTTP interface CascadingDictionariesApi maps Alfresco REST operations to Spring HTTP Service methods. Application code will normally prefer high-level services; use this interface for endpoint-level control or operations without a high-level wrapper.</p>
 * <p><strong>RU:</strong> HTTP-ошибки преобразуются общей конфигурацией клиента в AlfrescoApiException.</p>
 * <p><strong>EN:</strong> HTTP errors are converted by the shared client configuration into AlfrescoApiException.</p>
 */
public interface CascadingDictionariesApi {

        /**
     * <p><strong>RU:</strong> Возвращает серверную страницу ресурсов Alfresco; фильтрация, сортировка и пагинация выполняются на стороне ACS.</p>
     * <p><strong>EN:</strong> Note: This endpoint is available in Alfresco Enterprise 26.2 and newer versions. Gets a list of registered cascading dictionaries available in the system. The latest version of each cascading dictionary is returned.</p>
     * <p><strong>REST:</strong> GET /cascading-dictionaries; operationId: listCascadingDict.</p>
     *
     * @param skipCount RU: число элементов, пропускаемых перед текущей страницей. Необязательный параметр, если аннотация допускает null. EN: The number of entities that exist in the collection before those included in this list. If not supplied then the default value is 0.. Optional when the method annotation allows null.
     * @param maxItems RU: максимальное число элементов в странице. Необязательный параметр, если аннотация допускает null. EN: The maximum number of items to return in the list. If not supplied then the default value is 100.. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для listCascadingDict в generated-модели CascadingDictList. EN: Alfresco response for listCascadingDict represented as CascadingDictList.
     */

    @GetExchange(url = "/cascading-dictionaries")
    CascadingDictList listCascadingDict(@RequestParam(value = "skipCount", required = false) Integer skipCount, @RequestParam(value = "maxItems", required = false) Integer maxItems);

        /**
     * <p><strong>RU:</strong> Создаёт ресурс или связь в Alfresco. Метод напрямую отражает REST-контракт и принимает generated DTO тела запроса.</p>
     * <p><strong>EN:</strong> Note: This endpoint is available in Alfresco Enterprise 26.2 and newer versions. Creates a new cascading dictionary definition for the specified aspect. The aspect representing the cascading dictionary must be correctly defined and registered in the system before creating a cascading dictionary definition for it. Only one cascading dictionary definition can be created for an aspect. You must specify: - the unique name of the cascading dictionary - the aspect that the cascading dictionary definition is based on - the prefixed name of the key property of the aspect that represents the dictionary key - the prefixed name of the version property of the aspect that represents the dictionary version You must have admin rights to create a cascading dictionary.</p>
     * <p><strong>REST:</strong> POST /cascading-dictionaries; operationId: createCascadingDict.</p>
     *
     * @param cascadingDictBodyCreate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The cascading dictionary information to create.. Required.
     * @return RU: ответ Alfresco для createCascadingDict в generated-модели CascadingDictCreateEntry. EN: Alfresco response for createCascadingDict represented as CascadingDictCreateEntry.
     */

    @PostExchange(url = "/cascading-dictionaries")
    CascadingDictCreateEntry createCascadingDict(@RequestBody CascadingDictBodyCreate cascadingDictBodyCreate);

        /**
     * <p><strong>RU:</strong> Создаёт ресурс или связь в Alfresco. Метод напрямую отражает REST-контракт и принимает generated DTO тела запроса.</p>
     * <p><strong>EN:</strong> Note: This endpoint is available in Alfresco Enterprise 26.2 and newer versions. Creates a new content version of the cascading dictionary registered by aspectId. The cascading dictionary is versionable. The majorVersion parameter can be used to control versioning behaviour. Without this parameter, a new minor version is created by default. You must have admin rights to update the cascading dictionary content.</p>
     * <p><strong>REST:</strong> POST /cascading-dictionaries/{aspectId}/content; operationId: createCascadingDictContent.</p>
     *
     * @param aspectId RU: значение параметра aspectId для данной REST-операции. Обязательный параметр. EN: The prefixed name of an aspect (prefix:name) that represents the cascading dictionary, e.g. 'cdict:account'.. Required.
     * @param majorVersion RU: если true, создаётся major-версия; иначе minor, когда версия создаётся. Необязательный параметр, если аннотация допускает null. EN: If true, create a major version.. Optional when the method annotation allows null.
     * @param cascadingDictContentBody RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The content of the cascading dictionary.. Required.
     * @return RU: ответ Alfresco для createCascadingDictContent в generated-модели CascadingDictEntry. EN: Alfresco response for createCascadingDictContent represented as CascadingDictEntry.
     */

    @PostExchange(url = "/cascading-dictionaries/{aspectId}/content")
    CascadingDictEntry createCascadingDictContent(@PathVariable("aspectId") String aspectId, @RequestParam(value = "majorVersion", required = false) Boolean majorVersion, @RequestBody CascadingDictContentBody cascadingDictContentBody);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Note: This endpoint is available in Alfresco Enterprise 26.2 and newer versions. Gets the cascading dictionary registered in the system for aspectId. The latest version of the cascading dictionary is returned.</p>
     * <p><strong>REST:</strong> GET /cascading-dictionaries/{aspectId}; operationId: getCascadingDict.</p>
     *
     * @param aspectId RU: значение параметра aspectId для данной REST-операции. Обязательный параметр. EN: The prefixed name of an aspect (prefix:name) that represents the cascading dictionary, e.g. 'cdict:account'.. Required.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the cascading dictionary. The following optional fields can be requested: * data. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для getCascadingDict в generated-модели CascadingDictEntry. EN: Alfresco response for getCascadingDict represented as CascadingDictEntry.
     */

    @GetExchange(url = "/cascading-dictionaries/{aspectId}")
    CascadingDictEntry getCascadingDict(@PathVariable("aspectId") String aspectId, @RequestParam(value = "include", required = false) List<String> include);

        /**
     * <p><strong>RU:</strong> Изменяет существующий ресурс Alfresco согласно REST-контракту и возвращает подтверждённое сервером состояние, если endpoint имеет ответ.</p>
     * <p><strong>EN:</strong> Note: This endpoint is available in Alfresco Enterprise 26.2 and newer versions. Updates the metadata of an existing cascading dictionary definition for the specified aspect. You must have admin rights to update a cascading dictionary.</p>
     * <p><strong>REST:</strong> PUT /cascading-dictionaries/{aspectId}; operationId: updateCascadingDict.</p>
     *
     * @param aspectId RU: значение параметра aspectId для данной REST-операции. Обязательный параметр. EN: The prefixed name of an aspect (prefix:name) that represents the cascading dictionary, e.g. 'cdict:account'.. Required.
     * @param cascadingDictBodyUpdate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The cascading dictionary information to update.. Required.
     * @return RU: ответ Alfresco для updateCascadingDict в generated-модели CascadingDictUpdateEntry. EN: Alfresco response for updateCascadingDict represented as CascadingDictUpdateEntry.
     */

    @PutExchange(url = "/cascading-dictionaries/{aspectId}")
    CascadingDictUpdateEntry updateCascadingDict(@PathVariable("aspectId") String aspectId, @RequestBody CascadingDictBodyUpdate cascadingDictBodyUpdate);

        /**
     * <p><strong>RU:</strong> Удаляет ресурс или связь через Alfresco REST API; обратимость зависит от конкретной операции и её параметров.</p>
     * <p><strong>EN:</strong> Note: This endpoint is available in Alfresco Enterprise 26.2 and newer versions. Deletes the cascading dictionary metadata and content for the specified aspect. All versions of the content will be deleted. The aspect properties used to classify nodes will not be deleted. You must have admin rights to delete a cascading dictionary.</p>
     * <p><strong>REST:</strong> DELETE /cascading-dictionaries/{aspectId}; operationId: deleteCascadingDict.</p>
     *
     * @param aspectId RU: значение параметра aspectId для данной REST-операции. Обязательный параметр. EN: The prefixed name of an aspect (prefix:name) that represents the cascading dictionary, e.g. 'cdict:account'.. Required.
     */

    @DeleteExchange(url = "/cascading-dictionaries/{aspectId}")
    Void deleteCascadingDict(@PathVariable("aspectId") String aspectId);

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Note: This endpoint is available in Alfresco Enterprise 26.2 and newer versions. Gets a specific version of the cascading dictionary registered in the system for aspectId.</p>
     * <p><strong>REST:</strong> GET /cascading-dictionaries/{aspectId}/versions/{versionId}; operationId: getCascadingDictVersion.</p>
     *
     * @param aspectId RU: значение параметра aspectId для данной REST-операции. Обязательный параметр. EN: The prefixed name of an aspect (prefix:name) that represents the cascading dictionary, e.g. 'cdict:account'.. Required.
     * @param versionId RU: идентификатор версии. Обязательный параметр. EN: The identifier of a version, ie. version label, within the version history of a node.. Required.
     * @param include RU: дополнительные секции данных, которые сервер должен включить в ответ. Необязательный параметр, если аннотация допускает null. EN: Returns additional information about the cascading dictionary. The following optional fields can be requested: * data. Optional when the method annotation allows null.
     * @return RU: ответ Alfresco для getCascadingDictVersion в generated-модели CascadingDictEntry. EN: Alfresco response for getCascadingDictVersion represented as CascadingDictEntry.
     */

    @GetExchange(url = "/cascading-dictionaries/{aspectId}/versions/{versionId}")
    CascadingDictEntry getCascadingDictVersion(@PathVariable("aspectId") String aspectId, @PathVariable("versionId") String versionId, @RequestParam(value = "include", required = false) List<String> include);
}
