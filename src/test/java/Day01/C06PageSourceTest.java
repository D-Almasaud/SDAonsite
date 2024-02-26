package Day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class C06PageSourceTest {

    public static void main(String[] args) {


        // Go to the Amazon URL: https://www.amazon.com/
        //  Verify that it writes "Performance Metrics" or " Gateway" from the Source code.

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.amazon.com/");
        String sourceCode = driver.getPageSource();
        System.out.println("sourceCode = " + sourceCode);

        System.out.println(sourceCode.contains("Preformance Metrics"));
        System.out.println(sourceCode.contains("Geteway"));


        driver.quit();
    }
}