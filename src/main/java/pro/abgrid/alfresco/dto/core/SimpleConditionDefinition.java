package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: SimpleConditionDefinition.
 * EN: Alfresco REST API DTO model: SimpleConditionDefinition.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SimpleConditionDefinition {
    /**
     * <p><strong>RU:</strong> значение поля «field» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> The name of the property to compare. This should be either a property (e.g. "cm:name") or one of the keywords from this list: * size (the size of the content for a node) * mimetype (the mimetype of the content for a node) * encoding (the encoding of the content for a node) * category (a category for the node) * tag (a tag that the node has) * aspect (an aspect that the node has) For multi-valued properties the condition is satisfied if any of the values match the condition.. Required by the Swagger schema.</p>
     */
    private String field;

    /**

     * <p><strong>RU:</strong> значение поля «comparator» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> The method to compare the property against the parameter. Depending on the type of the property then different comparators are available: * All types: equals * text: contains, startsWith, endsWith * int/long/float/double/date: greaterThan, lessThan, greaterThanOrEqual, lessThanOrEqual * type: instanceOf Where a property is multivalued then the condition is true if it is satisfied by any of the values.. Required by the Swagger schema.</p>

     */

    private String comparator;

    /**

     * <p><strong>RU:</strong> значение поля «parameter» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> The value to compare the field against. Required by the Swagger schema.</p>

     */

    private String parameter;

    /**
     * RU: Создаёт экземпляр SimpleConditionDefinition.
     * EN: Creates a SimpleConditionDefinition instance.
     */
    public SimpleConditionDefinition() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «field» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The name of the property to compare. This should be either a property (e.g. "cm:name") or one of the keywords from this list: * size (the size of the content for a node) * mimetype (the mimetype of the content for a node) * encoding (the encoding of the content for a node) * category (a category for the node) * tag (a tag that the node has) * aspect (an aspect that the node has) For multi-valued properties the condition is satisfied if any of the values match the condition..</p>
     *
     * @return RU: текущее значение field. EN: current value of field.
     */

    public String getField() {
        return field;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «field» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The name of the property to compare. This should be either a property (e.g. "cm:name") or one of the keywords from this list: * size (the size of the content for a node) * mimetype (the mimetype of the content for a node) * encoding (the encoding of the content for a node) * category (a category for the node) * tag (a tag that the node has) * aspect (an aspect that the node has) For multi-valued properties the condition is satisfied if any of the values match the condition..</p>
     *
     * @param field RU: новое значение field. EN: new value for field.
     */

    public void setField(String field) {
        this.field = field;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «comparator» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The method to compare the property against the parameter. Depending on the type of the property then different comparators are available: * All types: equals * text: contains, startsWith, endsWith * int/long/float/double/date: greaterThan, lessThan, greaterThanOrEqual, lessThanOrEqual * type: instanceOf Where a property is multivalued then the condition is true if it is satisfied by any of the values..</p>
     *
     * @return RU: текущее значение comparator. EN: current value of comparator.
     */

    public String getComparator() {
        return comparator;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «comparator» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The method to compare the property against the parameter. Depending on the type of the property then different comparators are available: * All types: equals * text: contains, startsWith, endsWith * int/long/float/double/date: greaterThan, lessThan, greaterThanOrEqual, lessThanOrEqual * type: instanceOf Where a property is multivalued then the condition is true if it is satisfied by any of the values..</p>
     *
     * @param comparator RU: новое значение comparator. EN: new value for comparator.
     */

    public void setComparator(String comparator) {
        this.comparator = comparator;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «parameter» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The value to compare the field against.</p>
     *
     * @return RU: текущее значение parameter. EN: current value of parameter.
     */

    public String getParameter() {
        return parameter;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «parameter» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The value to compare the field against.</p>
     *
     * @param parameter RU: новое значение parameter. EN: new value for parameter.
     */

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

}
