package pro.abgrid.alfresco.service.permission;

import pro.abgrid.alfresco.api.NodesApi;
import pro.abgrid.alfresco.dto.core.Node;
import pro.abgrid.alfresco.dto.core.NodeBodyUpdate;
import pro.abgrid.alfresco.dto.core.PermissionElement;
import pro.abgrid.alfresco.dto.core.PermissionsBody;
import pro.abgrid.alfresco.dto.core.PermissionsInfo;
import pro.abgrid.alfresco.model.PermissionGrant;
import pro.abgrid.alfresco.model.PermissionSnapshot;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p><strong>RU:</strong> Высокоуровневый Spring-сервис для сценариев «permission» в Alfresco. Он служит прикладной границей над generated REST API: принимает более удобные параметры, скрывает технические детали HTTP/DTO там, где для них есть high-level модель, и оставляет доступ к серверному результату, когда это необходимо. Сервис предназначен для внедрения как обычный Spring bean в бизнес-сервисы приложения.</p>
 * <p><strong>EN:</strong> High-level Spring service for Alfresco permission scenarios. It acts as an application boundary over the generated REST API: it accepts application-friendly parameters, hides HTTP/DTO plumbing where a high-level model exists, and still exposes server results when required. The service is intended to be injected as a regular Spring bean into application business services.</p>
 */
@Service
public class AlfrescoPermissionService {
    private final NodesApi api;

        /**
     * <p><strong>RU:</strong> создаёт сервис и получает его зависимости через Spring DI; обычно этот конструктор не вызывается прикладным кодом напрямую.</p>
     * <p><strong>EN:</strong> creates the service with dependencies supplied by Spring DI; application code normally does not call this constructor directly.</p>
     *
     * @param api RU: зависимость `api`, используемая сервисом для выполнения операций Alfresco. EN: `api` dependency used by the service to perform Alfresco operations.
     */

    public AlfrescoPermissionService(NodesApi api) {
        this.api = api;
    }

        /**
     * <p><strong>RU:</strong> получает актуальное представление объекта из Alfresco; подходит для чтения его серверного состояния и метаданных.</p>
     * <p><strong>EN:</strong> retrieves the current Alfresco representation of the object for reading server-side state and metadata.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public PermissionSnapshot get(String nodeId) {
        Node node = api.getNode(nodeId, List.of("permissions"), null, null).getEntry();
        PermissionsInfo p = node.getPermissions();
        if (p == null) return new PermissionSnapshot(true, List.of(), List.of(), List.of());
        return new PermissionSnapshot(
                !Boolean.FALSE.equals(p.getIsInheritanceEnabled()),
                map(p.getInherited()), map(p.getLocallySet()), p.getSettable());
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `replaceLocal` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `replaceLocal` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param inheritanceEnabled RU: значение параметра `inheritanceEnabled` для выполняемой операции. EN: value of `inheritanceEnabled` used by the operation.
     * @param grants RU: значение параметра `grants` для выполняемой операции. EN: value of `grants` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public Node replaceLocal(String nodeId, boolean inheritanceEnabled, List<PermissionGrant> grants) {
        return update(nodeId, inheritanceEnabled, grants == null ? List.of() : grants);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `grant` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `grant` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param authorityId RU: значение параметра `authorityId` для выполняемой операции. EN: value of `authorityId` used by the operation.
     * @param permission RU: описание разрешения/ACL, применяемого к узлу. EN: permission/ACL definition applied to the node.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public Node grant(String nodeId, String authorityId, String permission) {
        return put(nodeId, new PermissionGrant(authorityId, permission, "ALLOWED"));
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `deny` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `deny` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param authorityId RU: значение параметра `authorityId` для выполняемой операции. EN: value of `authorityId` used by the operation.
     * @param permission RU: описание разрешения/ACL, применяемого к узлу. EN: permission/ACL definition applied to the node.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public Node deny(String nodeId, String authorityId, String permission) {
        return put(nodeId, new PermissionGrant(authorityId, permission, "DENIED"));
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `put` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `put` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param grant RU: значение параметра `grant` для выполняемой операции. EN: value of `grant` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public Node put(String nodeId, PermissionGrant grant) {
        Objects.requireNonNull(grant, "grant");
        PermissionSnapshot current = get(nodeId);
        List<PermissionGrant> local = new ArrayList<>(current.locallySet());
        local.removeIf(p -> sameKey(p, grant.authorityId(), grant.permission()));
        local.add(grant);
        return update(nodeId, current.inheritanceEnabled(), local);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `revoke` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `revoke` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param authorityId RU: значение параметра `authorityId` для выполняемой операции. EN: value of `authorityId` used by the operation.
     * @param permission RU: описание разрешения/ACL, применяемого к узлу. EN: permission/ACL definition applied to the node.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public Node revoke(String nodeId, String authorityId, String permission) {
        PermissionSnapshot current = get(nodeId);
        List<PermissionGrant> local = new ArrayList<>(current.locallySet());
        local.removeIf(p -> sameKey(p, authorityId, permission));
        return update(nodeId, current.inheritanceEnabled(), local);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `revokeAll` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `revokeAll` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param authorityId RU: значение параметра `authorityId` для выполняемой операции. EN: value of `authorityId` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public Node revokeAll(String nodeId, String authorityId) {
        PermissionSnapshot current = get(nodeId);
        List<PermissionGrant> local = new ArrayList<>(current.locallySet());
        local.removeIf(p -> Objects.equals(p.authorityId(), authorityId));
        return update(nodeId, current.inheritanceEnabled(), local);
    }

        /**
     * <p><strong>RU:</strong> устанавливает требуемое состояние или значение в Alfresco и возвращает результат операции.</p>
     * <p><strong>EN:</strong> sets the requested state or value in Alfresco and returns the operation result.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param enabled RU: требуемое состояние включено/выключено. EN: desired enabled/disabled state.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public Node setInheritance(String nodeId, boolean enabled) {
        PermissionSnapshot current = get(nodeId);
        return update(nodeId, enabled, current.locallySet());
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `enableInheritance` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `enableInheritance` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public Node enableInheritance(String nodeId) { return setInheritance(nodeId, true); }
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `disableInheritance` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `disableInheritance` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public Node disableInheritance(String nodeId) { return setInheritance(nodeId, false); }

    private Node update(String nodeId, boolean inheritanceEnabled, List<PermissionGrant> grants) {
        PermissionsBody permissions = new PermissionsBody();
        permissions.setIsInheritanceEnabled(inheritanceEnabled);
        permissions.setLocallySet(grants.stream().map(AlfrescoPermissionService::toElement).toList());
        NodeBodyUpdate body = new NodeBodyUpdate();
        body.setPermissions(permissions);
        return api.updateNode(nodeId, List.of("permissions"), null, body).getEntry();
    }

    private static boolean sameKey(PermissionGrant p, String authorityId, String permission) {
        return Objects.equals(p.authorityId(), authorityId) && Objects.equals(p.permission(), permission);
    }

    private static List<PermissionGrant> map(List<PermissionElement> values) {
        if (values == null) return List.of();
        return values.stream().map(p -> new PermissionGrant(p.getAuthorityId(), p.getName(), p.getAccessStatus())).toList();
    }

    private static PermissionElement toElement(PermissionGrant grant) {
        PermissionElement e = new PermissionElement();
        e.setAuthorityId(grant.authorityId());
        e.setName(grant.permission());
        e.setAccessStatus(grant.accessStatus());
        return e;
    }
}
