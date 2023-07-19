package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriverWait wait;
    protected WebDriver driver;



    public BasePage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver,this);
    }


}
