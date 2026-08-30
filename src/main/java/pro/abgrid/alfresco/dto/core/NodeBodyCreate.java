package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;

/**
 * RU: DTO-модель Alfresco REST API: NodeBodyCreate.
 * EN: Alfresco REST API DTO model: NodeBodyCreate.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NodeBodyCreate {
    /**
     * <p><strong>RU:</strong> имя ресурса Alfresco. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> The name must not contain spaces or the following special characters: * " &lt; &gt; \ / ? : and |. The character . must not be used at the end of the name.. Required by the Swagger schema.</p>
     */
    private String name;

    /**

     * <p><strong>RU:</strong> QName типа узла Alfresco. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the node type field in the Alfresco REST API model. Required by the Swagger schema.</p>

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

    private Map<String, Object> properties;

    /**

     * <p><strong>RU:</strong> данные permissions/ACL. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the permissions field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private PermissionsBody permissions;

    /**

     * <p><strong>RU:</strong> значение поля «definition» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the definition field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Definition definition;

    /**

     * <p><strong>RU:</strong> относительный путь ресурса. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the relative path field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String relativePath;

    /**

     * <p><strong>RU:</strong> значение поля «association» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the association field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Object association;

    /**

     * <p><strong>RU:</strong> значение поля «secondary children» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the secondary children field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private List<ChildAssociationBody> secondaryChildren;

    /**

     * <p><strong>RU:</strong> значение поля «targets» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the targets field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private List<AssociationBody> targets;

    /**
     * RU: Создаёт экземпляр NodeBodyCreate.
     * EN: Creates a NodeBodyCreate instance.
     */
    public NodeBodyCreate() {
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

    public Map<String, Object> getProperties() {
        return properties;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает динамические свойства Alfresco, индексированные по QName.</p>
     * <p><strong>EN:</strong> Sets Value of the properties field in the Alfresco REST API model.</p>
     *
     * @param properties RU: новое значение properties. EN: new value for properties.
     */

    public void setProperties(Map<String, Object> properties) {
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

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «definition» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the definition field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение definition. EN: current value of definition.
     */

    public Definition getDefinition() {
        return definition;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «definition» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the definition field in the Alfresco REST API model.</p>
     *
     * @param definition RU: новое значение definition. EN: new value for definition.
     */

    public void setDefinition(Definition definition) {
        this.definition = definition;
    }

        /**
     * <p><strong>RU:</strong> Возвращает относительный путь ресурса.</p>
     * <p><strong>EN:</strong> Returns Value of the relative path field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение relativePath. EN: current value of relativePath.
     */

    public String getRelativePath() {
        return relativePath;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает относительный путь ресурса.</p>
     * <p><strong>EN:</strong> Sets Value of the relative path field in the Alfresco REST API model.</p>
     *
     * @param relativePath RU: новое значение relativePath. EN: new value for relativePath.
     */

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «association» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the association field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение association. EN: current value of association.
     */

    public Object getAssociation() {
        return association;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «association» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the association field in the Alfresco REST API model.</p>
     *
     * @param association RU: новое значение association. EN: new value for association.
     */

    public void setAssociation(Object association) {
        this.association = association;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «secondary children» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the secondary children field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение secondaryChildren. EN: current value of secondaryChildren.
     */

    public List<ChildAssociationBody> getSecondaryChildren() {
        return secondaryChildren;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «secondary children» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the secondary children field in the Alfresco REST API model.</p>
     *
     * @param secondaryChildren RU: новое значение secondaryChildren. EN: new value for secondaryChildren.
     */

    public void setSecondaryChildren(List<ChildAssociationBody> secondaryChildren) {
        this.secondaryChildren = secondaryChildren;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «targets» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the targets field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение targets. EN: current value of targets.
     */

    public List<AssociationBody> getTargets() {
        return targets;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «targets» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the targets field in the Alfresco REST API model.</p>
     *
     * @param targets RU: новое значение targets. EN: new value for targets.
     */

    public void setTargets(List<AssociationBody> targets) {
        this.targets = targets;
    }

}
