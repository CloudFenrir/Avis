package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.DriverSetup;

public class DataPage extends DriverSetup {

    public DataPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "txtNombre")
    private WebElement txtNameField;

    @FindBy(id = "txtApellido")
    private WebElement txtLastNameField;

    @FindBy(id = "Cliente_Email")
    private WebElement txtEmailField;

    @FindBy(id = "Cliente_PaisResidenciaCve")
    private WebElement selectCountry;

    @FindBy(id = "txtTelefono")
    private WebElement txtPhoneField;

    @FindBy(id = "Cliente_Mensaje")
    private WebElement txtMessageField;

    @FindBy(xpath = "//*[@id=\"myform\"]/div[4]/div/div/span")
    private WebElement radioPrivacyButton;

    @FindBy(xpath = "//*[@id='prepay']/div[3]/div/div/span")
    private WebElement masterCardOption;

    @FindBy(id = "btnPrepagar")
    private WebElement prePayButtton;

    public String getPrepaidLabel() {
        return prepaidLabel.getText();
    }

    @FindBy(xpath = "//div[@id='modalPrepagar']/div/div/div/h3")
    private WebElement prepaidLabel;

    public Select getSelectCountryOptions() {
        return new Select(selectCountry);
    }

    public CancelReservationPage setPersonalData(String name, String lastName, String email, String country, String phone, String message) {
        txtNameField.sendKeys(name);
        txtLastNameField.sendKeys(lastName);
        txtEmailField.sendKeys(email);
        getSelectCountryOptions().selectByValue(country);
        txtPhoneField.sendKeys(phone);
        txtMessageField.sendKeys(message);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(radioPrivacyButton).click().perform();
        masterCardOption.click();
        prePayButtton.click();
        return new CancelReservationPage(getDriver());
    }
}
