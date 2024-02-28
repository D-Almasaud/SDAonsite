package HomeWorks.day06;


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
import java.util.ArrayList;
import java.util.List;

        public class Task01 {
        //Hw:1
        //Go to URL: https://the-internet.herokuapp.com/dropdown
        //Select Option 1 using index .
        //Select Option 2 by value.
        //Select Option 1 value by visible text.
        //Print all dropdown value.
        //Verify the dropdown has Option 2 text.
        //Print first selected option.
        //Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
        static WebDriver driver ;
        @BeforeClass
        public static void setUp(){
            driver=new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("https://the-internet.herokuapp.com/dropdown");
        }
        @AfterClass
        public static void tearDown(){
             driver.quit();

        }
        @Test
        public void test(){
            //Select Option 1 using index .
            WebElement element= driver.findElement(By.id("dropdown"));
            Select select = new Select(element);
            List<WebElement> options = select.getOptions();

            //Select Option 2 by value.
            select.selectByIndex(2);

            //Select Option 1 value by visible text.
            select.selectByIndex(1);

            //Print all dropdown value.
            for (WebElement option:options){
                System.out.println(option.getText());}

            //Verify the dropdown has Option 2 text.
            List<String> OptionsList = new ArrayList<>();

            for (WebElement option: options){
                OptionsList.add(option.getText());
            }

            Assert.assertTrue(OptionsList.contains("Option 2"));

            //Print first selected option.
            System.out.println(select.getFirstSelectedOption().getText());

            //Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
            int dropdownSize = options.size();
            if (dropdownSize != 3) {
                System.out.println("Expected Is Not Equal Actual");
            }
        }
    }