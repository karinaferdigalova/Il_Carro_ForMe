package tests;

import manager.ApplicationManager;

public class TestBase {
    static ApplicationManager app = new ApplicationManager ();

    public void setApp(){
        app.init ();
    }

    public void tearDown(){
        app.stop ();
    }
}
