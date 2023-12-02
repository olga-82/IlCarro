import manager.AplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {

    Logger logger = LoggerFactory.getLogger(TestBase.class);
  static   AplicationManager app = new AplicationManager();

    boolean flagNeedLogout = false;
    boolean flagNeedOpenMainPage = false;


    @BeforeSuite
    public void setUp() {
        app.init();
    }



    @AfterSuite

    public void stop() {
       app.tearDown();

    }
  public void startLogger(Method method) {
    logger.info(method.getName() + "  is started ");
  }
  @AfterMethod
  public void stopLogger() {
    logger.info("================================================================================================================");
  }



}
