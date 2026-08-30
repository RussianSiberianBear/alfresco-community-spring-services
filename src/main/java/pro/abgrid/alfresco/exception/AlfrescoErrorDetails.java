package pro.abgrid.alfresco.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * <p><strong>RU:</strong> Типизированное содержимое стандартного error-объекта ACS: ключ ошибки, HTTP code, краткое описание, ссылка на описание и logId, полезный при сопоставлении клиентской ошибки с серверным логом.</p>
 * <p><strong>EN:</strong> Typed content of the standard ACS error object: error key, status code, brief summary, description URL, and logId useful for correlating a client failure with server logs.</p>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlfrescoErrorDetails {
    /** RU: Ключ ошибки ACS. EN: ACS error key. */
    private String errorKey;
    /** RU: HTTP status code из error-envelope. EN: HTTP status code from the error envelope. */
    private Integer statusCode;
    /** RU: Краткое серверное описание ошибки. EN: Brief server-side error summary. */
    private String briefSummary;
    /** RU: Ссылка на дополнительное описание ошибки. EN: URL with additional error information. */
    private String descriptionURL;
    /** RU: Идентификатор для корреляции с серверным логом. EN: Identifier for correlation with server logs. */
    private String logId;

    /**
     * <p><strong>RU:</strong> Создаёт пустой контейнер деталей ошибки для десериализации стандартного ответа ACS.</p>
     * <p><strong>EN:</strong> Creates an empty error-details container for deserializing the standard ACS response.</p>
     */
    public AlfrescoErrorDetails() {
    }

    /**
     * RU: Возвращает error key.
     * EN: Returns error key.
      * @return RU: ключ ошибки. EN: error key.
     */
    public String getErrorKey() { return errorKey; }
    /**
     * RU: Устанавливает error key.
     * EN: Sets error key.
      * @param errorKey RU: ключ ошибки. EN: error key.
     */
    public void setErrorKey(String errorKey) { this.errorKey = errorKey; }
    /**
     * RU: Возвращает status code.
     * EN: Returns status code.
      * @return RU: HTTP status code. EN: HTTP status code.
     */
    public Integer getStatusCode() { return statusCode; }
    /**
     * RU: Устанавливает status code.
     * EN: Sets status code.
      * @param statusCode RU: HTTP status code. EN: HTTP status code.
     */
    public void setStatusCode(Integer statusCode) { this.statusCode = statusCode; }
    /**
     * RU: Возвращает brief summary.
     * EN: Returns brief summary.
      * @return RU: краткое описание. EN: brief summary.
     */
    public String getBriefSummary() { return briefSummary; }
    /**
     * RU: Устанавливает brief summary.
     * EN: Sets brief summary.
      * @param briefSummary RU: краткое описание. EN: brief summary.
     */
    public void setBriefSummary(String briefSummary) { this.briefSummary = briefSummary; }
    /**
     * RU: Возвращает description url.
     * EN: Returns description url.
      * @return RU: URL описания. EN: description URL.
     */
    public String getDescriptionURL() { return descriptionURL; }
    /**
     * RU: Устанавливает description url.
     * EN: Sets description url.
      * @param descriptionURL RU: URL описания. EN: description URL.
     */
    public void setDescriptionURL(String descriptionURL) { this.descriptionURL = descriptionURL; }
    /**
     * RU: Возвращает log id.
     * EN: Returns log id.
      * @return RU: идентификатор серверного лога. EN: server log identifier.
     */
    public String getLogId() { return logId; }
    /**
     * RU: Устанавливает log id.
     * EN: Sets log id.
      * @param logId RU: идентификатор серверного лога. EN: server log identifier.
     */
    public void setLogId(String logId) { this.logId = logId; }
}
