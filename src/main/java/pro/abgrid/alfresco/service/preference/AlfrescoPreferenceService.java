package pro.abgrid.alfresco.service.preference;

import pro.abgrid.alfresco.api.PreferencesApi;
import pro.abgrid.alfresco.dto.core.Preference;
import pro.abgrid.alfresco.dto.core.PreferenceBodyUpdate;
import pro.abgrid.alfresco.dto.core.PreferenceEntry;
import pro.abgrid.alfresco.dto.core.PreferencePaging;
import pro.abgrid.alfresco.model.PageSlice;
import pro.abgrid.alfresco.support.PagingExtractor;
import org.springframework.stereotype.Service;

/**
 * <p><strong>RU:</strong> Высокоуровневый Spring-сервис для сценариев «preference» в Alfresco. Он служит прикладной границей над generated REST API: принимает более удобные параметры, скрывает технические детали HTTP/DTO там, где для них есть high-level модель, и оставляет доступ к серверному результату, когда это необходимо. Сервис предназначен для внедрения как обычный Spring bean в бизнес-сервисы приложения.</p>
 * <p><strong>EN:</strong> High-level Spring service for Alfresco preference scenarios. It acts as an application boundary over the generated REST API: it accepts application-friendly parameters, hides HTTP/DTO plumbing where a high-level model exists, and still exposes server results when required. The service is intended to be injected as a regular Spring bean into application business services.</p>
 */
@Service
public class AlfrescoPreferenceService {
    private final PreferencesApi api;
    private final PagingExtractor paging;

        /**
     * <p><strong>RU:</strong> создаёт сервис и получает его зависимости через Spring DI; обычно этот конструктор не вызывается прикладным кодом напрямую.</p>
     * <p><strong>EN:</strong> creates the service with dependencies supplied by Spring DI; application code normally does not call this constructor directly.</p>
     *
     * @param api RU: зависимость `api`, используемая сервисом для выполнения операций Alfresco. EN: `api` dependency used by the service to perform Alfresco operations.
     * @param paging RU: зависимость `paging`, используемая сервисом для выполнения операций Alfresco. EN: `paging` dependency used by the service to perform Alfresco operations.
     */

    public AlfrescoPreferenceService(PreferencesApi api, PagingExtractor paging) {
        this.api = api;
        this.paging = paging;
    }

        /**
     * <p><strong>RU:</strong> получает список объектов из Alfresco с учётом поддерживаемых сервером ограничений и пагинации.</p>
     * <p><strong>EN:</strong> retrieves a list of Alfresco objects using the server-supported filtering and paging options.</p>
     *
     * @param personId RU: идентификатор пользователя; для текущего пользователя обычно используется `-me-`. EN: person identifier; `-me-` is normally used for the current user.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public PreferencePaging list(String personId, int skip, int size) {
        return api.listPreferences(personId, skip, size, null);
    }

        /**
     * <p><strong>RU:</strong> возвращает типизированную страницу результатов и скрывает от прикладного кода generated paging-wrapper Alfresco.</p>
     * <p><strong>EN:</strong> returns a typed result page and hides the generated Alfresco paging wrapper from application code.</p>
     *
     * @param personId RU: идентификатор пользователя; для текущего пользователя обычно используется `-me-`. EN: person identifier; `-me-` is normally used for the current user.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public PageSlice<Preference> page(String personId, int skip, int size) {
        return paging.extract(list(personId, skip, size).getList(), Preference.class);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `mine` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `mine` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public PageSlice<Preference> mine(int skip, int size) {
        return page("-me-", skip, size);
    }

        /**
     * <p><strong>RU:</strong> получает актуальное представление объекта из Alfresco; подходит для чтения его серверного состояния и метаданных.</p>
     * <p><strong>EN:</strong> retrieves the current Alfresco representation of the object for reading server-side state and metadata.</p>
     *
     * @param personId RU: идентификатор пользователя; для текущего пользователя обычно используется `-me-`. EN: person identifier; `-me-` is normally used for the current user.
     * @param name RU: имя создаваемого или изменяемого объекта. EN: name of the object being created or changed.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public PreferenceEntry get(String personId, String name) {
        return api.getPreference(personId, name, null);
    }

        /**
     * <p><strong>RU:</strong> получает актуальное представление объекта из Alfresco; подходит для чтения его серверного состояния и метаданных.</p>
     * <p><strong>EN:</strong> retrieves the current Alfresco representation of the object for reading server-side state and metadata.</p>
     *
     * @param name RU: имя создаваемого или изменяемого объекта. EN: name of the object being created or changed.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public PreferenceEntry getMine(String name) {
        return get("-me-", name);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `put` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `put` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param personId RU: идентификатор пользователя; для текущего пользователя обычно используется `-me-`. EN: person identifier; `-me-` is normally used for the current user.
     * @param name RU: имя создаваемого или изменяемого объекта. EN: name of the object being created or changed.
     * @param value RU: значение параметра `value` для выполняемой операции. EN: value of `value` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public PreferenceEntry put(String personId, String name, String value) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("preference name must not be blank");
        }
        PreferenceBodyUpdate body = new PreferenceBodyUpdate();
        body.setId(name);
        body.setValue(value);
        return api.updatePreference(personId, name, null, body);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `putMine` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `putMine` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param name RU: имя создаваемого или изменяемого объекта. EN: name of the object being created or changed.
     * @param value RU: значение параметра `value` для выполняемой операции. EN: value of `value` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public PreferenceEntry putMine(String name, String value) {
        return put("-me-", name, value);
    }
}
