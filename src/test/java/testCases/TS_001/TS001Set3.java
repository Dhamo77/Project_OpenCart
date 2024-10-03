package testCases.TS_001;

import BaseClasses.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HeaderPage;
import pageObjects.HomePageEnums;
import pageObjects.RegistrationPage;

public class TS001Set3 extends BaseClass {


    /**
     * Navigation to login page.
     */
    @Test
    public void TC_RF_018_1(){
        new HeaderPage(driver).setMyAccount(HomePageEnums.MyAccount.REGISTER);
        RegistrationPage registrationPage=new RegistrationPage(driver);
        registrationPage.navigateToLoginPage();

        Assert.assertEquals(registrationPage.getPageTitle(),"Account Login");
    }

    /**
     * Navigation to home page.
     */
    @Test
    public void TC_RF_018_2(){
        new HeaderPage(driver).setMyAccount(HomePageEnums.MyAccount.REGISTER);
        RegistrationPage registrationPage=new RegistrationPage(driver);
        registrationPage.navigateToHomePage();

        Assert.assertEquals(registrationPage.getPageTitle(),"Your Store");
    }

    /**
     * Navigation to Forget Password page.
     */
    @Test
    public void TC_RF_018_3(){
        new HeaderPage(driver).setMyAccount(HomePageEnums.MyAccount.REGISTER);
        RegistrationPage registrationPage=new RegistrationPage(driver);
        registrationPage.navigateToForgetPasswordPage();

        Assert.assertEquals(registrationPage.getPageTitle(),"Forgot Your Password?");
    }

}
