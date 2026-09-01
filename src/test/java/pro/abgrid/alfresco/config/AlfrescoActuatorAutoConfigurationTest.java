package pro.abgrid.alfresco.config;

import pro.abgrid.alfresco.api.DiscoveryApi;
import org.junit.jupiter.api.Test;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.boot.health.contributor.Status;

import static org.assertj.core.api.Assertions.assertThat;

class AlfrescoActuatorAutoConfigurationTest {

    @Test
    void reportsUpWhenDiscoveryCallSucceeds() {
        DiscoveryApi discovery = () -> null;
        HealthIndicator indicator = new AlfrescoActuatorAutoConfiguration().alfrescoHealthIndicator(discovery);

        assertThat(indicator.health().getStatus()).isEqualTo(Status.UP);
        assertThat(indicator.health().getDetails()).containsEntry("repository", "reachable");
    }

    @Test
    void reportsDownWithoutLeakingExceptionMessage() {
        DiscoveryApi discovery = () -> { throw new IllegalStateException("secret detail"); };
        HealthIndicator indicator = new AlfrescoActuatorAutoConfiguration().alfrescoHealthIndicator(discovery);

        assertThat(indicator.health().getStatus()).isEqualTo(Status.DOWN);
        assertThat(indicator.health().getDetails())
                .containsEntry("repository", "unreachable")
                .containsEntry("error", "IllegalStateException")
                .doesNotContainValue("secret detail");
    }
}
