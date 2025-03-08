package aiavatar.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class ArtPage {

    private AppiumDriver<MobileElement> appiumDriver;

    public ArtPage(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }


    By buttonAccount = By.id("com.wallet.walkthedog:id/imvUserAvatar");

    public void clickButtonAccount(){
        appiumDriver.findElement(buttonAccount).click();
    }

}
