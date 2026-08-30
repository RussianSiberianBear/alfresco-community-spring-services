package pro.abgrid.alfresco.model;

/**
 * <p><strong>RU:</strong> Результат ожидания rendition/transform операции: идентификаторы, финальный статус и, при готовности, бинарное содержимое с MIME-типом.</p>
 * <p><strong>EN:</strong> Result of waiting for a rendition/transform operation: identifiers, final status, and when available the binary content and MIME type.</p>
 *
 * @param nodeId RU: идентификатор исходного узла. EN: source node identifier.
 * @param renditionId RU: идентификатор rendition. EN: rendition identifier.
 * @param status RU: текущий/финальный статус операции. EN: current/final operation status.
 * @param content RU: бинарное содержимое. EN: binary content.
 * @param mimeType RU: MIME-тип содержимого. EN: content MIME type.
 */
public record TransformationResult(
        String nodeId,
        String renditionId,
        String status,
        byte[] content,
        String mimeType) {
}
