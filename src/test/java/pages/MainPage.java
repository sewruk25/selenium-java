package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//img[@class='product-image-photo'])[1]")
    protected WebElement firstLatest;
    @FindBy(xpath = "(//a[@title='Add to Wish List'])[1]")
    protected WebElement btnAddWishList;


    public void pointAtFirstLatest() {
        Actions action = new Actions(driver);
        action.moveToElement(firstLatest).build().perform();
    }

    public void addToWishList() throws InterruptedException {
        Thread.sleep(300);
        wait.until(ExpectedConditions.visibilityOf(btnAddWishList)).click();
    }

}
