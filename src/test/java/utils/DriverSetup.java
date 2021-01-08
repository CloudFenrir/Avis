package utils;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class DriverSetup {

    private WebDriver driver;

    public DriverSetup() {
        initDriver();
    }

    public DriverSetup(WebDriver driver) {
        this.driver = driver;
    }

    public void initDriver() {
        ChromeDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void quitDriver() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage navigateHomePage() {
        driver.navigate().to("https://avis.mx/");
        driver.manage().window().maximize();
        return new HomePage(driver);
    }

}
