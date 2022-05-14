import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddItemsToBagTest {
    public static WebDriver driver;
    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    MainPage mainPage = new MainPage(driver);
    SearchResultPage ozonSearchResultPage = new SearchResultPage(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));



    @Given("user is on Svoe_Rodnoe main page")
    public void user_is_on_Svoe_Rodnoe_main_page() {
        mainPage.OpenPage();
    }

    @And("user choose his city is {string}")
    public void user_choose_his_city_is(String city) {
        mainPage.ChooseCity(city);
    }

    @When("user search {string}")
    public void user_search(String searchParam){
        mainPage.SearchItem(searchParam);
        mainPage.ClickSearchButton();
    }

    @And("click on item button of first result")
    public void click_On_Item_Button_Of_First_Result() {
        ozonSearchResultPage.GoToFirstItemCard();
    }

    @And("click on add item button")
    public void click_on_add_item_button() {
        ozonSearchResultPage.ClickAddToCartButton();
        wait.until(ExpectedConditions.presenceOfElementLocated(ozonSearchResultPage.FindFarmerWindow()));
        ozonSearchResultPage.CloseNewFarmerWindowWindow();
    }

    @And("click twice on plus-button to add two more items")
    public void click_twice_on_plus_button_to_add_two_more_items(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ozonSearchResultPage.FindItemsCounter()));
        ozonSearchResultPage.ClickPlusButton();
        ozonSearchResultPage.ClickPlusButton();
    }

    @Then("total amount of items in cart shows {string}")
    public void total_amount_of_items_in_cart_shows(String expectedResult) {
        wait.until(ExpectedConditions.textToBe(ozonSearchResultPage.FindAmountOfItemsInCart(),expectedResult));
        Assert.assertEquals(expectedResult,ozonSearchResultPage.GetAmountOfItems());
    }

    @When("click on account-button")
    public void click_on_account_button() {
        mainPage.ClickAccountButton();
    }

    @When("enter wrong phone number {string}")
    public void enter_wrong_phone_number(String phoneNumber){
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPage.PhoneNumberField()));
        mainPage.EnterPhoneNumber(phoneNumber);
        mainPage.ClickEnterButton();
    }
    @When("enter wrong code {string}")
    public void enter_wrong_code(String code){
        mainPage.EnterCode(code);
        mainPage.ClickSendCodeButton();
    }

    @Then("error message is visible")
    public void error_message_is_visible() {
        Assert.assertTrue(mainPage.CheckErrorIsVisible());
    }

    @Then("end test")
    public void end_test() {
        driver.close();
        driver.quit();
    }
}
