package com.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpencartLoginTest2 {
    public static WebDriver driver;

    @BeforeMethod
    public void browser_config(){
        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
        driver=new ChromeDriver();
        //browser maximize
        driver.manage().window().maximize();
        System.out.println("Browser launch Successful");
    }

    @Test(priority = 1,description = "Email and password are invalid")
    public void login_test_valid_001(){
        driver.get("https://demo.opencart.com/");
        WebElement myAccount= driver.findElement(By.linkText("My Account"));
        myAccount.click();
        WebElement login= driver.findElement(By.linkText("Login"));
        login.click();
        WebElement email= driver.findElement(By.id("input-email"));
        WebElement password=driver.findElement(By.id("input-password"));
        WebElement loginBtn= driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));

        email.sendKeys("user10@bd.com");
        password.sendKeys("1234567");
        loginBtn.click();
        System.out.println("Login Invalid Test passed");
    }
    @AfterMethod
    public void browser_close(){
        driver.close();
        System.out.println("Test Complete.Browser closed.");
    }
}
