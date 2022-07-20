import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Setup {

    WebDriver driver;

    @BeforeClass
    public void startTest()
    {
         driver = new ChromeDriver();

    }
    @AfterClass
    public void finishTest() {

        driver.quit();
    }
}
