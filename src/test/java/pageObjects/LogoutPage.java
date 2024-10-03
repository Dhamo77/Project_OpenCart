package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LogoutPage extends AllRightColumnOptions{


    public enum MyAccount {
        MY_ACCOUNT("My Account"),ORDER_HISTORY("Order History"),
        TRANSACTIONS("Transactions"),DOWNLOADS("Downloads"),LOGOUT("Logout");
        private final String text;
        MyAccount(String text) {
            this.text=text;
        }
        public String getVisibleText() {
            return text;
        }
    }

    @FindBy(xpath = "(//*[@class='d-none d-md-inline'])[3]")
    WebElement  myAccountElement;
    @FindBy(xpath = "//*[contains(@class,'dropdown-menu dropdown-menu-right')]/li")
    List<WebElement> myAccountDropDown;
    public LogoutPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[text()='Continue']")
    private WebElement continueButton;

    /**
     * Action Methods
     */

    public void navigateToHomePage(){
        js.executeScript("arguments[0].scrollIntoView(true);", continueButton);
        wait.until(ExpectedConditions.visibilityOf(continueButton));
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='common-home']")));
    }
    public void setMyAccount(MyAccount type) {
        try {
            wait.until(ExpectedConditions.visibilityOf(myAccountElement));
            wait.until(ExpectedConditions.elementToBeClickable(myAccountElement));
            myAccountElement.click();
            boolean found = false;
            wait.until(ExpectedConditions.visibilityOfAllElements(myAccountDropDown));
            for (WebElement option : myAccountDropDown) {
                if (type.getVisibleText().equals(option.getText())) {
                    wait.until(ExpectedConditions.elementToBeClickable(option));
                    option.click();
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new NoSuchElementException("Logout option is not available in the dropdown.");
            }
        } catch (NoSuchElementException e) {
            throw e;
        }
    }
}
