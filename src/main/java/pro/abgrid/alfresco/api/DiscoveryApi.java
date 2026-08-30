package pro.abgrid.alfresco.api;

import pro.abgrid.alfresco.dto.discovery.DiscoveryEntry;
import org.springframework.web.service.annotation.GetExchange;

/**
 * <p><strong>RU:</strong> Низкоуровневый HTTP-интерфейс DiscoveryApi отображает операции Alfresco REST API на Spring HTTP Service. В обычном прикладном коде предпочтительнее high-level сервисы; этот интерфейс нужен для параметров и endpoint, не покрытых удобной обёрткой.</p>
 * <p><strong>EN:</strong> Low-level HTTP interface DiscoveryApi maps Alfresco REST operations to Spring HTTP Service methods. Application code will normally prefer high-level services; use this interface for endpoint-level control or operations without a high-level wrapper.</p>
 * <p><strong>RU:</strong> HTTP-ошибки преобразуются общей конфигурацией клиента в AlfrescoApiException.</p>
 * <p><strong>EN:</strong> HTTP errors are converted by the shared client configuration into AlfrescoApiException.</p>
 */
public interface DiscoveryApi {

        /**
     * <p><strong>RU:</strong> Получает актуальное состояние ресурса Alfresco через низкоуровневый REST endpoint. Используйте этот метод, когда нужен полный контроль над параметрами запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Retrieves the capabilities and detailed version information from the repository.</p>
     * <p><strong>REST:</strong> GET /discovery; operationId: getRepositoryInformation.</p>
     * @return RU: ответ Alfresco для getRepositoryInformation в generated-модели DiscoveryEntry. EN: Alfresco response for getRepositoryInformation represented as DiscoveryEntry.
     */

    @GetExchange(url = "/discovery")
    DiscoveryEntry getRepositoryInformation();
}
