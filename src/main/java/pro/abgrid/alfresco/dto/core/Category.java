package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: Category.
 * EN: Alfresco REST API DTO model: Category.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {
    /**
     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> The identifier for the category.. Required by the Swagger schema.</p>
     */
    private String id;

    /**

     * <p><strong>RU:</strong> имя ресурса Alfresco. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> The name of the category. This must be unique within the parent category.. Required by the Swagger schema.</p>

     */

    private String name;

    /**

     * <p><strong>RU:</strong> идентификатор родительского узла. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The id of the parent category (or -root- if this is a top level category).. Optional unless a specific endpoint requires it.</p>

     */

    private String parentId;

    /**

     * <p><strong>RU:</strong> значение поля «has children» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> True if the category has at least one child category.. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean hasChildren;

    /**

     * <p><strong>RU:</strong> значение поля «count» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The number of nodes that are assigned to this category.. Optional unless a specific endpoint requires it.</p>

     */

    private Double count;

    /**

     * <p><strong>RU:</strong> значение поля «path» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The path to this category.. Optional unless a specific endpoint requires it.</p>

     */

    private String path;

    /**
     * RU: Создаёт экземпляр Category.
     * EN: Creates a Category instance.
     */
    public Category() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Returns The identifier for the category..</p>
     *
     * @return RU: текущее значение id. EN: current value of id.
     */

    public String getId() {
        return id;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Sets The identifier for the category..</p>
     *
     * @param id RU: новое значение id. EN: new value for id.
     */

    public void setId(String id) {
        this.id = id;
    }

        /**
     * <p><strong>RU:</strong> Возвращает имя ресурса Alfresco.</p>
     * <p><strong>EN:</strong> Returns The name of the category. This must be unique within the parent category..</p>
     *
     * @return RU: текущее значение name. EN: current value of name.
     */

    public String getName() {
        return name;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает имя ресурса Alfresco.</p>
     * <p><strong>EN:</strong> Sets The name of the category. This must be unique within the parent category..</p>
     *
     * @param name RU: новое значение name. EN: new value for name.
     */

    public void setName(String name) {
        this.name = name;
    }

        /**
     * <p><strong>RU:</strong> Возвращает идентификатор родительского узла.</p>
     * <p><strong>EN:</strong> Returns The id of the parent category (or -root- if this is a top level category)..</p>
     *
     * @return RU: текущее значение parentId. EN: current value of parentId.
     */

    public String getParentId() {
        return parentId;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает идентификатор родительского узла.</p>
     * <p><strong>EN:</strong> Sets The id of the parent category (or -root- if this is a top level category)..</p>
     *
     * @param parentId RU: новое значение parentId. EN: new value for parentId.
     */

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «has children» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns True if the category has at least one child category..</p>
     *
     * @return RU: текущее значение hasChildren. EN: current value of hasChildren.
     */

    public Boolean getHasChildren() {
        return hasChildren;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «has children» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets True if the category has at least one child category..</p>
     *
     * @param hasChildren RU: новое значение hasChildren. EN: new value for hasChildren.
     */

    public void setHasChildren(Boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «count» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The number of nodes that are assigned to this category..</p>
     *
     * @return RU: текущее значение count. EN: current value of count.
     */

    public Double getCount() {
        return count;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «count» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The number of nodes that are assigned to this category..</p>
     *
     * @param count RU: новое значение count. EN: new value for count.
     */

    public void setCount(Double count) {
        this.count = count;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «path» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The path to this category..</p>
     *
     * @return RU: текущее значение path. EN: current value of path.
     */

    public String getPath() {
        return path;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «path» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The path to this category..</p>
     *
     * @param path RU: новое значение path. EN: new value for path.
     */

    public void setPath(String path) {
        this.path = path;
    }

}
