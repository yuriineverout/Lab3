import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class checkFollowingMessages extends baseTest {



    private By inputFormMenuItem = By.xpath("//a[text()='Input Forms']");
    private By radioBtn = By.xpath("//ul[@id='treemenu']//a[text()='Radio Buttons Demo']");
    private By raadioButtonMale = By.xpath("//h4[text()='Sex : ']/following-sibling::label[text()='Male']");
    private By radioButtonValue1550 = By.xpath("//div[@id='easycont']//*//div[@class='col-md-6 text-left']//div[@class='panel panel-default'][2]//*//input[@value='15 - 50']");
    private By buttonGetValues = By.xpath("//button[text()='Get values']");
    private By findText = By.xpath("//p[@class='groupradiobutton']");

    @Test
    public void checkFollowingMessages() throws InterruptedException {

        String expected = "Sex : Male Age group: 15 - 50";

        find(inputFormMenuItem).click();
        WebElement myRadiobutton = find(radioBtn);
        clickOnTheElement(myRadiobutton);
        // JavascriptExecutor executor = (JavascriptExecutor)driver;
        //executor.executeScript("arguments[0].click();", find(radioBtn));

        Thread.sleep(1000);
        find(raadioButtonMale).click();

        find(radioButtonValue1550).click();
        find(buttonGetValues).click();
        String actualText = find(findText).getAttribute("textContent");
        assertEquals(actualText , expected);

        driver.quit();
    }
}