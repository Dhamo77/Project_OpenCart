package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ForgotYourPasswordPage extends AllRightColumnOptions{
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
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
    }
    public void clickBackButton(){
        wait.until(ExpectedConditions.elementToBeClickable(backButton));
        backButton.click();
    }
    public String getWarningMessage(){
        wait.until(ExpectedConditions.visibilityOf(warningMessage));
        return warningMessage.getText();
    }
}
