package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;

    //first product from the cart table
    @FindBy(xpath = "//tbody[@id='tbodyid']/tr[@class='success'][1]/td[2]")
    public WebElement productName;
    @FindBy(xpath = "//div[@class='col-lg-1']/button[@class='btn btn-success']")
    public WebElement placerOrderButton;
    @FindBy(xpath = "//tbody[@id='tbodyid']/tr[@class='success'][1]/td[4]/a")
    WebElement deleteButton;

    public CartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public WebElement getDeleteButton() {return deleteButton;}
    public WebElement getProductName() {return productName;}
    public WebElement getPlacerOrderButton() {return placerOrderButton;}
}
