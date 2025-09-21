package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HelperBase {
    WebDriver wd;
    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }
    public void type(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        element.clear();
        element.sendKeys(text);
    }
    public void click(By locator){
        WebElement element = wd.findElement (locator);
        element.click ();

    }

    public boolean isElementPresent(By locator) {
        List<WebElement> list = wd.findElements (locator);
        return list.size () > 0;



    }
    public void pause(int time)  {
        try {
            Thread.sleep (time);
        } catch (InterruptedException e) {
            throw new RuntimeException (e);
        }
    }
}
