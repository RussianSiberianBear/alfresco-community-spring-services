package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: RevertBody.
 * EN: Alfresco REST API DTO model: RevertBody.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RevertBody {
    /**
     * <p><strong>RU:</strong> значение поля «major version» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Value of the major version field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>
     */
    private Boolean majorVersion;

    /**

     * <p><strong>RU:</strong> значение поля «comment» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the comment field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String comment;

    /**
     * RU: Создаёт экземпляр RevertBody.
     * EN: Creates a RevertBody instance.
     */
    public RevertBody() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «major version» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the major version field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение majorVersion. EN: current value of majorVersion.
     */

    public Boolean getMajorVersion() {
        return majorVersion;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «major version» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the major version field in the Alfresco REST API model.</p>
     *
     * @param majorVersion RU: новое значение majorVersion. EN: new value for majorVersion.
     */

    public void setMajorVersion(Boolean majorVersion) {
        this.majorVersion = majorVersion;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «comment» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the comment field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение comment. EN: current value of comment.
     */

    public String getComment() {
        return comment;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «comment» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the comment field in the Alfresco REST API model.</p>
     *
     * @param comment RU: новое значение comment. EN: new value for comment.
     */

    public void setComment(String comment) {
        this.comment = comment;
    }

}
