package aiavatar.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class RegisterPage {
    private AppiumDriver<MobileElement> appiumDriver;

    public RegisterPage(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    By textboxEmail = By.id("com.wallet.walkthedog:id/txtContent");

    By textboxPassword = By.xpath("(//android.widget.RelativeLayout[@resource-id='com.wallet.walkthedog:id/rootView'])[2]/android.widget.LinearLayout");
    By textboxConfirmPassword = By.xpath("(//android.widget.RelativeLayout[@resource-id='com.wallet.walkthedog:id/rootView'])[3]/android.widget.LinearLayout");
    By buttonContinue = By.id("com.wallet.walkthedog:id/btnConfirm");


    public void inputPassword(String password){
        appiumDriver.findElement(textboxPassword).click();
        Actions actions = new Actions(appiumDriver);
        actions.sendKeys(password).perform();
    }
    public void inputConfirmPassword(String confirmPassword){
        appiumDriver.findElement(textboxConfirmPassword).click();
        Actions actions = new Actions(appiumDriver);
        actions.sendKeys(confirmPassword).perform();
    }

    public void clickButtonContinue(){
        appiumDriver.hideKeyboard();
        appiumDriver.findElement(buttonContinue).click();
    }
}
