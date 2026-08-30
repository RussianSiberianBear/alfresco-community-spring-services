package pro.abgrid.alfresco.dto.discovery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: RepositoryEntry.
 * EN: Alfresco REST API DTO model: RepositoryEntry.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryEntry {
    /**
     * <p><strong>RU:</strong> значение поля «repository» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the repository field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private RepositoryInfo repository;

    /**
     * RU: Создаёт экземпляр RepositoryEntry.
     * EN: Creates a RepositoryEntry instance.
     */
    public RepositoryEntry() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «repository» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the repository field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение repository. EN: current value of repository.
     */

    public RepositoryInfo getRepository() {
        return repository;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «repository» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the repository field in the Alfresco REST API model.</p>
     *
     * @param repository RU: новое значение repository. EN: new value for repository.
     */

    public void setRepository(RepositoryInfo repository) {
        this.repository = repository;
    }

}
