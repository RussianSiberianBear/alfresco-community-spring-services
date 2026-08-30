package pro.abgrid.alfresco.support;

import pro.abgrid.alfresco.dto.core.Pagination;
import pro.abgrid.alfresco.model.PageSlice;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * <p><strong>RU:</strong> Преобразует generated paging payload, где list хранится как Object, в типизированный PageSlice&lt;T&gt;. Извлекает pagination и каждый entry через Jackson, централизуя workaround для неточной generated-модели.</p>
 * <p><strong>EN:</strong> Converts generated paging payloads whose list is Object into typed PageSlice&lt;T&gt;. Extracts pagination and individual entries through Jackson, centralizing the workaround for imprecise generated models.</p>
 */
@Component
public class PagingExtractor {
    private final ObjectMapper mapper;

        /**
     * <p><strong>RU:</strong> Создаёт компонент с зависимостями/контекстом, необходимыми для его работы.</p>
     * <p><strong>EN:</strong> Creates the component with the dependencies/context required for its operation.</p>
     *
     * @param mapper RU: Jackson ObjectMapper, используемый для безопасного преобразования JSON-моделей. EN: Jackson ObjectMapper used for safe JSON model conversion.
     */

    public PagingExtractor(ObjectMapper mapper) {
        this.mapper = mapper;
    }

        /**
     * <p><strong>RU:</strong> Преобразует generated/raw ответ в типизированную high-level модель, не выполняя дополнительного HTTP-запроса.</p>
     * <p><strong>EN:</strong> Converts a generated/raw response into a typed high-level model without performing another HTTP request.</p>
     *
     * @param <T> RU: тип элемента страницы. EN: page entry type.
     * @param rawList RU: generated list payload, обычно Object. EN: generated list payload, commonly Object.
     * @param entryType RU: класс целевого типа entry. EN: target entry class.
     * @return RU: результат операции согласно описанию метода. EN: operation result described above.
     */

    public <T> PageSlice<T> extract(Object rawList, Class<T> entryType) {
        if (rawList == null) {
            return new PageSlice<>(null, List.of());
        }

        JsonNode list = mapper.valueToTree(rawList);
        Pagination pagination = null;
        if (list.hasNonNull("pagination")) {
            pagination = mapper.convertValue(list.get("pagination"), Pagination.class);
        }

        List<T> entries = new ArrayList<>();
        JsonNode rawEntries = list.get("entries");
        if (rawEntries != null && rawEntries.isArray()) {
            for (JsonNode wrapper : rawEntries) {
                JsonNode entry = wrapper.get("entry");
                if (entry != null && !entry.isNull()) {
                    entries.add(mapper.convertValue(entry, entryType));
                }
            }
        }
        return new PageSlice<>(pagination, entries);
    }
}
