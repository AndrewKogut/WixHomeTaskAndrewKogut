package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage (WebDriver driver) {
        super(driver);
    }

    String baseURL = "https://georgel8.wixsite.com/ait-ht";

    @FindBy(id = "comp-jhalo8eilabel")
    WebElement shopButton;

    public HomePage goToHomePage (){
        driver.get(baseURL);
        return this;
    }

    public ProductsPage goToProductsPage (){
        click(shopButton);
        return new ProductsPage(driver);
    }

    public HomePage verifyShopButtonText(String expectedText) {
        verifyText(shopButton, expectedText);
        return this;
    }

}
