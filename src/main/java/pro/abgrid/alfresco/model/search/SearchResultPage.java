package pro.abgrid.alfresco.model.search;

import pro.abgrid.alfresco.dto.search.Pagination;
import pro.abgrid.alfresco.dto.search.ResultSetContext;
import pro.abgrid.alfresco.dto.search.ResultSetPaging;

import java.util.List;

/**
 * <p><strong>RU:</strong> Типизированный результат Search API: пагинация, immutable список SearchHit, context и исходный ResultSetPaging для доступа к расширенным данным generated API.</p>
 * <p><strong>EN:</strong> Typed Search API result containing pagination, immutable SearchHit entries, context, and the original ResultSetPaging for advanced generated-API data.</p>
 *
 * @param pagination RU: серверная пагинация Alfresco. EN: Alfresco server paging metadata.
 * @param entries RU: типизированные элементы страницы. EN: typed page entries.
 * @param context RU: значение context. EN: value of context.
 * @param raw RU: значение raw. EN: value of raw.
 */
public record SearchResultPage(
        Pagination pagination,
        List<SearchHit> entries,
        ResultSetContext context,
        ResultSetPaging raw
) {
    /**
     * <p><strong>RU:</strong> Нормализует список результатов в ненулевое immutable-представление.</p>
     * <p><strong>EN:</strong> Normalizes result entries to a non-null immutable representation.</p>
     */
    public SearchResultPage {
        entries = entries == null ? List.of() : List.copyOf(entries);
    }

        /**
     * <p><strong>RU:</strong> Возвращает count из серверной Pagination; если pagination/count отсутствуют, использует фактический размер entries.</p>
     * <p><strong>EN:</strong> Returns count from server Pagination; falls back to the actual entries size when pagination/count is absent.</p>
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public long count() {
        return pagination != null && pagination.getCount() != null
                ? pagination.getCount()
                : entries.size();
    }

    /**
     * <p><strong>RU:</strong> Возвращает общее число найденных элементов по данным Alfresco; при отсутствии значения использует размер текущей страницы.</p>
     * <p><strong>EN:</strong> Returns the total number of matching items reported by Alfresco; falls back to current page size when unavailable.</p>
     * @return RU: общее число результатов. EN: total result count.
     */
    public long totalItems() {
        return pagination != null && pagination.getTotalItems() != null
                ? pagination.getTotalItems()
                : entries.size();
    }

        /**
     * <p><strong>RU:</strong> Показывает, сообщил ли Alfresco о наличии следующей страницы.</p>
     * <p><strong>EN:</strong> Reports whether Alfresco indicated that another result page exists.</p>
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public boolean hasMoreItems() {
        return pagination != null && Boolean.TRUE.equals(pagination.getHasMoreItems());
    }
}
