package pro.abgrid.alfresco.dto.discovery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;

/**
 * RU: DTO-модель Alfresco REST API: LicenseInfo.
 * EN: Alfresco REST API DTO model: LicenseInfo.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LicenseInfo {
    /**
     * <p><strong>RU:</strong> значение поля «issued at» модели Alfresco REST API. Обязательное поле Swagger schema.</p>
     * <p><strong>EN:</strong> Value of the issued at field in the Alfresco REST API model. Required by the Swagger schema.</p>
     */
    private OffsetDateTime issuedAt;

    /**

     * <p><strong>RU:</strong> значение поля «expires at» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the expires at field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private OffsetDateTime expiresAt;

    /**

     * <p><strong>RU:</strong> значение поля «remaining days» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the remaining days field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private Integer remainingDays;

    /**

     * <p><strong>RU:</strong> значение поля «holder» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the holder field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private String holder;

    /**

     * <p><strong>RU:</strong> значение поля «mode» модели Alfresco REST API. Обязательное поле Swagger schema.</p>

     * <p><strong>EN:</strong> Value of the mode field in the Alfresco REST API model. Required by the Swagger schema.</p>

     */

    private String mode;

    /**

     * <p><strong>RU:</strong> значение поля «entitlements» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the entitlements field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private EntitlementsInfo entitlements;

    /**
     * RU: Создаёт экземпляр LicenseInfo.
     * EN: Creates a LicenseInfo instance.
     */
    public LicenseInfo() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «issued at» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the issued at field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение issuedAt. EN: current value of issuedAt.
     */

    public OffsetDateTime getIssuedAt() {
        return issuedAt;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «issued at» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the issued at field in the Alfresco REST API model.</p>
     *
     * @param issuedAt RU: новое значение issuedAt. EN: new value for issuedAt.
     */

    public void setIssuedAt(OffsetDateTime issuedAt) {
        this.issuedAt = issuedAt;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «expires at» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the expires at field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение expiresAt. EN: current value of expiresAt.
     */

    public OffsetDateTime getExpiresAt() {
        return expiresAt;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «expires at» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the expires at field in the Alfresco REST API model.</p>
     *
     * @param expiresAt RU: новое значение expiresAt. EN: new value for expiresAt.
     */

    public void setExpiresAt(OffsetDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «remaining days» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the remaining days field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение remainingDays. EN: current value of remainingDays.
     */

    public Integer getRemainingDays() {
        return remainingDays;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «remaining days» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the remaining days field in the Alfresco REST API model.</p>
     *
     * @param remainingDays RU: новое значение remainingDays. EN: new value for remainingDays.
     */

    public void setRemainingDays(Integer remainingDays) {
        this.remainingDays = remainingDays;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «holder» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the holder field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение holder. EN: current value of holder.
     */

    public String getHolder() {
        return holder;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «holder» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the holder field in the Alfresco REST API model.</p>
     *
     * @param holder RU: новое значение holder. EN: new value for holder.
     */

    public void setHolder(String holder) {
        this.holder = holder;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «mode» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the mode field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение mode. EN: current value of mode.
     */

    public String getMode() {
        return mode;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «mode» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the mode field in the Alfresco REST API model.</p>
     *
     * @param mode RU: новое значение mode. EN: new value for mode.
     */

    public void setMode(String mode) {
        this.mode = mode;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «entitlements» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the entitlements field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение entitlements. EN: current value of entitlements.
     */

    public EntitlementsInfo getEntitlements() {
        return entitlements;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «entitlements» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the entitlements field in the Alfresco REST API model.</p>
     *
     * @param entitlements RU: новое значение entitlements. EN: new value for entitlements.
     */

    public void setEntitlements(EntitlementsInfo entitlements) {
        this.entitlements = entitlements;
    }

}
