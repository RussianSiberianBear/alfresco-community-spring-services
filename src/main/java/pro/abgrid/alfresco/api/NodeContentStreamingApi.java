package pro.abgrid.alfresco.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import java.io.InputStream;
import java.time.OffsetDateTime;

/**
 * <p><strong>RU:</strong> Низкоуровневый HTTP-интерфейс потокового чтения содержимого узла. В отличие от generated {@link NodesApi#getNodeContent(String, Boolean, OffsetDateTime, String)}, ответ возвращается как {@link InputStream} и не материализуется в {@code byte[]}.</p>
 * <p><strong>EN:</strong> Low-level HTTP interface for streaming node content. Unlike generated {@link NodesApi#getNodeContent(String, Boolean, OffsetDateTime, String)}, the response is returned as an {@link InputStream} instead of being materialized as a {@code byte[]}.</p>
 */
public interface NodeContentStreamingApi {

    /**
     * <p><strong>RU:</strong> Открывает поток содержимого узла. Поток должен быть закрыт вызывающим кодом.</p>
     * <p><strong>EN:</strong> Opens the node content stream. The caller must close the stream.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param attachment RU: запрашивать ответ как attachment. EN: request the response as an attachment.
     * @param ifModifiedSince RU: условный заголовок If-Modified-Since. EN: conditional If-Modified-Since header.
     * @param range RU: необязательный HTTP Range. EN: optional HTTP Range header.
     * @return RU: поток HTTP-ответа. EN: HTTP response stream.
     */
    @GetExchange(url = "/nodes/{nodeId}/content")
    InputStream getNodeContentStream(
            @PathVariable("nodeId") String nodeId,
            @RequestParam(value = "attachment", required = false) Boolean attachment,
            @RequestHeader(value = "If-Modified-Since", required = false) OffsetDateTime ifModifiedSince,
            @RequestHeader(value = "Range", required = false) String range);
}
