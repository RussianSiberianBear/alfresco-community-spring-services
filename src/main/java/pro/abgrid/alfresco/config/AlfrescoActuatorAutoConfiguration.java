package pro.abgrid.alfresco.config;

import pro.abgrid.alfresco.api.DiscoveryApi;
import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

/**
 * <p><strong>RU:</strong> Опциональная интеграция с Spring Boot Actuator. Конфигурация активируется только когда Actuator присутствует в приложении и {@code alfresco.health.enabled} не установлен в {@code false}.</p>
 * <p><strong>EN:</strong> Optional Spring Boot Actuator integration. It is activated only when Actuator is present and {@code alfresco.health.enabled} is not set to {@code false}.</p>
 */
@AutoConfiguration(after = AlfrescoAutoConfiguration.class)
@ConditionalOnClass(name = "org.springframework.boot.health.actuate.endpoint.HealthEndpoint")
@ConditionalOnProperty(prefix = "alfresco.health", name = "enabled", havingValue = "true", matchIfMissing = true)
public class AlfrescoActuatorAutoConfiguration {

    /** RU: Создаёт контейнер опциональной auto-configuration. EN: Creates the optional auto-configuration container. */
    public AlfrescoActuatorAutoConfiguration() {
    }

    /**
     * <p><strong>RU:</strong> Регистрирует индикатор, который выполняет лёгкий Discovery-запрос к Alfresco и сообщает реальную доступность репозитория.</p>
     * <p><strong>EN:</strong> Registers an indicator that performs a lightweight Alfresco Discovery request and reports actual repository reachability.</p>
     *
     * @param discoveryApi RU: Discovery HTTP client. EN: Discovery HTTP client.
     * @return RU: Actuator health indicator для Alfresco. EN: Actuator health indicator for Alfresco.
     */
    @Bean(name = "alfrescoHealthIndicator")
    @ConditionalOnMissingBean(name = "alfrescoHealthIndicator")
    HealthIndicator alfrescoHealthIndicator(DiscoveryApi discoveryApi) {
        return () -> {
            try {
                discoveryApi.getRepositoryInformation();
                return Health.up().withDetail("repository", "reachable").build();
            } catch (Exception ex) {
                return Health.down().withDetail("repository", "unreachable")
                        .withDetail("error", ex.getClass().getSimpleName())
                        .build();
            }
        };
    }
}
