package practiceYT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver;

    @FindBy(xpath = "//input[@id='sign-username']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='sign-password']")
    public WebElement userPassword;
    //By SignIn=By.xpath("//a[@title='Already a user? Sign in']");

    @FindBy(xpath = "(//button[@class='btn btn-primary'])[3]")
    public WebElement signUpButton;

    @FindBy(xpath = "//div[@id='signInModal']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-body']")
    public WebElement eFrame;

    public RegisterPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public WebElement getEFrame() {return eFrame;}
    public WebElement getSignUpButton() {return signUpButton;}
    public WebElement getUserName(){
        return userName;
    }
    public WebElement getUserPassword() {return userPassword;}
}
