package testCases.TS_002;

import BaseClasses.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageObjects.HeaderPage;
import pageObjects.HomePageEnums;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import utilites.DataProviderClass;


public class TS_002_Set1 extends BaseClass {


    /**
     * Validate logging into the Application using valid credentials
     */
    @Test(dataProvider = "Login data1",dataProviderClass = DataProviderClass.class)
    public void TS_LI_001(String email,String password){
        new HeaderPage(driver).setMyAccount(HomePageEnums.MyAccount.LOGIN);
        LoginPage loginPage=new LoginPage(driver);
        loginPage.validLoginDetails(email,password);

        String expected ="My Account";
        String actual =loginPage.getPageTitle();
        Assert.assertEquals(actual,expected);
    }
    @AfterMethod
    void logout(){
        new LogoutPage(driver).setMyAccount(LogoutPage.MyAccount.LOGOUT);
    }
}
