package pro.abgrid.alfresco.service.search;

import pro.abgrid.alfresco.api.SearchApi;
import pro.abgrid.alfresco.dto.search.*;
import pro.abgrid.alfresco.model.SearchPage;
import pro.abgrid.alfresco.model.search.SearchCriteria;
import pro.abgrid.alfresco.model.search.SearchResultPage;
import pro.abgrid.alfresco.support.SearchResultExtractor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <p><strong>RU:</strong> Высокоуровневый Spring-сервис для сценариев «search» в Alfresco. Он служит прикладной границей над generated REST API: принимает более удобные параметры, скрывает технические детали HTTP/DTO там, где для них есть high-level модель, и оставляет доступ к серверному результату, когда это необходимо. Сервис предназначен для внедрения как обычный Spring bean в бизнес-сервисы приложения.</p>
 * <p><strong>EN:</strong> High-level Spring service for Alfresco search scenarios. It acts as an application boundary over the generated REST API: it accepts application-friendly parameters, hides HTTP/DTO plumbing where a high-level model exists, and still exposes server results when required. The service is intended to be injected as a regular Spring bean into application business services.</p>
 */
@Service
public class AlfrescoSearchService {
    private final SearchApi api;
    private final SearchResultExtractor extractor;

        /**
     * <p><strong>RU:</strong> создаёт сервис и получает его зависимости через Spring DI; обычно этот конструктор не вызывается прикладным кодом напрямую.</p>
     * <p><strong>EN:</strong> creates the service with dependencies supplied by Spring DI; application code normally does not call this constructor directly.</p>
     *
     * @param api RU: зависимость `api`, используемая сервисом для выполнения операций Alfresco. EN: `api` dependency used by the service to perform Alfresco operations.
     * @param extractor RU: зависимость `extractor`, используемая сервисом для выполнения операций Alfresco. EN: `extractor` dependency used by the service to perform Alfresco operations.
     */

    public AlfrescoSearchService(SearchApi api, SearchResultExtractor extractor) {
        this.api = api;
        this.extractor = extractor;
    }

