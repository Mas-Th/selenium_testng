package part2.demoqa.utility;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.io.File;
import java.io.IOException;

import static base.BasePage.driver;


public class TakeScreenshot {
    public static File testFailed(String testName){
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(
                System.getProperty("user.dir") +
                        "/resources/screenshots/"
                        + java.time.LocalDate.now() + testName + ".png" );
        try{
            FileUtils.copyFile(source, destination);
        }catch (IOException ex){
            throw new RuntimeException(ex);
        }
        return destination;

    }
}
