package HomeWorks.day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class task01 extends TestBase {

    @Test
    public void test(){
        driver.get(" http://demo.guru99.com/test/drag_drop.html");


        WebElement Bank =driver.findElement(By.xpath("//*[@id=\"credit2\"]/a"));
        WebElement sales =driver.findElement(By.xpath("//*[@id=\"credit1\"]/a"));
        WebElement f5000 =driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));

        WebElement dibtAc =driver.findElement(By.id("bank"));
        WebElement dibtAm =driver.findElement(By.id("amt7"));
        WebElement cridetAc =driver.findElement(By.id("loan"));
        WebElement cridetAm =driver.findElement(By.id("amt8"));

        WebElement perfect =driver.findElement(By.xpath("//*[@id=\"equal\"]/a"));



        Actions actions =new Actions(driver);
        actions .dragAndDrop(Bank,dibtAc)
                .dragAndDrop(sales,cridetAc)
                .dragAndDrop(f5000,dibtAm)
                .dragAndDrop(f5000,cridetAm).perform();

        Assert.assertTrue("perfect",perfect.isDisplayed());




    }
}