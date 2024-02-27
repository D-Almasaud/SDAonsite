package HomeWorks.day03;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task5 {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin() {
        // Go to the LinkedIn URL
        driver.get("https://www.linkedin.com/");

        // Locate elements using absolute XPath
        WebElement emailInputAbsolute = driver.findElement(By.xpath("//input[@id='session_key']"));
        WebElement passwordInputAbsolute = driver.findElement(By.xpath("//input[@id='session_password']"));
        WebElement signInButtonAbsolute = driver.findElement(By.xpath("//button[@type='submit']"));

        // Print information about elements located using absolute XPath
        System.out.println("Absolute XPath:");
        System.out.println("Email Input (Absolute XPath): " + emailInputAbsolute.getTagName());
        System.out.println("Password Input (Absolute XPath): " + passwordInputAbsolute.getTagName());
        System.out.println("Sign In Button (Absolute XPath): " + signInButtonAbsolute.getTagName());
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}