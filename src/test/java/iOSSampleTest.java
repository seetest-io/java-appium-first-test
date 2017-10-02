import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class iOSSampleTest{

    IOSDriver driver = null;
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
        //get an iOS device
        dc.setCapability("platformName", "iOS");
        //launch the app
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "<BUNDLE_ID>");
        driver = new IOSDriver(new URL("https://cloud.experitest.com:443/wd/hub"), dc);
    }

    @Test
    public void testYouriOSApp() {

        //Write your test case here
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}