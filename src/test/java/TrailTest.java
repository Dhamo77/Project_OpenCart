import BaseClasses.BaseClass;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HeaderPage;
import pageObjects.HomePageEnums;
import pageObjects.LoginPage;

public class TrailTest extends BaseClass {

    @Test(expectedExceptions = NoSuchElementException.class)
    public  void TC_LO_004(){
        new HeaderPage(driver).setMyAccount(HomePageEnums.MyAccount.LOGIN);
        LoginPage loginPage=new LoginPage(driver);

        loginPage.navigateToLogoutPage();
        Assert.fail();
    }


}
