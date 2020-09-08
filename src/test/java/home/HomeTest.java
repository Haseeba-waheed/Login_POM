package home;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.io.FileInputStream;
import java.util.Properties;


public class HomeTest {

    static ExtentTest test;
    static ExtentReports report;
    public HomePage homePage;
    WebDriver driver;
    LoginPage loginPage;
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
       // driver.get("http://testing-ground.scraping.pro/login");
        homePage = new HomePage(driver);
    }
   @Test
    public void testLoginNotCorrect() throws Exception{

       driver.get("http://testing-ground.scraping.pro/login");

       report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        test = report.startTest("ExtentDemo");

        FileInputStream fis = new FileInputStream(".\\resources\\properties_file");
        Properties prop = new Properties();

        prop.load(fis);
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        homePage.setUsername(username);
        homePage.setPassword(password);

        loginPage = homePage.clickLoginButton();

        if(loginPage.getAlertText().equals("ACCESS DENIED!\\n\" +\n" +
                "                \"<< GO BACK"))
        {
            test.log(LogStatus.PASS, "Navigated to the specified URL");
        }
        else
        {
            test.log(LogStatus.FAIL, "Test Failed");
        }
       // assertEquals(loginPage.getAlertText(),"ACCESS DENIED!\n" +
             //   "<< GO BACK","...");

       // assertEquals(loginPage.getAlertText(),"WELCOME :)\n" +
                //"<< GO BACK","incorrect");
    }

    @Test
    public void testLoginCorrect() throws Exception{
        driver.get("http://testing-ground.scraping.pro/login");

        report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        test = report.startTest("ExtentDemo");

        FileInputStream fis = new FileInputStream(".\\resources\\properties_file");
        Properties prop = new Properties();

        prop.load(fis);
        String username1 = prop.getProperty("username1");
        String password1 = prop.getProperty("password1");
        homePage.setUsername(username1);
        homePage.setPassword(password1);
        loginPage = homePage.clickLoginButton();

        if(loginPage.getAlertText().equals("WELCOME :)\\n\" +\n" +
                "        //\"<< GO BACK"))
        {
            test.log(LogStatus.PASS, "Navigated to the specified URL");
        }
        else
        {
            test.log(LogStatus.FAIL, "Test Failed");
        }
        // assertEquals(loginPage.getAlertText(),"ACCESS DENIED!\n" +
        //"<< GO BACK","...");

        // assertEquals(loginPage.getAlertText(),"WELCOME :)\n" +
        //"<< GO BACK","incorrect");
    }

}
