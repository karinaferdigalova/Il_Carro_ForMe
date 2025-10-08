package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }


    public void click(By locator) {
        wd.findElement (locator).click ();
    }

    public void type(By locator, String text) {
        WebElement element = wd.findElement (locator);
        element.click ();
        element.clear ();
        clearNew (element);
        if (text != null) {
            element.sendKeys (text);
        }
    }

    public void clearNew(WebElement element) {
        element.sendKeys (" ");
        element.sendKeys (Keys.BACK_SPACE);
    }


    public void pause(int time) {
        try {
            Thread.sleep (time);
        } catch (InterruptedException e) {
            throw new RuntimeException (e);
        }

    }
    public boolean isElementPresent(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return wd.findElements(locator).size() > 0;
        } catch (TimeoutException e) {
            return false;
        }
    }



    public boolean isYallaButtonNotActive() {
        try {
            WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
            return wait.until(driver -> {
                WebElement element = driver.findElement(By.cssSelector("button[type='submit']"));
                return !element.isEnabled();
            });
        } catch (TimeoutException e) {
            return false;
        }
    }
}
