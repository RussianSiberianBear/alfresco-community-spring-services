package pro.abgrid.alfresco.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * RU: DTO-модель Alfresco REST API: RequestDefaults.
 * EN: Alfresco REST API DTO model: RequestDefaults.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestDefaults {
    /**
     * <p><strong>RU:</strong> значение поля «text attributes» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> A list of query fields/properties used to expand TEXT: queries. The default is cm:content. You could include all content properties using d:content or list all individual content properties or types. As more terms are included the query size, complexity, memory impact and query time will increase.. Optional unless a specific endpoint requires it.</p>
     */
    private List<String> textAttributes;

    /**

     * <p><strong>RU:</strong> значение поля «default f t s operator» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The default way to combine query parts when AND or OR is not explicitly stated - includes ! - + one two three (one two three). Optional unless a specific endpoint requires it.</p>

     */

    private String defaultFTSOperator;

    /**

     * <p><strong>RU:</strong> значение поля «default f t s field operator» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The default way to combine query parts in field query groups when AND or OR is not explicitly stated - includes ! - + FIELD:(one two three). Optional unless a specific endpoint requires it.</p>

     */

    private String defaultFTSFieldOperator;

    /**

     * <p><strong>RU:</strong> значение поля «namespace» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The default name space to use if one is not provided. Optional unless a specific endpoint requires it.</p>

     */

    private String namespace;

    /**

     * <p><strong>RU:</strong> значение поля «default field name» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the default field name field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String defaultFieldName;

    /**
     * RU: Создаёт экземпляр RequestDefaults.
     * EN: Creates a RequestDefaults instance.
     */
    public RequestDefaults() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «text attributes» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns A list of query fields/properties used to expand TEXT: queries. The default is cm:content. You could include all content properties using d:content or list all individual content properties or types. As more terms are included the query size, complexity, memory impact and query time will increase..</p>
     *
     * @return RU: текущее значение textAttributes. EN: current value of textAttributes.
     */

    public List<String> getTextAttributes() {
        return textAttributes;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «text attributes» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets A list of query fields/properties used to expand TEXT: queries. The default is cm:content. You could include all content properties using d:content or list all individual content properties or types. As more terms are included the query size, complexity, memory impact and query time will increase..</p>
     *
     * @param textAttributes RU: новое значение textAttributes. EN: new value for textAttributes.
     */

    public void setTextAttributes(List<String> textAttributes) {
        this.textAttributes = textAttributes;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «default f t s operator» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The default way to combine query parts when AND or OR is not explicitly stated - includes ! - + one two three (one two three).</p>
     *
     * @return RU: текущее значение defaultFTSOperator. EN: current value of defaultFTSOperator.
     */

    public String getDefaultFTSOperator() {
        return defaultFTSOperator;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «default f t s operator» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The default way to combine query parts when AND or OR is not explicitly stated - includes ! - + one two three (one two three).</p>
     *
     * @param defaultFTSOperator RU: новое значение defaultFTSOperator. EN: new value for defaultFTSOperator.
     */

    public void setDefaultFTSOperator(String defaultFTSOperator) {
        this.defaultFTSOperator = defaultFTSOperator;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «default f t s field operator» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The default way to combine query parts in field query groups when AND or OR is not explicitly stated - includes ! - + FIELD:(one two three).</p>
     *
     * @return RU: текущее значение defaultFTSFieldOperator. EN: current value of defaultFTSFieldOperator.
     */

    public String getDefaultFTSFieldOperator() {
        return defaultFTSFieldOperator;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «default f t s field operator» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The default way to combine query parts in field query groups when AND or OR is not explicitly stated - includes ! - + FIELD:(one two three).</p>
     *
     * @param defaultFTSFieldOperator RU: новое значение defaultFTSFieldOperator. EN: new value for defaultFTSFieldOperator.
     */

    public void setDefaultFTSFieldOperator(String defaultFTSFieldOperator) {
        this.defaultFTSFieldOperator = defaultFTSFieldOperator;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «namespace» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The default name space to use if one is not provided.</p>
     *
     * @return RU: текущее значение namespace. EN: current value of namespace.
     */

    public String getNamespace() {
        return namespace;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «namespace» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The default name space to use if one is not provided.</p>
     *
     * @param namespace RU: новое значение namespace. EN: new value for namespace.
     */

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «default field name» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the default field name field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение defaultFieldName. EN: current value of defaultFieldName.
     */

    public String getDefaultFieldName() {
        return defaultFieldName;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «default field name» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the default field name field in the Alfresco REST API model.</p>
     *
     * @param defaultFieldName RU: новое значение defaultFieldName. EN: new value for defaultFieldName.
     */

    public void setDefaultFieldName(String defaultFieldName) {
        this.defaultFieldName = defaultFieldName;
    }

}
