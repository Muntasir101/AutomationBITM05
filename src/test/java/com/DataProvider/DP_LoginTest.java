package com.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

public class DP_LoginTest {

    WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void init_setup(String browser_name) {
        if (browser_name.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser_name.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (browser_name.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            System.out.println("Please provide browser name(Chrome,firefox or Edge).");
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test(dataProvider = "Login_invalid_data")
    public void TC_invalid_001(String DP_email, String DP_password){
        driver.get("https://demo.opencart.com/");
        Reporter.log("Opencart Opening");
        WebElement myAccount= driver.findElement(By.linkText("My Account"));
        myAccount.click();
        WebElement login= driver.findElement(By.linkText("Login"));
        login.click();
        Reporter.log("Login page open");
        WebElement email= driver.findElement(By.id("input-email"));
        WebElement password=driver.findElement(By.id("input-password"));
        WebElement loginBtn= driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));

        email.sendKeys(DP_email);
        Reporter.log("Email Typing");
        password.sendKeys(DP_password);
        Reporter.log("Password Typing");
        loginBtn.click();
        Reporter.log("Login Button clicked");
        System.out.println("Login Invalid Test passed");
    }

    @DataProvider(name="Login_invalid_data")
    public Object [][] data(){
        Object data[][] = new Object[3][2];

        //Set 1
        data [0][0] ="email@test.com";
        data [0][1] = "123456";

        //Set 2
        data [1][0] ="email2@test.com";
        data [1][1] = "123456";

        //Set 2
        data [2][0] ="email3@test.com";
        data [2][1] = "123456";

        return data;
    }

}