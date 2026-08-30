package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: PreferencePaging.
 * EN: Alfresco REST API DTO model: PreferencePaging.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PreferencePaging {
    /**
     * <p><strong>RU:</strong> значение поля «list» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the list field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private Object list;

    /**
     * RU: Создаёт экземпляр PreferencePaging.
     * EN: Creates a PreferencePaging instance.
     */
    public PreferencePaging() {
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
