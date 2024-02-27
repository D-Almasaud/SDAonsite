package HomeWorks.day05;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;

public class Task2 {

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void testAddToCartAndVerifyItemName() {
        // Navigate to the specified URL
        driver.get("https://www.saucedemo.com/v1/inventory.html");

        // Add the first item to the cart
        WebElement addToCartButton = driver.findElement(By.xpath("//button[text()='ADD TO CART']"));
        addToCartButton.click();

        // Open the cart
        WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
        cartIcon.click();

        // Get the item name from the cart
        WebElement itemNameInCart = driver.findElement(By.className("inventory_item_name"));
        String itemName = itemNameInCart.getText();

        // Assert that the item name is correct inside the cart
        assertEquals("Sauce Labs Backpack", itemName);
    }
}
