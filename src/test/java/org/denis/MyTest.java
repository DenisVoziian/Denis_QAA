package org.denis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class MyTest {
    WebDriver driver = null;

    @BeforeClass
    public void beforeClassMethod() {
        File file = new File("C:/Users/voziian/Downloads/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void TestTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement buttonRemove = driver.findElement(By.xpath("//*[@id='checkbox-example']/button[text()='Remove']"));
        buttonRemove.click();
        Thread.sleep(15000);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement message = driver.findElement(By.xpath("//*[@id='message']"));
        WebElement buttonAdd = driver.findElement(By.xpath("//*[@id='checkbox-example']/button[text()='Add']"));
        WebElement loading = driver.findElement(By.xpath("//*[@id='loading']"));
        wait.until(ExpectedConditions.visibilityOf(loading));
        wait.until(ExpectedConditions.invisibilityOf(loading));

        Assert.assertEquals(message.getText(), "It's gone!");


//        List<WebElement> elements = driver.findElements(By.cssSelector(".g.rc"));
//
//        for (WebElement element : elements) {
//            Assert.assertTrue(element.getText().contains("Selenium"));
//        }
    }
}
