package TestYT;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import practiceYT.HomePage;
import practiceYT.SignInPage;

public class SignInTest {
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
        HomePage homePage=new HomePage(driver);
        //create sign in page
        SignInPage signInPage=new SignInPage(driver);

        //Login the application
        homePage.getSignIn().click();
        Thread.sleep(1000);
        //forced to click on sign-in frame
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].click();", signInPage.getEframe());

        signInPage.getEframe().click();
        signInPage.getUserName().sendKeys("theCommet");
        signInPage.getPassword().sendKeys("Thequest1!");
        signInPage.getSignInButton().click();

        Assert.assertTrue(driver.getCurrentUrl().contains(pageLink));
        //Assert.assertEquals(userLabelText,userName);
        Assert.assertEquals("Welcome theCommet",userName);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}


