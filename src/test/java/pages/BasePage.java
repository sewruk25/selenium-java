package pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class BasePage {

    protected WebDriverWait wait;
    public WebDriver driver;


    public BasePage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public void visit(String url) {
        driver.get(url);
    }

    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }


}
