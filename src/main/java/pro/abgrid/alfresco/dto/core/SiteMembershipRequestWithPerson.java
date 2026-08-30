package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;

/**
 * RU: DTO-модель Alfresco REST API: SiteMembershipRequestWithPerson.
 * EN: Alfresco REST API DTO model: SiteMembershipRequestWithPerson.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SiteMembershipRequestWithPerson {
    /**
     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the id field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private String id;

    /**

     * <p><strong>RU:</strong> дата и время создания. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the created at field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private OffsetDateTime createdAt;

    /**

     * <p><strong>RU:</strong> значение поля «site» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the site field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private Site site;

    /**

     * <p><strong>RU:</strong> значение поля «person» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the person field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private Person person;

    /**

     * <p><strong>RU:</strong> значение поля «message» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the message field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String message;

    /**
     * RU: Создаёт экземпляр SiteMembershipRequestWithPerson.
     * EN: Creates a SiteMembershipRequestWithPerson instance.
     */
    public SiteMembershipRequestWithPerson() {
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
     * <p><strong>RU:</strong> Возвращает значение поля «site» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the site field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение site. EN: current value of site.
     */

    public Site getSite() {
        return site;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «site» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the site field in the Alfresco REST API model.</p>
     *
     * @param site RU: новое значение site. EN: new value for site.
     */

    public void setSite(Site site) {
        this.site = site;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «person» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the person field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение person. EN: current value of person.
     */

    public Person getPerson() {
        return person;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «person» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the person field in the Alfresco REST API model.</p>
     *
     * @param person RU: новое значение person. EN: new value for person.
     */

    public void setPerson(Person person) {
        this.person = person;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «message» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the message field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение message. EN: current value of message.
     */

    public String getMessage() {
        return message;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «message» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the message field in the Alfresco REST API model.</p>
     *
     * @param message RU: новое значение message. EN: new value for message.
     */

    public void setMessage(String message) {
        this.message = message;
    }

}
