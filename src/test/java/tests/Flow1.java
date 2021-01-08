package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import utils.DriverSetup;

public class Flow1 extends DriverSetup {

    SoftAssert asserts = new SoftAssert();

    @AfterMethod
    public void testShutDown() {
        quitDriver();
    }

    @Test
    public void flow1() throws InterruptedException {
        HomePage onHome = new HomePage(getDriver());
        onHome = onHome.navigateHomePage();
        onHome.setPlaceOfRentOption("Aeropuerto de Hermosillo");
        VehiclesPage onVehicles = onHome.setDeliveryAndReturn();
        ProtectionsPage onProtection = onVehicles.selectVehicle();
        DataPage onData = onProtection.setProtectionOptions();
        CancelReservationPage onCancel = onData.setPersonalData("Test", "Automation", "test123@gmail.com", "MX", "1231231234", "Merry Christmas");
        asserts.assertTrue(onCancel.getGoToHomeButton().isDisplayed(), "Go to home button is not displayed");
        asserts.assertAll();
    }

}
