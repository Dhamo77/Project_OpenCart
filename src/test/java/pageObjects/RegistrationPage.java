package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends AllRightColumnOptions {
    public RegistrationPage(WebDriver driver){
        super(driver);
    }

    public enum PrivacyPolicyOption {
        ENABLED, DISABLED
    }
    public enum NewsletterOption {
        SUBSCRIBED, UNSUBSCRIBED
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
    private WebElement submit_button;
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
    @FindBy(xpath = "//*[@id='error-password']")
    private WebElement password_error_message;
    @FindBy(xpath ="//*[@class='alert alert-danger alert-dismissible']")
    private WebElement privacyPolicy_warning_message;
    @FindBy(xpath = "//p/a[contains(@href,'login')]")
    private WebElement loginPageLink;

    @FindBy(xpath = "//*[@for='input-firstname']")
    private WebElement mandatoryFirstName;
    @FindBy(xpath = "//*[@for='input-lastname']")
    private WebElement mandatoryEmail;
    @FindBy(xpath = "//*[@for='input-email']")
    private WebElement mandatoryLastName;
    @FindBy(xpath = "//*[@for='input-password']")
    private WebElement mandatoryPassword;

//    @FindBy(xpath = "//b[text()='Privacy Policy']")
//    private WebElement privacyPolicyPage;


    @FindBy(xpath = "//*[text()='Forgotten Password']")
    private WebElement forgetPasswordLink;
    @FindBy(xpath = "//a[text()='Continue']")
    private WebElement successAccountCreatedPageButton;

    /**
     Actions Methods
     **/

    public void setFirstName(String firstname){
        first_name_box.clear();
        first_name_box.sendKeys(firstname);
    }
    public void setLastName(String lastname){
        last_name_box.clear();
        last_name_box.sendKeys(lastname);
    }
    public void setEmail(String email){
        email_box.clear();
        email_box.sendKeys(email);
    }
    public void setPassWord(String passWord){
        password_box.clear();
        password_box.sendKeys(passWord);
    }
    public void enableNewsletter(){
        js.executeScript("arguments[0].click();", newsletter_button);
    }
    public void clickSubmitButton(){
        js.executeScript("arguments[0].click();", submit_button);
    }
    public void enablePrivacyPolicy(){
        js.executeScript("arguments[0].click();", privacy_Policy_button);
    }
    public String getFirstNameErrorMessage(){
        wait.until(ExpectedConditions.visibilityOf(firstName_error_message));
        return firstName_error_message.getText();
    }
    public String getLastNameErrorMessage(){
        wait.until(ExpectedConditions.visibilityOf(lastName_error_message));
        return lastName_error_message.getText();
    }
    public String getEmailErrorMessage(){
        wait.until(ExpectedConditions.visibilityOf(email_error_message));
        return email_error_message.getText();
    }
    public String getPasswordErrorMessage(){
        wait.until(ExpectedConditions.visibilityOf(password_error_message));
        return password_error_message.getText();
    }
    public String getPrivacyPolicyWarningMessage(){
        wait.until(ExpectedConditions.visibilityOf(privacyPolicy_warning_message));
        return privacyPolicy_warning_message.getText();
    }
    public void navigateToLoginPage(){
        loginPageLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='account-login']")));
    }
    public String getEmailValidationMessage(){
        wait.until(ExpectedConditions.visibilityOf(email_box));
        return email_box.getAttribute("validationMessage");
    }
    public void registerAccountByKeyBoardAction(String firstName, String lastName, String email, String password) {
        privacy_Policy_button.click();
        actions.sendKeys(first_name_box, firstName).sendKeys(Keys.TAB).perform();
        actions.sendKeys(last_name_box, lastName).sendKeys(Keys.TAB).perform();
        actions.sendKeys(email_box, email).sendKeys(Keys.TAB).perform();
        actions.sendKeys(password_box, password).sendKeys(Keys.ENTER).perform();;
    }

    public String getFirstNamePlaceholder() {
        return first_name_box.getAttribute("placeholder");
    }

    public String getLastNamePlaceholder() {
        return last_name_box.getAttribute("placeholder");
    }

    public String getEmailPlaceholder() {
        return email_box.getAttribute("placeholder");
    }

    public String getPasswordPlaceholder() {
        return password_box.getAttribute("placeholder");
    }
    public boolean isEnable_PrivacyPolicy(){
        return privacy_Policy_button.isSelected();
    }
    public boolean isPasswordIsHidden(){
        String actual=password_box.getAttribute("type");
        return actual.equals("password");
    }
    public boolean isMandatoryFirstName(){
        return is_MandatoryFields(mandatoryFirstName);
    }
    public boolean isMandatoryLastName(){
        return is_MandatoryFields(mandatoryLastName);
    }
    public boolean isMandatoryEmail(){
        return is_MandatoryFields(mandatoryEmail);
    }
    public boolean isMandatoryPassword(){
        return is_MandatoryFields(mandatoryPassword);
    }
    public void accountRegister(String email,String  firstName,String lastName,String password,PrivacyPolicyOption privacyButton,NewsletterOption newsLetterButton){
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPassWord(password);
        if (privacyButton == PrivacyPolicyOption.ENABLED) {
            enablePrivacyPolicy();
        }
        if (newsLetterButton == NewsletterOption.SUBSCRIBED) {
            enableNewsletter();
        }
        clickSubmitButton();
    }
    public  String getAttributeValue(String attribute){
        return first_name_box.getAttribute(attribute);
    }
    public void successAccountCreatedPage(){
        wait.until(ExpectedConditions.visibilityOf(successAccountCreatedPageButton));
        wait.until(ExpectedConditions.elementToBeClickable(successAccountCreatedPageButton));
        successAccountCreatedPageButton.click();
    }
   /* public void navigateToPrivacyPolicyPage(){
        wait.until(ExpectedConditions.visibilityOf(privacyPolicyPage));
        wait.until(ExpectedConditions.elementToBeClickable(privacyPolicyPage));
        js.executeScript("arguments[0].click();",privacyPolicyPage);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
    }*/

    public void navigateToForgetPasswordPage() {
        wait.until(ExpectedConditions.visibilityOf(forgetPasswordLink));
        wait.until(ExpectedConditions.elementToBeClickable(forgetPasswordLink));
        js.executeScript("arguments[0].click();", forgetPasswordLink);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Forgot Your Password?']")));
    }

}
