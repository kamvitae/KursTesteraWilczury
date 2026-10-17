package pageObjects;

import selectors.ShopSelectors;

import static helpers.CommonUtils.clickVisible;

public class ShopHeader {
    /**
     * Ten przycisk jest dostępny z każdej strony sklepu w nagłówku.
     * Metoda nie powinna znaleźć się w ShopHomePage?
     * Czy tutaj, bo w scenariuszu wywołujemy ją ze strony produktu?
     * */
    public static void openCart(){
        clickVisible(ShopSelectors.BUTTON_CHECK_MY_CART);
//        click(By.xpath(
//                "/html/body/div[2]/div/header/div/div[2]/div[1]/a[1]/svg"));
        //są na stronie dwa takie elementy
        //nieprecyzyjne ale na razie działa. chcemy tylko ustawić ogóra do działania
    }
}
