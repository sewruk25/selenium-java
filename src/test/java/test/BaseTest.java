package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import pages.HeaderPage;

public class BaseTest {

    protected WebDriver driver;


//    @AfterMethod
//    public void teardown(){
//        if (driver != null){
//            driver.close();
//        }
//    }
}

