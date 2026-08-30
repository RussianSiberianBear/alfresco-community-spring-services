package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;

/**
 * RU: DTO-модель Alfresco REST API: SharedLinkBodyCreate.
 * EN: Alfresco REST API DTO model: SharedLinkBodyCreate.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SharedLinkBodyCreate {
    /**
     * <p><strong>RU:</strong> значение поля «node id» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the node id field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private String nodeId;

    /**

     * <p><strong>RU:</strong> значение поля «expires at» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the expires at field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private OffsetDateTime expiresAt;

    /**
     * RU: Создаёт экземпляр SharedLinkBodyCreate.
     * EN: Creates a SharedLinkBodyCreate instance.
     */
    public SharedLinkBodyCreate() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «node id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the node id field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение nodeId. EN: current value of nodeId.
     */

    public String getNodeId() {
        return nodeId;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «node id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the node id field in the Alfresco REST API model.</p>
     *
     * @param nodeId RU: новое значение nodeId. EN: new value for nodeId.
     */

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «expires at» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the expires at field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение expiresAt. EN: current value of expiresAt.
     */

    public OffsetDateTime getExpiresAt() {
        return expiresAt;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «expires at» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the expires at field in the Alfresco REST API model.</p>
     *
     * @param expiresAt RU: новое значение expiresAt. EN: new value for expiresAt.
     */

    public void setExpiresAt(OffsetDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

}
