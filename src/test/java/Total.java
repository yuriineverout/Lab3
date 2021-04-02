import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Total {
    @Test
    public void total() {

        String expected = "10";

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/");

        try {
            new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='at-cv-lightbox-close']"))).click();


        } catch (Exception E) {

        }
        driver.findElement(By.xpath("//a[text()='Input Forms']")).click();
        driver.findElement(By.xpath("//ul[@id='treemenu']//a[text()='Simple Form Demo']")).click();
        driver.findElement(By.xpath("//div[@class='form-group']//*[@id='sum1']")).sendKeys(String.valueOf(5));
        driver.findElement(By.xpath("//div[@class='form-group']//*[@id='sum2']")).sendKeys(String.valueOf(5));
        driver.findElement(By.xpath("//*[text()='Get Total']")).click();
        String actualText = driver.findElement(By.xpath("//span[@id='displayvalue']")).getText();
        assertEquals(expected, actualText);
        driver.quit();
    }
}
