import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {
//    @BeforeMethod
//    public void precondition(){
//        if (app.getUser().isLogged()) {
//            app.getUser().logout();
//        }
//
//    }

    @Test
    public void registrationPositive() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User()
                .withName("Sally")
                .withLastName("Rotten")
                .withEmail("nefr"+i+"@gmail.com")
                .withPassword("Rita12300$");
        app.getUser().openRegestrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLoggedSuccess());


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
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLoggedError());


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
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLoggedError());




    }
    @Test
    public void registrationNegativeEmptyPassword() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User()
                .withName("Sally")
                .withLastName("Rotten")
                .withEmail("nefr"+i+"@gmail.com")
                .withPassword("");
        app.getUser().openRegestrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLoggedError());

    }



    @AfterMethod
    public void postcondition(){

        app.getUser().buttonOk();

    }

}
