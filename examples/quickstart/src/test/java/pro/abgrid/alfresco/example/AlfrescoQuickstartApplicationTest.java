package pro.abgrid.alfresco.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
        "alfresco.url=http://localhost:8082",
        "alfresco.username=test-user",
        "alfresco.password=test-password"
})
class AlfrescoQuickstartApplicationTest {

    @Test
    void contextLoads() {
        // Verifies that the consumer application starts with only the public alfresco.* configuration.
    }
}
