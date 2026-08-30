package pro.abgrid.alfresco.model;

/**
 * <p><strong>RU:</strong> Одна запись ACL в удобном high-level виде: authority, имя разрешения и статус доступа.</p>
 * <p><strong>EN:</strong> Single ACL entry in an application-friendly form: authority, permission name, and access status.</p>
 *
 * @param authorityId RU: идентификатор пользователя или группы authority. EN: user or group authority identifier.
 * @param permission RU: имя разрешения Alfresco. EN: Alfresco permission name.
 * @param accessStatus RU: статус ALLOWED/DENIED. EN: ALLOWED/DENIED access status.
 */
public record PermissionGrant(String authorityId, String permission, String accessStatus) {}
