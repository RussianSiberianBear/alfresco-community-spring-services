package pro.abgrid.alfresco.dto.discovery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: EntitlementsInfo.
 * EN: Alfresco REST API DTO model: EntitlementsInfo.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EntitlementsInfo {
    /**
     * <p><strong>RU:</strong> значение поля «max users» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Value of the max users field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>
     */
    private Long maxUsers;

    /**

     * <p><strong>RU:</strong> значение поля «max docs» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the max docs field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Long maxDocs;

    /**

     * <p><strong>RU:</strong> значение поля «is cluster enabled» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the is cluster enabled field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean isClusterEnabled;

    /**

     * <p><strong>RU:</strong> значение поля «is cryptodoc enabled» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the is cryptodoc enabled field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean isCryptodocEnabled;

    /**

     * <p><strong>RU:</strong> значение поля «is custom embedded workflow enabled» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the is custom embedded workflow enabled field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean isCustomEmbeddedWorkflowEnabled;

    /**
     * RU: Создаёт экземпляр EntitlementsInfo.
     * EN: Creates a EntitlementsInfo instance.
     */
    public EntitlementsInfo() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «max users» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the max users field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение maxUsers. EN: current value of maxUsers.
     */

    public Long getMaxUsers() {
        return maxUsers;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «max users» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the max users field in the Alfresco REST API model.</p>
     *
     * @param maxUsers RU: новое значение maxUsers. EN: new value for maxUsers.
     */

    public void setMaxUsers(Long maxUsers) {
        this.maxUsers = maxUsers;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «max docs» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the max docs field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение maxDocs. EN: current value of maxDocs.
     */

    public Long getMaxDocs() {
        return maxDocs;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «max docs» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the max docs field in the Alfresco REST API model.</p>
     *
     * @param maxDocs RU: новое значение maxDocs. EN: new value for maxDocs.
     */

    public void setMaxDocs(Long maxDocs) {
        this.maxDocs = maxDocs;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «is cluster enabled» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the is cluster enabled field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение isClusterEnabled. EN: current value of isClusterEnabled.
     */

    public Boolean getIsClusterEnabled() {
        return isClusterEnabled;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «is cluster enabled» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the is cluster enabled field in the Alfresco REST API model.</p>
     *
     * @param isClusterEnabled RU: новое значение isClusterEnabled. EN: new value for isClusterEnabled.
     */

    public void setIsClusterEnabled(Boolean isClusterEnabled) {
        this.isClusterEnabled = isClusterEnabled;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «is cryptodoc enabled» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the is cryptodoc enabled field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение isCryptodocEnabled. EN: current value of isCryptodocEnabled.
     */

    public Boolean getIsCryptodocEnabled() {
        return isCryptodocEnabled;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «is cryptodoc enabled» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the is cryptodoc enabled field in the Alfresco REST API model.</p>
     *
     * @param isCryptodocEnabled RU: новое значение isCryptodocEnabled. EN: new value for isCryptodocEnabled.
     */

    public void setIsCryptodocEnabled(Boolean isCryptodocEnabled) {
        this.isCryptodocEnabled = isCryptodocEnabled;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «is custom embedded workflow enabled» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the is custom embedded workflow enabled field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение isCustomEmbeddedWorkflowEnabled. EN: current value of isCustomEmbeddedWorkflowEnabled.
     */

    public Boolean getIsCustomEmbeddedWorkflowEnabled() {
        return isCustomEmbeddedWorkflowEnabled;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «is custom embedded workflow enabled» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the is custom embedded workflow enabled field in the Alfresco REST API model.</p>
     *
     * @param isCustomEmbeddedWorkflowEnabled RU: новое значение isCustomEmbeddedWorkflowEnabled. EN: new value for isCustomEmbeddedWorkflowEnabled.
     */

    public void setIsCustomEmbeddedWorkflowEnabled(Boolean isCustomEmbeddedWorkflowEnabled) {
        this.isCustomEmbeddedWorkflowEnabled = isCustomEmbeddedWorkflowEnabled;
    }

}
