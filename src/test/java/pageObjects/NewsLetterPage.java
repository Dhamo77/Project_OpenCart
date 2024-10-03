package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsLetterPage extends AllRightColumnOptions{
    public NewsLetterPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "input-newsletter")
    private WebElement subscriptionButton;

    public boolean subscriptionButton_isEnable(){
        return subscriptionButton.isEnabled();
    }
}
