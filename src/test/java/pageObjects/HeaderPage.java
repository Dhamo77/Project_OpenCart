package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderPage extends BasePage{
    public HeaderPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "(//*[@class='d-none d-md-inline'])[2]")
    WebElement contactNumberElement;
    @FindBy(xpath = "(//*[@class='d-none d-md-inline'])[4]")
    WebElement  wishListElement;
    @FindBy(xpath = "(//*[@class='d-none d-md-inline'])[5]")
    WebElement  shoppingCartElement;
    @FindBy(xpath = "(//*[@class='d-none d-md-inline'])[6]")
    WebElement  checkoutElement;
    @FindBy(xpath = "(//*[@class='d-none d-md-inline'])[1]")
    WebElement currencyElement;
    @FindBy(xpath = "(//div[@class='dropdown'])[1]//ul/li")
    List<WebElement> currencyDropDown;
    @FindBy(xpath = "(//*[@class='d-none d-md-inline'])[3]")
    WebElement  myAccountElement;
    @FindBy(xpath = "//*[@class='dropdown-menu dropdown-menu-right']/li")
    List<WebElement> myAccountDropDown;
    @FindBy(xpath = "//*[@placeholder='Search']")
    WebElement searchBoxElement;
    @FindBy(xpath = "//div[@class=dropdown d-grid']/button")
    WebElement addedItemsElement;
    @FindBy(xpath = "//div[@class='dropdown d-grid']//ul/li/table//tr")
    List<WebElement> addedItemsDropDown;
    @FindBy(xpath = "//div[@class='dropdown d-grid']//button[@aria-label='Remove']")
    WebElement addedItemsRemove;
    @FindBy(xpath = "//div[@class='dropdown d-grid']//a[contains(@href,'checkout/cart')]")
    WebElement addedItemsViewCard;
    @FindBy(xpath = "//div[@class='dropdown d-grid']//a[contains(@href,'checkout/checkout')]")
    WebElement addedItemsCheckOut;
    @FindBy(xpath = "(//div[@class='dropdown d-grid']//li//div//tbody/tr/td)[2]")
    WebElement addedItemSub_TotalAmount;
    @FindBy(xpath = "(//div[@class='dropdown d-grid']//li//div//tbody/tr/td)[4]")
    WebElement addedItemEco_TaxAmount;
    @FindBy(xpath = "(//div[@class='dropdown d-grid']//li//div//tbody/tr/td)[6]")
    WebElement addedItemVATAmount;
    @FindBy(xpath = "(//div[@class='dropdown d-grid']//li//div//tbody/tr/td)[8]")
    WebElement addedItemTotalAmount;
    @FindBy(xpath = "//div[@class='dropdown d-grid']//ul//table[@class=table table-striped mb-2']//tr//td[@class='text-start']/a")
    WebElement addedItemsProductDetails;
    @FindBy(xpath = "//div[@class='dropdown d-grid']//ul//table[@class='table table-striped mb-2']//tr//td[3]")
    WebElement countOfParticularAddedProduct;
    @FindBy(xpath = "//div[@class='dropdown d-grid']//ul//table[@class='table table-striped mb-2']//tr//td[4]")
    WebElement amountOfParticularAddedProduct;

    //mainTag
    @FindBy(xpath = "//*[@class='nav-item dropdown']/a[contains(@href,'desktop')]")
    WebElement desktopElement;
    @FindBy(xpath = "(//*[@class='nav-item dropdown'])[1]//li")
    List<WebElement> desktopElementDropDown;
    @FindBy(xpath = "//a[@class='see-all'][contains(@href,'desktops')]")
    WebElement show_all_Desktops;
    @FindBy(xpath = "//*[@class='nav-item dropdown']/a[contains(@href,'laptop')]")
    WebElement laptop_notebookElement;
    @FindBy(xpath = "(//*[@class='nav-item dropdown'])[2]//li")
    List<WebElement> laptop_notebookDropDown;
    @FindBy(xpath = "//a[@class='see-all'][contains(@href,'laptop')]")
    WebElement show_all_laptop_notebook;
    @FindBy(xpath = "//*[@class='nav-item dropdown']/a[contains(@href,'component')]")
    WebElement componentsElement;
    @FindBy(xpath = "(//*[@class='nav-item dropdown'])[3]//li")
    List<WebElement> componentsDropDown;
    @FindBy(xpath = "//a[@class='see-all'][contains(@href,'component')]")
    WebElement show_all_components;
    @FindBy(xpath = "//*[@class='nav-item']/a[contains(@href,'tablet')]")
    WebElement tabletElement;
    @FindBy(xpath = "//*[@class='nav-item']/a[contains(@href,'software')]")
    WebElement softwareElement;
    @FindBy(xpath = "//*[@class='nav-item']/a[contains(@href,'phone')]")
    WebElement phones_PDAsElement;
    @FindBy(xpath = "//*[@class='nav-item']/a[contains(@href,'cameras')]")
    WebElement camerasElement;
    @FindBy(xpath = "//*[@class='nav-item dropdown']/a[contains(@href,'mp3-player')]")
    WebElement mp3PlayersElement;
    @FindBy(xpath = "(//*[@class='nav-item dropdown'])[4]//li")
    List<WebElement> mp3PlayersDropDown;
    @FindBy(xpath = "//a[@class='see-all'][contains(@href,'mp3-player')]")
    WebElement show_all_mp3Players;

    /**
     Actions Methods
     **/
    public void changeCurrencyValue(String currencyType){
        currencyElement.click();
        for (WebElement option:currencyDropDown){
            if (currencyType.equals(option.getText())){
                option.click();
                break;
            }
        }
    }
    public String getContactNumber(){
        return contactNumberElement.getText();
    }
    public void setMyAccount(String userType){
        myAccountElement.click();
        for (WebElement option:myAccountDropDown){
            if (userType.equals(option.getText())){
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
        searchBoxElement.sendKeys(productName+ Keys.ENTER);
    }
    public void getParticularDesktop(String desktopType){
        desktopElement.click();
        for (WebElement option:desktopElementDropDown){
            if (desktopType.equals(option.getText())){
                option.click();
                break;
            }
        }
    }
    public void getParticularLaptop_NoteBook(String lap_notebookType){
        laptop_notebookElement.click();
        for (WebElement option:laptop_notebookDropDown){
            if (lap_notebookType.equals(option.getText())){
                option.click();
                break;
            }
        }
    }
    public void getParticularComponents(String componentsType){
        componentsElement.click();
        for (WebElement option:componentsDropDown){
            if (componentsType.equals(option.getText())){
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
        return searchBoxElement.getText();
    }
}
