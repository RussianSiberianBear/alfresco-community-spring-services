package pro.abgrid.alfresco.integration;

import pro.abgrid.alfresco.dto.core.CategoryEntry;
import pro.abgrid.alfresco.dto.core.NodeEntry;
import pro.abgrid.alfresco.model.UploadRequest;
import pro.abgrid.alfresco.service.association.AlfrescoAssociationService;
import pro.abgrid.alfresco.service.category.AlfrescoCategoryService;
import pro.abgrid.alfresco.service.content.AlfrescoContentService;
import pro.abgrid.alfresco.service.query.AlfrescoQueryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = AlfrescoAssociationCategoryQueryIntegrationTest.TestApp.class)
class AlfrescoAssociationCategoryQueryIntegrationTest extends AlfrescoIntegrationTestBase {
    private static final String ROOT = "-root-";
    private static final String REFERENCES = "cm:references";

    @Autowired AlfrescoContentService content;
    @Autowired AlfrescoAssociationService associations;
    @Autowired AlfrescoCategoryService categories;
    @Autowired AlfrescoQueryService queries;

    @Test
    void associationsCategoriesAndQueriesLifecycle() {
        String suffix = UUID.randomUUID().toString().replace("-", "").substring(0, 12);
        String folderId = content.createFolder(ROOT, "alfresco-relations-it-" + suffix).getEntry().getId();
        String sourceId = null;
        String targetId = null;
        String categoryId = null;
        boolean associationCreated = false;
        boolean categoryAssigned = false;

        try {
            NodeEntry source = content.upload(new UploadRequest(
                    folderId,
                    "source-" + suffix + ".txt",
                    "source association document".getBytes(StandardCharsets.UTF_8)
            ));
            NodeEntry target = content.upload(new UploadRequest(
                    folderId,
                    "target-" + suffix + ".txt",
                    "target association document".getBytes(StandardCharsets.UTF_8)
            ));
            sourceId = source.getEntry().getId();
            targetId = target.getEntry().getId();
            final String sourceNodeId = sourceId;
            final String targetNodeId = targetId;

            var createdAssociation = associations.create(sourceNodeId, targetNodeId, REFERENCES);
            associationCreated = true;
            assertThat(createdAssociation.getEntry()).isNotNull();
            assertThat(createdAssociation.getEntry().getTargetId()).isEqualTo(targetId);
            assertThat(createdAssociation.getEntry().getAssocType()).isEqualTo(REFERENCES);

            var targets = associations.targets(sourceNodeId, REFERENCES, 0, 100);
            assertThat(targets.entries()).anyMatch(a -> targetNodeId.equals(a.getId()));
            var sources = associations.sources(targetNodeId, REFERENCES, 0, 100);
            assertThat(sources.entries()).anyMatch(a -> sourceNodeId.equals(a.getId()));

            CategoryEntry createdCategory = categories.createRoot("spring-sdk-" + suffix);
            assertThat(createdCategory.getEntry()).isNotNull();
            categoryId = createdCategory.getEntry().getId();
            final String createdCategoryId = categoryId;
            assertThat(createdCategory.getEntry().getName()).isEqualTo("spring-sdk-" + suffix);

            CategoryEntry renamed = categories.update(createdCategoryId, "spring-sdk-renamed-" + suffix);
            assertThat(renamed.getEntry().getName()).isEqualTo("spring-sdk-renamed-" + suffix);
            assertThat(categories.get(createdCategoryId).getEntry().getId()).isEqualTo(createdCategoryId);
            assertThat(categories.roots(0, 100).entries()).anyMatch(c -> createdCategoryId.equals(c.getId()));

            CategoryEntry assigned = categories.assign(sourceNodeId, createdCategoryId);
            categoryAssigned = true;
            assertThat(assigned.getEntry()).isNotNull();
            assertThat(assigned.getEntry().getId()).isEqualTo(createdCategoryId);
            assertThat(categories.categoriesForNode(sourceNodeId, 0, 100).entries())
                    .anyMatch(c -> createdCategoryId.equals(c.getId()));

            var people = queries.findPeople("admin", 0, 100);
            assertThat(people.entries()).anyMatch(p -> "admin".equals(p.getId()));

            associations.delete(sourceNodeId, targetNodeId, REFERENCES);
            associationCreated = false;
            assertThat(associations.targets(sourceNodeId, REFERENCES, 0, 100).entries())
                    .noneMatch(a -> targetNodeId.equals(a.getId()));

            categories.unassign(sourceNodeId, createdCategoryId);
            categoryAssigned = false;
            assertThat(categories.categoriesForNode(sourceNodeId, 0, 100).entries())
                    .noneMatch(c -> createdCategoryId.equals(c.getId()));
        } finally {
            if (sourceId != null && targetId != null && associationCreated) {
                try { associations.delete(sourceId, targetId, REFERENCES); } catch (RuntimeException ignored) { }
            }
            if (sourceId != null && categoryId != null && categoryAssigned) {
                try { categories.unassign(sourceId, categoryId); } catch (RuntimeException ignored) { }
            }
            if (categoryId != null) {
                try { categories.delete(categoryId); } catch (RuntimeException ignored) { }
            }
            content.deletePermanently(folderId);
        }
    }

    @SpringBootApplication
    @ComponentScan(basePackages = "pro.abgrid.alfresco")
    static class TestApp {}
}
