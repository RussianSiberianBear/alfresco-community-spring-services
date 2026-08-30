package pro.abgrid.alfresco.support;

import pro.abgrid.alfresco.dto.search.Pagination;
import pro.abgrid.alfresco.dto.search.ResultNode;
import pro.abgrid.alfresco.dto.search.ResultSetContext;
import pro.abgrid.alfresco.dto.search.ResultSetPaging;
import pro.abgrid.alfresco.model.search.SearchHit;
import pro.abgrid.alfresco.model.search.SearchResultPage;
import org.springframework.stereotype.Component;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * <p><strong>RU:</strong> Преобразует generated ResultSetPaging Search API в SearchResultPage и SearchHit. Сохраняет pagination/context/raw response, но избавляет прикладной код от ручного разбора Object list/entry wrappers.</p>
 * <p><strong>EN:</strong> Converts generated Search API ResultSetPaging into SearchResultPage and SearchHit. Preserves pagination/context/raw response while removing the need for application code to manually parse Object list/entry wrappers.</p>
 */
@Component
public class SearchResultExtractor {
    private final ObjectMapper mapper;

        /**
     * <p><strong>RU:</strong> Создаёт компонент с зависимостями/контекстом, необходимыми для его работы.</p>
     * <p><strong>EN:</strong> Creates the component with the dependencies/context required for its operation.</p>
     *
     * @param mapper RU: Jackson ObjectMapper, используемый для безопасного преобразования JSON-моделей. EN: Jackson ObjectMapper used for safe JSON model conversion.
     */

    public SearchResultExtractor(ObjectMapper mapper) {
        this.mapper = mapper;
    }

        /**
     * <p><strong>RU:</strong> Преобразует generated/raw ответ в типизированную high-level модель, не выполняя дополнительного HTTP-запроса.</p>
     * <p><strong>EN:</strong> Converts a generated/raw response into a typed high-level model without performing another HTTP request.</p>
     *
     * @param result RU: сырой Search API ответ. EN: raw Search API response.
     * @return RU: результат операции согласно описанию метода. EN: operation result described above.
     */

    public SearchResultPage extract(ResultSetPaging result) {
        if (result == null || result.getList() == null) {
            return new SearchResultPage(null, List.of(), null, result);
        }

        JsonNode list = mapper.valueToTree(result.getList());
        Pagination pagination = list.hasNonNull("pagination")
                ? mapper.convertValue(list.get("pagination"), Pagination.class)
                : null;
        ResultSetContext context = list.hasNonNull("context")
                ? mapper.convertValue(list.get("context"), ResultSetContext.class)
                : null;

        List<SearchHit> hits = new ArrayList<>();
        JsonNode entries = list.get("entries");
        if (entries != null && entries.isArray()) {
            for (JsonNode wrapper : entries) {
                JsonNode entry = wrapper.get("entry");
                if (entry != null && !entry.isNull()) {
                    SearchHit hit = SearchHit.from(mapper.convertValue(entry, ResultNode.class));
                    if (hit != null) {
                        hits.add(hit);
                    }
                }
            }
        }
        return new SearchResultPage(pagination, hits, context, result);
    }
}
