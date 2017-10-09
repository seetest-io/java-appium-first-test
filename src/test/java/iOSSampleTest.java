import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.boon.core.Sys;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class iOSSampleTest{

    IOSDriver driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    String testName = "Testing iOS App";
    String accessKey = System.getenv("accessKey");

    @Before
    public void setUp() throws MalformedURLException {
        System.out.println(accessKey);
        dc.setCapability("testName", testName);
        dc.setCapability("accessKey", accessKey);
        //install the app on the device
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
        //get an iOS device
        dc.setCapability("platformName", "iOS");
        //launch the app
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        driver = new IOSDriver(new URL("https://cloud.experitest.com:443/wd/hub"), dc);
    }

    @Test
    public void testYouriOSApp() {

        driver.findElement(By.xpath("//*[@text='Username']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@text='Password']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@text='loginButton']")).click();
        driver.findElement(By.xpath("//*[@text='makePaymentButton']")).click();
        driver.findElement(By.xpath("//*[@text='Phone']")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@text='Name']")).sendKeys("Test");
        driver.findElement(By.xpath("//*[@text='Amount']")).sendKeys("10");
        driver.findElement(By.xpath("//*[@text='Country']")).sendKeys("US");
        driver.findElement(By.xpath("//*[@text='sendPaymentButton']")).click();
        driver.findElement(By.xpath("//*[@text='Yes']")).click();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}