package testCases.TS_001;

import BaseClasses.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageObjects.HeaderPage;
import pageObjects.HomePageEnums;
import pageObjects.LogoutPage;
import pageObjects.RegistrationPage;
import utilites.DataProviderClass;

public class TS001Set1 extends BaseClass {

    /**
     *validate Registering an account by providing the new details accounts
     * (valid details)
     */

    @Test(dataProvider = "Registration data1",dataProviderClass = DataProviderClass.class)
    void TC_RF_001(String email,String firstname,String lastname,String password){
        HeaderPage headerPage =new HeaderPage(driver);
        headerPage.setMyAccount(HomePageEnums.MyAccount.REGISTER);
        RegistrationPage registrationPage=new RegistrationPage(driver);
        registrationPage.validAccountRegister(email,firstname,lastname,password, RegistrationPage.PrivacyPolicyOption.ENABLED, RegistrationPage.NewsletterOption.UNSUBSCRIBED);

        String actual=registrationPage.getPageTitle();
        String expected ="Your Account Has Been Created!";
        Assert.assertEquals(actual,expected);
    }
    @AfterMethod
    void logout(){
        new LogoutPage(driver).setMyAccount(LogoutPage.MyAccount.LOGOUT);
    }

}
