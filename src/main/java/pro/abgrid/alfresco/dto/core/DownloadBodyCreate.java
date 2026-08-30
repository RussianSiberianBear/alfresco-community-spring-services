package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * RU: DTO-модель Alfresco REST API: DownloadBodyCreate.
 * EN: Alfresco REST API DTO model: DownloadBodyCreate.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DownloadBodyCreate {
    /**
     * <p><strong>RU:</strong> значение поля «node ids» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the node ids field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private List<String> nodeIds;

    /**
     * RU: Создаёт экземпляр DownloadBodyCreate.
     * EN: Creates a DownloadBodyCreate instance.
     */
    public DownloadBodyCreate() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «node ids» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the node ids field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение nodeIds. EN: current value of nodeIds.
     */

    public List<String> getNodeIds() {
        return nodeIds;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «node ids» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the node ids field in the Alfresco REST API model.</p>
     *
     * @param nodeIds RU: новое значение nodeIds. EN: new value for nodeIds.
     */

    public void setNodeIds(List<String> nodeIds) {
        this.nodeIds = nodeIds;
    }

}
