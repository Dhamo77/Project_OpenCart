package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HeaderPage extends HomePageEnums{

    public HeaderPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "(//*[@class='d-none d-md-inline'])[2]")
    private WebElement contactNumberElement;
    @FindBy(xpath = "(//*[@class='d-none d-md-inline'])[4]")
    private WebElement  wishListElement;
    @FindBy(xpath = "(//*[@class='d-none d-md-inline'])[5]")
    private WebElement  shoppingCartElement;
    @FindBy(xpath = "(//*[@class='d-none d-md-inline'])[6]")
    private WebElement  checkoutElement;
    @FindBy(xpath = "(//*[@class='d-none d-md-inline'])[1]")
    private WebElement currencyElement;
    @FindBy(xpath = "(//div[@class='dropdown'])[1]//ul/li")
    private List<WebElement> currencyDropDown;
    @FindBy(xpath = "(//*[@class='d-none d-md-inline'])[3]")
    private WebElement  myAccountElement;
    @FindBy(xpath = "//*[contains(@class,'dropdown-menu dropdown-menu-right')]/li")
    private List<WebElement> myAccountDropDown;
    @FindBy(xpath = "//*[@placeholder='Search']")
    private WebElement searchBoxElement;
    @FindBy(xpath = "//*[@class=\"btn btn-light btn-lg\"]")
    private WebElement searchButtonElement;


    @FindBy(xpath = "//div[@class=dropdown d-grid']/button")
    private WebElement addedItemsElement;
    @FindBy(xpath = "//div[@class='dropdown d-grid']//ul/li/table//tr")
    private List<WebElement> addedItemsDropDown;
    @FindBy(xpath = "//div[@class='dropdown d-grid']//button[@aria-label='Remove']")
    private WebElement addedItemsRemove;
    @FindBy(xpath = "//div[@class='dropdown d-grid']//a[contains(@href,'checkout/cart')]")
    private WebElement addedItemsViewCard;
    @FindBy(xpath = "//div[@class='dropdown d-grid']//a[contains(@href,'checkout/checkout')]")
    private WebElement addedItemsCheckOut;
    @FindBy(xpath = "(//div[@class='dropdown d-grid']//li//div//tbody/tr/td)[2]")
    private WebElement addedItemSub_TotalAmount;
    @FindBy(xpath = "(//div[@class='dropdown d-grid']//li//div//tbody/tr/td)[4]")
    private WebElement addedItemEco_TaxAmount;
    @FindBy(xpath = "(//div[@class='dropdown d-grid']//li//div//tbody/tr/td)[6]")
    private WebElement addedItemVATAmount;
    @FindBy(xpath = "(//div[@class='dropdown d-grid']//li//div//tbody/tr/td)[8]")
    private WebElement addedItemTotalAmount;
    @FindBy(xpath = "//div[@class='dropdown d-grid']//ul//table[@class=table table-striped mb-2']//tr//td[@class='text-start']/a")
    private WebElement addedItemsProductDetails;
    @FindBy(xpath = "//div[@class='dropdown d-grid']//ul//table[@class='table table-striped mb-2']//tr//td[3]")
    private WebElement countOfParticularAddedProduct;
    @FindBy(xpath = "//div[@class='dropdown d-grid']//ul//table[@class='table table-striped mb-2']//tr//td[4]")
    private WebElement amountOfParticularAddedProduct;

    //mainTag
    @FindBy(xpath = "//*[@class='nav-item dropdown']/a[contains(@href,'desktop')]")
    private WebElement desktopElement;
    @FindBy(xpath = "(//*[@class='nav-item dropdown'])[1]//li")
    private List<WebElement> desktopElementDropDown;
    @FindBy(xpath = "//a[@class='see-all'][contains(@href,'desktops')]")
    private WebElement show_all_Desktops;
    @FindBy(xpath = "//*[@class='nav-item dropdown']/a[contains(@href,'laptop')]")
    private WebElement laptop_notebookElement;
    @FindBy(xpath = "(//*[@class='nav-item dropdown'])[2]//li")
    private List<WebElement> laptop_notebookDropDown;
    @FindBy(xpath = "//a[@class='see-all'][contains(@href,'laptop')]")
    private WebElement show_all_laptop_notebook;
    @FindBy(xpath = "//*[@class='nav-item dropdown']/a[contains(@href,'component')]")
    private WebElement componentsElement;
    @FindBy(xpath = "(//*[@class='nav-item dropdown'])[3]//li")
    private List<WebElement> componentsDropDown;
    @FindBy(xpath = "//a[@class='see-all'][contains(@href,'component')]")
    private WebElement show_all_components;
    @FindBy(xpath = "//*[@class='nav-item']/a[contains(@href,'tablet')]")
    private WebElement tabletElement;
    @FindBy(xpath = "//*[@class='nav-item']/a[contains(@href,'software')]")
    private WebElement softwareElement;
    @FindBy(xpath = "//*[@class='nav-item']/a[contains(@href,'phone')]")
    private WebElement phones_PDAsElement;
    @FindBy(xpath = "//*[@class='nav-item']/a[contains(@href,'cameras')]")
    private WebElement camerasElement;
    @FindBy(xpath = "//*[@class='nav-item dropdown']/a[contains(@href,'mp3-player')]")
    private WebElement mp3PlayersElement;
    @FindBy(xpath = "(//*[@class='nav-item dropdown'])[4]//li")
    private List<WebElement> mp3PlayersDropDown;
    @FindBy(xpath = "//a[@class='see-all'][contains(@href,'mp3-player')]")
    private WebElement show_all_mp3Players;

    By alertPopUp=By.xpath("//div[@class='alert alert-success alert-dismissible']");

    /**
     Actions Methods
     **/
    public void changeCurrencyValue(Currency currencyType){
        wait.until(ExpectedConditions.visibilityOf(currencyElement));
        wait.until(ExpectedConditions.elementToBeClickable(currencyElement));
        currencyElement.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(currencyDropDown));
        for (WebElement option:currencyDropDown){
            if (currencyType.getVisibleText().equals(option.getText())){
                wait.until(ExpectedConditions.elementToBeClickable(option));
                option.click();
                break;
            }
        }
    }
    public String getContactNumber(){
        return contactNumberElement.getText();
    }
    public void setMyAccount(MyAccount type){
        wait.until(ExpectedConditions.visibilityOf(myAccountElement));
        wait.until(ExpectedConditions.elementToBeClickable(myAccountElement));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(alertPopUp));

        myAccountElement.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(myAccountDropDown));
        for (WebElement option:myAccountDropDown){
            if (type.getVisibleText().equals(option.getText())){
                wait.until(ExpectedConditions.elementToBeClickable(option));
                option.click();
                break;
            }
        }
    }
    public void navigateToWishListPage(){
        wishListElement.click();
    }
    public void navigateToShoppingCartPage(){
        shoppingCartElement.click();
    }
    public void navigateToCheckOutPage(){
        checkoutElement.click();
    }
    public void searchProduct(String productName){
        searchBoxElement.clear();
        searchBoxElement.sendKeys(productName+ Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product-search")));
    }
    public void getParticularDesktop(Components type){
        desktopElement.click();
        for (WebElement option:desktopElementDropDown){
            if (type.getVisibleText().startsWith(option.getText())){
                option.click();
                break;
            }
        }
    }
    public void getParticularLaptop_NoteBook(Components lap_notebookType){
        laptop_notebookElement.click();
        for (WebElement option:laptop_notebookDropDown){
            if (lap_notebookType.getVisibleText().startsWith(option.getText())){
                option.click();
                break;
            }
        }
    }
    public void getParticularComponents(Components type){
        componentsElement.click();
        for (WebElement option:componentsDropDown){
            if (type.getVisibleText().startsWith(option.getText())){
                option.click();
                break;
            }
        }
    }
    public void getParticularMp3_player(String mp3playerType){
        mp3PlayersElement.click();
        for (WebElement option:mp3PlayersDropDown){
            if (mp3playerType.equals(option.getText())){
                option.click();
                break;
            }
        }
    }
    public void showAllTypeOfDesktops( ){
        desktopElement.click();
        show_all_Desktops.click();
    }
    public void showAllTypeOLap_Notebook( ){
        laptop_notebookElement.click();
        show_all_laptop_notebook.click();
    }
    public void showAllTypeOfComponents( ){
        componentsElement.click();
        show_all_components.click();
    }
    public void showAllTypeOfMP3players( ){
        mp3PlayersElement.click();
        show_all_mp3Players.click();
    }
    public void showTablets(){
        tabletElement.click();
    }
    public void showSoftware(){
        softwareElement.click();
    }
    public void showPhones(){
        phones_PDAsElement.click();
    }
    public void showCameras(){
        camerasElement.click();
    }
    public String getTheAmountOfParticularAddedItem(String productName){
        addedItemsElement.click();
        for (WebElement product:addedItemsDropDown){
            if (productName.equals(product.getText())){
                return amountOfParticularAddedProduct.getText();
            }
        }
        return ("Product not found!");
    }
    public String getTheCountOfParticularAddedItem(String productName){
        addedItemsElement.click();
        for (WebElement product:addedItemsDropDown){
            if (productName.equals(product.getText())){
                return countOfParticularAddedProduct.getText();
            }
        }
        return ("Product not found!");
    }
    public void getParticularProductDetailsInAddedItem(String productName){
        addedItemsElement.click();
        for (WebElement product:addedItemsDropDown){
            if (productName.equals(product.getText())){
                addedItemsProductDetails.click();
                break;
            }
        }
    }
    public void removeParticularProductInAddedItems(String productName){
        addedItemsElement.click();
        for (WebElement product:addedItemsDropDown){
            if (productName.equals(product.getText())){
                addedItemsRemove.click();
                break;
            }
        }
    }
    public void removeAllProductInAddedItems(){
        addedItemsElement.click();
        for (WebElement product:addedItemsDropDown){
            addedItemsRemove.click();
        }
    }
    public void checkoutTheAddedProducts(){
        addedItemsElement.click();
        addedItemsCheckOut.click();
    }
    public String getTheSubTotalAmountOfAddedProducts(){
        addedItemsElement.click();
        return addedItemSub_TotalAmount.getText();
    }
    public String getTheECO_TAXAmountOfAddedProducts(){
        addedItemsElement.click();
        return addedItemEco_TaxAmount.getText();
    }
    public String getTheVATAmountOfAddedProducts(){
        addedItemsElement.click();
        return addedItemVATAmount.getText();
    }
    public String getTheTotalAmountOfAddedProducts(){
        addedItemsElement.click();
        return addedItemTotalAmount.getText();
    }
    public String getSearchBoxText(){
        wait.until(ExpectedConditions.visibilityOf(searchBoxElement));
        return searchBoxElement.getAttribute("value");
    }

    public boolean searchBoxIsPresents(){
        return searchBoxElement.isDisplayed();
    }

    public boolean searchButtonIsPresents(){
        return searchButtonElement.isDisplayed();
    }
}
