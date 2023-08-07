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
    @FindBy(id = "option-label-color-93-item-49")
    protected WebElement selectColorBlack;
    @FindBy(id = "qty")
    protected WebElement txtQuantity;
    @FindBy(xpath = "(//span[@class='price'])[1]")
    protected WebElement price;
    @FindBy(id = "tab-label-reviews-title")
    protected WebElement tabReview;
    @FindBy(id = "nickname_field")
    protected WebElement txtReviewNick;
    @FindBy(id = "summary_field")
    protected WebElement txtReviewSummary;
    @FindBy(id = "review_field")
    protected WebElement txtReviewContent;
    @FindBy(id = "Rating_1_label")
    protected WebElement txtReviewRating1;
    @FindBy(xpath = "//button[@class='action submit primary']")
    protected WebElement btnReviewSubmit;


    public void setupAndAddToCartWithAssertions(String size, String color, String qnt) {
        wait.until(ExpectedConditions.elementToBeClickable(selectSize)).click();
        Assert.assertEquals(selectedSize.getText(), size);
        selectColorBlue.click();
        Assert.assertEquals(selectedColor.getText(), color);
        txtQuantity.clear();
        txtQuantity.sendKeys(qnt);
        wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart)).click();
    }

    public void setupAndAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(selectSize)).click();
        selectColorBlack.click();
        wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart)).click();
    }


    public void openReviewTap() {
        wait.until(ExpectedConditions.elementToBeClickable(tabReview)).click();
    }

    public void setReviewAndSubmit(String nick, String summary, String content) {
        wait.until(ExpectedConditions.elementToBeClickable(txtReviewNick)).sendKeys(nick);
        txtReviewSummary.sendKeys(summary);
        txtReviewContent.sendKeys(content);
        wait.until(ExpectedConditions.visibilityOf(txtReviewRating1));
        txtReviewRating1.click();
        btnReviewSubmit.click();


    }


}
