package pro.abgrid.alfresco.model;

/**
 * <p><strong>RU:</strong> Описывает создание новой версии документа: major/minor и комментарий. Фабрики major/minor делают вызывающий код читаемее.</p>
 * <p><strong>EN:</strong> Describes creation of a new document version: major/minor flag and comment. The major/minor factories make calling code more expressive.</p>
 *
 * @param major RU: true для major, false для minor версии. EN: true for a major, false for a minor version.
 * @param comment RU: комментарий к версии. EN: version comment.
 */
public record VersionRequest(boolean major, String comment) {
        /**
     * <p><strong>RU:</strong> Создаёт VersionRequest для major-версии.</p>
     * <p><strong>EN:</strong> Creates a VersionRequest for a major version.</p>
     *
     * @param comment RU: комментарий к версии. EN: version comment.
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public static VersionRequest major(String comment) {
        return new VersionRequest(true, comment);
    }

        /**
     * <p><strong>RU:</strong> Создаёт VersionRequest для minor-версии.</p>
     * <p><strong>EN:</strong> Creates a VersionRequest for a minor version.</p>
     *
     * @param comment RU: комментарий к версии. EN: version comment.
     * @return RU: результат, описанный выше. EN: result described above.
     */

    public static VersionRequest minor(String comment) {
        return new VersionRequest(false, comment);
    }
}
