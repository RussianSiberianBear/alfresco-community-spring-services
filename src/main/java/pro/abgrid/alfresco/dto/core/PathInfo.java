package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * RU: DTO-модель Alfresco REST API: PathInfo.
 * EN: Alfresco REST API DTO model: PathInfo.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PathInfo {
    /**
     * <p><strong>RU:</strong> значение поля «elements» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Value of the elements field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>
     */
    private List<PathElement> elements;

    /**

     * <p><strong>RU:</strong> имя ресурса Alfresco. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the name field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String name;

    /**

     * <p><strong>RU:</strong> значение поля «is complete» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the is complete field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean isComplete;

    /**
     * RU: Создаёт экземпляр PathInfo.
     * EN: Creates a PathInfo instance.
     */
    public PathInfo() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «elements» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the elements field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение elements. EN: current value of elements.
     */

    public List<PathElement> getElements() {
        return elements;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «elements» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the elements field in the Alfresco REST API model.</p>
     *
     * @param elements RU: новое значение elements. EN: new value for elements.
     */

    public void setElements(List<PathElement> elements) {
        this.elements = elements;
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

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «is complete» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the is complete field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение isComplete. EN: current value of isComplete.
     */

    public Boolean getIsComplete() {
        return isComplete;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «is complete» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the is complete field in the Alfresco REST API model.</p>
     *
     * @param isComplete RU: новое значение isComplete. EN: new value for isComplete.
     */

    public void setIsComplete(Boolean isComplete) {
        this.isComplete = isComplete;
    }

}
