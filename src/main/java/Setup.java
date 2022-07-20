import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.*;
import java.util.Date;

public class Setup {

    WebDriver driver;
    Date date = new Date();
    public void screenshot(){
        String screenshotName = date.toString().replace(" ","-").replace(":","-");
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot,new File("/Users/mac/IdeaProjects/TestProjectAQA/src/Screenshot" + screenshotName +".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void UserJson() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Reader reader = null;
        try {
            reader = new FileReader("/Users/mac/IdeaProjects/TestProjectAQA/src/main/resources/user.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        JSONObject jsonObject = (JSONObject) parser.parse(reader);
    }


    @BeforeClass
    public void startTest()
    {
         driver = new ChromeDriver();
         driver.get("https://www.pecodesoftware.com/qa-portal/registerlogin/registerlogin.php");
    }
    @AfterClass
    public void finishTest() {

        driver.quit();
    }
}
