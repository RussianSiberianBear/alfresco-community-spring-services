package pro.abgrid.alfresco.api;

import pro.abgrid.alfresco.dto.auth.TicketBody;
import pro.abgrid.alfresco.dto.auth.TicketEntry;
import pro.abgrid.alfresco.dto.auth.ValidTicketEntry;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * <p><strong>RU:</strong> Низкоуровневый HTTP-интерфейс AuthenticationApi отображает операции Alfresco REST API на Spring HTTP Service. В обычном прикладном коде предпочтительнее high-level сервисы; этот интерфейс нужен для параметров и endpoint, не покрытых удобной обёрткой.</p>
 * <p><strong>EN:</strong> Low-level HTTP interface AuthenticationApi maps Alfresco REST operations to Spring HTTP Service methods. Application code will normally prefer high-level services; use this interface for endpoint-level control or operations without a high-level wrapper.</p>
 * <p><strong>RU:</strong> HTTP-ошибки преобразуются общей конфигурацией клиента в AlfrescoApiException.</p>
 * <p><strong>EN:</strong> HTTP errors are converted by the shared client configuration into AlfrescoApiException.</p>
 */
public interface AuthenticationApi {

        /**
     * <p><strong>RU:</strong> Создаёт ресурс или связь в Alfresco. Метод напрямую отражает REST-контракт и принимает generated DTO тела запроса.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Logs in and returns the new authentication ticket. The userId and password properties are mandatory in the request body. For example: JSON { "userId": "jbloggs", "password": "password" } To use the ticket in future requests you should pass it in the request header. For example using Javascript: Javascript request.setRequestHeader ("Authorization", "Basic " + btoa(ticket));</p>
     * <p><strong>REST:</strong> POST /tickets; operationId: createTicket.</p>
     *
     * @param ticketBodyCreate RU: тело REST-запроса с данными операции; обязательные поля определяются соответствующим DTO. Обязательный параметр. EN: The user credential.. Required.
     * @return RU: ответ Alfresco для createTicket в generated-модели TicketEntry. EN: Alfresco response for createTicket represented as TicketEntry.
     */

    @PostExchange(url = "/tickets")
    TicketEntry createTicket(@RequestBody TicketBody ticketBodyCreate);

        /**
     * <p><strong>RU:</strong> Выполняет низкоуровневую REST-операцию GET /tickets/-me- Alfresco и сохраняет полный контроль над параметрами endpoint.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Validates the specified ticket (derived from Authorization header) is still valid. For example, you can pass the Authorization request header using Javascript: Javascript request.setRequestHeader ("Authorization", "Basic " + btoa(ticket));</p>
     * <p><strong>REST:</strong> GET /tickets/-me-; operationId: validateTicket.</p>
     * @return RU: ответ Alfresco для validateTicket в generated-модели ValidTicketEntry. EN: Alfresco response for validateTicket represented as ValidTicketEntry.
     */

    @GetExchange(url = "/tickets/-me-")
    ValidTicketEntry validateTicket();

        /**
     * <p><strong>RU:</strong> Удаляет ресурс или связь через Alfresco REST API; обратимость зависит от конкретной операции и её параметров.</p>
     * <p><strong>EN:</strong> Note: this endpoint is available in Alfresco 5.2 and newer versions. Deletes logged in ticket (logout).</p>
     * <p><strong>REST:</strong> DELETE /tickets/-me-; operationId: deleteTicket.</p>
     */

    @DeleteExchange(url = "/tickets/-me-")
    Void deleteTicket();
}
