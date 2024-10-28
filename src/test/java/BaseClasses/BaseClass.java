package BaseClasses;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class BaseClass  {
    public static WebDriver driver;
    public  SoftAssert softAssert;
    public Properties properties;
    protected static Logger logger ;

    @BeforeSuite
    void beforeSuit(){
        logger=Logger.getLogger(this.getClass());
        PropertyConfigurator.configure("D:\\java files\\selinium\\Selenium _intellij_IDE\\OpenCart\\src\\test\\resources\\Log4j.properties");
        logger.info("Starting the Test Suite.....");
    }
    @BeforeClass
    public void setUp(){
        if (logger == null) {
            logger=Logger.getLogger(this.getClass());
            PropertyConfigurator.configure("D:\\java files\\selinium\\Selenium _intellij_IDE\\OpenCart\\src\\test\\resources\\Log4j.properties");
        }
        logger.info("SetUp Basic things.....");
        try {
            FileInputStream fileInputStream=new FileInputStream("D:\\java files\\selinium\\Selenium _intellij_IDE\\OpenCart\\src\\test\\resources\\config.properties");
            properties=new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        softAssert=new SoftAssert();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(properties.getProperty("url"));
        Cookie[] cookies = {
                new Cookie("cf_clearance", "j74OQeO0eJYm6i1fNBv24m.cjjjZ_AHclTEU3kSbipA-1727357986-1.2.1.1-xxUCWQyo6TnaXzXaMvjgy1kcZy7rvTukFwhCsc282HdlwD7bT2juPLpIYZfbgQzAq29w2h0ZUgSM2yxrsUeyUNYAcjBwO2NXAvDEjvcta_ptIJ7_zEwoin1cIEFBcx13zdhL2KFJ2wa4jO1Kgn_ulw39nR1qcgZbIqU8yqd8m3NMPUSzej6iyDbLs4SzQ8jWRRs67UiwriGrorltr1B1QdoHkZpeaYlAfoZ0M_pGlXd44WLPkLRksR3Y_0_2ZZ0fyHVozBJ3_zl5ekveHNXrWGs6I7mwC9Y9RgY5369vKv1izSKpFS2G7Nei2y.DzVslJgwNZWPSwTSYJayy.Aj_zXrVL778lFynqwBr9q025MSxfmZCC7ahCMlLZ5qzApOspcxv1ZroiTk3OZ2dyx6lDQ"),
                new Cookie("cf_clearance", "QDOPPaOuaAzfcAj4AaRCLafzOtv9Qx7gXV.owR1GLTk-1727359352-1.2.1.1-UP1vEsEUirbq5NfKRR8Xi8fQjSM8XwVzVBdpuSdon_oGSLb9ZlwdFMwI9d0ixDlrqB8OxhQBFSt41l8hIyfVgL0pOgNS3JQ1DMZ.7XY2qw6zhRpplf4MjCWkLUMwza.HzInRl8o1eZiiwf1GfA1.v9.hYFZVwWt5Gdpba3S5PIK8OcPHyXJV0ENxfeo4eFJJsjKxPgBnpw.dvKue0JcjDHIIY2rv5RY9YUJYW6rkXH49YmlYGvi7xn3tqDLj4JsVcX1CwIADrf12R9na1ePecuDGjD1BgZC1X5pXF05NHuYrDK5Ib3E.YBHosHH8hw1Aqp11VQ3mFmFxLggCJnONmLMvLPkDGE35jetBev2r9gGRl02UHcoqdLC6VkNZN24IVLVdl0gCI1pO5K_zFcJy8w"),
                /* new Cookie("cf_clearance", "JG5gqCH_LIb_1ZUKj5Qki0qlkFYBlfR9xC_Ymkx4pqE-1727357496-1.2.1.1-fhJdT1xrz2S7ggSPztz53m72TvAU.WzHpKgIJnBqpPF3.HRyWQCF8Ewx.7cjuHloxx7tVJH9C8XQ.mWd3sbbDrErb_14tJAmHQCOTSmJ7b8YhTYIl_uAmXBsdXDsX2AGpXNMm6U924zT5EWpiPPHfkBkTy35Z5ifmpVIBWxmssb3qU47qBCWtKckDJQuH5KlHKCrDwCfUtPra1pdTnR2ZBk1CBbXgyJF1ZKbbdOsSIP8iuCXCJTrrxykwmmi6o9AsfDBZ42LfW1RPddxYj29O6czmbWW4W5HHBmJ1KxhgcD82SsCD4yo5dD0UezX8lckeNeTJGjtcLo6HlNBGKcHtKSvbBB17LcjNQPYXtXWLirYQmi1mTJkYAA0gFqpMrkM_oW1E23X4lY10d.fvWAMJA"),
                 new Cookie("cf_clearance", "7eD0eHdniIW33yBhZofpCy2a71ciAwuXk6rwIq7Tb38-1727357954-1.2.1.1-JnBzUqjfhYGwBSiwpktaGUC95TORLQa0nIpMHyeZs.g9ZuEIyFetj5WNRLCaye4sRXOkgAUwcEJ8Sy8Z6kQeQtbkrUhpDOtVWNap23d748XmgLlZfbCSbVCZP9Kurb79uMS_QjPvp37FeZIAv_dxdRIFu.Kwbg6feo0KjXAqwZBRtcdp6W9mNGtzXX6VGRKwA.kcvbYOhs0QUEWG4M3EoPICodli_KfqnRU0h2LYFVwG7wu8Y6L9NeV6204.GcGVncydXBi0LhocjYnsLeZVbwA0WJkuWhoV86H4MdsymXD76ZsV4k4myVx8jEf9vC3N6keUCKQi9FB4cHNqb2D0XEHWwIgCGGiUJj.QfbXPPa06jiw6qBcAEaIG0R1OtIwssNbKQgO55T933G65HAL5BQ"),
                 new Cookie("cf_clearance", "UJW4jXIgI257.LQiNrsRoOAOXoMi3IBgrvkw5JzVxRI-1727359386-1.2.1.1-kqAyf2tQOBgt7kcY6LXyitwzdYJLYCaDgIyQ8uF81.ilE6J.WJOdW0rK8rKj9NBCy10pTvbB4SG_c8CTOSFigQC5hGfcBMVaydpZe3i0XhY8hfQab52LLCAuWKWJu9sHFLnpcTDIscbDBMD.RtVnuORmL5Tt.q4VEFA7mZdhfJfCj9Q2iL_OzsxDxtxj3E8IDx4OVxlMNaQtZea3la1zI8VAriE51YKopGBqu8rGKe7oAMsLhezUfnHxpFqzzeHrW09tHYeLBRR9iwkQiISWiu_P5BKA8qtqSLoox2k12xbQLZgiqDGeAWlH4pK.EzF8DPHWTYbxEiEHKgXqLicd3XjbJY686PPva6xy.yzHg4PJd8bSdPRA2ohJUGPEfAZDnFufVw_nSY00WvfIoeCAbA"),
                 new Cookie("cf_clearance", "ESup8f3kN02K9a2IJvznd5VBsHOoz9J834TQ3qC9cGA-1727359961-1.2.1.1-OlJi3M0VqpyZTSbPRQNc4RQdGPZfvT5AgFspJYgL1cThLPLI1kMwS_3feVFMfoY54PG_TXIZwbQDmuf9GEVT0.3FHt4gr42QpKwf2ilHFiV04Sz1sFM7jW0QcmuQh.fOdjAVOi21Lq9i2Lg5PHj8eks_ro1aUiHv_aqQ886T0mfEAwFIIQ3hdpegZSlxrHdR.SYJJElwu4lptmuvB_xrF3M35_Aq_4aBGJe5IyYv9MlLCKhBxhK65.Ylapj3zmbMgUZ.qQH7ctXetFXF_CEUwdwaQ_v_odAMeLS43lpvnJ4COyQ1bx3kSuGhKi95T5stXvr9CQg3eplUVMv4d3ilBEvnHSmNEtSiXPGgRVqgHodCFwuoqK0fkJ60CACGE8157PJumRgocmv0QPPjhTA.lQ"),
                 new Cookie("cf_clearance", "KSZFj0mXNemzllywifAuDSyjovxe_6LpjFr9q_K.m4c-1727359982-1.2.1.1-y.faGh1pT2LHDzIBXn4vM6HXEuZrVgBmxT7Tx5GNbVhIWxfDScEZ_89ssJ8Sh1shCHOlI2B73Wo84tZHuqkzYCqA_zJqsHz.43s28ULPK9.PZ3Uc2BJ1lD9TW0H3IpCy940Bqlb4F0ShvuHcTjTHTc.bsprxxLqCgZUckKr.DK91opA4hKo6QGOxQY5wjIW8edb2I6c6VTLF.7h87TyXUTNRwLY0VTfXl6jCG4kaHhtDI8YGB.elE723Ko6YGgQI5gXecbf0fs.AmfSQVXwYGVUfKfYnUjUR38AULmJ5dNJ7ZHQQ1mQhyD22difEDjw6XOzslN.gPtZ.Hpfs9pLO0K0m17MssGoaeyA04nvq_80VRrBXaWViZF0oQG.8PDsobtjpa7uaSbJ2XsuQ7z35aw"),
                 new Cookie("cf_clearance", "1stedb0JRdVLpojrXcom4cB07ANwvnM8z3rHLaeZu_0-1727360241-1.2.1.1-PL5y37g3_XWrB_TOnEaG9Vt3U81bGHrIq_e5aDIc0V8A1kZxBFgX6LCBjIOZm.APQ1NUp2odXkSDYPRZRVL2l7TIKTKg85rBnIi2Lf2Hp_5zEbDlbHXv.j_RJU1uWg7nLnkvXuIPiosPj4f4s6iTSB8Ey4MWE0oWo_bWpey0CZQgt.fMcc5fZbBwmcQKUcN8.R5GXFGlYg761IKpGUCoJho_GxBlFKMNivVPf_dU6wbcv4TRqFHu_4iQsqXeTjFdHqib26TiQdcJ93a7MpEvqY4Q.aMopY5rxhA87f2pN6Vg_jUNjyW6fHS99iVwSnmfbxRIDoQrxTtP3W4b8sOwgxMpLx8V3E6Z6AksiCFf1dmInOhDFzfpZZBzt_epH_ExtkvX7YmS8QcfBCvDnRE5yA"),
                 new Cookie("cf_clearance", "QCMvKeLmVHp42Z7AobV5KasFwEteafcLXl_onR5UaPM-1727360203-1.2.1.1-v.9b6mGVOSDrZUl1PqngGG94ZsNYZvXrRxBLpeYsD3z23tgNMm4cQa_LlruDfnhhENKcHmd6iDEtC1Vk13dJr.R6ngHaIH2GDoaqS2S0PNEBeBlb8kYKPr4NHAsnVPjDvXePZBod9i0W94gv2qNIBr6EN9zIkAGMywAWxV1WlFrQdLo3uiq0WmcQu.keo3VEqSW_TJMGmqGZvkMLcGB7eWTEZTvdOBwP5nEIDIavyv7dxyfSnH42XhJ7R02.31v_3lVBGLQAigU7L2qf90os9xFEx2Lzie006OLyCNdbXZIf3jIBW_XaOJ596ORuHHxaf2Zzzd3M9kTJctbbmxqfueajsF8Qv_TZLyS57Fc6dSTUmbS0yRby0lUxl9vr_ZQ4P68_BJAZwuMTA.i.NOHKZw"),
                 new Cookie("cf_clearance", "RxtM1Wcw3j80mKUITUdw8BOb9BmKzlxNlVszjLVresE-1727360849-1.2.1.1-48FXXbG0GLbRbUBGfOv3qA96PwJXeR86n621QXjYFG1rDjaok2CH_C8tKnSMZwOA878ih5ovwNTIsVStKhX1uo10UYUG5iHqa6wSt76lr_Uo1m.dTHq_ibtmKq_RXey96QuOCIKLNo_nhgCLhamgBqWhYunU0K4UmQtXbqJTocu1HvRqDrgJe2SuqgUueNJCw4fvn4miomkEYxU8D6NUQ6KxPUNM1jwYfNyEtWXt13fSYLISqDRyCVh9eDOnU5tbCbI6FvXwouFHj.m6.LQZYRfNaVXB6x7xdVPoeM4udv4TiZxGCTNG7flN4gIE2GMyzB6AXo455ddfSZhK5qsH4ZK.xjs2z9mmAFpjZeLqFBk2UIZt5ab394mjbLzc45zVXCiaDbT3tWXjSeyld.Ardg"),
                 new Cookie("cf_clearance", "q5p5okoaFfdqoh.VFJ4P1JQ9DaoDz3dqrtWm1MeWexk-1727360862-1.2.1.1-of6JFDTvRiFD_PzBjLZi.ehbbPxZ5qh2IPcOtLynTh0TLi7disFDiHntDKJQcAq7mMzhGmLgrQiSf3n9GewR8vHph8XGVRNej6h5ExGT4a1bWtQNFEUnnX65Ebvsx6JBoNLo_LbA2z5mYIfgGBhcqYWqdGSS.5Tp6KSUqeM2jUmLuTGyfEZT5QbE.ggAwGEjXwYSKY90apKiFDusp80jpQjwKU4lCINyU8cS.1E3AWUWMfv4nXb.19mJukoSM5o4J7a5_jHu1nCvuuZbKqRvV9z66W65otRFNsvVaLP0qJiz1iKQntKJmmVf3y9NtWlwuRdYTNcamCog0YO6Fja3zl2sMkhplJSECPn764spwO0yr7jC5_oONFszPVL6tyUS_r9KLQDF6e7L4dGAlIRnqw"),
                 new Cookie("cf_clearance","hX1CzAolPqK8oVqWNduUFEikgRFTCDXZEfnUZtXpn28-1727370643-1.2.1.1-SLE8T4grfT1wedNBATiO9FX3K877BBthni5UVfg6JuuGqgYYf.5tSWyKmze3mIqyfWZu7j3ouiGVw6CWOMOyDrphTAFR_tM.j4NPX52PI48ZDRP9j8Kc6hBqbfblgkZ3HFjaK2KA168ZJfmyan3Lc1OGUn4.fsrDPL4JkVuXGJcCGLtukFKksEhwDbsOw6XMeLeaRe_TmZDYvdPfW2XH_SE5G6Jd8Ya8N3jvjJY7zN2UwPqRJrI.POQt0uMRMBR.KlzyPhxFgYPp1VBcyYU4odwKsjHqdDFbV44a52AI11G5J7_Aj0Yom.w7F_vLc.kHKwFWe1yquC9AiLUJIlw2ac.8Qw5XpyrrqMM5uA5qdAnhMxQ_WQOyn6j2R.jDWXds"),
                 new Cookie("cf_clearance","9Xcge7WnDmq6AeR0Zc2H7ICS4676LXLWsb.FVrAsD4M-1727370620-1.2.1.1-TpLYYMw98yRAtOw7cckP6OF3VWGtIY.z4l4AI2BRKbmWjD50dwsJrQRxUhw9ORemvmAmnbUmycUdbcYM5mdjn69wEtSa_ZcNF6FWiv.irW1lcA2QrrxLWpatgZaqvBOiekDpHCyqtNFsEStXLN0ZvhuvB7px.j_5fj3OGy4Spq50LG3rvrqb_kCvZb3Rmq.3xC3cKt8h2y4QaW4Yq2fKvXkv5U84V8r2Qbq6nl3sFyw7yaNX8pKkPeU7uOt3yvJQeY3_6bSsO8rr9Vh3sbtPv2sDGontZ_exBLWMT1G5f9IbO.6n1M86AG8.aDZYrJKeR3KefH3B_2xDpg8xnkoyY4ijwwCzPaeN5IO6rPdmsHHqWrCmCtjDD9PuKX0RHVaD"),
        */ };

        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }

        driver.navigate().refresh();
        driver.manage().window().maximize();
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    public String ScreenShotCapture(String testName){
        String formattedDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MMM-dd_HH-mm-ss"));
        String target = "D:\\java files\\selinium\\Selenium _intellij_IDE\\OpenCart\\screenshorts\\" + testName + "_" + formattedDateTime + ".png";
        try {
            File location=new File(target);
            Robot robot =new Robot();
            Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle rectangle=new Rectangle(dimension);
            BufferedImage image=robot.createScreenCapture(rectangle);
            ImageIO.write(image,"png",location);
        } catch (AWTException | IOException e) {
            e.getMessage();
        }
        return target;
    }

}
