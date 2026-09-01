package pro.abgrid.alfresco.service.content;

import pro.abgrid.alfresco.api.NodeContentStreamingApi;
import pro.abgrid.alfresco.api.NodeUploadApi;
import pro.abgrid.alfresco.api.StreamingNodeUploadApi;
import pro.abgrid.alfresco.api.NodesApi;
import pro.abgrid.alfresco.dto.core.*;
import pro.abgrid.alfresco.model.ContentResource;
import pro.abgrid.alfresco.model.UploadRequest;
import pro.abgrid.alfresco.model.StreamingUploadRequest;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;

/**
 * <p><strong>RU:</strong> Высокоуровневый Spring-сервис для сценариев «content» в Alfresco. Он служит прикладной границей над generated REST API: принимает более удобные параметры, скрывает технические детали HTTP/DTO там, где для них есть high-level модель, и оставляет доступ к серверному результату, когда это необходимо. Сервис предназначен для внедрения как обычный Spring bean в бизнес-сервисы приложения.</p>
 * <p><strong>EN:</strong> High-level Spring service for Alfresco content scenarios. It acts as an application boundary over the generated REST API: it accepts application-friendly parameters, hides HTTP/DTO plumbing where a high-level model exists, and still exposes server results when required. The service is intended to be injected as a regular Spring bean into application business services.</p>
 */
@Service
public class AlfrescoContentService {
    private final NodesApi nodes;
    private final NodeUploadApi upload;
    private final StreamingNodeUploadApi streamingUpload;
    private final NodeContentStreamingApi streamingContent;
        /**
     * <p><strong>RU:</strong> создаёт сервис и получает его зависимости через Spring DI; обычно этот конструктор не вызывается прикладным кодом напрямую.</p>
     * <p><strong>EN:</strong> creates the service with dependencies supplied by Spring DI; application code normally does not call this constructor directly.</p>
     *
     * @param nodes RU: зависимость `nodes`, используемая сервисом для выполнения операций Alfresco. EN: `nodes` dependency used by the service to perform Alfresco operations.
     * @param upload RU: зависимость `upload`, используемая сервисом для выполнения операций Alfresco. EN: `upload` dependency used by the service to perform Alfresco operations.
     * @param streamingUpload RU: потоковый multipart-клиент загрузки. EN: streaming multipart upload client.
     * @param streamingContent RU: потоковый клиент содержимого узлов. EN: streaming node-content client.
     */

    public AlfrescoContentService(
            NodesApi nodes, NodeUploadApi upload, StreamingNodeUploadApi streamingUpload,
            NodeContentStreamingApi streamingContent) {
        this.nodes = nodes;
        this.upload = upload;
        this.streamingUpload = streamingUpload;
        this.streamingContent = streamingContent;
    }

