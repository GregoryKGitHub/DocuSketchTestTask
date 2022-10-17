package loginTestSuit;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ConfProperties;

public class DS_02n extends BaseTest    {
    private final String expectedErrorMsg = "Wrong password. Try again or click Forgot password to reset it.";

    @Test
    public void passwordInputNegativeTest()    {
        Faker faker = new Faker();
        user = logInDataBuilder
                .email(ConfProperties.getProperty("validEmail"))
                .password(faker.superhero().name())
                .build();

        signInPage.inputEmail(user.getEmail());
        signInPage.nextBtnClick();
        signInPage.inputPassword(user.getPassword());
        signInPage.pwdNextBtnClick();
        String errorMsg = signInPage.getPasswordErrorMsg();

        Assert.assertEquals(errorMsg, expectedErrorMsg);
    }
}
