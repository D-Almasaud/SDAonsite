package Day05;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class C03CheckboxExercise {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void test() {
        // Go to URL: https://demoqa.com/
        driver.get("https://demoqa.com/");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-popup-blocking");

        // Click on Elements.
        driver.findElement(By.xpath("//*[text()='Elements']")).click();

        // Click on Checkbox.
        driver.findElement(By.id("item-1")).click();

        // Verify if Home checkbox is selected. if not, then click on it.
        WebElement checkbox = driver.findElement(By.xpath("//*[@class='rct-icon rct-icon-uncheck']"));
        if (!checkbox.isSelected()) {
            checkbox.click();
            System.out.println("Checkbox is selected now.");
        } else {
            System.out.println("Checkbox is already selected.");
        }

        // Verify that "You have selected" is visible using XPath.
        assertTrue(driver.findElement(By.xpath("//*[contains(text(),'You have selected')]")).isDisplayed());


    }}






















