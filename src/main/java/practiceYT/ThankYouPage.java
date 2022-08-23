package practiceYT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThankYouPage {
    WebDriver driver;

    //Thank you for your purchase!
    //@FindBy(xpath = "//div[@class='sweet-alert showSweetAlert visible']/h2")
    @FindBy(xpath = "//div[@class='sweet-alert showSweetAlert visible']/h2[contains(text(),'Thank you for your purchase!')] ")
    WebElement thankYouMessage ;
    @FindBy(xpath = "//p[@class='lead text-muted']")
    WebElement purchaseInfo; //[contains(text(),'Id:')]
    @FindBy(xpath = "(//div[@class='modal-footer']/button[@class='btn btn-secondary'])[1]")
    WebElement closeButton;

    @FindBy(xpath = "//div[@class='sa-confirm-button-container']/button[@class='confirm btn btn-lg btn-primary']")
    WebElement okButton;

    public ThankYouPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public WebElement getThankYouMessage() { return thankYouMessage;}
    public WebElement getOkButton() { return okButton;}
    public WebElement getPurchaseInfo() { return purchaseInfo;}




}
