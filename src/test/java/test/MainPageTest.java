package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import utility.ReadXLSdata;

public class MainPageTest {

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
        driver.get("https://magento.softwaretestingboard.com/");

        mainPage = new MainPage(driver);
        headerPage = new HeaderPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        itemPage = new ItemPage(driver);
        checkOutPage = new CheckoutPage(driver);

    }
//    @Test
//    public void trial(){
//        mainPage.pointAtFirstLatest();
//    }

    @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "testdata")
    public void offlineShopingProcess(String itemName, String email, String name, String lastName, String address,
                                      String city, String zipCode, String phone) throws InterruptedException {
        headerPage.searchFor(itemName);
        searchResultsPage.selectFirstResult();
        itemPage.setupAndAddToCart();
        headerPage.showCart();
        headerPage.goToCheckout();
        checkOutPage.setShippingAddress(email, name, lastName, address, city, zipCode, phone);

    }


}
