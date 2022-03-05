package com.Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserConfig {

    public static WebDriver driver;

    public static void main(String[] args) {
        chrome_launch();
        open_website("https://google.com");
    }
    public static void chrome_launch(){
        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
        driver=new ChromeDriver();
    }
    public static void firefox_launch(){
        System.setProperty("webdriver.gecko.driver","./Drivers/");
        driver=new FirefoxDriver();
    }
    public static void open_website(String URL){
        driver.get(URL);
    }

}
