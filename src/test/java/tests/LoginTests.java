package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @Test
    public void successLogin(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser ().fillLoginForm
                ("karina29@gmail.com", "karinA29!");
        app.getHelperUser ().isYallaButtonDisplayed();
        Assert.assertEquals (app.getHelperUser ().getMessage(),"Logged in success" );
        app.getHelperUser ().clickOkButton ();



    }



}
