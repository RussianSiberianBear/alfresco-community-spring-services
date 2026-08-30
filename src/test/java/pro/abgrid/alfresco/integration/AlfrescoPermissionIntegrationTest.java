package pro.abgrid.alfresco.integration;

import pro.abgrid.alfresco.dto.core.NodeEntry;
import pro.abgrid.alfresco.model.PermissionGrant;
import pro.abgrid.alfresco.model.PermissionSnapshot;
import pro.abgrid.alfresco.model.UploadRequest;
import pro.abgrid.alfresco.service.content.AlfrescoContentService;
import pro.abgrid.alfresco.service.permission.AlfrescoPermissionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = AlfrescoPermissionIntegrationTest.TestApp.class)
class AlfrescoPermissionIntegrationTest extends AlfrescoIntegrationTestBase {
    private static final String COMPANY_HOME = "-root-";
    private static final String AUTHORITY = "GROUP_EVERYONE";
    private static final String PERMISSION = "Consumer";

    @Autowired AlfrescoContentService content;
    @Autowired AlfrescoPermissionService permissions;

    @Test
    void grantRevokeAndInheritancePreserveAcl() {
        NodeEntry folder = content.createFolder(COMPANY_HOME,
                "alfresco-community-spring-services-permission-it-" + System.currentTimeMillis());
        String folderId = folder.getEntry().getId();
        String nodeId = null;
        try {
            NodeEntry uploaded = content.upload(new UploadRequest(
                    folderId, "acl-test.txt", "ACL test".getBytes(StandardCharsets.UTF_8),
                    "cm:content", null, null, null, false, false));
            nodeId = uploaded.getEntry().getId();

            PermissionSnapshot initial = permissions.get(nodeId);
            permissions.grant(nodeId, AUTHORITY, PERMISSION);
            PermissionSnapshot granted = permissions.get(nodeId);
            assertThat(granted.locallySet()).anyMatch(this::isExpectedGrant);

            permissions.disableInheritance(nodeId);
            PermissionSnapshot noInheritance = permissions.get(nodeId);
            assertThat(noInheritance.inheritanceEnabled()).isFalse();
            assertThat(noInheritance.locallySet()).anyMatch(this::isExpectedGrant);

            permissions.enableInheritance(nodeId);
            PermissionSnapshot inheritedAgain = permissions.get(nodeId);
            assertThat(inheritedAgain.inheritanceEnabled()).isTrue();
            assertThat(inheritedAgain.locallySet()).anyMatch(this::isExpectedGrant);

            permissions.revoke(nodeId, AUTHORITY, PERMISSION);
            PermissionSnapshot revoked = permissions.get(nodeId);
            assertThat(revoked.locallySet()).noneMatch(this::isExpectedGrant);

            // Restore original inheritance flag in case a server has non-default repository rules.
            permissions.setInheritance(nodeId, initial.inheritanceEnabled());
        } finally {
            if (nodeId != null) content.delete(nodeId);
            content.deletePermanently(folderId);
        }
    }

    private boolean isExpectedGrant(PermissionGrant grant) {
        return AUTHORITY.equals(grant.authorityId())
                && PERMISSION.equals(grant.permission())
                && "ALLOWED".equalsIgnoreCase(grant.accessStatus());
    }

    @SpringBootApplication
    @ComponentScan(basePackages = "pro.abgrid.alfresco")
    static class TestApp {}
}
