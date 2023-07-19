package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountPage extends BasePage{


    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='base']")
    protected WebElement pageTitle;


    public void verifyPageTitle(){
        wait.until(ExpectedConditions.elementToBeClickable(pageTitle));
        Assert.assertEquals(pageTitle.getText(),"My Account");
    }



}
