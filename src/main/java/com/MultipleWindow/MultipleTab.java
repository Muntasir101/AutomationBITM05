package com.MultipleWindow;

import com.Base.BaseClass;
import org.openqa.selenium.By;

import java.util.Set;

public class MultipleTab extends BaseClass {
    public static void main(String[] args) {
        chrome_launch();
        open_website("https://the-internet.herokuapp.com/windows");
        switchWindow();
        quit_browser();
    }
    public static void switchWindow(){
        String parentGUID = driver.getWindowHandle();
        driver.findElement(By.linkText("Click Here")).click();
        Set<String> allGuids=driver.getWindowHandles();

        //Switch to Child
        for(String ChildGuid:allGuids){
            if(!ChildGuid.equals(parentGUID)){
                driver.switchTo().window(ChildGuid);
                driver.get("https://google.com");
            }
        }

        //Switch back to parent
        for(String ChildGuid:allGuids){
            if(!ChildGuid.equals(parentGUID)){
                driver.switchTo().window(parentGUID);
                driver.get("https://demo.opencart.com/");
            }
        }
    }
}
