package test;

import com.fasterxml.jackson.databind.node.ArrayNode;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.ItemPage;
import utility.ReadXLSdata;

public class ItemTest extends BaseTest{

    HeaderPage headerPage;
    ItemPage itemPage;


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/juno-jacket.html#");


        headerPage = new HeaderPage(driver);
        itemPage = new ItemPage(driver);


    }

    @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "testdata")
    public void addToCartAndVerifyPrice(String url,String size, String color, String qnt) throws InterruptedException {
        itemPage.visit(url);
        itemPage.setupAndAddToCartWithAssertions(size, color, qnt);
        headerPage.showCart();
        headerPage.verifyPriceInCart();
    }


}
