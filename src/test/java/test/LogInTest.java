package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.LogInPage;
import pages.MyAccountPage;
import utility.ReadXLSdata;

public class LogInTest extends BaseTest {


    LogInPage logInPage;
    MyAccountPage myAccountPage;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        logInPage = new LogInPage(driver);
        myAccountPage = new MyAccountPage(driver);

    }


    @Test(dataProviderClass = ReadXLSdata.class,dataProvider = "testdata")
    public void signIn(String url, String login, String password) {
        logInPage.visit(url);
        logInPage.signIn(login, password);
        myAccountPage.verifyPageTitle();
    }


}
