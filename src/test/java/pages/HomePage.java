package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverSetup;

import java.util.List;

public class HomePage extends DriverSetup {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "TxtOficinaRenta")
    private WebElement placeOfRent;

    @FindBy(id = "Frenta")
    private WebElement delivery;

    @FindBy(id = "Fdev")
    private WebElement vuelta;

    @FindBy(id = "FechaDevolucion")
    private WebElement innerVuelta;

    @FindBy(id = "FechaRenta")
    private WebElement innerDelivery;

    @FindBy(xpath = "//div[@data-full='2020-12-15']")
    private WebElement deliveryDay;

    @FindBy(xpath = "//div[@class='mbsc-sc-itm   mbsc-btn-e']")
    private List<WebElement> deliveryHour;

    @FindBy(xpath = "//div[@data-full='2020-12-30']")
    private WebElement returnDay;

    @FindBy(xpath = "//div[@class='mbsc-sc-whl-sc']/div[71]")
    private WebElement returnHour;

    @FindBy(id = "aCotizar")
    private WebElement searchButton;

    @FindBy(id = "btnSeleccionarTarjeta")
    private WebElement prePaidButton;

    @FindBy(xpath = "//strong[@class='tt-highlight']")
    private WebElement hmoOption;


    public void setPlaceOfRentOption(String place) {
        WebDriverWait wait = new WebDriverWait (getDriver(), 15);
        placeOfRent.click();
        placeOfRent.sendKeys(place);
        wait.until(ExpectedConditions.visibilityOf(hmoOption));
        hmoOption.click();
    }

    public void setHour(String givenHour) {
        System.out.println(deliveryHour.get(3).getText());
        for (WebElement hour : deliveryHour) {
            try {
                if (hour.getAttribute("innerText").equals(givenHour)){
                    JavascriptExecutor js = (JavascriptExecutor) getDriver();
                    js.executeScript("arguments[0].scrollIntoView(true);", hour);
                    js.executeScript("arguments[0].click();", hour);
                    break;
                }
            }catch (StaleElementReferenceException ex) {
                ex.printStackTrace();
            }

        }
    }

    public VehiclesPage setDeliveryAndReturn() {
        WebDriverWait wait = new WebDriverWait (getDriver(), 15);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        wait.until(ExpectedConditions.elementToBeClickable(delivery));
        js.executeScript("arguments[0].removeAttribute('readonly','readonly')",delivery);
        js.executeScript("arguments[0].value = '2020/12/28 18:30';", delivery);
        js.executeScript("arguments[0].value = '2020/12/28 18:30';", innerDelivery);

        js.executeScript("arguments[0].removeAttribute('readonly','readonly')",vuelta);
        js.executeScript("arguments[0].value = '2020/12/30 15:30';", vuelta);
        js.executeScript("arguments[0].value = '2020/12/30 15:30';", innerVuelta);
//        delivery.click();
//        wait.until(ExpectedConditions.elementToBeClickable(deliveryDay));
//        deliveryDay.click();
//        Actions actions = new Actions(getDriver());
//        actions.moveToElement(deliveryHour);
//        wait.until(ExpectedConditions.elementToBeClickable(deliveryHour));
//        setHour(deliveryHour);
//        wait.until(ExpectedConditions.elementToBeClickable(returnDay));
//        returnDay.click();
//        actions.moveToElement(returnHour);
//        wait.until(ExpectedConditions.elementToBeClickable(returnHour));
//        returnHour.click();
//        setHour(retHour);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        return new VehiclesPage(getDriver());
    }



}
