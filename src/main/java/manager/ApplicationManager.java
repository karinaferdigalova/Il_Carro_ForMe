package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class ApplicationManager {
    WebDriver wd;

@BeforeSuite
    public void init(){
        wd = new ChromeDriver ();
        wd.navigate().to("https://ilcarro.web.app/");


    }
@AfterSuite
    public void stop(){
        wd.quit ();

    }

}
