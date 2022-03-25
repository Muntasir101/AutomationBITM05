package com.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class BaseClass {

    public static WebDriver driver;

    public static void chrome_launch(){
        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
        driver=new ChromeDriver();
        //browser maximize
        driver.manage().window().maximize();
    }
    public static void open_website(String URL){
        driver.get(URL);
    }
    public static void close_browser(){
        driver.close();
    }
    public static void quit_browser(){
        driver.quit();
    }

    public static String generate_Random_string(){
        String SALTCHAR="abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGH";
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
