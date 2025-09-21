package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super (wd);
    }

    public void openLoginForm() {
        click (By.xpath ("//a[text()=' Log in ']"));
    }

    public void fillLoginForm(String email, String password) {
        type (By.id ("email"),email);
        type (By.id ("password"),password);



        //WebElement yallaButton = driver.findElement();

    }


    public void isYallaButtonDisplayed() {
        isElementPresent (By.xpath("//button[text()=\"Y’alla!\"]"));
        click (By.xpath ("//button[text()=\"Y’alla!\"]"));
    }

    public boolean isLogged() {
        return isElementPresent (By.xpath (("//button[text()='Sign Out']")));

    }

    public String getMessage() {
       // pause (2000);
       return wd.findElement (By.cssSelector (".dialog-container>h2")).getText ();
    }
    public void clickOkButton(){
        click(By.xpath("//button[text()='Ok']"));
    }
}