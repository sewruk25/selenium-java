package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.LogInPage;
import utility.ReadXLSdata;
import utils.PageTitleUtils;

public class LogInTest {


    LogInPage logInPage;
    HeaderPage headerPage;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        logInPage = new LogInPage(driver);
        headerPage = new HeaderPage(driver);

    }

    @AfterMethod
    public void teardown() {
        headerPage.quit();
    }


    @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "testdata")
    public void testLogIn(String url, String login, String password) {
        logInPage.visit(url);
        logInPage.signIn(login, password);
        headerPage.titleAssert(PageTitleUtils.MY_ACCOUNT);
    }


}
