package pro.abgrid.alfresco.service.activity;

import pro.abgrid.alfresco.api.ActivitiesApi;
import pro.abgrid.alfresco.dto.core.Activity;
import pro.abgrid.alfresco.dto.core.ActivityPaging;
import pro.abgrid.alfresco.model.PageSlice;
import pro.abgrid.alfresco.support.PagingExtractor;
import org.springframework.stereotype.Service;

/**
 * <p><strong>RU:</strong> Высокоуровневый Spring-сервис для сценариев «activity» в Alfresco. Он служит прикладной границей над generated REST API: принимает более удобные параметры, скрывает технические детали HTTP/DTO там, где для них есть high-level модель, и оставляет доступ к серверному результату, когда это необходимо. Сервис предназначен для внедрения как обычный Spring bean в бизнес-сервисы приложения.</p>
 * <p><strong>EN:</strong> High-level Spring service for Alfresco activity scenarios. It acts as an application boundary over the generated REST API: it accepts application-friendly parameters, hides HTTP/DTO plumbing where a high-level model exists, and still exposes server results when required. The service is intended to be injected as a regular Spring bean into application business services.</p>
 */
@Service
public class AlfrescoActivityService {
    private final ActivitiesApi api;
    private final PagingExtractor paging;

        /**
     * <p><strong>RU:</strong> создаёт сервис и получает его зависимости через Spring DI; обычно этот конструктор не вызывается прикладным кодом напрямую.</p>
     * <p><strong>EN:</strong> creates the service with dependencies supplied by Spring DI; application code normally does not call this constructor directly.</p>
     *
     * @param api RU: зависимость `api`, используемая сервисом для выполнения операций Alfresco. EN: `api` dependency used by the service to perform Alfresco operations.
     * @param paging RU: зависимость `paging`, используемая сервисом для выполнения операций Alfresco. EN: `paging` dependency used by the service to perform Alfresco operations.
     */

    public AlfrescoActivityService(ActivitiesApi api, PagingExtractor paging) {
        this.api = api;
        this.paging = paging;
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `person` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `person` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param personId RU: идентификатор пользователя; для текущего пользователя обычно используется `-me-`. EN: person identifier; `-me-` is normally used for the current user.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public ActivityPaging person(String personId, int skip, int size) {
        return person(personId, skip, size, null, null);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `person` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `person` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param personId RU: идентификатор пользователя; для текущего пользователя обычно используется `-me-`. EN: person identifier; `-me-` is normally used for the current user.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @param who RU: значение параметра `who` для выполняемой операции. EN: value of `who` used by the operation.
     * @param siteId RU: короткий идентификатор сайта Alfresco. EN: Alfresco site short identifier.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public ActivityPaging person(String personId, int skip, int size, String who, String siteId) {
        return api.listActivitiesForPerson(personId, skip, size, who, siteId, null);
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

    public PageSlice<Activity> page(String personId, int skip, int size) {
        return paging.extract(person(personId, skip, size).getList(), Activity.class);
    }

        /**
     * <p><strong>RU:</strong> возвращает типизированную страницу результатов и скрывает от прикладного кода generated paging-wrapper Alfresco.</p>
     * <p><strong>EN:</strong> returns a typed result page and hides the generated Alfresco paging wrapper from application code.</p>
     *
     * @param personId RU: идентификатор пользователя; для текущего пользователя обычно используется `-me-`. EN: person identifier; `-me-` is normally used for the current user.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @param who RU: значение параметра `who` для выполняемой операции. EN: value of `who` used by the operation.
     * @param siteId RU: короткий идентификатор сайта Alfresco. EN: Alfresco site short identifier.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public PageSlice<Activity> page(String personId, int skip, int size, String who, String siteId) {
        return paging.extract(person(personId, skip, size, who, siteId).getList(), Activity.class);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `mine` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `mine` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public PageSlice<Activity> mine(int skip, int size) {
        return page("-me-", skip, size);
    }
}
