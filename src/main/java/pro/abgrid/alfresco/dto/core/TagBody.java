package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: TagBody.
 * EN: Alfresco REST API DTO model: TagBody.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TagBody {
    /**
     * <p><strong>RU:</strong> значение поля «tag» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the tag field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private String tag;

    /**
     * RU: Создаёт экземпляр TagBody.
     * EN: Creates a TagBody instance.
     */
    public TagBody() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «tag» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the tag field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение tag. EN: current value of tag.
     */

    public String getTag() {
        return tag;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «tag» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the tag field in the Alfresco REST API model.</p>
     *
     * @param tag RU: новое значение tag. EN: new value for tag.
     */

    public void setTag(String tag) {
        this.tag = tag;
    }

}
