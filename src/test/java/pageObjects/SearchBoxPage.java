package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class SearchBoxPage extends BasePage{
    public SearchBoxPage(WebDriver driver) {
        super(driver);
    }

    enum AllCategories{
        ALL_CATEGORIES(" All Categories"), DESKTOPS("Desktops"), MAC("Mac"),
        LAPTOPS_NOTEBOOKS("Laptops & Notebooks"), Macs("Macs"), WINDOWS("Windows"),
        COMPONENTS("Components"), MICE_AND_TRACKBALLS("Mice and Trackballs"), MONITORS("Monitors"),
        TEST_1("test 1"), TEST_2("test 2"), PRINTERS("Printers"), SCANNERS("Scanners"),
        WEB_CAMERAS("Web Cameras"), TABLETS("Tablets"), SOFTWARE("Software"), PHONES_PDAS("Phones & PDAs"),
        CAMERAS("Cameras"), MP3PLAYERS("MP3 Players"), TEXT_11("test 11"), TEXT_12("test 12"),
        TEXT_15("test 15"), TEXT_16("test 16"), TEXT_17("test 17"), TEXT_18("test 18"),
        TEXT_19("test 19"), TEXT_20("test 20"), TEXT_25("test 25"), TEXT_21("test 21"),
        TEXT_22("test 22"), TEXT_23("test 23"), TEXT_24("test 24"), TEXT_4("test 4"),
        TEXT_5("test 5"), TEXT_6("test 6"), TEXT_7("test 7"), TEST_8("test 8"), TEXT_9("test 9");
        private final String text;
        AllCategories(String text) {
            this.text=text;
        }
        public String getVisibleText() {
            return text;
        }

}
     enum SortBy{

    DEFAULT("Default"), NAME_ASS("Name (A - Z)"), NAME_DEC("Name (Z -A)"),
    PRICE_ASS("Price (Low > High)"), PRICE_DEC("Price (High > Low)"),
    RATING_ASS("Rating (Highest)"), RATING_DEC("Rating (Lowest)"),
    MODEL_ASS("Model (A- Z)"), MODEL_DEC("Model (Z -A)");
    private final String text;
    SortBy(String text) {
        this.text=text;
    }
    public String getVisibleText() {
        return text;
    }
}
     enum Show {
        TEN("10"), TWENTY_FIVE("25"), FIFTY("50"),SEVENTY_FIVE("75"),ONE_HUNDRED("100");
        private final String value;
        Show(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    @FindBy(css = "input#input-search")
    private WebElement searchBoxElement;
    @FindBy(css = "select#input-category")
    private WebElement allCategoriesElement;
    @FindBy(css = "input#input-description")
    private WebElement searchInProductDescriptionsButtonElement;
    @FindBy(css = "input#input-sub-category")
    private WebElement searchInSubcategoriesButtonElement;
    @FindBy(css = "button#button-search")
    private WebElement searchButtonElement;
    @FindBy(css = "a#compare-total")
    private WebElement productCompareElement;
    @FindBy(css = "button#button-list")
    private WebElement listButtonElement;
    @FindBy(css = "button#button-grid")
    private WebElement gridButtonElement;
    @FindBy(css = "select#input-sort")
    private WebElement sortDropDown;
    @FindBy(css = "select#input-limit")
    private WebElement showNumberOfItemsDropDown;
    @FindBy(xpath = "//div[@id='content']//p[contains(text(),'no product')]")
    private WebElement noProductMessage;
    @FindBy(xpath = "//div[@class='product-thumb']//h4")
    private List<WebElement> allProductsName;
    @FindBy(css = "span.price-new")
    WebElement currentProductPrice;
    @FindBy(css = "span.price-tax")
    WebElement currentProductTax;
    @FindBy(xpath = "//div[@class='button-group']/button[1]")
    private List<WebElement> addToCartButtons;
    @FindBy(xpath = "//div[@class='button-group']/button[2]")
    private List<WebElement> addTheProductToWishList;
    @FindBy(xpath = "//div[@class='button-group']/button[3]")
    private List<WebElement> addTheProductToCompare;
    @FindBy(xpath = "(//*[@class='page-item'])[2]")
    private WebElement paginationNext;
    @FindBy(xpath = "//*[@class='page-item active']/span")
    private WebElement currentPaginationPage;
    @FindBy(className = "col-sm-6 text-end")
    private WebElement totalPages;
    @FindBy(xpath = "//*[@id='content']/h1")
    private WebElement searcherWord;
    @FindBy(className = "alert alert-success alert-dismissible")
    private WebElement successAlertMessage;

    /**
     Actions Methods
     **/

    public void setTextToSearchBox(String text){
        searchBoxElement.sendKeys(text);
    }
    public void selectCategories(AllCategories categories){
        wait.until(ExpectedConditions.visibilityOf(allCategoriesElement));
        new Select(allCategoriesElement).selectByVisibleText(categories.getVisibleText());
    }
    public void enableProductDescription(){
        wait.until(ExpectedConditions.elementToBeClickable(searchInProductDescriptionsButtonElement));
        searchInProductDescriptionsButtonElement.click();
    }
    public void enableSubcategories(){
        wait.until(ExpectedConditions.elementToBeClickable(searchInSubcategoriesButtonElement));
        searchInSubcategoriesButtonElement.click();
    }
    public void enterSearchButton(){
        wait.until(ExpectedConditions.elementToBeClickable(searchButtonElement));
        searchButtonElement.click();
    }
    public String getSearcherProductText(){
        wait.until(ExpectedConditions.visibilityOf(searcherWord));
        return searcherWord.getText();
    }
    public String getNoProductMatchesMessage(){
        wait.until(ExpectedConditions.visibilityOf(noProductMessage));
        return noProductMessage.getText();
    }
    public void navigateToProductComparePage(){
        wait.until(ExpectedConditions.visibilityOf(productCompareElement));
        productCompareElement.click();
    }
    public void changeTheProductViewToList(){
        wait.until(ExpectedConditions.visibilityOf(listButtonElement));
        listButtonElement.click();
    }
    public void changeTheProductViewToGrid(){
        wait.until(ExpectedConditions.visibilityOf(gridButtonElement));
        gridButtonElement.click();
    }
    public void selectSortBy(SortBy sortBy){
        wait.until(ExpectedConditions.visibilityOf(sortDropDown));
        new Select(sortDropDown).selectByValue(sortBy.getVisibleText());
    }
    public void selectNumberOfProductShowPerPage(Show perPage){
        wait.until(ExpectedConditions.visibilityOf(showNumberOfItemsDropDown));
        new Select(showNumberOfItemsDropDown).selectByValue(perPage.getValue());
    }

    public void addTheProductToCard(String productName){
        boolean added=false;
        for (int i=0;i<getTotalPage();i++) {
            wait.until(ExpectedConditions.visibilityOfAllElements(allProductsName));
            for (WebElement product : allProductsName) {
                if (productName.equals(product.getText())) {
                    int index=allProductsName.indexOf(product);
                    wait.until(ExpectedConditions.elementToBeClickable(addToCartButtons.get(index)));
                    addToCartButtons.get(index).click();
                    added=true;
                    break;
                }
            }
            if (added){
                break;
            }
            wait.until(ExpectedConditions.elementToBeClickable(paginationNext));
            paginationNext.click();
        }
    }
    public void addTheProductToWishList(String productName){
        boolean added=false;
        for (int i=0;i<getTotalPage();i++) {
            wait.until(ExpectedConditions.visibilityOfAllElements(allProductsName));
            for (WebElement product : allProductsName) {
                if (productName.equals(product.getText())) {
                    int index=allProductsName.indexOf(product);
                    wait.until(ExpectedConditions.elementToBeClickable(addTheProductToWishList.get(index)));
                    addTheProductToWishList.get(index).click();
                    added=true;
                    break;
                }
            }
            if (added){
                break;
            }
            wait.until(ExpectedConditions.elementToBeClickable(paginationNext));
            paginationNext.click();
        }
    }
    public void addTheProductToCompare(String productName){
        boolean added=false;
        for (int i=0;i<getTotalPage();i++) {
            wait.until(ExpectedConditions.visibilityOfAllElements(allProductsName));
            for (WebElement product : allProductsName) {
                if (productName.equals(product.getText())) {
                    int index=allProductsName.indexOf(product);
                    wait.until(ExpectedConditions.elementToBeClickable(addTheProductToCompare.get(index)));
                    addTheProductToCompare.get(index).click();
                    added=true;
                    break;
                }
            }
            if (added){
                break;
            }
            wait.until(ExpectedConditions.elementToBeClickable(paginationNext));
            paginationNext.click();
        }
    }

    public List<String> getAllProductsName(){
        List<String> names =new ArrayList<>();
        for (int i=0;i<getTotalPage();i++) {
            wait.until(ExpectedConditions.visibilityOfAllElements(allProductsName));
            for (WebElement product : allProductsName) {
                wait.until(ExpectedConditions.visibilityOfAllElements(product));
                names.add(product.getText());
            }
            wait.until(ExpectedConditions.elementToBeClickable(paginationNext));
            paginationNext.click();
        }
        return names;
    }
    public String getCurrentPaginationNumber(){
        wait.until(ExpectedConditions.visibilityOfAllElements(currentPaginationPage));
        return currentPaginationPage.getText();
    }
    public int getTotalPage(){
        String text=totalPages.getText();
        int start=text.indexOf('(');
        int end=text.indexOf(" Pages");
        String sub=text.substring(start+1,end);
        return Integer.parseInt(sub);
    }
    public String getSuccessAlertMessage(){
        wait.until(ExpectedConditions.visibilityOf(successAlertMessage));
        return successAlertMessage.getText();
    }
}
