package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartViewPage extends BasePage {

    public CartViewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//iframe[@title='Cart Page']")
    WebElement cartViewPageIFrame;

    @FindBy(xpath = "//div[@class='_3ei-p']/h3[contains(text(), 'as')]/../../..//input[@type='number']")
    WebElement quantityOfProduct;


    public CartViewPage changeTheQuantityOfAddedProducts(String productName, int quantity) throws InterruptedException {
        executeInIFrame(cartViewPageIFrame, () -> {
            WebElement quantityOfProductField = driver.
                    findElement(By.xpath("//div[@class='_3ei-p']/h3[contains(text(), '" + productName + "')]/../../..//input[@type='number']"));
            writeNumbers(quantityOfProductField, quantity);
        });
        return new CartViewPage(driver);
    }

    public CartViewPage removeProductFromTheCartViewByName(String productName) {
        executeInIFrame(cartViewPageIFrame, () -> {
            WebElement removeLink = driver.findElement(By.xpath("//h3[contains(text(), '" + productName + "')]/..//button[@data-hook='remove-button']"));
            click(removeLink);
        });
        return new CartViewPage(driver);
    }


}
