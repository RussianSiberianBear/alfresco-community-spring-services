package pro.abgrid.alfresco.exception;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

/**
 * <p><strong>RU:</strong> Безопасно разбирает стандартный ACS error-envelope {error:{...}}. Пустое, нестандартное или повреждённое тело не превращает исходную HTTP-ошибку во вторичную ошибку парсинга: метод возвращает null.</p>
 * <p><strong>EN:</strong> Safely parses the standard ACS {error:{...}} envelope. Blank, non-standard, or malformed bodies never mask the original HTTP failure with a parsing failure; parse returns null instead.</p>
 */
public class AlfrescoErrorParser {
    private final ObjectMapper mapper;

        /**
     * <p><strong>RU:</strong> Создаёт компонент с зависимостями/контекстом, необходимыми для его работы.</p>
     * <p><strong>EN:</strong> Creates the component with the dependencies/context required for its operation.</p>
     *
     * @param mapper RU: Jackson ObjectMapper, используемый для безопасного преобразования JSON-моделей. EN: Jackson ObjectMapper used for safe JSON model conversion.
     */

    public AlfrescoErrorParser(ObjectMapper mapper) {
        this.mapper = mapper;
    }

        /**
     * <p><strong>RU:</strong> Пытается извлечь AlfrescoErrorDetails из стандартного error-envelope; при пустом или невалидном теле возвращает null.</p>
     * <p><strong>EN:</strong> Attempts to extract AlfrescoErrorDetails from the standard error envelope; returns null for blank or malformed bodies.</p>
     *
     * @param body RU: сериализованное тело запроса; interceptor его не логирует. EN: serialized request body; the interceptor does not log it.
     * @return RU: результат операции согласно описанию метода. EN: operation result described above.
     */

    public AlfrescoErrorDetails parse(String body) {
        if (body == null || body.isBlank()) return null;
        try {
            JsonNode root = mapper.readTree(body);
            JsonNode error = root == null ? null : root.get("error");
            if (error == null || error.isNull()) return null;
            return mapper.convertValue(error, AlfrescoErrorDetails.class);
        } catch (Exception ex) {
            return null;
        }
    }
}
