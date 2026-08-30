package pro.abgrid.alfresco.api;

import pro.abgrid.alfresco.dto.core.ProbeEntry;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

/**
 * <p><strong>RU:</strong> Низкоуровневый HTTP-интерфейс ProbesApi отображает операции Alfresco REST API на Spring HTTP Service. В обычном прикладном коде предпочтительнее high-level сервисы; этот интерфейс нужен для параметров и endpoint, не покрытых удобной обёрткой.</p>
 * <p><strong>EN:</strong> Low-level HTTP interface ProbesApi maps Alfresco REST operations to Spring HTTP Service methods. Application code will normally prefer high-level services; use this interface for endpoint-level control or operations without a high-level wrapper.</p>
 * <p><strong>RU:</strong> HTTP-ошибки преобразуются общей конфигурацией клиента в AlfrescoApiException.</p>
 * <p><strong>EN:</strong> HTTP errors are converted by the shared client configuration into AlfrescoApiException.</p>
 */
public interface ProbesApi {

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 6.0 and newer versions. Returns a status of 200 to indicate success and 503 for failure. The readiness probe is normally only used to check repository startup. The liveness probe should then be used to check the repository is still responding to requests. Note: No authentication is required to call this endpoint.</p>
     * <p><strong>REST:</strong> GET /probes/{probeId}; operationId: getProbe.</p>
     *
     * @param probeId RU: значение параметра probeId для данной REST-операции. Обязательный параметр. EN: The name of the probe: * -ready- * -live-. Required.
     * @return RU: ответ Alfresco для getProbe в generated-модели ProbeEntry. EN: Alfresco response for getProbe represented as ProbeEntry.
     */

    @GetExchange(url = "/probes/{probeId}")
    ProbeEntry getProbe(@PathVariable("probeId") String probeId);
}
