package pro.abgrid.alfresco.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;

/**
 * RU: DTO-модель Alfresco REST API: PersonBodyUpdate.
 * EN: Alfresco REST API DTO model: PersonBodyUpdate.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonBodyUpdate {
    /**
     * <p><strong>RU:</strong> значение поля «first name» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> Value of the first name field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>
     */
    private String firstName;

    /**

     * <p><strong>RU:</strong> значение поля «last name» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the last name field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String lastName;

    /**

     * <p><strong>RU:</strong> значение поля «description» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the description field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String description;

    /**

     * <p><strong>RU:</strong> значение поля «email» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the email field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String email;

    /**

     * <p><strong>RU:</strong> значение поля «skype id» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the skype id field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String skypeId;

    /**

     * <p><strong>RU:</strong> значение поля «google id» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the google id field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String googleId;

    /**

     * <p><strong>RU:</strong> значение поля «instant message id» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the instant message id field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String instantMessageId;

    /**

     * <p><strong>RU:</strong> значение поля «job title» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the job title field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String jobTitle;

    /**

     * <p><strong>RU:</strong> значение поля «location» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the location field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String location;

    /**

     * <p><strong>RU:</strong> значение поля «company» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the company field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Company company;

    /**

     * <p><strong>RU:</strong> значение поля «mobile» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the mobile field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String mobile;

    /**

     * <p><strong>RU:</strong> значение поля «telephone» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the telephone field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String telephone;

    /**

     * <p><strong>RU:</strong> значение поля «user status» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the user status field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String userStatus;

    /**

     * <p><strong>RU:</strong> значение поля «enabled» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the enabled field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean enabled;

    /**

     * <p><strong>RU:</strong> значение поля «email notifications enabled» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the email notifications enabled field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean emailNotificationsEnabled;

    /**

     * <p><strong>RU:</strong> значение поля «password» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the password field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String password;

    /**

     * <p><strong>RU:</strong> значение поля «old password» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the old password field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private String oldPassword;

    /**

     * <p><strong>RU:</strong> QName аспектов, применённых к узлу. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the aspect names field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private List<String> aspectNames;

    /**

     * <p><strong>RU:</strong> динамические свойства Alfresco, индексированные по QName. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Value of the properties field in the Alfresco REST API model. Optional unless a specific endpoint requires it.</p>

     */

    private Map<String, Object> properties;

    /**
     * RU: Создаёт экземпляр PersonBodyUpdate.
     * EN: Creates a PersonBodyUpdate instance.
     */
    public PersonBodyUpdate() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «first name» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the first name field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение firstName. EN: current value of firstName.
     */

    public String getFirstName() {
        return firstName;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «first name» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the first name field in the Alfresco REST API model.</p>
     *
     * @param firstName RU: новое значение firstName. EN: new value for firstName.
     */

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «last name» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the last name field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение lastName. EN: current value of lastName.
     */

    public String getLastName() {
        return lastName;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «last name» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the last name field in the Alfresco REST API model.</p>
     *
     * @param lastName RU: новое значение lastName. EN: new value for lastName.
     */

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «description» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the description field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение description. EN: current value of description.
     */

    public String getDescription() {
        return description;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «description» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the description field in the Alfresco REST API model.</p>
     *
     * @param description RU: новое значение description. EN: new value for description.
     */

    public void setDescription(String description) {
        this.description = description;
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

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «skype id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the skype id field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение skypeId. EN: current value of skypeId.
     */

    public String getSkypeId() {
        return skypeId;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «skype id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the skype id field in the Alfresco REST API model.</p>
     *
     * @param skypeId RU: новое значение skypeId. EN: new value for skypeId.
     */

    public void setSkypeId(String skypeId) {
        this.skypeId = skypeId;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «google id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the google id field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение googleId. EN: current value of googleId.
     */

    public String getGoogleId() {
        return googleId;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «google id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the google id field in the Alfresco REST API model.</p>
     *
     * @param googleId RU: новое значение googleId. EN: new value for googleId.
     */

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «instant message id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the instant message id field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение instantMessageId. EN: current value of instantMessageId.
     */

    public String getInstantMessageId() {
        return instantMessageId;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «instant message id» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the instant message id field in the Alfresco REST API model.</p>
     *
     * @param instantMessageId RU: новое значение instantMessageId. EN: new value for instantMessageId.
     */

    public void setInstantMessageId(String instantMessageId) {
        this.instantMessageId = instantMessageId;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «job title» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the job title field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение jobTitle. EN: current value of jobTitle.
     */

    public String getJobTitle() {
        return jobTitle;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «job title» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the job title field in the Alfresco REST API model.</p>
     *
     * @param jobTitle RU: новое значение jobTitle. EN: new value for jobTitle.
     */

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «location» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the location field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение location. EN: current value of location.
     */

    public String getLocation() {
        return location;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «location» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the location field in the Alfresco REST API model.</p>
     *
     * @param location RU: новое значение location. EN: new value for location.
     */

    public void setLocation(String location) {
        this.location = location;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «company» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the company field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение company. EN: current value of company.
     */

    public Company getCompany() {
        return company;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «company» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the company field in the Alfresco REST API model.</p>
     *
     * @param company RU: новое значение company. EN: new value for company.
     */

    public void setCompany(Company company) {
        this.company = company;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «mobile» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the mobile field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение mobile. EN: current value of mobile.
     */

    public String getMobile() {
        return mobile;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «mobile» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the mobile field in the Alfresco REST API model.</p>
     *
     * @param mobile RU: новое значение mobile. EN: new value for mobile.
     */

    public void setMobile(String mobile) {
        this.mobile = mobile;
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
     * <p><strong>RU:</strong> Возвращает значение поля «user status» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the user status field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение userStatus. EN: current value of userStatus.
     */

    public String getUserStatus() {
        return userStatus;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «user status» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the user status field in the Alfresco REST API model.</p>
     *
     * @param userStatus RU: новое значение userStatus. EN: new value for userStatus.
     */

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «enabled» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the enabled field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение enabled. EN: current value of enabled.
     */

    public Boolean getEnabled() {
        return enabled;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «enabled» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the enabled field in the Alfresco REST API model.</p>
     *
     * @param enabled RU: новое значение enabled. EN: new value for enabled.
     */

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «email notifications enabled» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the email notifications enabled field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение emailNotificationsEnabled. EN: current value of emailNotificationsEnabled.
     */

    public Boolean getEmailNotificationsEnabled() {
        return emailNotificationsEnabled;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «email notifications enabled» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the email notifications enabled field in the Alfresco REST API model.</p>
     *
     * @param emailNotificationsEnabled RU: новое значение emailNotificationsEnabled. EN: new value for emailNotificationsEnabled.
     */

    public void setEmailNotificationsEnabled(Boolean emailNotificationsEnabled) {
        this.emailNotificationsEnabled = emailNotificationsEnabled;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «password» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the password field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение password. EN: current value of password.
     */

    public String getPassword() {
        return password;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «password» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the password field in the Alfresco REST API model.</p>
     *
     * @param password RU: новое значение password. EN: new value for password.
     */

    public void setPassword(String password) {
        this.password = password;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «old password» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Value of the old password field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение oldPassword. EN: current value of oldPassword.
     */

    public String getOldPassword() {
        return oldPassword;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «old password» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Value of the old password field in the Alfresco REST API model.</p>
     *
     * @param oldPassword RU: новое значение oldPassword. EN: new value for oldPassword.
     */

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

        /**
     * <p><strong>RU:</strong> Возвращает QName аспектов, применённых к узлу.</p>
     * <p><strong>EN:</strong> Returns Value of the aspect names field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение aspectNames. EN: current value of aspectNames.
     */

    public List<String> getAspectNames() {
        return aspectNames;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает QName аспектов, применённых к узлу.</p>
     * <p><strong>EN:</strong> Sets Value of the aspect names field in the Alfresco REST API model.</p>
     *
     * @param aspectNames RU: новое значение aspectNames. EN: new value for aspectNames.
     */

    public void setAspectNames(List<String> aspectNames) {
        this.aspectNames = aspectNames;
    }

        /**
     * <p><strong>RU:</strong> Возвращает динамические свойства Alfresco, индексированные по QName.</p>
     * <p><strong>EN:</strong> Returns Value of the properties field in the Alfresco REST API model.</p>
     *
     * @return RU: текущее значение properties. EN: current value of properties.
     */

    public Map<String, Object> getProperties() {
        return properties;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает динамические свойства Alfresco, индексированные по QName.</p>
     * <p><strong>EN:</strong> Sets Value of the properties field in the Alfresco REST API model.</p>
     *
     * @param properties RU: новое значение properties. EN: new value for properties.
     */

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

}
