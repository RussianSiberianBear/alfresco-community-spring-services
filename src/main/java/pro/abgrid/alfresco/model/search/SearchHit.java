package pro.abgrid.alfresco.model.search;

import pro.abgrid.alfresco.dto.search.ResultNode;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p><strong>RU:</strong> Типизированное high-level представление одного результата поиска. Выносит часто используемые свойства узла в отдельные поля и одновременно сохраняет raw ResultNode для редких данных.</p>
 * <p><strong>EN:</strong> Typed high-level representation of a single search result. Promotes commonly used node properties to explicit fields while retaining raw ResultNode for less common data.</p>
 *
 * @param id RU: значение id. EN: value of id.
 * @param name RU: значение name. EN: value of name.
 * @param nodeType RU: QName типа создаваемого узла. EN: QName of the node type to create.
 * @param parentId RU: идентификатор родительской папки. EN: parent folder identifier.
 * @param file RU: значение file. EN: value of file.
 * @param folder RU: значение folder. EN: value of folder.
 * @param mimeType RU: MIME-тип содержимого. EN: content MIME type.
 * @param sizeInBytes RU: значение sizeInBytes. EN: value of sizeInBytes.
 * @param score RU: значение score. EN: value of score.
 * @param properties RU: свойства узла, устанавливаемые при загрузке. EN: node properties set on upload.
 * @param raw RU: значение raw. EN: value of raw.
 */
public record SearchHit(
        String id,
        String name,
        String nodeType,
        String parentId,
        boolean file,
        boolean folder,
        String mimeType,
        Long sizeInBytes,
        Double score,
        Map<String, Object> properties,
        ResultNode raw
) {
    /**
     * <p><strong>RU:</strong> Нормализует карту свойств в ненулевое immutable-представление.</p>
     * <p><strong>EN:</strong> Normalizes properties to a non-null immutable representation.</p>
     */
    public SearchHit {
        properties = properties == null ? Map.of() : Collections.unmodifiableMap(new LinkedHashMap<>(properties));
    }

    /**
     * <p><strong>RU:</strong> Преобразует generated {@link ResultNode} в компактную high-level модель поиска.</p>
     * <p><strong>EN:</strong> Converts a generated {@link ResultNode} into the compact high-level search model.</p>
     * @param node RU: generated результат поиска; может быть {@code null}. EN: generated search result; may be {@code null}.
     * @return RU: преобразованный результат либо {@code null}. EN: converted result or {@code null}.
     */
    public static SearchHit from(ResultNode node) {
        if (node == null) {
            return null;
        }
        return new SearchHit(
                node.getId(),
                node.getName(),
                node.getNodeType(),
                node.getParentId(),
                Boolean.TRUE.equals(node.getIsFile()),
                Boolean.TRUE.equals(node.getIsFolder()),
                node.getContent() == null ? null : node.getContent().getMimeType(),
                node.getContent() == null ? null : node.getContent().getSizeInBytes(),
                node.getSearch() == null ? null : node.getSearch().getScore(),
                node.getProperties(),
                node
        );
    }
}
