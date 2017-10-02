import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidSampleTest {

    AndroidDriver driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    String testName = "<TEST_NAME>";
    String accessKey = "<ACCESS_KEY>";
    String projectName = "<PROJECT_NAME>";

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("testName", testName);
        dc.setCapability("accessKey", accessKey);
        dc.setCapability("projectName", projectName);
        //install the app on the device
        dc.setCapability(MobileCapabilityType.APP, "cloud:<BUNDLE_ID>");
        //get an Android device
        dc.setCapability("platformName", "Android");
        //launch the app
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "<BUNDLE_ID>");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "<ACTIVITY>");
        driver = new AndroidDriver(new URL("https://cloud.experitest.com:443/wd/hub"), dc);
    }

    @Test
    public void testYourAndroidApp() {

        //Write your test case here
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}