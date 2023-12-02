import manager.TestNgListeners;
import models.User;
import models.UserLombok;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
@Listeners(TestNgListeners.class)
public class RegistrationTests extends TestBase {


    @AfterMethod(alwaysRun = true)
    public void postCondAfterMethod(Method method) {
        if (flagNeedLogout) {
           app.getUser().buttonOk();
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
    public void registrationPositive() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User()
                .withName("Sally")
                .withLastName("Rotten")
                .withEmail("nefr"+i+"@gmail.com")
                .withPassword("Rita12300$");
        app.getUser().openRegestrationForm();
        app.getUser().fillRegistrationFormWith(user);
        app.getUser().submitLogin();
        logger.info("registrationPositive starts with credentials "
                + user.getEmail() + " " + user. getPassword());
        flagNeedLogout = true;
        logger.info("flagNeedLogout = " + flagNeedLogout);
        Assert.assertTrue(app.getUser().isLoggedSuccess());
       // app.getUser().buttonOk();


    }
    @Test
    public void registrationNegativeWrongPassword() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User()
                .withName("Sally")
                .withLastName("Rotten")
                .withEmail("nefr"+i+"@gmail.com")
                .withPassword("Rita12300фыб");
        app.getUser().openRegestrationForm();
        app.getUser().fillRegistrationFormWith(user);
        app.getUser().submitLogin();
        flagNeedOpenMainPage=true;
        logger.info("flagNeedOpenMainPage = " + flagNeedOpenMainPage);
        Assert.assertTrue(app.getUser().isLoggedErrorWrongPassword());
       // app.getUser().buttonLogo();

      //  Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&amp;*!]
    }
    @Test
    public void registrationNegativeWrongEmail() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User()
                .withName("Sally")
                .withLastName("Rotten")
                .withEmail("nefr"+i+"gmail.com")
                .withPassword("Rita12300$");
        app.getUser().openRegestrationForm();
        app.getUser().fillRegistrationFormWith(user);
        app.getUser().submitLogin();
        flagNeedOpenMainPage=true;
        logger.info("flagNeedOpenMainPage = " + flagNeedOpenMainPage);
        Assert.assertTrue(app.getUser().isLoggedErrorWrongEmail());
       // app.getUser().buttonLogo();




    }
    @Test
    public void registrationNegativeEmptyPassword() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        UserLombok userLombok =  UserLombok.builder()
                .name("Sally")
                .lastName("Rotten")
                .email("nefr"+i+"@gmail.com")
                .password("")
                .build();
        app.getUser().openRegestrationForm();
        app.getUser().fillRegistrationFormLombok(userLombok);
        app.getUser().submitLogin();
        flagNeedOpenMainPage=true;
        logger.info("flagNeedOpenMainPage = " + flagNeedOpenMainPage);
        Assert.assertTrue(app.getUser().isLoggedErrorWrongPassword());
       // app.getUser().buttonLogo();

    }



    @AfterMethod
    public void postcondition(){

      //  app.getUser().buttonOk();

    }

}
