import manager.TestNgListeners;
import models.User;
import models.UserLombok;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
@Listeners(TestNgListeners.class)

public class LoginTests extends TestBase {
    @BeforeMethod
    public void precondition(Method method){
        if (flagNeedLogout) {
            app.getUser().logout();
            flagNeedLogout = false;
            logger.info("flagNeedLogout = " + flagNeedLogout);
            logger.info("method info: " + method.getName());
        } else if (flagNeedOpenMainPage) {
            app.getUser().buttonLogo();
            flagNeedOpenMainPage = false;
            logger.info("flagNeedOpenMainPage = " + flagNeedOpenMainPage);
        }


    }
    @Test
    public void loginPositiveUser() {
        User user = new User()
                .withEmail("nefr42@gmail.com")
                .withPassword("Rita12345$");
       app.getUser().login(user);
        flagNeedLogout=true;
        logger.info("flagNeedLogout = " + flagNeedLogout);
        logger.info(" loginPositiveUser starts with credentials "
                + user.getEmail() + " " + user. getPassword());
        app.getUser().isElementPresent(By.xpath("//h1[.='Logged in']")) ;


    }
    @Test
    public void loginPositiveUser2() {
        User user = new User()
                .withEmail("nefr42@gmail.com")
                .withPassword("Rita12345$");
        app.getUser().login(user);
        flagNeedLogout=true;
        app.getUser().isElementPresent(By.xpath("//h1[.='Logged in']")) ;

    }
    @Test
    public void loginPositiveUserLombok() {
        UserLombok user =  UserLombok.builder()
                .email("nefr42@gmail.com")
                .password("Rita12345$")
                 .build();
      app.getUser().loginLombok(user);
      flagNeedLogout=true;
        app.getUser().isElementPresent(By.xpath("//h1[.='Logged in']")) ;

    }
    @Test
    public void loginNegativeWrongEmail() {
        UserLombok user =  UserLombok.builder()
                .email("nefr4@gmail.com")
                .password("Rita12345$")
                .build();
        app.getUser().loginLombok(user);
        flagNeedOpenMainPage=true;
        app.getUser().isElementPresent(By.xpath("//h1[.='Login failed']")) ;


    }
    @Test
    public void loginNegativeWrongPassword() {
        UserLombok user =  UserLombok.builder()
                .email("nefr42@gmail.com")
                .password(" ")
                .build();
        app.getUser().loginLombok(user);
        flagNeedOpenMainPage=true;

        app.getUser().isElementPresent(By.xpath("//h1[.='Login failed']")) ;

    }


    @AfterMethod
    public void postcondition(){

            app.getUser().buttonOk();

    }

}
