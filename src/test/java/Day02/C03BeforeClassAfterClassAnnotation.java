/*package day02;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

public class C03BeforeClassAfterClassAnnotation {
    WebDriver driver;
    @BeforeClass
    public static void beforeClass(){
        driver = new ChromeDriver();
        System.out.println("Before class method is executed...");
    }

    @AfterClass
    public static void afterClass(){
        driver.quit();
        System.out.println("After Classs method is executed...");


        @Test
        public void test1(){
            driver= new ChromeDriver();
            driver.get("https://clarusway.com");
            System.out.println("test1 is executed ..." );

        }
        @Test
        public void test2(){
            driver= new ChromeDriver();
            driver.get("https://google.com");
            System.out.println("test2 is executed ..." );

        }
}}*/