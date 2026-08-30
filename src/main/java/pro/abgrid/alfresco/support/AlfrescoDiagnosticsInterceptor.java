package pro.abgrid.alfresco.support;

import pro.abgrid.alfresco.config.AlfrescoProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * <p><strong>RU:</strong> Опционально логирует метод, URI, HTTP status и длительность запроса. Не логирует credentials и request/response bodies, поэтому подходит для базовой эксплуатационной диагностики без явного раскрытия содержимого документов.</p>
 * <p><strong>EN:</strong> Optionally logs method, URI, HTTP status, and request duration. It does not log credentials or request/response bodies, making it suitable for basic operational diagnostics without explicitly exposing document content.</p>
 */
public class AlfrescoDiagnosticsInterceptor implements ClientHttpRequestInterceptor {
    private static final Logger log = LoggerFactory.getLogger(AlfrescoDiagnosticsInterceptor.class);
    private final boolean enabled;

        /**
     * <p><strong>RU:</strong> Создаёт компонент с зависимостями/контекстом, необходимыми для его работы.</p>
     * <p><strong>EN:</strong> Creates the component with the dependencies/context required for its operation.</p>
     *
     * @param properties RU: настройки Alfresco SDK. EN: Alfresco SDK settings.
     */

    public AlfrescoDiagnosticsInterceptor(AlfrescoProperties properties) {
        this.enabled = properties.getDiagnostics().isEnabled();
    }

        /**
     * <p><strong>RU:</strong> Перехватывает исходящий HTTP-запрос и применяет описанную политикой компонента обработку.</p>
     * <p><strong>EN:</strong> Intercepts an outgoing HTTP request and applies the policy described by this component.</p>
     *
     * @param request RU: исходящий HTTP-запрос. EN: outgoing HTTP request.
     * @param body RU: сериализованное тело запроса; interceptor его не логирует. EN: serialized request body; the interceptor does not log it.
     * @param execution RU: следующий элемент цепочки выполнения HTTP-запроса. EN: next HTTP request execution in the interceptor chain.
     * @return RU: результат операции согласно описанию метода. EN: operation result described above.
     * @throws java.io.IOException RU: при сетевой ошибке, исчерпании retry или прерывании backoff. EN: on network failure, retry exhaustion, or interrupted backoff.
     */

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {
        if (!enabled) return execution.execute(request, body);
        long started = System.nanoTime();
        try {
            ClientHttpResponse response = execution.execute(request, body);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - started);
            log.info("Alfresco HTTP {} {} -> {} ({} ms)", request.getMethod(), request.getURI(),
                    response.getStatusCode().value(), millis);
            return response;
        } catch (IOException | RuntimeException ex) {
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - started);
            log.warn("Alfresco HTTP {} {} failed after {} ms: {}", request.getMethod(), request.getURI(),
                    millis, ex.getMessage());
            throw ex;
        }
    }
}
