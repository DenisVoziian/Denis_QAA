package org.denis.testHW;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHomePage extends BaseTest {

    @Test(priority = 1)
    public void homePageContainsOnlyThreeArrivals() {
        homePage.goToShop();
        shopPage.goToHome();

        Assert.assertEquals(homePage.countArrivals(), 3);
    }

    @Test(priority = 2)
    public void homePageNavigateToProductPage() {
        homePage.goToProductRandom();

        Assert.assertTrue(productPage.addToBasketButtonIsDisplayed());
    }

    @Test(priority = 3)
    public void homePageDescriptionRegardingBookClickedOn() {
        homePage.goToProductRandom();
        productPage.clickOnDescriptionTab();

        Assert.assertTrue(productPage.compareDescription());
    }

    @Test(priority = 4)
    public void homePageReviewsRegardingBookClickedOn() {
        homePage.goToProductRandom();
        productPage.clickOnReviewsTab();

        Assert.assertTrue(productPage.compareReviewTitleAndProductTitle());
    }

    @Test(priority = 5)
    public void homePageAddBookToBasket() {
        homePage.goToProductRandom();
        productPage.clickOnAddToBasketButton();

        Assert.assertTrue(productPage.bookAddedToBasketMessageIsDisplayed());
    }

    @Test(priority = 6)
    public void homePageVerifyBasket() {
        homePage.goToProduct(1);

        String productNameOnProdPage = productPage.getProductNameOnProdPage();
        String productPriceOnProdPage = productPage.getProductPriceOnBProdPage();

        productPage.clickOnAddToBasketButton()
                .clickOnCartLink();

        Assert.assertEquals(productNameOnProdPage, basketPage.getProductNameOnBasket());
        Assert.assertEquals(productPriceOnProdPage, basketPage.getProductPriceOnBasket());
    }


}
