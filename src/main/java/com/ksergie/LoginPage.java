package com.ksergie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

public class LoginPage {

    private EventFiringWebDriver driver;

    public LoginPage(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    private By linkLogin = By.xpath("//a[@href='/login']");
    private By fieldLogin = By.id("login_field");
    private By fieldPassword = By.id("password");
    private By buttonSubmit = By.name("commit");
    private By stringUserPage = By.xpath("//h2");
    String BaseUrl = "https://github.com/";


    public void login(String userName, String userPasswd){
        driver.get(BaseUrl);
        driver.findElement(linkLogin).click();
        driver.findElement(fieldLogin).sendKeys(userName);
        driver.findElement(fieldPassword).sendKeys(userPasswd);
        driver.findElement(buttonSubmit).click();
        Assert.assertEquals("Learn Git and GitHub without any code!", driver.findElement(stringUserPage).getText(), "We are not log in");
    }
}
