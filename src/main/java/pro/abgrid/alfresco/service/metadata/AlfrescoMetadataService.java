package pro.abgrid.alfresco.service.metadata;

import pro.abgrid.alfresco.api.NodesApi;
import pro.abgrid.alfresco.dto.core.Node;
import pro.abgrid.alfresco.dto.core.NodeBodyUpdate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p><strong>RU:</strong> Высокоуровневый Spring-сервис для сценариев «metadata» в Alfresco. Он служит прикладной границей над generated REST API: принимает более удобные параметры, скрывает технические детали HTTP/DTO там, где для них есть high-level модель, и оставляет доступ к серверному результату, когда это необходимо. Сервис предназначен для внедрения как обычный Spring bean в бизнес-сервисы приложения.</p>
 * <p><strong>EN:</strong> High-level Spring service for Alfresco metadata scenarios. It acts as an application boundary over the generated REST API: it accepts application-friendly parameters, hides HTTP/DTO plumbing where a high-level model exists, and still exposes server results when required. The service is intended to be injected as a regular Spring bean into application business services.</p>
 */
@Service
public class AlfrescoMetadataService {
    private final NodesApi api;

        /**
     * <p><strong>RU:</strong> создаёт сервис и получает его зависимости через Spring DI; обычно этот конструктор не вызывается прикладным кодом напрямую.</p>
     * <p><strong>EN:</strong> creates the service with dependencies supplied by Spring DI; application code normally does not call this constructor directly.</p>
     *
     * @param api RU: зависимость `api`, используемая сервисом для выполнения операций Alfresco. EN: `api` dependency used by the service to perform Alfresco operations.
     */

    public AlfrescoMetadataService(NodesApi api) {
        this.api = api;
    }

        /**
     * <p><strong>RU:</strong> получает актуальное представление объекта из Alfresco; подходит для чтения его серверного состояния и метаданных.</p>
     * <p><strong>EN:</strong> retrieves the current Alfresco representation of the object for reading server-side state and metadata.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public Node get(String nodeId) {
        return api.getNode(nodeId, List.of("properties", "aspectNames"), null, null).getEntry();
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `properties` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `properties` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public Map<String, Object> properties(String nodeId) {
        Node node = get(nodeId);
        return node == null || node.getProperties() == null ? Map.of() : Map.copyOf(node.getProperties());
    }

        /**
     * <p><strong>RU:</strong> изменяет существующий объект Alfresco и возвращает состояние, подтверждённое сервером.</p>
     * <p><strong>EN:</strong> updates an existing Alfresco object and returns the server-confirmed state.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param properties RU: свойства Alfresco, которые требуется установить или изменить. EN: Alfresco properties to set or update.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public Node updateProperties(String nodeId, Map<String, String> properties) {
        NodeBodyUpdate body = new NodeBodyUpdate();
        body.setProperties(properties);
        return api.updateNode(nodeId, List.of("properties", "aspectNames"), null, body).getEntry();
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `aspects` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `aspects` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public List<String> aspects(String nodeId) {
        Node node = get(nodeId);
        return node == null || node.getAspectNames() == null ? List.of() : List.copyOf(node.getAspectNames());
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `hasAspect` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `hasAspect` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param aspect RU: значение параметра `aspect` для выполняемой операции. EN: value of `aspect` used by the operation.
     * @return RU: `true`, если условие выполнено; иначе `false`. EN: `true` when the condition is satisfied; otherwise `false`.
     */

    public boolean hasAspect(String nodeId, String aspect) {
        return aspects(nodeId).contains(aspect);
    }

        /**
     * <p><strong>RU:</strong> устанавливает требуемое состояние или значение в Alfresco и возвращает результат операции.</p>
     * <p><strong>EN:</strong> sets the requested state or value in Alfresco and returns the operation result.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param aspects RU: значение параметра `aspects` для выполняемой операции. EN: value of `aspects` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public Node setAspects(String nodeId, List<String> aspects) {
        NodeBodyUpdate body = new NodeBodyUpdate();
        body.setAspectNames(aspects == null ? List.of() : new ArrayList<>(new LinkedHashSet<>(aspects)));
        return api.updateNode(nodeId, List.of("properties", "aspectNames"), null, body).getEntry();
    }

        /**
     * <p><strong>RU:</strong> добавляет связь, значение или дочерний объект к существующему объекту Alfresco.</p>
     * <p><strong>EN:</strong> adds a relation, value, or child object to an existing Alfresco object.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param aspect RU: значение параметра `aspect` для выполняемой операции. EN: value of `aspect` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public Node addAspect(String nodeId, String aspect) {
        Set<String> updated = new LinkedHashSet<>(aspects(nodeId));
        updated.add(aspect);
        return setAspects(nodeId, List.copyOf(updated));
    }

        /**
     * <p><strong>RU:</strong> перемещает существующий узел в другую папку репозитория.</p>
     * <p><strong>EN:</strong> moves an existing node to another repository folder.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param aspect RU: значение параметра `aspect` для выполняемой операции. EN: value of `aspect` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public Node removeAspect(String nodeId, String aspect) {
        Set<String> updated = new LinkedHashSet<>(aspects(nodeId));
        updated.remove(aspect);
        return setAspects(nodeId, List.copyOf(updated));
    }
}
