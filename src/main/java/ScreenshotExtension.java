import io.qameta.allure.Allure;
import lombok.SneakyThrows;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Field;

public class ScreenshotExtension implements TestWatcher {

    @SneakyThrows
    @Override
    public void testFailed(ExtensionContext context,Throwable throwable){
        WebDriver driver = getDriver(context);

        Allure.getLifecycle().addAttachment("Screenshot","image/png","png",((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
    }

    private WebDriver getDriver(ExtensionContext context) {
        Object instance = context.getRequiredTestInstance();

        try {

            Field  field = instance.getClass().getDeclaredField("driver");
            field.setAccessible(true);
            return ((ThreadLocal<WebDriver>)field.get(instance)).get();
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }


}
