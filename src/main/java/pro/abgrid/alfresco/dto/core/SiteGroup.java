package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: SiteGroup.
 * EN: Alfresco REST API DTO model: SiteGroup.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SiteGroup {
    /**
     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the id field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private String id;

    /**

     * <p><strong>RU:</strong> значение поля «group» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the group field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private GroupMember group;

    /**

     * <p><strong>RU:</strong> значение поля «role» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the role field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private String role;

    /**
     * RU: Создаёт экземпляр SiteGroup.
     * EN: Creates a SiteGroup instance.
     */
    public SiteGroup() {
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
     * <p><strong>RU:</strong> Возвращает значение поля «group» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the group field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение group. EN: current value of group.
     */

    public GroupMember getGroup() {
        return group;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «group» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the group field in the Alfresco REST API model.</p>
     *
     * @param group RU: новое значение group. EN: new value for group.
     */

    public void setGroup(GroupMember group) {
        this.group = group;
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

}
