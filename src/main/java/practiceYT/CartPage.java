package practiceYT;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;
    @FindBy(xpath = "//table[@class='table table-bordered table-hover table-striped']/tbody[@id='tbodyid']/tr[@class='success']/td[2]")
    public WebElement productName;

    @FindBy(xpath = "//div[@class='col-lg-1']/button[@class='btn btn-success']")
    public WebElement placerOrderButton;

    public CartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement getProductName() {return productName;}
    public WebElement getPlacerOrderButton() {return placerOrderButton;}

}
