package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private final WebDriver driver;

    @FindBy(xpath = "//a[contains(@href, 'accounts')]")
    private WebElement signInBtn;

    public MainPage(WebDriver driver)   {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SignInPage signIn() {
        signInBtn.click();
        return new SignInPage(driver);
    }
}
