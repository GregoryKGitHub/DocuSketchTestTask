package loginTestSuit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ConfProperties;

import java.time.Duration;

public class DS_02p extends BaseTest    {

    @Test
    public void passwordInputPositiveTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        user = logInDataBuilder
                .email(ConfProperties.getProperty("validEmail"))
                .password(ConfProperties.getProperty("validPassword"))
                .build();

        signInPage.inputEmail(user.getEmail());
        signInPage.nextBtnClick();
        signInPage.inputPassword(user.getPassword());
        signInPage.pwdNextBtnClick();
        wait.until(ExpectedConditions.urlToBe(ConfProperties.getProperty("mainPage")));

        Assert.assertEquals(driver.getCurrentUrl(), ConfProperties.getProperty("mainPage"));
    }
}
