package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: sizeDetailsRequestExecResult.
 * EN: Alfresco REST API DTO model: sizeDetailsRequestExecResult.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class sizeDetailsRequestExecResult {
    /**
     * <p><strong>RU:</strong> значение поля «job id» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> The unique identifier of the size details execution request. Required by the Swagger schema.</p>
     */
    private String jobId;

    /**
     * RU: Создаёт экземпляр sizeDetailsRequestExecResult.
     * EN: Creates a sizeDetailsRequestExecResult instance.
     */
    public sizeDetailsRequestExecResult() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «job id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The unique identifier of the size details execution request.</p>
     *
     * @return RU: текущее значение jobId. EN: current value of jobId.
     */

    public String getJobId() {
        return jobId;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «job id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The unique identifier of the size details execution request.</p>
     *
     * @param jobId RU: новое значение jobId. EN: new value for jobId.
     */

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

}
