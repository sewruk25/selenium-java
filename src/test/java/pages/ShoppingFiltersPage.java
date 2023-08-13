package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingFiltersPage extends BasePage {


    public ShoppingFiltersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//div[@class='filter-options-title'])[2]")
    protected WebElement price;
    @FindBy(xpath = "(//div[@class='filter-options-title'])[3]")
    protected WebElement color;
    @FindBy(xpath = "(//li[@class='item'])[6]")
    protected WebElement setPrice;
    @FindBy(xpath = "(//div[@option-label='Blue'])[2]")
    protected WebElement setColor;


    public void setPirce(){
        wait.until(ExpectedConditions.elementToBeClickable(price)).click();
        wait.until(ExpectedConditions.elementToBeClickable(setPrice)).click();
    }
    public void setColor(){
        wait.until(ExpectedConditions.elementToBeClickable(color)).click();
        wait.until(ExpectedConditions.elementToBeClickable(setColor)).click();
    }




}
