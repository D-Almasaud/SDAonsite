package HomeWorks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class hm2 {
    public static void main(String[] args) {

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Example using get() method
        // Directly opens the specified URL
        driver.get("https://www.example.com");

        // Waits for the page to fully load before proceeding
        System.out.println("Title after using get(): " + driver.getTitle());

        // Example using navigate().to() method
        // Opens the specified URL
        driver.navigate().to("https://www.example.com");

        // Provides additional navigation capabilities, like going forward, backward, refreshing
        // Allows flexible sequential navigation without creating a new WebDriver instance

        // Prints the title after navigating to the specified URL
        System.out.println("Title after using navigate().to(): " + driver.getTitle());

        // You can continue navigating to other URLs
        driver.navigate().to("https://www.google.com");
        System.out.println("Title after navigating to Google: " + driver.getTitle());

        // Navigate back to the original URL
        driver.navigate().to("https://www.example.com");
        System.out.println("Title after navigating back to Example: " + driver.getTitle());

        // Close the browser
        driver.quit();
    }
}