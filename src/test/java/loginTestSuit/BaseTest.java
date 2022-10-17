package loginTestSuit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.SignInPage;
import utility.ConfProperties;
import utility.LogInData;
import utility.LogInDataBuilder;

import java.util.Collections;

public class BaseTest {
    protected WebDriver driver;
    protected MainPage mainPage;
    protected SignInPage signInPage;
    protected LogInData user;
    protected LogInDataBuilder logInDataBuilder = new LogInDataBuilder();

    @BeforeClass
    public void setUp()   {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-gb");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--incognito");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-plugins-discovery");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", null);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("mainPage"));
        mainPage = new MainPage(driver);
        signInPage = mainPage.signIn();
    }

    @AfterClass
    public void closeDriver()  {
        driver.quit();
    }
}
