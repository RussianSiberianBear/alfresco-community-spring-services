package pro.abgrid.alfresco.api;

import pro.abgrid.alfresco.dto.core.NodeEntry;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.PostExchange;

/**
 * <p><strong>RU:</strong> Низкоуровневый multipart endpoint для потоковой загрузки. Интерфейс зарегистрирован в отдельной HTTP Service group без byte-array interceptor'ов, чтобы большое request body не буферизовалось целиком.</p>
 * <p><strong>EN:</strong> Low-level multipart endpoint for streaming uploads. This interface is registered in a dedicated HTTP Service group without byte-array interceptors so large request bodies are not fully buffered.</p>
 */
public interface StreamingNodeUploadApi {

    /**
     * @param nodeId RU: идентификатор родительского узла. EN: parent node identifier.
     * @param autoRename RU: автоматически разрешать конфликт имени. EN: automatically resolve name conflicts.
     * @param majorVersion RU: создать major-версию. EN: create a major version.
     * @param versioningEnabled RU: включить versioning. EN: enable versioning.
     * @param parts RU: multipart-поля, включая потоковый Resource. EN: multipart parts including a streaming Resource.
     * @return RU: созданный узел. EN: created node.
     */
    @PostExchange(url = "/nodes/{nodeId}/children", contentType = "multipart/form-data")
    NodeEntry upload(
            @PathVariable("nodeId") String nodeId,
            @RequestParam(value = "autoRename", required = false) Boolean autoRename,
            @RequestParam(value = "majorVersion", required = false) Boolean majorVersion,
            @RequestParam(value = "versioningEnabled", required = false) Boolean versioningEnabled,
            @RequestBody MultiValueMap<String, Object> parts);
}
