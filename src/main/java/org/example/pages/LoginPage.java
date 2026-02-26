package org.example.pages;

import org.example.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    // Locators (page elements)
    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By flashMessage = By.id("flash");

    // Wait helper (to reduce flaky tests)
    private WebDriverWait getWait() {
        return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
    }

    // Page actions (what user does on the page)
    public LoginPage enterUserName(String username) {
        WebElement userField = getWait().until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        userField.clear();
        userField.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        WebElement passField = getWait().until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        passField.clear();
        passField.sendKeys(password);
        return this;
    }

    public LoginPage clickLogin() {
        getWait().until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        return this;
    }

    // Page verification data
    public String getFlashMessage() {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(flashMessage)).getText();
    }
}