import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class test7 {
    @Test
    public void сheckThatTextAppears() throws InterruptedException {

        String expected = "rgb(255, 0, 0)";

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/");

        try {
            new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='at-cv-lightbox-close']"))).click();


        } catch (Exception E) {
        }
        /*step1*/
         driver.findElement(By.xpath("//a[text()='Input Forms']")).click();
        /*step2*/
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//ul[@id='treemenu']//a[text()='Ajax Form Submit']")));
        JavascriptExecutor executor2 = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@id='submit-control']//input")));


        driver.findElement(By.xpath("//div[@id='submit-control']//input")).click();
        String actualText = driver.findElement(By.xpath("//input[@id='title']")).getAttribute("borderColor");
        assertEquals(expected, actualText);
        driver.quit();


        Thread.sleep(1000);



    }
}
