package HomeWorks.day03;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Challenge {

    static WebDriver driver;
    By loginButton = By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[4]/a");
    By emailBox = By.xpath("/html/body/section/div/div/div[1]/div/form/input[2]");
    By password = By.xpath("/html/body/section/div/div/div[1]/div/form/input[3]");
    By log =By.xpath("/html/body/section/div/div/div[1]/div/form/button");

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        Assert.assertNotNull(driver);
    }

    @Test
    public void loginTest() {

        driver.get("https://automationexercise.com/");
        // Verify if the correct URL is loaded before clicking on the login button
        String expectedUrl = "https://automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("Current URL doesn't match the expected URL",expectedUrl, actualUrl);

        WebElement first= driver.findElement(loginButton);
        first.click();

        // Enter credentials and login
        driver.findElement(emailBox).sendKeys("sda@test.com");
        driver.findElement(password).sendKeys("sdainclasstask");
        WebElement last= driver.findElement(log);
        last.click();
    }
}
