package test;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderPage;
import utility.ReadXLSdata;
import utils.PageTitleUtils;


public class HeaderTest extends BaseTest {

    HeaderPage headerPage;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.get("https://magento.softwaretestingboard.com/");
        headerPage = new HeaderPage(driver);

    }

    @Test (dataProviderClass = ReadXLSdata.class, dataProvider = "testdata")
    public void verifyLinking(String url){
        headerPage.visit(url);
        headerPage.goToWhatsNew();
        headerPage.titleAssert(PageTitleUtils.WHATS_NEW);
        headerPage.goToWomen();
        headerPage.titleAssert(PageTitleUtils.WOMEN);
        headerPage.goToMen();
        headerPage.titleAssert(PageTitleUtils.MEN);
        headerPage.goToGear();
        headerPage.titleAssert(PageTitleUtils.GEAR);
        headerPage.goToTraining();
        headerPage.titleAssert(PageTitleUtils.TRAINING);
        headerPage.goToSale();
        headerPage.titleAssert(PageTitleUtils.SALE);
    }


}


