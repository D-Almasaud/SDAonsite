package HomeWorks.day06;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static HomeWorks.day06.Challange.driver;

public class Task03 {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        // Launch Browser
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @Test
    public void testMultiSelect() {
        // Open "https://demoqa.com/select-menu"
        driver.get("https://demoqa.com/select-menu");

        // Select the Standard Multi-Select using the element id
        WebElement multiSelectElement = driver.findElement(By.id("cars"));
        Select multiSelect = new Select(multiSelectElement);

        // Verifying that the element is multi-select
        if (multiSelect.isMultiple()) {
            System.out.println("The element is multi-select.");
        } else {
            System.out.println("The element is not multi-select.");
        }

        // Select 'Opel' using the index and deselect the same using index
        multiSelect.selectByIndex(2);

        multiSelect.deselectByIndex(2);


        // Select 'Saab' using value and deselect the same using value
        multiSelect.selectByValue("saab");

        multiSelect.deselectByValue("saab");


        // Deselect all the options
        multiSelect.deselectAll();

    }




    @AfterClass
    public static void tearDown() {
        // Close the browser
       // driver.quit();
    }}

