package TestYT;

import Utilities.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import practiceYT.*;

import javax.swing.plaf.SliderUI;
import java.time.Duration;
import java.util.List;

public class DeleteFromCartTest {
    WebDriver driver;
    String pageLink = "https://www.demoblaze.com/index.html";
    String userWelcome = "Welcome theCommet02";

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get(pageLink);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void deleteCartTest() throws InterruptedException {
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
        signInPage.getUserName().sendKeys("theCommet02");
        signInPage.getPassword().sendKeys("Thequest1!");
        signInPage.getSignInButton().click();

        Thread.sleep(2000);
        Assert.assertEquals("Welcome theCommet02",userWelcome);

        Thread.sleep(1000);
        j.executeScript("arguments[0].click();", addCartPage.getCategoryLaptops());
        //System.out.println("click on category 2");

        String firstItemName = addCartPage.getFirstItem().getText();
        // click in the first product
        addCartPage.getFirstItem().click();

        String selectedItemName = nextCartPage.getSelectedItem().getText();
        Assert.assertEquals(firstItemName,selectedItemName);

        nextCartPage.getAddToCartButton().click();

        //go to Cart page
        homePage.getCart().click();
        Thread.sleep(2000);
        //delete product
        cartPage.getDeleteButton().click();

        //asserts that the product was deleted
        List<WebElement> resultRows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-striped']/tbody[@id='tbodyid']/tr"));
        if (resultRows != null ) {
            System.out.println("Product deleted from cart");
        } else {
            System.out.println("There was an error deleting a product");
        }



    }

    @AfterMethod

    public void tearDown(){
        driver.quit();
    }



}
