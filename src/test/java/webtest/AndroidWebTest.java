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
    String accessKey = System.getenv("SEETEST_IO_ACCESS_KEY");

    @Before
    public void setUp() throws IOException {
        dc.setCapability("testName", testName);
        dc.setCapability("accessKey",accessKey);
        dc.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        driver = new AndroidDriver(new URL("https://stage.experitest.com:443/wd/hub"),dc);;
    }

    @Test
    public void testYourAndroidApp() throws InterruptedException {
        if(driver.isLocked()){
            driver.unlockDevice();
        }
        driver.get("https://google.com");
        System.out.println(driver.getTitle());
        if(!driver.findElements(By.xpath("//*[@id='lst-ib']")).isEmpty()){

            driver.findElement(By.xpath("//*[@id='lst-ib']")).sendKeys("mobile automation testing");
        }
        else {
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys("mobile automation testing");
        }
        if(!driver.findElements(By.xpath("//*[@name='btnG']")).isEmpty())
        {
            driver.findElement(By.xpath("//*[@name='btnG']")).click();
        }
        else{
            driver.findElement(By.xpath("//*[@text='Google Search']")).click();
        }
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
