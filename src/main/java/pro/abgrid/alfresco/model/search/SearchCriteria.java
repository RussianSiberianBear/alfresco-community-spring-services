package pro.abgrid.alfresco.model.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p><strong>RU:</strong> Fluent DSL для распространённых сценариев Alfresco Search API. Позволяет комбинировать user query или AFTS с folder/mime/name/type ограничениями, дополнительными clauses/filters, сортировкой, include/fields и пагинацией.</p>
 * <p><strong>EN:</strong> Fluent DSL for common Alfresco Search API scenarios. Combines user query or AFTS with folder/mime/name/type restrictions, custom clauses/filters, sorting, include/fields, and paging.</p>
 */
public final class SearchCriteria {
    /**
     * RU: Прикладная модель интеграционного слоя Alfresco: Sort.
     * EN: Application model of the Alfresco integration layer: Sort.
     *
     * @param field RU: поле Alfresco, по которому выполняется сортировка. EN: Alfresco field used for sorting.
     * @param ascending RU: {@code true} для сортировки по возрастанию. EN: {@code true} for ascending order.
     */
    public record Sort(String field, boolean ascending) {}

    private String text;
    private String afts;
    private String folderId;
    private String mimeType;
    private String name;
    private String nodeType;
    private Integer page = 0;
    private Integer size = 20;
    private final List<String> clauses = new ArrayList<>();
    private final List<String> filters = new ArrayList<>();
    private final List<Sort> sorts = new ArrayList<>();
    private final List<String> include = new ArrayList<>();
    private final List<String> fields = new ArrayList<>();

    /**
     * <p><strong>RU:</strong> Создаёт пустые критерии поиска с пагинацией по умолчанию: страница 0, размер 20.</p>
     * <p><strong>EN:</strong> Creates empty search criteria with default paging: page 0 and size 20.</p>
     */
    public SearchCriteria() {
    }

