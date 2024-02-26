package HomeWorks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class hw3 {
    public static void main(String[] args) {

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to Facebook homepage
        driver.get("https://www.facebook.com/");

        // Verify expected URL equals actual URL
        String expectedUrl = "https://www.facebook.com/";
        String actualUrl = driver.getCurrentUrl();
        if (expectedUrl.equals(actualUrl)) {
            System.out.println("URL Verification: Passed");
        } else {
            System.out.println("URL Verification: Failed");
        }

        // Verify the page source of Facebook contains "Facebook"
        String pageSource = driver.getPageSource();
        String keywordToSearch = "Facebook";
        if (pageSource.contains(keywordToSearch)) {
            System.out.println("Page Source Verification: Passed");
        } else {
            System.out.println("Page Source Verification: Failed");
        }

        // Close the browser
        driver.quit();
    }
}