package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//img[@class='product-image-photo'])[1]")
    protected WebElement firstLatest;


    public void pointAtFirstLatest(){
        Actions action = new Actions(driver);
        action.moveToElement(firstLatest).build().perform();
    }

}
