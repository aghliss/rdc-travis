import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class RdcTest {

    private AndroidDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("testobject_api_key", System.getenv("TESTOBJECT_API_KEY"));
        caps.setCapability("platformName", "Android");
        driver = new AndroidDriver(new URL("https://eu1.appium.testobject.com/wd/hub"), caps);
    }

    @Test
    public void basicTest() {
        driver.navigate().to("https://saucelabs.com/pricing");
        ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        driver.navigate().to("https://saucelabs.com/");
        ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        driver.navigate().to("https://github.com/saucelabs");
        ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        driver.navigate().to("https://mvnrepository.com/artifact/junit/junit/4.12");
        ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    }

    @After
    public void close() {
        driver.quit();
    }
}
