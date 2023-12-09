package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SearchTests extends TestBase{
@AfterMethod(alwaysRun = true)
public void postMethod(){

    app.getUser().buttonLogo();
}

    @Test(groups = {"positive"})
    public void SearchTests() {

  app.getSearch().fillSearhForm();
  app.getSearch().pause(2000);
 Assert.assertTrue( app.getSearch().isCarPresent());



    }
    @Test(groups = {"positive"})
    public void SearchTests2(){

        app.getSearch().fillSearhForm2();
        app.getSearch().pause(2000);
       Assert.assertTrue( app.getSearch().isCarPresent());
    }

    @Test(groups = {"positive"})
    public void SearchTests3(){
        app.getSearch().fillSearhForm3();
        app.getSearch().pause(2000);
        Assert.assertTrue( app.getSearch().isCarPresent());
    }
    @Test(groups = {"positive"})
    public void SearchTests4(){

        app.getSearch().fillSearhForm4();
        app.getSearch().pause(2000);
        Assert.assertTrue( app.getSearch().isCarPresent());
    }



}
//*[@id='sat-datepicker-0']
//*[@aria-label='Next month']
//button[@aria-label='Previous month']
//td[@aria-label ='January 5, 2024']
//td[@aria-label ='January 15, 2024']
//td[@aria-label ='December 14, 2023']
//td[@aria-label ='December 24, 2023']