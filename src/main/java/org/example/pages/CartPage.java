package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(css = ".sc-11uohgb-0.hDmOrM")
    private List<WebElement> allProductsElements;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getAllProducts() {
        return allProductsElements;
    }

    public List<String> getAllProductsNames() {
        return allProductsElements.stream()
                .map(element -> element.findElement(By.cssSelector(".sc-11uohgb-2.elbkhN")).getText())
                .toList();
    }
}
