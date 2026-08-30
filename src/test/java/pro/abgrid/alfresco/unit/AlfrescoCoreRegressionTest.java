package pro.abgrid.alfresco.unit;

import pro.abgrid.alfresco.config.AlfrescoProperties;
import pro.abgrid.alfresco.exception.AlfrescoApiException;
import pro.abgrid.alfresco.exception.AlfrescoErrorDetails;
import pro.abgrid.alfresco.model.AlfrescoConnectionInfo;
import pro.abgrid.alfresco.service.AlfrescoInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import java.net.URI;
import static org.assertj.core.api.Assertions.assertThat;

class AlfrescoCoreRegressionTest {
    @Test void connectionInfoNeverExposesPassword(){
        AlfrescoProperties p=new AlfrescoProperties(); p.setUrl("http://localhost:8082"); p.setUsername("admin"); p.setPassword("top-secret");
        AlfrescoConnectionInfo info=new AlfrescoInfoService(p).connectionInfo();
        assertThat(info.credentialsConfigured()).isTrue();
        assertThat(info.toString()).doesNotContain("top-secret");
    }
    @Test void apiExceptionClassifiesCommonStatuses(){
        AlfrescoErrorDetails d=new AlfrescoErrorDetails(); d.setErrorKey("framework.exception.EntityNotFound"); d.setBriefSummary("Entity was not found");
        AlfrescoApiException ex=new AlfrescoApiException(HttpStatus.NOT_FOUND,"{}",HttpMethod.GET,URI.create("http://localhost/nodes/missing"),d);
        assertThat(ex.isNotFound()).isTrue(); assertThat(ex.isRetryableStatus()).isFalse();
        assertThat(ex.getErrorKey()).isEqualTo("framework.exception.EntityNotFound");
        assertThat(ex.getMessage()).contains("GET").contains("Entity was not found");
    }
}
