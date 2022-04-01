package com.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

public class OpencartLoginTest {
    public static WebDriver driver;

    @BeforeMethod
    public void browser_config(){
        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
        driver=new ChromeDriver();
        Reporter.log("Chrome Launch Successful");
        driver.manage().window().maximize();
        System.out.println("Browser launch Successful");
    }

    @Test(priority = 1,description = "Email and password are invalid")
    public void login_test_invalid_001(){
        driver.get("https://demo.opencart.com/");
        Reporter.log("Opencart Opening");
        WebElement myAccount= driver.findElement(By.linkText("My Account"));
        myAccount.click();
        WebElement login= driver.findElement(By.linkText("Login"));
        login.click();
        Reporter.log("Login page open");
        WebElement email= driver.findElement(By.id("input-email"));
        WebElement password=driver.findElement(By.id("input-password"));
        WebElement loginBtn= driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));

        email.sendKeys("test@test.com");
        Reporter.log("Email Typing");
        password.sendKeys("1234567");
        Reporter.log("Password Typing");
        loginBtn.click();
        Reporter.log("Login Button clicked");
        System.out.println("Login Invalid Test passed");
    }
    @AfterMethod
    public void browser_close(){
        driver.close();
        System.out.println("Test Complete.Browser closed.");
    }
}
