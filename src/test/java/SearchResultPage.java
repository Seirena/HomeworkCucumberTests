import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {
    private final WebDriver webDriver;

    public SearchResultPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private static final By closeFarmerWindowButtonLocator = By.xpath("//*[@class=\"custom-icon modal-container-header__close-button-icon icon-close\"]");
    private static final By firstItemCardLocator = By.xpath("(//*[@class=\"product-tile\"])[1]");
    private static final By addToCartButtonLocator = By.xpath("//*[contains(text(),'В корзину')]");
    private static final By plusItemButtonLocator = By.xpath("//*[@class=\"custom-icon item-quantity__button-icon icon-increment\"]");
    private static final By amountOfItemsInCartLocator = By.xpath("(//*[@class=\"added-product-count\"])[2]");
    private static final By itemsCounterLocator = By.xpath("//*[@class=\"item-quantity__count\"]");

    public void CloseNewFarmerWindowWindow(){
        webDriver.findElement(closeFarmerWindowButtonLocator).click();
    }
    public void GoToFirstItemCard(){
        webDriver.findElement(firstItemCardLocator).click();
    }
    public void ClickAddToCartButton(){
        webDriver.findElement(addToCartButtonLocator).click();
    }
    public void ClickPlusButton(){
        webDriver.findElement(plusItemButtonLocator).click();
    }
    public By FindItemsCounter(){
        return itemsCounterLocator;
    }
    public By FindAmountOfItemsInCart(){
        return amountOfItemsInCartLocator;
    }
    public String GetAmountOfItems() {
        return webDriver.findElement(amountOfItemsInCartLocator).getText();
    }
    public By FindFarmerWindow(){
        return closeFarmerWindowButtonLocator;
    }
}
