package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void openLoginForm() {
        wd.findElement(By.xpath(" //a[.=' Log in ']")).click();
    }
     public void openRegestrationForm() {
        wd.findElement(By.xpath("//*[.=' Sign up ']")).click();
    }

    public void fillLoginForm(String email, String password) {
        type(By.xpath(" //input[@id='email']"), email);
        type(By.xpath(" //input[@id='password']"), password);
    }


    public void submitLogin() {
      wd.findElement (By.xpath(" //button[@type='submit']")).submit();
    }
    public  void buttonOk() {
        click(By.xpath(" //button[@class='positive-button ng-star-inserted']"));
    }

    public void fillLoginForm(User user) {
        type(By.xpath(" //input[@id='email']"), user.getEmail());
        type(By.xpath(" //input[@id='password']"), user.getPassword());
    }
    public void fillRegistrationForm(User user) {
        type(By.xpath(" //input[@id='name']"), user.getName());
        type(By.xpath(" //input[@id='lastName']"), user.getLastName());
        type(By.xpath(" //input[@id='email']"), user.getEmail());
        type(By.xpath(" //input[@id='password']"), user.getPassword());
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').click();");
       // click(By.cssSelector("label[for='terms-of-use']"));

    }
    public void login(User user) {
        openLoginForm();
        fillLoginForm(user);
        submitLogin();
        buttonOk();

    }
    public boolean isLoggedSuccess()

    {
        return isElementPresent(By.xpath("//h2[contains(text(), 'success')]"));
    }
    public boolean isLoggedError() {
        return isElementPresent(By.xpath("//h1[.='Registration failed']"));
    }

}
