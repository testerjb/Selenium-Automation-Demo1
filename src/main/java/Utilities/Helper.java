package Utilities;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.time.LocalDate;
import java.util.*;

/* ****************************************************
 * Method with several utilities
 * 1. Generate a random string, useful for registration pages FOR unique users and emails
 * 2. Generate a random INT, useful for registration pages FOR unique users and emails
 * 3. Handles Alerts with try/catch
 * 4. Calculate current date and returns future year
 *
 * *****************************************************/

public class Helper {

    WebDriver driver ;

    public Helper(WebDriver driver) {
        this.driver=driver;
    }

    public String getRandomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString;
    }

    /*
     * Returns a random integer
     */
    public String randInt() {
        // create random object
        Random randomNum = new Random();
        // check next int value
        int randomN = randomNum.nextInt(546546);
        String ranInt = String.valueOf(randomN);
        //System.out.println("random int is " + randomN);
        return ranInt;
    }

    //Handles Alerts modals
    public void noAlertException(String alertText) {
        new WebDriverWait(driver, Duration.ofSeconds(60)).ignoring(NoAlertPresentException.class)
                .until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text : " + alert.getText());
        alert.accept();
        Assert.assertEquals(alert.getText(),alertText);
    }

    public String returnFutureYear()   {
        // create an LocalDate object
        LocalDate date = LocalDate.now();
        // add a year
        LocalDate returnDate = date.plusDays(400);
        //Split date into year, month, day
        String stringDate = returnDate.toString();
        String str[] = stringDate.split("-");
        //return year
        return str[0];
    }

    public boolean assertElementPresent(String xPathCode) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathCode)));
        return true;
    }


    // main method
    /*public static void main(String[] args) {
      copy code for testing methods separately
    }*/


}




