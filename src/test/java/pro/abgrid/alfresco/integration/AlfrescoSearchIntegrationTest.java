package pro.abgrid.alfresco.integration;

import pro.abgrid.alfresco.dto.core.NodeEntry;
import pro.abgrid.alfresco.model.UploadRequest;
import pro.abgrid.alfresco.model.search.SearchCriteria;
import pro.abgrid.alfresco.service.content.AlfrescoContentService;
import pro.abgrid.alfresco.service.search.AlfrescoSearchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = AlfrescoSearchIntegrationTest.TestApp.class)
class AlfrescoSearchIntegrationTest extends AlfrescoIntegrationTestBase {
    @Autowired AlfrescoContentService content;
    @Autowired AlfrescoSearchService search;

    @Test
    void aftsAndTypedDslWorkAgainstLiveSearchApi() {
        String folder = content.createFolder("-root-", "alfresco-search-it-" + System.currentTimeMillis()).getEntry().getId();
        String uniqueName = "search-me-" + System.currentTimeMillis() + ".txt";
        try {
            NodeEntry uploaded = content.upload(new UploadRequest(folder, uniqueName, "search".getBytes()));

            // Preserve the original raw API path.
            var raw = search.afts("cm:name:'" + uniqueName + "'", 0, 10);
            assertThat(raw.result().getList()).isNotNull();

            // Exercise the 2.11 fluent request builder with combined structural clauses.
            var request = search.request(new SearchCriteria()
                    .afts("cm:name:'" + uniqueName + "'")
                    .folder(folder)
                    .mimeType("text/plain")
                    .include("properties")
                    .fields("id", "name", "content", "properties")
                    .sortBy("cm:name", true)
                    .page(0)
                    .size(10));
            assertThat(request.getQuery().getQuery()).contains("AND", "PARENT:", "content.mimetype");
            assertThat(request.getPaging().getMaxItems()).isEqualTo(10);
            assertThat(request.getInclude()).contains("properties");
            assertThat(request.getFields()).contains("id", "name");
            assertThat(request.getSort()).hasSize(1);

            // Use a stable repository-wide query to verify typed response extraction independently
            // from the indexing latency of the document uploaded a few milliseconds above.
            var typed = search.find(new SearchCriteria().nodeType("cm:folder").page(0).size(5));
            assertThat(typed.entries()).isNotNull();
            assertThat(typed.pagination()).isNotNull();
            assertThat(typed.entries()).allSatisfy(hit -> {
                assertThat(hit.id()).isNotBlank();
                assertThat(hit.folder()).isTrue();
                assertThat(hit.raw()).isNotNull();
            });
        } finally {
            content.deletePermanently(folder);
        }
    }

    @SpringBootApplication
    @ComponentScan(basePackages = "pro.abgrid.alfresco")
    static class TestApp {}
}
