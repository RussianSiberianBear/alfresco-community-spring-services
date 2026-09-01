package pro.abgrid.alfresco.model;

import java.time.Duration;

/**
 * <p><strong>RU:</strong> Безопасный снимок настроек подключения для диагностики. Модель намеренно не содержит пароль и может использоваться в health/info endpoint приложения без раскрытия секрета.</p>
 * <p><strong>EN:</strong> Sanitized connection settings snapshot for diagnostics. The model intentionally has no password field and can be exposed by an application health/info endpoint without leaking the secret.</p>
 *
 * @param url RU: базовый URL экземпляра ACS. EN: base ACS instance URL.
 * @param username RU: имя пользователя подключения. EN: connection user name.
 * @param credentialsConfigured RU: признак наличия настроенных username/password. EN: whether username/password are configured.
 * @param retryEnabled RU: включены ли безопасные автоматические повторы. EN: whether safe automatic retries are enabled.
 * @param retryMaxAttempts RU: максимальное число попыток HTTP-запроса. EN: maximum HTTP request attempts.
 * @param diagnosticsEnabled RU: включено ли диагностическое HTTP-логирование. EN: whether diagnostic HTTP logging is enabled.
 * @param connectTimeout RU: таймаут установления HTTP-соединения. EN: HTTP connection timeout.
 * @param readTimeout RU: таймаут чтения HTTP-ответа. EN: HTTP response read timeout.
 * @param streamingReadTimeout RU: увеличенный таймаут потоковых операций. EN: extended streaming-operation timeout.
 * @param healthEnabled RU: включена ли Actuator health-интеграция при наличии Actuator. EN: whether Actuator health integration is enabled when Actuator is present.
 */
public record AlfrescoConnectionInfo(String url, String username, boolean credentialsConfigured,
                                     boolean retryEnabled, int retryMaxAttempts, boolean diagnosticsEnabled,
                                     Duration connectTimeout, Duration readTimeout, Duration streamingReadTimeout, boolean healthEnabled) {}
