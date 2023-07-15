package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.LogInPage;
import pages.MyAccountPage;

public class LogInTest extends BaseTest {


    LogInPage logInPage;
    MyAccountPage myAccountPage;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\skejt\\OneDrive\\Pulpit\\drajwer\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
        options.addArguments("start-maximized");

        driver.get("https://magento.softwaretestingboard.com/customer/account/login/referer/");

        logInPage = new LogInPage(driver);
        myAccountPage = new MyAccountPage(driver);


    }

    @Test
    public void signIn() {
        logInPage.signIn("","");
        myAccountPage.verifyPageTitle();
    }


}
