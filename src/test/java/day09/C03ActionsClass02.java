package day09;

/*import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03DragAndDrop extends TestBase {

    @Test
    public void test(){


 //Go to URL: http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
    driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

    //Fill in capitals by country.

        WebElement oslo = driver.findElement(By.id("box1"));
        WebElement norway = driver.findElement(By.id("box101"));


        WebElement seoul = driver.findElement(By.id("box5"));
        WebElement southKorea = driver.findElement(By.id("box105"));

        WebElement madrid = driver.findElement(By.id("box7"));
        WebElement spain = driver.findElement(By.id("box107"));



       WebElement   stockholm= driver.findElement(By.id("box2"));
        WebElement  sweden= driver.findElement(By.id("box102"));

        WebElement  washington = driver.findElement(By.id("box3"));
       WebElement   unitedStates = driver.findElement(By.id("box103"));

        WebElement copenhagen = driver.findElement(By.id("box4"));
        WebElement denmark = driver.findElement(By.id("box104"));

        WebElement rome = driver.findElement(By.id("box6"));
        WebElement italy = driver.findElement(By.id("box106"));

        Actions actions =new Actions(driver);
        actions
                .dragAndDrop(oslo, norway)
        .dragAndDrop(seoul, southKorea)
                .dragAndDrop(madrid, spain)
                .dragAndDrop(stockholm, sweden)
                .dragAndDrop(washington, unitedStates)
                .dragAndDrop(copenhagen, denmark)
                .dragAndDrop(rome, italy).perform();
    }
}
*/

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03ActionsClass02 extends TestBase {

    String url = "http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html";
    Actions actions =new Actions(driver);

    @Test
    public void test(){

        driver.get(url);
        dragCapitolInCountryBox("Madrid","Spain");
        dragCapitolInCountryBox("Washington","United States");
        dragCapitolInCountryBox("Rome","Italy");
        dragCapitolInCountryBox("Seoul","South Korea");
        dragCapitolInCountryBox("Copenhagen","Denmark");
        dragCapitolInCountryBox("Oslo","Norway");
        dragCapitolInCountryBox("Stockholm","Sweden");

    }
    public void dragCapitolInCountryBox(String capital, String country){
        By cap = By.xpath("//div[text()='"+ capital +"'][2]");
        By count = By.xpath("//div[text()='"+country+"']");

        WebElement capitalBox = driver.findElement(cap);
        WebElement countryBox = driver.findElement(count);
        actions.dragAndDrop(capitalBox,countryBox).perform();
    }
}