package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    // Открытие формы логина с ожиданием
    public void openLoginForm() {
        click(By.xpath("//a[text()=' Log in ']"));
        waitForLoginForm();  // ждём появления формы
    }

    // Ждём появления поля email
    public void waitForLoginForm() {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
    }

    // Заполнение формы логина по email и password
    public void fillLoginForm(String email, String password) {
        waitForLoginForm(); // убеждаемся, что форма открыта
        type(By.id("email"), email);
        type(By.id("password"), password);
    }

    // Заполнение формы логина через модель User
    public void fillLoginForm(User user) {
        fillLoginForm(user.getEmail(), user.getPassword());
    }

    public void submit() {
        click(By.xpath("//*[@type='submit']"));
    }

    public String getMessage() {
        try {
            WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(7));
            WebElement messageElement = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.message"))
            );
            return messageElement.getText().trim();
        } catch (TimeoutException e) {
            System.out.println("Message popup did not appear within 7 seconds");
            return null;
        }
    }

    public void clickOkButton() {
        try {
            WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(7));
            WebElement okButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.cssSelector("button.positive-button"))
            );
            okButton.click();
            System.out.println("OK button clicked successfully");
        } catch (TimeoutException e) {
            System.out.println("OK button did not appear within 7 seconds");
        }
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//*[text()=' Logout ']"));
    }

    public void logout() {
        click(By.xpath("//*[text()=' Logout ']"));
    }

    // ******************************** Registration ********************************

    public void openRegistrationForm() {
        click(By.xpath("//*[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getFirstName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void checkPolicy() {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').click()");
    }

    public void checkPolicyXY() {
        if (!wd.findElement(By.id("terms-of-use")).isSelected()) {
            WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']"));
            Rectangle rect = label.getRect();
            int w = rect.getWidth();
            int xOffSet = -w / 2;
            Actions actions = new Actions(wd);
            actions.moveToElement(label, xOffSet, 0).click().release().perform();
        }
    }

    public String getErrorText() {
        return wd.findElement(By.cssSelector("div.error")).getText();
    }

    public void login(User user) {
        openLoginForm();
        fillLoginForm(user);
        submit();
        clickOkButton();
    }

    // HelperUser.java
    public String submitAndGetMessage() {
        submit();           // нажимаем кнопку
        return getMessage(); // возвращаем текст сообщения
    }

}
