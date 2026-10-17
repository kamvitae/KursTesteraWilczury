package pageObjects;

import selectors.ShopSelectors;

import static helpers.CommonUtils.click;
import static helpers.CommonUtils.getWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ShopFirstProductPage {

    public static String getProductName() {
        return getWait().until(visibilityOfElementLocated(ShopSelectors.PRODUCT_NAME))
                .getText()
                .trim();
    }

    public static void addProductToCart(){
        click(ShopSelectors.BUTTON_ADD_TO_CART);
    }

    //    /** Czeka aż licznik produktów widoczny przy koszyku zaktualizuje dodaną zawartość.
//     * Na razie nieużywany*/
//    public static void waitForCartCount(int expectedCount) {
//        getWait().until(driver ->
//                driver.findElements(By.xpath("//a[@href='/koszyk']//span[contains(@class,'rounded-full')]")).stream()
//                        .filter(WebElement::isDisplayed)
//                        .anyMatch(element ->
//                                element.getText().trim()
//                                        .equals(String.valueOf(expectedCount))
//                        )
//        );
//    }
}
