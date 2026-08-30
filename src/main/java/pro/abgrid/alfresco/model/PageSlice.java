package pro.abgrid.alfresco.model;

import pro.abgrid.alfresco.dto.core.Pagination;

import java.util.List;

/**
 * <p><strong>RU:</strong> Типизированная страница результатов для endpoint Alfresco, generated-модели которых хранят list/entries как Object. Сохраняет серверную Pagination и безопасно представляет entries неизменяемым списком.</p>
 * <p><strong>EN:</strong> Typed result page for Alfresco endpoints whose generated models expose list/entries as Object. Preserves server Pagination and exposes entries as an immutable list.</p>
 *
 * @param <T> RU: тип элемента страницы. EN: page entry type.
 * @param pagination RU: серверная информация о пагинации; может быть {@code null}. EN: server paging metadata; may be {@code null}.
 * @param entries RU: элементы страницы; {@code null} нормализуется в пустой неизменяемый список. EN: page entries; {@code null} is normalized to an empty immutable list.
 */
public record PageSlice<T>(Pagination pagination, List<T> entries) {
    /**
     * <p><strong>RU:</strong> Нормализует список элементов, гарантируя ненулевое immutable-представление.</p>
     * <p><strong>EN:</strong> Normalizes entries to guarantee a non-null immutable representation.</p>
     */
    public PageSlice {
        entries = entries == null ? List.of() : List.copyOf(entries);
    }

        /**
     * <p><strong>RU:</strong> Возвращает count из серверной Pagination; если pagination/count отсутствуют, использует фактический размер entries.</p>
     * <p><strong>EN:</strong> Returns count from server Pagination; falls back to the actual entries size when pagination/count is absent.</p>
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public long count() {
        return pagination != null && pagination.getCount() != null ? pagination.getCount() : entries.size();
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
