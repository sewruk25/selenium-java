package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utility.ReadXLSdata;

public class AddReviewTest {
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
    @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "testdata")
    public void writeReview(String itemname, String nick, String summary, String content) throws InterruptedException {
        headerPage.searchFor(itemname);
        searchResultsPage.selectFirstResult();
        itemPage.openReviewTap();
        itemPage.setReviewAndSubmit(nick, summary, content);
    }


}
