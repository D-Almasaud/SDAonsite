package HomeWorks.day09;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.time.Duration;

public class task02 extends TestBase {
    @Test
    public void sliderTest(){
        By slider = By.className("rangeslider__handle");

        driver.get("https://rangeslider.js.org/ ");
        WebElement sliderButton = driver.findElement(slider);

        //Shift 100 units to the right and 100 units to the left on the horizontal axis.

        actions
                .dragAndDropBy(sliderButton,100,0)
                .pause(Duration.ofSeconds(2))
                .dragAndDropBy(sliderButton,-100,0)
                .build()
                .perform();

    }
}
