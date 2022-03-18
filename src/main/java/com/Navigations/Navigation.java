package com.Navigations;

import com.Base.BaseClass;

public class Navigation extends BaseClass {
    public static void main(String[] args) throws InterruptedException {
        chrome_launch();
        open_website("https://www.google.com/");
        navigate_to();
        Thread.sleep(3000);
        navigate_back();
        Thread.sleep(3000);
        navigate_forward();
        Thread.sleep(3000);
        reload();

    }
    public static void navigate_to(){
        driver.navigate().to("https://demo.opencart.com/");
    }
    public static void navigate_back(){
        driver.navigate().back();
    }
    public static void navigate_forward(){
        driver.navigate().forward();
    }
    public static void reload(){
       driver.navigate().refresh();
    }
}
