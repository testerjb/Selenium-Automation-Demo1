package Tests;

import Utilities.Helper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.RegisterPage;
import java.time.Duration;

public class RegisterTest {
    WebDriver driver;
    String pageLink = "https://www.demoblaze.com/index.html";

    @BeforeMethod
    public void setUp(){
    	System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
    	ChromeOptions opt = new ChromeOptions();
    	opt.addArguments("--remote-allow-origins=*");
    	// Launching the browser    	   	    	        
        driver=new ChromeDriver(opt);     
        driver.get(pageLink);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void registerTest() throws InterruptedException {
        //create page objects
        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        Helper helper = new Helper(driver);

        String randomNum = helper.randInt();
        String inputUser = "theCommet" +randomNum;
        String inputPass = "thedash111";

        //Click register button
        homePage.getRegisterLink().click();

        registerPage.getUserName().sendKeys(inputUser);
        registerPage.getUserPassword().sendKeys(inputPass);
        System.out.println("User created is :" + inputUser);
        registerPage.getRegisterButton().click();

        //Waits for alert, using ignoring since the alert cannot be caught
        new WebDriverWait(driver, Duration.ofSeconds(60)).ignoring(NoAlertPresentException.class)
                .until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text : " + alert.getText());
        Assert.assertEquals(alert.getText(),"Sign up successful.");
        alert.accept();
    }


    /* This test is used in order to test SignInTest since we don't have control over the test database
     * the user will be deleted eventually by the site admin
     */
    //@Test
    public void createSignInUser(){
        //create page objects
        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        Helper helper = new Helper(driver);

        String inputUser = "theCommet" ;
        String inputPass = "Thequest1";

        //Click register button
        homePage.getRegisterLink().click();

        registerPage.getUserName().sendKeys(inputUser);
        registerPage.getUserPassword().sendKeys(inputPass);
        System.out.println("user created is : " + inputUser);
        registerPage.getRegisterButton().click();

        //Waits for alert, using ignoring since the alert cannot be caught
        new WebDriverWait(driver, Duration.ofSeconds(60)).ignoring(NoAlertPresentException.class)
                .until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text : " + alert.getText());
        Assert.assertEquals(alert.getText(),"Sign up successful.");
        alert.accept();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
