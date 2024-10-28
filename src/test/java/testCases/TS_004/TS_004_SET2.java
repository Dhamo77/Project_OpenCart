package testCases.TS_004;

import BaseClasses.BaseClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HeaderPage;
import pageObjects.ProductSearchPage;

import java.util.List;


public class TS_004_SET2 extends BaseClass {

    /**
     * Validate User is able to sort the Products displayed in the Search Results
     */

    @BeforeClass
    public void setup(){
        new HeaderPage(driver).searchProduct("i");
        ProductSearchPage productSearchPage=new ProductSearchPage(driver);
        productSearchPage.enableProductDescription();
        productSearchPage.enterSearchButton();
    }

    /**
     * sort the Products by price(Low to High)
     */
    @Test
    public void TC_SP_020_1(){
        ProductSearchPage productSearchPage=new ProductSearchPage(driver);
        productSearchPage.selectSortBy(ProductSearchPage.SortBy.PRICE_ASC);
        List<Double> prices = productSearchPage.getAllProductsPrice();
        
        Double previous = null;
        for (Double current : prices) {
            if (previous != null) {
                softAssert.assertTrue(previous <= current);
            }
            previous = current;
        }
        softAssert.assertAll();
    }
    /**
     * sort the Products by price(High to Low)
     */
    @Test
    public void TC_SP_020_2(){
        ProductSearchPage productSearchPage=new ProductSearchPage(driver);
        productSearchPage.selectSortBy(ProductSearchPage.SortBy.PRICE_DEC);
        List<Double> prices = productSearchPage.getAllProductsPrice();

        Double previous = null;
        for (Double current : prices) {
            if (previous != null) {
                softAssert.assertTrue(previous >= current);
            }
            previous = current;
        }
        softAssert.assertAll();
    }

    /**
     * sort the Products by name(A to Z)
     */
    @Test
    public void TC_SP_020_3(){

        ProductSearchPage productSearchPage=new ProductSearchPage(driver);
        productSearchPage.selectSortBy(ProductSearchPage.SortBy.NAME_ASS);
        List<String> productNames = productSearchPage.getAllProductsName();

        String previous = null;
        for (String current : productNames) {
            if (previous != null) {
                softAssert.assertTrue(previous.compareToIgnoreCase(current) <= 0);
            }
            previous = current;
        }
        softAssert.assertAll();
    }

    /**
     * sort the Products by name(Z to A)
     */
    @Test
    public void TC_SP_020_4(){

        ProductSearchPage productSearchPage=new ProductSearchPage(driver);
        productSearchPage.selectSortBy(ProductSearchPage.SortBy.NAME_DEC);
        List<String> productNames = productSearchPage.getAllProductsName();

        String previous = null;
        for (String current : productNames) {
            if (previous != null) {
                softAssert.assertTrue(previous.compareToIgnoreCase(current) >= 0);
            }
            previous = current;
        }
            softAssert.assertAll();
    }
}
