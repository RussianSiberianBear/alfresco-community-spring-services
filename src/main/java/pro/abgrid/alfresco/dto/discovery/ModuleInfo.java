package pro.abgrid.alfresco.dto.discovery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;

/**
 * RU: DTO-модель Alfresco REST API: ModuleInfo.
 * EN: Alfresco REST API DTO model: ModuleInfo.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ModuleInfo {
    /**
     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Value of the id field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>
     */
    private String id;

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

     * <p><strong>RU:</strong> значение поля «version» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the version field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String version;

    /**

     * <p><strong>RU:</strong> значение поля «install date» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the install date field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private OffsetDateTime installDate;

    /**

     * <p><strong>RU:</strong> значение поля «install state» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the install state field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String installState;

    /**

     * <p><strong>RU:</strong> значение поля «version min» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the version min field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String versionMin;

    /**

     * <p><strong>RU:</strong> значение поля «version max» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the version max field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String versionMax;

    /**
     * RU: Создаёт экземпляр ModuleInfo.
     * EN: Creates a ModuleInfo instance.
     */
    public ModuleInfo() {
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
     * <p><strong>RU:</strong> Возвращает значение поля «version» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the version field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение version. EN: current value of version.
     */

    public String getVersion() {
        return version;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «version» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the version field in the Alfresco REST API model.</p>
     *
     * @param version RU: новое значение version. EN: new value for version.
     */

    public void setVersion(String version) {
        this.version = version;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «install date» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the install date field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение installDate. EN: current value of installDate.
     */

    public OffsetDateTime getInstallDate() {
        return installDate;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «install date» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the install date field in the Alfresco REST API model.</p>
     *
     * @param installDate RU: новое значение installDate. EN: new value for installDate.
     */

    public void setInstallDate(OffsetDateTime installDate) {
        this.installDate = installDate;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «install state» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the install state field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение installState. EN: current value of installState.
     */

    public String getInstallState() {
        return installState;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «install state» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the install state field in the Alfresco REST API model.</p>
     *
     * @param installState RU: новое значение installState. EN: new value for installState.
     */

    public void setInstallState(String installState) {
        this.installState = installState;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «version min» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the version min field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение versionMin. EN: current value of versionMin.
     */

    public String getVersionMin() {
        return versionMin;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «version min» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the version min field in the Alfresco REST API model.</p>
     *
     * @param versionMin RU: новое значение versionMin. EN: new value for versionMin.
     */

    public void setVersionMin(String versionMin) {
        this.versionMin = versionMin;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «version max» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the version max field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение versionMax. EN: current value of versionMax.
     */

    public String getVersionMax() {
        return versionMax;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «version max» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the version max field in the Alfresco REST API model.</p>
     *
     * @param versionMax RU: новое значение versionMax. EN: new value for versionMax.
     */

    public void setVersionMax(String versionMax) {
        this.versionMax = versionMax;
    }

}
