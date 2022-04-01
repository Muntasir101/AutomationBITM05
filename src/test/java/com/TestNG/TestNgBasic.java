package com.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgBasic {

    @Test(dependsOnMethods = {"testCase_003","testCase_002"})
    public void testCase_001(){
        System.out.println("Test case 1 Executed");
    }
    @Test
    public void testCase_002(){
        System.out.println("Test case 2 Executed");
        String Expected_title="Google";
        Assert.assertEquals("facebook",Expected_title);
    }
    @Test
    public void testCase_003(){
        System.out.println("Test case 3 Executed");
    }
}
