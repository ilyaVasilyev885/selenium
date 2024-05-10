package org.example;

import org.example.enums.Size;
import org.example.pages.CartPage;
import org.example.pages.ProductListingPage;
import org.example.utils.ScreenShotUtils;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ShoppingCartTest extends BaseTest {

    private ProductListingPage productListingPage;

    @BeforeMethod
    public void shoppingCartSetUp() {
        productListingPage = new ProductListingPage(driver);
        productListingPage.openUrl();
    }

    @Test
    public void compareFirstProductNamesTest() throws InterruptedException {
        WebElement firstProductElement = productListingPage.getFirstProduct();
        String firstProductName = productListingPage.getProductName(firstProductElement);
        CartPage cartPage = productListingPage.addToCartBtnClick(firstProductElement);

        Thread.sleep(500);
        List<String> allCartProductsNames = cartPage.getAllProductsNames();

        assertEquals(allCartProductsNames.size(), 1);
        assertEquals(firstProductName, allCartProductsNames.get(0));
        ScreenShotUtils.takeScreenshot(driver);

    }

    @Test
    public void compareAllProductsNamesTest() {
        List<String> allProductsNames = productListingPage.getAllProductsNames();
        List<CartPage> cartPages = productListingPage.addAllProductsToCart();

        List<String> allProductsNamesFromCart = cartPages.get(0).getAllProductsNames();

        assertEquals(allProductsNames, allProductsNamesFromCart);
        ScreenShotUtils.takeScreenshot(driver);
    }

    @Test
    public void compareProductBySizeTest() throws InterruptedException {
        List<String> allProductsNames = productListingPage.getAllProductsNames();
        productListingPage.findSizeElementAndClick(Size.S);

        Thread.sleep(500);

        List<String> allProductsNamesAfterClickSize = productListingPage.getAllProductsNames();

        assertTrue(allProductsNamesAfterClickSize.size() < allProductsNames.size());
        ScreenShotUtils.takeScreenshot(driver);
    }

    @Test
    public void compareProductsByHeader() throws InterruptedException {
        Thread.sleep(500);
        Integer allProductsNumber = productListingPage.getProductsNumberByHeader();

        productListingPage.findSizeElementAndClick(Size.XL);

        Thread.sleep(500);
        Integer sizeProductsNumber = productListingPage.getProductsNumberByHeader();

        assertTrue(sizeProductsNumber < allProductsNumber );
        ScreenShotUtils.takeScreenshot(driver);
    }

}
