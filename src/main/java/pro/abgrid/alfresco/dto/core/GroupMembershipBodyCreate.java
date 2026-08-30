package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: GroupMembershipBodyCreate.
 * EN: Alfresco REST API DTO model: GroupMembershipBodyCreate.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupMembershipBodyCreate {
    /**
     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the id field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private String id;

    /**

     * <p><strong>RU:</strong> значение поля «member type» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the member type field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private String memberType;

    /**
     * RU: Создаёт экземпляр GroupMembershipBodyCreate.
     * EN: Creates a GroupMembershipBodyCreate instance.
     */
    public GroupMembershipBodyCreate() {
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
     * <p><strong>RU:</strong> Возвращает значение поля «member type» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the member type field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение memberType. EN: current value of memberType.
     */

    public String getMemberType() {
        return memberType;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «member type» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the member type field in the Alfresco REST API model.</p>
     *
     * @param memberType RU: новое значение memberType. EN: new value for memberType.
     */

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

}
