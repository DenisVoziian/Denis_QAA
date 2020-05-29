package org.denis.pages.authform;

import org.denis.driver.DriverHolder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage {
    @FindBy(css = "td.product-name")
    WebElement productNameOnBasket;

    @FindBy(css = "td.product-price")
    WebElement productPriceOnBasket;

    public String getProductNameOnBasket(){
        return productNameOnBasket.getText();

    }

    public String getProductPriceOnBasket(){
        return productPriceOnBasket.getText();
    }

    public BasketPage() {
        PageFactory.initElements(DriverHolder.getINSTANCE().getDriver(), this);
    }
}

