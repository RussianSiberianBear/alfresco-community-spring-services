package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: Site.
 * EN: Alfresco REST API DTO model: Site.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Site {
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

     * <p><strong>RU:</strong> значение поля «title» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the title field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private String title;

    /**

     * <p><strong>RU:</strong> значение поля «description» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the description field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String description;

    /**

     * <p><strong>RU:</strong> значение поля «visibility» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the visibility field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private String visibility;

    /**

     * <p><strong>RU:</strong> значение поля «preset» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the preset field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String preset;

    /**

     * <p><strong>RU:</strong> значение поля «role» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the role field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String role;

    /**
     * RU: Создаёт экземпляр Site.
     * EN: Creates a Site instance.
     */
    public Site() {
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
     * <p><strong>RU:</strong> Возвращает значение поля «title» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the title field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение title. EN: current value of title.
     */

    public String getTitle() {
        return title;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «title» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the title field in the Alfresco REST API model.</p>
     *
     * @param title RU: новое значение title. EN: new value for title.
     */

    public void setTitle(String title) {
        this.title = title;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «description» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the description field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение description. EN: current value of description.
     */

    public String getDescription() {
        return description;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «description» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the description field in the Alfresco REST API model.</p>
     *
     * @param description RU: новое значение description. EN: new value for description.
     */

    public void setDescription(String description) {
        this.description = description;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «visibility» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the visibility field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение visibility. EN: current value of visibility.
     */

    public String getVisibility() {
        return visibility;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «visibility» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the visibility field in the Alfresco REST API model.</p>
     *
     * @param visibility RU: новое значение visibility. EN: new value for visibility.
     */

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «preset» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the preset field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение preset. EN: current value of preset.
     */

    public String getPreset() {
        return preset;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «preset» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the preset field in the Alfresco REST API model.</p>
     *
     * @param preset RU: новое значение preset. EN: new value for preset.
     */

    public void setPreset(String preset) {
        this.preset = preset;
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
