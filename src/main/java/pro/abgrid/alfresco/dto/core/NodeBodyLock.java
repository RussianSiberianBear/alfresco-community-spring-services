package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: NodeBodyLock.
 * EN: Alfresco REST API DTO model: NodeBodyLock.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NodeBodyLock {
    /**
     * <p><strong>RU:</strong> значение поля «time to expire» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Value of the time to expire field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>
     */
    private Integer timeToExpire;

    /**

     * <p><strong>RU:</strong> значение поля «type» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the type field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String type;

    /**

     * <p><strong>RU:</strong> значение поля «lifetime» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the lifetime field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String lifetime;

    /**
     * RU: Создаёт экземпляр NodeBodyLock.
     * EN: Creates a NodeBodyLock instance.
     */
    public NodeBodyLock() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «time to expire» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the time to expire field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение timeToExpire. EN: current value of timeToExpire.
     */

    public Integer getTimeToExpire() {
        return timeToExpire;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «time to expire» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the time to expire field in the Alfresco REST API model.</p>
     *
     * @param timeToExpire RU: новое значение timeToExpire. EN: new value for timeToExpire.
     */

    public void setTimeToExpire(Integer timeToExpire) {
        this.timeToExpire = timeToExpire;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «type» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the type field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение type. EN: current value of type.
     */

    public String getType() {
        return type;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «type» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the type field in the Alfresco REST API model.</p>
     *
     * @param type RU: новое значение type. EN: new value for type.
     */

    public void setType(String type) {
        this.type = type;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «lifetime» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the lifetime field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение lifetime. EN: current value of lifetime.
     */

    public String getLifetime() {
        return lifetime;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «lifetime» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the lifetime field in the Alfresco REST API model.</p>
     *
     * @param lifetime RU: новое значение lifetime. EN: new value for lifetime.
     */

    public void setLifetime(String lifetime) {
        this.lifetime = lifetime;
    }

}
