package pro.abgrid.alfresco.integration;

import pro.abgrid.alfresco.dto.core.Node;
import pro.abgrid.alfresco.dto.core.NodeEntry;
import pro.abgrid.alfresco.dto.core.VersionPaging;
import pro.abgrid.alfresco.model.UploadRequest;
import pro.abgrid.alfresco.model.VersionRequest;
import pro.abgrid.alfresco.service.content.AlfrescoContentService;
import pro.abgrid.alfresco.service.metadata.AlfrescoMetadataService;
import pro.abgrid.alfresco.service.version.AlfrescoVersionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = AlfrescoMetadataVersionIntegrationTest.TestApp.class)
class AlfrescoMetadataVersionIntegrationTest extends AlfrescoIntegrationTestBase {
    private static final String COMPANY_HOME = "-root-";

    @Autowired
    AlfrescoContentService content;

    @Autowired
    AlfrescoMetadataService metadata;

    @Autowired
    AlfrescoVersionService versions;

    @Test
    void metadataAspectsAndVersionHistory() {
        String folderName = "alfresco-community-spring-services-metadata-version-it-" + System.currentTimeMillis();
        NodeEntry folder = content.createFolder(COMPANY_HOME, folderName);
        String folderId = folder.getEntry().getId();
        byte[] first = "Version one".getBytes(StandardCharsets.UTF_8);
        byte[] second = "Version two".getBytes(StandardCharsets.UTF_8);

        try {
            NodeEntry uploaded = content.upload(new UploadRequest(
                    folderId,
                    "versioned-document.txt",
                    first,
                    "cm:content",
                    null,
                    null,
                    null,
                    false,
                    true
            ));
            String nodeId = uploaded.getEntry().getId();

            metadata.addAspect(nodeId, "cm:titled");
            metadata.updateProperties(nodeId, Map.of(
                    "cm:title", "Integration test document",
                    "cm:description", "Metadata and versioning test"
            ));

            Node node = metadata.get(nodeId);
            assertThat(node.getAspectNames()).contains("cm:titled");
            assertThat(node.getProperties()).containsEntry("cm:title", "Integration test document");
            assertThat(node.getProperties()).containsEntry("cm:description", "Metadata and versioning test");

            versions.updateContent(nodeId, second, VersionRequest.major("Integration test major version"));

            VersionPaging history = versions.history(nodeId, 0, 100);
            assertThat(history).isNotNull();
            assertThat(history.getList()).isNotNull();
            assertThat(content.download(nodeId).content()).isEqualTo(second);

            content.delete(nodeId);
        } finally {
            content.deletePermanently(folderId);
        }
    }

    @SpringBootApplication
    @ComponentScan(basePackages = "pro.abgrid.alfresco")
    static class TestApp {
    }
}
