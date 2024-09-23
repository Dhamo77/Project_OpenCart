package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class SearchBoxPage extends BasePage{
    public SearchBoxPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "input#input-search")
    WebElement searchBoxElement;
    @FindBy(css = "select#input-category")
    WebElement allCategoriesElement;
    @FindBy(css = "input#input-description")
    WebElement searchInProductDescriptionsButtonElement;
    @FindBy(css = "input#input-sub-category")
    WebElement searchInSubcategoriesButtonElement;
    @FindBy(css = "button#button-search")
    WebElement searchButtonElement;
    @FindBy(css = "a#compare-total")
    WebElement productCompareElement;
    @FindBy(css = "button#button-list")
    WebElement listButtonElement;
    @FindBy(css = "button#button-grid")
    WebElement gridButtonElement;
    @FindBy(css = "select#input-sort")
    WebElement sortDropDown;
    @FindBy(css = "select#input-limit")
    WebElement showNumberOfItemsDropDown;
    @FindBy(xpath = "//div[@id='content']//p[contains(text(),'no product')]")
    WebElement noProductMessage;
    @FindBy(xpath = "//div[@class='product-thumb']//h4")
    List<WebElement> allProductsName;
    @FindBy(css = "span.price-new")
    WebElement currentProductPrice;
    @FindBy(css = "span.price-tax")
    WebElement currentProductTax;
    @FindBy(xpath = "//div[@class='button-group']/button[1]")
    List<WebElement> addTheProductToCard;
    @FindBy(xpath = "//div[@class='button-group']/button[2]")
    List<WebElement> addTheProductToWishList;
    @FindBy(xpath = "//div[@class='button-group']/button[3]")
    List<WebElement> addTheProductToCompare;
    @FindBy(xpath = "(//*[@class='page-item'])[2]")
    WebElement paginationNext;
    @FindBy(xpath = "//*[@class='page-item active']/span")
    WebElement currentPaginationPage;
    @FindBy(className = "col-sm-6 text-end")
    WebElement totalPages;
    @FindBy(xpath = "//*[@id='content']/h1")
    WebElement searcherWord;

    /**
     Actions Methods
     **/

    public void sentTextToSearchBox(String text){
        searchBoxElement.sendKeys(text);
    }
    public void selectCategories(String categories){
        new Select(allCategoriesElement).selectByVisibleText(categories);
    }
    public void enableProductDescription(){
        searchInProductDescriptionsButtonElement.click();
    }
    public void enableSubcategories(){
        searchInSubcategoriesButtonElement.click();
    }
    public void searchTheText(){
        searchButtonElement.click();
    }
    public String getSearcherProductText(){
        return searcherWord.getText();
    }
    public String getNoProductMatchesMessage(){
        return noProductMessage.getText();
    }
    public void navigateToProductComparePage(){
        productCompareElement.click();
    }
    public void changeTheProductViewToList(){
        listButtonElement.click();
    }
    public void changeTheProductViewToGrid(){
        gridButtonElement.click();
    }
    public void selectSortBy(String sortBy){
        new Select(sortDropDown).selectByValue(sortBy);
    }
    public void selectNumberOfProductShowPerPage(String perPage){
        new Select(showNumberOfItemsDropDown).selectByValue(perPage);
    }

    public void addTheProductToCard(String productName){
        for (int i=0;i<getTotalPage();i++) {
            for (WebElement product : allProductsName) {
                if (productName.equals(product.getText())) {
                    addTheProductToCard.get(allProductsName.indexOf(product)).click();
                    break;
                }
            }
            paginationNext.click();
        }
    }
    public void addTheProductToWishList(String productName){
        for (int i=0;i<getTotalPage();i++) {
            for (WebElement product : allProductsName) {
                if (productName.equals(product.getText())) {
                    addTheProductToWishList.get(allProductsName.indexOf(product)).click();
                    break;
                }
            }
            paginationNext.click();
        }
    }
    public void addTheProductToCompare(String productName){
        for (int i=0;i<getTotalPage();i++) {
            for (WebElement product : allProductsName) {
                if (productName.equals(product.getText())) {
                    addTheProductToCompare.get(allProductsName.indexOf(product)).click();
                    break;
                }
            }
            paginationNext.click();
        }
    }

    public List<String> getAllProductsName(){
        List<String> names =new ArrayList<>();
        for (int i=0;i<getTotalPage();i++) {
            for (WebElement product : allProductsName)
                names.add(product.getText());
            paginationNext.click();
        }
        return names;
    }
    public String getCurrentPaginationNumber(){
        return currentPaginationPage.getText();
    }
    public int getTotalPage(){
        String text=totalPages.getText();
        int start=text.indexOf('(');
        int end=text.indexOf(" Pages");
        String sub=text.substring(start+1,end);
        return Integer.parseInt(sub);
    }
}
