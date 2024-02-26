package HomeWorks.day03;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task1 {
//task01:


//Type "Green Mile" in the search box and print the number of results.
//Type "Premonition" in the search box and print the number of results.
//Type "The Curious Case of Benjamin Button" in the search box and print the number of results.
//Close with AfterClass.
    static WebDriver driver;
    By searchbox =By.name("q");
    By resultId =By.id("result-stats");
    //Create the driver with BeforeClass and make it static inside the class.
    // Go to http://www.google.com
    @BeforeClass
    public static void setup() {
        // Set the path to your chromedriver executable
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

//Type "Green Mile" in the search box and print the number of results.
    @Test
public void greenMileTest(){
        driver.get("https:/google.com");
      driver.findElement(searchbox).sendKeys("Green Mile"+ Keys.ENTER);
      String TotalResult =driver.findElement(resultId).getText();
        System.out.println("TotalResult = " + TotalResult);
    }

//Type "Premonition" in the search box and print the number of results.
@Test
public void premonitionTest(){
    driver.get("https:/google.com");
    driver.findElement(searchbox).sendKeys("Premonition"+ Keys.ENTER);
    String TotalResult =driver.findElement(resultId).getText();
    System.out.println("TotalResult = " + TotalResult);
}

//Type "The Curious Case of Benjamin Button" in the search box and print the number of results.
@Test
public void theCuriousCaseofBenjaminButtonTest(){
    driver.get("https:/google.com");
    driver.findElement(searchbox).sendKeys("The Curious Case of Benjamin Button"+ Keys.ENTER);
    String TotalResult =driver.findElement(resultId).getText();
    System.out.println("TotalResult = " + TotalResult);
}


//Close with AfterClass.

    @AfterClass
    public static void tearDown() {

      driver.quit();
    }
}