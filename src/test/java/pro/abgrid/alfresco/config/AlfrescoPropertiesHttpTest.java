package pro.abgrid.alfresco.config;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AlfrescoPropertiesHttpTest {

    @Test
    void httpDefaultsAreProductionSafeAndConfigurable() {
        AlfrescoProperties properties = new AlfrescoProperties();

        assertThat(properties.getHttp().getConnectTimeout()).isEqualTo(Duration.ofSeconds(5));
        assertThat(properties.getHttp().getReadTimeout()).isEqualTo(Duration.ofSeconds(30));
        assertThat(properties.getHttp().getStreamingReadTimeout()).isEqualTo(Duration.ofMinutes(10));
        assertThat(properties.getHealth().isEnabled()).isTrue();

        properties.getHttp().setConnectTimeout(Duration.ofSeconds(2));
        properties.getHttp().setReadTimeout(Duration.ofMinutes(2));
        properties.getHttp().setStreamingReadTimeout(Duration.ofMinutes(20));
        properties.getHealth().setEnabled(false);

        assertThat(properties.getHttp().getConnectTimeout()).isEqualTo(Duration.ofSeconds(2));
        assertThat(properties.getHttp().getReadTimeout()).isEqualTo(Duration.ofMinutes(2));
        assertThat(properties.getHttp().getStreamingReadTimeout()).isEqualTo(Duration.ofMinutes(20));
        assertThat(properties.getHealth().isEnabled()).isFalse();
    }

    @Test
    void rejectsNonPositiveHttpTimeouts() {
        AlfrescoProperties.Http http = new AlfrescoProperties.Http();

        assertThatThrownBy(() -> http.setConnectTimeout(Duration.ZERO))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("connect-timeout");
        assertThatThrownBy(() -> http.setReadTimeout(Duration.ofSeconds(-1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("read-timeout");
        assertThatThrownBy(() -> http.setStreamingReadTimeout(Duration.ZERO))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("streaming-read-timeout");
    }
}
