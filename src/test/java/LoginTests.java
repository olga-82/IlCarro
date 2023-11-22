import models.User;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }

    }

//    @Test
//    public void loginPositive() {
//        app.getUser().openLoginForm();
//        app.getUser().fillLoginForm("nefr42@gmail.com", "Rita12345$");
//        app.getUser().submitLogin();
//        if (app.getUser().isElementPresent(By.xpath("//h1[.='Logged in']"))) ;
//        {
//            app.getUser().buttonOk();
//        }
//        if (app.getUser().isLogged()) {
//            app.getUser().logout();
//        }
//    }
    @Test
    public void loginPositiveUser() {
        User user = new User()
                .withEmail("nefr42@gmail.com")
                .withPassword("Rita12345$");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user.getEmail(), user.getPassword());
        app.getUser().submitLogin();
        app.getUser().isElementPresent(By.xpath("//h1[.='Logged in']")) ;

    }
    @Test
    public void loginPositiveUser2() {
        User user = new User()
                .withEmail("nefr42@gmail.com")
                .withPassword("Rita12345$");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        app.getUser().isElementPresent(By.xpath("//h1[.='Logged in']")) ;

    }
   @AfterMethod
    public void postcondition(){

            app.getUser().buttonOk();

    }

}
