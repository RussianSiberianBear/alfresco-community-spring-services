package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;
import java.util.Map;

/**
 * RU: DTO-модель Alfresco REST API: Activity.
 * EN: Alfresco REST API DTO model: Activity.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Activity {
    /**
     * <p><strong>RU:</strong> значение поля «post person id» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> The id of the person who performed the activity. Required by the Swagger schema.</p>
     */
    private String postPersonId;

    /**

     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> The unique id of the activity. Required by the Swagger schema.</p>

     */

    private Long id;

    /**

     * <p><strong>RU:</strong> значение поля «site id» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The unique id of the site on which the activity was performed. Optional unless a specific endpoint requires it.</p>

     */

    private String siteId;

    /**

     * <p><strong>RU:</strong> значение поля «posted at» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The date time at which the activity was performed. Optional unless a specific endpoint requires it.</p>

     */

    private OffsetDateTime postedAt;

    /**

     * <p><strong>RU:</strong> значение поля «feed person id» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> The feed on which this activity was posted. Required by the Swagger schema.</p>

     */

    private String feedPersonId;

    /**

     * <p><strong>RU:</strong> значение поля «activity summary» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> An object summarizing the activity. Optional unless a specific endpoint requires it.</p>

     */

    private Map<String, String> activitySummary;

    /**

     * <p><strong>RU:</strong> значение поля «activity type» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> The type of the activity posted. Required by the Swagger schema.</p>

     */

    private String activityType;

    /**
     * RU: Создаёт экземпляр Activity.
     * EN: Creates a Activity instance.
     */
    public Activity() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «post person id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The id of the person who performed the activity.</p>
     *
     * @return RU: текущее значение postPersonId. EN: current value of postPersonId.
     */

    public String getPostPersonId() {
        return postPersonId;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «post person id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The id of the person who performed the activity.</p>
     *
     * @param postPersonId RU: новое значение postPersonId. EN: new value for postPersonId.
     */

    public void setPostPersonId(String postPersonId) {
        this.postPersonId = postPersonId;
    }

        /**
     * <p><strong>RU:</strong> Возвращает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Returns The unique id of the activity.</p>
     *
     * @return RU: текущее значение id. EN: current value of id.
     */

    public Long getId() {
        return id;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Sets The unique id of the activity.</p>
     *
     * @param id RU: новое значение id. EN: new value for id.
     */

    public void setId(Long id) {
        this.id = id;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «site id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The unique id of the site on which the activity was performed.</p>
     *
     * @return RU: текущее значение siteId. EN: current value of siteId.
     */

    public String getSiteId() {
        return siteId;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «site id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The unique id of the site on which the activity was performed.</p>
     *
     * @param siteId RU: новое значение siteId. EN: new value for siteId.
     */

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «posted at» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The date time at which the activity was performed.</p>
     *
     * @return RU: текущее значение postedAt. EN: current value of postedAt.
     */

    public OffsetDateTime getPostedAt() {
        return postedAt;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «posted at» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The date time at which the activity was performed.</p>
     *
     * @param postedAt RU: новое значение postedAt. EN: new value for postedAt.
     */

    public void setPostedAt(OffsetDateTime postedAt) {
        this.postedAt = postedAt;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «feed person id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The feed on which this activity was posted.</p>
     *
     * @return RU: текущее значение feedPersonId. EN: current value of feedPersonId.
     */

    public String getFeedPersonId() {
        return feedPersonId;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «feed person id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The feed on which this activity was posted.</p>
     *
     * @param feedPersonId RU: новое значение feedPersonId. EN: new value for feedPersonId.
     */

    public void setFeedPersonId(String feedPersonId) {
        this.feedPersonId = feedPersonId;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «activity summary» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns An object summarizing the activity.</p>
     *
     * @return RU: текущее значение activitySummary. EN: current value of activitySummary.
     */

    public Map<String, String> getActivitySummary() {
        return activitySummary;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «activity summary» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets An object summarizing the activity.</p>
     *
     * @param activitySummary RU: новое значение activitySummary. EN: new value for activitySummary.
     */

    public void setActivitySummary(Map<String, String> activitySummary) {
        this.activitySummary = activitySummary;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «activity type» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The type of the activity posted.</p>
     *
     * @return RU: текущее значение activityType. EN: current value of activityType.
     */

    public String getActivityType() {
        return activityType;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «activity type» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The type of the activity posted.</p>
     *
     * @param activityType RU: новое значение activityType. EN: new value for activityType.
     */

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

}
