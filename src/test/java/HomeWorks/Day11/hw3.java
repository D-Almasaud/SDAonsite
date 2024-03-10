package HomeWorks.Day11;



import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.io.File; //
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

public class hw3 extends TestBase {
    @Test
    public void test() throws InterruptedException {

        //Go to URL: https://opensource-demo.orangehrmlive.com/
        driver.get("https://opensource-demo.orangehrmlive.com/");

        DownloadCSVfile(driver);
        VerifyIsDownloaded();

    }

    public void DownloadCSVfile(WebDriver driver) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        By username = By.name("username");
        By password = By.name("password");
        By submit = By.xpath("//*[@type='submit']");
        By pim = By.linkText("PIM");
        By config = By.xpath("//*[@class='oxd-topbar-body-nav-tab --parent']");
        By dataImport = By.xpath("//*[text()='Data Import']");
        By download = By.linkText("Download");

        //Login page valid credentials.
        WebElement usernameElement = driver.findElement(username);
        usernameElement.sendKeys("Admin");

        WebElement passwordElement = driver.findElement(password);
        passwordElement.sendKeys("admin123");

        WebElement submitButton = driver.findElement(submit);
        submitButton.click();

        //Click PIM on the left side bar
        WebElement pimButton = driver.findElement(pim);
        wait.until(ExpectedConditions.elementToBeClickable(pimButton));
        pimButton.click();

        //Click Configuration and select Data Import
        WebElement configButton = driver.findElement(config);
        wait.until(ExpectedConditions.visibilityOf(configButton));
        configButton.click();

        WebElement dataImportButton = driver.findElement(dataImport);
        dataImportButton.click();

        //Download sample CSV file.
        WebElement downloadButton = driver.findElement(download);
        downloadButton.click();
        Thread.sleep(1000);

    }
    public void VerifyIsDownloaded(){
        // Get the path to the Downloads directory
        String downloadsPath = System.getProperty("user.home") + "/Downloads";

        // Specify the file name
        String fileName = "importData.csv";

        // Create a File object for the downloaded file
        File downloadedFile = new File(downloadsPath, fileName);

        // Wait for the file to be downloaded (you can add a wait condition here if needed)

        // Verify if the file is downloaded successfully
        Assert.assertTrue("File is not downloaded successfully", downloadedFile.exists() && downloadedFile.length()>0);}
}