package pro.abgrid.alfresco.model;

import java.util.List;
import java.util.Map;

/**
 * <p><strong>RU:</strong> High-level запрос загрузки документа. Собирает родителя, имя, бинарное содержимое, тип, аспекты, свойства и параметры versioning/auto-rename в одном объекте.</p>
 * <p><strong>EN:</strong> High-level document upload request combining parent, name, binary content, type, aspects, properties, and versioning/auto-rename options.</p>
 *
 * @param parentId RU: идентификатор родительской папки. EN: parent folder identifier.
 * @param filename RU: имя файла. EN: file name.
 * @param content RU: бинарное содержимое. EN: binary content.
 * @param nodeType RU: QName типа создаваемого узла. EN: QName of the node type to create.
 * @param aspects RU: аспекты, применяемые при загрузке. EN: aspects applied on upload.
 * @param properties RU: свойства узла, устанавливаемые при загрузке. EN: node properties set on upload.
 * @param autoRename RU: автоматически разрешать конфликт имени. EN: automatically resolve name conflicts.
 * @param majorVersion RU: создать major-версию при загрузке. EN: create a major version on upload.
 * @param versioningEnabled RU: включить версионирование. EN: enable versioning.
 */
public record UploadRequest(String parentId, String filename, byte[] content, String nodeType,
                            List<String> aspects, Map<String,Object> properties,
                            Boolean autoRename, Boolean majorVersion, Boolean versioningEnabled) {
    /**
     * RU: Создаёт минимальный запрос загрузки с типом {@code cm:content}.
     * EN: Creates a minimal upload request using {@code cm:content} as the node type.
     *
     * @param parentId RU: идентификатор родительской папки. EN: parent folder identifier.
     * @param filename RU: имя файла. EN: file name.
     * @param content RU: бинарное содержимое файла. EN: binary file content.
     */
    public UploadRequest(String parentId, String filename, byte[] content) {
        this(parentId, filename, content, "cm:content", null, null, null, null, null);
    }
}
