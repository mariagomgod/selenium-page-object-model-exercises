package com.ejemplo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserAccountPage extends BasePage {

    public UserAccountPage(WebDriver driver) {
        super(driver);
    }

    By homeLinkLocator = By.cssSelector("a.home");

    public void navigateToHomePage() {
        WebElement homeLink = wait.until(
                ExpectedConditions.visibilityOfElementLocated(homeLinkLocator)
        );
        homeLink.click();
    }
}
