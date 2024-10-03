package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor js;
    Actions actions ;
    public BasePage(WebDriver driver){
        this.actions= new Actions(driver);
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//img[@title='Your Store']")
    WebElement homePageElement;

    @FindBy(className= "breadcrumb")
    WebElement breadcrumbsElement;

    @FindBy(tagName= "h1")
    WebElement pageHeadingElement;


    /**
     Actions Methods
     **/
    public void navigateToHomePage(){
        homePageElement.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='common-home']")));
    }
    public String getPageTitle(){
        return driver.getTitle();
    }
    public boolean is_MandatoryFields(WebElement element){
        String beforeContent = (String) js.executeScript(
                "return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", element);
        String beforeColor = (String) js.executeScript(
                "return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", element);
        if (beforeContent == null || beforeColor == null) {
            return false;
        }
        if (beforeContent.equals("none") || beforeContent.trim().isEmpty() || beforeContent.equals("\"\"")) {
            return false;
        }
        return beforeContent.contains("*") &&
                (beforeColor.equals("rgb(255, 0, 0)") || beforeColor.equals("rgba(255, 0, 0, 1)"));
    }

    public String getPageSource(){
        return driver.getPageSource();
    }

    public String getRandomNumber(){
        int number=10000+new Random().nextInt(90000);
        return Integer.toString(number);
    }

    public String getRandomString(){
        int length=6;
        StringBuilder randomString=new StringBuilder();
        String alphabets="qwertyuioplkjhgfdsazxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM";
        for (int i=0;i<length;i++){
            int index=new Random().nextInt(alphabets.length());
            char letter=alphabets.charAt(index);
            randomString.append(letter);
        }
        return randomString.toString();
    }

    public String getBreadcrumbs(){
        return breadcrumbsElement.getText().trim();
    }

    public String getPageHeading(){
        try {
            return pageHeadingElement.getText().trim();
        }catch (Exception e){
            return "No headLine!";
        }
    }

    public void navigateToBack(){
        driver.navigate().back();
    }
}
