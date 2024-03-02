package HomeWorks.day07;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
public class Task02 {

        static WebDriver driver;

        @BeforeClass
        public static void setUp() {
            // Launch Browser
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

        @Test
        public void testBasicAuth() {
            // Open the URL with username and password in the URL
            String username = "admin";
            String password = "admin";
            String urlWithAuth = "https://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth";
            driver.get(urlWithAuth);

            // Verify the congratulations message
            String congratulationsMessage = driver.findElement(By.cssSelector("div#content h3")).getText();
            System.out.println("Congratulations Message: " + congratulationsMessage);

            // Add assertions as needed

            // Assert.assertTrue(congratulationsMessage.contains("Congratulations! You must have the proper credentials."));
        }

        @AfterClass
        public static void tearDown() {
            // Close the browser
            driver.quit();
        }
    }
