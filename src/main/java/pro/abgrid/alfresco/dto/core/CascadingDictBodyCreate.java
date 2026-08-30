package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: CascadingDictBodyCreate.
 * EN: Alfresco REST API DTO model: CascadingDictBodyCreate.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CascadingDictBodyCreate {
    /**
     * <p><strong>RU:</strong> имя ресурса Alfresco. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> The unique name of the cascading dictionary.. Required by the Swagger schema.</p>
     */
    private String name;

    /**

     * <p><strong>RU:</strong> значение поля «aspect» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> The prefixed name of the aspect describing the cascading dictionary, e.g. 'cdict:account'. The aspect must already be defined in the repository and registered as a cascading dictionary. It must also contain at least the key and version properties defined below.. Required by the Swagger schema.</p>

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
     * RU: Создаёт экземпляр CascadingDictBodyCreate.
     * EN: Creates a CascadingDictBodyCreate instance.
     */
    public CascadingDictBodyCreate() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает имя ресурса Alfresco.</p>
     * <p><strong>EN:</strong> Returns The unique name of the cascading dictionary..</p>
     *
     * @return RU: текущее значение name. EN: current value of name.
     */

    public String getName() {
        return name;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает имя ресурса Alfresco.</p>
     * <p><strong>EN:</strong> Sets The unique name of the cascading dictionary..</p>
     *
     * @param name RU: новое значение name. EN: new value for name.
     */

    public void setName(String name) {
        this.name = name;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «aspect» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The prefixed name of the aspect describing the cascading dictionary, e.g. 'cdict:account'. The aspect must already be defined in the repository and registered as a cascading dictionary. It must also contain at least the key and version properties defined below..</p>
     *
     * @return RU: текущее значение aspect. EN: current value of aspect.
     */

    public String getAspect() {
        return aspect;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «aspect» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The prefixed name of the aspect describing the cascading dictionary, e.g. 'cdict:account'. The aspect must already be defined in the repository and registered as a cascading dictionary. It must also contain at least the key and version properties defined below..</p>
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

}
