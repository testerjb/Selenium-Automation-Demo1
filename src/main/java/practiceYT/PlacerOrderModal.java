package practiceYT;
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
}
