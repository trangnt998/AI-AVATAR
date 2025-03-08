package aiavatar.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginPage {
    private AppiumDriver<MobileElement> appiumDriver;

    public LoginPage(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    By textboxEmailNotFocus = By.id("com.wallet.walkthedog:id/lblFakeTitle");
    By textboxEmailFocus = By.id("com.wallet.walkthedog:id/txtContent");
    By buttonNext = By.id("com.wallet.walkthedog:id/view_sign_in");
    By buttonGoogle = By.id("com.wallet.walkthedog:id/btnLoginGoogle");
    By buttonFacebook = By.id("com.wallet.walkthedog:id/btnLoginFacebook");



    public void inputEmail(String email) throws InterruptedException {
        appiumDriver.findElement(textboxEmailNotFocus).click();
        appiumDriver.hideKeyboard();
        System.out.println("Click textbox email success");
        appiumDriver.findElement(textboxEmailFocus).sendKeys(email);
    }

    public void clickButtonNext() {
        appiumDriver.findElement(buttonNext).click();
    }

    public void clickButtonLoginByGoogle(){
        appiumDriver.findElement(buttonGoogle).click();
    }

}
