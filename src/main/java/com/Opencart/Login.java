package com.Opencart;

import com.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login extends BaseClass {
   // public static WebDriver driver;

    public static void main(String[] args) {
        chrome_launch();
        open_website("https://demo.opencart.com/");
        login_invalid_TestCase01();
        //login_valid_TestCase02();
        close_browser();
    }

    public static void login_invalid_TestCase01(){
        WebElement myAccount= driver.findElement(By.linkText("My Account"));
        myAccount.click();
        WebElement login= driver.findElement(By.linkText("Login"));
        login.click();

        WebElement email= driver.findElement(By.id("input-email"));
        WebElement password=driver.findElement(By.id("input-password"));
        WebElement loginBtn= driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));

        email.sendKeys("test@test.com");
        password.sendKeys("1234567");
        loginBtn.click();

        //Verify
        String Expected_message="Warning: No match for E-Mail Address and/or Password.";
        WebElement errorMessage= driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]"));
        String Actual_message= errorMessage.getText();
        if(Expected_message.equalsIgnoreCase(Actual_message)){
            System.out.println("Test Passed");
        }
        else {
            System.out.println("Test Failed.Bug Found.");
        }

    }
    public static void login_valid_TestCase02(){
        WebElement myAccount= driver.findElement(By.linkText("My Account"));
        myAccount.click();
        WebElement login= driver.findElement(By.linkText("Login"));
        login.click();

        WebElement email= driver.findElement(By.id("input-email"));
        WebElement password=driver.findElement(By.id("input-password"));
        WebElement loginBtn= driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));

        email.sendKeys("user1@bd.com");
        password.sendKeys("123456");
        loginBtn.click();
    }

}
