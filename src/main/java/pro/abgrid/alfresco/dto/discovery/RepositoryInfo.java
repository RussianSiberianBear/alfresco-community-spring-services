package pro.abgrid.alfresco.dto.discovery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * RU: DTO-модель Alfresco REST API: RepositoryInfo.
 * EN: Alfresco REST API DTO model: RepositoryInfo.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryInfo {
    /**
     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the id field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private String id;

    /**

     * <p><strong>RU:</strong> значение поля «edition» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the edition field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private String edition;

    /**

     * <p><strong>RU:</strong> значение поля «version» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the version field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private VersionInfo version;

    /**

     * <p><strong>RU:</strong> значение поля «status» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the status field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private StatusInfo status;

    /**

     * <p><strong>RU:</strong> значение поля «license» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the license field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private LicenseInfo license;

    /**

     * <p><strong>RU:</strong> значение поля «modules» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the modules field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private List<ModuleInfo> modules;

    /**
     * RU: Создаёт экземпляр RepositoryInfo.
     * EN: Creates a RepositoryInfo instance.
     */
    public RepositoryInfo() {
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
     * <p><strong>RU:</strong> Возвращает значение поля «edition» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the edition field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение edition. EN: current value of edition.
     */

    public String getEdition() {
        return edition;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «edition» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the edition field in the Alfresco REST API model.</p>
     *
     * @param edition RU: новое значение edition. EN: new value for edition.
     */

    public void setEdition(String edition) {
        this.edition = edition;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «version» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the version field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение version. EN: current value of version.
     */

    public VersionInfo getVersion() {
        return version;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «version» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the version field in the Alfresco REST API model.</p>
     *
     * @param version RU: новое значение version. EN: new value for version.
     */

    public void setVersion(VersionInfo version) {
        this.version = version;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «status» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the status field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение status. EN: current value of status.
     */

    public StatusInfo getStatus() {
        return status;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «status» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the status field in the Alfresco REST API model.</p>
     *
     * @param status RU: новое значение status. EN: new value for status.
     */

    public void setStatus(StatusInfo status) {
        this.status = status;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «license» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the license field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение license. EN: current value of license.
     */

    public LicenseInfo getLicense() {
        return license;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «license» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the license field in the Alfresco REST API model.</p>
     *
     * @param license RU: новое значение license. EN: new value for license.
     */

    public void setLicense(LicenseInfo license) {
        this.license = license;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «modules» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the modules field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение modules. EN: current value of modules.
     */

    public List<ModuleInfo> getModules() {
        return modules;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «modules» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the modules field in the Alfresco REST API model.</p>
     *
     * @param modules RU: новое значение modules. EN: new value for modules.
     */

    public void setModules(List<ModuleInfo> modules) {
        this.modules = modules;
    }

}
