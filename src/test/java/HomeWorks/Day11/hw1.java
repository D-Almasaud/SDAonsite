package HomeWorks.Day11;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

public class hw1 extends TestBase {

    // Day:11/Hw:1
    // Go to URL: http://facebook.com
    // getCookies,
    // addCookie,
    // deleteCookieNamed,
    // deleteAllCookies.

    @Test
    public void test() {
        // Go to URL: http://facebook.com
        driver.get("http://facebook.com");

        // getCookies
        System.out.println("Cookies before any operation:");
        driver.manage().getCookies().forEach(System.out::println);
        System.out.println("------------------------------");

        // addCookie
        Cookie newCookie = new Cookie("myCookie", "cookieValue");
        driver.manage().addCookie(newCookie);

        // getCookies after adding
        System.out.println("Cookies after adding a new cookie:");
        driver.manage().getCookies().forEach(System.out::println);
        System.out.println("------------------------------");

        // deleteCookieNamed
        driver.manage().deleteCookieNamed("myCookie");

        // getCookies after deleting a specific cookie
        System.out.println("Cookies after deleting a specific cookie:");
        driver.manage().getCookies().forEach(System.out::println);
        System.out.println("------------------------------");

        // deleteAllCookies
        driver.manage().deleteAllCookies();

        // getCookies after deleting all cookies
        System.out.println("Cookies after deleting all cookies:");
        driver.manage().getCookies().forEach(System.out::println);
        System.out.println("End here...");
    }
}
