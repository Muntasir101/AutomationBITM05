package com.WebElememnt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TitleUrl {
    public static WebDriver driver;

    public static void main(String[] args) {
        chrome_launch();
        open_website("https://demo.opencart.com/");
        get_title();
        get_url();
        close_browser();
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

    public static void get_title(){
        String title=driver.getTitle();
        System.out.println(title);
    }
    public static void get_url(){
        String url=driver.getCurrentUrl();
        System.out.println(url);
    }

    public static void close_browser(){
        driver.close();
    }
}
