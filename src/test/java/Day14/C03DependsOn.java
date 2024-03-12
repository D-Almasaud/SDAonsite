package Day14;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;


import java.time.Duration;

public class C03DependsOn {

   static WebDriver driver;

    //First go to Facebook.
    //Then go to Google depending on Facebook,
    //Then go to Amazon depending on Google
    //Close the driver.

    //Create tests that depend on each other
    //Create beforeClass and set up settings.
    //By creating interdependent tests;
    @BeforeClass
    public static  void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test
    public void testFacebook() {
        // Navigate to Facebook
        driver.get("https://www.facebook.com/");
    }

    @Test(dependsOnMethods = "testFacebook")
    public void testGoogle() {

        driver.get("https://www.google.com");
    }

    @Test(dependsOnMethods = "testGoogle")
    public void testAmazon() {

        driver.get("https://www.amazon.com");
    }

    @AfterClass
    public static void tearDown() {
        // Close the driver after all tests are executed
        if (driver != null) {
            driver.quit();
        }
    }
}