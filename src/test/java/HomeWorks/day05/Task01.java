package HomeWorks.day05;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.Driver;
import java.util.List;

    public class Task01 {

        // Task 1:
        //Go to URL: https://demoqa.com/radio-button
        static WebDriver driver;

        @BeforeClass
        public static void setUp() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
            driver.get("https://demoqa.com/radio-button");
        }

        @AfterClass
        public static void tearDown() {
            // driver.quit();
        }

        //Verify whether all 3 options given to the question can be selected.

        @Test
        public void radioBTest() {
            List<WebElement> radiob = driver.findElements(By.name("like"));
            //JavascriptExecutor js = (JavascriptExecutor) driver;

            if (!radiob.get(0).isSelected()) {
                JavascriptExecutor js = (JavascriptExecutor)driver;
                js.executeScript("arguments[0].click()",radiob.get(0));
                radiob.get(0).click();
                System.out.println("radio button 1 is selected...");
            } else {
                System.out.println("radio button 1 is already selected...");

            }
            if (!radiob.get(1).isSelected()) {
                JavascriptExecutor js = (JavascriptExecutor)driver;
                js.executeScript("arguments[0].click()",radiob.get(1));
                radiob.get(1).click();
                System.out.println("radio 2 is selected...");
            } else {
                System.out.println("radio 2 is already selected...");

                if (!radiob.get(2).isSelected()) {
                    JavascriptExecutor js = (JavascriptExecutor)driver;
                    js.executeScript("arguments[0].click()",radiob.get(2));
                    radiob.get(2).click();
                    System.out.println("radio 3 is selected...");
                } else {
                    System.out.println("radio 3 is already selected...");

                }
                Assert.assertTrue(radiob.get(0).isSelected());
                Assert.assertTrue(radiob.get(1).isSelected());
                Assert.assertTrue(radiob.get(2).isSelected());

            }
            //Verify whether all 3 options given to the question can be selected.
            //When each option is selected, print the following texts on the console.

        }
    }