package pro.abgrid.alfresco.service.audit;

import pro.abgrid.alfresco.api.AuditApi;
import pro.abgrid.alfresco.dto.core.*;
import pro.abgrid.alfresco.model.PageSlice;
import pro.abgrid.alfresco.support.PagingExtractor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p><strong>RU:</strong> Высокоуровневый Spring-сервис для сценариев «audit» в Alfresco. Он служит прикладной границей над generated REST API: принимает более удобные параметры, скрывает технические детали HTTP/DTO там, где для них есть high-level модель, и оставляет доступ к серверному результату, когда это необходимо. Сервис предназначен для внедрения как обычный Spring bean в бизнес-сервисы приложения.</p>
 * <p><strong>EN:</strong> High-level Spring service for Alfresco audit scenarios. It acts as an application boundary over the generated REST API: it accepts application-friendly parameters, hides HTTP/DTO plumbing where a high-level model exists, and still exposes server results when required. The service is intended to be injected as a regular Spring bean into application business services.</p>
 */
@Service
public class AlfrescoAuditService {
    private final AuditApi api;
    private final PagingExtractor paging;

        /**
     * <p><strong>RU:</strong> создаёт сервис и получает его зависимости через Spring DI; обычно этот конструктор не вызывается прикладным кодом напрямую.</p>
     * <p><strong>EN:</strong> creates the service with dependencies supplied by Spring DI; application code normally does not call this constructor directly.</p>
     *
     * @param api RU: зависимость `api`, используемая сервисом для выполнения операций Alfresco. EN: `api` dependency used by the service to perform Alfresco operations.
     * @param paging RU: зависимость `paging`, используемая сервисом для выполнения операций Alfresco. EN: `paging` dependency used by the service to perform Alfresco operations.
     */

    public AlfrescoAuditService(AuditApi api, PagingExtractor paging) {
        this.api = api;
        this.paging = paging;
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `applications` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `applications` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public AuditAppPaging applications(int skip, int size) {
        return api.listAuditApps(skip, size, null);
    }

        /**
     * <p><strong>RU:</strong> возвращает типизированную страницу результатов и скрывает от прикладного кода generated paging-wrapper Alfresco.</p>
     * <p><strong>EN:</strong> returns a typed result page and hides the generated Alfresco paging wrapper from application code.</p>
     *
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public PageSlice<AuditApp> applicationPage(int skip, int size) {
        return paging.extract(applications(skip, size).getList(), AuditApp.class);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `application` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `application` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param applicationId RU: идентификатор audit-приложения. EN: audit application identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public AuditApp application(String applicationId) {
        AuditAppEntry response = api.getAuditApp(applicationId, null, null);
        return response == null ? null : response.getEntry();
    }

        /**
     * <p><strong>RU:</strong> устанавливает требуемое состояние или значение в Alfresco и возвращает результат операции.</p>
     * <p><strong>EN:</strong> sets the requested state or value in Alfresco and returns the operation result.</p>
     *
     * @param applicationId RU: идентификатор audit-приложения. EN: audit application identifier.
     * @param enabled RU: требуемое состояние включено/выключено. EN: desired enabled/disabled state.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public AuditApp setEnabled(String applicationId, boolean enabled) {
        AuditBodyUpdate body = new AuditBodyUpdate();
        body.setIsEnabled(enabled);
        AuditAppEntry response = api.updateAuditApp(applicationId, null, body);
        return response == null ? null : response.getEntry();
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `entries` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `entries` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param applicationId RU: идентификатор audit-приложения. EN: audit application identifier.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public AuditEntryPaging entries(String applicationId, int skip, int size) {
        return entries(applicationId, skip, size, null, null);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `entries` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `entries` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param applicationId RU: идентификатор audit-приложения. EN: audit application identifier.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @param where RU: выражение Alfresco `where` для серверной фильтрации. EN: Alfresco `where` expression for server-side filtering.
     * @param orderBy RU: выражение сортировки Alfresco. EN: Alfresco ordering expression.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public AuditEntryPaging entries(String applicationId, int skip, int size, String where, List<String> orderBy) {
        return api.listAuditEntriesForAuditApp(applicationId, skip, false, orderBy, size, where, null, null);
    }

        /**
     * <p><strong>RU:</strong> возвращает типизированную страницу результатов и скрывает от прикладного кода generated paging-wrapper Alfresco.</p>
     * <p><strong>EN:</strong> returns a typed result page and hides the generated Alfresco paging wrapper from application code.</p>
     *
     * @param applicationId RU: идентификатор audit-приложения. EN: audit application identifier.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public PageSlice<AuditEntry> entryPage(String applicationId, int skip, int size) {
        return paging.extract(entries(applicationId, skip, size).getList(), AuditEntry.class);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `entry` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `entry` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param applicationId RU: идентификатор audit-приложения. EN: audit application identifier.
     * @param entryId RU: идентификатор audit-записи. EN: audit entry identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public AuditEntryEntry entry(String applicationId, String entryId) {
        return api.getAuditEntry(applicationId, entryId, null);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `nodeEntries` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `nodeEntries` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public AuditEntryPaging nodeEntries(String nodeId, int skip, int size) {
        return nodeEntries(nodeId, skip, size, null, null);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `nodeEntries` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `nodeEntries` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @param where RU: выражение Alfresco `where` для серверной фильтрации. EN: Alfresco `where` expression for server-side filtering.
     * @param orderBy RU: выражение сортировки Alfresco. EN: Alfresco ordering expression.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public AuditEntryPaging nodeEntries(String nodeId, int skip, int size, String where, List<String> orderBy) {
        return api.listAuditEntriesForNode(nodeId, skip, orderBy, size, where, null, null);
    }

        /**
     * <p><strong>RU:</strong> возвращает типизированную страницу результатов и скрывает от прикладного кода generated paging-wrapper Alfresco.</p>
     * <p><strong>EN:</strong> returns a typed result page and hides the generated Alfresco paging wrapper from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public PageSlice<AuditEntry> nodeEntryPage(String nodeId, int skip, int size) {
        return paging.extract(nodeEntries(nodeId, skip, size).getList(), AuditEntry.class);
    }

        /**
     * <p><strong>RU:</strong> удаляет соответствующий объект Alfresco; используйте метод, когда объект больше не должен быть доступен через репозиторий.</p>
     * <p><strong>EN:</strong> deletes the corresponding Alfresco object; use it when the object should no longer be available through the repository.</p>
     *
     * @param applicationId RU: идентификатор audit-приложения. EN: audit application identifier.
     * @param entryId RU: идентификатор audit-записи. EN: audit entry identifier.
     */

    public void deleteEntry(String applicationId, String entryId) {
        api.deleteAuditEntry(applicationId, entryId);
    }

        /**
     * <p><strong>RU:</strong> удаляет соответствующий объект Alfresco; используйте метод, когда объект больше не должен быть доступен через репозиторий.</p>
     * <p><strong>EN:</strong> deletes the corresponding Alfresco object; use it when the object should no longer be available through the repository.</p>
     *
     * @param applicationId RU: идентификатор audit-приложения. EN: audit application identifier.
     * @param where RU: выражение Alfresco `where` для серверной фильтрации. EN: Alfresco `where` expression for server-side filtering.
     */

    public void deleteEntries(String applicationId, String where) {
        if (where == null || where.isBlank()) {
            throw new IllegalArgumentException("where must not be blank when deleting audit entries");
        }
        api.deleteAuditEntriesForAuditApp(applicationId, where);
    }
}
