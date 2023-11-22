import manager.AplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
  static   AplicationManager app = new AplicationManager();


    @BeforeSuite
    public void setUp() {
        app.init();
    }



    @AfterSuite

    public void stop() {
       app.tearDown();

    }


}
