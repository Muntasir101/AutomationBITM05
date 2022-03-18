package com.BrowserOptions;

import com.Base.BaseClass;

public class BasicAuth extends BaseClass {
    public static void main(String[] args) {
        chrome_launch();
        driver.get("https://admin2:admin@the-internet.herokuapp.com/basic_auth");
    }
}
