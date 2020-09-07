package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
   // private By alert = By.className("error");
    private By alert = By.id("case_login");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public String getAlertText(){
        return driver.findElement(alert).getText();

    }
}
