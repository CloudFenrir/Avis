package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverSetup;

import java.time.Duration;

public class ProtectionsPage extends DriverSetup {

    public ProtectionsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "chkPaquete")
    private WebElement totalProtectionRadioButton;

    @FindBy(id = "Servicios_1__IsChecked")
    private WebElement babyChairRadioButton;

    @FindBy(id = "btnSeleccionarTarjeta")
    private WebElement prePaidButton;

    @FindBy(id = "lottie")
    private WebElement loadAnimation;


    public DataPage setProtectionOptions() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        Actions actions = new Actions(getDriver());
//        wait.until(ExpectedConditions.elementToBeClickable(totalProtectionRadioButton)).click();
        totalProtectionRadioButton.click();

        wait.until(ExpectedConditions.visibilityOf(loadAnimation));
//        Thread.sleep(20000);
//        actions.moveToElement(babyChairRadioButton).perform();
        babyChairRadioButton.click();
        wait.until(ExpectedConditions.visibilityOf(loadAnimation));
//        Thread.sleep(20000);
        prePaidButton.click();
        return new DataPage(getDriver());
    }
}
