import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class checkbox {
    @Test
    public void checkbox() throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/");

        try {
            new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='at-cv-lightbox-close']"))).click();


        } catch (Exception E) {
        }
        driver.findElement(By.xpath("//a[text()='Input Forms']")).click();

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//ul[@id='treemenu']//a[text()='Checkbox Demo']")));

        Thread.sleep(1000);

        driver.findElement(By.xpath("//label[text()='Option 1']")).click();
        driver.findElement(By.xpath("//label[text()='Option 3']")).click();
//        executor.executeScript("arguments[0].click();", option1);
//        executor.executeScript("arguments[0].click();", option3);

        boolean option1s = driver.findElement(By.xpath("//label[text()='Option 1']//input")).isSelected();
        boolean option3s = driver.findElement(By.xpath("//label[text()='Option 3']//input")).isSelected();
        Assert.assertTrue(option1s);
        Assert.assertTrue(option3s);

        driver.quit();
    }
}