package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultsPage extends BasePage{
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }


//    (//a[@class='product-item-link'])[1]

    @FindBy(xpath = "(//a[@class='product-item-link'])[1]")
    protected WebElement firstResult;


    public void selectFirstResult(){
        wait.until(ExpectedConditions.elementToBeClickable(firstResult));
        firstResult.click();
    }

}
