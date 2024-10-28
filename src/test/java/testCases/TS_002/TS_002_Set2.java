package testCases.TS_002;

import BaseClasses.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HeaderPage;
import pageObjects.HomePageEnums;
import pageObjects.LoginPage;
import utilites.DataProviderClass;

public class TS_002_Set2 extends BaseClass {
    /**
     * Validate logging into the Application using invalid credentials
     */
    @Test(dataProvider = "Login data2",dataProviderClass = DataProviderClass.class)
    public void TS_LI_002(String email,String password){
        new HeaderPage(driver).setMyAccount(HomePageEnums.MyAccount.LOGIN);
        LoginPage loginPage=new LoginPage(driver);
        loginPage.setLoginDetails(email,password);

        String expected ="Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(loginPage.getWarningMessage(),expected);
    }
}
