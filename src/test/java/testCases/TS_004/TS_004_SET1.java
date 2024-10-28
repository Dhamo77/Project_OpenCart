package testCases.TS_004;

import BaseClasses.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HeaderPage;
import pageObjects.HomePageEnums;
import pageObjects.LoginPage;
import pageObjects.ProductSearchPage;

public class TS_004_SET1 extends BaseClass {

    /**
     * Validate navigate to search Page
     */
    @Test
    public void TC_SP_001(){
        HeaderPage headerPage=new HeaderPage(driver);
        headerPage.searchProduct(properties.getProperty("product1"));
        String actual =headerPage.getPageTitle();
        if (actual.equals("Search")) {
            Assert.assertEquals(actual,"Search");
        } else {
            Assert.assertEquals(actual,"Search - "+properties.getProperty("product1"));
        }
    }

    /**
     * Validate the searched text in the main search box and search page Search Criteria box are same.
     */
    @Test
    public void TC_SP_002(){
        HeaderPage headerPage=new HeaderPage(driver);
        headerPage.searchProduct(properties.getProperty("product1"));

        String mainSearchBox=headerPage.getSearchBoxText();
        String searchCriteriaBox = new ProductSearchPage(driver).getSearchCriteriaText();
        Assert.assertEquals(searchCriteriaBox, mainSearchBox);
    }

    /**
     * Validate the searched text is show in the Search head area.
     */
    @Test
    public void TC_SP_003(){
        new HeaderPage(driver).searchProduct(properties.getProperty("product1"));

        String headerText=new ProductSearchPage(driver).getSearcherHeaderText();
        Assert.assertTrue(headerText.contains(properties.getProperty("product1")));
    }

    /**
     * Validate searching with an existing Product Name
     */

    @Test
    public void TC_SP_004(){
        new HeaderPage(driver).searchProduct(properties.getProperty("product2"));
        ProductSearchPage productSearchPage = new ProductSearchPage(driver);

        Assert.assertTrue(productSearchPage.isProductPresent());
    }

    /**
     * Validate searching with an not existing Product Name
     */

    @Test
    public void TC_SP_005(){
        new HeaderPage(driver).searchProduct(properties.getProperty("invalidProduct"));
        ProductSearchPage productSearchPage = new ProductSearchPage(driver);

        String expected="There is no product that matches the search criteria.";
        Assert.assertEquals(productSearchPage.getNoProductMatchesMessage(),expected);
    }

    /**
     * Validate whether the 'Search in subcategories' checkbox option is disable and the default catagorie is 'All Categories' in search page.
     */

    @Test
    public void TC_SP_006(){
        new HeaderPage(driver).searchProduct(properties.getProperty("product1"));
        ProductSearchPage productSearchPage = new ProductSearchPage(driver);

        softAssert.assertFalse(productSearchPage.subCategoriesIsInDefaultSubCategories());
        softAssert.assertEquals(productSearchPage.getTheSelectedCategoriesOption(),"All Categories");
        softAssert.assertAll();
    }

    /**
     *Validate whether the 'Search in product descriptions' checkbox option is not selected by default  in search page.
     */

    @Test
    public void TC_SP_007(){
        new HeaderPage(driver).searchProduct(properties.getProperty("product2"));

        Assert.assertFalse(new ProductSearchPage(driver).searchInProductDefaultDescriptions());
    }

    /**
     * Validate whether the default option in 'Sort By' is Default  in search page.
     */

    @Test
    public void TC_SP_008(){
        new HeaderPage(driver).searchProduct(properties.getProperty("product2"));
        ProductSearchPage productSearchPage = new ProductSearchPage(driver);

        Assert.assertEquals(productSearchPage.getTheSelectedSortByOptionText(),"Default");
    }

    /**
     * Validate whether the default option in 'Show' is 10  in search page.
     */

    @Test
    public void TC_SP_009(){
        new HeaderPage(driver).searchProduct(properties.getProperty("product2"));
        ProductSearchPage productSearchPage = new ProductSearchPage(driver);

        Assert.assertEquals(productSearchPage.getTheSelectedShowPerPageOptionText(),"10");
    }

    /**
     * Validate the navigation to product compare page
     */

    @Test
    public void TC_SP_010(){
        new HeaderPage(driver).searchProduct(properties.getProperty("product2"));
        ProductSearchPage productSearchPage = new ProductSearchPage(driver);
        productSearchPage.navigateToProductComparePage();

        Assert.assertEquals(productSearchPage.getPageTitle(),"Product Comparison");
    }

