package aiavatar.tests;

import aiavatar.bases.BaseTest;
import aiavatar.steps.*;
import aiavatar.utils.MailUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegisterTest extends BaseTest {

    @Test
    public void registerAccountSuccess() throws InterruptedException, IOException {
        LoginSteps loginSteps = new LoginSteps();
        RegisterSteps registerSteps = new RegisterSteps();
        VerifyEmailSteps verifyEmailSteps = new VerifyEmailSteps();
        VerifyPhoneSteps verifyPhoneSteps = new VerifyPhoneSteps();
        ArtSteps artSteps = new ArtSteps();
        AccountSteps accountSteps = new AccountSteps();

        String email = MailUtils.getTemporaryEmail();
        String password = "123456";
        String confirmPassword = "123456";

        loginSteps.loginWithNewEmail(email);
        registerSteps.fillPasswordAndConfirmPasswordAndContinue(password, confirmPassword);
        verifyEmailSteps.appearScreenVerificationCode(email);
        verifyEmailSteps.fillVerificationCode();

        verifyPhoneSteps.cancelVerifyPhoneNumber();
        artSteps.clickButtonAccount();
        accountSteps.verifyEmailAccount(email);
    }

    @Test
    public void registerBByGoogle() {

    }
}
