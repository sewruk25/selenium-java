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
        headerPage.verifylnkWhatsNew();
        headerPage.verifylnkWomen();
        headerPage.verifylnkMen();
        headerPage.verifylnkGear();
        headerPage.verifylnkTraining();
        headerPage.verifylnkSale();
    }


}


