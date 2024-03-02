package homework06;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Challenge {

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void explicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        // Click on "Click me, to Open an alert after 5 seconds" button
        driver.findElement(By.id("alert")).click();

        // Wait for the alert to be present and accept it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        // Click on "Change Text to Selenium Webdriver"
        driver.findElement(By.id("populate-text")).click();

        // Wait for the text to be present and verify
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait2.until(ExpectedConditions.textToBePresentInElementLocated(By.id("h2"), "Selenium Webdriver"));
        Assert.assertTrue(driver.findElement(By.id("h2")).getText().equals("Selenium Webdriver"));

        // Click on "Display button after 10 seconds" button
        driver.findElement(By.id("display-other-button")).click();

        // Wait for the button to be displayed and verify
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("hidden")));
        Assert.assertTrue(driver.findElement(By.id("hidden")).isDisplayed());

        // Click on "Enable button after 10 seconds" button
        driver.findElement(By.id("enable-button")).click();

        // Wait for the button to be enabled and verify
        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait4.until(ExpectedConditions.elementToBeClickable(By.id("disable")));
        Assert.assertTrue(driver.findElement(By.id("disable")).isEnabled());

        // Click on "Check Checkbox after 10 seconds" button
        driver.findElement(By.id("ch")).click();

        // Wait for the checkbox to be checked and verify
        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait5.until(ExpectedConditions.elementToBeSelected(By.id("ch")));
        Assert.assertTrue(driver.findElement(By.id("ch")).isSelected());
    }
}
