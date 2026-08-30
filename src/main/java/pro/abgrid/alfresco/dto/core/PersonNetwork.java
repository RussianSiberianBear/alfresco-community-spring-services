package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * RU: DTO-модель Alfresco REST API: PersonNetwork.
 * EN: Alfresco REST API DTO model: PersonNetwork.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonNetwork {
    /**
     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> This network's unique id. Required by the Swagger schema.</p>
     */
    private String id;

    /**

     * <p><strong>RU:</strong> значение поля «home network» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Is this the home network?. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean homeNetwork;

    /**

     * <p><strong>RU:</strong> значение поля «is enabled» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the is enabled field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private Boolean isEnabled;

    /**

     * <p><strong>RU:</strong> дата и время создания. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the created at field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private OffsetDateTime createdAt;

    /**

     * <p><strong>RU:</strong> значение поля «paid network» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the paid network field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean paidNetwork;

    /**

     * <p><strong>RU:</strong> значение поля «subscription level» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the subscription level field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String subscriptionLevel;

    /**

     * <p><strong>RU:</strong> значение поля «quotas» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the quotas field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private List<NetworkQuota> quotas;

    /**
     * RU: Создаёт экземпляр PersonNetwork.
     * EN: Creates a PersonNetwork instance.
     */
    public PersonNetwork() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Returns This network's unique id.</p>
     *
     * @return RU: текущее значение id. EN: current value of id.
     */

    public String getId() {
        return id;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Sets This network's unique id.</p>
     *
     * @param id RU: новое значение id. EN: new value for id.
     */

    public void setId(String id) {
        this.id = id;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «home network» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Is this the home network?.</p>
     *
     * @return RU: текущее значение homeNetwork. EN: current value of homeNetwork.
     */

    public Boolean getHomeNetwork() {
        return homeNetwork;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «home network» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Is this the home network?.</p>
     *
     * @param homeNetwork RU: новое значение homeNetwork. EN: new value for homeNetwork.
     */

    public void setHomeNetwork(Boolean homeNetwork) {
        this.homeNetwork = homeNetwork;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «is enabled» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the is enabled field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение isEnabled. EN: current value of isEnabled.
     */

    public Boolean getIsEnabled() {
        return isEnabled;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «is enabled» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the is enabled field in the Alfresco REST API model.</p>
     *
     * @param isEnabled RU: новое значение isEnabled. EN: new value for isEnabled.
     */

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

        /**
     * <p><strong>RU:</strong> Возвращает дата и время создания.</p>
     * <p><strong>EN:</strong> Returns Value of the created at field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение createdAt. EN: current value of createdAt.
     */

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает дата и время создания.</p>
     * <p><strong>EN:</strong> Sets Value of the created at field in the Alfresco REST API model.</p>
     *
     * @param createdAt RU: новое значение createdAt. EN: new value for createdAt.
     */

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «paid network» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the paid network field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение paidNetwork. EN: current value of paidNetwork.
     */

    public Boolean getPaidNetwork() {
        return paidNetwork;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «paid network» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the paid network field in the Alfresco REST API model.</p>
     *
     * @param paidNetwork RU: новое значение paidNetwork. EN: new value for paidNetwork.
     */

    public void setPaidNetwork(Boolean paidNetwork) {
        this.paidNetwork = paidNetwork;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «subscription level» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the subscription level field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение subscriptionLevel. EN: current value of subscriptionLevel.
     */

    public String getSubscriptionLevel() {
        return subscriptionLevel;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «subscription level» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the subscription level field in the Alfresco REST API model.</p>
     *
     * @param subscriptionLevel RU: новое значение subscriptionLevel. EN: new value for subscriptionLevel.
     */

    public void setSubscriptionLevel(String subscriptionLevel) {
        this.subscriptionLevel = subscriptionLevel;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «quotas» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the quotas field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение quotas. EN: current value of quotas.
     */

    public List<NetworkQuota> getQuotas() {
        return quotas;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «quotas» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the quotas field in the Alfresco REST API model.</p>
     *
     * @param quotas RU: новое значение quotas. EN: new value for quotas.
     */

    public void setQuotas(List<NetworkQuota> quotas) {
        this.quotas = quotas;
    }

}
