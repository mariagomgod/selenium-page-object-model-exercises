package com.ejemplo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    By signInButtonLocator = By.cssSelector("a.login");
    By productLocator = By.cssSelector("a.product-name");

    public void clickSignInButton() {
        WebElement signInLink = wait.until(
                ExpectedConditions.visibilityOfElementLocated(signInButtonLocator)
        );
        signInLink.click();
    }

    public void clickOnFirstProduct() {
        List<WebElement> productLinks = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(productLocator)
        );
        WebElement firstProductLink = wait.until(
                ExpectedConditions.elementToBeClickable(productLinks.get(0))
        );
        firstProductLink.click();
    }
}
