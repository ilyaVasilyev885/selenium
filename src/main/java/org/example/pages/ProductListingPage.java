package org.example.pages;

import org.example.enums.Size;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductListingPage extends BasePage {

    @FindBy(css = ".sc-124al1g-2.dwOYCh")
    private WebElement firstProductElement;

    @FindBy(className = "sc-124al1g-2")
    private List<WebElement> allProductsElements;

    @FindBy(xpath = "//main[@class = 'sc-ebmerl-4 iliWeY']/p")
    private WebElement header;

    public ProductListingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openUrl() {
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
    }

    public WebElement getFirstProduct() {
        return firstProductElement;
    }

    public List<String> getAllProductsNames() {
        return allProductsElements.stream()
                .map(this::getProductName)
                .toList();
    }

    public List<CartPage> addAllProductsToCart() {
        return allProductsElements.stream()
                .map(this::addToCartBtnClick)
                .toList();
    }

    public String getProductName(WebElement productElement) {
        return productElement.findElement(By.cssSelector(".sc-124al1g-4.eeXMBo")).getText();
    }

    public CartPage addToCartBtnClick(WebElement productElement) {
        productElement.findElement(By.cssSelector(".sc-124al1g-0.jCsgpZ")).click();
        return new CartPage(driver);
    }

    public void findSizeElementAndClick(Size size) {
        WebElement element = driver.findElement(By.xpath(String.format("//span[text() = '%s']", size.toString())));
        element.click();
    }

    public Integer getProductsNumberByHeader() {
        String productsNumber = header.getText().split(" ")[0];
        return Integer.parseInt(productsNumber.trim());
    }

}

