package aiavatar.steps;

import aiavatar.pages.AccountPage;
import aiavatar.pages.LoginPage;
import aiavatar.utils.AppiumDriverManager;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;

public class AccountSteps {
    AppiumDriver appiumDriver = new AppiumDriverManager().getDriver();
    AccountPage accountPage = new AccountPage(appiumDriver);

    public void verifyEmailAccount(String expEmail){
        String actEmail = accountPage.getEmail();
        Assert.assertEquals(actEmail, expEmail);
    }
}
