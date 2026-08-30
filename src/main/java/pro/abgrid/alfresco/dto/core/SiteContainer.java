package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: SiteContainer.
 * EN: Alfresco REST API DTO model: SiteContainer.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SiteContainer {
    /**
     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the id field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private String id;

    /**

     * <p><strong>RU:</strong> значение поля «folder id» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the folder id field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private String folderId;

    /**
     * RU: Создаёт экземпляр SiteContainer.
     * EN: Creates a SiteContainer instance.
     */
    public SiteContainer() {
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
     * <p><strong>RU:</strong> Возвращает значение поля «folder id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the folder id field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение folderId. EN: current value of folderId.
     */

    public String getFolderId() {
        return folderId;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «folder id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the folder id field in the Alfresco REST API model.</p>
     *
     * @param folderId RU: новое значение folderId. EN: new value for folderId.
     */

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }

}
