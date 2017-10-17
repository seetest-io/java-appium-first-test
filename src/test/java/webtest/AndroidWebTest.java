package webtest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;

public class AndroidWebTest {

    AndroidDriver driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    String testName = "Testing Website on Android Chrome with Java";
    //String accessKey = System.getenv("SEETEST_IO_ACCESS_KEY");
    String accessKey = "eyJ4cC51IjoxNjUwLCJ4cC5wIjoxNDM1LCJ4cC5tIjoiTVRRNU5UQXhOelV3T0RreE1BIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4MTY0MzI4MDcsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.JBVpm1JBc8AEHSJm3nY8qv-7Orx0MfSN6D9BsxmfcSA";

    @Before
    public void setUp() throws IOException {
        dc.setCapability("testName", testName);
        dc.setCapability("accessKey",accessKey);
        dc.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        driver = new AndroidDriver(new URL("https://cloud.experitest.com:443/wd/hub"),dc);;
    }

    @Test
    public void testYourAndroidApp() throws InterruptedException {
        if(driver.isLocked()){
            driver.unlockDevice();
        }
        driver.get("https://google.com");
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("mobile automation testing");
        driver.findElement(By.xpath("//*[@name='btnG']")).click();
        driver.wait(5000);

    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
