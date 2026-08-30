package pro.abgrid.alfresco.exception;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;

import java.net.URI;

/**
 * <p><strong>RU:</strong> Единое runtime-исключение для неуспешных ответов Alfresco REST API. Сохраняет HTTP status, method, URI, raw body и разобранный стандартный error-envelope, а также предоставляет удобные predicates для типовых сценариев обработки ошибок.</p>
 * <p><strong>EN:</strong> Unified runtime exception for non-success Alfresco REST responses. Preserves HTTP status, method, URI, raw body, and parsed standard error envelope, and exposes convenience predicates for common error-handling scenarios.</p>
 */
public class AlfrescoApiException extends RuntimeException {
    /** RU: HTTP status ответа Alfresco. EN: Alfresco HTTP response status. */
    private final HttpStatusCode status;
    /** RU: Сырое тело ошибочного ответа. EN: Raw error response body. */
    private final String responseBody;
    /** RU: HTTP-метод исходного запроса, если известен. EN: HTTP method of the original request, when known. */
    private final HttpMethod method;
    /** RU: URI исходного запроса, если известен. EN: URI of the original request, when known. */
    private final URI uri;
    /** RU: Разобранный стандартный error-envelope Alfresco, если доступен. EN: Parsed standard Alfresco error envelope, when available. */
    private final AlfrescoErrorDetails error;

        /**
     * <p><strong>RU:</strong> Создаёт компонент с зависимостями/контекстом, необходимыми для его работы.</p>
     * <p><strong>EN:</strong> Creates the component with the dependencies/context required for its operation.</p>
     *
     * @param status RU: HTTP status ответа Alfresco. EN: Alfresco HTTP response status.
     * @param responseBody RU: сырое тело ошибочного ответа. EN: raw error response body.
     */

    public AlfrescoApiException(HttpStatusCode status, String responseBody) {
        this(status, responseBody, null, null, null);
    }

        /**
     * <p><strong>RU:</strong> Создаёт компонент с зависимостями/контекстом, необходимыми для его работы.</p>
     * <p><strong>EN:</strong> Creates the component with the dependencies/context required for its operation.</p>
     *
     * @param status RU: HTTP status ответа Alfresco. EN: Alfresco HTTP response status.
     * @param responseBody RU: сырое тело ошибочного ответа. EN: raw error response body.
     * @param method RU: HTTP-метод исходного запроса. EN: HTTP method of the original request.
     * @param uri RU: URI исходного запроса. EN: URI of the original request.
     * @param error RU: разобранный стандартный error-envelope, либо null. EN: parsed standard error envelope, or null.
     */

    public AlfrescoApiException(HttpStatusCode status, String responseBody,
                                HttpMethod method, URI uri, AlfrescoErrorDetails error) {
        super(buildMessage(status, responseBody, method, uri, error));
        this.status = status;
        this.responseBody = responseBody;
        this.method = method;
        this.uri = uri;
        this.error = error;
    }

    /**
     * RU: Возвращает status.
     * EN: Returns status.
      * @return RU: HTTP status ответа Alfresco. EN: Alfresco HTTP response status.
     */
    public HttpStatusCode getStatus() { return status; }
    /**
     * RU: Возвращает response body.
     * EN: Returns response body.
      * @return RU: сырое тело ответа. EN: raw response body.
     */
    public String getResponseBody() { return responseBody; }
    /**
     * RU: Возвращает method.
     * EN: Returns method.
      * @return RU: HTTP-метод запроса либо {@code null}. EN: request HTTP method or {@code null}.
     */
    public HttpMethod getMethod() { return method; }
    /**
     * RU: Возвращает uri.
     * EN: Returns uri.
      * @return RU: URI запроса либо {@code null}. EN: request URI or {@code null}.
     */
    public URI getUri() { return uri; }
    /**
     * RU: Возвращает error.
     * EN: Returns error.
      * @return RU: разобранные детали ошибки либо {@code null}. EN: parsed error details or {@code null}.
     */
    public AlfrescoErrorDetails getError() { return error; }

