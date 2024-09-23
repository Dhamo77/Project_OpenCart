package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutPage extends BasePage {
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
}
