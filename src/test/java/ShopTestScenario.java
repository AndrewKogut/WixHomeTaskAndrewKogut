import org.testng.annotations.Test;
import pages.HomePage;

public class ShopTestScenario extends BaseTest {


    @Test
    public void addProductToCardScenario() throws Exception {
        HomePage homePage = new HomePage(driver);

        homePage.goToHomePage()
                .verifyShopButtonText("SHOP")
                .goToProductsPage()
                .selectProductByNameFromGalleryAndClickQuickView("Glasses")
                .addItemToCart()
                .removeItemFromCart()
                .minimizeTheCartOnProductsPage()
                .selectProductByNameFromGalleryAndOpenDetails("Glasses")
                .addItemToCartFromProductPage()
                .minimizeTheCartOnProductDetailsPage()
                .goBackToProductPage()
                .goToBagOfItems()
                .minimizeTheCartOnProductsPage()
                .selectProductByNameFromGalleryAndClickQuickView("product")
                .addItemToCart()
                .goToCartViewPage()
                .changeTheQuantityOfAddedProducts("Glasses",3)
                .removeProductFromTheCartViewByName("product");
    }

}
