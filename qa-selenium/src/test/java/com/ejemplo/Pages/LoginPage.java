package com.ejemplo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By emailAddressLocator = By.id("email");
    By passwordLocator = By.id("passwd");
    By submitLoginLocator = By.id("SubmitLogin");

    public void setEmailAddress(String email) {
        WebElement emailTextbox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(emailAddressLocator)
        );
        emailTextbox.clear();
        emailTextbox.sendKeys(email);
    }

    public void setPassword(String password) {
        WebElement passwordTextbox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(passwordLocator)
        );
        passwordTextbox.clear();
        passwordTextbox.sendKeys(password);
    }

    public void clickSignInButton() {
        WebElement signInButton = wait.until(
                ExpectedConditions.elementToBeClickable(submitLoginLocator)
        );
        signInButton.click();
    }
}
