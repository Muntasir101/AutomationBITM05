package com.Alert;

import com.Base.BaseClass;
import org.openqa.selenium.By;

public class AllAboutAlerts extends BaseClass {
    public static void main(String[] args) throws InterruptedException {
        chrome_launch();
        open_website("https://the-internet.herokuapp.com/javascript_alerts");
        alerts();
        close_browser();

    }
    public static void alerts() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();

        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
        driver.switchTo().alert().sendKeys("Hello World");
        Thread.sleep(4000);
        driver.switchTo().alert().accept();
    }

}
