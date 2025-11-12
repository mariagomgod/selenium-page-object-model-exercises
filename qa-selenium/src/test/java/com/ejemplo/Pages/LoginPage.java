package com.ejemplo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setEmailAddress(String email) {
        WebElement emailTextbox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("email"))
        );
        emailTextbox.clear();
        emailTextbox.sendKeys(email);
    }

    public void setPassword(String password) {
        WebElement passwordTextbox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("passwd"))
        );
        passwordTextbox.clear();
        passwordTextbox.sendKeys(password);
    }

    public void clickSignInButton() {
        WebElement signInButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("SubmitLogin"))
        );
        signInButton.click();
    }
}
