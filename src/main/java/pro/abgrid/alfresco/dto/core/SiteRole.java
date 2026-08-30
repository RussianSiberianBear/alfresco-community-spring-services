package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: SiteRole.
 * EN: Alfresco REST API DTO model: SiteRole.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SiteRole {
    /**
     * <p><strong>RU:</strong> значение поля «site» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the site field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private Site site;

    /**

     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the id field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private String id;

    /**

     * <p><strong>RU:</strong> значение поля «guid» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the guid field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private String guid;

    /**

     * <p><strong>RU:</strong> значение поля «role» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the role field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private String role;

    /**
     * RU: Создаёт экземпляр SiteRole.
     * EN: Creates a SiteRole instance.
     */
    public SiteRole() {
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
     * <p><strong>RU:</strong> Возвращает значение поля «guid» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the guid field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение guid. EN: current value of guid.
     */

    public String getGuid() {
        return guid;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «guid» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the guid field in the Alfresco REST API model.</p>
     *
     * @param guid RU: новое значение guid. EN: new value for guid.
     */

    public void setGuid(String guid) {
        this.guid = guid;
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
