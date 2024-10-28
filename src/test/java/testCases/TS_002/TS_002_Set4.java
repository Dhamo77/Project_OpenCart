package testCases.TS_002;

import BaseClasses.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HeaderPage;
import pageObjects.HomePageEnums;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;

public class TS_002_Set4 extends BaseClass {

    /**
     * Validate 'Forgotten Password' link is available in the Login page and is working
     */
    @Test
    public void TS_LI_011(){
        new HeaderPage(driver).setMyAccount(HomePageEnums.MyAccount.LOGIN);
        LoginPage loginPage=new LoginPage(driver);
        loginPage.clickForgottenPasswordLink();

        String expected="Forgot Your Password?";
        Assert.assertEquals(loginPage.getPageTitle(),expected);
    }

    /**
     * Validate user is able to navigate to different pages from Login page
     */

    @Test
    public void TS_LI_012(){
        new HeaderPage(driver).setMyAccount(HomePageEnums.MyAccount.LOGIN);
        LoginPage loginPage=new LoginPage(driver);
        loginPage.navigateToRegistrationPage();
        String registrationPageTitle= loginPage.getPageTitle();

        Assert.assertEquals("Register Account",registrationPageTitle);
    }

    /**
     * Validate the different ways of navigating to the Login page
     */

    @Test
    public void TS_LI_013(){
        new HeaderPage(driver).setMyAccount(HomePageEnums.MyAccount.LOGIN);
        LoginPage loginPage=new LoginPage(driver);
        String expected ="Account Login";

        softAssert.assertEquals(loginPage.getPageTitle(),expected);

        new HeaderPage(driver).setMyAccount(HomePageEnums.MyAccount.REGISTER);
        RegistrationPage registrationPage=new RegistrationPage(driver);
        registrationPage.navigateToLoginPage();

        softAssert.assertEquals(registrationPage.getPageTitle(),expected);
    }
}
