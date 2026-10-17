package pageObjects;

import org.openqa.selenium.By;

import static helpers.CommonUtils.click;

/** Na stronie sklepu obecne są przekierowania.
 * Możemy automatycznie zaakceptować  żeby nie powrócić na strone główną.
 * Na razie nieużywane. xpath do wymiany*/
public class ShopRedirectPage {
    public static void openProducts(){
        //html/body/div[2]/div[3]/div[3]/a[2] //button alertu "zobacz produkty"
        click(By.xpath("//html/body/div[2]/div[3]/div[3]/a[2]"));
    }
}