    /**
     * Validate the product added to the Product Comparison
     */
    @Test
    public void TC_SP_011(){
        String productName= properties.getProperty("product2");
        new HeaderPage(driver).searchProduct(productName);
        ProductSearchPage productSearchPage = new ProductSearchPage(driver);
        productSearchPage.addTheProductToCompare(productName);
        String actual=productSearchPage.getSuccessAlertMessage();

        Assert.assertEquals(actual,"Success: You have added "+productName+" to your product comparison!");
    }

    /**
     * Validate the product added to the Wish List without login or creating the account
     */

    @Test
    public void TC_SP_012_1(){
        String productName= properties.getProperty("product2");
        new HeaderPage(driver).searchProduct(productName);
        ProductSearchPage productSearchPage = new ProductSearchPage(driver);
        productSearchPage.addTheProductToWishList(productName);
        String actual=productSearchPage.getSuccessAlertMessage();

        Assert.assertEquals(actual, "You must login or create an account to save "+productName+" to your wish list!");
    }

    /**
     * Validate the product added to the Wish List before after login
     */

    @Test
    public void TC_SP_012_2(){
        String productName= properties.getProperty("product2");
        new HeaderPage(driver).setMyAccount(HomePageEnums.MyAccount.LOGIN);
        new LoginPage(driver).setLoginDetails(properties.getProperty("email"),properties.getProperty("password"));
        new HeaderPage(driver).searchProduct(productName);
        ProductSearchPage productSearchPage = new ProductSearchPage(driver);
        productSearchPage.addTheProductToWishList(productName);
        String actual=productSearchPage.getSuccessAlertMessage();

        Assert.assertEquals(actual, "Success: You have added "+productName+" to your wish list!");
    }


    /**
     * Validate the product added to the shopping cart.
     */
    @Test
    public void TC_SP_013(){
        String productName= properties.getProperty("product2");
        new HeaderPage(driver).searchProduct(productName);
        ProductSearchPage productSearchPage = new ProductSearchPage(driver);
        productSearchPage.addTheProductToCard(productName);
        String actual=productSearchPage.getSuccessAlertMessage();

        Assert.assertEquals(actual, "Success: You have added "+productName+" to your shopping cart!");
    }

    /**
     * Validate all the fields in the Search functionality and Search page have placeholders
     */

    @Test
    public void TC_SP_014(){
        String productName= properties.getProperty("product2");
        new HeaderPage(driver).searchProduct(productName);
        ProductSearchPage productSearchPage = new ProductSearchPage(driver);
        String mainSearchBoxPlaceHolder=productSearchPage.getMainSearchBoxPlaceHolder();
        String searchCriteriaPlaceHolder=productSearchPage.getSearchCriteriaPlaceHolder();

        softAssert.assertEquals(mainSearchBoxPlaceHolder,"Search");
        softAssert.assertEquals(searchCriteriaPlaceHolder,"Keywords");
        softAssert.assertAll();
    }

    /**
     * Validate searching using 'Search Criteria' field
     */

    @Test
    public void TC_SP_015(){
        String productName= properties.getProperty("product2");
        new HeaderPage(driver).searchProduct("");
        ProductSearchPage productSearchPage = new ProductSearchPage(driver);
        productSearchPage.setTextToSearchBox(productName);
        productSearchPage.enterSearchButton();

        Assert.assertTrue(productSearchPage.isProductPresent());
    }

    /**
     * Validation navigation to the existing product page
     */

    @Test
    public void TC_SP_016(){
        String productName= properties.getProperty("product2");
        new HeaderPage(driver).searchProduct(productName);
        ProductSearchPage productSearchPage = new ProductSearchPage(driver);
        productSearchPage.navigationToProductPage(productName);

        String actual="iMac";
        Assert.assertEquals(productSearchPage.getPageTitle(),actual);
    }

    //    @Test
//    public void TC_SP_017(){
//
//    }

