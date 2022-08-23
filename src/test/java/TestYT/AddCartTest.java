package TestYT;
import Utilities.Helper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import practiceYT.*;

import java.time.Duration;

/*
 * Note for this test, as we don't have control over database this user will be deleted
 */
public class AddCartTest {
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
        //create page objects
        HomePage homePage=new HomePage(driver);
        SignInPage signInPage=new SignInPage(driver);
        Helper helper = new Helper(driver);
        ThankYouPage thankYouPage= new ThankYouPage(driver);

        //------------------
        AddCartPage addCartPage= new AddCartPage(driver);
        CartPage cartPage= new CartPage(driver);
        NextCartPage nextCartPage = new NextCartPage(driver);
        PlacerOrderModal placerOrderModal= new PlacerOrderModal(driver);

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

        Assert.assertEquals("Welcome theCommet",userName);

        Thread.sleep(1000);
        j.executeScript("arguments[0].click();", addCartPage.getCategory());

        String firstItemName = addCartPage.getFirstItem().getText();
       // click in the first product
        addCartPage.getFirstItem().click();

        String selectedItemName = nextCartPage.getSelectedItem().getText();
        Assert.assertEquals(firstItemName,selectedItemName);

        nextCartPage.getAddToCartButton().click();
        //go to Cart page
        homePage.getCart().click();

        String productText = cartPage.getProductName().getText();
        System.out.println("Product Name: " +cartPage.getProductName().getText());
        Assert.assertEquals(selectedItemName,productText);

        //click on Place order button
        cartPage.getPlacerOrderButton().click();

        //forced to click on frame
        j.executeScript("arguments[0].click();", placerOrderModal.getEframe());

        placerOrderModal.getCardHolderName().sendKeys("JillTester");
        placerOrderModal.getCardHolderCountry().sendKeys("United States");
        placerOrderModal.getCardHolderCity().sendKeys("New York");
        placerOrderModal.getCardNumber().sendKeys("378282246310005");
        placerOrderModal.getCardExpirationMonth().sendKeys("01");

        //get the future year and converts it to string
        String sYear = helper.returnFutureYear();
        System.out.println("year > " + sYear);
        placerOrderModal.getCardExpirationYear().sendKeys(sYear);
        //Thread.sleep(2000);
        placerOrderModal.getPurchaseButton().click();

        //Thread.sleep(2000);
        thankYouPage.getOkButton().click();



    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
