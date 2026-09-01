package pro.abgrid.alfresco.model;

import org.springframework.core.io.Resource;

import java.util.List;
import java.util.Map;

/**
 * <p><strong>RU:</strong> High-level запрос потоковой загрузки документа. Содержимое передаётся как Spring {@link Resource}, поэтому файл не требуется предварительно читать целиком в {@code byte[]}.</p>
 * <p><strong>EN:</strong> High-level streaming document upload request. Content is supplied as a Spring {@link Resource}, so the complete file does not need to be preloaded into a {@code byte[]}.</p>
 *
 * @param parentId RU: идентификатор родительской папки. EN: parent folder identifier.
 * @param filename RU: имя создаваемого файла. EN: file name to create.
 * @param content RU: потоковый источник содержимого. EN: streaming content resource.
 * @param nodeType RU: QName типа создаваемого узла. EN: QName of the node type to create.
 * @param aspects RU: аспекты, применяемые при загрузке. EN: aspects applied on upload.
 * @param properties RU: свойства узла. EN: node properties.
 * @param autoRename RU: автоматически разрешать конфликт имени. EN: automatically resolve name conflicts.
 * @param majorVersion RU: создать major-версию. EN: create a major version.
 * @param versioningEnabled RU: включить versioning. EN: enable versioning.
 */
public record StreamingUploadRequest(
        String parentId,
        String filename,
        Resource content,
        String nodeType,
        List<String> aspects,
        Map<String, Object> properties,
        Boolean autoRename,
        Boolean majorVersion,
        Boolean versioningEnabled) {

    /**
     * RU: Создаёт минимальный потоковый запрос с типом {@code cm:content}.
     * EN: Creates a minimal streaming request using {@code cm:content}.
     *
     * @param parentId RU: идентификатор родительской папки. EN: parent folder identifier.
     * @param filename RU: имя файла. EN: file name.
     * @param content RU: потоковый источник. EN: streaming source.
     */
    public StreamingUploadRequest(String parentId, String filename, Resource content) {
        this(parentId, filename, content, "cm:content", null, null, null, null, null);
    }

    /**
     * RU: Проверяет обязательные поля запроса до HTTP-вызова.
     * EN: Validates required request fields before the HTTP call.
     */
    public StreamingUploadRequest {
        if (parentId == null || parentId.isBlank()) {
            throw new IllegalArgumentException("parentId must not be blank");
        }
        if (filename == null || filename.isBlank()) {
            throw new IllegalArgumentException("filename must not be blank");
        }
        if (content == null) {
            throw new IllegalArgumentException("content must not be null");
        }
    }
}
