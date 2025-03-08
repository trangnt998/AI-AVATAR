package aiavatar.steps;

import aiavatar.pages.LoginPage;
import aiavatar.utils.AppiumDriverManager;
import io.appium.java_client.AppiumDriver;

public class LoginSteps {


    AppiumDriver appiumDriver = new AppiumDriverManager().getDriver();
    LoginPage loginPage = new LoginPage(appiumDriver);

    public void loginWithNewEmail(String email) throws InterruptedException {
        loginPage.inputEmail(email);
        System.out.println("Input email success");
        loginPage.clickButtonNext();

    }

    public void clickButtonLoginByGoogle(){
        loginPage.clickButtonLoginByGoogle();
    }

}
