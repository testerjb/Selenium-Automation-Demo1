package TestYT;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import practiceYT.*;

import java.time.Duration;

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
        //create home page object
        HomePage homePage=new HomePage(driver);
        //create sign in page
        SignInPage signInPage=new SignInPage(driver);
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
        Assert.assertEquals(selectedItemName,productText);

        //click on Place order button
        cartPage.getPlacerOrderButton().click();

        Thread.sleep(1000);
        //forced to click on frame
        j.executeScript("arguments[0].click();", placerOrderModal.getEframe());

        String modalTitle = placerOrderModal.ModalTitle.getText();
        Assert.assertEquals("Place order",modalTitle );

        //close modal
        j.executeScript("arguments[0].click();", placerOrderModal.getCancelButtonX());
        System.out.println("Rest of the test to be continued");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
