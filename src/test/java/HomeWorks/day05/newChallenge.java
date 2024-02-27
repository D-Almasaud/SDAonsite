

//
//import org.junit.AfterClass;
//import org.junit.Assert;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.locators.RelativeLocator;
//
//import java.time.Duration;
//
//import static org.junit.Assert.assertTrue;
//
//public class newChallenge {
//
//
//        static WebDriver driver;
//
//        @BeforeClass
//        public static void setUp() {
//            ChromeOptions options = new ChromeOptions();
//            driver = new ChromeDriver(options);
//            driver.get("https://webdriveruniversity.com/To-Do-List/index.html");
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//            //Assert.assertTrue(driver.getTitle().contains("To-Do List"));
//        }
//        @AfterClass
//        public static void tearDown(){
//            // driver.quit();
//
//        }
//
//    @Test
//    public void test(){
//        driver.get("https://webdriveruniversity.com/To-Do-List/index.html");
//       // assertTrue("Page is not visible successfully", driver.getTitle().contains("To-Do-List"));
//
//        By textField = RelativeLocator.with(By.xpath("//*[@type='text']"));
//        driver.findElement(textField).sendKeys("Danah"+ Keys.ENTER);
//       // assertTrue("TODO has not been added to the list", driver.findElement(By.xpath("//li[contains(text(),'Danah')]")).isDisplayed());
//
//
//        By deleteField = RelativeLocator.with(By.xpath("//*[@id=\"container\"]/ul/li[4]/span/i"));
//        driver.findElement(deleteField).click();
//        //assertTrue("TODO has not been removed from the list", driver.findElements(By.xpath("//li[contains(text(),'Danah')]")).isEmpty());
//
//    }
//}
package HomeWorks.day05;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

import static org.junit.Assert.assertTrue;
import java.util.List;

public class newChallenge {


    static WebDriver driver;

    @Test
    public void test01(){
        driver = new ChromeDriver();
        driver.get("https://webdriveruniversity.com/To-Do-List/index.html");

        String todoText = "test TODO";
        driver.findElement(By.tagName("input")).sendKeys(todoText + Keys.ENTER);
        List<WebElement> todoList = driver.findElements(By.xpath("//ul/li"));

        boolean result = false;
        for (WebElement w: todoList){
            if (w.getText().equals(todoText)){
                result = true;
            }
        }
        Assert.assertTrue(result);

        driver.findElement(By.xpath("//*[contains(text(), 'test')]/span/i")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        todoList = driver.findElements(By.xpath("//ul/li"));
        for (WebElement w: todoList){
            if (w.getText().equals(todoText)){
                result = false;
            }
        }
        Assert.assertTrue(result);
        WebElement completedTODO = driver.findElement(By.xpath("//li[contains(text(), 'Go to potion class')]"));
        completedTODO.click();
        result = completedTODO.getAttribute("class").equals("completed");
        Assert.assertTrue(result);
    }
}

