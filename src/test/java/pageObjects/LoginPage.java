package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import static java.awt.Toolkit.getDefaultToolkit;

public class LoginPage extends AllRightColumnOptions {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#input-email")
    private WebElement emailBox;
    @FindBy(css = "#input-password")
    private WebElement passwordBox;
    @FindBy(xpath = "//*[@id='form-login']//*[@class='btn btn-primary']")
    private WebElement loginButton;
    @FindBy(xpath = "(//*[@href='https://demo.opencart.com/en-gb?route=account/forgotten'])[1]")
    private WebElement forgottenPasswordLink;
    @FindBy(xpath = "//*[@class='alert alert-danger alert-dismissible']")
    private WebElement warningMessage;
    @FindBy(xpath = "(//*[@class='btn btn-primary'])[1]")
    private WebElement newCustomerLink;

    @FindBy(xpath = "//*[@for='input-email']")
    private WebElement mandatoryEmailSymbol;
    @FindBy(xpath = "//*[@for='input-password']")
    private WebElement mandatoryPasswordSymbol;

    /**
     Action methods
     **/
    public void setEmailId(String email){
        emailBox.sendKeys(email);
    }
    public void setPassword(String password){
        passwordBox.sendKeys(password);
    }

    /**
     * TODO
     */
    public void clickLoginButton(){
        js.executeScript("arguments[0].click();", loginButton);
    }

    public void clickForgottenPasswordLink(){
        forgottenPasswordLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Forgot Your Password?']")));
    }
    public String getWarningMessage(){
        wait.until(ExpectedConditions.visibilityOf(warningMessage));
        return warningMessage.getText();
    }
    public void navigateToRegistrationPage(){
        newCustomerLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Register Account']")));
    }

    public void setLoginDetails(String email,String password){
        setEmailId(email);
        setPassword(password);
        clickLoginButton();
    }
    public void validLoginDetails(String email,String password){
        setEmailId(email);
        setPassword(password);
        clickLoginButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='My Account']")));
    }
    public String  getEmailPlaceholder(){
        return emailBox.getAttribute("placeholder");
    }
    public String  getPasswordPlaceholder(){
        return passwordBox.getAttribute("placeholder");
    }

    public String  getPasswordType(){
        return passwordBox.getAttribute("type");
    }

    public void byKeyBoardActions(String email,String password)  {
        actions.sendKeys(emailBox,email).sendKeys(Keys.TAB).perform();
        actions.sendKeys(passwordBox,password).sendKeys(Keys.ENTER).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='My Account']")));
    }

    public boolean isEmailHaveMandatorySymbol(){
        return is_MandatoryFields(mandatoryEmailSymbol);
    }
    public boolean isPasswordHaveMandatorySymbol(){
        return is_MandatoryFields(mandatoryPasswordSymbol);
    }
    public String getCopiedPassword(){
        actions.moveToElement(passwordBox).click().doubleClick().keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        return getClipboardContents();
    }
    private static String getClipboardContents() {
        String result = "";
        try {
            Clipboard clipboard = getDefaultToolkit().getSystemClipboard();
            Transferable contents = clipboard.getContents(null);
            if (contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                result = (String) contents.getTransferData(DataFlavor.stringFlavor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
