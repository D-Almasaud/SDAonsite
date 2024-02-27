package Day05;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertTrue;

public class C02CheckBoxes {
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    public void checkboxTest() {
        // Locate the elements of checkboxes
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        // Click on checkbox 1 only if it's not selected
        if (!checkbox1.isSelected()) {
            checkbox1.click();
            System.out.println("check box 1 is selected");
        } else { System.out.println("check box 1 is already selected");}

        // Click on checkbox 2 only if it's not selected
        if (!checkbox2.isSelected()) {
            checkbox2.click();
            System.out.println("check box 2 is selected");
        } else { System.out.println("check box 2 is already selected");}


        // Assert that checkbox 1 is checked and check 2 for caution
        assertTrue("Checkbox 1 is not checked", checkbox1.isSelected());
        assertTrue("Checkbox 2 is not checked", checkbox2.isSelected());
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
