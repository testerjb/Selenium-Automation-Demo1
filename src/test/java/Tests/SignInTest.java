package Tests;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.SignInPage;

/*
 * ***********************************************************************************************
 * Note : as we don't have control over database, this user might be deleted eventually, it's that
 * is the case, go and run in RegisterTest the test createSignInUser()
 * ***********************************************************************************************
 */

public class SignInTest {
    WebDriver driver;
    String pageLink = "https://www.demoblaze.com/index.html";
    String userName = "theCommet";
    String expectedWelcome = "Welcome theCommet";
    String password = "Thequest1!";

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get(pageLink);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void signInTestcase()  {
        //create page objects
        HomePage homePage=new HomePage(driver);
        SignInPage signInPage=new SignInPage(driver);

        //Login the application
        homePage.getSignIn().click();

        //forced to click on sign-in frame
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].click();", signInPage.getEframe());

        signInPage.getEframe().click();
        signInPage.getUserName().sendKeys("theCommet");
        signInPage.getPassword().sendKeys(password);
        signInPage.getSignInButton().click();

        Assert.assertTrue(driver.getCurrentUrl().contains(pageLink));
        String welcomeTextPage = homePage.getWelcomeMessg().getText();
        //Assert >> (actual, expected)
        Assert.assertEquals(welcomeTextPage,expectedWelcome);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}


