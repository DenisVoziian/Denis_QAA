package org.denis.pages.authform;

import org.denis.driver.DriverHolder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage {
    @FindBy(xpath = "//*[text()='Home']")
    WebElement buttonHome;

    public HomePage goToHome(){
        buttonHome.click();
        return new HomePage();
    }

    public ShopPage() {
        PageFactory.initElements(DriverHolder.getINSTANCE().getDriver(), this);
    }
}
