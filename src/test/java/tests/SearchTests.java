package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SearchTests extends TestBase{


    @Test
    public void SearchTests() {

  app.getSearch().fillSearhForm();
  app.getSearch().pause(2000);
  app.getSearch().isCarPresent();



    }


}
