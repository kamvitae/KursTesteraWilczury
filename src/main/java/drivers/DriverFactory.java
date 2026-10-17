package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static WebDriver driver;

    private DriverFactory() {
    }

    public static void startDriver() {
        if (driver != null) {
            throw new IllegalStateException("Driver został już uruchomiony");
        }

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException(
                    "Driver nie został uruchomiony. Brakuje wywołania startDriver()."
            );
        }

        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
