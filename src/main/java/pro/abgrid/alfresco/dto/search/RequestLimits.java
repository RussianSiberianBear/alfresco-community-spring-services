package pro.abgrid.alfresco.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: RequestLimits.
 * EN: Alfresco REST API DTO model: RequestLimits.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestLimits {
    /**
     * <p><strong>RU:</strong> значение поля «permission evaluation time» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Maximum time for post query permission evaluation. Optional unless a specific endpoint requires it.</p>
     */
    private Integer permissionEvaluationTime;

    /**

     * <p><strong>RU:</strong> значение поля «permission evaluation count» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Maximum count of post query permission evaluations. Optional unless a specific endpoint requires it.</p>

     */

    private Integer permissionEvaluationCount;

    /**

     * <p><strong>RU:</strong> значение поля «track total hits limit» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Maximum count of total items to track accurately for search results. Special values: * -1: Unlimited tracking of total hits * 0: Use default search engine setting * Positive integer: Track total hits accurately up to this value Default: 10000 Note: Tracking a large number of total hits may impact query performance for queries that match many documents.. Optional unless a specific endpoint requires it.</p>

     */

    private Integer trackTotalHitsLimit;

    /**
     * RU: Создаёт экземпляр RequestLimits.
     * EN: Creates a RequestLimits instance.
     */
    public RequestLimits() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «permission evaluation time» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Maximum time for post query permission evaluation.</p>
     *
     * @return RU: текущее значение permissionEvaluationTime. EN: current value of permissionEvaluationTime.
     */

    public Integer getPermissionEvaluationTime() {
        return permissionEvaluationTime;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «permission evaluation time» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Maximum time for post query permission evaluation.</p>
     *
     * @param permissionEvaluationTime RU: новое значение permissionEvaluationTime. EN: new value for permissionEvaluationTime.
     */

    public void setPermissionEvaluationTime(Integer permissionEvaluationTime) {
        this.permissionEvaluationTime = permissionEvaluationTime;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «permission evaluation count» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Maximum count of post query permission evaluations.</p>
     *
     * @return RU: текущее значение permissionEvaluationCount. EN: current value of permissionEvaluationCount.
     */

    public Integer getPermissionEvaluationCount() {
        return permissionEvaluationCount;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «permission evaluation count» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Maximum count of post query permission evaluations.</p>
     *
     * @param permissionEvaluationCount RU: новое значение permissionEvaluationCount. EN: new value for permissionEvaluationCount.
     */

    public void setPermissionEvaluationCount(Integer permissionEvaluationCount) {
        this.permissionEvaluationCount = permissionEvaluationCount;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «track total hits limit» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Maximum count of total items to track accurately for search results. Special values: * -1: Unlimited tracking of total hits * 0: Use default search engine setting * Positive integer: Track total hits accurately up to this value Default: 10000 Note: Tracking a large number of total hits may impact query performance for queries that match many documents..</p>
     *
     * @return RU: текущее значение trackTotalHitsLimit. EN: current value of trackTotalHitsLimit.
     */

    public Integer getTrackTotalHitsLimit() {
        return trackTotalHitsLimit;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «track total hits limit» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Maximum count of total items to track accurately for search results. Special values: * -1: Unlimited tracking of total hits * 0: Use default search engine setting * Positive integer: Track total hits accurately up to this value Default: 10000 Note: Tracking a large number of total hits may impact query performance for queries that match many documents..</p>
     *
     * @param trackTotalHitsLimit RU: новое значение trackTotalHitsLimit. EN: new value for trackTotalHitsLimit.
     */

    public void setTrackTotalHitsLimit(Integer trackTotalHitsLimit) {
        this.trackTotalHitsLimit = trackTotalHitsLimit;
    }

}
