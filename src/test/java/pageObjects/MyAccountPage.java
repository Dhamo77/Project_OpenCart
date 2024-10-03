package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountPage extends AllRightColumnOptions{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[contains(text(),'Subscribe / unsubscribe to newsletter')]")
    private WebElement newsLetterElement;
    @FindBy(xpath = "//*[text()='Edit your account information']")
    private WebElement accountInformationElement;
    public void navigateToNewsLetterPage(){
        wait.until(ExpectedConditions.visibilityOf(newsLetterElement));
        wait.until(ExpectedConditions.elementToBeClickable(newsLetterElement));
        js.executeScript("arguments[0].click();",newsLetterElement);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Newsletter Subscription']")));
    }
    public void navigateToEditAccountInformation(){
        accountInformationElement.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='My Account Information']")));
    }
}
