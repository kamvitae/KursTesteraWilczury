package selectors;

import org.openqa.selenium.By;

public class ShopSelectors {
    public static final By BUTTON_ADD_TO_CART = By.xpath(
            "//button[normalize-space(.)='Dodaj do koszyka']");
    public static final By BUTTON_CHECK_MY_CART = By.cssSelector("a[href$='/koszyk']");
    public static final By BUTTON_ACCEPT_ESSENTIAL_COOKIES = By.xpath(
            "//button[normalize-space(.)='Tylko niezbędne']"
    );
    public static final By CATEGORY_SIMPLE_PRODUCTS = By.xpath(
            "//a[normalize-space(.)='Produkty proste']");
    public static final By CATEGORY_COLLECTION2026 = By.xpath(
            "//*[normalize-space(.)='Kolekcja 2026']");
    public static final By FIRST_PRODUCT_LINK = By.xpath(
            "(//main//a[@href][.//img])[1]");
    public static final By PRODUCT_NAME = By.cssSelector("main h1");
    public static final By CART_PRODUCT_CARDS = By.xpath(
            "//main//div[@data-slot='card-content']" +
                    "[.//h3/a[contains(@href, '/produkty/')]]");
}
