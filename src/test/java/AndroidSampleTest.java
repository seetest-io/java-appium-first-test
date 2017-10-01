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
    String userName = "<YOUR_USER_NAME>";
    String accessKey = "<ACCESS_KEY>";


    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("username", userName);
        dc.setCapability("accessKey", accessKey);
        //install the app on the device
        dc.setCapability(MobileCapabilityType.APP, "cloud:<BUNDLE_ID>");
        //get an iOS device
        dc.setCapability("deviceQuery", "@os='android'");
        //launch the app
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");


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