package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//img[@title='Your Store']")
    WebElement homePageElement;

    /**
     Actions Methods
     **/
    public void navigateToHomePage(){
        homePageElement.click();
    }
    public String getPageTitle(){
       return driver.getTitle();
    }
}
