package Utilities;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import java.util.Random;

/* ****************************************************
 * Method with several utilities
 * 1. Generate a random string, useful for registration pages FOR unique users and emails
 * 2. Generate a random INT, useful for registration pages FOR unique users and emails
 * 3. Handles Alerts with try/catch
 * *****************************************************/

public class Helper {

    WebDriver driver ;
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
    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException Ex) {
            return false;
        }
    }
}

