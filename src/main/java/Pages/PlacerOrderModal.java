package Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlacerOrderModal {
    WebDriver driver;
    @FindBy(xpath = "//div[@id='orderModal']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-header']/button[@class='close']/span")
    public WebElement cancelButtonX;

    @FindBy(xpath = "//div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-header']/h5[@id='orderModalLabel']")
    public WebElement ModalTitle;

    @FindBy(xpath = "//div[@id='orderModal']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-body']")
    public WebElement eFrame;

    @FindBy(xpath = "//form/div[@class='form-group'][1]/input[@id='name']")
    public WebElement cardHolderName;

    @FindBy(xpath = "//form/div[@class='form-group'][2]/input[@id='country']")
    public WebElement cardHolderCountry;
    @FindBy(xpath = "//form/div[@class='form-group'][3]/input[@id='city']")
    public WebElement cardHolderCity;
    @FindBy(xpath = "//form/div[@class='form-group'][4]/input[@id='card']")
    public WebElement cardNumber;
    @FindBy(xpath = "//form/div[@class='form-group'][5]/input[@id='month']")
    public WebElement cardExpirationMonth;
    @FindBy(xpath = "//form/div[@class='form-group'][6]/input[@id='year']")
    public WebElement cardExpirationYear;
    @FindBy(xpath = "//button[@class='btn btn-primary'][contains(text(),'Purchase')]")
    public WebElement purchaseButton;

    public PlacerOrderModal(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement getEframe() {
        return eFrame;
    }
    public WebElement getModalTitle() {
        return ModalTitle;
    }
    public WebElement getCancelButtonX() {
        return cancelButtonX;
    }
    public WebElement getCardHolderName() { return cardHolderName;}
    public WebElement getCardHolderCountry() { return cardHolderCountry;}
    public WebElement getCardHolderCity() { return cardHolderCity;}
    public WebElement getCardNumber() { return cardNumber;}
    public WebElement getCardExpirationMonth() { return cardExpirationMonth;}
    public WebElement getCardExpirationYear() { return cardExpirationYear;}
    public WebElement getPurchaseButton() { return purchaseButton;}

}
