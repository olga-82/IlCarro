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
        type(By.id("dates"),"12/8/2023 - 12/22/2023");
        click(By.xpath("//button[@type='submit']"));
    }
public boolean isCarPresent() {
return isElementPresent(By.xpath("//span[text()='Chevrolet Comaro']"));

}

    }







//input[@id='city']
//input[@id='dates']

//button[@type='submit']

//12/8/2023 - 12/22/2023