package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//iframe[@aria-label='Shop']")
    WebElement productsIFrame;

    @FindBy(xpath = "//iframe[@aria-label='Wix Stores']")
    WebElement bagIFrame;

    @FindBy(xpath = "//a[@data-hook='cart-icon-button']")
    WebElement bagOfItemIcon;

    public QuickViewPopUp selectProductByNameFromGalleryAndClickQuickView(String productName) {
        executeInIFrame(productsIFrame, () -> {
            WebElement productPicture = driver.findElement(By.xpath("//h3[contains(text(), '" + productName + "')]/../.."));
            hoverCursor(productPicture);
            WebElement quickViewButton = driver.findElement(By.xpath("//h3[contains(text(), '" + productName + "')]/../..//button[@class='quickview-button']"));
            click(quickViewButton);
        });
        return new QuickViewPopUp(driver);
    }

    public ProductDetailsPage selectProductByNameFromGalleryAndOpenDetails(String productName) {
        executeInIFrame(productsIFrame, () -> {
            WebElement productNameLink = driver.findElement(By.xpath("//h3[contains(text(), '" + productName + "')]"));
            click(productNameLink);
        });
        return new ProductDetailsPage(driver);
    }

    public CartPopUp goToBagOfItemsAlternative() {
        if (bagIFrame.isEnabled()) {
            executeInIFrame(bagIFrame, () -> click(bagOfItemIcon));
        } else {
            click(bagOfItemIcon);
        }
        return new CartPopUp(driver);
    }

    public CartPopUp goToBagOfItems() {
            click(bagOfItemIcon);
        return new CartPopUp(driver);
    }

}