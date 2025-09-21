package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super (wd);
    }

    public void openLoginForm() {
     click(By.xpath("//a[contains(text(),'Log in')]"));
    }

    public void fillLoginForm(String email, String password) {
        type (By.id ("email"),email);
        type (By.id ("password"),password);
        //WebElement yallaButton = driver.findElement();
    }

    public boolean isYallaButtonDisplayed() {
        if (isElementPresent(By.xpath("//button[normalize-space()='Y’alla!']"))) {
            click(By.xpath("//button[normalize-space()='Y’alla!']"));
            return true;
        }
        return false;
    }



    public String getMessage () {
            WebDriverWait wait = new WebDriverWait (wd, Duration.ofSeconds (5));
            WebElement message = wait.until (
                    ExpectedConditions.visibilityOfElementLocated (By.cssSelector (".dialog-container>h2")));
            return message.getText ();

    }
        public void clickOkButton() {
        if (isElementPresent(By.xpath("//button[text()='Ok']")))
            click(By.xpath("//button[text()='Ok']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//*[text()=' Logout ']"));
    }


    public void logout() {
        click(By.xpath("//*[text()=' Logout ']"));
    }

}