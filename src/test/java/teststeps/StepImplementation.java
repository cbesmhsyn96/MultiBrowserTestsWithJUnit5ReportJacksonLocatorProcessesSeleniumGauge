package teststeps;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import utils.LocatorMethods;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class StepImplementation extends LocatorMethods {
    private static HashMap<String, Object> randomStrDatasByKey = new HashMap<>();

    static {
        randomStrDatasByKey.put("Name",getRandomStrFromList(nameDatas));
        randomStrDatasByKey.put("Surname",getRandomStrFromList(surnameDatas));
        randomStrDatasByKey.put("Adress",createAdressFromMockDatas());
    }

    private static Actions actions;
    private static void prepareObjects(){
        actions = new Actions(driver);
    }
    @Step("Go to <url>")
    public void goToURL(String url) throws InterruptedException {
        options = new ChromeOptions();
        driver = new ChromeDriver(options);
        prepareObjects();
        //options = new FirefoxOptions();
        //driver = new FirefoxDriver(options);

        /*options = new SafariOptions();
        options.setAcceptInsecureCerts(true);
        driver = new SafariDriver(options);*/

        /*options = new EdgeOptions();
        driver = new EdgeDriver();*/

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        logger.info(url+" url li sayfaya gidildi.");
    }

    @Step("Hover element by <key>")
    public void hoverElement(String key) throws IOException {
        actions.moveToElement(findElement(key)).perform();
        logger.info(key+" keyli elemente hover edildi.");
    }

    @Step("Click element by <key>")
    public void clickElementByKey(String key) throws IOException {
        findElement(key).click();
        logger.info(key+" keyli elemente tiklandi.");
    }



    @Step("Send keys random text with <dataKeyType> element by <key>")
    public void sendKeysValueByKey(String dataKeyType,String key) throws IOException, InterruptedException {
        String randText = (String) randomStrDatasByKey.get(dataKeyType);
        findElement(key).sendKeys(randText);
        Thread.sleep(10000);
        logger.info(key+" keyli elemente "+dataKeyType+ " listesinden rastgele biri["+randText+"] yazıldı.");
    }

}