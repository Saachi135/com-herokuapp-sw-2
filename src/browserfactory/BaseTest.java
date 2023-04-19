package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    // public static method

    public void openBrowser(String baseUrl) {
        //Launch the Chrome Browser
        driver = new ChromeDriver();

        //open the url into the browser
        driver.get(baseUrl);

        //maximise window
        driver.manage().window().maximize();
        //implicit timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public void closeBrowser() {
        //To close all the associated browser windows
        driver.quit();
    }
}
