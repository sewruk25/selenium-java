package pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
        itemPage = new ItemPage(driver);
    }
    ItemPage itemPage;


    @FindBy(id="search")
    protected WebElement inputSearch;
    @FindBy(xpath = "//button[@class='action search']")
    protected WebElement btnSearch;
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
    @FindBy(xpath = "//a[@class='action showcart']")
    protected WebElement lnkShowCart;
    @FindBy(xpath = "//span[@class='minicart-price']")
    protected WebElement oneItemPrice;
    @FindBy(xpath ="//span[@data-bind='html: cart().subtotal_excl_tax']" )
    protected WebElement sumPrice;
    @FindBy (id="top-cart-btn-checkout")
    protected WebElement btnToCheckoutCart;
    @FindBy (xpath = "//div[@class='loading-mask']")
    protected WebElement cartLoader;

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

    public void showCart() throws InterruptedException {
        wait.until(ExpectedConditions.invisibilityOf(cartLoader));
//        wait.until(ExpectedConditions.elementToBeClickable(lnkShowCart)).click();
        lnkShowCart.click();
    }

    public int getPrice() throws InterruptedException {
        Thread.sleep(5000);
        String cena = oneItemPrice.getText().substring(1, 3);
        return Integer.parseInt(cena);
    }

    public String multiplyPrice() throws InterruptedException {
        return Integer.toString(6*getPrice());
    }
    public String cutPrice(){
        return sumPrice.getText().substring(1,4);
    }
    public void verifyPriceInCart() throws InterruptedException {
        Assert.assertEquals(cutPrice(),multiplyPrice());
    }
    public void searchFor(String itemName){
        wait.until(ExpectedConditions.elementToBeClickable(inputSearch)).sendKeys(itemName);
        inputSearch.sendKeys(Keys.ENTER);
    }
    public void goToCheckout(){
        wait.until(ExpectedConditions.elementToBeClickable(btnToCheckoutCart)).click();
    }



//    Aero Daily Fitness Tee






}
