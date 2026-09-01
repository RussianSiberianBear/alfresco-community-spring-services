package pro.abgrid.alfresco.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

/**
 * <p><strong>RU:</strong> Типобезопасные настройки интеграции, привязанные Spring Boot к секции {@code alfresco.*}. Содержат адрес ACS, Basic Auth credentials, политику безопасного retry и диагностическое HTTP-логирование. Пароль хранится только как конфигурационное значение и не попадает в {@code AlfrescoConnectionInfo}.</p>
 * <p><strong>EN:</strong> Type-safe integration settings bound by Spring Boot from {@code alfresco.*}. Contains the ACS address, Basic Auth credentials, safe retry policy, and diagnostic HTTP logging. The password remains a configuration value and is intentionally excluded from {@code AlfrescoConnectionInfo}.</p>
 */
@ConfigurationProperties(prefix = "alfresco")
public class AlfrescoProperties {

    /**
     * <p><strong>RU:</strong> Создаёт контейнер настроек, который затем заполняется Spring Boot binding-механизмом.</p>
     * <p><strong>EN:</strong> Creates the settings container populated later by Spring Boot configuration binding.</p>
     */
    public AlfrescoProperties() {
    }

    /**

     * <p><strong>RU:</strong> базовый URL ACS, например http://localhost:8082; API path добавляется настройками HTTP service groups.</p>

     * <p><strong>EN:</strong> base ACS URL, for example http://localhost:8082; API paths are added by HTTP service group configuration.</p>

     */

    private String url;
    /**
     * <p><strong>RU:</strong> имя пользователя Basic Auth.</p>
     * <p><strong>EN:</strong> Basic Auth user name.</p>
     */
    private String username;
    /**
     * <p><strong>RU:</strong> пароль Basic Auth; не следует выводить в логи или diagnostics.</p>
     * <p><strong>EN:</strong> Basic Auth password; must not be logged or exposed by diagnostics.</p>
     */
    private String password;
    /**
     * <p><strong>RU:</strong> настройки автоматических повторов только безопасных read-запросов.</p>
     * <p><strong>EN:</strong> automatic retry settings for safe read requests only.</p>
     */
    private Retry retry = new Retry();
    /**
     * <p><strong>RU:</strong> настройки диагностического HTTP-логирования без bodies/credentials.</p>
     * <p><strong>EN:</strong> diagnostic HTTP logging settings without bodies/credentials.</p>
     */
    private Diagnostics diagnostics = new Diagnostics();
    /**
     * <p><strong>RU:</strong> настройки HTTP-транспорта: connect/read timeout и переиспользование соединений JDK HttpClient.</p>
     * <p><strong>EN:</strong> HTTP transport settings: connect/read timeout and JDK HttpClient connection reuse.</p>
     */
    private Http http = new Http();
    /**
     * <p><strong>RU:</strong> настройки опционального Actuator health indicator.</p>
     * <p><strong>EN:</strong> optional Actuator health indicator settings.</p>
     */
    private Health health = new Health();

        /**
     * <p><strong>RU:</strong> Возвращает базовый URL ACS, например http://localhost:8082; API path добавляется настройками HTTP service groups.</p>
     * <p><strong>EN:</strong> Returns base ACS URL, for example http://localhost:8082; API paths are added by HTTP service group configuration.</p>
     *
     * @return RU: текущее значение настройки. EN: current setting value.
     */