        /**
     * <p><strong>RU:</strong> выполняет поиск в Alfresco с переданными критериями и возвращает результат с серверной пагинацией.</p>
     * <p><strong>EN:</strong> executes an Alfresco search using the supplied criteria and returns server-paged results.</p>
     *
     * @param request RU: high-level параметры операции. EN: high-level operation parameters.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public ResultSetPaging search(SearchRequest request) {
        return api.search(request);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `userQuery` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `userQuery` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param text RU: текст пользовательского полнотекстового запроса. EN: user full-text query.
     * @param page RU: номер страницы, начиная с нуля. EN: zero-based page number.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public SearchPage userQuery(String text, int page, int size) {
        return execute(text, null, page, size);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `afts` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `afts` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param query RU: поисковое выражение. EN: search expression.
     * @param page RU: номер страницы, начиная с нуля. EN: zero-based page number.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public SearchPage afts(String query, int page, int size) {
        return execute(null, query, page, size);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `userQueryTyped` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `userQueryTyped` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param text RU: текст пользовательского полнотекстового запроса. EN: user full-text query.
     * @param page RU: номер страницы, начиная с нуля. EN: zero-based page number.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public SearchResultPage userQueryTyped(String text, int page, int size) {
        return find(new SearchCriteria().text(text).page(page).size(size));
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `aftsTyped` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `aftsTyped` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param query RU: поисковое выражение. EN: search expression.
     * @param page RU: номер страницы, начиная с нуля. EN: zero-based page number.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public SearchResultPage aftsTyped(String query, int page, int size) {
        return find(new SearchCriteria().afts(query).page(page).size(size));
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `execute` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `execute` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param userQuery RU: значение параметра `userQuery` для выполняемой операции. EN: value of `userQuery` used by the operation.
     * @param afts RU: AFTS-запрос, передаваемый поисковому API Alfresco. EN: AFTS query passed to the Alfresco Search API.
     * @param page RU: номер страницы, начиная с нуля. EN: zero-based page number.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public SearchPage execute(String userQuery, String afts, int page, int size) {
        SearchCriteria criteria = new SearchCriteria().page(page).size(size);
        if (userQuery != null) criteria.text(userQuery);
        if (afts != null) criteria.afts(afts);
        ResultSetPaging result = api.search(request(criteria));
        return new SearchPage(result, criteria.page(), criteria.size());
    }

        /**
     * <p><strong>RU:</strong> выполняет поиск в Alfresco с переданными критериями и возвращает результат с серверной пагинацией.</p>
     * <p><strong>EN:</strong> executes an Alfresco search using the supplied criteria and returns server-paged results.</p>
     *
     * @param criteria RU: критерии поиска, фильтрации и пагинации. EN: search, filtering, and paging criteria.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public SearchPage search(SearchCriteria criteria) {
        ResultSetPaging result = api.search(request(criteria));
        return new SearchPage(result, criteria.page(), criteria.size());
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level поиск и преобразует generated-ответ Alfresco в типизированную модель, удобную прикладному коду.</p>
     * <p><strong>EN:</strong> performs a high-level search and converts the generated Alfresco response into an application-friendly typed model.</p>
     *
     * @param criteria RU: критерии поиска, фильтрации и пагинации. EN: search, filtering, and paging criteria.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public SearchResultPage find(SearchCriteria criteria) {
        return extractor.extract(api.search(request(criteria)));
    }

        /**
     * <p><strong>RU:</strong> формирует generated request DTO из high-level параметров без выполнения HTTP-запроса; полезно для диагностики и расширенных сценариев.</p>
     * <p><strong>EN:</strong> builds the generated request DTO from high-level parameters without executing HTTP; useful for diagnostics and advanced scenarios.</p>
     *
     * @param criteria RU: критерии поиска, фильтрации и пагинации. EN: search, filtering, and paging criteria.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public SearchRequest request(SearchCriteria criteria) {
        if (criteria == null) {
            throw new IllegalArgumentException("criteria must not be null");
        }

        List<String> structural = structuralClauses(criteria);
        RequestQuery query = new RequestQuery();
        query.setUserQuery(criteria.text());

        if (criteria.afts() != null) {
            List<String> all = new ArrayList<>();
            all.add(criteria.afts());
            all.addAll(structural);
            all.addAll(criteria.clauses());
            query.setQuery(and(all));
        } else if (criteria.text() == null) {
            List<String> all = new ArrayList<>(structural);
            all.addAll(criteria.clauses());
            query.setQuery(and(all));
        }

        if (query.getUserQuery() == null && query.getQuery() == null) {
            throw new IllegalArgumentException("search criteria must define text, afts, or at least one structural clause");
        }

        RequestPagination paging = new RequestPagination();
        paging.setSkipCount(criteria.page() * criteria.size());
        paging.setMaxItems(criteria.size());

        SearchRequest request = new SearchRequest();
        request.setQuery(query);
        request.setPaging(paging);

        if (!criteria.include().isEmpty()) {
            RequestInclude include = new RequestInclude();
            include.addAll(criteria.include());
            request.setInclude(include);
        }
        if (!criteria.fields().isEmpty()) {
            RequestFields fields = new RequestFields();
            fields.addAll(criteria.fields());
            request.setFields(fields);
        }

        List<String> filters = new ArrayList<>(criteria.filters());
        // With userQuery, structural clauses are filters so they do not replace the user's full-text query.
        if (criteria.text() != null && criteria.afts() == null) {
            filters.addAll(structural);
            filters.addAll(criteria.clauses());
        }
        if (!filters.isEmpty()) {
            RequestFilterQueries fq = new RequestFilterQueries();
            for (String filter : filters) {
                fq.add(Map.of("query", filter));
            }
            request.setFilterQueries(fq);
        }

        if (!criteria.sorts().isEmpty()) {
            RequestSortDefinition sort = new RequestSortDefinition();
            for (SearchCriteria.Sort item : criteria.sorts()) {
                Map<String, Object> spec = new LinkedHashMap<>();
                spec.put("type", "FIELD");
                spec.put("field", item.field());
                spec.put("ascending", item.ascending());
                sort.add(spec);
            }
            request.setSort(sort);
        }
        return request;
    }

        /**
     * <p><strong>RU:</strong> передаёт generated-запрос напрямую в REST-клиент; предназначен для сценариев, которым недостаточно high-level API.</p>
     * <p><strong>EN:</strong> passes the generated request directly to the REST client; intended for cases not covered by the high-level API.</p>
     *
     * @param request RU: high-level параметры операции. EN: high-level operation parameters.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public ResultSetPaging raw(SearchRequest request) {
        return api.search(request);
    }

    private List<String> structuralClauses(SearchCriteria criteria) {
        List<String> result = new ArrayList<>();
        if (criteria.folderId() != null) {
            result.add("PARENT:" + quote(criteria.folderId()));
        }
        if (criteria.mimeType() != null) {
            result.add("@cm\\:content.mimetype:" + quote(criteria.mimeType()));
        }
        if (criteria.name() != null) {
            result.add("cm:name:" + quote(criteria.name()));
        }
        if (criteria.nodeType() != null) {
            result.add("TYPE:" + quote(criteria.nodeType()));
        }
        return result;
    }

    private String and(List<String> clauses) {
        List<String> nonBlank = clauses.stream()
                .filter(value -> value != null && !value.isBlank())
                .map(String::trim)
                .toList();
        if (nonBlank.isEmpty()) return null;
        if (nonBlank.size() == 1) return nonBlank.getFirst();
        return nonBlank.stream().map(value -> "(" + value + ")").reduce((a, b) -> a + " AND " + b).orElse(null);
    }

    private String quote(String value) {
        return "\"" + value.replace("\\", "\\\\").replace("\"", "\\\"") + "\"";
    }
}
