package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: CategoryBody.
 * EN: Alfresco REST API DTO model: CategoryBody.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryBody {
    /**
     * <p><strong>RU:</strong> имя ресурса Alfresco. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> The name of the category. This must be unique within the parent category.. Required by the Swagger schema.</p>
     */
    private String name;

    /**
     * RU: Создаёт экземпляр CategoryBody.
     * EN: Creates a CategoryBody instance.
     */
    public CategoryBody() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает имя ресурса Alfresco.</p>
     * <p><strong>EN:</strong> Returns The name of the category. This must be unique within the parent category..</p>
     *
     * @return RU: текущее значение name. EN: current value of name.
     */

    public String getName() {
        return name;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает имя ресурса Alfresco.</p>
     * <p><strong>EN:</strong> Sets The name of the category. This must be unique within the parent category..</p>
     *
     * @param name RU: новое значение name. EN: new value for name.
     */

    public void setName(String name) {
        this.name = name;
    }

}