    /**
     * Validate working of selecting the category drop down
     */
    @Test
    public void TC_SP_018(){
        String productName= properties.getProperty("product2");
        new HeaderPage(driver).searchProduct(productName);
        ProductSearchPage productSearchPage = new ProductSearchPage(driver);

        productSearchPage.selectCategories(ProductSearchPage.AllCategories.DESKTOPS);
        String expected1=productSearchPage.getTheSelectedCategoriesOption();
        productSearchPage.selectCategories(ProductSearchPage.AllCategories.LAPTOPS_NOTEBOOKS);
        String expected2=productSearchPage.getTheSelectedCategoriesOption();
        productSearchPage.selectCategories(ProductSearchPage.AllCategories.MP3PLAYERS);
        String expected3=productSearchPage.getTheSelectedCategoriesOption();
        productSearchPage.selectCategories(ProductSearchPage.AllCategories.PRINTERS);
        String expected4=productSearchPage.getTheSelectedCategoriesOption().trim();

        softAssert.assertEquals(expected1,"Desktops");
        softAssert.assertEquals(expected2,"Laptops & Notebooks");
        softAssert.assertEquals(expected3,"MP3 Players");
        softAssert.assertEquals(expected4,"Printers");
        softAssert.assertAll();
    }

    /**
     * Validate List and Grid views when  multiple Products are displayed in the search results
     */
    @Test
    public void TC_SP_019(){
        String productName= properties.getProperty("product1");
        new HeaderPage(driver).searchProduct(productName);
        ProductSearchPage productSearchPage = new ProductSearchPage(driver);
        productSearchPage.changeTheProductViewToList();
        boolean listType=productSearchPage.isListTypeSelected();
        productSearchPage.changeTheProductViewToGrid();
        boolean gridType=productSearchPage.isGridTypeSelected();

        softAssert.assertTrue(listType);
        softAssert.assertTrue(gridType);
        softAssert.assertAll();
    }



    /**
     * Validate the User can select how many products can be displayed in the Search Results
     */
    @Test
    public void TC_SP_021(){
        new HeaderPage(driver).searchProduct("i");
        ProductSearchPage productSearchPage=new ProductSearchPage(driver);
        productSearchPage.enableProductDescription();
        productSearchPage.enterSearchButton();
        String noOfPages_result1=productSearchPage.getTotalPage();
        productSearchPage.selectNumberOfProductShowPerPage(ProductSearchPage.Show.TWENTY_FIVE);
        String noOfPages_result2=productSearchPage.getTotalPage();

        softAssert.assertEquals(noOfPages_result1,"2");
        softAssert.assertEquals(noOfPages_result2,"1");
        softAssert.assertAll();
    }

    /**
     * Validate we can use all the options of Search functionality using the Keyboard keys.
     */
    @Test
    public void TC_SP_022(){
        new HeaderPage(driver).searchProduct("i");
        ProductSearchPage productSearchPage=new ProductSearchPage(driver);
        productSearchPage.searchByKeyBoardActions(properties.getProperty("product1"),true,"macs",true);

        Assert.assertFalse(productSearchPage.ifAnyProductAvailable());
    }

    /**
     * Validate 'Search' text box field and the button having search icon are displayed on all the page of the Application
     */
    @Test
    public void TC_SP_023(){
        HeaderPage headerPage=new HeaderPage(driver);
        softAssert.assertTrue(headerPage.searchBoxIsPresents());
        softAssert.assertTrue(headerPage.searchButtonIsPresents());

        headerPage.setMyAccount(HomePageEnums.MyAccount.LOGIN);
        softAssert.assertTrue(headerPage.searchBoxIsPresents());
        softAssert.assertTrue(headerPage.searchButtonIsPresents());

        headerPage.setMyAccount(HomePageEnums.MyAccount.REGISTER);
        softAssert.assertTrue(headerPage.searchBoxIsPresents());
        softAssert.assertTrue(headerPage.searchButtonIsPresents());

        headerPage.navigateToCheckOutPage();
        softAssert.assertTrue(headerPage.searchBoxIsPresents());
        softAssert.assertTrue(headerPage.searchButtonIsPresents());

        headerPage.navigateToWishListPage();
        softAssert.assertTrue(headerPage.searchBoxIsPresents());
        softAssert.assertTrue(headerPage.searchButtonIsPresents());

        softAssert.assertAll();
    }

    /**
     * Validate Page Heading, Page URL and Page Title of the 'Search' page
     */

    @Test
    public void TC_SP_024(){
        new HeaderPage(driver).searchProduct("i");
        ProductSearchPage productSearchPage=new ProductSearchPage(driver);
        String header= productSearchPage.getPageHeading();

        Assert.assertTrue(header.contains("Search"));
    }

}
