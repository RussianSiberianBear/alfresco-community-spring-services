package pro.abgrid.alfresco.integration;

import pro.abgrid.alfresco.dto.core.GroupEntry;
import pro.abgrid.alfresco.dto.core.PersonBodyCreate;
import pro.abgrid.alfresco.dto.core.PersonBodyUpdate;
import pro.abgrid.alfresco.dto.core.PersonEntry;
import pro.abgrid.alfresco.dto.core.SiteEntry;
import pro.abgrid.alfresco.service.group.AlfrescoGroupService;
import pro.abgrid.alfresco.service.site.AlfrescoSiteService;
import pro.abgrid.alfresco.service.user.AlfrescoUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = AlfrescoIdentitySiteIntegrationTest.TestApp.class)
class AlfrescoIdentitySiteIntegrationTest extends AlfrescoIntegrationTestBase {
    @Autowired AlfrescoUserService users;
    @Autowired AlfrescoGroupService groups;
    @Autowired AlfrescoSiteService sites;

    @Test
    void userGroupAndSiteLifecycle() {
        String suffix = UUID.randomUUID().toString().replace("-", "").substring(0, 12);
        String personId = "spring_sdk_user_" + suffix;
        String groupShortId = "spring_sdk_" + suffix;
        String siteId = "spring-sdk-" + suffix;
        String createdGroupId = null;
        boolean siteCreated = false;

        // People API has create/update but no delete-person endpoint in the ACS REST API
        // used by this client. This integration user is intentionally left in the test ACS.
        PersonBodyCreate person = new PersonBodyCreate();
        person.setId(personId);
        person.setFirstName("Spring SDK");
        person.setLastName("Integration " + suffix);
        person.setEmail(personId + "@example.test");
        person.setPassword("SpringSdk-Test-" + suffix + "!Aa1");
        person.setEnabled(true);

        PersonEntry createdPerson = users.create(person);
        assertEquals(personId, createdPerson.getEntry().getId());
        assertEquals(personId, users.get(personId).getEntry().getId());

        PersonBodyUpdate update = new PersonBodyUpdate();
        update.setJobTitle("Alfresco Community Spring Services integration test");
        update.setLocation("Test ACS");
        PersonEntry updatedPerson = users.update(personId, update);
        assertEquals("Alfresco Community Spring Services integration test", updatedPerson.getEntry().getJobTitle());

        try {
            GroupEntry group = groups.create(groupShortId, "Spring SDK integration " + suffix);
            createdGroupId = group.getEntry().getId();
            assertTrue(createdGroupId.startsWith("GROUP_"));

            assertEquals(personId, groups.addPerson(createdGroupId, personId).getEntry().getId());
            assertNotNull(groups.members(createdGroupId, 0, 100));
            assertNotNull(users.groups(personId, 0, 100));

            SiteEntry site = sites.create(siteId, "Spring SDK integration " + suffix, "PRIVATE");
            siteCreated = true;
            assertEquals(siteId, site.getEntry().getId());

            assertNotNull(sites.addMember(siteId, personId, "SiteCollaborator"));
            assertEquals(personId, sites.member(siteId, personId).getEntry().getId());
            assertNotNull(users.sites(personId, 0, 100));

            assertNotNull(sites.addGroup(siteId, createdGroupId, "SiteConsumer"));
            assertNotNull(sites.groups(siteId, 0, 100));
            assertNotNull(sites.containers(siteId, 0, 100));

            assertNotNull(sites.changeRole(siteId, personId, "SiteContributor"));
            assertNotNull(sites.changeGroupRole(siteId, createdGroupId, "SiteCollaborator"));
        } finally {
            // Site and group lifecycle include delete endpoints, so verify/clean those resources.
            // The created person remains intentionally for inspection in the dedicated test ACS.
            if (siteCreated) {
                try { sites.delete(siteId, true); } catch (RuntimeException ignored) { }
            }
            if (createdGroupId != null) {
                try { groups.delete(createdGroupId, true); } catch (RuntimeException ignored) { }
            }
        }
    }

    @SpringBootApplication
    @ComponentScan(basePackages = "pro.abgrid.alfresco")
    static class TestApp {}
}
