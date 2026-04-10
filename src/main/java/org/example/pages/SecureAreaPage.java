package org.example.pages;

import org.openqa.selenium.By;

public class SecureAreaPage extends BasePage {

   private final By flashmsg = By.id("flash");
    private final By logoutButton = By.cssSelector("a.button.secondary.radius");

public String getsuccessmsg(){
    return gettext(flashmsg);
}
public boolean IsLoggoutbuttonDisplayed(){
    return isDisplayed(logoutButton);

}
public LoginPage clickLogout(){
    Click(logoutButton);
    return new LoginPage();
}
}
