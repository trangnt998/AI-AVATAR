package aiavatar.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class AccountPage {
    private AppiumDriver<MobileElement> appiumDriver;

    public AccountPage(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }


    By labelEmail = By.id("com.wallet.walkthedog:id/lblAccountName");

    public String getEmail(){
        return appiumDriver.findElement(labelEmail).getText();
    }
}
