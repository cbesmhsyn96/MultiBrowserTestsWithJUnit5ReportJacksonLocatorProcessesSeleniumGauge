package base;

import com.thoughtworks.gauge.AfterScenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import teststeps.StepImplementation;
import utils.TestDataClass;

public class ChromeBase extends TestDataClass {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static ChromeOptions options;
    protected static final Logger logger = LogManager.getLogger(StepImplementation.class);
    @BeforeEach
    public void setUpTest(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
    }

    @AfterScenario
    public void tearDown(){
        if (driver!= null){
            logger.info("Chrome tarayıcısından çıkılıyor.");
            driver.quit();
            logger.info("Chrome tarayıcısından çıkıldı.");
        }
    }
}
