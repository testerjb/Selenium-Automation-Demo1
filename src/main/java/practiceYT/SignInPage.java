package practiceYT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    WebDriver driver;
    By UserName=By.xpath("//form/div[@class='form-group'][1]/input[@id='loginusername']");
    By Password=By.xpath("//form/div[@class='form-group'][2]/input[@id='loginpassword']");
    By SignInButton=By.xpath("(//button[@class='btn btn-primary'])[3]");
    By eFrame = By.xpath("//div[@id='logInModal']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-body']");

    public SignInPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement getEframe() {
        return driver.findElement(eFrame);
    }

    public WebElement getUserName(){
        return driver.findElement(UserName);
    }

    public WebElement getPassword(){
        return driver.findElement(Password);
    }

    public WebElement getSignInButton(){
        return driver.findElement(SignInButton);
    }
}
