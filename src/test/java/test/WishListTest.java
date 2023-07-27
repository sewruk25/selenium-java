package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.LogInPage;
import pages.MainPage;
import utility.ReadXLSdata;
import utils.PageTitleUtils;

public class WishListTest {

    protected MainPage mainPage;
    protected HeaderPage headerPage;
    protected LogInPage loginPage;



    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        mainPage = new MainPage(driver);
        headerPage = new HeaderPage(driver);
        loginPage = new LogInPage(driver);

    }

    @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "testdata")
    public void addToWishList(String url, String login, String password) throws InterruptedException {
        mainPage.visit(url);
        mainPage.pointAtFirstLatest();
        mainPage.addToWishList();
        loginPage.signIn(login, password);
        headerPage.titleAssert(PageTitleUtils.MY_WISH_LIST);

    }

}
