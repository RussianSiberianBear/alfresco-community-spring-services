package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: CategoryLinkBody.
 * EN: Alfresco REST API DTO model: CategoryLinkBody.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryLinkBody {
    /**
     * <p><strong>RU:</strong> значение поля «category id» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> The identifier of the category.. Required by the Swagger schema.</p>
     */
    private String categoryId;

    /**
     * RU: Создаёт экземпляр CategoryLinkBody.
     * EN: Creates a CategoryLinkBody instance.
     */
    public CategoryLinkBody() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «category id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The identifier of the category..</p>
     *
     * @return RU: текущее значение categoryId. EN: current value of categoryId.
     */

    public String getCategoryId() {
        return categoryId;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «category id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The identifier of the category..</p>
     *
     * @param categoryId RU: новое значение categoryId. EN: new value for categoryId.
     */

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

}
