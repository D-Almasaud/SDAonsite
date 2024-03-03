package HomeWorks.day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Challenge extends TestBase {
    @Test
    public void test() {
        driver.get("https://clarusway.getlearnworlds.com/sda-test-registration-form");

        // Switch to the iframe by identifying it using its unique attributes
        driver.switchTo().frame(0);

        // Fill the first name
        WebElement firstNameInput = driver.findElement(By.xpath("//*[@elname='First']"));
        firstNameInput.sendKeys("Danah");

        // Fill the last name
        WebElement lastNameInput = driver.findElement(By.xpath("//*[@elname='Last']"));
        lastNameInput.sendKeys("Almasaud");

        //Check the radio button
        List<WebElement> radio = driver.findElements(By.className("tempContDiv"));
        radio.get(1).click();

        // Drop down Selection
        WebElement dropdown = driver.findElement(By.id("Dropdown-arialabel"));
        Select select = new Select(dropdown);
        select.selectByIndex(2);

        // check box
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@for='Checkbox_1']"));
        WebElement checkbox3 = driver.findElement(By.xpath("//*[@for='Checkbox_3']"));
        checkbox1.click();
        checkbox3.click();

        // Rating
        WebElement star1 = driver.findElement(By.xpath("//*[@aria-label='1 Star']"));
        WebElement star2 = driver.findElement(By.xpath("//*[@aria-label='2 Star']"));
        WebElement star3 = driver.findElement(By.xpath("//*[@aria-label='3 Star']"));
        WebElement star4 = driver.findElement(By.xpath("//*[@aria-label='4 Star']"));
        WebElement star5 = driver.findElement(By.xpath("//*[@aria-label='5 Star']"));
        star3.click();

        // Submit button
        driver.findElement(By.xpath("//*[@elname='submit']")).click();

        // Assertions
        Assert.assertNotNull("First name should not be null", firstNameInput.getAttribute("value"));
        Assert.assertTrue("Dropdown should be chosen", select.getFirstSelectedOption().getText().equals("Second Choice"));


        // Assertions for Rating

        // Get the current value of the selected rating
        String selectedRating = star3.getAttribute("aria-label");

// Extract the numeric value from the rating
        int numericValue = Integer.parseInt(selectedRating.split(" ")[0]);

// Assertion for Rating - Star 3 should have numeric value 3
        Assert.assertEquals(3, numericValue);

    }
}
