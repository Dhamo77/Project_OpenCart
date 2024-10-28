package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProductSearchPage extends BasePage{
    public ProductSearchPage(WebDriver driver) {
        super(driver);
    }

    public enum AllCategories{
        ALL_CATEGORIES("0"), DESKTOPS("20"), MAC("27"),PC("26"),
        LAPTOPS_NOTEBOOKS("18"), Macs("46"), WINDOWS("45"),
        COMPONENTS("25"), MICE_AND_TRACKBALLS("29"), MONITORS("28"),
        TEST_1("35"), TEST_2("36"), PRINTERS("30"), SCANNERS("31"),
        WEB_CAMERAS("32"), TABLETS("57"), SOFTWARE("17"), PHONES_PDAS("24"),
        CAMERAS("33"), MP3PLAYERS("34"), TEXT_11("43"), TEXT_12("44"),
        TEXT_15("47"), TEXT_16("48"), TEXT_17("49"), TEXT_18("50"),
        TEXT_19("51"), TEXT_20("52"), TEXT_25("58"), TEXT_21("53"),
        TEXT_22("54"), TEXT_23("55"), TEXT_24("56"), TEXT_4("38"),
        TEXT_5("37"), TEXT_6("39"), TEXT_7("40"), TEST_8("41"), TEXT_9("42");
        private final String text;
        AllCategories(String text) {
            this.text=text;
        }
        public String getVisibleText() {
            return text;
        }

    }
    public enum SortBy{

        DEFAULT("Default"), NAME_ASS("Name (A - Z)"), NAME_DEC("Name (Z - A)"),
        PRICE_ASC("Price (Low > High)"), PRICE_DEC("Price (High > Low)"),
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
    public enum Show {
        TEN("10"), TWENTY_FIVE("25"), FIFTY("50"),SEVENTY_FIVE("75"),ONE_HUNDRED("100");
        private final String value;
        Show(String value) {
            this.value = value;
        }
        public String getVisibleText() {
            return value;
        }
    }
    @FindBy(xpath = "//input[@id='input-search']")
    private WebElement searchCriteriaBoxElement;
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
    private final By currentSortByDropDownPath =By.cssSelector("select#input-sort");
    @FindBy(css = "select#input-sort")
    private WebElement sortDropDown;
    @FindBy(css = "select#input-limit")
    private WebElement showNumberOfItemsDropDown;
    @FindBy(xpath = "//div[@id='content']//p[contains(text(),'no product')]")
    private WebElement noProductMessage;
    @FindBy(xpath = "//div[@class='product-thumb']//h4")
    private List<WebElement> allProductsName;

    By currentProductName =By.xpath("//div[@class='product-thumb']//h4");
    @FindBy(xpath = "//div[@class='product-thumb']//h4/a")
    private List<WebElement> ProductsName;

    By currentProductPrice =By.cssSelector("span.price-new");
    /*@FindBy(css = "span.price-new")
    WebElement currentProductPrice;*/
    @FindBy(css = "span.price-tax")
    WebElement currentProductTax;
    @FindBy(xpath = "//div[@class='button-group']/button[1]")
    private List<WebElement> addTheProductToCart;
    @FindBy(xpath = "//div[@class='button-group']/button[2]")
    private List<WebElement> addTheProductToWishList;
    @FindBy(xpath = "//div[@class='button-group']/button[3]")
    private List<WebElement> addTheProductToCompare;
    @FindBy(xpath = "(//*[@class='page-item'])[2]")
    private WebElement paginationNext;
    @FindBy(xpath = "//*[@class='page-item active']/span")
    private WebElement currentPaginationPage;
    @FindBy(xpath = "//div[@class='col-sm-6 text-end']")
    private WebElement totalPages;
    @FindBy(xpath = "//*[@id='content']/h1")
    private WebElement searcherHeaderWord;
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement successAlertMessage;
    @FindBy(xpath = "//*[@placeholder='Search']")
    private WebElement mainSearchBox;
    @FindBy(xpath = "//div[@class='row row-cols-1 row-cols-sm-2 row-cols-md-2 row-cols-lg-3']")
    private WebElement gridTypeElement;

    @FindBy(xpath = "//div[@class='row row-cols-1 product-list']")
    private WebElement listTypeElement;

    @FindBy(xpath = "//*[@class='col mb-3']")
    private List<WebElement> productAvailable;

    /**
     Actions Methods
     **/

    public void setTextToSearchBox(String text){
        searchCriteriaBoxElement.sendKeys(text);
    }
    public String getSearchCriteriaText(){
        wait.until(ExpectedConditions.visibilityOf(searchCriteriaBoxElement));
        return searchCriteriaBoxElement.getAttribute("value");
    }
    public void selectCategories(AllCategories categories){
        wait.until(ExpectedConditions.visibilityOf(allCategoriesElement));
        new Select(allCategoriesElement).selectByValue(categories.getVisibleText());
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
        wait.until(ExpectedConditions.visibilityOf(searchButtonElement));
        wait.until(ExpectedConditions.elementToBeClickable(searchButtonElement));
        searchButtonElement.click();
    }
    public String getSearcherHeaderText(){
        wait.until(ExpectedConditions.visibilityOf(searcherHeaderWord));
        return searcherHeaderWord.getText();
    }
    public String getNoProductMatchesMessage(){
        wait.until(ExpectedConditions.visibilityOf(noProductMessage));
        return noProductMessage.getText();
    }
    public void navigateToProductComparePage(){
        wait.until(ExpectedConditions.visibilityOf(productCompareElement));
        productCompareElement.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Product Comparison']")));
    }

    public void selectSortBy(SortBy sortBy){
        wait.until(ExpectedConditions.visibilityOf(sortDropDown));
        new Select(sortDropDown).selectByVisibleText(sortBy.getVisibleText());
    }
    public void selectNumberOfProductShowPerPage(Show perPage){
        wait.until(ExpectedConditions.visibilityOf(showNumberOfItemsDropDown));
        new Select(showNumberOfItemsDropDown).selectByVisibleText(perPage.getVisibleText());
    }

    public void addTheProductToCard(String productName){
        boolean added=false;
        for (int i = 0; i< getTotalPageInNumeric(); i++) {
            allProductsName=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='product-thumb']//h4")));
            addTheProductToCart =wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='button-group']/button[1]")));
            for (WebElement product : allProductsName) {
                if (productName.equalsIgnoreCase(product.getText())) {
                    int index=allProductsName.indexOf(product);
                    wait.until(ExpectedConditions.visibilityOf(addTheProductToCart.get(index)));
                    wait.until(ExpectedConditions.elementToBeClickable(addTheProductToCart.get(index)));
                    javaScriptClick(addTheProductToCart.get(index));
                    added=true;
                    break;
                }
            }
            if (added){
                break;
            }
            if (i< getTotalPageInNumeric()-1) {
                pagination();
            }
        }
    }
    public void addTheProductToWishList(String productName){
        boolean added=false;
        for (int i = 0; i< getTotalPageInNumeric(); i++) {
            allProductsName=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='product-thumb']//h4")));
            addTheProductToWishList=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='button-group']/button[2]")));
            for (WebElement product : allProductsName) {
                if (productName.equalsIgnoreCase(product.getText())) {
                    int index=allProductsName.indexOf(product);
                    wait.until(ExpectedConditions.visibilityOf(addTheProductToWishList.get(index)));
                    wait.until(ExpectedConditions.elementToBeClickable(addTheProductToWishList.get(index)));
                    javaScriptClick(addTheProductToWishList.get(index));
                    added=true;
                    break;
                }
            }
            if (added){
                break;
            }
            if (i< getTotalPageInNumeric()-1) {
                pagination();
            }
        }
    }
    public void addTheProductToCompare(String productName){
        boolean added=false;
        for (int i = 0; i< getTotalPageInNumeric(); i++) {
            allProductsName=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='product-thumb']//h4")));
            addTheProductToCompare=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='button-group']/button[3]")));
            for (WebElement product : allProductsName) {
                if (productName.equalsIgnoreCase(product.getText())) {
                    int index=allProductsName.indexOf(product);
                    wait.until(ExpectedConditions.visibilityOf(addTheProductToCompare.get(index)));
                    wait.until(ExpectedConditions.elementToBeClickable(addTheProductToCompare.get(index)));
                    javaScriptClick(addTheProductToCompare.get(index));
                    added=true;
                    break;
                }
            }
            if (added){
                break;
            }
            if (i< getTotalPageInNumeric()-1) {
                pagination();
            }
        }
    }

    public List<String> getAllProductsName(){
        List<String> names =new ArrayList<>();
        for (int i = 0; i< getTotalPageInNumeric(); i++) {
            List<WebElement> productNames = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(currentProductName));
            for (WebElement product : productNames) {
                names.add(product.getText());
            }
            if (i< getTotalPageInNumeric()-1) {
                pagination();
            }
        }
        return names;
    }
    public List<Double> getAllProductsPrice(){
        List<Double> prices = new ArrayList<>();
        for (int i=0;i<getTotalPageInNumeric();i++) {
            List<WebElement> priceElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(currentProductPrice));
            for (WebElement priceElement : priceElements) {
                String cleanedString = priceElement.getText().replaceAll("[^\\d.]", "").trim();
                prices.add(Double.parseDouble(cleanedString));
            }
            if (i<getTotalPageInNumeric()-1){
                pagination();
            }
        }
        return prices;
    }
    public String getCurrentPaginationNumber(){
        wait.until(ExpectedConditions.visibilityOfAllElements(currentPaginationPage));
        return currentPaginationPage.getText();
    }
    private int getTotalPageInNumeric(){
        wait.until(ExpectedConditions.visibilityOf(totalPages));
        String text=totalPages.getText();
        int start=text.indexOf('(');
        int end=text.indexOf(" Pages");
        String sub=text.substring(start+1,end);
        return Integer.parseInt(sub);
    }
    public String getTotalPage(){
        wait.until(ExpectedConditions.visibilityOf(totalPages));
        String text=totalPages.getText();
        int start=text.indexOf('(');
        int end=text.indexOf(" Pages");
        return (text.substring(start+1,end));
    }
    public String getSuccessAlertMessage(){
        wait.until(ExpectedConditions.visibilityOf(successAlertMessage));
        return successAlertMessage.getText();
    }

    public  boolean isProductPresent(){
        List<String> productsName= getAllProductsName();
        for (String name:productsName){
            if (getSearchCriteriaText().equals(name)){
                return true;
            }
        }
        return false;
    }

    public boolean subCategoriesIsInDefaultSubCategories(){
        return searchInSubcategoriesButtonElement.isEnabled();
    }
    public boolean searchInProductDefaultDescriptions(){

        return searchInProductDescriptionsButtonElement.isSelected();
    }
    public String getTheSelectedCategoriesOption() {
        Select dropdown = new Select(allCategoriesElement);
        return dropdown.getFirstSelectedOption().getText();

    }
    public String getTheSelectedSortByOptionText() {
        Select dropdown = new Select(sortDropDown);
        return dropdown.getFirstSelectedOption().getText();
    }
    public String getTheSelectedShowPerPageOptionText() {
        Select dropdown = new Select(showNumberOfItemsDropDown);
        return dropdown.getFirstSelectedOption().getText();
    }

    private void pagination(){
        paginationNext=driver.findElement(By.xpath("(//*[@class='page-item'])[2]"));
        js.executeScript("arguments[0].scrollIntoView(true);", paginationNext);
        wait.until(ExpectedConditions.visibilityOf(paginationNext));  // Wait for visibility
        wait.until(ExpectedConditions.elementToBeClickable(paginationNext));
        try {
            Thread.sleep(1000);// Ensure it's clickable
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        paginationNext.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='product-thumb']//h4")));
    }

    public String getSearchCriteriaPlaceHolder(){
        return searchCriteriaBoxElement.getAttribute("placeholder");
    }
    public String getMainSearchBoxPlaceHolder(){
        return mainSearchBox.getAttribute("placeholder");
    }

    public void navigationToProductPage(String productName){
        boolean added =false;
        for (int i = 0; i< getTotalPageInNumeric(); i++) {
            ProductsName=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='product-thumb']//h4/a")));
            for (WebElement product : ProductsName) {
                if (productName.equalsIgnoreCase(product.getText())) {
                    int index=ProductsName.indexOf(product);
                    javaScriptClick(ProductsName.get(index));
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Related Products']")));
                    added=true;
                    break;
                }
            }
            if (added){
                break;
            }
            if (i< getTotalPageInNumeric()-1) {
                pagination();
            }
        }
    }
    public void changeTheProductViewToGrid(){
        wait.until(ExpectedConditions.visibilityOf(gridButtonElement));
        javaScriptClick(gridButtonElement);
        wait.until(ExpectedConditions.visibilityOf(gridTypeElement));
    }

    public void changeTheProductViewToList(){
        wait.until(ExpectedConditions.visibilityOf(listButtonElement));
        javaScriptClick(listButtonElement);
        wait.until(ExpectedConditions.visibilityOf(listTypeElement));
    }

    public boolean isGridTypeSelected(){
        try {
            return gridTypeElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isListTypeSelected(){
        try {
            return listTypeElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private void javaScriptClick(WebElement element){
        js.executeScript("arguments[0].click();",element);
    }

    public  void searchByKeyBoardActions(String text,boolean  productDescriptions,String categories,boolean subcategories){
        searchCriteriaBoxElement.clear();
        actions.click(searchCriteriaBoxElement).sendKeys(text).keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
        if (productDescriptions){
            actions.keyDown(Keys.SPACE).keyUp(Keys.SPACE).keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
        }
        else {
            actions.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
        }
        while (!getTheSelectedCategoriesOption().trim().equalsIgnoreCase(categories)){
            actions.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).perform();
        }
        if (subcategories&&(!categories.equals("All Categories"))){
            actions.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
            actions.keyDown(Keys.SPACE).keyUp(Keys.SPACE).perform();
        }
        actions.keyDown(Keys.TAB).keyUp(Keys.TAB).keyDown(Keys.SPACE).keyUp(Keys.SPACE).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
    }
    public boolean ifAnyProductAvailable(){
        return productAvailable.size() != 0;
    }

}
