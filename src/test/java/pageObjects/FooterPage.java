package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FooterPage extends BasePage{
    public FooterPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "a[href$='terms']")
    WebElement termsConditionsElement;
    @FindBy(css = "a[href$='delivery']")
    WebElement deliveryInformationElement;
    @FindBy(css = "a[href$='about-us']")
    WebElement aboutUsElement;
    @FindBy(css = "a[href$='privacy']")
    WebElement privacyPolicyElement;
    @FindBy(xpath = "//*[@class='list-unstyled']//*[contains(@href,'contact')]")
    WebElement contactUsElement;
    @FindBy(css = "a[href$='returns.add']")
    WebElement returnsElement;
    @FindBy(css = "a[href$='sitemap']")
    WebElement siteMapElement;
    @FindBy(css = "a[href$='brands']")
    WebElement brandsElement;
    @FindBy(css = "a[href$='voucher']")
    WebElement giftCertificatesElement;
    @FindBy(css = "a[href$='affiliate']")
    WebElement affiliateElement;
    @FindBy(css = "a[href$='special']")
    WebElement specialsElement;
    @FindBy(css = "a[href$='account']")
    WebElement myAccountElement;
    @FindBy(css = "a[href$='order']")
    WebElement orderHistoryElement;
    @FindBy(xpath = "//div[@class='col-sm-3']//a[contains(@href,'wishlist')]")
    WebElement wishListElement;
    @FindBy(css = "a[href$='newsletter']")
    WebElement newsletterElement;

    /**
     Actions Methods
     **/
    public void navigateToTermsConditionsPage(){
        termsConditionsElement.click();
    }
    public void navigateToDeliveryInformationPage(){
        deliveryInformationElement.click();
    }
    public void navigateToAboutUsPage(){
        aboutUsElement.click();
    }
    public void navigateToPrivacyPolicyPage(){
        privacyPolicyElement.click();
    }
    public void navigateToContactUsPage(){
        contactUsElement.click();
    }
    public void navigateToProductReturnsPage(){
        returnsElement.click();
    }
    public void navigateToSiteMapPage(){
        siteMapElement.click();
    }
    public void navigateToAllBrandsPage(){
        brandsElement.click();
    }
    public void navigateToGiftCertificatesPage(){
        giftCertificatesElement.click();
    }
    public void navigateToAffiliatePage(){
        affiliateElement.click();
    }
    public void navigateToSpecialOffersPage(){
        specialsElement.click();
    }
    public void navigateToMyAccountPage(){
        myAccountElement.click();
    }
    public void navigateToOrderHistoryPage(){
        orderHistoryElement.click();
    }
    public void navigateToWishListPage(){
        wishListElement.click();
    }
    public void navigateToNewsletterPage(){
        newsletterElement.click();
    }
}
