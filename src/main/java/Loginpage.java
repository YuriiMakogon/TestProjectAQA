import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

    private WebDriver driver;
    @FindBy(xpath = "//input[@name='username']")
    public WebElement loginInput;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement enter;


    public Loginpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


}


