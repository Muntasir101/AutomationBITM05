package com.Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserConfig {

    public static WebDriver driver;

    public static void main(String[] args) {
        chrome_launch();
        browserMaximumSize();
        open_website("https://google.com");//Max Width : 1296 Max Height: 688
       // browser_close();
       // browser_quit();
        firefox_launch();
        browserMaximumSize();  //Max Width : 1295 Max Height: 687
        open_website("https://demo.opencart.com");
      //  browser_close();
     //   browser_quit();

    }
    public static void chrome_launch(){
        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
        driver=new ChromeDriver();

        //browser maximize
        driver.manage().window().maximize();
    }
    public static void firefox_launch(){
        System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
        driver=new FirefoxDriver();
    }
    public static void open_website(String URL){
        driver.get(URL);
    }

    public static void browser_close(){
        driver.close();
    }
    public static void browser_quit(){
        driver.quit();
    }

    public static void browserMaximumSize(){
      int maxWidth= driver.manage().window().getSize().getWidth();
      int maxHeight=   driver.manage().window().getSize().getHeight();
      System.out.println("Max Width : "+maxWidth + " Max Height: "+maxHeight);
    }

}
