package com.ejemplo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartSummaryPage extends BasePage {

    public ShoppingCartSummaryPage(WebDriver driver) {
        super(driver);
    }

    public void verificationItemAddedInShoppingCart() {
        WebElement cartQuantityLabel = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("summary_products_quantity"))
        );

        String numProductsLabelText = cartQuantityLabel.getText().trim();
        // Ej: "1 Product" → nos quedamos con el primer "trozo"
        int numProducts = Integer.parseInt(numProductsLabelText.split(" ")[0]);
        assertEquals(1, numProducts);
    }
}
