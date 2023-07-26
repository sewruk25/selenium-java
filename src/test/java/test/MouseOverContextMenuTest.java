package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.MainPage;

public class MouseOverContextMenuTest extends BaseTest {

protected MainPage mainPage;
protected HeaderPage headerPage;


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");

        mainPage = new MainPage(driver);
        headerPage = new HeaderPage(driver);


    }
    @Test
    public void move() throws InterruptedException {

        headerPage.pointAtLnkWomen();
    }
}
