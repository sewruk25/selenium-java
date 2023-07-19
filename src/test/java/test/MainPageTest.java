package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class MainPageTest {

    MainPage mainPage;
    HeaderPage headerPage;
    SearchResultsPage searchResultsPage;
    ItemPage itemPage;
    CheckoutPage checkOutPage;
    @BeforeMethod
    public void setup(){
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

    @Test(testName = "czwarty")
    public void offlineShopingProcess() throws InterruptedException {
        headerPage.searchFor("Aero Daily Fitness Tee");
        searchResultsPage.selectFirstResult();
        itemPage.setupAndAddToCart();
        headerPage.showCart();
        headerPage.goToCheckout();
        checkOutPage.setShippingAddress("kacper@test.pl","kacper","test","Polna 2","Sopot",
                "40600","123123123");

    }


}
