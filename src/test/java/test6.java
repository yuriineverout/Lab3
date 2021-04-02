import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class test6 {

    @Test
    public void сheckThatTextAppears() throws InterruptedException {

        String expected = "Day selected :- Friday";

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/");

        try {
            new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='at-cv-lightbox-close']"))).click();


        } catch (Exception E) {
        }
        /*step1*/ driver.findElement(By.xpath("//a[text()='Input Forms']")).click();

        /*step2*/ JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//ul[@id='treemenu']//a[text()='Select Dropdown List']")));

        Thread.sleep(1000);

        /*step3*/ driver.findElement(By.xpath("//*[@id='select-demo']//option[7]")).click();
        /*reading*/ String actualText = driver.findElement(By.xpath("//*[@id='select-demo']/following-sibling::p")).getAttribute("textContent");
        assertEquals(expected, actualText);
        driver.quit();


    }

}
