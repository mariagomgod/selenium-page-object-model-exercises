package com.ejemplo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Linear Shopping Cart tests for Java
public class LinearCartTests {

    @Test
    public void LinearAddToCartTest() {

        // Inicialización
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navegar al website
        driver.get("http://www.automationpractice.pl/index.php");

        // Navegar a la página de login
        WebElement signInLink = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.login"))
        );
        signInLink.click();

        // Hacer login
        WebElement emailTextbox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("email"))
        );
        emailTextbox.sendKeys("testautomation@test.com");
        WebElement passwordTextbox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("passwd"))
        );
        passwordTextbox.sendKeys("Testing@@123");
        WebElement signInButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("SubmitLogin"))
        );
        signInButton.click();

        // Navegar de nuevo a la home page
        WebElement homeLink = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.home"))
        );
        homeLink.click();

        // Seleccionar el primer producto
        List<WebElement> productLinks = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("a.product-name"))
        );
        WebElement firstProductLink = wait.until(
                ExpectedConditions.elementToBeClickable(productLinks.get(0))
        );
        firstProductLink.click();

        // Añadir el producto a la shopping cart
        WebElement addToCartButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='add_to_cart']/button"))
        );
        addToCartButton.click();

        // Proceder al checkout

        WebElement proceedToCheckoutButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Proceed to checkout']"))
        );
        proceedToCheckoutButton.click();

        // Verificar que hay un producto añadido en la Shopping cart
        WebElement cartQuantityLabel = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("summary_products_quantity"))
        );

        String numProductsLabelText = cartQuantityLabel.getText().trim();
        // Ej: "1 Product" → nos quedamos con el primer "trozo"
        int numProducts = Integer.parseInt(numProductsLabelText.split(" ")[0]);
        assertEquals(1, numProducts);

        // Cerramos el navegador
        driver.quit();
    }

}
