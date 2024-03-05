package Day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.JScriptUtilities;
import utilities.TestBase;

public class C01JavaScriptExecutor extends TestBase {


    @Test
    public void test(){
        driver.get("https://linkedin.com");
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("alert(\"Hi SDA\");");
        //handle alert
        driver.switchTo().alert().accept();

         //scroll down by js
        //windowScrollBy(horizontal,vertical)
        js.executeScript("window.scrollBy(0,1500);");

        // "window.scrollBy(x,y);"
      WebElement button = driver.findElement(By.xpath("//*[@id=\"main-content\"]/section[8]/div/a"));
      int x = button.getLocation().getX();
       int y = button.getLocation().getY();

        js.executeScript("window.scrollTo("+x+","+y+");");

        // scrollIntoView method another element
        WebElement element = driver.findElement(By.xpath("//*[@id=\"main-content\"]/section[6]/div/section/div[2]/img"));

        js.executeScript("arguments[0].scrollIntoView();", element);
        // using methods from the jscript to use

        JScriptUtilities.clickElementByJS(driver,button);

    }
}
