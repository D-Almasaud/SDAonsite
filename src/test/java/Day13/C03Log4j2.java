package Day13;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03Log4j2 extends TestBase {


    Logger logger = Logger.getLogger(C03Log4j2.class);
    @Test
    public void test() {

        // Go to URL: https://healthunify.com/bmicalculator/
        driver.get("https://healthunify.com/bmicalculator/");

        // Entering weight
        driver.findElement(By.name("wg")).sendKeys("50");
        logger.info("Entered weight: 50");

        // Selecting kilograms
        driver.findElement(By.name("opt1")).click();
        driver.findElement(By.xpath("//*[@id=\"post-556\"]/div/div/form/p[1]/select/option[2]")).click();
        logger.info("Selected kilograms");

        // Selecting height in feet
        driver.findElement(By.name("opt2")).click();
        driver.findElement(By.xpath("//*[@id=\"post-556\"]/div/div/form/p[2]/select/option[5]")).click();
        logger.info("Selected height in feet");

        // Selecting height in inches
        driver.findElement(By.name("opt3")).click();
        driver.findElement(By.xpath("//*[@id=\"post-556\"]/div/div/form/p[2]/select[2]/option[5]")).click();
        logger.info("Selected height in inches");

        // Clicking on calculate
        driver.findElement(By.name("cc")).click();
        logger.info("Clicked on Calculate button");

        // Getting SIUnit value
        String siUnit = driver.findElement(By.name("si")).getAttribute("value");
        logger.info("SIUnit: " + siUnit);

        // Getting USUnit value
        String usUnit = driver.findElement(By.name("us")).getAttribute("value");
        logger.info("USUnit: " + usUnit);

        // Getting UKUnit value
        String ukUnit = driver.findElement(By.name("uk")).getAttribute("value");
        logger.info("UKUnit: " + ukUnit);

        // Getting overall description
        String description = driver.findElement(By.name("desc")).getAttribute("value");
        logger.info("Overall Description: " + description);
    }
}
