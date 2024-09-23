package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotYourPasswordPage extends BasePage{
    public ForgotYourPasswordPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//*[@placeholder='E-Mail Address']")
    WebElement emailInputBox;
    @FindBy(xpath = "//*[@class='btn btn-primary']")
    WebElement continueButton;
    @FindBy(xpath = "//*[@class='btn btn-light']")
    WebElement backButton;
    @FindBy(xpath = "//*[@class='alert alert-danger alert-dismissible']")
    WebElement warningMessage;

    /**
     Action methods
     **/
    public void enterEmailId(String email){
        emailInputBox.sendKeys(email);
    }
    public void clickContinueButton(){
        continueButton.click();
    }
    public void clickBackButton(){
        backButton.click();
    }
    public String getWarningMessage(){
        return warningMessage.getText();
    }
}
