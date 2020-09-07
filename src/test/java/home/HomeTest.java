package home;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


public class HomeTest {

    static ExtentTest test;
    static ExtentReports report;
    public HomePage homePage;
    WebDriver driver;
    @BeforeTest
    public void setup(){

        System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        homePage = new HomePage(driver);
    }
   @Test(priority = 0)
    public void testLoginNotCorrect(){

       report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        test = report.startTest("ExtentDemo");
       driver.get("http://testing-ground.scraping.pro/login");

       homePage.setUsername("admin");
        homePage.setPassword("1345");
        LoginPage loginPage = homePage.clickLoginButton();

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

    @Test(priority = 1)
    public void testLoginCorrect(){
        report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        test = report.startTest("ExtentDemo");
        driver.get("http://testing-ground.scraping.pro/login");

        homePage.setUsername("admin");
        homePage.setPassword("12345");
        LoginPage loginPage = homePage.clickLoginButton();

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
