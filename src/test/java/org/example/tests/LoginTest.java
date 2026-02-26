package org.example.tests;

import org.example.base.BaseTest;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginShouldWork() {
        LoginPage loginPage = new LoginPage();

        String message = loginPage
                .enterUserName("tomsmith")
                .enterPassword("SuperSecretPassword!")
                .clickLogin()
                .getFlashMessage();

        Assert.assertTrue(
                message.contains("You logged into a secure area!"),
                "Expected success message not found. Actual: " + message
        );
    }

    @Test
    public void invalidLoginShouldShowError() {
        LoginPage loginPage = new LoginPage();

        String message = loginPage
                .enterUserName("wrongUser")
                .enterPassword("wrongPass")
                .clickLogin()
                .getFlashMessage();

        Assert.assertTrue(
                message.toLowerCase().contains("invalid"),
                "Expected invalid login message. Actual: " + message
        );
    }
}