        /**
     * <p><strong>RU:</strong> Задаёт/возвращает user-query текст для Alfresco Search API. При построении запроса он используется как пользовательский полнотекстовый запрос.</p>
     * <p><strong>EN:</strong> Sets/returns the user-query text for Alfresco Search API. It is used as the user full-text query when building the request.</p>
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public String text() { return text; }
        /**
     * <p><strong>RU:</strong> Задаёт/возвращает явное AFTS-выражение. Используйте, когда требуется полный синтаксис Alfresco Full Text Search.</p>
     * <p><strong>EN:</strong> Sets/returns an explicit AFTS expression. Use it when full Alfresco Full Text Search syntax is required.</p>
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public String afts() { return afts; }
    /**
     * <p><strong>RU:</strong> Возвращает идентификатор папки, ограничивающей область поиска.</p>
     * <p><strong>EN:</strong> Returns the folder identifier restricting the search scope.</p>
     * @return RU: идентификатор папки либо {@code null}, если ограничение не задано. EN: folder identifier or {@code null} when unrestricted.
     */
    public String folderId() { return folderId; }
        /**
     * <p><strong>RU:</strong> Ограничивает поиск заданным MIME-типом.</p>
     * <p><strong>EN:</strong> Restricts search to the requested MIME type.</p>
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public String mimeType() { return mimeType; }
        /**
     * <p><strong>RU:</strong> Добавляет ограничение по имени узла.</p>
     * <p><strong>EN:</strong> Adds a node-name restriction.</p>
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public String name() { return name; }
        /**
     * <p><strong>RU:</strong> Ограничивает результаты QName типом узла.</p>
     * <p><strong>EN:</strong> Restricts results to a QName node type.</p>
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public String nodeType() { return nodeType; }
        /**
     * <p><strong>RU:</strong> Задаёт/возвращает номер страницы начиная с нуля. Отрицательное значение при чтении нормализуется к 0.</p>
     * <p><strong>EN:</strong> Sets/returns the zero-based page number. Negative values are normalized to 0 when read.</p>
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public int page() { return page == null ? 0 : Math.max(0, page); }
        /**
     * <p><strong>RU:</strong> Задаёт/возвращает размер страницы; при чтении значение не меньше 1.</p>
     * <p><strong>EN:</strong> Sets/returns page size; the read value is at least 1.</p>
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public int size() { return size == null ? 20 : Math.max(1, size); }
        /**
     * <p><strong>RU:</strong> Возвращает immutable список дополнительных query clauses.</p>
     * <p><strong>EN:</strong> Returns an immutable list of additional query clauses.</p>
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public List<String> clauses() { return List.copyOf(clauses); }
        /**
     * <p><strong>RU:</strong> Возвращает immutable список filterQueries.</p>
     * <p><strong>EN:</strong> Returns an immutable list of filter queries.</p>
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public List<String> filters() { return List.copyOf(filters); }
        /**
     * <p><strong>RU:</strong> Возвращает immutable список настроек сортировки.</p>
     * <p><strong>EN:</strong> Returns an immutable list of sort definitions.</p>
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public List<Sort> sorts() { return List.copyOf(sorts); }
        /**
     * <p><strong>RU:</strong> Запрашивает дополнительные секции данных Search API.</p>
     * <p><strong>EN:</strong> Requests additional Search API sections.</p>
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public List<String> include() { return List.copyOf(include); }
        /**
     * <p><strong>RU:</strong> Ограничивает поля, возвращаемые Search API.</p>
     * <p><strong>EN:</strong> Restricts fields returned by Search API.</p>
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public List<String> fields() { return List.copyOf(fields); }

        /**
     * <p><strong>RU:</strong> Задаёт/возвращает user-query текст для Alfresco Search API. При построении запроса он используется как пользовательский полнотекстовый запрос.</p>
     * <p><strong>EN:</strong> Sets/returns the user-query text for Alfresco Search API. It is used as the user full-text query when building the request.</p>
     *
     * @param value RU: значение value. EN: value of value.
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public SearchCriteria text(String value) { this.text = blankToNull(value); return this; }
        /**
     * <p><strong>RU:</strong> Задаёт/возвращает явное AFTS-выражение. Используйте, когда требуется полный синтаксис Alfresco Full Text Search.</p>
     * <p><strong>EN:</strong> Sets/returns an explicit AFTS expression. Use it when full Alfresco Full Text Search syntax is required.</p>
     *
     * @param value RU: значение value. EN: value of value.
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public SearchCriteria afts(String value) { this.afts = blankToNull(value); return this; }
        /**
     * <p><strong>RU:</strong> Ограничивает поиск потомками указанной папки.</p>
     * <p><strong>EN:</strong> Restricts search to descendants of the specified folder.</p>
     *
     * @param value RU: значение value. EN: value of value.
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public SearchCriteria folder(String value) { this.folderId = blankToNull(value); return this; }
        /**
     * <p><strong>RU:</strong> Ограничивает поиск заданным MIME-типом.</p>
     * <p><strong>EN:</strong> Restricts search to the requested MIME type.</p>
     *
     * @param value RU: значение value. EN: value of value.
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public SearchCriteria mimeType(String value) { this.mimeType = blankToNull(value); return this; }
        /**
     * <p><strong>RU:</strong> Добавляет ограничение по имени узла.</p>
     * <p><strong>EN:</strong> Adds a node-name restriction.</p>
     *
     * @param value RU: значение value. EN: value of value.
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public SearchCriteria name(String value) { this.name = blankToNull(value); return this; }
        /**
     * <p><strong>RU:</strong> Ограничивает результаты QName типом узла.</p>
     * <p><strong>EN:</strong> Restricts results to a QName node type.</p>
     *
     * @param value RU: значение value. EN: value of value.
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public SearchCriteria nodeType(String value) { this.nodeType = blankToNull(value); return this; }
        /**
     * <p><strong>RU:</strong> Задаёт/возвращает номер страницы начиная с нуля. Отрицательное значение при чтении нормализуется к 0.</p>
     * <p><strong>EN:</strong> Sets/returns the zero-based page number. Negative values are normalized to 0 when read.</p>
     *
     * @param value RU: значение value. EN: value of value.
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public SearchCriteria page(int value) { this.page = value; return this; }
        /**
     * <p><strong>RU:</strong> Задаёт/возвращает размер страницы; при чтении значение не меньше 1.</p>
     * <p><strong>EN:</strong> Sets/returns page size; the read value is at least 1.</p>
     *
     * @param value RU: значение value. EN: value of value.
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public SearchCriteria size(int value) { this.size = value; return this; }

        /**
     * <p><strong>RU:</strong> Добавляет дополнительный AFTS/query clause, объединяемый high-level builder с остальными условиями через AND.</p>
     * <p><strong>EN:</strong> Adds an extra AFTS/query clause combined by the high-level builder with other conditions using AND.</p>
     *
     * @param aftsClause RU: значение aftsClause. EN: value of aftsClause.
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public SearchCriteria and(String aftsClause) {
        String value = blankToNull(aftsClause);
        if (value != null) clauses.add(value);
        return this;
    }

        /**
     * <p><strong>RU:</strong> Добавляет filterQuery: условие фильтрует результат без участия в полнотекстовом scoring.</p>
     * <p><strong>EN:</strong> Adds a filterQuery: it filters results without participating in full-text scoring.</p>
     *
     * @param aftsFilter RU: значение aftsFilter. EN: value of aftsFilter.
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public SearchCriteria filter(String aftsFilter) {
        String value = blankToNull(aftsFilter);
        if (value != null) filters.add(value);
        return this;
    }

        /**
     * <p><strong>RU:</strong> Добавляет фильтр равенства свойства Alfresco указанному значению.</p>
     * <p><strong>EN:</strong> Adds an equality filter for an Alfresco property.</p>
     *
     * @param property RU: значение property. EN: value of property.
     * @param value RU: значение value. EN: value of value.
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public SearchCriteria propertyEquals(String property, Object value) {
        Objects.requireNonNull(value, "value");
        String p = requireProperty(property);
        return and("@" + escapeQName(p) + ":" + quote(String.valueOf(value)));
    }

        /**
     * <p><strong>RU:</strong> Добавляет серверную сортировку по полю.</p>
     * <p><strong>EN:</strong> Adds server-side sorting by a field.</p>
     *
     * @param field RU: значение field. EN: value of field.
     * @param ascending RU: значение ascending. EN: value of ascending.
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public SearchCriteria sortBy(String field, boolean ascending) {
        sorts.add(new Sort(requireProperty(field), ascending));
        return this;
    }

        /**
     * <p><strong>RU:</strong> Запрашивает дополнительные секции данных Search API.</p>
     * <p><strong>EN:</strong> Requests additional Search API sections.</p>
     *
     * @param values RU: значение values. EN: value of values.
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public SearchCriteria include(String... values) {
        if (values != null) for (String value : values) if (blankToNull(value) != null) include.add(value);
        return this;
    }

        /**
     * <p><strong>RU:</strong> Ограничивает поля, возвращаемые Search API.</p>
     * <p><strong>EN:</strong> Restricts fields returned by Search API.</p>
     *
     * @param values RU: значение values. EN: value of values.
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public SearchCriteria fields(String... values) {
        if (values != null) for (String value : values) if (blankToNull(value) != null) fields.add(value);
        return this;
    }

    private static String requireProperty(String value) {
        String v = blankToNull(value);
        if (v == null) throw new IllegalArgumentException("field/property must not be blank");
        return v;
    }

    private static String blankToNull(String value) {
        return value == null || value.isBlank() ? null : value.trim();
    }

    private static String escapeQName(String value) {
        return value.replace(":", "\\:");
    }

    private static String quote(String value) {
        return "\"" + value.replace("\\", "\\\\").replace("\"", "\\\"") + "\"";
    }
}
