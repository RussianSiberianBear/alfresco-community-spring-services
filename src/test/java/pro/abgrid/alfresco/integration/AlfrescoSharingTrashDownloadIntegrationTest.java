package pro.abgrid.alfresco.integration;

import pro.abgrid.alfresco.dto.core.DownloadEntry;
import pro.abgrid.alfresco.dto.core.NodeEntry;
import pro.abgrid.alfresco.dto.core.SharedLinkEntry;
import pro.abgrid.alfresco.model.UploadRequest;
import pro.abgrid.alfresco.service.content.AlfrescoContentService;
import pro.abgrid.alfresco.service.download.AlfrescoDownloadService;
import pro.abgrid.alfresco.service.shared.AlfrescoSharedLinkService;
import pro.abgrid.alfresco.service.trash.AlfrescoTrashService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = AlfrescoSharingTrashDownloadIntegrationTest.TestApp.class)
class AlfrescoSharingTrashDownloadIntegrationTest extends AlfrescoIntegrationTestBase {
    private static final String ROOT = "-root-";

    @Autowired AlfrescoContentService content;
    @Autowired AlfrescoSharedLinkService sharedLinks;
    @Autowired AlfrescoTrashService trash;
    @Autowired AlfrescoDownloadService downloads;

    @Test
    void sharedLinksTrashAndDownloadsLifecycle() {
        String suffix = UUID.randomUUID().toString().replace("-", "").substring(0, 12);
        String folderId = content.createFolder(ROOT, "alfresco-sharing-it-" + suffix).getEntry().getId();
        String firstId = null;
        String secondId = null;
        String sharedId = null;
        String downloadId = null;
        boolean firstInTrash = false;

        try {
            byte[] firstBytes = ("first-" + suffix).getBytes(StandardCharsets.UTF_8);
            byte[] secondBytes = ("second-" + suffix).getBytes(StandardCharsets.UTF_8);

            NodeEntry first = content.upload(new UploadRequest(folderId, "first-" + suffix + ".txt", firstBytes));
            NodeEntry second = content.upload(new UploadRequest(folderId, "second-" + suffix + ".txt", secondBytes));
            firstId = first.getEntry().getId();
            secondId = second.getEntry().getId();
            final String firstNodeId = firstId;

            SharedLinkEntry shared = sharedLinks.create(firstId);
            assertThat(shared.getEntry()).isNotNull();
            sharedId = shared.getEntry().getId();
            assertThat(shared.getEntry().getNodeId()).isEqualTo(firstId);
            assertThat(sharedLinks.get(sharedId).getEntry().getId()).isEqualTo(sharedId);
            assertThat(sharedLinks.content(sharedId)).isEqualTo(firstBytes);
            // ACS documents the shared-links list as eventually consistent.
            // The dedicated GET /shared-links/{id} above is the authoritative lifecycle check;
            // do not make this integration test depend on the search index refresh interval.

            sharedLinks.delete(sharedId);
            sharedId = null;

            content.delete(firstId);
            firstInTrash = true;
            assertThat(trash.get(firstId).getEntry().getId()).isEqualTo(firstId);
            assertThat(trash.content(firstId).content()).isEqualTo(firstBytes);
            assertThat(trash.page(0, 100).entries())
                    .anyMatch(node -> firstNodeId.equals(node.getId()));

            NodeEntry restored = trash.restore(firstId);
            firstInTrash = false;
            assertThat(restored.getEntry().getId()).isEqualTo(firstId);
            assertThat(content.download(firstId).content()).isEqualTo(firstBytes);

            DownloadEntry created = downloads.create(List.of(firstId, secondId));
            assertThat(created.getEntry()).isNotNull();
            downloadId = created.getEntry().getId();
            assertThat(downloadId).isNotBlank();

            DownloadEntry done = downloads.awaitDone(downloadId);
            assertThat(done.getEntry().getStatus()).isEqualToIgnoringCase("DONE");
            byte[] zip = downloads.content(downloadId).content();
            assertThat(zip).hasSizeGreaterThan(4);
            assertThat(zip[0]).isEqualTo((byte) 'P');
            assertThat(zip[1]).isEqualTo((byte) 'K');
        } finally {
            if (sharedId != null) {
                try { sharedLinks.delete(sharedId); } catch (RuntimeException ignored) { }
            }
            if (downloadId != null) {
                try { downloads.delete(downloadId); } catch (RuntimeException ignored) { }
            }
            if (firstInTrash && firstId != null) {
                try { trash.purge(firstId); } catch (RuntimeException ignored) { }
            }
            try { content.deletePermanently(folderId); } catch (RuntimeException ignored) { }
        }
    }

    @SpringBootApplication
    @ComponentScan(basePackages = "pro.abgrid.alfresco")
    static class TestApp {}
}
