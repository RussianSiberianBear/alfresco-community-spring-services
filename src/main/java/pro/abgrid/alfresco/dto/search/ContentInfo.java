package pro.abgrid.alfresco.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: ContentInfo.
 * EN: Alfresco REST API DTO model: ContentInfo.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContentInfo {
    /**
     * <p><strong>RU:</strong> MIME-тип содержимого. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the mime type field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private String mimeType;

    /**

     * <p><strong>RU:</strong> значение поля «mime type name» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the mime type name field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private String mimeTypeName;

    /**

     * <p><strong>RU:</strong> размер содержимого в байтах. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the size in bytes field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private Long sizeInBytes;

    /**

     * <p><strong>RU:</strong> кодировка содержимого. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the encoding field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String encoding;

    /**

     * <p><strong>RU:</strong> значение поля «mime type group» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the mime type group field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String mimeTypeGroup;

    /**
     * RU: Создаёт экземпляр ContentInfo.
     * EN: Creates a ContentInfo instance.
     */
    public ContentInfo() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает MIME-тип содержимого.</p>
     * <p><strong>EN:</strong> Returns Value of the mime type field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение mimeType. EN: current value of mimeType.
     */

    public String getMimeType() {
        return mimeType;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает MIME-тип содержимого.</p>
     * <p><strong>EN:</strong> Sets Value of the mime type field in the Alfresco REST API model.</p>
     *
     * @param mimeType RU: новое значение mimeType. EN: new value for mimeType.
     */

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «mime type name» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the mime type name field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение mimeTypeName. EN: current value of mimeTypeName.
     */

    public String getMimeTypeName() {
        return mimeTypeName;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «mime type name» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the mime type name field in the Alfresco REST API model.</p>
     *
     * @param mimeTypeName RU: новое значение mimeTypeName. EN: new value for mimeTypeName.
     */

    public void setMimeTypeName(String mimeTypeName) {
        this.mimeTypeName = mimeTypeName;
    }

        /**
     * <p><strong>RU:</strong> Возвращает размер содержимого в байтах.</p>
     * <p><strong>EN:</strong> Returns Value of the size in bytes field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение sizeInBytes. EN: current value of sizeInBytes.
     */

    public Long getSizeInBytes() {
        return sizeInBytes;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает размер содержимого в байтах.</p>
     * <p><strong>EN:</strong> Sets Value of the size in bytes field in the Alfresco REST API model.</p>
     *
     * @param sizeInBytes RU: новое значение sizeInBytes. EN: new value for sizeInBytes.
     */

    public void setSizeInBytes(Long sizeInBytes) {
        this.sizeInBytes = sizeInBytes;
    }

        /**
     * <p><strong>RU:</strong> Возвращает кодировка содержимого.</p>
     * <p><strong>EN:</strong> Returns Value of the encoding field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение encoding. EN: current value of encoding.
     */

    public String getEncoding() {
        return encoding;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает кодировка содержимого.</p>
     * <p><strong>EN:</strong> Sets Value of the encoding field in the Alfresco REST API model.</p>
     *
     * @param encoding RU: новое значение encoding. EN: new value for encoding.
     */

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «mime type group» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the mime type group field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение mimeTypeGroup. EN: current value of mimeTypeGroup.
     */

    public String getMimeTypeGroup() {
        return mimeTypeGroup;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «mime type group» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the mime type group field in the Alfresco REST API model.</p>
     *
     * @param mimeTypeGroup RU: новое значение mimeTypeGroup. EN: new value for mimeTypeGroup.
     */

    public void setMimeTypeGroup(String mimeTypeGroup) {
        this.mimeTypeGroup = mimeTypeGroup;
    }

}
