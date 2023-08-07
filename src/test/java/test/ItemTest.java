package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.ItemPage;
import utility.ReadXLSdata;

public class ItemTest {

    HeaderPage headerPage;
    ItemPage itemPage;


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        headerPage = new HeaderPage(driver);
        itemPage = new ItemPage(driver);

    }

    @AfterMethod
    public void teardown() {
        headerPage.quit();
    }

    @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "testdata")
    public void testPriceCount(String url, String size, String color, String qnt) {
        itemPage.visit(url);
        itemPage.setupAndAddToCartWithAssertions(size, color, qnt);
        headerPage.showCart();
        headerPage.verifyPriceInCart();
    }


}
