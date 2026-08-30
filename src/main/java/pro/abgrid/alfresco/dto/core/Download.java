package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: Download.
 * EN: Alfresco REST API DTO model: Download.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Download {
    /**
     * <p><strong>RU:</strong> значение поля «files added» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> number of files added so far in the zip. Optional unless a specific endpoint requires it.</p>
     */
    private Integer filesAdded;

    /**

     * <p><strong>RU:</strong> значение поля «bytes added» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> number of bytes added so far in the zip. Optional unless a specific endpoint requires it.</p>

     */

    private Integer bytesAdded;

    /**

     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> the id of the download node. Optional unless a specific endpoint requires it.</p>

     */

    private String id;

    /**

     * <p><strong>RU:</strong> значение поля «total files» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> the total number of files to be added in the zip. Optional unless a specific endpoint requires it.</p>

     */

    private Integer totalFiles;

    /**

     * <p><strong>RU:</strong> значение поля «total bytes» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> the total number of bytes to be added in the zip. Optional unless a specific endpoint requires it.</p>

     */

    private Integer totalBytes;

    /**

     * <p><strong>RU:</strong> значение поля «status» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> the current status of the download node creation. Optional unless a specific endpoint requires it.</p>

     */

    private String status;

    /**
     * RU: Создаёт экземпляр Download.
     * EN: Creates a Download instance.
     */
    public Download() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «files added» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns number of files added so far in the zip.</p>
     *
     * @return RU: текущее значение filesAdded. EN: current value of filesAdded.
     */

    public Integer getFilesAdded() {
        return filesAdded;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «files added» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets number of files added so far in the zip.</p>
     *
     * @param filesAdded RU: новое значение filesAdded. EN: new value for filesAdded.
     */

    public void setFilesAdded(Integer filesAdded) {
        this.filesAdded = filesAdded;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «bytes added» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns number of bytes added so far in the zip.</p>
     *
     * @return RU: текущее значение bytesAdded. EN: current value of bytesAdded.
     */

    public Integer getBytesAdded() {
        return bytesAdded;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «bytes added» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets number of bytes added so far in the zip.</p>
     *
     * @param bytesAdded RU: новое значение bytesAdded. EN: new value for bytesAdded.
     */

    public void setBytesAdded(Integer bytesAdded) {
        this.bytesAdded = bytesAdded;
    }

        /**
     * <p><strong>RU:</strong> Возвращает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Returns the id of the download node.</p>
     *
     * @return RU: текущее значение id. EN: current value of id.
     */

    public String getId() {
        return id;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Sets the id of the download node.</p>
     *
     * @param id RU: новое значение id. EN: new value for id.
     */

    public void setId(String id) {
        this.id = id;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «total files» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns the total number of files to be added in the zip.</p>
     *
     * @return RU: текущее значение totalFiles. EN: current value of totalFiles.
     */

    public Integer getTotalFiles() {
        return totalFiles;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «total files» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets the total number of files to be added in the zip.</p>
     *
     * @param totalFiles RU: новое значение totalFiles. EN: new value for totalFiles.
     */

    public void setTotalFiles(Integer totalFiles) {
        this.totalFiles = totalFiles;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «total bytes» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns the total number of bytes to be added in the zip.</p>
     *
     * @return RU: текущее значение totalBytes. EN: current value of totalBytes.
     */

    public Integer getTotalBytes() {
        return totalBytes;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «total bytes» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets the total number of bytes to be added in the zip.</p>
     *
     * @param totalBytes RU: новое значение totalBytes. EN: new value for totalBytes.
     */

    public void setTotalBytes(Integer totalBytes) {
        this.totalBytes = totalBytes;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «status» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns the current status of the download node creation.</p>
     *
     * @return RU: текущее значение status. EN: current value of status.
     */

    public String getStatus() {
        return status;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «status» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets the current status of the download node creation.</p>
     *
     * @param status RU: новое значение status. EN: new value for status.
     */

    public void setStatus(String status) {
        this.status = status;
    }

}
