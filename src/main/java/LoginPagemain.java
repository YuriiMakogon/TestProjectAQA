import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Date;


public class LoginPagemain extends Setup {

    Date date = new Date();

    @Test
    public void verifyElementSelection(){
        Loginpage loginpage = new Loginpage(driver);
        driver.get("https://www.pecodesoftware.com/qa-portal/registerlogin/registerlogin.php");
        Assert.assertEquals(true,loginpage.loginInput.isDisplayed());
        Assert.assertEquals(true,loginpage.password.isDisplayed());
        Assert.assertEquals(true,loginpage.enter.isDisplayed());
    }

    @Test
    public void testClick(){
        Loginpage loginpage = new Loginpage(driver);
        driver.get("https://www.pecodesoftware.com/qa-portal/registerlogin/registerlogin.php");
        try {
            loginpage.enter.click();
            String screenshotName = date.toString().replace(" ","-").replace(":","-");
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot,new File("/Users/mac/IdeaProjects/TestProjectAQA/src/Screenshot" + screenshotName +".png"));
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void testPass(){
        Loginpage loginpage = new Loginpage(driver);
        driver.get("https://www.pecodesoftware.com/qa-portal/registerlogin/registerlogin.php");

        JSONParser parser = new JSONParser();
        try(Reader reader = new FileReader("/Users/mac/IdeaProjects/TestProjectAQA/src/main/resources/user.json"))  {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            loginpage.loginInput.clear();
            loginpage.password.sendKeys(jsonObject.get("UserPass").toString());

            loginpage.enter.click();
            String screenshotName = date.toString().replace(" ","-").replace(":","-");

            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot,new File("/Users/mac/IdeaProjects/TestProjectAQA/src/Screenshot" + screenshotName +".png"));
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void testLog(){
        Loginpage loginpage = new Loginpage(driver);
        driver.get("https://www.pecodesoftware.com/qa-portal/registerlogin/registerlogin.php");


        JSONParser parser = new JSONParser();
        try(Reader reader = new FileReader("/Users/mac/IdeaProjects/TestProjectAQA/src/main/resources/user.json"))  {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            loginpage.loginInput.sendKeys(jsonObject.get("UserName").toString());
            loginpage.password.clear();
            loginpage.enter.click();
            String screenshotName = date.toString().replace(" ","-").replace(":","-");

            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot,new File("/Users/mac/IdeaProjects/TestProjectAQA/src/Screenshot" + screenshotName +".png"));
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }



    @Test()
    public void testAll() {
        Loginpage loginpage = new Loginpage(driver);
        driver.get("https://www.pecodesoftware.com/qa-portal/registerlogin/registerlogin.php");


        JSONParser parser = new JSONParser();
        try(Reader reader = new FileReader("/Users/mac/IdeaProjects/TestProjectAQA/src/main/resources/user.json"))  {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            loginpage.loginInput.sendKeys(jsonObject.get("UserName").toString());
            loginpage.password.sendKeys(jsonObject.get("UserPass").toString());
            loginpage.enter.click();

            String screenshotName = date.toString().replace(" ","-").replace(":","-");

            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot,new File("/Users/mac/IdeaProjects/TestProjectAQA/src/Screenshot" + screenshotName +".png"));
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


}
