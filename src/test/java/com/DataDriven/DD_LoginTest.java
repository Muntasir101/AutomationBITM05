package com.DataDriven;

import com.DataDriven.Utils.Xls_Reader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

public class DD_LoginTest {

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

    @Test
    public void TC_invalid_001(){

        //Excel Implementation
        Xls_Reader reader=new Xls_Reader("./src/test/java/com/DataDriven/Login_data.xlsx");
        String sheetName="Login_invalid";

        int rowCount = reader.getRowCount(sheetName);

        for(int rowNum=2;rowNum<=rowCount;rowNum++){
            String DD_email= reader.getCellData(sheetName,"Email",rowNum);
            String DD_password= reader.getCellData(sheetName,"Password",rowNum);

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

            email.sendKeys(DD_email);
            Reporter.log("Email Typing");
            password.sendKeys(DD_password);
            Reporter.log("Password Typing");
            loginBtn.click();
            Reporter.log("Login Button clicked");
            System.out.println("Login Invalid Test passed");
        }

    }


}