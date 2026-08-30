package pro.abgrid.alfresco.service.image;

import pro.abgrid.alfresco.api.NodesApi;
import pro.abgrid.alfresco.dto.core.NodeEntry;
import org.springframework.stereotype.Service;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * <p><strong>RU:</strong> Высокоуровневый Spring-сервис для сценариев «image» в Alfresco. Он служит прикладной границей над generated REST API: принимает более удобные параметры, скрывает технические детали HTTP/DTO там, где для них есть high-level модель, и оставляет доступ к серверному результату, когда это необходимо. Сервис предназначен для внедрения как обычный Spring bean в бизнес-сервисы приложения.</p>
 * <p><strong>EN:</strong> High-level Spring service for Alfresco image scenarios. It acts as an application boundary over the generated REST API: it accepts application-friendly parameters, hides HTTP/DTO plumbing where a high-level model exists, and still exposes server results when required. The service is intended to be injected as a regular Spring bean into application business services.</p>
 */
@Service
public class AlfrescoImageService {
    private final NodesApi nodes;
        /**
     * <p><strong>RU:</strong> создаёт сервис и получает его зависимости через Spring DI; обычно этот конструктор не вызывается прикладным кодом напрямую.</p>
     * <p><strong>EN:</strong> creates the service with dependencies supplied by Spring DI; application code normally does not call this constructor directly.</p>
     *
     * @param nodes RU: зависимость `nodes`, используемая сервисом для выполнения операций Alfresco. EN: `nodes` dependency used by the service to perform Alfresco operations.
     */

    public AlfrescoImageService(NodesApi nodes){this.nodes=nodes;}
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `resize` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `resize` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param width RU: значение параметра `width` для выполняемой операции. EN: value of `width` used by the operation.
     * @param height RU: значение параметра `height` для выполняемой операции. EN: value of `height` used by the operation.
     * @param format RU: значение параметра `format` для выполняемой операции. EN: value of `format` used by the operation.
     * @return RU: полученное бинарное содержимое. EN: retrieved binary content.
     */

    public byte[] resize(String nodeId,int width,int height,String format) {
        try {
            byte[] source=nodes.getNodeContent(nodeId,true,null,null);
            BufferedImage input=ImageIO.read(new ByteArrayInputStream(source));
            if(input==null) throw new IllegalArgumentException("Node is not a supported image: "+nodeId);
            BufferedImage output=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
            var g=output.createGraphics(); g.drawImage(input,0,0,width,height,null); g.dispose();
            ByteArrayOutputStream out=new ByteArrayOutputStream(); if(!ImageIO.write(output,format,out)) throw new IllegalArgumentException("Unsupported image format: "+format); return out.toByteArray();
        } catch(IOException e){throw new UncheckedIOException("Unable to resize image",e);}
    }
        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `resizeAndReplace` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `resizeAndReplace` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param width RU: значение параметра `width` для выполняемой операции. EN: value of `width` used by the operation.
     * @param height RU: значение параметра `height` для выполняемой операции. EN: value of `height` used by the operation.
     * @param format RU: значение параметра `format` для выполняемой операции. EN: value of `format` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public NodeEntry resizeAndReplace(String nodeId,int width,int height,String format){return nodes.updateNodeContent(nodeId,null,null,null,null,null,resize(nodeId,width,height,format));}
}
