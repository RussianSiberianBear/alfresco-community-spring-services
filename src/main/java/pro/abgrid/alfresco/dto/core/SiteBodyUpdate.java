package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: SiteBodyUpdate.
 * EN: Alfresco REST API DTO model: SiteBodyUpdate.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SiteBodyUpdate {
    /**
     * <p><strong>RU:</strong> значение поля «title» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Value of the title field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>
     */
    private String title;

    /**

     * <p><strong>RU:</strong> значение поля «description» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the description field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String description;

    /**

     * <p><strong>RU:</strong> значение поля «visibility» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the visibility field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String visibility;

    /**
     * RU: Создаёт экземпляр SiteBodyUpdate.
     * EN: Creates a SiteBodyUpdate instance.
     */
    public SiteBodyUpdate() {
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

}
