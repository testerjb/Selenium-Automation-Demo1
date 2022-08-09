package practiceYT;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NextCartPage {
    WebDriver driver;
    @FindBy(xpath = "//div[@class='row']/div[@id='tbodyid']/h2[@class='name']")
    public WebElement selectedItem;

    @FindBy(xpath = "//a[@class='btn btn-success btn-lg']")
    public WebElement addToCartButton;

    //div[@class='row']/div[@id='tbodyid']/h2[@class='name']
   // By selectedItem= By.xpath("//div[@class='row']/div[@id='tbodyid']/h2[@class='name']");
   // By addToCartButton= By.xpath("//a[@class='btn btn-success btn-lg']");
    //open product page in order to add it to cart

    public NextCartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement getSelectedItem() {
        return selectedItem;
    }
    public WebElement getAddToCartButton() {
        return addToCartButton;
    }


}
