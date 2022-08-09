
package practiceYT.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

/*
 *
 * THIS CLASS WAS MADE TO HANDLE FILE RELATED METHODS
 *
 */

public class FilesUtilities {

    /*
     * The following method was created to handle a file that was downloaded as RTF format and had
     * to be converted to Word and then upload it with this new format in a web site
     */
    public void openWordRTFAndSaveAsDoc(String filePath, String fileToOpen, String newFileName) throws Exception {
        WebDriver driver = new ChromeDriver();
        filePath = filePath +"\\Downloads\\";
        StringSelection ss = new StringSelection(filePath + newFileName);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            Actions actions = new Actions(driver);
            try {
                File f = new File( filePath + fileToOpen);
                Desktop.getDesktop().open(f);
                Thread.sleep(2000);
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_F12);
                robot.keyPress(KeyEvent.VK_F12);
                Thread.sleep(2000);
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                Thread.sleep(1000);
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);
                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);
                robot.keyPress(KeyEvent.VK_HOME);
                robot.keyRelease(KeyEvent.VK_HOME);
                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);
                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);

                Thread.sleep(1000);
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                Thread.sleep(1000);

                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_W);

                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyRelease(KeyEvent.VK_W);

                /* Close Word program
                 * Word doesn't get closed with
                 * actions.keyDown(Keys.ALT); actions.sendKeys(Keys.F4);
                 * actions.keyUp(Keys.ALT); actions.perform();*/

                robot.keyPress(KeyEvent.VK_ALT);
                robot.keyPress(KeyEvent.VK_4);
                robot.keyRelease(KeyEvent.VK_4);
                robot.keyRelease(KeyEvent.VK_ALT);
                driver.close();
            }
            catch (IOException ioe) {
                System.out.println("Error occurred saving the file: " + ioe);
                ioe.printStackTrace();
            }
        }
    }

    /*
     * The following method  deletes a file from disk
     */
    public boolean deleteFileFromDisk(String fileLocationInDisk) {

        Boolean result = false ;
        try {
            File file2DeleteRTF = new File(fileLocationInDisk);
            result= file2DeleteRTF.delete() ;
        } catch(Exception e) { e.printStackTrace();  }
        return result;
    }
}
