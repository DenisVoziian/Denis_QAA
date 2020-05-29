package org.denis.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverFactory {
    public static WebDriver initDriver(DriverType driverType) {
        switch (driverType) {
            case OPERA: {
                WebDriverManager.operadriver().setup();
                return new OperaDriver();
            }
            case FIREFOX: {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }
            case CHROME:
            default: {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }
        }
    }

    public static WebDriver initDriver() {
        DriverType driverType = DriverType.valueOf(System.getProperty("driver.type").toUpperCase());
        return initDriver(driverType);
    }
}
