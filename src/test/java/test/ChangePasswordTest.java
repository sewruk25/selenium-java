package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utility.ReadXLSdata;
import utils.PageTitleUtils;

public class ChangePasswordTest extends BaseTest {


    LogInPage logInPage;
    MyAccountPage myAccountPage;
    HeaderPage headerPage;
    MyAccountSideBarPage myAccountSideBarPage;
    EditAccountInformation editAccountInformation;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        logInPage = new LogInPage(driver);
        myAccountPage = new MyAccountPage(driver);
        headerPage = new HeaderPage(driver);
        myAccountSideBarPage = new MyAccountSideBarPage(driver);
        editAccountInformation = new EditAccountInformation(driver);

    }
//    @AfterMethod
//    public void teardown(){
//        headerPage.quit();
//    }




    @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "testdata")
    public void changePassword(String url, String login, String password, String listOption, String currentPassword,
                               String newPassword)  {
        logInPage.visit(url);
        logInPage.signIn(login, password);
        myAccountSideBarPage.klyk(String.valueOf(listOption));
        editAccountInformation.changePassword();
        editAccountInformation.setNewPassword(currentPassword, newPassword);
        headerPage.titleAssert(PageTitleUtils.CUSTOMER_LOGIN);
    }

}