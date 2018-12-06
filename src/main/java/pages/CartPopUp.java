package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPopUp extends BasePage {

    public CartPopUp(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//div[@class = 's_yOSHETPAPopupSkin']//iframe")
    WebElement cartPopUpIFrame;

    @FindBy(xpath = "//button[@class = 'remove-item' and @title = 'Remove Item']")
    WebElement removeItemIcon;

    @FindBy(xpath = "//button[@class = 'cart-widget-close rotate' and @id = 'cart-widget-close']")
    WebElement minimizeTheCartIcon;

    @FindBy(xpath = "//a[@class = 'button-primary is-button-wide']")
    WebElement viewCartButton;

    @FindBy(xpath = "//section[@class = 'cart-content']//li[1]")
    WebElement firstItemInCartPopUp;

    public ProductsPage minimizeTheCartOnProductsPage() {
        executeInIFrame(cartPopUpIFrame, () -> click(minimizeTheCartIcon));
        return new ProductsPage(driver);
    }

    public ProductDetailsPage minimizeTheCartOnProductDetailsPage() {
        executeInIFrame(cartPopUpIFrame, () -> click(minimizeTheCartIcon));
        return new ProductDetailsPage(driver);
    }

    public CartViewPage goToCartViewPage() {
        executeInIFrame(cartPopUpIFrame, () -> click(viewCartButton));
        return new CartViewPage(driver);
    }

    public CartPopUp removeItemFromCart() {
        executeInIFrame(cartPopUpIFrame, () -> {
            hoverCursor(firstItemInCartPopUp);
            click(removeItemIcon);
        });
        return new CartPopUp(driver);
    }
}
