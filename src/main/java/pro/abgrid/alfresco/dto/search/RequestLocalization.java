package pro.abgrid.alfresco.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * RU: DTO-модель Alfresco REST API: RequestLocalization.
 * EN: Alfresco REST API DTO model: RequestLocalization.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestLocalization {
    /**
     * <p><strong>RU:</strong> значение поля «timezone» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> A valid timezone id supported by @see java.time.ZoneId. Optional unless a specific endpoint requires it.</p>
     */
    private String timezone;

    /**

     * <p><strong>RU:</strong> значение поля «locales» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> A list of Locales definied by IETF BCP 47. The ordering is significant. The first locale (leftmost) is used for sort and query localization, whereas the remaining locales are used for query only.. Optional unless a specific endpoint requires it.</p>

     */

    private List<String> locales;

    /**
     * RU: Создаёт экземпляр RequestLocalization.
     * EN: Creates a RequestLocalization instance.
     */
    public RequestLocalization() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «timezone» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns A valid timezone id supported by @see java.time.ZoneId.</p>
     *
     * @return RU: текущее значение timezone. EN: current value of timezone.
     */

    public String getTimezone() {
        return timezone;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «timezone» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets A valid timezone id supported by @see java.time.ZoneId.</p>
     *
     * @param timezone RU: новое значение timezone. EN: new value for timezone.
     */

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «locales» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns A list of Locales definied by IETF BCP 47. The ordering is significant. The first locale (leftmost) is used for sort and query localization, whereas the remaining locales are used for query only..</p>
     *
     * @return RU: текущее значение locales. EN: current value of locales.
     */

    public List<String> getLocales() {
        return locales;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «locales» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets A list of Locales definied by IETF BCP 47. The ordering is significant. The first locale (leftmost) is used for sort and query localization, whereas the remaining locales are used for query only..</p>
     *
     * @param locales RU: новое значение locales. EN: new value for locales.
     */

    public void setLocales(List<String> locales) {
        this.locales = locales;
    }

}
