package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: ActivityPaging.
 * EN: Alfresco REST API DTO model: ActivityPaging.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityPaging {
    /**
     * <p><strong>RU:</strong> значение поля «list» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the list field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private Object list;

    /**
     * RU: Создаёт экземпляр ActivityPaging.
     * EN: Creates a ActivityPaging instance.
     */
    public ActivityPaging() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «list» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the list field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение list. EN: current value of list.
     */

    public Object getList() {
        return list;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «list» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the list field in the Alfresco REST API model.</p>
     *
     * @param list RU: новое значение list. EN: new value for list.
     */

    public void setList(Object list) {
        this.list = list;
    }

}
