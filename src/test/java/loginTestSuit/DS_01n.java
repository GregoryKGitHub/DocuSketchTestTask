package loginTestSuit;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DS_01n extends BaseTest {
    private final String expectedErrorMsg = "Couldn’t find your Google Account";

    @Test
    public void usernameInputNegativeTest()    {
        Faker faker = new Faker();
        user = logInDataBuilder
                .email(faker.internet().emailAddress())
                .build();

        signInPage.inputEmail(user.getEmail());
        signInPage.nextBtnClick();
        String errorMsg = signInPage.getEmailErrorMsg();

        Assert.assertEquals(errorMsg, expectedErrorMsg);
    }
}
