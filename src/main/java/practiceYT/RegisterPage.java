package practiceYT;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver;

    @FindBy(id= "sign-username")
    public WebElement userName;
    @FindBy(xpath = "//input[@id='sign-password']")
    public WebElement userPassword;
    @FindBy(partialLinkText = "Welcome")
    public WebElement welcomeUser;
    @FindBy(xpath = "//div[@id='signInModal']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-body']")
    public WebElement eFrame;
    @FindBy(xpath ="//div[@class='modal-content']/div[@class='modal-header']/h5[@id='signInModalLabel']")
    public WebElement registerTitle;
    @FindBy (xpath = "(//div[@class='modal-footer']/button[@class='btn btn-primary'])[2]")
    public WebElement registerButton;
    @FindBy (css = "css=#signInModal .btn-primary")
    public  WebElement signUpConfirmationModal;

    public RegisterPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement getSignUpConfirmationModal() {return signUpConfirmationModal;}
    public WebElement getWelcomeUser() {return welcomeUser;}
    public WebElement getRegisterButton() {return registerButton;}
    public WebElement getRegisterTitle() {return registerTitle;}
    public WebElement getEFrame() {return eFrame;}
    public WebElement getUserName(){
        return userName;
    }
    public WebElement getUserPassword() {return userPassword;}
}
