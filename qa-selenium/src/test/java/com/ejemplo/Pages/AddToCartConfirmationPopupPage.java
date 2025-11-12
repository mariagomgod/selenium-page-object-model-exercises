package com.ejemplo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AddToCartConfirmationPopupPage extends BasePage {

    public AddToCartConfirmationPopupPage(WebDriver driver) {
        super(driver);
    }

    public void checkout() {
        WebElement proceedToCheckoutButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Proceed to checkout']"))
        );
        proceedToCheckoutButton.click();
    }
}
