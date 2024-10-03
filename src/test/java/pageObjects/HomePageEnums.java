package pageObjects;

import org.openqa.selenium.WebDriver;

public class HomePageEnums extends BasePage {
    public HomePageEnums(WebDriver driver) {
        super(driver);
    }
    public enum Currency{
        Euro("€ Euro"), PoundSterling("£ Pound Sterling"), USDollar("$ US Dollar");
        private final String text;
        Currency(String text) {
            this.text=text;
        }
        public String getVisibleText() {
            return text;
        }
    }
    public enum MyAccount{
        REGISTER("Register"),LOGIN("Login");
        private final String text;
        MyAccount(String text) {
            this.text=text;
        }
        public String getVisibleText() {
            return text;
        }
    }
    public enum Desktop{
        PC("PC"),MAC("Mac");
        private final String text;
        Desktop(String text) {
            this.text=text;
        }
        public String getVisibleText() {
            return text;
        }
    }
    public enum LaptopsNotebooks {
        WINDOWS ("Windows"),MACS("Macs");
        private final String text;
        LaptopsNotebooks(String text) {
            this.text=text;
        }
        public String getVisibleText() {
            return text;
        }
    }
    public enum Components {
        MICE_AND_TRACKBALLS("Mice and Trackballs"),MONITORS("Monitors"),PRINTERS("Printers"),
        SCANNERS("Scanners"), WEB_CAMERAS("Web Cameras");
        private final String text;
        Components(String text) {
            this.text=text;
        }
        public String getVisibleText() {
            return text;
        }
        }

}
