package pro.abgrid.alfresco.integration;

import pro.abgrid.alfresco.dto.core.NodeEntry;
import pro.abgrid.alfresco.model.TransformationResult;
import pro.abgrid.alfresco.model.UploadRequest;
import pro.abgrid.alfresco.service.content.AlfrescoContentService;
import pro.abgrid.alfresco.service.transformation.AlfrescoTransformationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = AlfrescoTransformationIntegrationTest.TestApp.class)
class AlfrescoTransformationIntegrationTest extends AlfrescoIntegrationTestBase {
    private static final String COMPANY_HOME = "-root-";

    @Autowired
    AlfrescoContentService content;

    @Autowired
    AlfrescoTransformationService transformation;

    @Test
    void docxToPdf() throws Exception {
        String folderName = "alfresco-community-spring-services-transform-it-" + System.currentTimeMillis();
        NodeEntry folder = content.createFolder(COMPANY_HOME, folderName);
        String folderId = folder.getEntry().getId();
        String fileName = "transform-test.docx";
        String sourceText = "Alfresco Community Spring Services transformation test";

        try {
            NodeEntry uploaded = content.upload(new UploadRequest(
                    folderId,
                    fileName,
                    createDocx(sourceText)));
            String nodeId = uploaded.getEntry().getId();

            TransformationResult pdf = transformation.toPdf(nodeId);

            assertThat(pdf.status()).isEqualToIgnoringCase("CREATED");
            assertThat(pdf.content()).isNotEmpty();
            assertThat(pdf.mimeType()).isEqualTo("application/pdf");
            assertThat(pdf.content()).startsWith(new byte[]{0x25, 0x50, 0x44, 0x46}); // %PDF

            content.delete(nodeId);
        } finally {
            content.deletePermanently(folderId);
        }
    }

    @Test
    void imageThumbnail() throws Exception {
        String folderName = "alfresco-community-spring-services-thumbnail-it-" + System.currentTimeMillis();
        NodeEntry folder = content.createFolder(COMPANY_HOME, folderName);
        String folderId = folder.getEntry().getId();

        try {
            NodeEntry uploaded = content.upload(new UploadRequest(
                    folderId,
                    "transform-test.png",
                    createPng()));
            String nodeId = uploaded.getEntry().getId();

            TransformationResult thumbnail = transformation.thumbnail(nodeId);

            assertThat(thumbnail.status()).isEqualToIgnoringCase("CREATED");
            assertThat(thumbnail.content()).isNotEmpty();
            assertThat(thumbnail.mimeType()).startsWith("image/");

            content.delete(nodeId);
        } finally {
            content.deletePermanently(folderId);
        }
    }

    private static byte[] createPng() throws IOException {
        BufferedImage image = new BufferedImage(160, 100, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int r = x * 255 / image.getWidth();
                int g = y * 255 / image.getHeight();
                int b = 180;
                image.setRGB(x, y, (r << 16) | (g << 8) | b);
            }
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write(image, "png", out);
        return out.toByteArray();
    }

    /** Creates a minimal valid DOCX without adding a third-party document library. */
    private static byte[] createDocx(String text) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (ZipOutputStream zip = new ZipOutputStream(out)) {
            put(zip, "[Content_Types].xml", """
                    <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                    <Types xmlns="http://schemas.openxmlformats.org/package/2006/content-types">
                      <Default Extension="rels" ContentType="application/vnd.openxmlformats-package.relationships+xml"/>
                      <Default Extension="xml" ContentType="application/xml"/>
                      <Override PartName="/word/document.xml" ContentType="application/vnd.openxmlformats-officedocument.wordprocessingml.document.main+xml"/>
                    </Types>
                    """);
            put(zip, "_rels/.rels", """
                    <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                    <Relationships xmlns="http://schemas.openxmlformats.org/package/2006/relationships">
                      <Relationship Id="rId1" Type="http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument" Target="word/document.xml"/>
                    </Relationships>
                    """);
            put(zip, "word/document.xml", """
                    <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                    <w:document xmlns:w="http://schemas.openxmlformats.org/wordprocessingml/2006/main">
                      <w:body>
                        <w:p><w:r><w:t>%s</w:t></w:r></w:p>
                        <w:sectPr/>
                      </w:body>
                    </w:document>
                    """.formatted(escapeXml(text)));
        }
        return out.toByteArray();
    }

    private static void put(ZipOutputStream zip, String name, String content) throws IOException {
        zip.putNextEntry(new ZipEntry(name));
        zip.write(content.getBytes(StandardCharsets.UTF_8));
        zip.closeEntry();
    }

    private static String escapeXml(String value) {
        return value.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&apos;");
    }

    @SpringBootApplication
    @ComponentScan(basePackages = "pro.abgrid.alfresco")
    static class TestApp {
    }
}
