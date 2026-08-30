package pro.abgrid.alfresco.dto.discovery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: StatusInfo.
 * EN: Alfresco REST API DTO model: StatusInfo.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatusInfo {
    /**
     * <p><strong>RU:</strong> значение поля «is read only» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the is read only field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private Boolean isReadOnly;

    /**

     * <p><strong>RU:</strong> значение поля «is audit enabled» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the is audit enabled field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private Boolean isAuditEnabled;

    /**

     * <p><strong>RU:</strong> значение поля «is quick share enabled» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the is quick share enabled field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private Boolean isQuickShareEnabled;

    /**

     * <p><strong>RU:</strong> значение поля «is thumbnail generation enabled» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the is thumbnail generation enabled field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private Boolean isThumbnailGenerationEnabled;

    /**

     * <p><strong>RU:</strong> значение поля «is direct access url enabled» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the is direct access url enabled field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private Boolean isDirectAccessUrlEnabled;

    /**
     * RU: Создаёт экземпляр StatusInfo.
     * EN: Creates a StatusInfo instance.
     */
    public StatusInfo() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «is read only» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the is read only field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение isReadOnly. EN: current value of isReadOnly.
     */

    public Boolean getIsReadOnly() {
        return isReadOnly;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «is read only» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the is read only field in the Alfresco REST API model.</p>
     *
     * @param isReadOnly RU: новое значение isReadOnly. EN: new value for isReadOnly.
     */

    public void setIsReadOnly(Boolean isReadOnly) {
        this.isReadOnly = isReadOnly;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «is audit enabled» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the is audit enabled field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение isAuditEnabled. EN: current value of isAuditEnabled.
     */

    public Boolean getIsAuditEnabled() {
        return isAuditEnabled;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «is audit enabled» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the is audit enabled field in the Alfresco REST API model.</p>
     *
     * @param isAuditEnabled RU: новое значение isAuditEnabled. EN: new value for isAuditEnabled.
     */

    public void setIsAuditEnabled(Boolean isAuditEnabled) {
        this.isAuditEnabled = isAuditEnabled;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «is quick share enabled» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the is quick share enabled field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение isQuickShareEnabled. EN: current value of isQuickShareEnabled.
     */

    public Boolean getIsQuickShareEnabled() {
        return isQuickShareEnabled;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «is quick share enabled» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the is quick share enabled field in the Alfresco REST API model.</p>
     *
     * @param isQuickShareEnabled RU: новое значение isQuickShareEnabled. EN: new value for isQuickShareEnabled.
     */

    public void setIsQuickShareEnabled(Boolean isQuickShareEnabled) {
        this.isQuickShareEnabled = isQuickShareEnabled;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «is thumbnail generation enabled» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the is thumbnail generation enabled field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение isThumbnailGenerationEnabled. EN: current value of isThumbnailGenerationEnabled.
     */

    public Boolean getIsThumbnailGenerationEnabled() {
        return isThumbnailGenerationEnabled;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «is thumbnail generation enabled» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the is thumbnail generation enabled field in the Alfresco REST API model.</p>
     *
     * @param isThumbnailGenerationEnabled RU: новое значение isThumbnailGenerationEnabled. EN: new value for isThumbnailGenerationEnabled.
     */

    public void setIsThumbnailGenerationEnabled(Boolean isThumbnailGenerationEnabled) {
        this.isThumbnailGenerationEnabled = isThumbnailGenerationEnabled;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «is direct access url enabled» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the is direct access url enabled field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение isDirectAccessUrlEnabled. EN: current value of isDirectAccessUrlEnabled.
     */

    public Boolean getIsDirectAccessUrlEnabled() {
        return isDirectAccessUrlEnabled;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «is direct access url enabled» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the is direct access url enabled field in the Alfresco REST API model.</p>
     *
     * @param isDirectAccessUrlEnabled RU: новое значение isDirectAccessUrlEnabled. EN: new value for isDirectAccessUrlEnabled.
     */

    public void setIsDirectAccessUrlEnabled(Boolean isDirectAccessUrlEnabled) {
        this.isDirectAccessUrlEnabled = isDirectAccessUrlEnabled;
    }

}
