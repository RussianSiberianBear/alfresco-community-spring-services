package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

/**
 * RU: DTO-модель Alfresco REST API: ContentStorageInfo.
 * EN: Alfresco REST API DTO model: ContentStorageInfo.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContentStorageInfo {
    /**
     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Content type property identifier (e.g. cm:content). Inside this object only colon (':') delimiter for namespace-prefix will be used.. Required by the Swagger schema.</p>
     */
    private String id;

    /**

     * <p><strong>RU:</strong> значение поля «storage properties» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> A map (String-String) of storage properties for given content.. Optional unless a specific endpoint requires it.</p>

     */

    private Map<String, String> storageProperties;

    /**
     * RU: Создаёт экземпляр ContentStorageInfo.
     * EN: Creates a ContentStorageInfo instance.
     */
    public ContentStorageInfo() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Returns Content type property identifier (e.g. cm:content). Inside this object only colon (':') delimiter for namespace-prefix will be used..</p>
     *
     * @return RU: текущее значение id. EN: current value of id.
     */

    public String getId() {
        return id;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Sets Content type property identifier (e.g. cm:content). Inside this object only colon (':') delimiter for namespace-prefix will be used..</p>
     *
     * @param id RU: новое значение id. EN: new value for id.
     */

    public void setId(String id) {
        this.id = id;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «storage properties» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns A map (String-String) of storage properties for given content..</p>
     *
     * @return RU: текущее значение storageProperties. EN: current value of storageProperties.
     */

    public Map<String, String> getStorageProperties() {
        return storageProperties;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «storage properties» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets A map (String-String) of storage properties for given content..</p>
     *
     * @param storageProperties RU: новое значение storageProperties. EN: new value for storageProperties.
     */

    public void setStorageProperties(Map<String, String> storageProperties) {
        this.storageProperties = storageProperties;
    }

}
