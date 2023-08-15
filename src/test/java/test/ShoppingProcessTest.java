package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utility.ReadXLSdata;
import utils.PageTitleUtils;

public class ShoppingProcessTest {

    HeaderPage headerPage;
    SearchResultsPage searchResultsPage;
    ItemPage itemPage;
    CheckoutPage checkOutPage;
    LogInPage logInPage;
    ShoppingFiltersPage shoppingFiltersPage;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        headerPage = new HeaderPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        itemPage = new ItemPage(driver);
        checkOutPage = new CheckoutPage(driver);
        logInPage = new LogInPage(driver);
        shoppingFiltersPage = new ShoppingFiltersPage(driver);

    }

//    @AfterMethod
//    public void teardown() {
//        headerPage.quit();
//    }


    @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "testdata")
    public void testOfflineShoppingProcess(String url, String itemName, String email, String name, String lastName, String address,
                                      String city, String state, String zipCode, String phone) throws InterruptedException {
        headerPage.visit(url);
        headerPage.searchFor(itemName);
        searchResultsPage.selectFirstResult();
        itemPage.setupAndAddToCartBlackL();
        headerPage.showCart();
        headerPage.goToCheckout();
        checkOutPage.setShippingAddress(email, name, lastName, address, city, state, zipCode, phone);
        headerPage.titleAssert(PageTitleUtils.PURCHASE_CONFIRMATION);
    }
    @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "testdata")
    public void testOnlineShoppingProcess(String url, String login, String password) throws InterruptedException {
        logInPage.visit(url);
        logInPage.signIn(login, password);
        headerPage.goToSale();
        searchResultsPage.hoodiesAndSweatShirts();
        shoppingFiltersPage.setPirce();
        searchResultsPage.selectFirstResult();
        itemPage.setupAndAddToCartBlueXL();
        headerPage.showCart();
        headerPage.goToCheckout();
        checkOutPage.acceptShippingMethodAndPlaceOrder();



    }




}
