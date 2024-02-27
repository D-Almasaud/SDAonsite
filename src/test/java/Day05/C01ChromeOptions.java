package Day05;

import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class C01ChromeOptions {

    static WebDriver driver;

    @Test
    public void test() {
        ChromeOptions options = new ChromeOptions();

        // Uncomment the lines below based on the options you want to apply

        // Open Chrome in maximize mode
         options.addArguments("start-maximized");

        // Open Chrome in incognito mode
        options.addArguments("incognito");

        // Run Chrome in headless mode (without displaying)
         options.addArguments("headless");

        // Disable pop-up blocking in the Chrome browser
         options.addArguments("disable-popup-blocking");

        // Prevent Chrome from displaying the "Chrome is being controlled by automated software" notification
        options.addArguments("disable-infobars");

        // Set language to English
        options.addArguments("--lang=en");

        // Initialize ChromeDriver with ChromeOptions
        driver = new ChromeDriver(options);
        driver.get("https://www.google.com");
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
        driver.quit();
    }
}