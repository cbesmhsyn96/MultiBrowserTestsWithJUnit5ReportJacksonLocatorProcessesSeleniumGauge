package base;

import com.thoughtworks.gauge.AfterScenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.ILoggerFactory;
import teststeps.StepImplementation;
import utils.TestDataClass;

import java.time.Duration;

public class SafariBase extends TestDataClass {
    protected static SafariDriver driver;
    protected static WebDriverWait wait;
    protected static SafariOptions options;
    protected static final Logger logger = LogManager.getLogger(StepImplementation.class);

    @BeforeEach
    public void setUpTest(){

    }

    @AfterScenario
    public void tearDown(){
        if (driver != null) {
            logger.info("Safari tarayıcısından çıkılıyor.");
            driver.quit();
            logger.info("Safari tarayıcısından çıkıldı.");
        }
    }
}
