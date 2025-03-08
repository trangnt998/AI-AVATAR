package aiavatar.steps;

import aiavatar.pages.VerifyEmailPage;
import aiavatar.utils.AppiumDriverManager;
import aiavatar.utils.MailUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.Assert;

import java.io.IOException;

import static aiavatar.utils.MailUtils.getEmails;

public class VerifyEmailSteps {
    AppiumDriver<MobileElement> appiumDriver = new AppiumDriverManager().getDriver();
    VerifyEmailPage verifyEmailPage = new VerifyEmailPage(appiumDriver);


    public void appearScreenVerificationCode(String email) throws IOException {
        String expTitle = "Register";
        String expContent = "Verification code sent to email " + email;

        String actTitle = verifyEmailPage.getTitleScreen();
        String actContent = verifyEmailPage.getContentScreen();

        Assert.assertEquals(actTitle, expTitle);
        Assert.assertEquals(actContent, expContent);
    }

    public String getVerificationCode() {
        String emailContent = MailUtils.getEmails();
        return MailUtils.extractOTP(emailContent);
    }

    public void fillVerificationCode() throws InterruptedException {
        Thread.sleep(15000);
        String code = getVerificationCode();
        verifyEmailPage.inputTextboxVerifycationCode(code);
    }


}
