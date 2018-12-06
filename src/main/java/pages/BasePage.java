package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utils.Action;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = init(driver);
        wait = new WebDriverWait(driver, 60);
    }

    public WebDriver init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
        return driver;
    }

    public void executeInIFrame(WebElement iframe, Action action) {
        waitFrameAndSwitchToIt(iframe);
        //switchToIFrame(iframe);
        action.run();
        exitFromIFrame();
    }

    public void waitVisibility(WebElement elementBy) {
        wait.until(ExpectedConditions.visibilityOf(elementBy));
    }

    public void waitFrameAndSwitchToIt(WebElement elementBy) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(elementBy));
    }

    public void click(WebElement elementBy) {
        waitVisibility(elementBy);
        elementBy.click();
    }

    public void writeNumbers(WebElement elementBy, int number) {
        wait.until(ExpectedConditions.visibilityOf(elementBy));
        elementBy.sendKeys(Keys.chord(Keys.CONTROL, "a"), String.valueOf(number));
    }

    public String readText(WebElement elementBy) {
        wait.until(ExpectedConditions.visibilityOf(elementBy));
        return elementBy.getText();
    }

    public void assertEquals(WebElement elementBy, String expectedText) {
        wait.until(ExpectedConditions.visibilityOf(elementBy));
        Assert.assertEquals(readText(elementBy), expectedText);

    }

    public void switchToIFrame(WebElement frameName) {
        waitVisibility(frameName);
        driver.switchTo().frame(frameName);
    }

    public void exitFromIFrame() {
        driver.switchTo().defaultContent();
    }

    public void hoverCursor(WebElement webElement) {
        waitVisibility(webElement);
        Actions action = new Actions(driver);
        action.moveToElement(webElement).pause(1000).build().perform();
    }

    public void verifyText(WebElement elementBy, String expectedText) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(readText(elementBy), expectedText, "Text incorrect");
    }

    public boolean isElementOnTheRightSide(WebElement webElement) {
        int windowWidth = driver.manage().window().getSize().getWidth();
        int elementX = webElement.getLocation().getX();

        return (double) elementX / windowWidth > 0.65;
    }
}




