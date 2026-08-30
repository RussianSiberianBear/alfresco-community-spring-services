package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: Capabilities.
 * EN: Alfresco REST API DTO model: Capabilities.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Capabilities {
    /**
     * <p><strong>RU:</strong> значение поля «is admin» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Value of the is admin field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>
     */
    private Boolean isAdmin;

    /**

     * <p><strong>RU:</strong> значение поля «is guest» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the is guest field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean isGuest;

    /**

     * <p><strong>RU:</strong> значение поля «is mutable» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the is mutable field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean isMutable;

    /**
     * RU: Создаёт экземпляр Capabilities.
     * EN: Creates a Capabilities instance.
     */
    public Capabilities() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «is admin» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the is admin field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение isAdmin. EN: current value of isAdmin.
     */

    public Boolean getIsAdmin() {
        return isAdmin;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «is admin» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the is admin field in the Alfresco REST API model.</p>
     *
     * @param isAdmin RU: новое значение isAdmin. EN: new value for isAdmin.
     */

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «is guest» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the is guest field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение isGuest. EN: current value of isGuest.
     */

    public Boolean getIsGuest() {
        return isGuest;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «is guest» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the is guest field in the Alfresco REST API model.</p>
     *
     * @param isGuest RU: новое значение isGuest. EN: new value for isGuest.
     */

    public void setIsGuest(Boolean isGuest) {
        this.isGuest = isGuest;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «is mutable» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the is mutable field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение isMutable. EN: current value of isMutable.
     */

    public Boolean getIsMutable() {
        return isMutable;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «is mutable» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the is mutable field in the Alfresco REST API model.</p>
     *
     * @param isMutable RU: новое значение isMutable. EN: new value for isMutable.
     */

    public void setIsMutable(Boolean isMutable) {
        this.isMutable = isMutable;
    }

}
