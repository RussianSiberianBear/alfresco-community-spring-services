package pro.abgrid.alfresco.service;

import pro.abgrid.alfresco.config.AlfrescoProperties;
import pro.abgrid.alfresco.model.AlfrescoConnectionInfo;
import org.springframework.stereotype.Service;

/**
 * <p><strong>RU:</strong> Высокоуровневый Spring-сервис для сценариев «info» в Alfresco. Он служит прикладной границей над generated REST API: принимает более удобные параметры, скрывает технические детали HTTP/DTO там, где для них есть high-level модель, и оставляет доступ к серверному результату, когда это необходимо. Сервис предназначен для внедрения как обычный Spring bean в бизнес-сервисы приложения.</p>
 * <p><strong>EN:</strong> High-level Spring service for Alfresco info scenarios. It acts as an application boundary over the generated REST API: it accepts application-friendly parameters, hides HTTP/DTO plumbing where a high-level model exists, and still exposes server results when required. The service is intended to be injected as a regular Spring bean into application business services.</p>
 */
@Service
public class AlfrescoInfoService {
    private final AlfrescoProperties properties;
        /**
     * <p><strong>RU:</strong> создаёт сервис и получает его зависимости через Spring DI; обычно этот конструктор не вызывается прикладным кодом напрямую.</p>
     * <p><strong>EN:</strong> creates the service with dependencies supplied by Spring DI; application code normally does not call this constructor directly.</p>
     *
     * @param properties RU: зависимость `properties`, используемая сервисом для выполнения операций Alfresco. EN: `properties` dependency used by the service to perform Alfresco operations.
     */

    public AlfrescoInfoService(AlfrescoProperties properties){this.properties=properties;}
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `connectionInfo` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `connectionInfo` operation against Alfresco while hiding generated REST-client details from application code.</p>
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public AlfrescoConnectionInfo connectionInfo(){
        return new AlfrescoConnectionInfo(properties.getUrl(), properties.getUsername(),
                hasText(properties.getUsername()) && hasText(properties.getPassword()),
                properties.getRetry().isEnabled(), properties.getRetry().getMaxAttempts(),
                properties.getDiagnostics().isEnabled());
    }
    private static boolean hasText(String value){return value!=null&&!value.isBlank();}
}
