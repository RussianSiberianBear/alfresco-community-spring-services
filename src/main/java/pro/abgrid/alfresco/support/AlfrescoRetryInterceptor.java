package pro.abgrid.alfresco.support;

import pro.abgrid.alfresco.config.AlfrescoProperties;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

/**
 * <p><strong>RU:</strong> Реализует ограниченный exponential-backoff retry только для безопасных методов GET/HEAD/OPTIONS. Повторяет сетевые IOException и HTTP 429/502/503/504; изменяющие POST/PUT/PATCH/DELETE намеренно никогда не повторяются автоматически во избежание дублирования побочных эффектов.</p>
 * <p><strong>EN:</strong> Implements bounded exponential-backoff retry only for safe GET/HEAD/OPTIONS requests. Retries network IOExceptions and HTTP 429/502/503/504; mutating POST/PUT/PATCH/DELETE requests are intentionally never retried automatically to avoid duplicate side effects.</p>
 */
public class AlfrescoRetryInterceptor implements ClientHttpRequestInterceptor {
    private static final Set<HttpMethod> SAFE_METHODS = Set.of(HttpMethod.GET, HttpMethod.HEAD, HttpMethod.OPTIONS);
    private final AlfrescoProperties.Retry retry;

        /**
     * <p><strong>RU:</strong> Создаёт компонент с зависимостями/контекстом, необходимыми для его работы.</p>
     * <p><strong>EN:</strong> Creates the component with the dependencies/context required for its operation.</p>
     *
     * @param properties RU: настройки Alfresco SDK. EN: Alfresco SDK settings.
     */

    public AlfrescoRetryInterceptor(AlfrescoProperties properties) {
        this.retry = properties.getRetry();
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
        if (!retry.isEnabled() || !SAFE_METHODS.contains(request.getMethod()) || retry.getMaxAttempts() <= 1) {
            return execution.execute(request, body);
        }

        IOException lastIo = null;
        for (int attempt = 1; attempt <= retry.getMaxAttempts(); attempt++) {
            try {
                ClientHttpResponse response = execution.execute(request, body);
                if (!isTransient(response.getStatusCode().value()) || attempt == retry.getMaxAttempts()) {
                    return response;
                }
                response.close();
            } catch (IOException ex) {
                lastIo = ex;
                if (attempt == retry.getMaxAttempts()) throw ex;
            }
            sleep(backoff(attempt));
        }
        throw lastIo == null ? new IOException("Alfresco retry exhausted") : lastIo;
    }

    private boolean isTransient(int status) {
        return status == 429 || status == 502 || status == 503 || status == 504;
    }

    private Duration backoff(int completedAttempt) {
        long base = Math.max(0L, retry.getInitialDelay().toMillis());
        long max = Math.max(base, retry.getMaxDelay().toMillis());
        long multiplier = 1L << Math.min(20, Math.max(0, completedAttempt - 1));
        long millis;
        try { millis = Math.multiplyExact(base, multiplier); }
        catch (ArithmeticException ex) { millis = max; }
        return Duration.ofMillis(Math.min(max, millis));
    }

    private static void sleep(Duration delay) throws IOException {
        if (delay.isZero() || delay.isNegative()) return;
        try {
            Thread.sleep(delay.toMillis());
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            throw new IOException("Interrupted during Alfresco retry backoff", ex);
        }
    }
}
