package pageObjects;

import selectors.ShopSelectors;

import static helpers.CommonUtils.click;

public class ShopProductsPage {

    public static void openFirstProduct(){
        click(ShopSelectors.FIRST_PRODUCT_LINK);
    }
}
