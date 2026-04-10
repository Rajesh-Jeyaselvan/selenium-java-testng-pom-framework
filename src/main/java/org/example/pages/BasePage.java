package org.example.pages;

import org.example.factory.DriverFactory;
import org.example.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

   protected WebDriver driver;
   private final WebDriverWait wait;

   public BasePage(){
       this.driver = DriverFactory.getDriver();
       int timeout = Integer.parseInt(ConfigReader.get("timeout"));
       this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));


   }

   protected WebElement waitforvisibilitystate( By locator){
       return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
   }
   protected WebElement waitforClickablestate(By locator){
       return wait.until(ExpectedConditions.elementToBeClickable(locator));
   }
   protected void type(By locator, String text) {
       WebElement element = waitforvisibilitystate(locator);
       element.clear();
       element.sendKeys(text==null ? "": text);
   }
   protected  void Click(By locator){
       waitforClickablestate(locator).click();
   }
   protected  String gettext(By locator){
       return waitforvisibilitystate(locator).getText();
   }
   protected boolean isDisplayed(By locator){
       try{
           return waitforvisibilitystate(locator).isDisplayed();
       } catch (TimeoutException e){
           return false;
       }
   }
}
