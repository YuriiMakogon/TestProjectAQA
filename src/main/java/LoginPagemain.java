import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

@DisplayName("Base Test")
@ExtendWith(ScreenshotExtension.class)
class LoginPagemain extends Setup {


    @Test
    public void verifyElementSelection(){
        Loginpage loginpage = new Loginpage(driver);
        Assert.assertEquals(true,loginpage.loginInput.isDisplayed());
        Assert.assertEquals(true,loginpage.password.isDisplayed());
        Assert.assertEquals(true,loginpage.enter.isDisplayed());
    }

    @Test
    public void testClick(){
        Loginpage loginpage = new Loginpage(driver);
            loginpage.enter.click();

        Assert.fail();
        screenshot();
    }


    @Test
    public void testPass() throws FileNotFoundException {
        Loginpage loginpage = new Loginpage(driver);



        JSONParser parser = new JSONParser();
        try(Reader reader = new FileReader("/Users/mac/IdeaProjects/TestProjectAQA/src/main/resources/user.json"))  {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            loginpage.loginInput.clear();
            loginpage.password.sendKeys(jsonObject.get("UserPass").toString());

            loginpage.enter.click();
            screenshot();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void testLog(){
        Loginpage loginpage = new Loginpage(driver);

        JSONParser parser = new JSONParser();
        try(Reader reader = new FileReader("/Users/mac/IdeaProjects/TestProjectAQA/src/main/resources/user.json"))  {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            loginpage.loginInput.sendKeys(jsonObject.get("UserName").toString());
            loginpage.password.clear();
            loginpage.enter.click();
            screenshot();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test()
    public void testAll() {
        Loginpage loginpage = new Loginpage(driver);


        JSONParser parser = new JSONParser();
        try(Reader reader = new FileReader("/Users/mac/IdeaProjects/TestProjectAQA/src/main/resources/user.json"))  {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            loginpage.loginInput.sendKeys(jsonObject.get("UserName").toString());
            loginpage.password.sendKeys(jsonObject.get("UserPass").toString());
            loginpage.enter.click();
            screenshot();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


}
