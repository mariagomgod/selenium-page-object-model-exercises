package com.ejemplo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailPage extends BasePage {

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    By addToCartButtonLocator = By.xpath("//p[@id='add_to_cart']/button");

    public void clickAddToCartButton() {
        WebElement addToCartButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(addToCartButtonLocator)
        );
        addToCartButton.click();
    }
}
