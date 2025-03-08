package aiavatar.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class VerifyPhonePage {
    private AppiumDriver<MobileElement> appiumDriver;

    public VerifyPhonePage(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    By titleScreen = By.id("com.wallet.walkthedog:id/lblTitle");

    By buttonCancel = By.xpath("//android.widget.Button[@resource-id='cancel']");

    public void clickTitleScreen(){
        appiumDriver.findElement(titleScreen).click();
    }

    public void clickButtonCancel(){
        appiumDriver.findElement(buttonCancel).click();
    }



}
