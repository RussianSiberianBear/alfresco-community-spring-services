package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: SiteMembershipRequestWithPersonPaging.
 * EN: Alfresco REST API DTO model: SiteMembershipRequestWithPersonPaging.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SiteMembershipRequestWithPersonPaging {
    /**
     * <p><strong>RU:</strong> значение поля «list» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the list field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private Object list;

    /**
     * RU: Создаёт экземпляр SiteMembershipRequestWithPersonPaging.
     * EN: Creates a SiteMembershipRequestWithPersonPaging instance.
     */
    public SiteMembershipRequestWithPersonPaging() {
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
