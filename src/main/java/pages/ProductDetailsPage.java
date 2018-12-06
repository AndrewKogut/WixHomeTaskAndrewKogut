package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//iframe[@aria-label='Product Page']")
    WebElement productDetailsPageIFrame;

    @FindBy(xpath = "//button[contains(@class, 'button-add-to-cart')]")
    WebElement addToCartButton;

    @FindBy(xpath = "//p[contains(@class, 'ddm1repeaterButtonlabel')]")
    WebElement storesButton;

    public CartPopUp addItemToCartFromProductPage() {
        executeInIFrame(productDetailsPageIFrame, () -> click(addToCartButton));
        return new CartPopUp(driver);
    }

    public ProductsPage goBackToProductPage() {
        executeInIFrame(productDetailsPageIFrame, () -> driver.navigate().back());
        return new ProductsPage(driver);
    }

}
