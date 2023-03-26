package Utlity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriverParameter {
    public WebDriver driver;//static yazılırsa paralel çalışmaz

    public static WebDriverWait wait;

    @BeforeClass
    @Parameters("browserTipi")
    public void baslangicIslemler(String browserSelected) {
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);


        if (browserSelected.equalsIgnoreCase("firefox")) {
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
            driver = new FirefoxDriver();
        } else {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);

        }
        //driver.manage().window().maximize(); // Ekranı max yapıyor.
        Duration dr = Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);
        driver.manage().timeouts().implicitlyWait(dr);

        wait = new WebDriverWait(driver,
                Duration.ofSeconds(30));
        driver.get("https://admin-demo.nopcommerce.com/login");

    }

    @AfterClass
    public void bitisIslemleri()
    {
        Tools.Bekle(5);
        driver.quit();
    }
}
