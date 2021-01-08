package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverSetup;

public class CancelReservationPage extends DriverSetup {

    public CancelReservationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getGoToHomeButton() {
        return goToHomeButton;
    }

    @FindBy(xpath = "//a[@class='btn btn-white font-weight-bold px-4']")
    private WebElement goToHomeButton;


}
