package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllRightColumnOptions extends BasePage{
    public AllRightColumnOptions(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='list-group mb-3']/a[text()='Login']")
    WebElement loginLink;
    @FindBy(xpath = "//div[@class='list-group mb-3']/a[text()='Register']")
    WebElement registerLink;
    @FindBy(xpath = "//div[@class='list-group mb-3']/a[text()='Forgotten Password']")
    WebElement forgottenPasswordLink;
    @FindBy(xpath = "//div[@class='list-group mb-3']/a[text()='My Account']")
    WebElement myAccountLink;
    @FindBy(xpath = "//div[@class='list-group mb-3']/a[text()='Address Book']")
    WebElement addressBookLink;
    @FindBy(xpath = "//div[@class='list-group mb-3']/a[text()='Wish List']")
    WebElement wishListLink;
    @FindBy(xpath = "//div[@class='list-group mb-3']/a[text()='Order History']")
    WebElement orderHistoryLink;
    @FindBy(xpath = "//div[@class='list-group mb-3']/a[text()='Downloads']")
    WebElement downloadsLink;
    @FindBy(xpath = "//div[@class='list-group mb-3']/a[text()='Subscriptions']")
    WebElement subscriptionsLink;
    @FindBy(xpath = "//div[@class='list-group mb-3']/a[text()='Reward Points']")
    WebElement rewardPointsLink;
    @FindBy(xpath = "//div[@class='list-group mb-3']/a[text()='Returns']")
    WebElement returnsLink;
    @FindBy(xpath = "//div[@class='list-group mb-3']/a[text()='Transactions']")
    WebElement transactionsLink;
    @FindBy(xpath = "//div[@class='list-group mb-3']/a[text()='Newsletter']")
    WebElement newsletterLink;
    @FindBy(xpath = "//div[@class='list-group mb-3']/a[text()='Password']")
    WebElement passwordLink;
    @FindBy(xpath = "//div[@class='list-group mb-3']/a[text()='Logout']")
    WebElement logoutLink;
    @FindBy(xpath = "//div[@class='list-group mb-3']/a[text()='Edit Account']")
    WebElement editMyAccountLink;

    /**
     * Actions methods
     */


    public void navigateToLoginPage(){
        wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        loginLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Returning Customer']")));

    }

    public void navigateToRegistrationPage(){
        wait.until(ExpectedConditions.elementToBeClickable(registerLink));
        registerLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Register Account']")));
    }
    public void navigateToMyAccountPage(){
        wait.until(ExpectedConditions.elementToBeClickable(myAccountLink));
        myAccountLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='My Account']")));

    }
    public void navigateToAddressBookPage(){
        wait.until(ExpectedConditions.elementToBeClickable(addressBookLink));
        addressBookLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Address Book Entries']")));
    }

    public void navigateToMyWishlistPage(){
        wait.until(ExpectedConditions.elementToBeClickable(wishListLink));
        wishListLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='My Wishlist']")));
    }

    public void navigateToOrdersPage(){
        wait.until(ExpectedConditions.elementToBeClickable(orderHistoryLink));
        orderHistoryLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Orders']")));
    }

    public void navigateToDownloadsPage(){
        wait.until(ExpectedConditions.elementToBeClickable(downloadsLink));
        downloadsLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Downloads']")));
    }

    public void navigateToSubscriptionsPage(){
        wait.until(ExpectedConditions.elementToBeClickable(subscriptionsLink));
        subscriptionsLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Subscriptions']")));
    }

    public void navigateToRewardPointsPage(){
        wait.until(ExpectedConditions.elementToBeClickable(rewardPointsLink));
        rewardPointsLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Your Reward Points']")));
    }

    public void navigateToProductReturnsPage(){
        wait.until(ExpectedConditions.elementToBeClickable(returnsLink));
        returnsLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Product Returns']")));
    }

    public void navigateToYourTransactionsPage(){
        wait.until(ExpectedConditions.elementToBeClickable(transactionsLink));
        transactionsLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Your Transactions']")));
    }

    public void navigateToNewsletterPage(){
        wait.until(ExpectedConditions.elementToBeClickable(newsletterLink));
        newsletterLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Newsletter Subscription']")));
    }

    public void navigateToForgotPasswordPage(){
        wait.until(ExpectedConditions.elementToBeClickable(forgottenPasswordLink));
        forgottenPasswordLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Forgot Your Password?']")));
    }

    public void navigateToPasswordPage(){
        wait.until(ExpectedConditions.elementToBeClickable(passwordLink));
        passwordLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Change Password']")));
    }

    public void navigateToLogoutPage(){
        js.executeScript("arguments[0].scrollIntoView(true);",logoutLink);
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        logoutLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Account Logout']")));
    }

    public void navigateToEditMyAccountPage(){
        wait.until(ExpectedConditions.elementToBeClickable(editMyAccountLink));
        editMyAccountLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='My Account Information']")));
    }
}
