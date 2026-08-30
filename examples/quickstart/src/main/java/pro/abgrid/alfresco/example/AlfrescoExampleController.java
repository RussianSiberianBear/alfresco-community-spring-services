package pro.abgrid.alfresco.example;

import pro.abgrid.alfresco.dto.core.Node;
import pro.abgrid.alfresco.dto.core.NodeEntry;
import pro.abgrid.alfresco.model.ContentResource;
import pro.abgrid.alfresco.model.UploadRequest;
import pro.abgrid.alfresco.model.search.SearchResultPage;
import pro.abgrid.alfresco.service.AlfrescoClient;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/alfresco")
public class AlfrescoExampleController {

    private final AlfrescoClient alfresco;

    public AlfrescoExampleController(AlfrescoClient alfresco) {
        this.alfresco = alfresco;
    }

    @PostMapping(value = "/documents", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public UploadedDocument upload(
            @RequestParam String parentId,
            @RequestPart("file") MultipartFile file,
            @RequestParam(defaultValue = "true") boolean autoRename,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description) throws IOException {

        UploadRequest request = new UploadRequest(
                parentId,
                file.getOriginalFilename(),
                file.getBytes(),
                "cm:content",
                List.of("cm:titled"),
                uploadProperties(title, description),
                autoRename,
                true,
                true
        );

        NodeEntry created = alfresco.content().upload(request);
        Node node = created.getEntry();

        return new UploadedDocument(
                node.getId(),
                node.getName(),
                node.getNodeType(),
                node.getParentId()
        );
    }

    @GetMapping("/documents/{nodeId}")
    public Node node(@PathVariable String nodeId) {
        return alfresco.content().get(nodeId).getEntry();
    }

    @GetMapping("/documents/{nodeId}/metadata")
    public Map<String, Object> metadata(@PathVariable String nodeId) {
        return alfresco.metadata().properties(nodeId);
    }

    @GetMapping("/documents/{nodeId}/content")
    public ResponseEntity<byte[]> download(@PathVariable String nodeId) {
        ContentResource resource = alfresco.content().download(nodeId);
        MediaType mediaType = safeMediaType(resource.mimeType());
        String filename = resource.filename() == null ? nodeId : resource.filename();

        return ResponseEntity.ok()
                .contentType(mediaType)
                .contentLength(resource.size())
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        ContentDisposition.attachment()
                                .filename(filename, StandardCharsets.UTF_8)
                                .build()
                                .toString())
                .body(resource.content());
    }

    @GetMapping("/search")
    public SearchResultPage search(
            @RequestParam String q,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        return alfresco.search().userQueryTyped(q, page, size);
    }

    private static Map<String, Object> uploadProperties(String title, String description) {
        Map<String, Object> properties = new java.util.LinkedHashMap<>();
        if (title != null && !title.isBlank()) {
            properties.put("cm:title", title);
        }
        if (description != null && !description.isBlank()) {
            properties.put("cm:description", description);
        }
        return properties.isEmpty() ? null : properties;
    }

    private static MediaType safeMediaType(String value) {
        if (value == null || value.isBlank()) {
            return MediaType.APPLICATION_OCTET_STREAM;
        }
        try {
            return MediaType.parseMediaType(value);
        } catch (IllegalArgumentException ignored) {
            return MediaType.APPLICATION_OCTET_STREAM;
        }
    }

    public record UploadedDocument(String id, String name, String nodeType, String parentId) {
    }
}
