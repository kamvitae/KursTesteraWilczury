package pageObjects;

import org.openqa.selenium.WebElement;
import selectors.ShopSelectors;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static helpers.CommonUtils.getWait;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingCartPage {

    private static final Pattern NUMBER = Pattern.compile("\\d+(?:[.,]\\d+)?");

    public static void assertProductIsPresent(String expectedProductName) {

        List<String> nameNumbers = extractNumbers(expectedProductName);

        boolean productCardIsVisible = getWait().until(driver ->
                driver.findElements(ShopSelectors.CART_PRODUCT_CARDS).stream()
                        .filter(WebElement::isDisplayed)
                        .map(WebElement::getText)
                        .anyMatch(cardText -> containsAllNumbers(cardText, nameNumbers))
        );

        assertTrue(
                productCardIsVisible,
                "Nie znaleziono w koszyku produktu: " + expectedProductName
        );
    }

    private static boolean containsAllNumbers(String text, List<String> expectedNumbers) {
        List<String> actualNumbers = extractNumbers(text);
        return !expectedNumbers.isEmpty() && actualNumbers.containsAll(expectedNumbers);
    }

    private static List<String> extractNumbers(String text) {
        Matcher matcher = NUMBER.matcher(text.replace(" ", ""));
        return matcher.results()
                .map(result -> result.group().replace(',', '.'))
                .toList();
    }
}
