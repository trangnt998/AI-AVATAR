package aiavatar.steps;

import aiavatar.pages.LoginPage;
import aiavatar.pages.VerifyPhonePage;
import aiavatar.utils.AppiumDriverManager;
import io.appium.java_client.AppiumDriver;

public class VerifyPhoneSteps {
    AppiumDriver appiumDriver = new AppiumDriverManager().getDriver();
    VerifyPhonePage verifyPhonePage = new VerifyPhonePage(appiumDriver);

    public void cancelVerifyPhoneNumber() throws InterruptedException {
        Thread.sleep(5000);
        verifyPhonePage.clickTitleScreen();
        verifyPhonePage.clickButtonCancel();
    }
}
