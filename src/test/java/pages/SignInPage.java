package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ConfProperties;

import java.time.Duration;

public class SignInPage {
    private final WebDriver driver;

    private final WebDriverWait wait;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInputField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInputField;

    @FindBy(id = "identifierNext")
    private WebElement nextBtn;

    @FindBy(id = "passwordNext")
    private WebElement pwdNextBtn;

    @FindBy(xpath = "//form[@method='post']//div[2]/div[2]")
    private WebElement wrongEmailMsg;

    @FindBy(xpath = "//div[@aria-live='assertive']")
    private WebElement wrongPwdMsg;

    @FindBy(id = "forgotPassword")
    private WebElement passwordPageApprove;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    public void inputEmail(String email)    {
        emailInputField.sendKeys(email);
    }

    public void inputPassword(String password)  {
        wait.until(ExpectedConditions.visibilityOf(passwordInputField));
        passwordInputField.sendKeys(password);
    }

    public void nextBtnClick()  {
        nextBtn.click();
    }

    public MainPage pwdNextBtnClick()   {
        pwdNextBtn.click();
        return new MainPage(driver);
    }

    public String getEmailErrorMsg()   {
        wait.until(ExpectedConditions.visibilityOf(wrongEmailMsg));
        return wrongEmailMsg.getAttribute("outerText");
    }

    public String getPasswordErrorMsg() {
        wait.until(ExpectedConditions.visibilityOf(wrongPwdMsg));
        return wrongPwdMsg.getAttribute("outerText");
    }

    public String getPasswordPageApprove()  {
        wait.until(ExpectedConditions.visibilityOf(passwordPageApprove));
        return passwordPageApprove.getAttribute("outerText");
    }
}
