package loginTestSuit;

import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ConfProperties;

public class DS_01p extends BaseTest    {
    private final String passwordPageApproveExpected = "Forgot password?";

    @Test
    public void usernameInputPositiveTest()    {
        user = logInDataBuilder
                .email(ConfProperties.getProperty("validEmail"))
                .build();

        signInPage.inputEmail(user.getEmail());
        signInPage.nextBtnClick();
        String passwordPageApproveActual = signInPage.getPasswordPageApprove();

        Assert.assertEquals(passwordPageApproveActual, passwordPageApproveExpected);
    }
}
