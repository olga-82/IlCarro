import manager.TestNgListeners;
import models.Car;
import models.User;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestNgListeners.class)
public class AddNewCar extends TestBase{

    @BeforeMethod
    public void Preconditions() {
        if (app.getUser().isLogged()==false)

            app.getUser().login(new User()
                    .withEmail("nefr42@gmail.com")
                    .withPassword("Rita12345$"));
             app.getUser().buttonOk();

    }
    @Test
    public void addNewCarPositive() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
     Car car = Car.builder()
             .location("Tel Aviv")
             .make("KIA")
             .model("Sportage")
             .year("2009")
             .fuel("Petrol")
             .seats("5")
             .carClass("B")
             .carRegNumber("100-200-"+i)
             .price("150")
             .about("")
             .build();
     app.getUser().pause(5000);
     app.getCar().openCarForm();
     app.getCar().fillCarForm(car);
     app.getUser().submitLogin();



    }
}
