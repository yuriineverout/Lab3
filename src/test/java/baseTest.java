import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class baseTest {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/");
        closeAdv();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod () {
        driver.quit();
    }

    public void closeAdv() {
        try {
            WebElement exit = new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='at-cv-lightbox-close']")));
            exit.click();
        } catch (NoSuchElementException e) {
            System.out.println("No any adv appears");
        }
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);

    }
    /*
    public void sleep(int sec) throws InterruptedException{
        Thread.sleep(sec);
    }
     */
    public void clickOnTheElement(WebElement el) throws InterruptedException{
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", el);
        Thread.sleep(1000);
    }


}