package tests;

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
    public void successLogin(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser ().fillLoginForm
                ("karina29@gmail.com", "karinA29!");
        app.getHelperUser ().isYallaButtonDisplayed();

        Assert.assertEquals (app.getHelperUser ().getMessage(),"Logged in success" );
      

    }
    @Test
    public void successLoginModel(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser ().fillLoginForm
                ("karina29@gmail.com", "karinA29!");
        app.getHelperUser ().isYallaButtonDisplayed();
        Assert.assertEquals (app.getHelperUser ().getMessage(),"Logged in success" );




    }
    @AfterMethod
    public void postCondition(){
        app.getHelperUser ().clickOkButton ();
    }



}
