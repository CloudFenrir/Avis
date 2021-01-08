package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverSetup;

public class VehiclesPage extends DriverSetup {

    public VehiclesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='divAutoD']/div/div[1]/div/div[2]/form/input[37]")
    private WebElement selectAveoButton;

    public ProtectionsPage selectVehicle() {
        selectAveoButton.click();
        return new ProtectionsPage(getDriver());
    }

}
