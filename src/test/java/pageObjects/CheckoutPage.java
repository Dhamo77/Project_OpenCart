package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CheckoutPage extends AllRightColumnOptions {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id='content']//p")
    WebElement emptyShoppingCardMessageElement;
    @FindBy(xpath = "//*[@id='content']//a")
    WebElement continueButtonForEmptyCardElement;
    @FindBy(xpath = "//*[@name='firstname']")
    WebElement firstnameBoxElement;
    @FindBy(xpath = "//*[@name='lastname']")
    WebElement lastnameBoxElement;
    @FindBy(xpath = "//*[@name='company']")
    WebElement companyBoxElement;
    @FindBy(xpath = "//*[@name='address_1']")
    WebElement addressBox1Element;
    @FindBy(xpath = "//*[@name='address_2']")
    WebElement addressBox2Element;
    @FindBy(xpath = "//*[@name='city']")
    WebElement cityBoxElement;
    @FindBy(xpath = "//*[@name='postcode']")
    WebElement postCodeBoxElement;
    @FindBy(xpath = "//select[@name='country_id']")
    WebElement countryDropDown;
    @FindBy(xpath = "//select[@name='zone_id']")
    WebElement regionStateDropDown;
    @FindBy(css = "button#button-shipping-address")
    WebElement continueButton;
    @FindBy(id = "error-shipping-firstname")
    WebElement firstnameErrorMessage;
    @FindBy(id = "error-shipping-lastname")
    WebElement lastnameErrorMessage;
    @FindBy(id = "error-shipping-address-1")
    WebElement address1ErrorMessage;
    @FindBy(id = "error-shipping-city")
    WebElement cityErrorMessage;
    @FindBy(id = "error-shipping-zone")
    WebElement regionStateErrorMessage;
    @FindBy(id = "error-shipping-country")
    WebElement countryErrorMessage;
    @FindBy(id = "error-shipping-postcode")
    WebElement postCodeErrorMessage;

    /**Shipping Method Elements*/

    @FindBy(css = "button#button-shipping-methods")
    WebElement chooseShippingMethod;
    @FindBy(css = "input#input-shipping-method-flat-flat")
    WebElement flatShippingRateButtonElement;
    @FindBy(css = "button#button-shipping-method")
    WebElement confirmTheShippingMethodElement;
    @FindBy(css = "div#error-shipping-method")
    WebElement shippingMethodErrorMessage;
    @FindBy(css = "button#button-payment-methods")
    WebElement choosePaymentMethod;
    @FindBy(css = "input#input-payment-method-cod-cod")
    WebElement cashOnDeliveryButtonElement;
    @FindBy(css = "button#button-payment-method")
    WebElement confirmThePaymentMethodElement;
    @FindBy(css = "div#error-payment-method")
    WebElement paymentMethodErrorMessage;
    @FindBy(xpath = "//button[@class='btn btn-primary'][text()='Confirm Order']")
    WebElement confirmOrderButtonElement;
    @FindBy(css = "textarea#input-comment")
    WebElement inputTextAreaElement;
    @FindBy(xpath = "//*[@id='checkout-confirm']//tbody//a")
    List<WebElement> orderedProductsName;
    @FindBy(xpath = "//*[@id='checkout-confirm']//tbody/tr/td[1]")
    List<WebElement> numberOfEachProduct;
    @FindBy(xpath = "//*[@id='checkout-confirm']//tbody/tr/td[2]")
    List<WebElement> totalAmountOfEachProduct;
    @FindBy(xpath = "(//*[@id='checkout-confirm']//tfoot/tr/td[2])[1]")
    WebElement orderedProductsSub_TotalAmount;
    @FindBy(xpath = "(//*[@id='checkout-confirm']//tfoot/tr/td[2])[2]")
    WebElement orderedProductsEco_TaxAmount;
    @FindBy(xpath = "(//*[@id='checkout-confirm']//tfoot/tr/td[2])[3]")
    WebElement orderedProductsVATAmount;
    @FindBy(xpath = "(//*[@id='checkout-confirm']//tfoot/tr/td[2])[4]")
    WebElement orderedProductsTotalAmount;

    /**
     * Action methods
     */

    public void setFirstname(String firstname){
        firstnameBoxElement.sendKeys(firstname);
    }
    public String  getFirstNameErrorMessage(){
        return firstnameErrorMessage.getText();
    }
    public void setLastname(String lastname){
        lastnameBoxElement.sendKeys(lastname);
    }
    public String  getLastNameErrorMessage(){
        return lastnameErrorMessage.getText();
    }
    public void setAddressBox1Element(String address){
        addressBox1Element.sendKeys(address);
    }
    public String  getAddress1ErrorMessage(){
        return address1ErrorMessage.getText();
    }
    public void setAddressBox2Element(String address){
        addressBox2Element.sendKeys(address);
    }
    public void setCityName(String cityName){
        cityBoxElement.sendKeys(cityName);
    }
    public String  getCityErrorMessage(){
        return cityErrorMessage.getText();
    }
    public void setCountryName(String countryName){
        new Select(countryDropDown).selectByValue(countryName);
    }
    public String  getCountryErrorMessage(){
        return countryErrorMessage.getText();
    }
    public void setRegion_StateName(String regionStateName){
        new Select(regionStateDropDown).selectByValue(regionStateName);
    }
    public String  getRegion_StateErrorMessage(){
        return regionStateErrorMessage.getText();
    }
    public void setPostCode(String postCode){
        postCodeBoxElement.sendKeys(postCode);
    }
    public String  getPostCodeErrorMessage(){
        return postCodeErrorMessage.getText();
    }
    public void setCompanyName(String companyName){
        companyBoxElement.sendKeys(companyName);
    }
    public void setShippingMethod(){
        chooseShippingMethod.click();
        flatShippingRateButtonElement.click();
        confirmTheShippingMethodElement.click();
    }
    public String getShippingErrorMessage(){
        return shippingMethodErrorMessage.getText();
    }
    public void setPaymentMethod(){
        choosePaymentMethod.click();
        cashOnDeliveryButtonElement.click();
        confirmThePaymentMethodElement.click();
    }
    public String getPaymentErrorMessage(){
        return paymentMethodErrorMessage.getText();
    }
    public String getEmptyShoppingCardMessage(){
        return emptyShoppingCardMessageElement.getText();
    }
    public void addCommentsOnOrderedProducts(String comments){
        inputTextAreaElement.sendKeys(comments+ Keys.ENTER);
    }
    public void clickTheContinueButtonForNextProcess(){
        continueButton.click();
    }
    public void confirmOrder(){
        confirmOrderButtonElement.click();
    }
    public int totalNumberOfProducts(){
        return orderedProductsName.size();
    }
    public String getSub_TotalAmount(){
        return orderedProductsSub_TotalAmount.getText();
    }
    public String getECO_TaxAmount(){
        return orderedProductsEco_TaxAmount.getText();
    }
    public String getVATAmount(){

        return orderedProductsVATAmount.getText();
    }
    public String getTotalAmount(){
        return orderedProductsTotalAmount.getText();
    }

}
