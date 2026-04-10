package org.example.tests;

import org.example.base.BaseTest;
import org.example.pages.LoginPage;
import org.example.pages.LogoutPage;
import org.example.pages.SecureAreaPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.PseudoColumnUsage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginShouldWork() {
        SecureAreaPage secureAreaPage = new LoginPage()
                .loginValid("tomsmith", "SuperSecretPassword!");

        Assert.assertTrue(
                secureAreaPage.IsLoggoutbuttonDisplayed(),
                "Logout button should be visible after successful login."
        );

        Assert.assertTrue(
                secureAreaPage.getsuccessmsg().contains("You logged into a secure area!"),
                "Success message was not displayed correctly."
        );
    }

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {
        return new Object[][]{
                {"wrongUser", "wrongPass", "Your username is invalid!"},
                {"tomsmith", "wrongPass", "Your password is invalid!"}
        };
    }

    @Test(dataProvider = "invalidLoginData")
    public void invalidLoginShouldShowError(String username, String password, String expectedMessage) {
        LoginPage loginPage = new LoginPage()
                .loginInvalid(username, password);

        Assert.assertTrue(
                loginPage.getErrorMessage().contains(expectedMessage),
                "Expected error message not shown. Actual: " + loginPage.getErrorMessage()
        );
    }

    @Test
    public void loggedoutSuccessfully() {
        SecureAreaPage secure = new LoginPage()
                .loginValid("tomsmith", "SuperSecretPassword!");

        LoginPage loginPage = secure.clickLogout();

        Assert.assertTrue(
                loginPage.getErrorMessage().contains("You logged out of the secure area!"),
                "Logged out successfully message was not displayed"
        );
    }
}