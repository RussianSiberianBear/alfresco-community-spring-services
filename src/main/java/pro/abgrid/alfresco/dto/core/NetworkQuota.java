package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: NetworkQuota.
 * EN: Alfresco REST API DTO model: NetworkQuota.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NetworkQuota {
    /**
     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the id field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private String id;

    /**

     * <p><strong>RU:</strong> значение поля «limit» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the limit field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private Long limit;

    /**

     * <p><strong>RU:</strong> значение поля «usage» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the usage field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private Long usage;

    /**
     * RU: Создаёт экземпляр NetworkQuota.
     * EN: Creates a NetworkQuota instance.
     */
    public NetworkQuota() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Returns Value of the id field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение id. EN: current value of id.
     */

    public String getId() {
        return id;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Sets Value of the id field in the Alfresco REST API model.</p>
     *
     * @param id RU: новое значение id. EN: new value for id.
     */

    public void setId(String id) {
        this.id = id;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «limit» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the limit field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение limit. EN: current value of limit.
     */

    public Long getLimit() {
        return limit;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «limit» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the limit field in the Alfresco REST API model.</p>
     *
     * @param limit RU: новое значение limit. EN: new value for limit.
     */

    public void setLimit(Long limit) {
        this.limit = limit;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «usage» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the usage field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение usage. EN: current value of usage.
     */

    public Long getUsage() {
        return usage;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «usage» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the usage field in the Alfresco REST API model.</p>
     *
     * @param usage RU: новое значение usage. EN: new value for usage.
     */

    public void setUsage(Long usage) {
        this.usage = usage;
    }

}
