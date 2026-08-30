package pro.abgrid.alfresco.integration;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

/** Base configuration for tests against a real Alfresco Community instance.
 *
 * Set ALFRESCO_TEST_URL, ALFRESCO_TEST_USERNAME and ALFRESCO_TEST_PASSWORD.
 * Tests are skipped when ALFRESCO_TEST_URL is absent.
 */
public abstract class AlfrescoIntegrationTestBase {
    protected static final String URL = env("ALFRESCO_TEST_URL", "");
    protected static final String USERNAME = env("ALFRESCO_TEST_USERNAME", "admin");
    protected static final String PASSWORD = env("ALFRESCO_TEST_PASSWORD", "admin");

    @DynamicPropertySource
    static void alfrescoProperties(DynamicPropertyRegistry r) {
        r.add("alfresco.url", () -> URL);
        r.add("alfresco.username", () -> USERNAME);
        r.add("alfresco.password", () -> PASSWORD);
    }

    @BeforeAll
    static void requireServer() {
        org.junit.jupiter.api.Assumptions.assumeTrue(!URL.isBlank(),
                "Set ALFRESCO_TEST_URL to run Alfresco integration tests");
    }

    private static String env(String name, String fallback) {
        String value = System.getenv(name);
        return value == null || value.isBlank() ? fallback : value;
    }
}
