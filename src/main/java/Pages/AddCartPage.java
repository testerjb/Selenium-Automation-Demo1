package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCartPage {
    WebDriver driver;

    //select first item from the category selected
    @FindBy(xpath = "(//div[@class='card-block']/h4[@class='card-title']/a[@class='hrefch'])[1]")
    public WebElement firstItem;

    //select category Phones
    @FindBy(xpath = "//div[@class='col-lg-3']/div[@class='list-group']/a[@id='itemc'][1]")
    public WebElement categoryP;

    //select category laptops
    @FindBy(xpath = "//div[@class='row']/div[@class='col-lg-3']/div[@class='list-group']/a[@id='itemc'][2]")
    public WebElement categoryL;

    //select category Monitor
    @FindBy(xpath = "//div[@class='list-group']/a[@id='itemc'][3][contains(text(),'Monitors')]")
    //old "//div[@class='row']/div[@class='col-lg-3']/div[@class='list-group']/a[@id='itemc'][3]"
    public WebElement categoryM;

    //constructor
    public AddCartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    
    //after login select category laptops
    public WebElement getCategoryLaptops() {
        return  categoryL;
    }
    public WebElement getCategoryPhones() {return categoryP;}
    public WebElement getCategoryMonitors() {return categoryM;}

    //get the first item from the page to click on it
    public WebElement getFirstItem() { return firstItem; }













}
