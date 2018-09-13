package com.ksergie;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected EventFiringWebDriver driver;
    protected WebDriverWait wait;
    protected EventFiringWebDriver eventDriver;
    protected EventHandler handler;

    static final String firefox = "firefox";
    static final String chrome = "chrome";
    static final String edge = "edge";


    private EventFiringWebDriver getDriver(String browser){
        switch(browser){
            case firefox:
                System.setProperty("webdriver.gecko.driver", new File(BaseTest.class.getResource("/geckodriver.exe").getFile()).getPath());
//                FirefoxOptions options = new FirefoxOptions();
//                options.addArguments();
//                options.setCapability();
                FirefoxDriver firefoxDriver = new FirefoxDriver();
                eventDriver = new EventFiringWebDriver(firefoxDriver);
                registerEventDriver();
                break;
            case chrome:
                System.setProperty("webdriver.chrome.driver", new File(BaseTest.class.getResource("/chromedriver.exe").getFile()).getPath());
                ChromeDriver chromeDriver = new ChromeDriver();
                eventDriver = new EventFiringWebDriver(chromeDriver);
                registerEventDriver();
                break;
//            case "ie":
//            case "internet explorer":
//                System.setProperty("webdriver.ie.driver", new File(com.ksergie.BaseTest.class.getResource("/IEDriverServer.exe").getFile()).getPath());
            case edge:
            default:
                System.setProperty("webdriver.edge.driver", new File(BaseTest.class.getResource("/MicrosoftWebDriver.exe").getFile()).getPath());
                EdgeDriver edgeDriver = new EdgeDriver();
                eventDriver = new EventFiringWebDriver(edgeDriver);
                registerEventDriver();
                break;
//                return new EdgeDriver();
        }
        return eventDriver;
    }

    private void registerEventDriver(){
        handler = new EventHandler();
        eventDriver.register(handler);
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

