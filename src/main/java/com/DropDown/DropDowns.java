package com.DropDown;

import com.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDowns extends BaseClass {
    public static void main(String[] args) {
        chrome_launch();
        open_website("https://the-internet.herokuapp.com/dropdown");
        selectOption();
    }
    public static void selectOption(){
        WebElement dropdown= driver.findElement(By.id("dropdown"));
        Select slt=new Select(dropdown);
      //  slt.selectByIndex(1);
    //    slt.selectByValue("2");
        slt.selectByVisibleText("Option 1");

    }
}
