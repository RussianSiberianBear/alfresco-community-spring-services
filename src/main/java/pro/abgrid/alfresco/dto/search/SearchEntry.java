package pro.abgrid.alfresco.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * RU: DTO-модель Alfresco REST API: SearchEntry.
 * EN: Alfresco REST API DTO model: SearchEntry.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchEntry {
    /**
     * <p><strong>RU:</strong> значение поля «score» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> The score for this row. Optional unless a specific endpoint requires it.</p>
     */
    private Double score;

    /**

     * <p><strong>RU:</strong> значение поля «highlight» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Highlight fragments if requested and available. A match can happen in any of the requested field.. Optional unless a specific endpoint requires it.</p>

     */

    private List<Object> highlight;

    /**
     * RU: Создаёт экземпляр SearchEntry.
     * EN: Creates a SearchEntry instance.
     */
    public SearchEntry() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «score» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The score for this row.</p>
     *
     * @return RU: текущее значение score. EN: current value of score.
     */

    public Double getScore() {
        return score;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «score» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The score for this row.</p>
     *
     * @param score RU: новое значение score. EN: new value for score.
     */

    public void setScore(Double score) {
        this.score = score;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «highlight» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Highlight fragments if requested and available. A match can happen in any of the requested field..</p>
     *
     * @return RU: текущее значение highlight. EN: current value of highlight.
     */

    public List<Object> getHighlight() {
        return highlight;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «highlight» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Highlight fragments if requested and available. A match can happen in any of the requested field..</p>
     *
     * @param highlight RU: новое значение highlight. EN: new value for highlight.
     */

    public void setHighlight(List<Object> highlight) {
        this.highlight = highlight;
    }

}
