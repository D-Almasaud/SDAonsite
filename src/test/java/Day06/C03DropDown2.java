package Day06;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C03DropDown2 {
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
      //  driver.quit();

    }
    @Test
    public void dropDownTest(){
        //locate select tag
        WebElement Element= driver.findElement(By.xpath("//*[@id=\"oldSelectMenu\"]")); //

        Select select= new Select(Element); // to use a select it must have tag name starts with select
         select.selectByIndex(3);// index 3 means 4 element which is yellow

    }
    @Test
    public void dropDownTest2(){
        //locate select tag
        WebElement Element= driver.findElement(By.xpath("//*[@id=\"oldSelectMenu\"]")); //

        Select select= new Select(Element); // to use a select it must have tag name starts with select
        select.selectByValue("4");// value 4 element which is purple

    }
    @Test
    public void dropDownTest3(){
        //locate select tag
        WebElement Element= driver.findElement(By.xpath("//*[@id=\"oldSelectMenu\"]")); //

        Select select= new Select(Element); // to use a select it must have tag name starts with select
        select.selectByValue("red");// value 4 element which is purple

    }
    @Test
    public void dropDownTest4(){
        //locate select tag
        WebElement Element= driver.findElement(By.xpath("//*[@id=\"oldSelectMenu\"]")); //

        Select select= new Select(Element); // to use a select it must have tag name starts with select
        select.selectByVisibleText("Purple");// value 4 element which is purple

    }
    @Test
    public void dropDownTest5(){
        WebElement Element= driver.findElement(By.xpath("//*[@id=\"oldSelectMenu\"]")); //

        Select select= new Select(Element);
        // isMultiple() method returns true if we can select multiple options return false otherwise.
        System.out.println("select.isMultiple() = " + select.isMultiple());
        WebElement elemnt2 = driver.findElement(By.id("cars"));  // false --> cannot select multiple options
        Select select2 = new Select(elemnt2);
        System.out.println("select2.isMultiple() = " + select2.isMultiple());  // true --> can select multiple options
    }
    }


