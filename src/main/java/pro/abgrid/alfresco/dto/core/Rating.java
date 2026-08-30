package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;

/**
 * RU: DTO-модель Alfresco REST API: Rating.
 * EN: Alfresco REST API DTO model: Rating.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rating {
    /**
     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the id field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private String id;

    /**

     * <p><strong>RU:</strong> значение поля «aggregate» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the aggregate field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private Object aggregate;

    /**

     * <p><strong>RU:</strong> значение поля «rated at» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the rated at field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private OffsetDateTime ratedAt;

    /**

     * <p><strong>RU:</strong> рейтинг текущего пользователя; в ACS 26.2.0 likes возвращает boolean, а fiveStar — integer. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The rating. The type is specific to the rating scheme: boolean for likes and integer for fiveStar.. Optional unless a specific endpoint requires it.</p>

     */

    private Object myRating;

    /**
     * RU: Создаёт экземпляр Rating.
     * EN: Creates a Rating instance.
     */
    public Rating() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Returns Value of the id field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение id. EN: current value of id.
     */

    public String getId() {
        return id;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Sets Value of the id field in the Alfresco REST API model.</p>
     *
     * @param id RU: новое значение id. EN: new value for id.
     */

    public void setId(String id) {
        this.id = id;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «aggregate» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the aggregate field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение aggregate. EN: current value of aggregate.
     */

    public Object getAggregate() {
        return aggregate;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «aggregate» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the aggregate field in the Alfresco REST API model.</p>
     *
     * @param aggregate RU: новое значение aggregate. EN: new value for aggregate.
     */

    public void setAggregate(Object aggregate) {
        this.aggregate = aggregate;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «rated at» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the rated at field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение ratedAt. EN: current value of ratedAt.
     */

    public OffsetDateTime getRatedAt() {
        return ratedAt;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «rated at» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the rated at field in the Alfresco REST API model.</p>
     *
     * @param ratedAt RU: новое значение ratedAt. EN: new value for ratedAt.
     */

    public void setRatedAt(OffsetDateTime ratedAt) {
        this.ratedAt = ratedAt;
    }

        /**
     * <p><strong>RU:</strong> Возвращает рейтинг текущего пользователя; в ACS 26.2.0 likes возвращает boolean, а fiveStar — integer.</p>
     * <p><strong>EN:</strong> Returns The rating. The type is specific to the rating scheme: boolean for likes and integer for fiveStar..</p>
     *
     * @return RU: текущее значение myRating. EN: current value of myRating.
     */

    public Object getMyRating() {
        return myRating;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает рейтинг текущего пользователя; в ACS 26.2.0 likes возвращает boolean, а fiveStar — integer.</p>
     * <p><strong>EN:</strong> Sets The rating. The type is specific to the rating scheme: boolean for likes and integer for fiveStar..</p>
     *
     * @param myRating RU: новое значение myRating. EN: new value for myRating.
     */

    public void setMyRating(Object myRating) {
        this.myRating = myRating;
    }

}
