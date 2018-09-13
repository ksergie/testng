package com.ksergie;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventHandler implements WebDriverEventListener {

    @Override
    public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] charSequences) {
        // TODO Auto-generated method stub

        System.out.println("inside method afterChangeValueOf on " + arg0.toString());
    }

    @Override
    public void afterClickOn(WebElement arg0, WebDriver arg1) {
        // TODO Auto-generated method stub
        System.out.println("inside method afterClickOn on " + arg0.toString());
    }

    @Override
    public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
        // TODO Auto-generated method stub
        System.out.println("Find happened on " + arg0.toString());
    }

    @Override
    public void afterNavigateBack(WebDriver arg0) {
        // TODO Auto-generated method stub

        System.out.println("Inside the after navigateback to " + arg0.getCurrentUrl());
    }

    @Override
    public void afterNavigateForward(WebDriver arg0) {
        // TODO Auto-generated method stub
        System.out.println("Inside the afterNavigateForward to " + arg0.getCurrentUrl());
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateTo(String arg0, WebDriver arg1) {
        // TODO Auto-generated method stub
        System.out.println("Inside the afterNavigateTo to " + arg0);
    }

    @Override
    public void afterScript(String arg0, WebDriver arg1) {
        // TODO Auto-generated method stub
        System.out.println("Inside the afterScript to, Script is " + arg0);
    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {

    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {

    }

    @Override
    public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] charSequences) {
        // TODO Auto-generated method stub

        System.out.println("Inside the beforeChangeValueOf method");
    }

    @Override
    public void beforeClickOn(WebElement arg0, WebDriver arg1) {
        // TODO Auto-generated method stub
        System.out.println("About to click on the " + arg0.toString());

    }

    @Override
    public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
        // TODO Auto-generated method stub
        System.out.println("Just before finding element" + arg0.toString());

    }

    @Override
    public void beforeNavigateBack(WebDriver arg0) {
        // TODO Auto-generated method stub
        System.out.println("Just before beforeNavigateBack " + arg0.getCurrentUrl());

    }

    @Override
    public void beforeNavigateForward(WebDriver arg0) {
        // TODO Auto-generated method stub
        System.out.println("Just before beforeNavigateForward " + arg0.getCurrentUrl());

    }

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateTo(String arg0, WebDriver arg1) {
        // TODO Auto-generated method stub
        System.out.println("Just before beforeNavigateTo " + arg0);
    }

    @Override
    public void beforeScript(String arg0, WebDriver arg1) {
        // TODO Auto-generated method stub
        System.out.println("Just before beforeScript " + arg0);
    }

    @Override
    public void onException(Throwable arg0, WebDriver arg1) {
        // TODO Auto-generated method stub
        System.out.println("Exception occured at " + arg0.getMessage());

    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {

    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, java.lang.String text){
        System.out.println("We have got this text: " + text);
    }

}
