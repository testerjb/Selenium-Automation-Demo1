package TestYT;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import practiceYT.HomePage;
import practiceYT.RegisterPage;
import java.time.Duration;

public class RegisterTest {
    WebDriver driver;
    String pageLink = "https://www.demoblaze.com/index.html";
    String userName = "Welcome theCommet";

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver=new ChromeDriver();

        driver.get(pageLink);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void signInTestcase() throws InterruptedException {
        //create home page object
        HomePage homePage = new HomePage(driver);
        //create register page
        RegisterPage registerPage = new RegisterPage(driver);

        //Login the application
        homePage.getSignIn().click();
        Thread.sleep(1000);
        registerPage.getEFrame().click();
        registerPage.getUserName().sendKeys("theCommet");
        registerPage.getEFrame().sendKeys("Thequest1!");

        //forced to click on sign-in frame
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].click();", registerPage.getEFrame());

        Assert.assertTrue(driver.getCurrentUrl().contains(pageLink));

        Assert.assertEquals("Welcome theCommet",userName);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