    /**
     * RU: Возвращает error key.
     * EN: Returns error key.
      * @return RU: ключ ошибки либо {@code null}. EN: error key or {@code null}.
     */
    public String getErrorKey() { return error == null ? null : error.getErrorKey(); }
    /**
     * RU: Возвращает brief summary.
     * EN: Returns brief summary.
      * @return RU: краткое описание либо {@code null}. EN: brief summary or {@code null}.
     */
    public String getBriefSummary() { return error == null ? null : error.getBriefSummary(); }
    /**
     * RU: Возвращает log id.
     * EN: Returns log id.
      * @return RU: серверный log id либо {@code null}. EN: server log id or {@code null}.
     */
    public String getLogId() { return error == null ? null : error.getLogId(); }

        /**
     * <p><strong>RU:</strong> Проверяет HTTP 404; удобно для ветвления бизнес-логики без ручного сравнения status code.</p>
     * <p><strong>EN:</strong> Checks for HTTP 404, useful for application branching without manual status-code comparison.</p>
     * @return RU: результат операции согласно описанию метода. EN: operation result described above.
     */

    public boolean isNotFound() { return status.value() == 404; }
        /**
     * <p><strong>RU:</strong> Проверяет HTTP 409 Conflict.</p>
     * <p><strong>EN:</strong> Checks for HTTP 409 Conflict.</p>
     * @return RU: результат операции согласно описанию метода. EN: operation result described above.
     */

    public boolean isConflict() { return status.value() == 409; }
        /**
     * <p><strong>RU:</strong> Проверяет HTTP 401 Authentication required/failed.</p>
     * <p><strong>EN:</strong> Checks for HTTP 401 authentication failure.</p>
     * @return RU: результат операции согласно описанию метода. EN: operation result described above.
     */

    public boolean isUnauthorized() { return status.value() == 401; }
        /**
     * <p><strong>RU:</strong> Проверяет HTTP 403, когда пользователь аутентифицирован, но операция запрещена.</p>
     * <p><strong>EN:</strong> Checks for HTTP 403 when the user is authenticated but not permitted.</p>
     * @return RU: результат операции согласно описанию метода. EN: operation result described above.
     */

    public boolean isForbidden() { return status.value() == 403; }
        /**
     * <p><strong>RU:</strong> Проверяет HTTP 429 Too Many Requests.</p>
     * <p><strong>EN:</strong> Checks for HTTP 429 Too Many Requests.</p>
     * @return RU: результат операции согласно описанию метода. EN: operation result described above.
     */

    public boolean isRateLimited() { return status.value() == 429; }
        /**
     * <p><strong>RU:</strong> Проверяет любой HTTP 5xx.</p>
     * <p><strong>EN:</strong> Checks for any HTTP 5xx status.</p>
     * @return RU: результат операции согласно описанию метода. EN: operation result described above.
     */

    public boolean isServerError() { return status.is5xxServerError(); }
        /**
     * <p><strong>RU:</strong> Проверяет статус, который retry interceptor считает временным: 429, 502, 503 или 504. Сам метод ничего не повторяет.</p>
     * <p><strong>EN:</strong> Checks whether the status is considered transient by the retry interceptor: 429, 502, 503, or 504. This method does not perform a retry.</p>
     * @return RU: результат операции согласно описанию метода. EN: operation result described above.
     */

    public boolean isRetryableStatus() {
        int code = status.value();
        return code == 429 || code == 502 || code == 503 || code == 504;
    }

    private static String buildMessage(HttpStatusCode status, String body, HttpMethod method,
                                       URI uri, AlfrescoErrorDetails error) {
        StringBuilder message = new StringBuilder("Alfresco API request failed with HTTP ")
                .append(status.value());
        if (method != null) message.append(" ").append(method);
        if (uri != null) message.append(" ").append(uri);
        if (error != null && error.getBriefSummary() != null && !error.getBriefSummary().isBlank()) {
            message.append(": ").append(error.getBriefSummary());
            if (error.getErrorKey() != null && !error.getErrorKey().isBlank()) {
                message.append(" [").append(error.getErrorKey()).append(']');
            }
            if (error.getLogId() != null && !error.getLogId().isBlank()) {
                message.append(" (logId=").append(error.getLogId()).append(')');
            }
        } else if (body != null && !body.isBlank()) {
            message.append(": ").append(body);
        }
        return message.toString();
    }
}
