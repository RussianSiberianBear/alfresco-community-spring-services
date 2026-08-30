package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: getNodeSizeDetailsResponse.
 * EN: Alfresco REST API DTO model: getNodeSizeDetailsResponse.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class getNodeSizeDetailsResponse {
    /**
     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Provides the nodeId for which POST/size-details has been initiated.. Optional unless a specific endpoint requires it.</p>
     */
    private String id;

    /**

     * <p><strong>RU:</strong> размер содержимого в байтах. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The folder size in bytes.. Optional unless a specific endpoint requires it.</p>

     */

    private String sizeInBytes;

    /**

     * <p><strong>RU:</strong> значение поля «calculated at» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Provides the timestamp when the calculation of folder size is completed.. Optional unless a specific endpoint requires it.</p>

     */

    private String calculatedAt;

    /**

     * <p><strong>RU:</strong> значение поля «number of files» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Provides the number of files in the folder.. Optional unless a specific endpoint requires it.</p>

     */

    private Integer numberOfFiles;

    /**

     * <p><strong>RU:</strong> значение поля «status» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Provides a status that signifies the completion of the calculateSize mechanism. NOT-INITIATED: Not Initiated yet. IN-PROGRESS: Calculation is in progress. COMPLETED: Calculation has been done.. Optional unless a specific endpoint requires it.</p>

     */

    private String status;

    /**

     * <p><strong>RU:</strong> значение поля «job id» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Provides the getId for which POST/size-details has been initiated.. Optional unless a specific endpoint requires it.</p>

     */

    private String jobId;

    /**
     * RU: Создаёт экземпляр getNodeSizeDetailsResponse.
     * EN: Creates a getNodeSizeDetailsResponse instance.
     */
    public getNodeSizeDetailsResponse() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Returns Provides the nodeId for which POST/size-details has been initiated..</p>
     *
     * @return RU: текущее значение id. EN: current value of id.
     */

    public String getId() {
        return id;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Sets Provides the nodeId for which POST/size-details has been initiated..</p>
     *
     * @param id RU: новое значение id. EN: new value for id.
     */

    public void setId(String id) {
        this.id = id;
    }

        /**
     * <p><strong>RU:</strong> Возвращает размер содержимого в байтах.</p>
     * <p><strong>EN:</strong> Returns The folder size in bytes..</p>
     *
     * @return RU: текущее значение sizeInBytes. EN: current value of sizeInBytes.
     */

    public String getSizeInBytes() {
        return sizeInBytes;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает размер содержимого в байтах.</p>
     * <p><strong>EN:</strong> Sets The folder size in bytes..</p>
     *
     * @param sizeInBytes RU: новое значение sizeInBytes. EN: new value for sizeInBytes.
     */

    public void setSizeInBytes(String sizeInBytes) {
        this.sizeInBytes = sizeInBytes;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «calculated at» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Provides the timestamp when the calculation of folder size is completed..</p>
     *
     * @return RU: текущее значение calculatedAt. EN: current value of calculatedAt.
     */

    public String getCalculatedAt() {
        return calculatedAt;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «calculated at» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Provides the timestamp when the calculation of folder size is completed..</p>
     *
     * @param calculatedAt RU: новое значение calculatedAt. EN: new value for calculatedAt.
     */

    public void setCalculatedAt(String calculatedAt) {
        this.calculatedAt = calculatedAt;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «number of files» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Provides the number of files in the folder..</p>
     *
     * @return RU: текущее значение numberOfFiles. EN: current value of numberOfFiles.
     */

    public Integer getNumberOfFiles() {
        return numberOfFiles;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «number of files» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Provides the number of files in the folder..</p>
     *
     * @param numberOfFiles RU: новое значение numberOfFiles. EN: new value for numberOfFiles.
     */

    public void setNumberOfFiles(Integer numberOfFiles) {
        this.numberOfFiles = numberOfFiles;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «status» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Provides a status that signifies the completion of the calculateSize mechanism. NOT-INITIATED: Not Initiated yet. IN-PROGRESS: Calculation is in progress. COMPLETED: Calculation has been done..</p>
     *
     * @return RU: текущее значение status. EN: current value of status.
     */

    public String getStatus() {
        return status;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «status» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Provides a status that signifies the completion of the calculateSize mechanism. NOT-INITIATED: Not Initiated yet. IN-PROGRESS: Calculation is in progress. COMPLETED: Calculation has been done..</p>
     *
     * @param status RU: новое значение status. EN: new value for status.
     */

    public void setStatus(String status) {
        this.status = status;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «job id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Provides the getId for which POST/size-details has been initiated..</p>
     *
     * @return RU: текущее значение jobId. EN: current value of jobId.
     */

    public String getJobId() {
        return jobId;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «job id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Provides the getId for which POST/size-details has been initiated..</p>
     *
     * @param jobId RU: новое значение jobId. EN: new value for jobId.
     */

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

}
