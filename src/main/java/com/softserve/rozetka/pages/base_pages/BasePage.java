package com.softserve.rozetka.pages.base_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class BasePage {
    private static final int TIME = 10000;
    private static final int POLLING_TIME = 3;
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIME));
    }

    protected WebElement waitForElementToAppear(WebElement element){
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(TIME))
                .pollingEvery(Duration.ofSeconds(POLLING_TIME))
                .ignoring(NoSuchElementException.class);
         return  wait.until(ExpectedConditions.visibilityOf(element));
    }
    protected void waitForPresenceOfElement(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    protected void waitForPresenceOfAllElements(By locator){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    protected void waitForElementsToAppear(List<WebElement>elements){
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
    protected void waitForElementsToDisappear(List<WebElement>elements){
        wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
    }
    protected WebElement waitForElementBecomeClickable(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    protected void waitForUrlToBe(String URL){
        wait.until(ExpectedConditions.urlToBe(URL));
    }

    public void waitForPageLoadComplete() {
        new WebDriverWait(driver, Duration.ofSeconds(TIME)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

}
