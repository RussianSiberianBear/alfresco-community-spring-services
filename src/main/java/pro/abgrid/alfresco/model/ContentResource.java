package pro.abgrid.alfresco.model;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * <p><strong>RU:</strong> High-level представление загруженного из Alfresco бинарного содержимого вместе с именем файла и MIME-типом. Удобно для сохранения на диск, передачи HTTP-клиенту или дальнейшей обработки.</p>
 * <p><strong>EN:</strong> High-level representation of binary content downloaded from Alfresco together with file name and MIME type. Useful for saving, returning from an HTTP endpoint, or further processing.</p>
 *
 * @param content RU: бинарное содержимое. EN: binary content.
 * @param filename RU: имя файла. EN: file name.
 * @param mimeType RU: MIME-тип содержимого. EN: content MIME type.
 */
public record ContentResource(byte[] content, String filename, String mimeType) {
        /**
     * <p><strong>RU:</strong> Создаёт новый InputStream поверх content без копирования в файл; каждый вызов возвращает новый поток.</p>
     * <p><strong>EN:</strong> Creates a new InputStream over content without writing a file; every call returns a new stream.</p>
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public InputStream inputStream() { return new ByteArrayInputStream(content); }
        /**
     * <p><strong>RU:</strong> Задаёт/возвращает размер страницы; при чтении значение не меньше 1.</p>
     * <p><strong>EN:</strong> Sets/returns page size; the read value is at least 1.</p>
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public long size() { return content == null ? 0 : content.length; }
}
