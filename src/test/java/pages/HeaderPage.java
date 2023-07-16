package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.PageTitleUtils;


public class HeaderPage extends BasePage{

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='base']")
    protected WebElement titlePage;
    @FindBy(id="ui-id-3")
    protected WebElement lnkWhatsNew;
    @FindBy(id="ui-id-4")
    protected WebElement lnkWomen;
    @FindBy(id="ui-id-5")
    protected WebElement lnkMen;
    @FindBy(id="ui-id-6")
    protected WebElement lnkGear;
    @FindBy(id="ui-id-7")
    protected WebElement lnkTraining;
    @FindBy(id="ui-id-8")
    protected WebElement lnkSale;

    public void verifylnkWhatsNew(){
        wait.until(ExpectedConditions.elementToBeClickable(lnkWhatsNew)).click();
        Assert.assertEquals(titlePage.getText(), PageTitleUtils.WHATS_NEW);
    }
    public void verifylnkWomen(){
        wait.until(ExpectedConditions.elementToBeClickable(lnkWomen)).click();
        Assert.assertEquals(titlePage.getText(), PageTitleUtils.WOMEN);
    }
    public void verifylnkMen(){
        wait.until(ExpectedConditions.elementToBeClickable(lnkMen)).click();
        Assert.assertEquals(titlePage.getText(), PageTitleUtils.MEN);
    }
    public void verifylnkGear(){
        wait.until(ExpectedConditions.elementToBeClickable(lnkGear)).click();
        Assert.assertEquals(titlePage.getText(), PageTitleUtils.GEAR);
    }
    public void verifylnkTraining(){
        wait.until(ExpectedConditions.elementToBeClickable(lnkTraining)).click();
        Assert.assertEquals(titlePage.getText(), PageTitleUtils.TRAINING);
    }
    public void verifylnkSale(){
        wait.until(ExpectedConditions.elementToBeClickable(lnkSale)).click();
        Assert.assertEquals(titlePage.getText(), PageTitleUtils.SALE);
    }







}
