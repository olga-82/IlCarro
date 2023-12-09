package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public  class HelperSearch extends HelperBase{
    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public  void typeSity(String address) {
        type(By.id("city"), address);
        click(By.cssSelector("div.pac-item"));

    }
    public  void fillSearhForm() {
        typeSity("Tel Aviv");
        type(By.id("dates"),"12/10/2023 - 12/22/2023");
        click(By.xpath("//button[@type='submit']"));
    }

    public  void fillSearhForm2() {
        typeSity("Tel Aviv");
        click(By.id("dates"));
        isFormSearchDatePresent();
        click(By.xpath("//td[@aria-label ='December 14, 2023']"));
        click(By.xpath("//td[@aria-label ='December 24, 2023']"));
        click(By.xpath("//button[@type='submit']"));
    }
    public  void fillSearhForm3() {
        typeSity("Tel Aviv");
        click(By.id("dates"));
        isFormSearchDatePresent();
        click(By.xpath("//*[@aria-label='Next month']"));
        click(By.xpath("//td[@aria-label ='January 5, 2024']"));
        click(By.xpath("//td[@aria-label ='January 15, 2024']"));
        click(By.xpath("//button[@type='submit']"));
    }
    public  void fillSearhForm4() {
        typeSity("Tel Aviv");
        click(By.id("dates"));
        isFormSearchDatePresent();
        click(By.xpath("//*[@aria-label='Next month']"));
        click(By.xpath("//*[@aria-label='Next month']"));
        click(By.xpath("//button[@aria-label='Previous month']"));
        click(By.xpath("//button[@aria-label='Previous month']"));
        click(By.xpath("//td[@aria-label ='January 7, 2024']"));
        click(By.xpath("//td[@aria-label ='January 17, 2024']"));
        click(By.xpath("//button[@type='submit']"));
    }
public boolean isCarPresent() {
return isElementPresent(By.xpath("//span[text()='Chevrolet Comaro']"));

}
public boolean isFormSearchDatePresent() {
    return isElementPresent(By.xpath("//*[@id='sat-datepicker-0']"));


}


    }







//input[@id='city']
//input[@id='dates']

//button[@type='submit']

//12/8/2023 - 12/22/2023