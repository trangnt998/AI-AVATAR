package aiavatar.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class VerifyEmailPage {
    private AppiumDriver<MobileElement> appiumDriver;

    public VerifyEmailPage(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }


    By titleScreen = By.id("com.wallet.walkthedog:id/tv_title_toolbar");
    By contentScreen = By.id("com.wallet.walkthedog:id/tvMessage");
    By textboxVerificationCode = By.xpath("//*[@resource-id='com.wallet.walkthedog:id/rootView']//android.widget.LinearLayout");

    public String getTitleScreen() {
        return appiumDriver.findElement(titleScreen).getText();
    }
    public String getContentScreen(){
        return appiumDriver.findElement(contentScreen).getText();
    }

    public void inputTextboxVerifycationCode(String code) {
        appiumDriver.findElement(textboxVerificationCode).click();
        Actions actions = new Actions(appiumDriver);
        actions.sendKeys(code).perform();
    }

    public void hideAppIntoBackground(){
        appiumDriver.runAppInBackground(Duration.ofSeconds(-1));
    }


}
