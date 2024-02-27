package Day04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02Example {

    @Test
    public void test() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        // Task 1: Create buttons
        clickButton(driver, By.xpath("//button[text()='Add Element']"), "Add Element", 100);

        // Task 2: Delete buttons and validate
        clickButton(driver, By.xpath("//button[text()='Delete']"), "Delete", 50);

        driver.quit();
    }

    // Method to click a button n times if it exists, returns true if clicked at least once, false otherwise
    private void clickButton(WebDriver driver, By by, String buttonName, int n) {
        for (int i = 0; i < n; i++) {
            WebElement button = driver.findElement(by);
            button.click();
        }
    }
}
