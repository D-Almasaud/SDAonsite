package HomeWorks.day03;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task3 {

    static WebDriver driver;

    // Method to set up the WebDriver and navigate to the login page before the test
    @BeforeClass
    public static void setUp(){
        // Initialize ChromeDriver
        driver = new ChromeDriver();
        // Maximize the browser window
        driver.manage().window().maximize();
        // Set implicit wait to 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Navigate to the specified URL
        driver.get("https://id.heroku.com/login");
    }

    // Test method to perform the actual login test
    @Test
    public void test(){
        // Find the email input field and enter an email address
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("D-Almasaud@oulook.com");

        // Find the password input field and enter a password
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("1234");

        // Find the Login button and click on it
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        // Find the error message element
        WebElement errorMessage = driver.findElement(By.className("panel-footer"));

        // Check if the error message is displayed and print the appropriate message
        if (errorMessage.isDisplayed()) {
            System.out.println("Registration Failed");
        } else {
            System.out.println("Registered");
        }
    }

    // Method to close the WebDriver after the test
    @AfterClass
    public static void tearDown(){
        // Quit the WebDriver, closing all open pages
        driver.quit();
    }
}
