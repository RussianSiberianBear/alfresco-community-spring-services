package pro.abgrid.alfresco.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: Error.
 * EN: Alfresco REST API DTO model: Error.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Error {
    /**
     * <p><strong>RU:</strong> значение поля «error» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the error field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private Object error;

    /**
     * RU: Создаёт экземпляр Error.
     * EN: Creates a Error instance.
     */
    public Error() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «error» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the error field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение error. EN: current value of error.
     */

    public Object getError() {
        return error;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «error» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the error field in the Alfresco REST API model.</p>
     *
     * @param error RU: новое значение error. EN: new value for error.
     */

    public void setError(Object error) {
        this.error = error;
    }

}
