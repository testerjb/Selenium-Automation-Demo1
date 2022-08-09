package practiceYT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCartPage {
    WebDriver driver;

    String categories = "Laptops";
   // original driver.findElement(By.xpath("//a[contains(text(), '" + categories + "')]")).click();
    //By category=By.xpath("//a[contains(text(), '" + categories + "')]");
    By firstItem=By.xpath("(//div[@class='card-block']/h4[@class='card-title']/a[@class='hrefch'])[1]");
    //By selectedItem= By.xpath("//div[@class='row']/div[@id='tbodyid']/h2[@class='name']");
    //By addToCartButton= By.xpath("//a[@class='btn btn-success btn-lg']");

    //select category laptops
    By category= By.xpath("//div[@class='col-lg-3']/div[@class='list-group']/a[@id='itemc'][2]");
    //constructor
    public AddCartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    
    //after login select category laptops
    public WebElement getCategory() {
        return driver.findElement(category);
    }

    //get the first item from the page to click on it
    public WebElement getFirstItem() {
        return driver.findElement(firstItem);
    }

    //open product page in order to add it to cart
/*    public WebElement getSelectedItem() {
        return driver.findElement(selectedItem);
    }
    public WebElement getAddToCartButton() {
        return driver.findElement(addToCartButton);
    }*/












}
