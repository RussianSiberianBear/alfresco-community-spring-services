package pro.abgrid.alfresco.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: PathElement.
 * EN: Alfresco REST API DTO model: PathElement.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PathElement {
    /**
     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Value of the id field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>
     */
    private String id;

    /**

     * <p><strong>RU:</strong> имя ресурса Alfresco. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the name field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String name;

    /**
     * RU: Создаёт экземпляр PathElement.
     * EN: Creates a PathElement instance.
     */
    public PathElement() {
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
     * <p><strong>RU:</strong> Возвращает имя ресурса Alfresco.</p>
     * <p><strong>EN:</strong> Returns Value of the name field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение name. EN: current value of name.
     */

    public String getName() {
        return name;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает имя ресурса Alfresco.</p>
     * <p><strong>EN:</strong> Sets Value of the name field in the Alfresco REST API model.</p>
     *
     * @param name RU: новое значение name. EN: new value for name.
     */

    public void setName(String name) {
        this.name = name;
    }

}
