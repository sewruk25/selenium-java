package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class BaseTest {




    protected WebDriver driver;


    @AfterMethod
    public void teardown(){
        if (driver != null){
            driver.close();
        }
    }
}

