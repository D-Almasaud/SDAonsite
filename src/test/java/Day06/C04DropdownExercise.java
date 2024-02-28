package Day06;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C04DropdownExercise {
      /*
    Launch the browser.
    Open "https://demoqa.com/select-menu".
    Select the Standard Multi-Select using the element id.
    Verifying that the element is multi-select.
    Select 'Opel' using the index and deselect the same using index.
    Select 'Saab' using value and deselect the same using value.
    Deselect all the options.
    Close the browser.
     */
      static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");

    }
    @AfterClass
    public static void tearDown() {
        driver.quit();

    }
    @Test
    public void dropDownTest(){
        //    Select the Standard Multi-Select using the element id.
        WebElement element= driver.findElement(By.id("cars"));
        Select select = new Select(element);

        //    Verifying that the element is multi-select.
        Assert.assertTrue(select.isMultiple());
        //    Select 'Opel' using the index and deselect the same using index.
        select.selectByIndex(2);
        List<WebElement> option = select.getOptions();
        Assert.assertTrue(option.get(2).isSelected());
        //    Select 'Saab' using value and deselect the same using value.
              select.selectByVisibleText("Saab");
              Assert.assertEquals(2,select.getAllSelectedOptions().size());
              select.selectByVisibleText("Saab");
        //    Deselect all the options.
          select.deselectAll();

    }
}
