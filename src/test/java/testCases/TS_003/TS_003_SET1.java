package testCases.TS_003;

import BaseClasses.BaseClass;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HeaderPage;
import pageObjects.HomePageEnums;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;

public class TS_003_SET1 extends BaseClass {

    /**
     * Validate Logging out by selecting Logout option from 'My Account' dropMenu
     */

    @Test
    public  void TC_LO_001(){
        new HeaderPage(driver).setMyAccount(HomePageEnums.MyAccount.LOGIN);
        LoginPage loginPage=new LoginPage(driver);
        loginPage.setLoginDetails(properties.getProperty("email"), properties.getProperty("password"));
        LogoutPage logoutPage=new LogoutPage(driver);
        logoutPage.setMyAccount(LogoutPage.MyAccount.LOGOUT);
        logoutPage.navigateToHomePage();

        String expected="Your Store";
        Assert.assertEquals(expected,logoutPage.getPageTitle());
    }

    /**
     * Validate Logging out by selecting Logout option from 'Right Column' options
     */

    @Test
    public  void TC_LO_002(){
        new HeaderPage(driver).setMyAccount(HomePageEnums.MyAccount.LOGIN);
        LoginPage loginPage=new LoginPage(driver);
        loginPage.setLoginDetails(properties.getProperty("email"), properties.getProperty("password"));
        LogoutPage logoutPage=new LogoutPage(driver);
        loginPage.navigateToLogoutPage();

        String expected="Account Logout";
        Assert.assertEquals(expected,logoutPage.getPageTitle());
    }


    /**
     * Validate logging out and browsing back
     */
    @Test
    public  void TC_LO_003(){
        new HeaderPage(driver).setMyAccount(HomePageEnums.MyAccount.LOGIN);
        LoginPage loginPage=new LoginPage(driver);
        loginPage.setLoginDetails(properties.getProperty("email"), properties.getProperty("password"));
        LogoutPage logoutPage=new LogoutPage(driver);
        logoutPage.setMyAccount(LogoutPage.MyAccount.LOGOUT);
        logoutPage.navigateToBack();

        String expected="Account Login";
        Assert.assertEquals(logoutPage.getPageTitle(),expected);
    }

    /**
     * Validate Logout option is not displayed under 'My Account' menu before logging in
     */
    @Test(expectedExceptions = NoSuchElementException.class)
    public  void TC_LO_004(){
        LogoutPage logoutPage= new LogoutPage(driver);
        logoutPage.setMyAccount(LogoutPage.MyAccount.LOGOUT);
    }

    /**
     * Validate Logout option is not displayed under 'Right Column' options before logging in
     */
    @Test(expectedExceptions = NoSuchElementException.class)
    public  void TC_LO_005(){
        new HeaderPage(driver).setMyAccount(HomePageEnums.MyAccount.LOGIN);
        LoginPage loginPage=new LoginPage(driver);

        loginPage.navigateToLogoutPage();
        Assert.fail();
    }

    /**
     * Validate logging out and login in immediately after logout
     */
    @Test
    public  void TC_LO_006(){
        new HeaderPage(driver).setMyAccount(HomePageEnums.MyAccount.LOGIN);
        LoginPage loginPage=new LoginPage(driver);
        loginPage.setLoginDetails(properties.getProperty("email"), properties.getProperty("password"));
        LogoutPage logoutPage=new LogoutPage(driver);
        logoutPage.setMyAccount(LogoutPage.MyAccount.LOGOUT);
        new HeaderPage(driver).setMyAccount(HomePageEnums.MyAccount.LOGIN);
        loginPage=new LoginPage(driver);
        loginPage.setLoginDetails(properties.getProperty("email"), properties.getProperty("password"));

        String expected="My Account";
        Assert.assertEquals(logoutPage.getPageTitle(),expected);
    }

    /**
     * Validate 'Account Logout' page
     */
    @Test
    public  void TC_LO_007(){
        new HeaderPage(driver).setMyAccount(HomePageEnums.MyAccount.LOGIN);
        LoginPage loginPage=new LoginPage(driver);
        loginPage.setLoginDetails(properties.getProperty("email"), properties.getProperty("password"));
        LogoutPage logoutPage=new LogoutPage(driver);
        logoutPage.setMyAccount(LogoutPage.MyAccount.LOGOUT);

        String actualBreadcrumb=logoutPage.getBreadcrumbs();
        String expectedBreadcrumb="Account\\nLogout";
        String actualHeading="Account Logout";
        String expectedHeading=logoutPage.getPageHeading();
        softAssert.assertEquals(actualBreadcrumb,expectedBreadcrumb);
        softAssert.assertEquals(actualHeading,expectedHeading);
    }
}
