package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    public void successLogin() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("karina29@gmail.com", "karinA29!");
        String message = app.getHelperUser().submitAndGetMessage();
        Assert.assertEquals(message, "Logged in success");
    }

    @Test
    public void successLogin1() {
        User user = new User().setEmail("karina29@gmail.com").setPassword("karinA29!");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        String message = app.getHelperUser().submitAndGetMessage();
        Assert.assertEquals(message, "Logged in success");
    }

    @Test
    public void successLoginModel() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("karina29@gmail.com", "karinA29!");
        String message = app.getHelperUser().submitAndGetMessage();
        Assert.assertEquals(message, "Logged in success");
    }

    @Test
    public void loginWrongEmail() {
        User user = new User().setEmail("karina29gmail.com").setPassword("karinA29!");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "It'snot look like email");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }

    @Test
    public void loginWrongPassword() {
        User user = new User().setEmail("karina29@gmail.com").setPassword("karA29!");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        String message = app.getHelperUser().submitAndGetMessage();
        Assert.assertEquals(message, "\"Login or Password incorrect\"");

    }

    @Test
    public void loginEmptyPassword() {
        User user = new User().setEmail("karina29@gmail.com").setPassword("");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Password is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }

    @Test
    public void loginEmptyEmail() {
        User user = new User().setEmail("").setPassword("karinA29!");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Email is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }

    @Test
    public void loginUnregisteredUser() {
        User user = new User().setEmail("arina29@gmail.com").setPassword("karinA29!");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        String message = app.getHelperUser().submitAndGetMessage();
        Assert.assertEquals(message, "\"Login or Password incorrect\"");
    }

    @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOkButton();
    }
}
