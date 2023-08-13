package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchResultsPage extends BasePage {
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "(//a[@class='product-item-link'])[1]")
    protected WebElement firstResult;
    @FindBy(xpath = "(//li[@class='item'])[7]")
    protected WebElement hoodies;


    public void selectFirstResult() {
        wait.until(ExpectedConditions.elementToBeClickable(firstResult));
        firstResult.click();
    }

    public void hoodiesAndSweatShirts()  {
        wait.until(ExpectedConditions.elementToBeClickable(hoodies)).click();
    }



}
