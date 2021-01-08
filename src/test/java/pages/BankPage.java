package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverSetup;

public class BankPage extends DriverSetup {

    public BankPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "continuar")
    private WebElement goBackToAvis;

    public DataPage returnToDataPage() {
        goBackToAvis.click();
        return new DataPage(getDriver());
    }



}
