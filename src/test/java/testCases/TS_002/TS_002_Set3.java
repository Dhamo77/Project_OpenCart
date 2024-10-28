package testCases.TS_002;

import BaseClasses.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HeaderPage;
import pageObjects.HomePageEnums;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;

public class TS_002_Set3 extends BaseClass {

    /**
     * Validate proper notification messages are displayed for the mandatory fields,
     * when you don't provide any fields in the 'login' page and submit
     */
    @Test
    public void TS_LI_003(){
        new HeaderPage(driver).setMyAccount(HomePageEnums.MyAccount.LOGIN);
        LoginPage loginPage=new LoginPage(driver);
        loginPage.setLoginDetails("","");

        String expected ="Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(loginPage.getWarningMessage(),expected);
    }

    /**
     * Validate Login by using the Keyboard keys
     */
    @Test
    public void TS_LI_004() {
        new HeaderPage(driver).setMyAccount(HomePageEnums.MyAccount.LOGIN);
        LoginPage loginPage=new LoginPage(driver);
        loginPage.byKeyBoardActions(properties.getProperty("email"),properties.getProperty("password"));

        String expected ="My Account";
        String actual =loginPage.getPageTitle();
        new LogoutPage(driver).setMyAccount(LogoutPage.MyAccount.LOGOUT);

        Assert.assertEquals(actual,expected);
    }

    /**
     * Validate all the fields in the Login  page have the proper placeholders
     */

    @Test
    public void TS_LI_005(){
        new HeaderPage(driver).setMyAccount(HomePageEnums.MyAccount.LOGIN);
        LoginPage loginPage=new LoginPage(driver);
        String emailPlaceholder= loginPage.getEmailPlaceholder();
        String passwordPlaceholder= loginPage.getPasswordPlaceholder();

        softAssert.assertEquals(emailPlaceholder,"E-Mail Address");
        softAssert.assertEquals(passwordPlaceholder,"Password");
        softAssert.assertAll();
    }

    /**
     * Validate all the mandatory fields in the Login page are marked with red color * symbol
     */

    @Test
    public void TS_LI_006(){
        new HeaderPage(driver).setMyAccount(HomePageEnums.MyAccount.LOGIN);
        LoginPage loginPage=new LoginPage(driver);

        softAssert.assertTrue(loginPage.isEmailHaveMandatorySymbol());
        softAssert.assertTrue(loginPage.isPasswordHaveMandatorySymbol());
        softAssert.assertAll();
    }

    /**
     * Validate the Password text entered into the 'Password' field of 'Login' functionality is toggled to hide its visibility
     */

    @Test
    public void TS_LI_007(){
        new HeaderPage(driver).setMyAccount(HomePageEnums.MyAccount.LOGIN);
        LoginPage loginPage=new LoginPage(driver);
        String actual= loginPage.getPasswordType();

        Assert.assertEquals(actual,"password");
    }

    /**
     * Validate the Password is not visible in the Page Source
     */

    @Test
    public void TS_LI_008(){
        new HeaderPage(driver).setMyAccount(HomePageEnums.MyAccount.LOGIN);
        LoginPage loginPage=new LoginPage(driver);
        String pageSource=loginPage.getPageSource();
        String  password=loginPage.getRandomNumber();
        loginPage.setPassword(password);

        Assert.assertFalse(pageSource.contains(password));
    }

    /**
     *Validate the copying of the text entered into the Password field
     */

    @Test
    public void TS_LI_009(){
        new HeaderPage(driver).setMyAccount(HomePageEnums.MyAccount.LOGIN);
        LoginPage loginPage=new LoginPage(driver);
        String password=loginPage.getRandomNumber();
        loginPage.setPassword(password);
        String copiedPassword=loginPage.getCopiedPassword();

        Assert.assertNotEquals(copiedPassword,password);
    }

    /**
     * Validate the Breadcrumb, Page Heading, Page URL, Page Title of 'Register Account' Page
     */

    @Test
    public void TS_LI_014(){
        new HeaderPage(driver).setMyAccount(HomePageEnums.MyAccount.LOGIN);
        LoginPage loginPage=new LoginPage(driver);
        String expectedBreadcrumb ="Account\nLogin";
        String actualBreadcrumb =loginPage.getBreadcrumbs();

        String expectedHeading ="Account Login";
        String actualHeading =loginPage.getPageHeading();

        String expectedTitle ="Account Login";
        String actualTitle =loginPage.getPageTitle();
        
        softAssert.assertEquals(actualBreadcrumb,expectedBreadcrumb);
        softAssert.assertEquals(actualHeading,expectedHeading);
        softAssert.assertEquals(actualTitle,expectedTitle);
        softAssert.assertAll();

    }
}
