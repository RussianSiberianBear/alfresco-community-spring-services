package pro.abgrid.alfresco.integration;

import pro.abgrid.alfresco.dto.core.NodeEntry;
import pro.abgrid.alfresco.exception.AlfrescoApiException;
import pro.abgrid.alfresco.model.ContentResource;
import pro.abgrid.alfresco.model.UploadRequest;
import pro.abgrid.alfresco.service.content.AlfrescoContentService;
import pro.abgrid.alfresco.service.AlfrescoClient;
import pro.abgrid.alfresco.service.AlfrescoInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest(classes = AlfrescoContentIntegrationTest.TestApp.class)
class AlfrescoContentIntegrationTest extends AlfrescoIntegrationTestBase {
    private static final String COMPANY_HOME = "-root-";

    @Autowired
    AlfrescoContentService content;

    @Autowired AlfrescoClient client;
    @Autowired AlfrescoInfoService info;

    @Test
    void uploadDownloadAndDelete() {
        String folderName = "alfresco-community-spring-services-it-" + System.currentTimeMillis();
        NodeEntry folder = content.createFolder(COMPANY_HOME, folderName);
        String folderId = folder.getEntry().getId();
        String fileName = "hello.txt";
        byte[] source = "Hello from alfresco-community-spring-services".getBytes(StandardCharsets.UTF_8);

        try {
            NodeEntry uploaded = content.upload(new UploadRequest(
                    folderId,
                    fileName,
                    source,
                    "cm:content",
                    java.util.List.of("cm:titled"),
                    Map.of(
                            "cm:title", "Integration upload",
                            "cm:description", "Created by alfresco-community-spring-services integration test"
                    ),
                    true,
                    true,
                    true
            ));
            String nodeId = uploaded.getEntry().getId();

            NodeEntry reloaded = content.get(nodeId);
            assertThat(reloaded.getEntry().getProperties())
                    .containsEntry("cm:title", "Integration upload")
                    .containsEntry("cm:description", "Created by alfresco-community-spring-services integration test");

            ContentResource downloaded = content.download(nodeId);
            assertThat(downloaded.content()).isEqualTo(source);
            assertThat(downloaded.filename()).isEqualTo(fileName);

            content.delete(nodeId);
        } finally {
            content.deletePermanently(folderId);
        }
    }


    @Test
    void stableFacadeAndSanitizedInfoAreAvailable() {
        assertThat(client.content()).isSameAs(content);
        assertThat(client.search()).isNotNull();
        assertThat(client.trash()).isNotNull();
        assertThat(info.connectionInfo().credentialsConfigured()).isTrue();
        assertThat(info.connectionInfo().username()).isEqualTo(USERNAME);
        assertThat(java.util.Arrays.stream(
                info.connectionInfo().getClass().getRecordComponents())
                .map(java.lang.reflect.RecordComponent::getName))
                .doesNotContain("password");
    }

    @Test
    void missingNodeExposesStructuredAlfrescoError() {
        String missingId = UUID.randomUUID().toString();

        assertThatThrownBy(() -> content.get(missingId))
                .isInstanceOfSatisfying(AlfrescoApiException.class, ex -> {
                    assertThat(ex.isNotFound()).isTrue();
                    assertThat(ex.getStatus().value()).isEqualTo(404);
                    assertThat(ex.getMethod()).isEqualTo(org.springframework.http.HttpMethod.GET);
                    assertThat(ex.getUri()).isNotNull();
                    assertThat(ex.getUri().toString()).contains(missingId);
                    assertThat(ex.getBriefSummary()).isNotBlank();
                    assertThat(ex.getResponseBody()).contains("error");
                });
    }

    @SpringBootApplication
    @ComponentScan(basePackages = "pro.abgrid.alfresco")
    static class TestApp {}
}
