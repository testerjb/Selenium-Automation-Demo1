package practiceYT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
    WebDriver driver;

    //demoblaze site
    By logo=By.xpath("/html/body/nav[@id='narvbarx']/a[@id='nava']/img/@src");
    By signInButton=By.xpath("//a[@id='login2']");
    By signUpButton= By.xpath("//a[@id='signin2']");
    By welcomeUser= By.partialLinkText("Welcome");
    By cart = By.xpath(("//ul[@class='navbar-nav ml-auto']/li[@class='nav-item'][3]/a[@class='nav-link']"));

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public WebElement getLogo(){
        return driver.findElement(logo);
    }
    public WebElement getWelcomeMessg(){
        return driver.findElement(welcomeUser);
    }
    public WebElement getRegister(){
        return driver.findElement(signUpButton);
    }
    public WebElement getSignIn(){
        return driver.findElement(signInButton);
    }
    public WebElement getCart(){return driver.findElement(cart);
    }
}
