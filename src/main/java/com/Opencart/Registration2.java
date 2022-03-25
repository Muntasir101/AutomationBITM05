package com.Opencart;

import com.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class Registration2 extends BaseClass {

    public static void main(String[] args) throws InterruptedException {
        chrome_launch();
        open_website("https://demo.opencart.com");
        register_Valid_TestCase01();
        close_browser();
    }

    public static void register_Valid_TestCase01() throws InterruptedException {
        WebElement myAccount= driver.findElement(By.linkText("My Account"));
        myAccount.click();
        WebElement register= driver.findElement(By.linkText("Register"));
        register.click();

        WebElement firstname = driver.findElement(By.name("firstname"));
        WebElement lastname = driver.findElement(By.name("lastname"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement telephone = driver.findElement(By.name("telephone"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement confirm = driver.findElement(By.name("confirm"));
        WebElement newsletter = driver.findElement(By.name("newsletter"));
        WebElement agree = driver.findElement(By.name("agree"));
        WebElement continueBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));

        String firstName="avbc";
        firstname.sendKeys(firstName);
        lastname.sendKeys("vwxyz");
        email.sendKeys("misis1020@gmail.com");
        Thread.sleep(5000);
        telephone.sendKeys("0123456789");
        password.sendKeys("1234567");
        confirm.sendKeys("1234567");
        newsletter.click();
        agree.click();
        Thread.sleep(3000);
        continueBtn.click();


        //Verify Error message
        String Expected_message="Warning: E-Mail Address is already registered!";
        WebElement error_message= driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]"));
        String Actual_message= error_message.getText();
        System.out.println(Actual_message);

        if(Expected_message.contains(Actual_message)){
            System.out.println("Test Passed.");
        }
        else {
            System.out.println("Test Failed. "+Actual_message);
        }
    }

}
