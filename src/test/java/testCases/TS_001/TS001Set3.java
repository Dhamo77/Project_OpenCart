package testCases.TS_001;

import BaseClasses.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import utilites.XLUtilities;

public class TS001Set3 extends BaseClass {

    /**
     * Validate Registering an Account by providing only the Mandatory fields
     */
    @Test
    void TC_RF_003()  {
        XLUtilities xl=new XLUtilities("D:\\java files\\selinium\\Selenium _intellij_IDE\\OpenCart\\testdata\\OpenCard.Test scenarios.xlsx");
        Object[] data=xl.getRowValues(1,"TS_001_RegistrationData");
        HeaderPage headerPage=new HeaderPage(driver);
        headerPage.setMyAccount(HomePageEnums.MyAccount.REGISTER);
        RegistrationPage registrationPage=new RegistrationPage(driver);
        registrationPage.validAccountRegister((String) data[0],(String) data[1],(String) data[2],(String) data[3], RegistrationPage.PrivacyPolicyOption.ENABLED, RegistrationPage.NewsletterOption.UNSUBSCRIBED);

        String expected ="Your Account Has Been Created!";
        String actual=registrationPage.getPageTitle();
        new LogoutPage(driver).setMyAccount(LogoutPage.MyAccount.LOGOUT);

        Assert.assertEquals(actual,expected);
    }

    /**
     * Validate proper notification messages are displayed for the mandatory fields,
     * when you don't provide any fields in the 'Register Account' page and submit
     */
    @Test
    void TC_RF_004() {
        HeaderPage headerPage=new HeaderPage(driver);
        headerPage.setMyAccount(HomePageEnums.MyAccount.REGISTER);
        RegistrationPage registrationPage=new RegistrationPage(driver);
        registrationPage.setFirstName("");
        registrationPage.setLastName("");
        registrationPage.setEmail("");
        registrationPage.setPassWord("");
        registrationPage.clickSubmitButton();
        String expected1 ="First Name must be between 1 and 32 characters!";
        String expected2 ="Last Name must be between 1 and 32 characters!";
        String expected3 ="E-Mail Address does not appear to be valid!";
        String expected4 ="Password must be between 4 and 20 characters!";
        String expected5 ="Warning: You must agree to the Privacy Policy!";

        softAssert.assertEquals(registrationPage.getFirstNameErrorMessage(),expected1);
        softAssert.assertEquals(registrationPage.getLastNameErrorMessage(),expected2);
        softAssert.assertEquals(registrationPage.getEmailErrorMessage(),expected3);
        softAssert.assertEquals(registrationPage.getPasswordErrorMessage(),expected4);
        softAssert.assertEquals(registrationPage.getPrivacyPolicyWarningMessage(),expected5);
        softAssert.assertAll();
    }

    /**
     * Validate Registering an Account when 'Yes' option is selected for Newsletter field
     */
    @Test
    void TC_RF_005(){
        XLUtilities xl=new XLUtilities("D:\\java files\\selinium\\Selenium _intellij_IDE\\OpenCart\\testdata\\OpenCard.Test scenarios.xlsx");
        Object[] data=xl.getRowValues(2,"TS_001_RegistrationData");
        HeaderPage headerPage=new HeaderPage(driver);
        headerPage.setMyAccount(HomePageEnums.MyAccount.REGISTER);
        RegistrationPage registrationPage=new RegistrationPage(driver);
        registrationPage.validAccountRegister((String) data[0],(String) data[1],(String) data[2],(String) data[3], RegistrationPage.PrivacyPolicyOption.ENABLED, RegistrationPage.NewsletterOption.SUBSCRIBED);

        String expected1 ="Your Account Has Been Created!";
        softAssert.assertEquals(registrationPage.getPageTitle(),expected1);


        new AllRightColumnOptions(driver).navigateToNewsletterPage();
        boolean expected2=new NewsLetterPage(driver).subscriptionButton_isEnable();
        softAssert.assertTrue(expected2);
        new LogoutPage(driver).setMyAccount(LogoutPage.MyAccount.LOGOUT);
        softAssert.assertAll();
    }

    /**
     *Validate Registering an Account when 'NO' option is selected for Newsletter field
     */
    @Test
    void TC_RF_006(){
        XLUtilities xl=new XLUtilities("D:\\java files\\selinium\\Selenium _intellij_IDE\\OpenCart\\testdata\\OpenCard.Test scenarios.xlsx");
        Object[] data=xl.getRowValues(3,"TS_001_RegistrationData");
        HeaderPage headerPage=new HeaderPage(driver);
        headerPage.setMyAccount(HomePageEnums.MyAccount.REGISTER);
        RegistrationPage registrationPage=new RegistrationPage(driver);
        registrationPage.validAccountRegister((String) data[0],(String) data[1],(String) data[2],(String) data[3], RegistrationPage.PrivacyPolicyOption.ENABLED, RegistrationPage.NewsletterOption.UNSUBSCRIBED);

        String expected1 ="Your Account Has Been Created!";
        softAssert.assertEquals(registrationPage.getPageTitle(),expected1);

        new AllRightColumnOptions(driver).navigateToNewsletterPage();
        boolean expected2=new NewsLetterPage(driver).subscriptionButton_isEnable();
        softAssert.assertFalse(expected2);
        new LogoutPage(driver).setMyAccount(LogoutPage.MyAccount.LOGOUT);
        softAssert.assertAll();
    }

