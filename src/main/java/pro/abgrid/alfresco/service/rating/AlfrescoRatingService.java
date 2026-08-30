package pro.abgrid.alfresco.service.rating;

import pro.abgrid.alfresco.api.RatingsApi;
import pro.abgrid.alfresco.dto.core.RatingBody;
import pro.abgrid.alfresco.dto.core.RatingEntry;
import pro.abgrid.alfresco.dto.core.RatingPaging;
import org.springframework.stereotype.Service;

/**
 * <p><strong>RU:</strong> Высокоуровневый Spring-сервис для сценариев «rating» в Alfresco. Он служит прикладной границей над generated REST API: принимает более удобные параметры, скрывает технические детали HTTP/DTO там, где для них есть high-level модель, и оставляет доступ к серверному результату, когда это необходимо. Сервис предназначен для внедрения как обычный Spring bean в бизнес-сервисы приложения.</p>
 * <p><strong>EN:</strong> High-level Spring service for Alfresco rating scenarios. It acts as an application boundary over the generated REST API: it accepts application-friendly parameters, hides HTTP/DTO plumbing where a high-level model exists, and still exposes server results when required. The service is intended to be injected as a regular Spring bean into application business services.</p>
 */
@Service
public class AlfrescoRatingService {
    /** RU: Схема рейтинга {@code likes}. EN: {@code likes} rating scheme. */
    public static final String LIKES = "likes";
    /** RU: Схема рейтинга {@code fiveStar}. EN: {@code fiveStar} rating scheme. */
    public static final String FIVE_STAR = "fiveStar";

    private final RatingsApi api;

        /**
     * <p><strong>RU:</strong> создаёт сервис и получает его зависимости через Spring DI; обычно этот конструктор не вызывается прикладным кодом напрямую.</p>
     * <p><strong>EN:</strong> creates the service with dependencies supplied by Spring DI; application code normally does not call this constructor directly.</p>
     *
     * @param api RU: зависимость `api`, используемая сервисом для выполнения операций Alfresco. EN: `api` dependency used by the service to perform Alfresco operations.
     */

    public AlfrescoRatingService(RatingsApi api) {
        this.api = api;
    }

        /**
     * <p><strong>RU:</strong> получает список объектов из Alfresco с учётом поддерживаемых сервером ограничений и пагинации.</p>
     * <p><strong>EN:</strong> retrieves a list of Alfresco objects using the server-supported filtering and paging options.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public RatingPaging list(String nodeId, int skip, int size) {
        return api.listRatings(nodeId, skip, size, null);
    }

        /**
     * <p><strong>RU:</strong> получает актуальное представление объекта из Alfresco; подходит для чтения его серверного состояния и метаданных.</p>
     * <p><strong>EN:</strong> retrieves the current Alfresco representation of the object for reading server-side state and metadata.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param scheme RU: значение параметра `scheme` для выполняемой операции. EN: value of `scheme` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public RatingEntry get(String nodeId, String scheme) {
        return api.getRating(nodeId, scheme, null);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `rate` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `rate` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param scheme RU: значение параметра `scheme` для выполняемой операции. EN: value of `scheme` used by the operation.
     * @param value RU: значение параметра `value` для выполняемой операции. EN: value of `value` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public RatingEntry rate(String nodeId, String scheme, Object value) {
        RatingBody body = new RatingBody();
        body.setId(scheme);
        body.setMyRating(value);
        return api.createRating(nodeId, null, body);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `rate` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `rate` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param scheme RU: значение параметра `scheme` для выполняемой операции. EN: value of `scheme` used by the operation.
     * @param value RU: значение параметра `value` для выполняемой операции. EN: value of `value` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public RatingEntry rate(String nodeId, String scheme, String value) {
        return rate(nodeId, scheme, (Object) value);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `like` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `like` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public RatingEntry like(String nodeId) {
        return rate(nodeId, LIKES, Boolean.TRUE);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `fiveStar` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `fiveStar` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param stars RU: значение параметра `stars` для выполняемой операции. EN: value of `stars` used by the operation.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public RatingEntry fiveStar(String nodeId, int stars) {
        if (stars < 1 || stars > 5) {
            throw new IllegalArgumentException("Five-star rating must be between 1 and 5");
        }
        return rate(nodeId, FIVE_STAR, stars);
    }

        /**
     * <p><strong>RU:</strong> перемещает существующий узел в другую папку репозитория.</p>
     * <p><strong>EN:</strong> moves an existing node to another repository folder.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param scheme RU: значение параметра `scheme` для выполняемой операции. EN: value of `scheme` used by the operation.
     */

    public void remove(String nodeId, String scheme) {
        api.deleteRating(nodeId, scheme);
    }
}
