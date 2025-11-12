package com.ejemplo;

import com.ejemplo.Pages.HomePage;
import com.ejemplo.Pages.LoginPage;
import com.ejemplo.Pages.AddToCartConfirmationPopupPage;
import com.ejemplo.Pages.ProductDetailPage;
import com.ejemplo.Pages.ShoppingCartSummaryPage;
import com.ejemplo.Pages.UserAccountPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Linear Shopping Cart tests for Java
public class POMCartTests {

    @Test
    public void POMAddToCartTest() {

        // Inicialización
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navegar al website
        driver.get("http://www.automationpractice.pl/index.php");

        // Navegar a la página de login
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();

        // Hacer login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmailAddress("testautomation1234@test.com");
        loginPage.setPassword("Testing@@123");
        loginPage.clickSignInButton();

        // Navegar de nuevo a la home page
        UserAccountPage userAccountPage = new UserAccountPage(driver);
        userAccountPage.navigateToHomePage();

        // Seleccionar el primer producto
        homePage.clickOnFirstProduct();

        // Añadir el producto a la shopping cart
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        productDetailPage.clickAddToCartButton();

        // Proceder al checkout
        AddToCartConfirmationPopupPage addToCartConfirmationPopupPage = new AddToCartConfirmationPopupPage(driver);
        addToCartConfirmationPopupPage.checkout();

        // Verificar que hay un producto añadido en la Shopping cart
        ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
        shoppingCartSummaryPage.verificationItemAddedInShoppingCart();

        // Cerramos el navegador
        driver.quit();
    }

}
