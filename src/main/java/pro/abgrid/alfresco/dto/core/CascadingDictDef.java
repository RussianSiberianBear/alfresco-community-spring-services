package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * RU: DTO-модель Alfresco REST API: CascadingDictDef.
 * EN: Alfresco REST API DTO model: CascadingDictDef.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CascadingDictDef {
    /**
     * <p><strong>RU:</strong> имя ресурса Alfresco. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> The name of the cascading dictionary, e.g. "Accounts".. Required by the Swagger schema.</p>
     */
    private String name;

    /**

     * <p><strong>RU:</strong> значение поля «aspect» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> The prefixed name of the aspect describing the cascading dictionary, e.g. 'cdict:account'.. Required by the Swagger schema.</p>

     */

    private String aspect;

    /**

     * <p><strong>RU:</strong> значение поля «key property» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> The prefixed name of the key property of the cascading dictionary, e.g. 'cdict:accountNumber'.. Required by the Swagger schema.</p>

     */

    private String keyProperty;

    /**

     * <p><strong>RU:</strong> значение поля «version property» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> The prefixed name of the version property of the cascading dictionary, e.g. 'cdict:accountDictVersion'.. Required by the Swagger schema.</p>

     */

    private String versionProperty;

    /**

     * <p><strong>RU:</strong> значение поля «version» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> The version of the cascading dictionary definition, e.g. '1.5'.. Required by the Swagger schema.</p>

     */

    private String version;

    /**

     * <p><strong>RU:</strong> значение поля «levels» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the levels field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private List<CascadingDictLevel> levels;

    /**

     * <p><strong>RU:</strong> дата и время создания. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the created at field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private OffsetDateTime createdAt;

    /**

     * <p><strong>RU:</strong> дата и время последнего изменения. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the modified at field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private OffsetDateTime modifiedAt;

    /**
     * RU: Создаёт экземпляр CascadingDictDef.
     * EN: Creates a CascadingDictDef instance.
     */
    public CascadingDictDef() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает имя ресурса Alfresco.</p>
     * <p><strong>EN:</strong> Returns The name of the cascading dictionary, e.g. "Accounts"..</p>
     *
     * @return RU: текущее значение name. EN: current value of name.
     */

    public String getName() {
        return name;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает имя ресурса Alfresco.</p>
     * <p><strong>EN:</strong> Sets The name of the cascading dictionary, e.g. "Accounts"..</p>
     *
     * @param name RU: новое значение name. EN: new value for name.
     */

    public void setName(String name) {
        this.name = name;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «aspect» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The prefixed name of the aspect describing the cascading dictionary, e.g. 'cdict:account'..</p>
     *
     * @return RU: текущее значение aspect. EN: current value of aspect.
     */

    public String getAspect() {
        return aspect;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «aspect» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The prefixed name of the aspect describing the cascading dictionary, e.g. 'cdict:account'..</p>
     *
     * @param aspect RU: новое значение aspect. EN: new value for aspect.
     */

    public void setAspect(String aspect) {
        this.aspect = aspect;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «key property» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The prefixed name of the key property of the cascading dictionary, e.g. 'cdict:accountNumber'..</p>
     *
     * @return RU: текущее значение keyProperty. EN: current value of keyProperty.
     */

    public String getKeyProperty() {
        return keyProperty;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «key property» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The prefixed name of the key property of the cascading dictionary, e.g. 'cdict:accountNumber'..</p>
     *
     * @param keyProperty RU: новое значение keyProperty. EN: new value for keyProperty.
     */

    public void setKeyProperty(String keyProperty) {
        this.keyProperty = keyProperty;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «version property» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The prefixed name of the version property of the cascading dictionary, e.g. 'cdict:accountDictVersion'..</p>
     *
     * @return RU: текущее значение versionProperty. EN: current value of versionProperty.
     */

    public String getVersionProperty() {
        return versionProperty;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «version property» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The prefixed name of the version property of the cascading dictionary, e.g. 'cdict:accountDictVersion'..</p>
     *
     * @param versionProperty RU: новое значение versionProperty. EN: new value for versionProperty.
     */

    public void setVersionProperty(String versionProperty) {
        this.versionProperty = versionProperty;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «version» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The version of the cascading dictionary definition, e.g. '1.5'..</p>
     *
     * @return RU: текущее значение version. EN: current value of version.
     */

    public String getVersion() {
        return version;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «version» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The version of the cascading dictionary definition, e.g. '1.5'..</p>
     *
     * @param version RU: новое значение version. EN: new value for version.
     */

    public void setVersion(String version) {
        this.version = version;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «levels» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the levels field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение levels. EN: current value of levels.
     */

    public List<CascadingDictLevel> getLevels() {
        return levels;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «levels» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the levels field in the Alfresco REST API model.</p>
     *
     * @param levels RU: новое значение levels. EN: new value for levels.
     */

    public void setLevels(List<CascadingDictLevel> levels) {
        this.levels = levels;
    }

        /**
     * <p><strong>RU:</strong> Возвращает дата и время создания.</p>
     * <p><strong>EN:</strong> Returns Value of the created at field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение createdAt. EN: current value of createdAt.
     */

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает дата и время создания.</p>
     * <p><strong>EN:</strong> Sets Value of the created at field in the Alfresco REST API model.</p>
     *
     * @param createdAt RU: новое значение createdAt. EN: new value for createdAt.
     */

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

        /**
     * <p><strong>RU:</strong> Возвращает дата и время последнего изменения.</p>
     * <p><strong>EN:</strong> Returns Value of the modified at field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение modifiedAt. EN: current value of modifiedAt.
     */

    public OffsetDateTime getModifiedAt() {
        return modifiedAt;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает дата и время последнего изменения.</p>
     * <p><strong>EN:</strong> Sets Value of the modified at field in the Alfresco REST API model.</p>
     *
     * @param modifiedAt RU: новое значение modifiedAt. EN: new value for modifiedAt.
     */

    public void setModifiedAt(OffsetDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

}
