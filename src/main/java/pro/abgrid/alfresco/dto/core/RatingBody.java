package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: RatingBody.
 * EN: Alfresco REST API DTO model: RatingBody.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RatingBody {
    /**
     * <p><strong>RU:</strong> уникальный идентификатор ресурса. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> The rating scheme type. Possible values are likes and fiveStar.. Required by the Swagger schema.</p>
     */
    private String id;

    /**

     * <p><strong>RU:</strong> рейтинг текущего пользователя; в ACS 26.2.0 likes возвращает boolean, а fiveStar — integer. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> The rating. The type is specific to the rating scheme: boolean for likes and integer for fiveStar.. Required by the Swagger schema.</p>

     */

    private Object myRating;

    /**
     * RU: Создаёт экземпляр RatingBody.
     * EN: Creates a RatingBody instance.
     */
    public RatingBody() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Returns The rating scheme type. Possible values are likes and fiveStar..</p>
     *
     * @return RU: текущее значение id. EN: current value of id.
     */

    public String getId() {
        return id;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает уникальный идентификатор ресурса.</p>
     * <p><strong>EN:</strong> Sets The rating scheme type. Possible values are likes and fiveStar..</p>
     *
     * @param id RU: новое значение id. EN: new value for id.
     */

    public void setId(String id) {
        this.id = id;
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
