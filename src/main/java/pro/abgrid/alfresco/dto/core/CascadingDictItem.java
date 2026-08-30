package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;

/**
 * RU: DTO-модель Alfresco REST API: CascadingDictItem.
 * EN: Alfresco REST API DTO model: CascadingDictItem.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CascadingDictItem {
    /**
     * <p><strong>RU:</strong> динамические свойства Alfresco, индексированные по QName. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> A map of properties for the given dictionary entry. The key is the prefixed name of the property. The value is a JSON value that can be deserialized according to aspect property definition (for example, a string or number).. Required by the Swagger schema.</p>
     */
    private Map<String, Object> properties;

    /**

     * <p><strong>RU:</strong> значение поля «children» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The child items of this item in the cascading dictionary hierarchy. It uses the same object definition as the parent item, so it can be used recursively for any number of levels in the hierarchy. For leaf items, the children array is empty.. Optional unless a specific endpoint requires it.</p>

     */

    private List<CascadingDictItem> children;

    /**
     * RU: Создаёт экземпляр CascadingDictItem.
     * EN: Creates a CascadingDictItem instance.
     */
    public CascadingDictItem() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает динамические свойства Alfresco, индексированные по QName.</p>
     * <p><strong>EN:</strong> Returns A map of properties for the given dictionary entry. The key is the prefixed name of the property. The value is a JSON value that can be deserialized according to aspect property definition (for example, a string or number)..</p>
     *
     * @return RU: текущее значение properties. EN: current value of properties.
     */

    public Map<String, Object> getProperties() {
        return properties;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает динамические свойства Alfresco, индексированные по QName.</p>
     * <p><strong>EN:</strong> Sets A map of properties for the given dictionary entry. The key is the prefixed name of the property. The value is a JSON value that can be deserialized according to aspect property definition (for example, a string or number)..</p>
     *
     * @param properties RU: новое значение properties. EN: new value for properties.
     */

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «children» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The child items of this item in the cascading dictionary hierarchy. It uses the same object definition as the parent item, so it can be used recursively for any number of levels in the hierarchy. For leaf items, the children array is empty..</p>
     *
     * @return RU: текущее значение children. EN: current value of children.
     */

    public List<CascadingDictItem> getChildren() {
        return children;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «children» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The child items of this item in the cascading dictionary hierarchy. It uses the same object definition as the parent item, so it can be used recursively for any number of levels in the hierarchy. For leaf items, the children array is empty..</p>
     *
     * @param children RU: новое значение children. EN: new value for children.
     */

    public void setChildren(List<CascadingDictItem> children) {
        this.children = children;
    }

}
