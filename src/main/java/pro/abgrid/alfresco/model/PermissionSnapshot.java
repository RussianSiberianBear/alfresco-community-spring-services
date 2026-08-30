package pro.abgrid.alfresco.model;

import java.util.List;

/**
 * <p><strong>RU:</strong> Снимок ACL узла с отдельно сохранёнными наследуемыми и локально установленными разрешениями, флагом inheritance и перечнем разрешений, которые сервер разрешает устанавливать.</p>
 * <p><strong>EN:</strong> Node ACL snapshot that keeps inherited and locally set permissions separate, along with inheritance state and server-reported settable permissions.</p>
 *
 * @param inheritanceEnabled RU: включено ли наследование ACL от родителя. EN: whether parent ACL inheritance is enabled.
 * @param inherited RU: наследуемые разрешения. EN: inherited permissions.
 * @param locallySet RU: локально установленные разрешения. EN: locally set permissions.
 * @param settable RU: разрешения, которые сервер допускает к установке. EN: permissions the server reports as settable.
 */
public record PermissionSnapshot(
        boolean inheritanceEnabled,
        List<PermissionGrant> inherited,
        List<PermissionGrant> locallySet,
        List<String> settable
) {
    /**
     * <p><strong>RU:</strong> Нормализует списки разрешений в ненулевые immutable-коллекции.</p>
     * <p><strong>EN:</strong> Normalizes permission lists to non-null immutable collections.</p>
     */
    public PermissionSnapshot {
        inherited = inherited == null ? List.of() : List.copyOf(inherited);
        locallySet = locallySet == null ? List.of() : List.copyOf(locallySet);
        settable = settable == null ? List.of() : List.copyOf(settable);
    }

        /**
     * <p><strong>RU:</strong> Формирует эффективный high-level список ACL: при отключённом inheritance только локальные записи, иначе inherited + locallySet.</p>
     * <p><strong>EN:</strong> Builds the effective high-level ACL list: local entries only when inheritance is disabled, otherwise inherited plus locallySet.</p>
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public List<PermissionGrant> effective() {
        if (!inheritanceEnabled) return locallySet;
        var result = new java.util.ArrayList<PermissionGrant>(inherited.size() + locallySet.size());
        result.addAll(inherited);
        result.addAll(locallySet);
        return List.copyOf(result);
    }
}
