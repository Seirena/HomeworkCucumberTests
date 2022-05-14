import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final WebDriver webDriver;
    public MainPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    private final By searchCityFieldLocator = By.xpath("//*[@placeholder=\"Ваш город\"]");
    private final By firstCityLocator = By.xpath("//*[@data-testid=\"cityName0\"]");
    private static final String mainPageUrl = "https://svoe-rodnoe.ru/";
    private final By searchItemFieldLocator = By.xpath("//*[@type=\"search\"][2]");
    private final By changeCityButtonLocator = By.xpath("//*[contains(text(),'Нет, изменить')]");
    private final By searchButtonLocator = By.xpath("//*[@class=\"main\"]//*[@type=\"submit\"]");
    private final By accountButtonLocator = By.xpath("//*[@class=\"custom-icon account-button__icon account-button__icon_white\"]");
    private final By phoneNumberFieldLocator = By.xpath("//*[@name=\"login\"]");
    private final By enterButtonLocator = By.xpath("//*[@data-testid=\"getCode\"]");
    private final By errorWrongCodeMessageLocator = By.xpath("//*[@class=\"confirm-code__error\"]");
    private final By codeFieldLocator = By.xpath("//*[@data-testid=\"code0\"]");
    private final By sendCodeButtonLocator = By.xpath("//*[contains(text(),'Отправить')]");

    public void OpenPage(){
        webDriver.get(mainPageUrl);
    }

    public void SearchItem(String searchParam) {
        webDriver.findElement(searchItemFieldLocator).sendKeys(searchParam);
    }

    public void ClickSearchButton(){
        webDriver.findElement(searchButtonLocator).click();
    }

    public void ChooseCity(String cityName){
        webDriver.findElement(changeCityButtonLocator).click();
        webDriver.findElement(searchCityFieldLocator).sendKeys(cityName);
        webDriver.findElement(firstCityLocator).click();
    }
    public void ClickAccountButton(){
        webDriver.findElement(accountButtonLocator).click();
    }
    public By PhoneNumberField(){
        return phoneNumberFieldLocator;
    }
    public void EnterPhoneNumber(String phoneNumber){
        webDriver.findElement(phoneNumberFieldLocator).sendKeys(phoneNumber);
    }
    public void EnterCode(String code){
        webDriver.findElement(codeFieldLocator).sendKeys(code);
    }

    public void ClickEnterButton(){
        webDriver.findElement(enterButtonLocator).click();
    }
    public void ClickSendCodeButton(){
        webDriver.findElement(sendCodeButtonLocator).click();
    }

    public boolean CheckErrorIsVisible(){
        return webDriver.findElement(errorWrongCodeMessageLocator).isDisplayed();
    }

}