        /**
     * <p><strong>RU:</strong> получает актуальное представление объекта из Alfresco; подходит для чтения его серверного состояния и метаданных.</p>
     * <p><strong>EN:</strong> retrieves the current Alfresco representation of the object for reading server-side state and metadata.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public NodeEntry get(String nodeId) { return nodes.getNode(nodeId, List.of("properties","path","permissions"), null, null); }
        /**
     * <p><strong>RU:</strong> получает актуальное представление объекта из Alfresco; подходит для чтения его серверного состояния и метаданных.</p>
     * <p><strong>EN:</strong> retrieves the current Alfresco representation of the object for reading server-side state and metadata.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param include RU: дополнительные поля/секции Alfresco, которые требуется включить в ответ. EN: additional Alfresco fields/sections to include in the response.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public NodeEntry get(String nodeId, List<String> include) { return nodes.getNode(nodeId, include, null, null); }
        /**
     * <p><strong>RU:</strong> изменяет существующий объект Alfresco и возвращает состояние, подтверждённое сервером.</p>
     * <p><strong>EN:</strong> updates an existing Alfresco object and returns the server-confirmed state.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param name RU: имя создаваемого или изменяемого объекта. EN: name of the object being created or changed.
     * @param aspects RU: значение параметра `aspects` для выполняемой операции. EN: value of `aspects` used by the operation.
     * @param properties RU: свойства Alfresco, которые требуется установить или изменить. EN: Alfresco properties to set or update.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public NodeEntry update(String nodeId, String name, List<String> aspects, Map<String,String> properties) {
        NodeBodyUpdate b=new NodeBodyUpdate(); b.setName(name); b.setAspectNames(aspects); b.setProperties(properties); return nodes.updateNode(nodeId,null,null,b);
    }
        /**
     * <p><strong>RU:</strong> создаёт папку в указанном родительском узле, чтобы приложение могло формировать структуру репозитория без работы с generated DTO.</p>
     * <p><strong>EN:</strong> creates a folder under the requested parent so applications can build repository structures without dealing with generated DTOs.</p>
     *
     * @param parentId RU: идентификатор родительского узла. EN: parent node identifier.
     * @param name RU: имя создаваемого или изменяемого объекта. EN: name of the object being created or changed.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public NodeEntry createFolder(String parentId, String name) {
        NodeBodyCreate b=new NodeBodyCreate(); b.setName(name); b.setNodeType("cm:folder"); return nodes.createNode(parentId,false,null,null,null,null,b);
    }
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `create` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `create` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param parentId RU: идентификатор родительского узла. EN: parent node identifier.
     * @param name RU: имя создаваемого или изменяемого объекта. EN: name of the object being created or changed.
     * @param nodeType RU: значение параметра `nodeType` для выполняемой операции. EN: value of `nodeType` used by the operation.
     * @param properties RU: свойства Alfresco, которые требуется установить или изменить. EN: Alfresco properties to set or update.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public NodeEntry create(String parentId, String name, String nodeType, Map<String,Object> properties) {
        NodeBodyCreate b=new NodeBodyCreate(); b.setName(name); b.setNodeType(nodeType); b.setProperties(properties); return nodes.createNode(parentId,null,null,null,null,null,b);
    }
        /**
     * <p><strong>RU:</strong> загружает новый документ в Alfresco и возвращает созданный узел с серверными метаданными.</p>
     * <p><strong>EN:</strong> uploads a new document to Alfresco and returns the created node with server-side metadata.</p>
     *
     * @param r RU: значение параметра `r` для выполняемой операции. EN: value of `r` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public NodeEntry upload(UploadRequest r) {
        ByteArrayResource resource = new ByteArrayResource(r.content()) {
            @Override
            public String getFilename() {
                return r.filename();
            }
        };
        return uploadResource(
                r.parentId(), r.filename(), resource, r.nodeType(), r.aspects(), r.properties(),
                r.autoRename(), r.majorVersion(), r.versioningEnabled(), false);
    }

    /**
     * <p><strong>RU:</strong> Загружает документ потоково из Spring {@link Resource} без предварительной материализации всего файла в {@code byte[]}.</p>
     * <p><strong>EN:</strong> Uploads a document from a Spring {@link Resource} without materializing the complete file into a {@code byte[]} first.</p>
     *
     * @param request RU: параметры потоковой загрузки. EN: streaming upload parameters.
     * @return RU: созданный узел Alfresco. EN: created Alfresco node.
     */
    public NodeEntry upload(StreamingUploadRequest request) {
        return uploadResource(
                request.parentId(), request.filename(), request.content(), request.nodeType(),
                request.aspects(), request.properties(), request.autoRename(),
                request.majorVersion(), request.versioningEnabled(), true);
    }

    private NodeEntry uploadResource(
            String parentId, String filename, Resource resource, String nodeType,
            List<String> aspects, Map<String, Object> properties,
            Boolean autoRename, Boolean majorVersion, Boolean versioningEnabled, boolean streaming) {
        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
        HttpHeaders fileHeaders = new HttpHeaders();
        fileHeaders.setContentDispositionFormData("filedata", filename);
        parts.add("filedata", new HttpEntity<>(resource, fileHeaders));
        addPart(parts, "name", filename);
        addPart(parts, "nodeType", nodeType);
        if (aspects != null && !aspects.isEmpty()) {
            parts.add("aspectNames", String.join(",", aspects));
        }

        if (properties != null) {
            properties.forEach((name, value) -> {
                if (name != null && !name.isBlank() && value != null) {
                    if (value instanceof Iterable<?> values) {
                        values.forEach(item -> {
                            if (item != null) {
                                parts.add(name, item.toString());
                            }
                        });
                    } else {
                        parts.add(name, value.toString());
                    }
                }
            });
        }

        return streaming
                ? streamingUpload.upload(parentId, autoRename, majorVersion, versioningEnabled, parts)
                : upload.upload(parentId, autoRename, majorVersion, versioningEnabled, parts);
    }

    private static void addPart(MultiValueMap<String, Object> parts, String name, Object value) {
        if (value != null) {
            parts.add(name, value);
        }
    }
        /**
     * <p><strong>RU:</strong> получает бинарное содержимое из Alfresco для передачи клиенту, сохранения или дальнейшей обработки.</p>
     * <p><strong>EN:</strong> retrieves binary content from Alfresco for client delivery, storage, or further processing.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @return RU: полученное бинарное содержимое. EN: retrieved binary content.
     */

    public ContentResource download(String nodeId) {
        NodeEntry n=get(nodeId); Node x=n.getEntry(); byte[] data=nodes.getNodeContent(nodeId,true,null,null);
        String mime=x!=null&&x.getContent()!=null?x.getContent().getMimeType():"application/octet-stream";
        return new ContentResource(data,x==null?null:x.getName(),mime);
    }

