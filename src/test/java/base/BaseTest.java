package base;

import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;
   /* @BeforeTest
    public void setup(){

        System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://testing-ground.scraping.pro/login");
        homePage = new HomePage(driver);
    }*/
}
