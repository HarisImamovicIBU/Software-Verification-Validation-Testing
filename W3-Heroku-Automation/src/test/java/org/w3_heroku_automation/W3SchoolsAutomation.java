package org.w3_heroku_automation;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class W3SchoolsAutomation {
    private static WebDriver webDriver;
    private static String baseUrl;

    @BeforeAll
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/Korisnik/Desktop/Materials/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        webDriver = new ChromeDriver(options);
        baseUrl="https://www.w3schools.com/html/html_tables.asp";
    }
    @AfterAll
    public static void tearDown(){
        if(webDriver!=null){
            webDriver.quit();
        }
    }
    @Test
    void assertCellValueIsYoshiTannamuri() throws InterruptedException {
        webDriver.get(baseUrl);
        Thread.sleep(2000);

        WebElement secondColumnFifthRow = webDriver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div[1]/div[1]/div[3]/div/table/tbody/tr[6]/td[2]"));
        assertEquals("Yoshi Tannamuri", secondColumnFifthRow.getText());
    }
}
