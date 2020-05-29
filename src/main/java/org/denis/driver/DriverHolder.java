package org.denis.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverHolder {
    private WebDriver driver;
    private static DriverHolder INSTANCE = null;
    private WebDriverWait webDriverWaiter;

    public static DriverHolder getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new DriverHolder();
        }
        return INSTANCE;
    }

    public void initDriver(DriverType driverType) {
        driver = DriverFactory.initDriver(driverType);
        webDriverWaiter = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    public WebDriverWait getWebDriverWaiter(){
        return webDriverWaiter;
    }

    public WebDriver getDriver(){
        return driver;
    }

    private DriverHolder() {

    }

}