    /**
     * <p><strong>RU:</strong> Потоково копирует содержимое узла в предоставленный {@link OutputStream}. Метод не закрывает целевой поток.</p>
     * <p><strong>EN:</strong> Streams node content into the supplied {@link OutputStream}. The target stream is not closed by this method.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param target RU: целевой поток приложения. EN: application target stream.
     * @return RU: количество скопированных байт. EN: number of copied bytes.
     * @throws IOException RU: при ошибке чтения или записи потока. EN: if reading or writing the stream fails.
     */
    public long downloadTo(String nodeId, OutputStream target) throws IOException {
        if (target == null) {
            throw new IllegalArgumentException("target must not be null");
        }
        try (InputStream input = streamingContent.getNodeContentStream(nodeId, true, null, null)) {
            return input.transferTo(target);
        }
    }

    /**
     * <p><strong>RU:</strong> Потоково сохраняет содержимое узла в файл, заменяя существующий файл.</p>
     * <p><strong>EN:</strong> Streams node content to a file, replacing an existing file.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param target RU: путь к целевому файлу. EN: target file path.
     * @return RU: количество записанных байт. EN: number of written bytes.
     * @throws IOException RU: при ошибке файлового ввода-вывода. EN: if file I/O fails.
     */
    public long downloadTo(String nodeId, Path target) throws IOException {
        if (target == null) {
            throw new IllegalArgumentException("target must not be null");
        }
        try (OutputStream output = Files.newOutputStream(
                target, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE)) {
            return downloadTo(nodeId, output);
        }
    }
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `replaceContent` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `replaceContent` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param content RU: содержимое документа. EN: document content.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public NodeEntry replaceContent(String nodeId, byte[] content) { return nodes.updateNodeContent(nodeId,null,null,null,null,null,content); }
        /**
     * <p><strong>RU:</strong> изменяет имя узла, не меняя его идентификатор.</p>
     * <p><strong>EN:</strong> changes a node name without changing its identifier.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param name RU: имя создаваемого или изменяемого объекта. EN: name of the object being created or changed.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public NodeEntry rename(String nodeId,String name) { return update(nodeId,name,null,null); }
        /**
     * <p><strong>RU:</strong> перемещает существующий узел в другую папку репозитория.</p>
     * <p><strong>EN:</strong> moves an existing node to another repository folder.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param targetParentId RU: идентификатор папки, в которую требуется восстановить или переместить узел. EN: identifier of the folder to restore or move the node into.
     * @param name RU: имя создаваемого или изменяемого объекта. EN: name of the object being created or changed.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public NodeEntry move(String nodeId,String targetParentId,String name) { NodeBodyMove b=new NodeBodyMove(); b.setTargetParentId(targetParentId); b.setName(name); return nodes.moveNode(nodeId,null,null,b); }
        /**
     * <p><strong>RU:</strong> создаёт копию узла в целевой папке, сохраняя исходный объект.</p>
     * <p><strong>EN:</strong> copies a node into the target folder while preserving the source object.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param targetParentId RU: идентификатор папки, в которую требуется восстановить или переместить узел. EN: identifier of the folder to restore or move the node into.
     * @param name RU: имя создаваемого или изменяемого объекта. EN: name of the object being created or changed.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public NodeEntry copy(String nodeId,String targetParentId,String name) { NodeBodyCopy b=new NodeBodyCopy(); b.setTargetParentId(targetParentId); b.setName(name); return nodes.copyNode(nodeId,null,null,b); }
        /**
     * <p><strong>RU:</strong> удаляет соответствующий объект Alfresco; используйте метод, когда объект больше не должен быть доступен через репозиторий.</p>
     * <p><strong>EN:</strong> deletes the corresponding Alfresco object; use it when the object should no longer be available through the repository.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     */

    public void delete(String nodeId) { nodes.deleteNode(nodeId,false); }
        /**
     * <p><strong>RU:</strong> удаляет соответствующий объект Alfresco; используйте метод, когда объект больше не должен быть доступен через репозиторий.</p>
     * <p><strong>EN:</strong> deletes the corresponding Alfresco object; use it when the object should no longer be available through the repository.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     */

    public void deletePermanently(String nodeId) { nodes.deleteNode(nodeId,true); }
        /**
     * <p><strong>RU:</strong> устанавливает блокировку узла для защиты документа от конфликтующих изменений.</p>
     * <p><strong>EN:</strong> locks a node to protect the document from conflicting changes.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public NodeEntry lock(String nodeId) { return nodes.lockNode(nodeId,null,null,new NodeBodyLock()); }
        /**
     * <p><strong>RU:</strong> устанавливает блокировку узла для защиты документа от конфликтующих изменений.</p>
     * <p><strong>EN:</strong> locks a node to protect the document from conflicting changes.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public NodeEntry unlock(String nodeId) { return nodes.unlockNode(nodeId,null,null); }
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `checkout` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `checkout` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public NodeEntry checkout(String nodeId) { return nodes.checkoutNode(nodeId,null,null); }
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `cancelCheckout` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `cancelCheckout` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public NodeEntry cancelCheckout(String nodeId) { return nodes.cancelCheckoutNode(nodeId,null,null); }
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `children` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `children` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public NodeChildAssociationPaging children(String nodeId,int skip,int size) { return nodes.listNodeChildren(nodeId,skip,size,null,null,null,null,null,null); }
}
