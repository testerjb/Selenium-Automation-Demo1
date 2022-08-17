package practiceYT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/*
 * *******************************************************************
 * This is the Home page for https://www.demoblaze.com/index.html site
 * *******************************************************************
 */

public class HomePage {
    WebDriver driver;

    //Sign in LOGIN button
    By signInButton=By.xpath("//a[contains(text(),'Log in')]");

    //register button
    By signUpLink= By.id("signin2"); //sign up button
    By logo=By.xpath("/html/body/nav[@id='narvbarx']/a[@id='nava']/img/@src");
    By welcomeUser = By.xpath("//ul[@class='navbar-nav ml-auto']/li[@class='nav-item'][6]/a[@id='nameofuser'][contains(text(),'Welcome')]");
    By cart = By.xpath(("//ul[@class='navbar-nav ml-auto']/li[@class='nav-item'][3]/a[@class='nav-link']"));

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public WebElement getLogo(){
        return driver.findElement(logo);
    }
    public WebElement getWelcomeMessg(){return driver.findElement(welcomeUser);}
    public WebElement getRegisterLink(){
        return driver.findElement(signUpLink);
    }
    public WebElement getSignIn(){
        return driver.findElement(signInButton);
    }
    public WebElement getCart(){return driver.findElement(cart);
    }
}
