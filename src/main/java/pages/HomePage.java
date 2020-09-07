package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private By usernameField = By.id("usr");
    private By passwordField = By.id("pwd");
    private By loginButton = By.xpath("//*[@id=\"case_login\"]/form/input[3]");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public void setUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }
    public void setPassword(String password){
        driver.findElement((passwordField)).sendKeys(password);
    }


    public LoginPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

}
