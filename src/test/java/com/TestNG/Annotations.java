package com.TestNG;

import org.testng.annotations.*;

public class Annotations {
    @BeforeClass
    public void browser_config(){
        System.out.println("Browser launch Successful");
    }
    @Test(priority = -1)
    public void login_test_valid_001(){
        System.out.println("Login valid Test passed");
    }
    @Test(priority = 1)
    public void login_test_invalid_002(){
        System.out.println("Login Invalid Test passed");
    }
    @AfterClass
    public void browser_close(){
        System.out.println("Test Complete.Browser closed.");
    }
}
