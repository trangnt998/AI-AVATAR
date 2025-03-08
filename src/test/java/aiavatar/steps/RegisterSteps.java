package aiavatar.steps;

import aiavatar.pages.RegisterPage;
import aiavatar.utils.AppiumDriverManager;
import io.appium.java_client.AppiumDriver;

public class RegisterSteps {
    AppiumDriver appiumDriver = new AppiumDriverManager().getDriver();
    RegisterPage registerPage = new RegisterPage(appiumDriver);

    public void fillPasswordAndConfirmPasswordAndContinue(String password, String confirmPassword){
        registerPage.inputPassword(password);
        registerPage.inputConfirmPassword(confirmPassword);
        registerPage.clickButtonContinue();
    }

}
