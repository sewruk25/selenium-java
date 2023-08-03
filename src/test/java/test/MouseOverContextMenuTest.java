package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.MainPage;
import utility.ReadXLSdata;

public class MouseOverContextMenuTest extends BaseTest {

protected MainPage mainPage;
protected HeaderPage headerPage;


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        mainPage = new MainPage(driver);
        headerPage = new HeaderPage(driver);

    }
    @AfterMethod
    public void teardown(){
        headerPage.quit();
    }

    @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "testdata")
    public void hoverToJackets(String url)  {
        headerPage.visit(url);
        headerPage.moveToJacketUsingHover();
    }
}
