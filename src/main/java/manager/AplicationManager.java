package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AplicationManager {

   Logger logger = LoggerFactory.getLogger(AplicationManager.class);
  //  WebDriver wd;
  EventFiringWebDriver wd;
    HelperUser user;
    HelperCar car;

    public HelperCar getCar() {
        return car;
    }

    public HelperUser getUser() {

        return user;
    }

    @BeforeSuite
    public void init() {
        wd = new EventFiringWebDriver(new ChromeDriver());
        user = new HelperUser(wd);
        car = new HelperCar(wd);
        wd.register(new WdListener());

        wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.web.app/search)");
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @AfterSuite

    public void tearDown() {
        wd.quit();

    }


}