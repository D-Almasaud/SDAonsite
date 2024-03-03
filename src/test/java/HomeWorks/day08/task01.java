package HomeWorks.day08;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class task01 extends TestBase {


@Test
    public void test(){


   //Go to URL: http://demo.guru99.com/test/guru99home/
        driver.get("http://demo.guru99.com/test/guru99home/");

    //Find the number of iframes on the page.
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println("Number of iframes on the page: " + iframes.size());

    //Link to the third iframe (JMeter Made Easy) (https://www.guru99.com/live selenium project.html) click here.
        WebElement thirdIframeLink = driver.findElement(By.id("a077aa5e"));
        thirdIframeLink.click();
    //Exit the iframe and return to the main page.
        driver.switchTo().defaultContent();



}}
