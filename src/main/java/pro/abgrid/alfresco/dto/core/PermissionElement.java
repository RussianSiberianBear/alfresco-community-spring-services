package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: PermissionElement.
 * EN: Alfresco REST API DTO model: PermissionElement.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PermissionElement {
    /**
     * <p><strong>RU:</strong> значение поля «authority id» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Value of the authority id field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>
     */
    private String authorityId;

    /**

     * <p><strong>RU:</strong> имя ресурса Alfresco. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the name field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String name;

    /**

     * <p><strong>RU:</strong> значение поля «access status» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the access status field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String accessStatus;

    /**

     * <p><strong>RU:</strong> значение поля «authority display name» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the authority display name field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String authorityDisplayName;

    /**
     * RU: Создаёт экземпляр PermissionElement.
     * EN: Creates a PermissionElement instance.
     */
    public PermissionElement() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «authority id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the authority id field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение authorityId. EN: current value of authorityId.
     */

    public String getAuthorityId() {
        return authorityId;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «authority id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the authority id field in the Alfresco REST API model.</p>
     *
     * @param authorityId RU: новое значение authorityId. EN: new value for authorityId.
     */

    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId;
    }

        /**
     * <p><strong>RU:</strong> Возвращает имя ресурса Alfresco.</p>
     * <p><strong>EN:</strong> Returns Value of the name field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение name. EN: current value of name.
     */

    public String getName() {
        return name;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает имя ресурса Alfresco.</p>
     * <p><strong>EN:</strong> Sets Value of the name field in the Alfresco REST API model.</p>
     *
     * @param name RU: новое значение name. EN: new value for name.
     */

    public void setName(String name) {
        this.name = name;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «access status» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the access status field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение accessStatus. EN: current value of accessStatus.
     */

    public String getAccessStatus() {
        return accessStatus;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «access status» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the access status field in the Alfresco REST API model.</p>
     *
     * @param accessStatus RU: новое значение accessStatus. EN: new value for accessStatus.
     */

    public void setAccessStatus(String accessStatus) {
        this.accessStatus = accessStatus;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «authority display name» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the authority display name field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение authorityDisplayName. EN: current value of authorityDisplayName.
     */

    public String getAuthorityDisplayName() {
        return authorityDisplayName;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «authority display name» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the authority display name field in the Alfresco REST API model.</p>
     *
     * @param authorityDisplayName RU: новое значение authorityDisplayName. EN: new value for authorityDisplayName.
     */

    public void setAuthorityDisplayName(String authorityDisplayName) {
        this.authorityDisplayName = authorityDisplayName;
    }

}
