package org.denis;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeTask_11 {
    WebDriver driver = null;
    By buttonJsConfirm = By.xpath("//button[text()='Click for JS Confirm']");
    By buttonJsPrompt = By.xpath("//button[text()='Click for JS Prompt']");
    By result = By.id("result");

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterClass
    public void afterClass() throws NullPointerException {
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
        /* Тест1: Обработка нажатия на кнопку Click for JS Confirm и выбор Ок
    Перейти на http://the-internet.herokuapp.com/javascript_alerts
    Нажат Click for JS Confirm кнопку
    В алерте выбрать Оk
    Проверить надпись в секции Result */
    public void TestJSConfirm_accept() {
        driver.findElement(buttonJsConfirm).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        String outputText = driver.findElement(result).getText();
        Assert.assertEquals(outputText, "You clicked: Ok");
    }

    @Test
        /* Test2: Обработка нажатия на кнопку Click for JS Confirm и выбор Cencel
    Шаги те же но выбрать Cancel */
    public void TestJSConfirm_dismiss() {
        driver.findElement(buttonJsConfirm).click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        String outputText = driver.findElement(result).getText();
        Assert.assertEquals(outputText, "You clicked: Cancel");
    }

    @Test
        /* Test3: Обработка кнопки Click for JS Prompt
    Шаги теже что и в предыдущих тестах, но проверить ввод текста в prompt */
    public void TestJSPrompt_AcceptWithText() {
        driver.findElement(buttonJsPrompt).click();

        Alert alert = driver.switchTo().alert();
        String text = "TestText";
        alert.sendKeys(text);
        alert.accept();

        String outputText = driver.findElement(result).getText();
        Assert.assertEquals(outputText, "You entered: " + text);
    }

    @Test
        /* Тест4:
    Шаги теже что и в предыдущих тестах,но проверить без ввода текста в prompt */
    public void TestJSPrompt_AcceptWithoutText() {
        driver.findElement(buttonJsPrompt).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        String outputText = driver.findElement(result).getText();
        Assert.assertEquals(outputText, "You entered:");
    }

    @Test
        /* Тесты5:
    Шаги теже что и в предыдущих тестах, но проверить ввод текста и нажать cencel */
    public void TestJSPrompt_DismissWithText() {
        driver.findElement(buttonJsPrompt).click();

        Alert alert = driver.switchTo().alert();
        String text = "TestText";
        alert.sendKeys(text);
        alert.dismiss();

        String outputText = driver.findElement(result).getText();
        Assert.assertEquals(outputText, "You entered: null");
    }

    @Test
        /* Тест6:
    Шаги теже что и в предыдущих тестах, но проверить без ввода текста в prompt и нажать cancel */
    public void TestJSPrompt_DismissWithoutText() {
        driver.findElement(buttonJsPrompt).click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        String outputText = driver.findElement(result).getText();
        Assert.assertEquals(outputText, "You entered: null");
    }
}
