package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * RU: DTO-модель Alfresco REST API: PermissionsInfo.
 * EN: Alfresco REST API DTO model: PermissionsInfo.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PermissionsInfo {
    /**
     * <p><strong>RU:</strong> значение поля «is inheritance enabled» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Value of the is inheritance enabled field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>
     */
    private Boolean isInheritanceEnabled;

    /**

     * <p><strong>RU:</strong> значение поля «inherited» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the inherited field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private List<PermissionElement> inherited;

    /**

     * <p><strong>RU:</strong> значение поля «locally set» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the locally set field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private List<PermissionElement> locallySet;

    /**

     * <p><strong>RU:</strong> значение поля «settable» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the settable field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private List<String> settable;

    /**
     * RU: Создаёт экземпляр PermissionsInfo.
     * EN: Creates a PermissionsInfo instance.
     */
    public PermissionsInfo() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «is inheritance enabled» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the is inheritance enabled field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение isInheritanceEnabled. EN: current value of isInheritanceEnabled.
     */

    public Boolean getIsInheritanceEnabled() {
        return isInheritanceEnabled;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «is inheritance enabled» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the is inheritance enabled field in the Alfresco REST API model.</p>
     *
     * @param isInheritanceEnabled RU: новое значение isInheritanceEnabled. EN: new value for isInheritanceEnabled.
     */

    public void setIsInheritanceEnabled(Boolean isInheritanceEnabled) {
        this.isInheritanceEnabled = isInheritanceEnabled;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «inherited» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the inherited field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение inherited. EN: current value of inherited.
     */

    public List<PermissionElement> getInherited() {
        return inherited;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «inherited» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the inherited field in the Alfresco REST API model.</p>
     *
     * @param inherited RU: новое значение inherited. EN: new value for inherited.
     */

    public void setInherited(List<PermissionElement> inherited) {
        this.inherited = inherited;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «locally set» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the locally set field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение locallySet. EN: current value of locallySet.
     */

    public List<PermissionElement> getLocallySet() {
        return locallySet;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «locally set» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the locally set field in the Alfresco REST API model.</p>
     *
     * @param locallySet RU: новое значение locallySet. EN: new value for locallySet.
     */

    public void setLocallySet(List<PermissionElement> locallySet) {
        this.locallySet = locallySet;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «settable» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the settable field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение settable. EN: current value of settable.
     */

    public List<String> getSettable() {
        return settable;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «settable» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the settable field in the Alfresco REST API model.</p>
     *
     * @param settable RU: новое значение settable. EN: new value for settable.
     */

    public void setSettable(List<String> settable) {
        this.settable = settable;
    }

}