    public String getUrl() {
        return url;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает базовый URL ACS, например http://localhost:8082; API path добавляется настройками HTTP service groups.</p>
     * <p><strong>EN:</strong> Sets base ACS URL, for example http://localhost:8082; API paths are added by HTTP service group configuration.</p>
     *
     * @param url RU: новое значение настройки. EN: new setting value.
     */

    public void setUrl(String url) {
        this.url = url;
    }

        /**
     * <p><strong>RU:</strong> Возвращает имя пользователя Basic Auth.</p>
     * <p><strong>EN:</strong> Returns Basic Auth user name.</p>
     *
     * @return RU: текущее значение настройки. EN: current setting value.
     */

    public String getUsername() {
        return username;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает имя пользователя Basic Auth.</p>
     * <p><strong>EN:</strong> Sets Basic Auth user name.</p>
     *
     * @param username RU: новое значение настройки. EN: new setting value.
     */

    public void setUsername(String username) {
        this.username = username;
    }

        /**
     * <p><strong>RU:</strong> Возвращает пароль Basic Auth; не следует выводить в логи или diagnostics.</p>
     * <p><strong>EN:</strong> Returns Basic Auth password; must not be logged or exposed by diagnostics.</p>
     *
     * @return RU: текущее значение настройки. EN: current setting value.
     */

    public String getPassword() {
        return password;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает пароль Basic Auth; не следует выводить в логи или diagnostics.</p>
     * <p><strong>EN:</strong> Sets Basic Auth password; must not be logged or exposed by diagnostics.</p>
     *
     * @param password RU: новое значение настройки. EN: new setting value.
     */

    public void setPassword(String password) {
        this.password = password;
    }

        /**
     * <p><strong>RU:</strong> Возвращает настройки автоматических повторов только безопасных read-запросов.</p>
     * <p><strong>EN:</strong> Returns automatic retry settings for safe read requests only.</p>
     *
     * @return RU: текущее значение настройки. EN: current setting value.
     */

    public Retry getRetry() { return retry; }
        /**
     * <p><strong>RU:</strong> Устанавливает настройки автоматических повторов только безопасных read-запросов.</p>
     * <p><strong>EN:</strong> Sets automatic retry settings for safe read requests only.</p>
     *
     * @param retry RU: новое значение настройки. EN: new setting value.
     */

    public void setRetry(Retry retry) { this.retry = retry == null ? new Retry() : retry; }
        /**
     * <p><strong>RU:</strong> Возвращает настройки диагностического HTTP-логирования без bodies/credentials.</p>
     * <p><strong>EN:</strong> Returns diagnostic HTTP logging settings without bodies/credentials.</p>
     *
     * @return RU: текущее значение настройки. EN: current setting value.
     */

    public Diagnostics getDiagnostics() { return diagnostics; }
        /**
     * <p><strong>RU:</strong> Устанавливает настройки диагностического HTTP-логирования без bodies/credentials.</p>
     * <p><strong>EN:</strong> Sets diagnostic HTTP logging settings without bodies/credentials.</p>
     *
     * @param diagnostics RU: новое значение настройки. EN: new setting value.
     */

    public void setDiagnostics(Diagnostics diagnostics) { this.diagnostics = diagnostics == null ? new Diagnostics() : diagnostics; }

    /** @return RU: настройки HTTP-транспорта. EN: HTTP transport settings. */
    public Http getHttp() { return http; }
    /** @param http RU: настройки HTTP-транспорта. EN: HTTP transport settings. */
    public void setHttp(Http http) { this.http = http == null ? new Http() : http; }
    /** @return RU: настройки health indicator. EN: health indicator settings. */
    public Health getHealth() { return health; }
    /** @param health RU: настройки health indicator. EN: health indicator settings. */
    public void setHealth(Health health) { this.health = health == null ? new Health() : health; }

    /**
     * <p><strong>RU:</strong> Настройки встроенного HTTP-транспорта. Один JDK {@code HttpClient} используется всеми группами API, поэтому keep-alive соединения и внутренний пул переиспользуются между запросами.</p>
     * <p><strong>EN:</strong> Built-in HTTP transport settings. One JDK {@code HttpClient} is shared by all API groups so keep-alive connections and its internal pool are reused across requests.</p>
     */
    public static class Http {
        private Duration connectTimeout = Duration.ofSeconds(5);
        private Duration readTimeout = Duration.ofSeconds(30);
        private Duration streamingReadTimeout = Duration.ofMinutes(10);

        /** RU: Создаёт HTTP-настройки по умолчанию. EN: Creates default HTTP settings. */
        public Http() {}
        /** @return RU: таймаут установления соединения. EN: connection establishment timeout. */
        public Duration getConnectTimeout() { return connectTimeout; }
        /** @param connectTimeout RU: таймаут установления соединения. EN: connection establishment timeout. */
        public void setConnectTimeout(Duration connectTimeout) {
            this.connectTimeout = positive(connectTimeout, Duration.ofSeconds(5), "connect-timeout");
        }
        /** @return RU: таймаут чтения ответа. EN: response read timeout. */
        public Duration getReadTimeout() { return readTimeout; }
        /** @param readTimeout RU: таймаут чтения ответа. EN: response read timeout. */
        public void setReadTimeout(Duration readTimeout) {
            this.readTimeout = positive(readTimeout, Duration.ofSeconds(30), "read-timeout");
        }
        /** @return RU: увеличенный таймаут потоковых upload/download операций. EN: extended timeout for streaming upload/download operations. */
        public Duration getStreamingReadTimeout() { return streamingReadTimeout; }
        /** @param streamingReadTimeout RU: таймаут потоковых операций. EN: streaming operation timeout. */
        public void setStreamingReadTimeout(Duration streamingReadTimeout) {
            this.streamingReadTimeout = positive(streamingReadTimeout, Duration.ofMinutes(10), "streaming-read-timeout");
        }
        private static Duration positive(Duration value, Duration fallback, String name) {
            if (value == null) return fallback;
            if (value.isZero() || value.isNegative()) {
                throw new IllegalArgumentException("alfresco.http." + name + " must be greater than zero");
            }
            return value;
        }
    }

    /**
     * <p><strong>RU:</strong> Настройки проверки доступности Alfresco через Spring Boot Actuator.</p>
     * <p><strong>EN:</strong> Settings for Alfresco reachability checks through Spring Boot Actuator.</p>
     */
    public static class Health {
        private boolean enabled = true;
        /** RU: Создаёт health-настройки по умолчанию. EN: Creates default health settings. */
        public Health() {}
        /** @return RU: включена ли регистрация health indicator. EN: whether health indicator registration is enabled. */
        public boolean isEnabled() { return enabled; }
        /** @param enabled RU: включить или выключить health indicator. EN: enable or disable the health indicator. */
        public void setEnabled(boolean enabled) { this.enabled = enabled; }
    }

    /**
     * <p><strong>RU:</strong> Настройки bounded exponential backoff для безопасных HTTP read-операций.</p>
     * <p><strong>EN:</strong> Bounded exponential-backoff settings for safe HTTP read operations.</p>
     */
    public static class Retry {

        /** RU: Создаёт retry-настройки со значениями по умолчанию. EN: Creates retry settings with defaults. */
        public Retry() {
        }
        /**
         * <p><strong>RU:</strong> включает соответствующую политику.</p>
         * <p><strong>EN:</strong> enables the corresponding policy.</p>
         */
        private boolean enabled = true;
        /**
         * <p><strong>RU:</strong> максимальное общее число попыток, минимум 1.</p>
         * <p><strong>EN:</strong> maximum total number of attempts, at least 1.</p>
         */
        private int maxAttempts = 3;
        /**
         * <p><strong>RU:</strong> начальная задержка exponential backoff.</p>
         * <p><strong>EN:</strong> initial exponential-backoff delay.</p>
         */
        private Duration initialDelay = Duration.ofMillis(200);
        /**
         * <p><strong>RU:</strong> верхняя граница задержки между попытками.</p>
         * <p><strong>EN:</strong> upper bound for delay between attempts.</p>
         */
        private Duration maxDelay = Duration.ofSeconds(2);

                /**
         * <p><strong>RU:</strong> Возвращает включает соответствующую политику.</p>
         * <p><strong>EN:</strong> Returns enables the corresponding policy.</p>
         *
         * @return RU: текущее значение настройки. EN: current setting value.
         */

        public boolean isEnabled() { return enabled; }
                /**
         * <p><strong>RU:</strong> Устанавливает включает соответствующую политику.</p>
         * <p><strong>EN:</strong> Sets enables the corresponding policy.</p>
         *
         * @param enabled RU: новое значение настройки. EN: new setting value.
         */

        public void setEnabled(boolean enabled) { this.enabled = enabled; }
                /**
         * <p><strong>RU:</strong> Возвращает максимальное общее число попыток, минимум 1.</p>
         * <p><strong>EN:</strong> Returns maximum total number of attempts, at least 1.</p>
         *
         * @return RU: текущее значение настройки. EN: current setting value.
         */

        public int getMaxAttempts() { return maxAttempts; }
                /**
         * <p><strong>RU:</strong> Устанавливает максимальное общее число попыток, минимум 1.</p>
         * <p><strong>EN:</strong> Sets maximum total number of attempts, at least 1.</p>
         *
         * @param maxAttempts RU: новое значение настройки. EN: new setting value.
         */

        public void setMaxAttempts(int maxAttempts) { this.maxAttempts = Math.max(1, maxAttempts); }
                /**
         * <p><strong>RU:</strong> Возвращает начальная задержка exponential backoff.</p>
         * <p><strong>EN:</strong> Returns initial exponential-backoff delay.</p>
         *
         * @return RU: текущее значение настройки. EN: current setting value.
         */

        public Duration getInitialDelay() { return initialDelay; }
                /**
         * <p><strong>RU:</strong> Устанавливает начальная задержка exponential backoff.</p>
         * <p><strong>EN:</strong> Sets initial exponential-backoff delay.</p>
         *
         * @param initialDelay RU: новое значение настройки. EN: new setting value.
         */

        public void setInitialDelay(Duration initialDelay) { this.initialDelay = initialDelay == null ? Duration.ZERO : initialDelay; }
                /**
         * <p><strong>RU:</strong> Возвращает верхняя граница задержки между попытками.</p>
         * <p><strong>EN:</strong> Returns upper bound for delay between attempts.</p>
         *
         * @return RU: текущее значение настройки. EN: current setting value.
         */

        public Duration getMaxDelay() { return maxDelay; }
                /**
         * <p><strong>RU:</strong> Устанавливает верхняя граница задержки между попытками.</p>
         * <p><strong>EN:</strong> Sets upper bound for delay between attempts.</p>
         *
         * @param maxDelay RU: новое значение настройки. EN: new setting value.
         */

        public void setMaxDelay(Duration maxDelay) { this.maxDelay = maxDelay == null ? Duration.ZERO : maxDelay; }
    }

    /**
     * <p><strong>RU:</strong> Настройки безопасного диагностического HTTP-логирования без credentials и bodies.</p>
     * <p><strong>EN:</strong> Settings for safe diagnostic HTTP logging without credentials or bodies.</p>
     */
    public static class Diagnostics {

        /** RU: Создаёт diagnostics-настройки со значениями по умолчанию. EN: Creates diagnostics settings with defaults. */
        public Diagnostics() {
        }
        /**
         * <p><strong>RU:</strong> включает соответствующую политику.</p>
         * <p><strong>EN:</strong> enables the corresponding policy.</p>
         */
        private boolean enabled = false;
                /**
         * <p><strong>RU:</strong> Возвращает включает соответствующую политику.</p>
         * <p><strong>EN:</strong> Returns enables the corresponding policy.</p>
         *
         * @return RU: текущее значение настройки. EN: current setting value.
         */

        public boolean isEnabled() { return enabled; }
                /**
         * <p><strong>RU:</strong> Устанавливает включает соответствующую политику.</p>
         * <p><strong>EN:</strong> Sets enables the corresponding policy.</p>
         *
         * @param enabled RU: новое значение настройки. EN: new setting value.
         */

        public void setEnabled(boolean enabled) { this.enabled = enabled; }
    }
}

