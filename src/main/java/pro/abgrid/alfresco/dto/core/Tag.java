package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: Tag.
 * EN: Alfresco REST API DTO model: Tag.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tag {
    /**
     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> The identifier for the tag.. Required by the Swagger schema.</p>
     */
    private String id;

    /**

     * <p><strong>RU:</strong> значение поля «tag» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> The unique name of the tag.. Required by the Swagger schema.</p>

     */

    private String tag;

    /**

     * <p><strong>RU:</strong> значение поля «count» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The number of nodes that this tag has been applied to.. Optional unless a specific endpoint requires it.</p>

     */

    private Double count;

    /**
     * RU: Создаёт экземпляр Tag.
     * EN: Creates a Tag instance.
     */
    public Tag() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Returns The identifier for the tag..</p>
     *
     * @return RU: текущее значение id. EN: current value of id.
     */

    public String getId() {
        return id;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Sets The identifier for the tag..</p>
     *
     * @param id RU: новое значение id. EN: new value for id.
     */

    public void setId(String id) {
        this.id = id;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «tag» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The unique name of the tag..</p>
     *
     * @return RU: текущее значение tag. EN: current value of tag.
     */

    public String getTag() {
        return tag;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «tag» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The unique name of the tag..</p>
     *
     * @param tag RU: новое значение tag. EN: new value for tag.
     */

    public void setTag(String tag) {
        this.tag = tag;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «count» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The number of nodes that this tag has been applied to..</p>
     *
     * @return RU: текущее значение count. EN: current value of count.
     */

    public Double getCount() {
        return count;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «count» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The number of nodes that this tag has been applied to..</p>
     *
     * @param count RU: новое значение count. EN: new value for count.
     */

    public void setCount(Double count) {
        this.count = count;
    }

}
