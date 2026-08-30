package pro.abgrid.alfresco.api;

import pro.abgrid.alfresco.dto.core.NodeEntry;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.PostExchange;

/**
 * <p><strong>RU:</strong> Низкоуровневый HTTP-интерфейс multipart-загрузки узлов Alfresco. В обычном прикладном коде предпочтительнее {@code AlfrescoContentService}.</p>
 * <p><strong>EN:</strong> Low-level HTTP interface for Alfresco multipart node upload. Application code will normally prefer {@code AlfrescoContentService}.</p>
 */
public interface NodeUploadApi {
    /**
     * <p><strong>RU:</strong> Загружает бинарный файл как дочерний узел. Multipart body содержит {@code filedata}, стандартные поля Alfresco и произвольные QName-свойства.</p>
     * <p><strong>EN:</strong> Uploads a binary file as a child node. The multipart body contains {@code filedata}, standard Alfresco fields, and arbitrary QName properties.</p>
     *
     * @param nodeId RU: идентификатор родительского узла. EN: parent node identifier.
     * @param autoRename RU: автоматически разрешать конфликт имени. EN: automatically resolve name conflicts.
     * @param majorVersion RU: создать major-версию. EN: create a major version.
     * @param versioningEnabled RU: включить versioning. EN: enable versioning.
     * @param parts RU: multipart-поля запроса, включая файл и свойства узла. EN: multipart request parts including file content and node properties.
     * @return RU: созданный узел. EN: created node.
     */
    @PostExchange(url = "/nodes/{nodeId}/children", contentType = "multipart/form-data")
    NodeEntry upload(@PathVariable("nodeId") String nodeId,
                     @RequestParam(value = "autoRename", required = false) Boolean autoRename,
                     @RequestParam(value = "majorVersion", required = false) Boolean majorVersion,
                     @RequestParam(value = "versioningEnabled", required = false) Boolean versioningEnabled,
                     @RequestBody MultiValueMap<String, Object> parts);
}
