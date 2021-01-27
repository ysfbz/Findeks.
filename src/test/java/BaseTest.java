import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import helper.ElementHelper;
import helper.StoreHelper;
import model.ElementInfo;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    @BeforeScenario
    public void hazirlik() {
        System.out.println("Senaryo Hazirlaniyor");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        action = new Actions(driver);
        driver.manage().window().maximize();
    }

    static WebDriver driver;
    static Actions action;

    public static void getUrl(){
        driver.get("https://www.teb.com.tr");
    }

    public WebElement findElement(String key) {
        ElementInfo elementInfo = StoreHelper.INSTANCE.findElementInfoByKey(key);
        By infoParam = ElementHelper.getElementInfoToBy(elementInfo);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        WebElement webElement = webDriverWait
                .until(ExpectedConditions.presenceOfElementLocated(infoParam));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})",
                webElement);
        return webElement;
    }

    public void clickElement(String by){
        findElement(by).click();
    }

    public void openNewTab(){
        for(String childWindow: driver.getWindowHandles())
        {
            driver.switchTo().window(childWindow);
        }
    }

    @AfterScenario
    public void bitir() {
        driver.quit();
        System.out.println("Senaryo Tamamlandi.");
    }
}