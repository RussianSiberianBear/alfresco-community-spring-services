package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

/**
 * RU: DTO-модель Alfresco REST API: Favorite.
 * EN: Alfresco REST API DTO model: Favorite.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Favorite {
    /**
     * <p><strong>RU:</strong> значение поля «target guid» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> The guid of the object that is a favorite.. Required by the Swagger schema.</p>
     */
    private String targetGuid;

    /**

     * <p><strong>RU:</strong> дата и время создания. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The time the object was made a favorite.. Optional unless a specific endpoint requires it.</p>

     */

    private OffsetDateTime createdAt;

    /**

     * <p><strong>RU:</strong> значение поля «target» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the target field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private Map<String, Object> target;

    /**

     * <p><strong>RU:</strong> динамические свойства Alfresco, индексированные по QName. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> A subset of the target favorite properties, system properties and properties already available in the target are excluded.. Optional unless a specific endpoint requires it.</p>

     */

    private Map<String, Object> properties;

    /**

     * <p><strong>RU:</strong> значение поля «allowable operations» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The allowable operations for the target.. Optional unless a specific endpoint requires it.</p>

     */

    private List<String> allowableOperations;

    /**
     * RU: Создаёт экземпляр Favorite.
     * EN: Creates a Favorite instance.
     */
    public Favorite() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «target guid» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The guid of the object that is a favorite..</p>
     *
     * @return RU: текущее значение targetGuid. EN: current value of targetGuid.
     */

    public String getTargetGuid() {
        return targetGuid;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «target guid» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The guid of the object that is a favorite..</p>
     *
     * @param targetGuid RU: новое значение targetGuid. EN: new value for targetGuid.
     */

    public void setTargetGuid(String targetGuid) {
        this.targetGuid = targetGuid;
    }

        /**
     * <p><strong>RU:</strong> Возвращает дата и время создания.</p>
     * <p><strong>EN:</strong> Returns The time the object was made a favorite..</p>
     *
     * @return RU: текущее значение createdAt. EN: current value of createdAt.
     */

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает дата и время создания.</p>
     * <p><strong>EN:</strong> Sets The time the object was made a favorite..</p>
     *
     * @param createdAt RU: новое значение createdAt. EN: new value for createdAt.
     */

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «target» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the target field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение target. EN: current value of target.
     */

    public Map<String, Object> getTarget() {
        return target;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «target» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the target field in the Alfresco REST API model.</p>
     *
     * @param target RU: новое значение target. EN: new value for target.
     */

    public void setTarget(Map<String, Object> target) {
        this.target = target;
    }

        /**
     * <p><strong>RU:</strong> Возвращает динамические свойства Alfresco, индексированные по QName.</p>
     * <p><strong>EN:</strong> Returns A subset of the target favorite properties, system properties and properties already available in the target are excluded..</p>
     *
     * @return RU: текущее значение properties. EN: current value of properties.
     */

    public Map<String, Object> getProperties() {
        return properties;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает динамические свойства Alfresco, индексированные по QName.</p>
     * <p><strong>EN:</strong> Sets A subset of the target favorite properties, system properties and properties already available in the target are excluded..</p>
     *
     * @param properties RU: новое значение properties. EN: new value for properties.
     */

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «allowable operations» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The allowable operations for the target..</p>
     *
     * @return RU: текущее значение allowableOperations. EN: current value of allowableOperations.
     */

    public List<String> getAllowableOperations() {
        return allowableOperations;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «allowable operations» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The allowable operations for the target..</p>
     *
     * @param allowableOperations RU: новое значение allowableOperations. EN: new value for allowableOperations.
     */

    public void setAllowableOperations(List<String> allowableOperations) {
        this.allowableOperations = allowableOperations;
    }

}
