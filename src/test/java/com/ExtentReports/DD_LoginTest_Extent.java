package com.ExtentReports;

import com.DataDriven.Utils.Xls_Reader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DD_LoginTest_Extent {

    WebDriver driver;

    ExtentHtmlReporter htmlReporter;
    ExtentReports reports;
    ExtentTest logger;

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

        // Implement Extent Report
        htmlReporter = new ExtentHtmlReporter("./ExtentReports/LoginTestReport.html");
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);


        //Information added to report
        reports.setSystemInfo("Environment","Test");
        reports.setSystemInfo("Test By", "Muntasir");
        reports.setSystemInfo("OS","Windows 11");
        reports.setSystemInfo("Browser", "Firefox");

        logger = reports.createTest("Login Test");

        //Excel Implementation
        Xls_Reader reader=new Xls_Reader("./src/test/java/com/DataDriven/Login_data.xlsx");
        String sheetName="Login_invalid";

        int rowCount = reader.getRowCount(sheetName);

        for(int rowNum=2;rowNum<=rowCount;rowNum++){
            String DD_email= reader.getCellData(sheetName,"Email",rowNum);
            String DD_password= reader.getCellData(sheetName,"Password",rowNum);

            driver.get("https://demo.guru99.com/selenium/newtours/");
            //Reporter.log("Newtours Opening");
            logger.log(Status.INFO,"Newtours Open");
            WebElement email= driver.findElement(By.name("userName"));
            WebElement password=driver.findElement(By.name("password"));
            WebElement loginBtn= driver.findElement(By.name("submit"));

            email.sendKeys(DD_email);
           // Reporter.log("Email Typing");
            logger.log(Status.INFO,"Email typing");
            password.sendKeys(DD_password);
            //Reporter.log("Password Typing");
            logger.log(Status.INFO,"Password typing");
            loginBtn.click();
          //  Reporter.log("Login Button clicked");
            logger.log(Status.INFO,"Sign in clicked");
            System.out.println("Login Invalid Test passed");

            logger.log(Status.PASS,"Test Passed");
        }

        reports.flush();
    }


}