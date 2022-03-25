package com.Screenshot;

import com.Base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class ElementScreenshot extends BaseClass {
    public static void main(String[] args) throws IOException {
        chrome_launch();
        open_website("https://google.com");
        element_screenshot();
        close_browser();
    }
    public static void element_screenshot() throws IOException {
        WebElement searchBox = driver.findElement(By.name("q"));
        File srcFile = ((TakesScreenshot)searchBox).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,new File("./Screenshots/GoogleSearch.png"),true);
    }
}
