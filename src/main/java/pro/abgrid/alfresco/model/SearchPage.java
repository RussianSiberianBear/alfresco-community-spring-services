package pro.abgrid.alfresco.model;

import pro.abgrid.alfresco.dto.search.ResultSetPaging;

/**
 * <p><strong>RU:</strong> Обратнос совместимая оболочка сырого ResultSetPaging с информацией о запрошенной странице. Для нового типизированного кода предпочтительнее SearchResultPage.</p>
 * <p><strong>EN:</strong> Backward-compatible wrapper around raw ResultSetPaging plus requested page information. Prefer SearchResultPage for new typed code.</p>
 *
 * @param result RU: сырой ответ Search API. EN: raw Search API response.
 * @param page RU: номер страницы начиная с нуля. EN: zero-based page number.
 * @param size RU: размер страницы. EN: page size.
 */
public record SearchPage(ResultSetPaging result, int page, int size) {}
