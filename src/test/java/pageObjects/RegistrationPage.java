package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver){
        super(driver);
    }

    /**
     Web Elements
     **/
    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement first_name_box;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement last_name_box;
    @FindBy(xpath = "//input[@placeholder='E-Mail']")
    private WebElement email_box;
    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement password_box;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement login_button;
    @FindBy(xpath = "//input[@name='agree']")
    private WebElement privacy_Policy_button;
    @FindBy(id = "input-newsletter")
    private WebElement newsletter_button;
    @FindBy(id = "error-firstname")
    private WebElement firstName_error_message;
    @FindBy(id = "error-lastname")
    private WebElement lastName_error_message;
    @FindBy(id = "error-email")
    private WebElement email_error_message;
    @FindBy(id = "error-password")
    private WebElement password_error_message;
    @FindBy(xpath ="//*[@class='alert alert-danger alert-dismissible']")
    private WebElement privacyPolicy_warning_message;
    @FindBy(xpath = "//p/a[contains(@href,'login')]")
    WebElement loginPageLink;

    /**
     Actions Methods
     **/

    public void enterFirstName(String Firstname){
        first_name_box.sendKeys(Firstname);
    }
    public void enterLastName(String Firstname){
        last_name_box.sendKeys(Firstname);
    }
    public void enterEmail(String email){
        email_box.sendKeys(email);
    }
    public void enterPassWord(String passWord){
        password_box.sendKeys(passWord);
    }
    public void enableNewsletter(){
        newsletter_button.click();
    }
    public void clickLoginButton(){
        login_button.click();
    }
    public void enablePrivacyPolicy(){
        privacy_Policy_button.click();
    }
    public String getFirstNameErrorMessage(){
        return lastName_error_message.getText();
    }
    public String getLastNameErrorMessage(){
        return lastName_error_message.getText();
    }
    public String getEmailErrorMessage(){
        return email_error_message.getText();
    }
    public String getPasswordErrorMessage(){
        return password_error_message.getText();
    }
    public String getPrivacyPolicyWarningMessage(){
        return privacyPolicy_warning_message.getText();
    }
    public void navigateToLoginPage(){
        loginPageLink.click();
    }
    public String getEmailValidationMessage(){
        return email_box.getAttribute("validationMessage");
    }
}
