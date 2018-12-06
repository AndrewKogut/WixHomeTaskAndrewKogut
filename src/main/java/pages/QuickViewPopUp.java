package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuickViewPopUp extends BasePage {

    public QuickViewPopUp (WebDriver driver){
        super(driver);
    }

    @FindBy(className = "s_WgMETPAModalSkiniframe")
            WebElement quickViewPopUpIFrame;

    @FindBy(xpath = "//button[contains(@class, 'button-add-to-cart')]")
            WebElement addToCart;

    public CartPopUp addItemToCart() {
        executeInIFrame(quickViewPopUpIFrame, () -> click(addToCart));
        return new CartPopUp(driver);
    }
}
