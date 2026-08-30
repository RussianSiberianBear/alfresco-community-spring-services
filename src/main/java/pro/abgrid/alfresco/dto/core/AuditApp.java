package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: AuditApp.
 * EN: Alfresco REST API DTO model: AuditApp.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditApp {
    /**
     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the id field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private String id;

    /**

     * <p><strong>RU:</strong> имя ресурса Alfresco. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the name field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String name;

    /**

     * <p><strong>RU:</strong> значение поля «is enabled» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the is enabled field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean isEnabled;

    /**

     * <p><strong>RU:</strong> значение поля «max entry id» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the max entry id field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Integer maxEntryId;

    /**

     * <p><strong>RU:</strong> значение поля «min entry id» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the min entry id field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Integer minEntryId;

    /**
     * RU: Создаёт экземпляр AuditApp.
     * EN: Creates a AuditApp instance.
     */
    public AuditApp() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Returns Value of the id field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение id. EN: current value of id.
     */

    public String getId() {
        return id;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Sets Value of the id field in the Alfresco REST API model.</p>
     *
     * @param id RU: новое значение id. EN: new value for id.
     */

    public void setId(String id) {
        this.id = id;
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
     * <p><strong>RU:</strong> Возвращает значение поля «is enabled» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the is enabled field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение isEnabled. EN: current value of isEnabled.
     */

    public Boolean getIsEnabled() {
        return isEnabled;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «is enabled» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the is enabled field in the Alfresco REST API model.</p>
     *
     * @param isEnabled RU: новое значение isEnabled. EN: new value for isEnabled.
     */

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «max entry id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the max entry id field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение maxEntryId. EN: current value of maxEntryId.
     */

    public Integer getMaxEntryId() {
        return maxEntryId;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «max entry id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the max entry id field in the Alfresco REST API model.</p>
     *
     * @param maxEntryId RU: новое значение maxEntryId. EN: new value for maxEntryId.
     */

    public void setMaxEntryId(Integer maxEntryId) {
        this.maxEntryId = maxEntryId;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «min entry id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the min entry id field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение minEntryId. EN: current value of minEntryId.
     */

    public Integer getMinEntryId() {
        return minEntryId;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «min entry id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the min entry id field in the Alfresco REST API model.</p>
     *
     * @param minEntryId RU: новое значение minEntryId. EN: new value for minEntryId.
     */

    public void setMinEntryId(Integer minEntryId) {
        this.minEntryId = minEntryId;
    }

}
