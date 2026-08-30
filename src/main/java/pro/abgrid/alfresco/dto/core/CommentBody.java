package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: CommentBody.
 * EN: Alfresco REST API DTO model: CommentBody.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentBody {
    /**
     * <p><strong>RU:</strong> метаданные бинарного содержимого. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the content field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private String content;

    /**
     * RU: Создаёт экземпляр CommentBody.
     * EN: Creates a CommentBody instance.
     */
    public CommentBody() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает метаданные бинарного содержимого.</p>
     * <p><strong>EN:</strong> Returns Value of the content field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение content. EN: current value of content.
     */

    public String getContent() {
        return content;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает метаданные бинарного содержимого.</p>
     * <p><strong>EN:</strong> Sets Value of the content field in the Alfresco REST API model.</p>
     *
     * @param content RU: новое значение content. EN: new value for content.
     */

    public void setContent(String content) {
        this.content = content;
    }

}
