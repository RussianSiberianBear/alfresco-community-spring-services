package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: Rendition.
 * EN: Alfresco REST API DTO model: Rendition.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rendition {
    /**
     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Value of the id field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>
     */
    private String id;

    /**

     * <p><strong>RU:</strong> метаданные бинарного содержимого. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the content field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private ContentInfo content;

    /**

     * <p><strong>RU:</strong> значение поля «status» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the status field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String status;

    /**
     * RU: Создаёт экземпляр Rendition.
     * EN: Creates a Rendition instance.
     */
    public Rendition() {
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
     * <p><strong>RU:</strong> Возвращает метаданные бинарного содержимого.</p>
     * <p><strong>EN:</strong> Returns Value of the content field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение content. EN: current value of content.
     */

    public ContentInfo getContent() {
        return content;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает метаданные бинарного содержимого.</p>
     * <p><strong>EN:</strong> Sets Value of the content field in the Alfresco REST API model.</p>
     *
     * @param content RU: новое значение content. EN: new value for content.
     */

    public void setContent(ContentInfo content) {
        this.content = content;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «status» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the status field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение status. EN: current value of status.
     */

    public String getStatus() {
        return status;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «status» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the status field in the Alfresco REST API model.</p>
     *
     * @param status RU: новое значение status. EN: new value for status.
     */

    public void setStatus(String status) {
        this.status = status;
    }

}
