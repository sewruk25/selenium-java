package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ItemPage extends BasePage {


    public ItemPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@itemprop='name']")
    protected WebElement name;
    @FindBy(id = "product-addtocart-button")
    protected WebElement btnAddToCart;
    @FindBy(xpath = "(//span[@class='swatch-attribute-selected-option'])[1]")
    protected WebElement selectedSize;
    @FindBy(xpath = "(//span[@class='swatch-attribute-selected-option'])[2]")
    protected WebElement selectedColor;
    @FindBy(id = "option-label-size-143-item-169")
    protected WebElement selectSize;
    @FindBy(id = "option-label-color-93-item-50")
    protected WebElement selectColorBlue;
    @FindBy(id="option-label-color-93-item-49")
    protected WebElement selectColorBlack;
    @FindBy(id = "qty")
    protected WebElement inputQuantity;
    @FindBy(xpath = "(//span[@class='price'])[1]")
    protected WebElement price;


    public void setupAndAddToCartWithAssertions(String qnt) {
        wait.until(ExpectedConditions.elementToBeClickable(selectSize)).click();
        Assert.assertEquals(selectedSize.getText(), "L");
        selectColorBlue.click();
        Assert.assertEquals(selectedColor.getText(), "Blue");
        inputQuantity.clear();
        inputQuantity.sendKeys(qnt);
        wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart)).click();
    }
    public void setupAndAddToCart(){
        wait.until(ExpectedConditions.elementToBeClickable(selectSize)).click();
        selectColorBlack.click();
        wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart)).click();
    }



}