    /**
     * Validate different ways of navigating to 'Register Account' page
     */
    @Test
    void TC_RF_007(){
        HeaderPage headerPage=new HeaderPage(driver);
        headerPage.setMyAccount(HomePageEnums.MyAccount.REGISTER);
        RegistrationPage registrationPage=new RegistrationPage(driver);

        String expected1 ="Register Account";
        softAssert.assertEquals(registrationPage.getPageTitle(),expected1);
        headerPage.setMyAccount(HomePageEnums.MyAccount.LOGIN);
        LoginPage loginPage=new LoginPage(driver);
        loginPage.navigateToRegistrationPage();
        softAssert.assertEquals(loginPage.getPageTitle(),expected1);
        softAssert.assertAll();
    }

    /**
     * Validate Registering an Account by providing the existing account details (i.e. existing email address)
     */
    @Test
    void TC_RF_008(){
        XLUtilities xl=new XLUtilities("D:\\java files\\selinium\\Selenium _intellij_IDE\\OpenCart\\testdata\\OpenCard.Test scenarios.xlsx");
        Object[] data=xl.getRowValues(4,"TS_001_RegistrationData");
        HeaderPage headerPage=new HeaderPage(driver);
        headerPage.setMyAccount(HomePageEnums.MyAccount.REGISTER);
        RegistrationPage registrationPage=new RegistrationPage(driver);
        registrationPage.accountRegister((String) data[0],(String) data[1],(String) data[2],(String) data[3], RegistrationPage.PrivacyPolicyOption.ENABLED, RegistrationPage.NewsletterOption.UNSUBSCRIBED);

        String expected ="Warning: E-Mail Address is already registered!";
        Assert.assertEquals(registrationPage.getPrivacyPolicyWarningMessage(),expected);
    }

    /**
     * Validate Registering an Account by providing an invalid email address into the E-Mail field
     */
    @Test
    void TC_RF_009(){
        HeaderPage headerPage=new HeaderPage(driver);
        headerPage.setMyAccount(HomePageEnums.MyAccount.REGISTER);
        RegistrationPage registrationPage=new RegistrationPage(driver);
        registrationPage.setEmail("smith9@");
        registrationPage.clickSubmitButton();
        String expected1=registrationPage.getEmailValidationMessage();
        registrationPage.setEmail("smith9@.");
        registrationPage.clickSubmitButton();
        String expected2=registrationPage.getEmailValidationMessage();
        registrationPage.setEmail("TrailTest@!gmail.com");
        registrationPage.clickSubmitButton();
        String expected3=registrationPage.getEmailValidationMessage();
        registrationPage.setEmail("TrailTest@-gmail.com");
        registrationPage.clickSubmitButton();
        String expected4=registrationPage.getEmailValidationMessage();

        softAssert.assertEquals("Please enter a part following '@'. 'smith9@' is incomplete.",expected1);
        softAssert.assertEquals("'.' is used at a wrong position in '.'.",expected2);
        softAssert.assertEquals("A part following '@' should not contain the symbol '!'.",expected3);
        softAssert.assertEquals("Please enter an email address.",expected4);
        softAssert.assertAll();
    }

    /**
     * Validate Registering an Account by using the Keyboard keys
     */
    @Test
    void TC_RF_010(){
        XLUtilities xl=new XLUtilities("D:\\java files\\selinium\\Selenium _intellij_IDE\\OpenCart\\testdata\\OpenCard.Test scenarios.xlsx");
        Object[] data=xl.getRowValues(5,"TS_001_RegistrationData");
        HeaderPage headerPage=new HeaderPage(driver);
        headerPage.setMyAccount(HomePageEnums.MyAccount.REGISTER);
        RegistrationPage registrationPage=new RegistrationPage(driver);
        registrationPage.registerAccountByKeyBoardAction((String) data[1],(String) data[2],(String) data[0],(String) data[3]);

        String expected1 ="Your Account Has Been Created!";
        String actual=registrationPage.getPageTitle();
        new LogoutPage(driver).setMyAccount(LogoutPage.MyAccount.LOGOUT);

        Assert.assertEquals(actual,expected1);
    }

    /**
     * Validate all the fields in the Register Account page have the proper placeholders
     */
    @Test
    void TC_RF_011(){
        HeaderPage headerPage=new HeaderPage(driver);
        headerPage.setMyAccount(HomePageEnums.MyAccount.REGISTER);
        RegistrationPage registrationPage=new RegistrationPage(driver);
        String firstName=registrationPage.getFirstNamePlaceholder();
        String lastName=registrationPage.getLastNamePlaceholder();
        String emailText=registrationPage.getEmailPlaceholder();
        String passwordText = registrationPage.getPasswordPlaceholder();

        softAssert.assertEquals("First Name",firstName);
        softAssert.assertEquals("Last Name",lastName);
        softAssert.assertEquals("E-Mail",emailText);
        softAssert.assertEquals("Password",passwordText);
        softAssert.assertAll();
    }

