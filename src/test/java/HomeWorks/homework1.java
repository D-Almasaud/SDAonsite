package HomeWorks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class homework1 {
    public static void main(String[] args) throws InterruptedException {



        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to Google homepage
        driver.get("https://www.google.com");

        // Print the title of the page
        String pageTitle = driver.getTitle();
        System.out.println("Title of the page: " + pageTitle);

        // Print the current URL
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        // Close the browser
        driver.quit();
    }
}