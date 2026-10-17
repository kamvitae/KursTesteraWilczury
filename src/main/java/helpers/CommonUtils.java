package helpers;

import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DecimalFormat;
import java.time.Duration;

import static drivers.DriverFactory.getDriver;

public class CommonUtils {

    private static final Duration DEF_TIMEOUT = Duration.ofSeconds(15);

    /** DEF_TIMEOUT sec. WebDriverWait**/
    public static WebDriverWait getWait(){
        return new WebDriverWait(getDriver(), DEF_TIMEOUT);
    }

    /** Kliknij w podany element. Ponawia wyszukanie, jeśli DOM wymieni element przed kliknięciem. **/
    public static void click(By locator) {
        getWait().until(driver -> {
            try {
                WebElement element = driver.findElement(locator);

                if (element.isDisplayed() && element.isEnabled()) {
                    element.click();
                    return true;
                }
            } catch (StaleElementReferenceException e) {
                return false;
            }

            return false;
        });
    }

    /** Bardziej rozbudowany click upewniający się, że znaleziony element nie jest ukryty.
     * Korzysta z findElements() zamiast findElement().
     * Powinno być odporne na przebudowanie strony*/
    public static void clickVisible(By locator) {
        getWait().until(driver -> {
            try {
                WebElement element = driver.findElements(locator).stream()
                        .filter(WebElement::isDisplayed)
                        .filter(WebElement::isEnabled)
                        .findFirst()
                        .orElse(null);

                if (element == null) {
                    return false;
                }

                element.click();
                return true;
            } catch (StaleElementReferenceException e) {
                return false;
            }
        });
    }

    /** Sprawdza widoczność elementu. **/
    public static boolean elementIsDisplayed(WebDriver driver, By locator){
        return driver.findElement(locator).isDisplayed();
    }
    /** Sprawdza czy element jest zaznaczony.
     * Zbędna?
     **/
    public static boolean elementIsSelected(WebDriver driver, By locator){
        return driver.findElement(locator).isSelected();

    }
    /** Wypisz podany tekst w elemencie. Używa getWait() by upewnić się, że element jest klikalny. **/
    public static void type(By locator, String text){

        getWait().until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text);
    }

    /** Przewija widok strony do wskazanego elementu.
     * Zdarza się, że np footer przesłania przycisk i blokuje skuteczność testu zawierającego click()*/
    public static void scrollToElement(By locator) {
        WebElement element = getWait().until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );

        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        js.executeScript(
                "arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});",
                element
        );
    }

    /** Wyślij wskazany plik do formularza.*/
    public static void fileUpload(By locator, String path){
        getDriver().findElement(locator).sendKeys(path);
    }

    public static String getRandomNumberBetween(int min, int max){
        DecimalFormat formatter = new DecimalFormat("#");
        return formatter.format(min + Math.floor(max-min) * Math.random());
    }

    public static String getRandomPhone(){
        return getRandomNumberBetween(100000000,999999999);
    }

    public static String getRandomName(int number){
        String randomName = RandomString.make(number).toLowerCase();
        return randomName;
    }

    public static String getRandomMail(int number){
        return getRandomName(number)+"@gmail.com";
    }


}
