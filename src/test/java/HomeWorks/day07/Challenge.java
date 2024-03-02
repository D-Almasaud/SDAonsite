package HomeWorks.day07;

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
        driver.findElement(By.id("alert")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.findElement(By.id("populate-text")).click();
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait2.until(ExpectedConditions.textToBePresentInElementLocated(By.id("h2"), "Selenium Webdriver"));
        Assert.assertTrue(driver.findElement(By.id("h2")).getText().equals("Selenium Webdriver"));
    }
}