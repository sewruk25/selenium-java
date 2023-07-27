package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import utility.ReadXLSdata;

public class MainPageTest extends BaseTest {

    MainPage mainPage;
    HeaderPage headerPage;
    SearchResultsPage searchResultsPage;
    ItemPage itemPage;
    CheckoutPage checkOutPage;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        mainPage = new MainPage(driver);
        headerPage = new HeaderPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        itemPage = new ItemPage(driver);
        checkOutPage = new CheckoutPage(driver);

    }


    @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "testdata")
    public void offlineShopingProcess(String itemName, String email, String name, String lastName, String address,
                                      String city, String state, String zipCode, String phone) throws InterruptedException {
        headerPage.visit("https://magento.softwaretestingboard.com/");
        headerPage.searchFor(itemName);
        searchResultsPage.selectFirstResult();
        itemPage.setupAndAddToCart();
        headerPage.showCart();
        headerPage.goToCheckout();
        checkOutPage.setShippingAddress(email, name, lastName, address, city, state, zipCode, phone);
    }



}
