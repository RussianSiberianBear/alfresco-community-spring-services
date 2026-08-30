package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;

/**
 * RU: DTO-модель Alfresco REST API: NodeBodyUpdate.
 * EN: Alfresco REST API DTO model: NodeBodyUpdate.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NodeBodyUpdate {
    /**
     * <p><strong>RU:</strong> имя ресурса Alfresco. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> The name must not contain spaces or the following special characters: * " &lt; &gt; \ / ? : and |. The character . must not be used at the end of the name.. Optional unless a specific endpoint requires it.</p>
     */
    private String name;

    /**

     * <p><strong>RU:</strong> QName типа узла Alfresco. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the node type field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String nodeType;

    /**

     * <p><strong>RU:</strong> QName аспектов, применённых к узлу. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the aspect names field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private List<String> aspectNames;

    /**

     * <p><strong>RU:</strong> динамические свойства Alfresco, индексированные по QName. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the properties field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Map<String, String> properties;

    /**

     * <p><strong>RU:</strong> данные permissions/ACL. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the permissions field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private PermissionsBody permissions;

    /**
     * RU: Создаёт экземпляр NodeBodyUpdate.
     * EN: Creates a NodeBodyUpdate instance.
     */
    public NodeBodyUpdate() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает имя ресурса Alfresco.</p>
     * <p><strong>EN:</strong> Returns The name must not contain spaces or the following special characters: * " &lt; &gt; \ / ? : and |. The character . must not be used at the end of the name..</p>
     *
     * @return RU: текущее значение name. EN: current value of name.
     */

    public String getName() {
        return name;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает имя ресурса Alfresco.</p>
     * <p><strong>EN:</strong> Sets The name must not contain spaces or the following special characters: * " &lt; &gt; \ / ? : and |. The character . must not be used at the end of the name..</p>
     *
     * @param name RU: новое значение name. EN: new value for name.
     */

    public void setName(String name) {
        this.name = name;
    }

        /**
     * <p><strong>RU:</strong> Возвращает QName типа узла Alfresco.</p>
     * <p><strong>EN:</strong> Returns Value of the node type field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение nodeType. EN: current value of nodeType.
     */

    public String getNodeType() {
        return nodeType;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает QName типа узла Alfresco.</p>
     * <p><strong>EN:</strong> Sets Value of the node type field in the Alfresco REST API model.</p>
     *
     * @param nodeType RU: новое значение nodeType. EN: new value for nodeType.
     */

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

        /**
     * <p><strong>RU:</strong> Возвращает QName аспектов, применённых к узлу.</p>
     * <p><strong>EN:</strong> Returns Value of the aspect names field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение aspectNames. EN: current value of aspectNames.
     */

    public List<String> getAspectNames() {
        return aspectNames;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает QName аспектов, применённых к узлу.</p>
     * <p><strong>EN:</strong> Sets Value of the aspect names field in the Alfresco REST API model.</p>
     *
     * @param aspectNames RU: новое значение aspectNames. EN: new value for aspectNames.
     */

    public void setAspectNames(List<String> aspectNames) {
        this.aspectNames = aspectNames;
    }

        /**
     * <p><strong>RU:</strong> Возвращает динамические свойства Alfresco, индексированные по QName.</p>
     * <p><strong>EN:</strong> Returns Value of the properties field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение properties. EN: current value of properties.
     */

    public Map<String, String> getProperties() {
        return properties;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает динамические свойства Alfresco, индексированные по QName.</p>
     * <p><strong>EN:</strong> Sets Value of the properties field in the Alfresco REST API model.</p>
     *
     * @param properties RU: новое значение properties. EN: new value for properties.
     */

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

        /**
     * <p><strong>RU:</strong> Возвращает данные permissions/ACL.</p>
     * <p><strong>EN:</strong> Returns Value of the permissions field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение permissions. EN: current value of permissions.
     */

    public PermissionsBody getPermissions() {
        return permissions;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает данные permissions/ACL.</p>
     * <p><strong>EN:</strong> Sets Value of the permissions field in the Alfresco REST API model.</p>
     *
     * @param permissions RU: новое значение permissions. EN: new value for permissions.
     */

    public void setPermissions(PermissionsBody permissions) {
        this.permissions = permissions;
    }

}
