package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //find element and input in username field
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //find element and input in password field
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        //Click on ‘LOGIN’ button
        driver.findElement(By.className("radius")).click();
        //Verify the text “Secure Area”
        String expectedMessage = "Secure Area";
        WebElement actualTextElement = driver.findElement(By.xpath("//h2"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(" Secure Area not displayed", expectedMessage, actualMessage);


    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        //find element and Enter “tomsmith1” username
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        //find element and Enter “SuperSecretPassword!” password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        //find element and Click on ‘LOGIN’ button
        driver.findElement(By.className("radius")).click();
        //Verify the error message “Your username is invalid!”
        String expectedMessage = "Your password is invalid!\n" +
                "×";
        WebElement actualDisplayMessage = driver.findElement(By.id("flash"));
        String actualMessage = actualDisplayMessage.getText();
        Assert.assertEquals("Your password is invalid", expectedMessage, actualMessage);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}

