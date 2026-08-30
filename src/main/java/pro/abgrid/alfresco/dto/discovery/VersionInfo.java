package pro.abgrid.alfresco.dto.discovery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: VersionInfo.
 * EN: Alfresco REST API DTO model: VersionInfo.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VersionInfo {
    /**
     * <p><strong>RU:</strong> значение поля «major» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the major field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private String major;

    /**

     * <p><strong>RU:</strong> значение поля «minor» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the minor field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private String minor;

    /**

     * <p><strong>RU:</strong> значение поля «patch» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the patch field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private String patch;

    /**

     * <p><strong>RU:</strong> значение поля «hotfix» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the hotfix field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private String hotfix;

    /**

     * <p><strong>RU:</strong> значение поля «schema» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the schema field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private Integer schema;

    /**

     * <p><strong>RU:</strong> значение поля «label» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the label field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private String label;

    /**

     * <p><strong>RU:</strong> значение поля «display» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the display field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private String display;

    /**
     * RU: Создаёт экземпляр VersionInfo.
     * EN: Creates a VersionInfo instance.
     */
    public VersionInfo() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «major» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the major field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение major. EN: current value of major.
     */

    public String getMajor() {
        return major;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «major» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the major field in the Alfresco REST API model.</p>
     *
     * @param major RU: новое значение major. EN: new value for major.
     */

    public void setMajor(String major) {
        this.major = major;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «minor» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the minor field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение minor. EN: current value of minor.
     */

    public String getMinor() {
        return minor;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «minor» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the minor field in the Alfresco REST API model.</p>
     *
     * @param minor RU: новое значение minor. EN: new value for minor.
     */

    public void setMinor(String minor) {
        this.minor = minor;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «patch» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the patch field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение patch. EN: current value of patch.
     */

    public String getPatch() {
        return patch;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «patch» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the patch field in the Alfresco REST API model.</p>
     *
     * @param patch RU: новое значение patch. EN: new value for patch.
     */

    public void setPatch(String patch) {
        this.patch = patch;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «hotfix» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the hotfix field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение hotfix. EN: current value of hotfix.
     */

    public String getHotfix() {
        return hotfix;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «hotfix» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the hotfix field in the Alfresco REST API model.</p>
     *
     * @param hotfix RU: новое значение hotfix. EN: new value for hotfix.
     */

    public void setHotfix(String hotfix) {
        this.hotfix = hotfix;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «schema» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the schema field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение schema. EN: current value of schema.
     */

    public Integer getSchema() {
        return schema;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «schema» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the schema field in the Alfresco REST API model.</p>
     *
     * @param schema RU: новое значение schema. EN: new value for schema.
     */

    public void setSchema(Integer schema) {
        this.schema = schema;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «label» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the label field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение label. EN: current value of label.
     */

    public String getLabel() {
        return label;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «label» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the label field in the Alfresco REST API model.</p>
     *
     * @param label RU: новое значение label. EN: new value for label.
     */

    public void setLabel(String label) {
        this.label = label;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «display» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the display field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение display. EN: current value of display.
     */

    public String getDisplay() {
        return display;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «display» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the display field in the Alfresco REST API model.</p>
     *
     * @param display RU: новое значение display. EN: new value for display.
     */

    public void setDisplay(String display) {
        this.display = display;
    }

}
