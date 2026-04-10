package org.example.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By flashMessage = By.id("flash");

    public LoginPage enterUsername(String username) {
        type(usernameInput, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        type(passwordInput, password);
        return this;
    }

    public SecureAreaPage clickLoginExpectSuccess() {
        Click(loginButton);
        return new SecureAreaPage();
    }

    public LoginPage clickLoginExpectFailure() {
        Click(loginButton);
        return this;
    }

    public SecureAreaPage loginValid(String username, String password) {
        return enterUsername(username)
                .enterPassword(password)
                .clickLoginExpectSuccess();
    }

    public LoginPage loginInvalid(String username, String password) {
        return enterUsername(username)
                .enterPassword(password)
                .clickLoginExpectFailure();
    }

    public String getErrorMessage() {
        return gettext(flashMessage);
    }
}