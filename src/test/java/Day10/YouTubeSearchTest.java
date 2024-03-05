package Day10;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.TestBase;

public class YouTubeSearchTest extends TestBase {


    @Test
    public void searchAndVerifyVideo() throws InterruptedException {
        // Navigate to YouTube
        driver.get("https://www.youtube.com/");

        // Find the search input field and enter the search query
        WebElement searchInput = driver.findElement(By.xpath("//input[@id='search']"));
        searchInput.sendKeys("hans zimmer stay");

        // Submit the search form
        searchInput.submit();

        // Wait for search results to load (You may need to add more robust waits in a real-world scenario)

            Thread.sleep(3000); // Just for demonstration purposes, use WebDriverWait in a real scenario


        // Click on the first video in the search results
        WebElement firstVideo = driver.findElement(By.xpath("//*[@id='video-title']/yt-formatted-string"));
        firstVideo.click();


            Thread.sleep(2000);


        // Assert that the video is from Hans Zimmer
         WebElement videoUploader = driver.findElement(By.partialLinkText("Hans Zimmer"));
        String uploaderName = videoUploader.getText();
        Assert.assertTrue(uploaderName.contains("Hans Zimmer"));
    }


    }

