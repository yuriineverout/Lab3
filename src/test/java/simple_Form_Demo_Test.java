import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class simple_Form_Demo_Test extends baseTest {


    private By inputFormMenuItem = By.xpath("//a[text()='Input Forms']");
    private By simpleFormDemoItem = By.xpath("//ul[@id='treemenu']//a[text()='Simple Form Demo']");
    private By enterMessageInputField = By.xpath("//*[@id='user-message']");
    private By showMessageButton = By.xpath("//form[@id='get-input']//button");
    private By displayedText = By.xpath("//span[@id='display']");


    @Test
    public void simple_Form() {

        String expectedText = "Hello my name is Yurii";

        find(inputFormMenuItem).click();
        find(simpleFormDemoItem).click();
        find(enterMessageInputField).sendKeys(expectedText);
        find(showMessageButton).click();

        String actualText = find(displayedText).getText();
        Assert.assertEquals(actualText, expectedText);

    }
}
