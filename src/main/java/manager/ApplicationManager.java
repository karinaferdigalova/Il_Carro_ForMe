package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    HelperUser helperUser;

@BeforeSuite
    public void init(){
        wd = new ChromeDriver ();
    wd.manage ().window ().maximize ();
    wd.manage ().timeouts ().implicitlyWait (5, TimeUnit.SECONDS);
    wd.navigate().to("https://ilcarro.web.app/");;
    helperUser = new HelperUser (wd);


    }

    public HelperUser getHelperUser() {
        return helperUser;
    }

    @AfterSuite
    public void stop(){
        wd.quit ();

    }

}
