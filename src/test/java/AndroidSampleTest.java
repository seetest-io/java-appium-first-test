import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidSampleTest {

    AndroidDriver driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    String testName = "Testing Android App with Java";
    String accessKey = System.getenv("ACCESS_KEY");

    @Before
    public void setUp() throws IOException {
        dc.setCapability("testName", testName);
        dc.setCapability("accessKey", accessKey);
        //install the app on the device
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank/.LoginActivity");
        //get an Android device
        dc.setCapability("platformName", "Android");
        //launch the app
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        driver = new AndroidDriver(new URL("https://cloud.experitest.com:443/wd/hub"), dc);
    }

    @Test
    public void testYourAndroidApp() {
        if(driver.isLocked()){
            driver.unlockDevice();
        }
        driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@id='loginButton']")).click();
        driver.findElement(By.xpath("//*[@id='makePaymentButton']")).click();
        driver.findElement(By.xpath("//*[@id='phoneTextField']")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id='nameTextField']")).sendKeys("Test");
        driver.findElement(By.xpath("//*[@id='amountTextField']")).sendKeys("10");
        driver.findElement(By.xpath("//*[@id='countryTextField']")).sendKeys("US");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@id='sendPaymentButton']")).click();
        driver.findElement(By.xpath("//*[@id='button1']")).click();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
