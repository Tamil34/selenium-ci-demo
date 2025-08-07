package com.edureka.Excel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests {
	WebDriver driver;

    @BeforeMethod
    public void setUp() 
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        var options = new org.openqa.selenium.chrome.ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
        driver = new ChromeDriver(options);
        driver.get("https://example.com/login");
    }
    
    @Test
    public void testLogin() {
        driver.findElement(By.id("username")).sendKeys("testuser");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.id("login")).click();
        Assert.assertTrue(driver.getTitle().contains("Dashboard"));
    }
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }
    
    

}
