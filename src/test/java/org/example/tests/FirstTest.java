package org.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//This is sample java file to launch and test if selenium setup is working or not

public class FirstTest {

    @Test
    public void openGoogle() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.Linkedin.com");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

driver.quit();
    }
}
