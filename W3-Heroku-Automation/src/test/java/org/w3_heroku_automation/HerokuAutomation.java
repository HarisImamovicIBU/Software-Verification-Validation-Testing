package org.w3_heroku_automation;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class HerokuAutomation {
    private static WebDriver webDriver;
    private static String baseUrl;

    @BeforeAll
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/Korisnik/Desktop/Materials/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", prefs);
        webDriver = new ChromeDriver(options);
        baseUrl = "https://the-internet.herokuapp.com/";
    }
    @AfterAll
    public static void tearDown(){
        if(webDriver!=null){
            webDriver.quit();
        }
    }
    @Test
    void assertHerokuAuthentication() throws InterruptedException{
        webDriver.get(baseUrl);
        Thread.sleep(3000);
        WebElement formAuthLink = webDriver.findElement(By.xpath("/html/body/div[2]/div/ul/li[21]/a"));
        formAuthLink.click();
        Thread.sleep(2000);

        WebElement usernameInput = webDriver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/div/input"));
        WebElement passwordInput = webDriver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/div/input"));

        usernameInput.sendKeys("tomsmith");
        passwordInput.sendKeys("SuperSecretPassword!");

        Thread.sleep(2000);

        WebElement button = webDriver.findElement(By.xpath("/html/body/div[2]/div/div/form/button"));
        button.click();

        Thread.sleep(3000);

        assertEquals("https://the-internet.herokuapp.com/secure",webDriver.getCurrentUrl());

        WebElement logout = webDriver.findElement(By.xpath("/html/body/div[2]/div/div/a"));
        logout.click();

        Thread.sleep(5000);

        webDriver.get("https://the-internet.herokuapp.com/");

        Thread.sleep(5000);

        WebElement checkboxes = webDriver.findElement(By.xpath("/html/body/div[2]/div/ul/li[6]/a"));
        checkboxes.click();
        Thread.sleep(5000);

        webDriver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[2]")).click();
        webDriver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[1]")).click();

        webDriver.get("https://the-internet.herokuapp.com/");
        Thread.sleep(3000);

        WebElement dropdown = webDriver.findElement(By.xpath("/html/body/div[2]/div/ul/li[11]/a"));
        dropdown.click();
        Thread.sleep(3000);

        webDriver.findElement(By.xpath("/html/body/div[2]/div/div/select")).click();
        Thread.sleep(500);
        webDriver.findElement(By.xpath("/html/body/div[2]/div/div/select/option[3]")).click();
        Thread.sleep(2000);

    }
}









