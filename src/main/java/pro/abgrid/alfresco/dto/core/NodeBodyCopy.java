package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: NodeBodyCopy.
 * EN: Alfresco REST API DTO model: NodeBodyCopy.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NodeBodyCopy {
    /**
     * <p><strong>RU:</strong> значение поля «target parent id» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the target parent id field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private String targetParentId;

    /**

     * <p><strong>RU:</strong> имя ресурса Alfresco. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The name must not contain spaces or the following special characters: * " &lt; &gt; \ / ? : and |. The character . must not be used at the end of the name.. Optional unless a specific endpoint requires it.</p>

     */

    private String name;

    /**
     * RU: Создаёт экземпляр NodeBodyCopy.
     * EN: Creates a NodeBodyCopy instance.
     */
    public NodeBodyCopy() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «target parent id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the target parent id field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение targetParentId. EN: current value of targetParentId.
     */

    public String getTargetParentId() {
        return targetParentId;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «target parent id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the target parent id field in the Alfresco REST API model.</p>
     *
     * @param targetParentId RU: новое значение targetParentId. EN: new value for targetParentId.
     */

    public void setTargetParentId(String targetParentId) {
        this.targetParentId = targetParentId;
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

}
