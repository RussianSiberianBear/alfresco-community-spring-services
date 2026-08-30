package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * RU: DTO-модель Alfresco REST API: CascadingDictContentDef.
 * EN: Alfresco REST API DTO model: CascadingDictContentDef.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CascadingDictContentDef {
    /**
     * <p><strong>RU:</strong> значение поля «levels» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the levels field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private List<CascadingDictLevel> levels;

    /**
     * RU: Создаёт экземпляр CascadingDictContentDef.
     * EN: Creates a CascadingDictContentDef instance.
     */
    public CascadingDictContentDef() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «levels» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the levels field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение levels. EN: current value of levels.
     */

    public List<CascadingDictLevel> getLevels() {
        return levels;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «levels» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the levels field in the Alfresco REST API model.</p>
     *
     * @param levels RU: новое значение levels. EN: new value for levels.
     */

    public void setLevels(List<CascadingDictLevel> levels) {
        this.levels = levels;
    }

}
