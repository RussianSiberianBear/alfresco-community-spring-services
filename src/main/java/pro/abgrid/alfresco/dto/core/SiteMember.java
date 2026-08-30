package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: SiteMember.
 * EN: Alfresco REST API DTO model: SiteMember.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SiteMember {
    /**
     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the id field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private String id;

    /**

     * <p><strong>RU:</strong> значение поля «person» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the person field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private Person person;

    /**

     * <p><strong>RU:</strong> значение поля «role» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the role field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private String role;

    /**

     * <p><strong>RU:</strong> значение поля «is member of group» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the is member of group field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean isMemberOfGroup;

    /**
     * RU: Создаёт экземпляр SiteMember.
     * EN: Creates a SiteMember instance.
     */
    public SiteMember() {
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
     * <p><strong>RU:</strong> Возвращает значение поля «role» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the role field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение role. EN: current value of role.
     */

    public String getRole() {
        return role;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «role» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the role field in the Alfresco REST API model.</p>
     *
     * @param role RU: новое значение role. EN: new value for role.
     */

    public void setRole(String role) {
        this.role = role;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «is member of group» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the is member of group field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение isMemberOfGroup. EN: current value of isMemberOfGroup.
     */

    public Boolean getIsMemberOfGroup() {
        return isMemberOfGroup;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «is member of group» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the is member of group field in the Alfresco REST API model.</p>
     *
     * @param isMemberOfGroup RU: новое значение isMemberOfGroup. EN: new value for isMemberOfGroup.
     */

    public void setIsMemberOfGroup(Boolean isMemberOfGroup) {
        this.isMemberOfGroup = isMemberOfGroup;
    }

}
