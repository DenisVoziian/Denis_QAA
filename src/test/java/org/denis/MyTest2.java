package org.denis;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;


public class MyTest2 {
    WebDriver driver = null;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement href = driver.findElement(By.cssSelector("div.example a"));
        href.click();

        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(windowHandles.get(1));
        String text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(text, "New Window");

        Thread.sleep(5000);

        driver.close();
        driver.switchTo().window(windowHandles.get(0));

        Assert.assertTrue(driver.findElement(By.cssSelector("#content a")).isDisplayed());
    }

    @AfterClass
    public void afterClass() throws NullPointerException {
        driver.quit();
    }
}
