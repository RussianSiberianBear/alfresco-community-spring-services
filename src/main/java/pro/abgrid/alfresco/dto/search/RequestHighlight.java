package pro.abgrid.alfresco.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * RU: DTO-модель Alfresco REST API: RequestHighlight.
 * EN: Alfresco REST API DTO model: RequestHighlight.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestHighlight {
    /**
     * <p><strong>RU:</strong> значение поля «prefix» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> The string used to mark the start of a highlight in a fragment.. Optional unless a specific endpoint requires it.</p>
     */
    private String prefix;

    /**

     * <p><strong>RU:</strong> значение поля «postfix» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The string used to mark the end of a highlight in a fragment.. Optional unless a specific endpoint requires it.</p>

     */

    private String postfix;

    /**

     * <p><strong>RU:</strong> значение поля «snippet count» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The maximum number of distinct highlight snippets to return for each highlight field.. Optional unless a specific endpoint requires it.</p>

     */

    private Integer snippetCount;

    /**

     * <p><strong>RU:</strong> значение поля «fragment size» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The character length of each snippet.. Optional unless a specific endpoint requires it.</p>

     */

    private Integer fragmentSize;

    /**

     * <p><strong>RU:</strong> значение поля «max analyzed chars» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The number of characters to be considered for highlighting. Matches after this count will not be shown.. Optional unless a specific endpoint requires it.</p>

     */

    private Integer maxAnalyzedChars;

    /**

     * <p><strong>RU:</strong> значение поля «merge contiguous» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> If fragments over lap they can be merged into one larger fragment. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean mergeContiguous;

    /**

     * <p><strong>RU:</strong> значение поля «use phrase highlighter» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Should phrases be identified.. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean usePhraseHighlighter;

    /**

     * <p><strong>RU:</strong> значение поля «fields» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The fields to highlight and field specific configuration properties for each field. Optional unless a specific endpoint requires it.</p>

     */

    private List<Object> fields;

    /**
     * RU: Создаёт экземпляр RequestHighlight.
     * EN: Creates a RequestHighlight instance.
     */
    public RequestHighlight() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «prefix» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The string used to mark the start of a highlight in a fragment..</p>
     *
     * @return RU: текущее значение prefix. EN: current value of prefix.
     */

    public String getPrefix() {
        return prefix;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «prefix» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The string used to mark the start of a highlight in a fragment..</p>
     *
     * @param prefix RU: новое значение prefix. EN: new value for prefix.
     */

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «postfix» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The string used to mark the end of a highlight in a fragment..</p>
     *
     * @return RU: текущее значение postfix. EN: current value of postfix.
     */

    public String getPostfix() {
        return postfix;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «postfix» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The string used to mark the end of a highlight in a fragment..</p>
     *
     * @param postfix RU: новое значение postfix. EN: new value for postfix.
     */

    public void setPostfix(String postfix) {
        this.postfix = postfix;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «snippet count» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The maximum number of distinct highlight snippets to return for each highlight field..</p>
     *
     * @return RU: текущее значение snippetCount. EN: current value of snippetCount.
     */

    public Integer getSnippetCount() {
        return snippetCount;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «snippet count» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The maximum number of distinct highlight snippets to return for each highlight field..</p>
     *
     * @param snippetCount RU: новое значение snippetCount. EN: new value for snippetCount.
     */

    public void setSnippetCount(Integer snippetCount) {
        this.snippetCount = snippetCount;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «fragment size» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The character length of each snippet..</p>
     *
     * @return RU: текущее значение fragmentSize. EN: current value of fragmentSize.
     */

    public Integer getFragmentSize() {
        return fragmentSize;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «fragment size» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The character length of each snippet..</p>
     *
     * @param fragmentSize RU: новое значение fragmentSize. EN: new value for fragmentSize.
     */

    public void setFragmentSize(Integer fragmentSize) {
        this.fragmentSize = fragmentSize;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «max analyzed chars» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The number of characters to be considered for highlighting. Matches after this count will not be shown..</p>
     *
     * @return RU: текущее значение maxAnalyzedChars. EN: current value of maxAnalyzedChars.
     */

    public Integer getMaxAnalyzedChars() {
        return maxAnalyzedChars;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «max analyzed chars» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The number of characters to be considered for highlighting. Matches after this count will not be shown..</p>
     *
     * @param maxAnalyzedChars RU: новое значение maxAnalyzedChars. EN: new value for maxAnalyzedChars.
     */

    public void setMaxAnalyzedChars(Integer maxAnalyzedChars) {
        this.maxAnalyzedChars = maxAnalyzedChars;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «merge contiguous» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns If fragments over lap they can be merged into one larger fragment.</p>
     *
     * @return RU: текущее значение mergeContiguous. EN: current value of mergeContiguous.
     */

    public Boolean getMergeContiguous() {
        return mergeContiguous;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «merge contiguous» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets If fragments over lap they can be merged into one larger fragment.</p>
     *
     * @param mergeContiguous RU: новое значение mergeContiguous. EN: new value for mergeContiguous.
     */

    public void setMergeContiguous(Boolean mergeContiguous) {
        this.mergeContiguous = mergeContiguous;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «use phrase highlighter» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Should phrases be identified..</p>
     *
     * @return RU: текущее значение usePhraseHighlighter. EN: current value of usePhraseHighlighter.
     */

    public Boolean getUsePhraseHighlighter() {
        return usePhraseHighlighter;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «use phrase highlighter» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Should phrases be identified..</p>
     *
     * @param usePhraseHighlighter RU: новое значение usePhraseHighlighter. EN: new value for usePhraseHighlighter.
     */

    public void setUsePhraseHighlighter(Boolean usePhraseHighlighter) {
        this.usePhraseHighlighter = usePhraseHighlighter;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «fields» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The fields to highlight and field specific configuration properties for each field.</p>
     *
     * @return RU: текущее значение fields. EN: current value of fields.
     */

    public List<Object> getFields() {
        return fields;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «fields» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The fields to highlight and field specific configuration properties for each field.</p>
     *
     * @param fields RU: новое значение fields. EN: new value for fields.
     */

    public void setFields(List<Object> fields) {
        this.fields = fields;
    }

}
