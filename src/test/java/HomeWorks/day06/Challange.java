package HomeWorks.day06;

import com.github.javafaker.Faker;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Challange
{

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        // Launch Browser
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();}

    @Test
    public void testContactCreation() {
        // Navigate to the contact list page
        // Assuming the user is already logged in
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");

        driver.findElement(By.id("email")).sendKeys("a@sda.com");
        driver.findElement(By.id("password")).sendKeys("1234567");
        WebElement button0 = driver.findElement(By.id("submit"));
        button0.click();


        Assert.assertEquals("User is directed to create contact page successfully","Contact List App", driver.getTitle());

        // Click on Add a New contact button
        WebElement button = driver.findElement(By.id("add-contact"));
        button.click();

        // Fill the fields using Java.Faker
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();

        String address1 = faker.address().streetAddress();
        String address2 = faker.address().secondaryAddress();
        String city = faker.address().city();
        String state = faker.address().state();
        String postalCode = faker.address().zipCode();
        String country = faker.address().country();





        // Fill form inputs
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("birthdate")).sendKeys("2000-12-12");
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("phone")).sendKeys("12345678");
        driver.findElement(By.id("street1")).sendKeys(address1);
        driver.findElement(By.id("street2")).sendKeys(address2);
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("stateProvince")).sendKeys(state);
        driver.findElement(By.id("postalCode")).sendKeys(postalCode);
        driver.findElement(By.id("country")).sendKeys(country);


        // Click on submit button
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();

        // Additional: Verify if contact has been created successfully
      //  Assert.assertEquals("User is directed to create contact page successfully","Contact List App", driver.getTitle());

    }

    @AfterClass
    public static void tearDown() {
        // Close the browser
       // driver.quit();
    }
}

