package com.ksergie;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    private WebDriver getDriver(String browser){
        switch(browser){
            case "firefox":
                System.setProperty("webdriver.gecko.driver"), new File(BaseTest.class.getResource("/geckodriver.exe").getFile()).getPath();
//                FirefoxOptions options = new FirefoxOptions();
//                options.addArguments();
//                options.setCapability();
                return new FirefoxDriver();
            case "chrome":
                System.setProperty("webdriver.chrome.driver"), new File(BaseTest.class.getResource("/chromedriver.exe").getFile()).getPath();
                return new ChromeDriver();
//            case "ie":
//            case "internet explorer":
//                System.setProperty("webdriver.ie.driver"), new File(com.ksergie.BaseTest.class.getResource("/IEDriverServer.exe").getFile()).getPath();
            case "edge":
            default:
                System.setProperty("webdriver.edge.driver"), new File(BaseTest.class.getResource("/MicrosoftWebDriver.exe").getFile()).getPath();
                return new EdgeDriver();
        }
    }

    @BeforeClass
    @Parameters("selenium.browser")
    public void setUp(@Optional("edge") String browser){
        driver = getDriver(browser);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
    }

    @AfterClass
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}

