package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utility.ReadXLSdata;
import utils.PageTitleUtils;

public class AddAdditionalAddressTest {


    LogInPage logInPage;
    HeaderPage headerPage;
    MyAccountSideBarPage myAccountSideBarPage;
    AdressBookPage adressBookPage;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        logInPage = new LogInPage(driver);
        headerPage = new HeaderPage(driver);
        myAccountSideBarPage = new MyAccountSideBarPage(driver);
        adressBookPage = new AdressBookPage(driver);

    }

//    @AfterMethod
//    public void teardown() {
//        headerPage.quit();
//    }


    @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "testdata")
    public void testAddAddress(String url, String login, String password, String listOption, String phoneNumber,
                                     String street, String city, String zipCode, String country, String region) throws InterruptedException {
        logInPage.visit(url);
        logInPage.signIn(login, password);
        myAccountSideBarPage.selectFromSider(String.valueOf(listOption));
        adressBookPage.setNewAddress();
        adressBookPage.setNewAddress(phoneNumber, street, city, zipCode, country, region);
        headerPage.titleAssert(PageTitleUtils.ADDRESS_BOOK);

    }

}