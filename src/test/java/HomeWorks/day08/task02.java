package HomeWorks.day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class task02 extends TestBase {

    @Test
    public void testWindowHandling() {
        // Go to URL
        driver.get("https://the-internet.herokuapp.com/windows");

        // Verify the text: "Opening a new window"
        Assert.assertEquals("Opening Window Text is incorrect", "Opening a new window", driver.findElement(By.xpath("//*[@id='content']//h3")).getText());

        // Verify the title of the page is "The Internet"
        Assert.assertEquals("Original Window Title is incorrect", "The Internet", driver.getTitle());

        // Click on the "Click Here" link
        driver.findElement(By.linkText("Click Here")).click();

        // Switch to the new window
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }

        // Verify the new window title is "New Window"
        Assert.assertEquals("New Window Title is incorrect", "New Window", driver.getTitle());

        // Close the new window and switch back to the original window
        driver.close();

        // Switch back to the original window by using the first window handle
        String mainWindowHandle = driver.getWindowHandles().iterator().next();
        driver.switchTo().window(mainWindowHandle);

        // Verify the title: "The Internet"
        Assert.assertEquals("Current Window Title is incorrect", "The Internet", driver.getTitle());
    }
}
