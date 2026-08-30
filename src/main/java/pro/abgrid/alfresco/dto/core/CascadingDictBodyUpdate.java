package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: CascadingDictBodyUpdate.
 * EN: Alfresco REST API DTO model: CascadingDictBodyUpdate.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CascadingDictBodyUpdate {
    /**
     * <p><strong>RU:</strong> имя ресурса Alfresco. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> The unique name of the cascading dictionary.. Required by the Swagger schema.</p>
     */
    private String name;

    /**
     * RU: Создаёт экземпляр CascadingDictBodyUpdate.
     * EN: Creates a CascadingDictBodyUpdate instance.
     */
    public CascadingDictBodyUpdate() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает имя ресурса Alfresco.</p>
     * <p><strong>EN:</strong> Returns The unique name of the cascading dictionary..</p>
     *
     * @return RU: текущее значение name. EN: current value of name.
     */

    public String getName() {
        return name;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает имя ресурса Alfresco.</p>
     * <p><strong>EN:</strong> Sets The unique name of the cascading dictionary..</p>
     *
     * @param name RU: новое значение name. EN: new value for name.
     */

    public void setName(String name) {
        this.name = name;
    }

}
