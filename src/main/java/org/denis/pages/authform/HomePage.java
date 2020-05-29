package org.denis.pages.authform;

import org.denis.driver.DriverHolder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;


public class HomePage {
    @FindBy(xpath = "//*[text()='Shop']")
    WebElement shopButton;

    @FindBy(xpath = "//*[@class='products']")
    List<WebElement> listArrivals;

    @FindBy(xpath = "//*[@class='products']//img")
    List<WebElement> listArrivalsImg;

    public ShopPage goToShop() {
        shopButton.click();
        return new ShopPage();
    }

    public ProductPage goToProductRandom() {
        Random randomizer = new Random();
        listArrivalsImg.get(randomizer.nextInt(listArrivals.size())).click();
        return new ProductPage();
    }

    public ProductPage goToProduct(int index) {
        listArrivalsImg.get(index).click();
        return new ProductPage();
    }

    public int countArrivals() {
        return listArrivals.size();
    }

    public HomePage() {
        PageFactory.initElements(DriverHolder.getINSTANCE().getDriver(), this);
    }
}