    /**
     *Validate all the mandatory fields in the Register Account page are marked with red color '*' symbol
     */
    @Test
    void TC_RF_012(){
        HeaderPage headerPage=new HeaderPage(driver);
        headerPage.setMyAccount(HomePageEnums.MyAccount.REGISTER);
        RegistrationPage registrationPage=new RegistrationPage(driver);

        softAssert.assertTrue(registrationPage.isMandatoryFirstName());
        softAssert.assertTrue(registrationPage.isMandatoryLastName());
        softAssert.assertTrue(registrationPage.isMandatoryEmail());
        softAssert.assertTrue(registrationPage.isMandatoryPassword());
        softAssert.assertAll();
    }



    /**
     * Validate whether the Mandatory fields in the Register Account page are accepting only spaces
     */

    @Test
    void TC_RF_013(){
        HeaderPage headerPage=new HeaderPage(driver);
        headerPage.setMyAccount(HomePageEnums.MyAccount.REGISTER);
        RegistrationPage registrationPage=new RegistrationPage(driver);
        registrationPage.accountRegister("","","","", RegistrationPage.PrivacyPolicyOption.ENABLED, RegistrationPage.NewsletterOption.UNSUBSCRIBED);

        String expected ="My Account";
        Assert.assertNotEquals(registrationPage.getPageTitle(),expected);
    }

    /**
     * Validate whether the leading and trailing spaces entered into the Register Account fields are trimmed
     */
    @Test
    void TC_RF_014(){
        XLUtilities xl=new XLUtilities("D:\\java files\\selinium\\Selenium _intellij_IDE\\OpenCart\\testdata\\OpenCard.Test scenarios.xlsx");
        Object[] data=xl.getRowValues(6,"TS_001_RegistrationData");
        HeaderPage headerPage=new HeaderPage(driver);
        headerPage.setMyAccount(HomePageEnums.MyAccount.REGISTER);
        RegistrationPage registrationPage=new RegistrationPage(driver);
        registrationPage.validAccountRegister((String) data[0],(String) data[1],(String) data[2],(String) data[3], RegistrationPage.PrivacyPolicyOption.ENABLED, RegistrationPage.NewsletterOption.UNSUBSCRIBED);
        registrationPage.successAccountCreatedPage();
        new MyAccountPage(driver).navigateToEditAccountInformation();
        MyAccountInformationPage informationPage=new MyAccountInformationPage(driver);
        String firstName=informationPage.getFirstNameValue();
        String lastName=informationPage.getLastNameValue();
        String email=informationPage.getEmailValue();
        new LogoutPage(driver).setMyAccount(LogoutPage.MyAccount.LOGOUT);

        softAssert.assertEquals("Josh",firstName);
        softAssert.assertEquals("Hazlewood",lastName);
        softAssert.assertEquals("hazle@gmail.com",email);
        softAssert.assertAll();

    }

    /**
     * Validate whether the 'Privacy Policy' checkbox option is not selected by default
     */
    @Test
    void TC_RF_015(){
        new HeaderPage(driver).setMyAccount(HomePageEnums.MyAccount.REGISTER);
        boolean actual=new RegistrationPage(driver).isEnable_PrivacyPolicy();
        Assert.assertFalse(actual);
    }

    /**
     * Validate Registering the Account without selecting the 'Privacy Policy' checkbox option
     */
    @Test
    void TC_RF_016(){
        XLUtilities xl=new XLUtilities("D:\\java files\\selinium\\Selenium _intellij_IDE\\OpenCart\\testdata\\OpenCard.Test scenarios.xlsx");
        Object[] data=xl.getRowValues(5,"TS_001_RegistrationData");
        HeaderPage headerPage=new HeaderPage(driver);
        headerPage.setMyAccount(HomePageEnums.MyAccount.REGISTER);
        RegistrationPage registrationPage=new RegistrationPage(driver);
        registrationPage.accountRegister((String) data[0],(String) data[1],(String) data[2],(String) data[3], RegistrationPage.PrivacyPolicyOption.DISABLED, RegistrationPage.NewsletterOption.UNSUBSCRIBED);

        String expected ="Warning: You must agree to the Privacy Policy!";
        Assert.assertEquals(registrationPage.getPrivacyPolicyWarningMessage(),expected);
    }

    /**
     * Validate the Password text entered into the 'Password' field of 'Register Account' functionality is toggled to hide its visibility
     */
    @Test
    void TC_RF_017(){
        new HeaderPage(driver).setMyAccount(HomePageEnums.MyAccount.REGISTER);
        RegistrationPage registrationPage=new RegistrationPage(driver);

        boolean actual=registrationPage.isPasswordIsHidden();
        Assert.assertTrue(actual);
    }
}
