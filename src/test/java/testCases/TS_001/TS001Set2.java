package testCases.TS_001;

import BaseClasses.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HeaderPage;
import pageObjects.HomePageEnums;
import pageObjects.RegistrationPage;
import utilites.DataProviderClass;

public class TS001Set2 extends BaseClass {

    /**
     *validate Registering an account by providing the new details accounts
     * (invalid details)
     */

    @Test(dataProvider = "Registration data2",dataProviderClass = DataProviderClass.class)
    void TC_RF_002(String email,String firstname,String lastname,String password){
        new HeaderPage(driver).setMyAccount(HomePageEnums.MyAccount.REGISTER);
        RegistrationPage registrationPage=new RegistrationPage(driver);
        registrationPage.accountRegister(email,firstname,lastname,password, RegistrationPage.PrivacyPolicyOption.ENABLED, RegistrationPage.NewsletterOption.UNSUBSCRIBED);

        String actual=registrationPage.getPageTitle();
        String expected ="My Account";
        Assert.assertNotEquals( expected,actual);
    }
}
