package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * RU: DTO-модель Alfresco REST API: Company.
 * EN: Alfresco REST API DTO model: Company.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Company {
    /**
     * <p><strong>RU:</strong> значение поля «organization» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Value of the organization field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>
     */
    private String organization;

    /**

     * <p><strong>RU:</strong> значение поля «address1» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the address1 field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String address1;

    /**

     * <p><strong>RU:</strong> значение поля «address2» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the address2 field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String address2;

    /**

     * <p><strong>RU:</strong> значение поля «address3» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the address3 field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String address3;

    /**

     * <p><strong>RU:</strong> значение поля «postcode» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the postcode field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String postcode;

    /**

     * <p><strong>RU:</strong> значение поля «telephone» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the telephone field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String telephone;

    /**

     * <p><strong>RU:</strong> значение поля «fax» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the fax field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String fax;

    /**

     * <p><strong>RU:</strong> значение поля «email» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the email field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String email;

    /**
     * RU: Создаёт экземпляр Company.
     * EN: Creates a Company instance.
     */
    public Company() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «organization» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the organization field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение organization. EN: current value of organization.
     */

    public String getOrganization() {
        return organization;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «organization» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the organization field in the Alfresco REST API model.</p>
     *
     * @param organization RU: новое значение organization. EN: new value for organization.
     */

    public void setOrganization(String organization) {
        this.organization = organization;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «address1» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the address1 field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение address1. EN: current value of address1.
     */

    public String getAddress1() {
        return address1;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «address1» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the address1 field in the Alfresco REST API model.</p>
     *
     * @param address1 RU: новое значение address1. EN: new value for address1.
     */

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «address2» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the address2 field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение address2. EN: current value of address2.
     */

    public String getAddress2() {
        return address2;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «address2» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the address2 field in the Alfresco REST API model.</p>
     *
     * @param address2 RU: новое значение address2. EN: new value for address2.
     */

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «address3» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the address3 field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение address3. EN: current value of address3.
     */

    public String getAddress3() {
        return address3;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «address3» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the address3 field in the Alfresco REST API model.</p>
     *
     * @param address3 RU: новое значение address3. EN: new value for address3.
     */

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «postcode» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the postcode field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение postcode. EN: current value of postcode.
     */

    public String getPostcode() {
        return postcode;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «postcode» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the postcode field in the Alfresco REST API model.</p>
     *
     * @param postcode RU: новое значение postcode. EN: new value for postcode.
     */

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «telephone» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the telephone field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение telephone. EN: current value of telephone.
     */

    public String getTelephone() {
        return telephone;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «telephone» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the telephone field in the Alfresco REST API model.</p>
     *
     * @param telephone RU: новое значение telephone. EN: new value for telephone.
     */

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «fax» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the fax field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение fax. EN: current value of fax.
     */

    public String getFax() {
        return fax;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «fax» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the fax field in the Alfresco REST API model.</p>
     *
     * @param fax RU: новое значение fax. EN: new value for fax.
     */

    public void setFax(String fax) {
        this.fax = fax;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «email» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the email field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение email. EN: current value of email.
     */

    public String getEmail() {
        return email;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «email» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the email field in the Alfresco REST API model.</p>
     *
     * @param email RU: новое значение email. EN: new value for email.
     */

    public void setEmail(String email) {
        this.email = email;
    }

}
