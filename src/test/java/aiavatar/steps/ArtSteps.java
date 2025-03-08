package aiavatar.steps;

import aiavatar.pages.ArtPage;
import aiavatar.pages.LoginPage;
import aiavatar.utils.AppiumDriverManager;
import io.appium.java_client.AppiumDriver;

public class ArtSteps {
    AppiumDriver appiumDriver = new AppiumDriverManager().getDriver();
    ArtPage artPage = new ArtPage(appiumDriver);

    public void clickButtonAccount(){
        artPage.clickButtonAccount();
    }
}
