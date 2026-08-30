package pro.abgrid.alfresco.service.query;

import pro.abgrid.alfresco.api.QueriesApi;
import pro.abgrid.alfresco.dto.core.Node;
import pro.abgrid.alfresco.dto.core.NodePaging;
import pro.abgrid.alfresco.dto.core.Person;
import pro.abgrid.alfresco.dto.core.PersonPaging;
import pro.abgrid.alfresco.dto.core.Site;
import pro.abgrid.alfresco.dto.core.SitePaging;
import pro.abgrid.alfresco.model.PageSlice;
import pro.abgrid.alfresco.support.PagingExtractor;
import org.springframework.stereotype.Service;

/**
 * <p><strong>RU:</strong> Высокоуровневый Spring-сервис для сценариев «query» в Alfresco. Он служит прикладной границей над generated REST API: принимает более удобные параметры, скрывает технические детали HTTP/DTO там, где для них есть high-level модель, и оставляет доступ к серверному результату, когда это необходимо. Сервис предназначен для внедрения как обычный Spring bean в бизнес-сервисы приложения.</p>
 * <p><strong>EN:</strong> High-level Spring service for Alfresco query scenarios. It acts as an application boundary over the generated REST API: it accepts application-friendly parameters, hides HTTP/DTO plumbing where a high-level model exists, and still exposes server results when required. The service is intended to be injected as a regular Spring bean into application business services.</p>
 */
@Service
public class AlfrescoQueryService {
    private final QueriesApi api;
    private final PagingExtractor paging;

        /**
     * <p><strong>RU:</strong> создаёт сервис и получает его зависимости через Spring DI; обычно этот конструктор не вызывается прикладным кодом напрямую.</p>
     * <p><strong>EN:</strong> creates the service with dependencies supplied by Spring DI; application code normally does not call this constructor directly.</p>
     *
     * @param api RU: зависимость `api`, используемая сервисом для выполнения операций Alfresco. EN: `api` dependency used by the service to perform Alfresco operations.
     * @param paging RU: зависимость `paging`, используемая сервисом для выполнения операций Alfresco. EN: `paging` dependency used by the service to perform Alfresco operations.
     */

    public AlfrescoQueryService(QueriesApi api, PagingExtractor paging) {
        this.api = api;
        this.paging = paging;
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level поиск и преобразует generated-ответ Alfresco в типизированную модель, удобную прикладному коду.</p>
     * <p><strong>EN:</strong> performs a high-level search and converts the generated Alfresco response into an application-friendly typed model.</p>
     *
     * @param term RU: значение параметра `term` для выполняемой операции. EN: value of `term` used by the operation.
     * @param rootNodeId RU: значение параметра `rootNodeId` для выполняемой операции. EN: value of `rootNodeId` used by the operation.
     * @param nodeType RU: значение параметра `nodeType` для выполняемой операции. EN: value of `nodeType` used by the operation.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public NodePaging findNodesRaw(String term, String rootNodeId, String nodeType, int skip, int size) {
        return api.findNodes(requireTerm(term, 3, "node"), rootNodeId, skip, size, nodeType, null, null, null);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level поиск и преобразует generated-ответ Alfresco в типизированную модель, удобную прикладному коду.</p>
     * <p><strong>EN:</strong> performs a high-level search and converts the generated Alfresco response into an application-friendly typed model.</p>
     *
     * @param term RU: значение параметра `term` для выполняемой операции. EN: value of `term` used by the operation.
     * @param rootNodeId RU: значение параметра `rootNodeId` для выполняемой операции. EN: value of `rootNodeId` used by the operation.
     * @param nodeType RU: значение параметра `nodeType` для выполняемой операции. EN: value of `nodeType` used by the operation.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public PageSlice<Node> findNodes(String term, String rootNodeId, String nodeType, int skip, int size) {
        return paging.extract(findNodesRaw(term, rootNodeId, nodeType, skip, size).getList(), Node.class);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level поиск и преобразует generated-ответ Alfresco в типизированную модель, удобную прикладному коду.</p>
     * <p><strong>EN:</strong> performs a high-level search and converts the generated Alfresco response into an application-friendly typed model.</p>
     *
     * @param term RU: значение параметра `term` для выполняемой операции. EN: value of `term` used by the operation.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public PageSlice<Node> findNodes(String term, int skip, int size) {
        return findNodes(term, null, null, skip, size);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level поиск и преобразует generated-ответ Alfresco в типизированную модель, удобную прикладному коду.</p>
     * <p><strong>EN:</strong> performs a high-level search and converts the generated Alfresco response into an application-friendly typed model.</p>
     *
     * @param term RU: значение параметра `term` для выполняемой операции. EN: value of `term` used by the operation.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public SitePaging findSitesRaw(String term, int skip, int size) {
        return api.findSites(requireTerm(term, 2, "site"), skip, size, null, null);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level поиск и преобразует generated-ответ Alfresco в типизированную модель, удобную прикладному коду.</p>
     * <p><strong>EN:</strong> performs a high-level search and converts the generated Alfresco response into an application-friendly typed model.</p>
     *
     * @param term RU: значение параметра `term` для выполняемой операции. EN: value of `term` used by the operation.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public PageSlice<Site> findSites(String term, int skip, int size) {
        return paging.extract(findSitesRaw(term, skip, size).getList(), Site.class);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level поиск и преобразует generated-ответ Alfresco в типизированную модель, удобную прикладному коду.</p>
     * <p><strong>EN:</strong> performs a high-level search and converts the generated Alfresco response into an application-friendly typed model.</p>
     *
     * @param term RU: значение параметра `term` для выполняемой операции. EN: value of `term` used by the operation.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public PersonPaging findPeopleRaw(String term, int skip, int size) {
        return api.findPeople(requireTerm(term, 2, "person"), skip, size, null, null);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level поиск и преобразует generated-ответ Alfresco в типизированную модель, удобную прикладному коду.</p>
     * <p><strong>EN:</strong> performs a high-level search and converts the generated Alfresco response into an application-friendly typed model.</p>
     *
     * @param term RU: значение параметра `term` для выполняемой операции. EN: value of `term` used by the operation.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public PageSlice<Person> findPeople(String term, int skip, int size) {
        return paging.extract(findPeopleRaw(term, skip, size).getList(), Person.class);
    }

    private static String requireTerm(String term, int min, String kind) {
        if (term == null || term.trim().length() < min) {
            throw new IllegalArgumentException(kind + " query term must contain at least " + min + " characters");
        }
        return term.trim();
    }
}
