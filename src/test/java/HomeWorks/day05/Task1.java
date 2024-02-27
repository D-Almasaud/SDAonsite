package HomeWorks.day05;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class Task1 {

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
    }

    @AfterClass
    public static void tearDown() {
     //   driver.quit();
    }

    @Test
    public void testRadioOptionsSelection() {
        // Go to URL: https://demoqa.com/radio-button
        driver.get("https://demoqa.com/radio-button");

        // Verify whether all 3 options given to the question can be selected.
        List<WebElement> radioOptions = driver.findElements(By.xpath("//input[@type='radio']"));

        for (WebElement option : radioOptions) {
            option.click();
            assertTrue("Option '" + option.getAttribute("value") + "' is not selected.",
                    option.isSelected());
        }
    }
}
