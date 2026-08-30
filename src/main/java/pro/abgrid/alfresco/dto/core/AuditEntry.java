package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;
import java.util.Map;

/**
 * RU: DTO-модель Alfresco REST API: AuditEntry.
 * EN: Alfresco REST API DTO model: AuditEntry.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditEntry {
    /**
     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the id field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private String id;

    /**

     * <p><strong>RU:</strong> значение поля «audit application id» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the audit application id field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private String auditApplicationId;

    /**

     * <p><strong>RU:</strong> пользователь, создавший ресурс. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the created by user field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private UserInfo createdByUser;

    /**

     * <p><strong>RU:</strong> дата и время создания. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the created at field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private OffsetDateTime createdAt;

    /**

     * <p><strong>RU:</strong> значение поля «values» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the values field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Map<String, Object> values;

    /**
     * RU: Создаёт экземпляр AuditEntry.
     * EN: Creates a AuditEntry instance.
     */
    public AuditEntry() {
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
     * <p><strong>RU:</strong> Возвращает значение поля «audit application id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the audit application id field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение auditApplicationId. EN: current value of auditApplicationId.
     */

    public String getAuditApplicationId() {
        return auditApplicationId;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «audit application id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the audit application id field in the Alfresco REST API model.</p>
     *
     * @param auditApplicationId RU: новое значение auditApplicationId. EN: new value for auditApplicationId.
     */

    public void setAuditApplicationId(String auditApplicationId) {
        this.auditApplicationId = auditApplicationId;
    }

        /**
     * <p><strong>RU:</strong> Возвращает пользователь, создавший ресурс.</p>
     * <p><strong>EN:</strong> Returns Value of the created by user field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение createdByUser. EN: current value of createdByUser.
     */

    public UserInfo getCreatedByUser() {
        return createdByUser;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает пользователь, создавший ресурс.</p>
     * <p><strong>EN:</strong> Sets Value of the created by user field in the Alfresco REST API model.</p>
     *
     * @param createdByUser RU: новое значение createdByUser. EN: new value for createdByUser.
     */

    public void setCreatedByUser(UserInfo createdByUser) {
        this.createdByUser = createdByUser;
    }

        /**
     * <p><strong>RU:</strong> Возвращает дата и время создания.</p>
     * <p><strong>EN:</strong> Returns Value of the created at field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение createdAt. EN: current value of createdAt.
     */

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает дата и время создания.</p>
     * <p><strong>EN:</strong> Sets Value of the created at field in the Alfresco REST API model.</p>
     *
     * @param createdAt RU: новое значение createdAt. EN: new value for createdAt.
     */

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «values» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the values field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение values. EN: current value of values.
     */

    public Map<String, Object> getValues() {
        return values;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «values» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the values field in the Alfresco REST API model.</p>
     *
     * @param values RU: новое значение values. EN: new value for values.
     */

    public void setValues(Map<String, Object> values) {
        this.values = values;
    }

}
