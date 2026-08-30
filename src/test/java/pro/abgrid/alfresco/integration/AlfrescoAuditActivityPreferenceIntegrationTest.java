package pro.abgrid.alfresco.integration;

import pro.abgrid.alfresco.dto.core.AuditApp;
import pro.abgrid.alfresco.dto.core.PreferenceEntry;
import pro.abgrid.alfresco.model.PageSlice;
import pro.abgrid.alfresco.service.activity.AlfrescoActivityService;
import pro.abgrid.alfresco.service.audit.AlfrescoAuditService;
import pro.abgrid.alfresco.service.preference.AlfrescoPreferenceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = AlfrescoAuditActivityPreferenceIntegrationTest.TestApp.class)
class AlfrescoAuditActivityPreferenceIntegrationTest extends AlfrescoIntegrationTestBase {

    @Autowired AlfrescoAuditService audit;
    @Autowired AlfrescoActivityService activities;
    @Autowired AlfrescoPreferenceService preferences;

    @Test
    void auditActivitiesAndPreferencesAreAccessible() {
        PageSlice<AuditApp> apps = audit.applicationPage(0, 100);
        assertThat(apps.entries()).isNotNull();
        if (!apps.entries().isEmpty()) {
            AuditApp first = apps.entries().getFirst();
            assertThat(first.getId()).isNotBlank();
            AuditApp loaded = audit.application(first.getId());
            assertThat(loaded.getId()).isEqualTo(first.getId());
            assertThat(audit.entryPage(first.getId(), 0, 25).entries()).isNotNull();
        }

        assertThat(activities.mine(0, 25).entries()).isNotNull();

        String name = "alfresco.spring.services.it." +
                UUID.randomUUID().toString().replace("-", "");
        String value = "value-" + UUID.randomUUID();

        PreferenceEntry updated = preferences.putMine(name, value);
        assertThat(updated.getEntry()).isNotNull();
        assertThat(updated.getEntry().getId()).isEqualTo(name);
        assertThat(updated.getEntry().getValue()).isEqualTo(value);

        PreferenceEntry loaded = preferences.getMine(name);
        assertThat(loaded.getEntry().getId()).isEqualTo(name);
        assertThat(loaded.getEntry().getValue()).isEqualTo(value);

        assertThat(preferences.mine(0, 100).entries())
                .anyMatch(preference -> name.equals(preference.getId()) && value.equals(preference.getValue()));
    }

    @SpringBootApplication
    @ComponentScan(basePackages = "pro.abgrid.alfresco")
    static class TestApp {}
}
