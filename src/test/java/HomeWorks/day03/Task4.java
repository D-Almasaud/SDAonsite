package HomeWorks.day03;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task4 {
    static WebDriver driver;

    // Define locators for web elements
    By calculator = By.xpath("/html/body/div/div[3]/div[2]/div[2]/div[1]/p/a");
    By number1 = By.xpath("/html/body/div/div[3]/form/div[1]/input[1]");
    By number2 = By.xpath("/html/body/div/div[3]/form/div[1]/input[2]");
    By calculate = By.xpath("/html/body/div/div[3]/form/div[2]/input");
    By result = By.xpath("/html/body/div/div[3]/div/p/span");

    // Setup method to run before the test class starts
    @BeforeClass
    public static void setup() {
        // Initialize ChromeDriver
        driver = new ChromeDriver();
        // Set implicit wait to 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Maximize the browser window
        driver.manage().window().maximize();
    }

    // Test method to perform the actual test
    @Test
    public void CTest() {
        // Open the specified URL
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // Find the calculator element and click on it
        WebElement first = driver.findElement(calculator);
        first.click();

        // Enter values into the number fields
        driver.findElement(number1).sendKeys("5");
        driver.findElement(number2).sendKeys("6");

        // Find the calculate button and click on it
        WebElement second = driver.findElement(calculate);
        second.click();

        // Get the result and print it
        String totalResult = driver.findElement(result).getText();
        System.out.println("total result = " + totalResult);
    }
}
