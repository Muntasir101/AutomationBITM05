package com.Opencart;

import com.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class Registration extends BaseClass {

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
        email.sendKeys(generate_Random_string() + "@gmail.com");
        Thread.sleep(5000);
        telephone.sendKeys("0123456789");
        password.sendKeys("1234567");
        confirm.sendKeys("1234567");
        newsletter.click();
        agree.click();
        Thread.sleep(3000);
        continueBtn.click();

        //Verify by Text
//        String Expected_message="Your Account Has Been Created!";
//        WebElement successMessage= driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
//        String Actual_message= successMessage.getText();
//        if(Expected_message.equalsIgnoreCase(Actual_message)){
//            System.out.println("Test Passed");
//        }
//        else {
//            System.out.println("Test Failed.Bug Found.");
//        }

        //Verify by Title
        String Expected_title="Your Account Has Been Created!";
        String Actual_title= driver.getTitle();
        if(Expected_title.equalsIgnoreCase(Actual_title)){
            System.out.println("Test Passed.Account successfully created");
        }
        else {
            System.out.println("Test Failed.Bug Found.Actual Title is: "+Actual_title);
        }
    }


    public static String generate_Random_string(){
        String SALTCHAR="abcdefghijklmnopqrstuvwxyz123";
        StringBuilder rstr=new StringBuilder();
        Random rnd=new Random();

        while (rstr.length()<10){
            int index=(int)(rnd.nextFloat()*SALTCHAR.length());
            rstr.append(SALTCHAR.charAt(index));
        }
        String newString=rstr.toString();
        return newString;
    }

}
