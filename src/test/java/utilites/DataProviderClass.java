package utilites;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider(name = "Registration data1")
    protected static Object[][] validRegistration(){
        XLUtilities xl=new XLUtilities("D:\\java files\\selinium\\Selenium _intellij_IDE\\OpenCart\\testdata\\OpenCard.Test scenarios.xlsx");
        return xl.getAllData("DD_valid_TS_001_Registration");
    }
    @DataProvider(name = "Registration data2")
    protected static Object[][] invalidRegistration(){
        XLUtilities xl=new XLUtilities("D:\\java files\\selinium\\Selenium _intellij_IDE\\OpenCart\\testdata\\OpenCard.Test scenarios.xlsx");
        return xl.getAllData("DD_invalid_TS_001_Registration");
    }
    @DataProvider(name = "Login data1")
    protected static Object[][] validLogin(){
        XLUtilities xl=new XLUtilities("D:\\java files\\selinium\\Selenium _intellij_IDE\\OpenCart\\testdata\\OpenCard.Test scenarios.xlsx");
        return xl.getAllData("DD_valid_TS002_Login");
    }
    @DataProvider(name = "Login data2")
    protected static Object[][] invalidLogin(){
        XLUtilities xl=new XLUtilities("D:\\java files\\selinium\\Selenium _intellij_IDE\\OpenCart\\testdata\\OpenCard.Test scenarios.xlsx");
        return xl.getAllData("DD_invalid_TS002_Login");
    }

}
