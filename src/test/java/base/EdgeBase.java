package base;

import com.thoughtworks.gauge.AfterScenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import teststeps.StepImplementation;
import utils.TestDataClass;

public class EdgeBase extends TestDataClass {
    protected static EdgeDriver driver;
    protected static WebDriverWait wait;
    protected static EdgeOptions options;
    protected static final Logger logger = LogManager.getLogger(StepImplementation.class);

    @BeforeEach
    public void setUpTest(){
        System.setProperty("webdriver.edge.driver","drivers/msedgedriver.exe");
    }

    @AfterScenario
    public void tearDown(){
        if (driver != null) {
            logger.info("Edge tarayıcısından çıkılıyor.");
            driver.quit();
            logger.info("Edge tarayıcısından çıkıldı.");
        }
    }
}
