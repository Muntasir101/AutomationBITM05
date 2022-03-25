package com.MultipleWindow;

import com.Base.BaseClass;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import org.openqa.selenium.By;

import java.util.Set;

public class GetGUID extends BaseClass {
    public static void main(String[] args) {
        chrome_launch();
        open_website("https://the-internet.herokuapp.com/windows");
        get_guid();
        close_browser();
    }
    public static void get_guid(){
        String parentGUID = driver.getWindowHandle();
        System.out.println(parentGUID);

        driver.findElement(By.linkText("Click Here")).click();
        Set<String> allGuids=driver.getWindowHandles();
        System.out.println(allGuids);
    }
}
