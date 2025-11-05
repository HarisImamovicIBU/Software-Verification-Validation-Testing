import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UIAutomationTest {
    private static WebDriver webDriver;
    private static String baseUrl;

    @BeforeAll
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "/C:/Users/Korisnik/Desktop/Materials/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
        baseUrl="http://www.uitestingplayground.com/sampleapp";
    }

    @AfterAll
    public static void tearDown(){
        if(webDriver!=null){
            webDriver.quit();
        }
    }

    @Test
    void assertWebElementsAreInputs() throws InterruptedException {
        webDriver.get("http://www.uitestingplayground.com/sampleapp");
        Thread.sleep(3000);
        //Finding input fields by their name
        WebElement username = webDriver.findElement(By.name("UserName"));
        WebElement password = webDriver.findElement(By.name("Password"));

        //Asserting that they are actually inputs
        assertEquals("input", username.getTagName().toLowerCase());
        assertEquals("input", password.getTagName().toLowerCase());
        username.clear();
        password.clear();

        //Entering some input to the input fields
        username.sendKeys("test");
        Thread.sleep(3000);
        password.sendKeys("pwd");
        Thread.sleep(3000);

        //Finding the login button by id
        WebElement loginButton = webDriver.findElement(By.id("login"));
        assertEquals("button", loginButton.getTagName().toLowerCase());

        //Clicking the button
        loginButton.click();

        //Asserting status text
        WebElement statusLabel = webDriver.findElement(By.id("loginstatus"));
        String statusText = statusLabel.getText();
        assertTrue(statusText.contains("test"), "Login status should contain 'test' but was: " + statusText);
        Thread.sleep(3000);
    }
    @Test
    void assertEmptyFormSubmission() throws InterruptedException {
        webDriver.get("http://www.uitestingplayground.com/sampleapp");
        Thread.sleep(3000);
        //Finding input elements by name
        WebElement username = webDriver.findElement(By.name("UserName"));
        WebElement password = webDriver.findElement(By.name("Password"));

        //Entering invalid input to the input fields
        username.sendKeys(" ");
        Thread.sleep(3000);
        password.sendKeys(" ");
        Thread.sleep(3000);

        //Finding the login button by id
        WebElement button = webDriver.findElement(By.id("login"));

        //Clicking the button
        button.click();

        //Asserting status text is Invalid username/password
        WebElement statusLabel = webDriver.findElement(By.id("loginstatus"));
        String statusText = statusLabel.getText();
        assertEquals("Invalid username/password", statusText);
        Thread.sleep(3000);
    }
}