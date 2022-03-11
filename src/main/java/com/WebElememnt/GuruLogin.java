package com.WebElememnt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GuruLogin {
    public static WebDriver driver;
    public static void main(String[] args) {
        chrome_launch();
        open_website("https://demo.guru99.com/v4/");
        login_TestCase01();
    }
    public static void chrome_launch(){
        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
        driver=new ChromeDriver();

        //browser maximize
        driver.manage().window().maximize();
    }
    public static void open_website(String URL){
        driver.get(URL);
    }

    public static void login_TestCase01(){
        WebElement email= driver.findElement(By.name("uid"));
        WebElement password=driver.findElement(By.name("password"));
        WebElement loginBtn= driver.findElement(By.name("btnLogin"));
        WebElement resetBtn= driver.findElement(By.name("btnReset"));

        email.sendKeys("test@test.com");
        password.sendKeys("1234567");
        loginBtn.click();
        resetBtn.click();
    }
}
