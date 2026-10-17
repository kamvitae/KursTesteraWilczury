package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selectors.ShopSelectors;
import strings.ShopStrings;

import static drivers.DriverFactory.getDriver;
import static helpers.CommonUtils.clickVisible;
import static helpers.CommonUtils.getWait;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopHomePage {

    public static void openHomepage(){
        getDriver().get(ShopStrings.SHOPSTAG_BASE_URL);
        assertEquals(ShopStrings.SHOPSTAG_BASE_URL,
                getDriver().getCurrentUrl());
    }

    public static void  acceptEssentialCookies(){
        clickVisible(ShopSelectors.BUTTON_ACCEPT_ESSENTIAL_COOKIES);
    }

    /** wiem, że lokator do dupy ale na razie próbuję zmusić ogóra do działania*/
    public static void openSimpleProductsCategory(){

        WebElement visibleCollection = getWait().until(driver ->
                driver.findElements(ShopSelectors.CATEGORY_COLLECTION2026).stream()
                        .filter(WebElement::isDisplayed)
                        .findFirst()
                        .orElse(null)
        );

        new Actions(getDriver())
                .moveToElement(visibleCollection)
                .perform();

        clickVisible(ShopSelectors.CATEGORY_SIMPLE_PRODUCTS);

        getWait().until(ExpectedConditions.urlContains(
                "/kategoria/produkty-proste"));
    }
}


