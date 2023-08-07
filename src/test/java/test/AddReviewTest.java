package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utility.ReadXLSdata;

public class AddReviewTest {

    HeaderPage headerPage;
    SearchResultsPage searchResultsPage;
    ItemPage itemPage;


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        headerPage = new HeaderPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        itemPage = new ItemPage(driver);


    }

    @AfterMethod
    public void teardown() {
        headerPage.quit();
    }


    @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "testdata")
    public void testAddReview(String url, String itemname, String nick, String summary, String content) {
        headerPage.visit(url);
        headerPage.searchFor(itemname);
        searchResultsPage.selectFirstResult();
        itemPage.openReviewTap();
        itemPage.setReviewAndSubmit(nick, summary, content);
    }


}
