package pro.abgrid.alfresco.config;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AlfrescoAutoConfigurationTest {

    @Test
    void derivesAllApiBaseUrlsFromSingleServerUrl() {
        assertThat(AlfrescoAutoConfiguration.resolveBaseUrl("http://localhost:8082/", "alfresco"))
                .isEqualTo("http://localhost:8082/alfresco/api/-default-/public/alfresco/versions/1");
        assertThat(AlfrescoAutoConfiguration.resolveBaseUrl("http://localhost:8082", "alfresco-auth"))
                .isEqualTo("http://localhost:8082/alfresco/api/-default-/public/authentication/versions/1");
        assertThat(AlfrescoAutoConfiguration.resolveBaseUrl("https://example.org", "alfresco-search"))
                .isEqualTo("https://example.org/alfresco/api/-default-/public/search/versions/1");
        assertThat(AlfrescoAutoConfiguration.resolveBaseUrl("https://example.org/", "alfresco-discovery"))
                .isEqualTo("https://example.org/alfresco/api");
    }

    @Test
    void rejectsRelativeServerUrl() {
        assertThatThrownBy(() -> AlfrescoAutoConfiguration.resolveBaseUrl("localhost:8082", "alfresco"))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("http or https");
    }
}
